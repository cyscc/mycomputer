package com.cyss.mycomputer.service;

import com.cyss.mycomputer.entity.Order;
import com.cyss.mycomputer.entity.OrderItem;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-11-12 15:17
 * @Description:
 */
public interface IOrderService {

    Order create(Integer aid, Integer uid, String username, Integer[] cids);

    List<Order> selectOrder(Integer uid);

    List<OrderItem> selectOrderItem(Integer oid);
}
