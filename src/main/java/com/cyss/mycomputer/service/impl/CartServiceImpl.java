package com.cyss.mycomputer.service.impl;

import com.cyss.mycomputer.entity.Cart;
import com.cyss.mycomputer.mapper.CartMapper;
import com.cyss.mycomputer.mapper.ProductMapper;
import com.cyss.mycomputer.service.ICartService;
import com.cyss.mycomputer.service.ex.*;
import com.cyss.mycomputer.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.impl
 * @Author: cyss
 * @CreatTime: 2022-11-09 10:06
 * @Description:
 */
@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        if(cartMapper.findByUidAndPid(uid, pid) == null){
            Cart cart = new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setPrice(productMapper.findById(pid).getPrice());
            cart.setNum(amount);
            cart.setModifiedTime(new Date());
            cart.setModifiedUser(username);
            cart.setCreatedUser(username);
            cart.setCreatedTime(new Date());
            Integer rows = cartMapper.insert(cart);
            if(rows != 1){
                throw new InsertException("插入数据时产生未知的异常");
            }
        }else {
            Cart result = cartMapper.findByUidAndPid(uid, pid);
            Integer rows = cartMapper.updateNumByCid(result.getCid(), (result.getNum() + amount), username, new Date());
            if(rows != 1){
                throw new UpdateException("更新数据时产生未知的异常");
            }
        }
    }

    @Override
    public List<CartVO> getCartVOByUid(Integer uid) {
        return cartMapper.findByUid(uid);
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart cart = cartMapper.findByCid(cid);
        if(cart == null){
            throw new CartNotFoundException("购物车商品数据不存在");
        }
        if(!cart.getUid().equals(uid)){
            throw new AccessDeniedException("购物车数据非法访问");
        }
        Integer num = cart.getNum() + 1;
        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if(rows != 1){
            throw new UpdateException("购物车商品数据更新异常");
        }
        return num;
    }

    @Override
    public Integer reductionNum(Integer cid, Integer uid, String username) {
        Cart cart = cartMapper.findByCid(cid);
        if(cart == null){
            throw new CartNotFoundException("购物车商品数据不存在");
        }
        if(!cart.getUid().equals(uid)){
            throw new AccessDeniedException("购物车数据非法访问");
        }
        Integer num = cart.getNum() - 1;
        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if(rows != 1){
            throw new UpdateException("购物车商品数据更新异常");
        }
        return num;
    }

    @Override
    public List<CartVO> getCartVOByCid(Integer[] cids, Integer uid) {
        List<CartVO> cartVOByCid = cartMapper.findCartVOByCid(cids);
        Iterator<CartVO> iterator = cartVOByCid.iterator();
        while(iterator.hasNext()){
            CartVO vo = iterator.next();
            if(!vo.getUid().equals(uid)){
                cartVOByCid.remove(vo);
            }
        }
        return cartVOByCid;
    }

    @Override
    public Integer deleteCartVOByCid(Integer cid, Integer uid) {
        Cart cart = cartMapper.findByCid(cid);
        if(cart == null){
            throw new DeleteException("删除的数据不存在");
        }
        if(!cart.getUid().equals(uid)){
            throw new AccessDeniedException("操作数据权限错误");
        }
        Integer rows = cartMapper.deleteByCid(cid);
        if(!rows.equals(1)){
            throw new DeleteException("删除数据发生异常");
        }
        return rows;
    }
}
