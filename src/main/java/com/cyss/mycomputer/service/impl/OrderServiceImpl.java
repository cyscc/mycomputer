package com.cyss.mycomputer.service.impl;

import com.cyss.mycomputer.entity.Address;
import com.cyss.mycomputer.entity.Order;
import com.cyss.mycomputer.entity.OrderItem;
import com.cyss.mycomputer.mapper.OrderMapper;
import com.cyss.mycomputer.service.IAddressService;
import com.cyss.mycomputer.service.ICartService;
import com.cyss.mycomputer.service.IOrderService;
import com.cyss.mycomputer.service.ex.InsertException;
import com.cyss.mycomputer.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.impl
 * @Author: cyss
 * @CreatTime: 2022-11-12 15:35
 * @Description:
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICartService cartService;

    @Override
    public Order create(Integer aid, Integer uid, String username, Integer[] cids) {
        List<CartVO> cartVOList = cartService.getCartVOByCid(cids, uid);
        long totalPrice = 0L;
        for(CartVO cartVO : cartVOList){
            totalPrice += cartVO.getNum() * cartVO.getRealPrice();
        }
        Address address = addressService.getByAid(aid, uid);

        Order order = new Order();
        order.setUid(uid);
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        order.setTotalPrice(totalPrice);
        order.setStatus(0);
        order.setOrderTime(new Date());
        order.setPayTime(null);
        order.setCreatedUser(username);
        order.setCreatedTime(new Date());
        order.setModifiedUser(username);
        order.setModifiedTime(new Date());

        Integer rows = orderMapper.insertOrder(order);
        if(rows != 1){
            throw new InsertException("订单数据插入异常");
        }

        for(CartVO cartVO : cartVOList){
            OrderItem orderItem = new OrderItem();
            orderItem.setOid(order.getOid());
            orderItem.setPid(cartVO.getPid());
            orderItem.setTitle(cartVO.getTitle());
            orderItem.setImage(cartVO.getImage());
            orderItem.setPrice(cartVO.getRealPrice());
            orderItem.setNum(cartVO.getNum());
            orderItem.setCreatedUser(username);
            orderItem.setCreatedTime(new Date());
            orderItem.setModifiedUser(username);
            orderItem.setModifiedTime(new Date());
            Integer row = orderMapper.insertOrderItem(orderItem);
            if(row != 1){
                throw new InsertException("订单数据项插入异常");
            }
        }
        return order;
    }

    @Override
    public List<Order> selectOrder(Integer uid) {
        return orderMapper.selectOrderByUid(uid);
    }

    @Override
    public List<OrderItem> selectOrderItem(Integer oid) {
        return orderMapper.selectOrderByOid(oid);
    }
}
