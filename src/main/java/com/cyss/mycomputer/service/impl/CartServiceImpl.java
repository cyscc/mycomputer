package com.cyss.mycomputer.service.impl;

import com.cyss.mycomputer.entity.Cart;
import com.cyss.mycomputer.mapper.CartMapper;
import com.cyss.mycomputer.mapper.ProductMapper;
import com.cyss.mycomputer.service.ICartService;
import com.cyss.mycomputer.service.ex.InsertException;
import com.cyss.mycomputer.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}
