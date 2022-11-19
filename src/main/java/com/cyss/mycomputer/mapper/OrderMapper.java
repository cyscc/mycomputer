package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Order;
import com.cyss.mycomputer.entity.OrderItem;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.mapper
 * @Author: cyss
 * @CreatTime: 2022-11-12 15:02
 * @Description:
 */
public interface OrderMapper {

    Integer insertOrder(Order order);

    Integer insertOrderItem(OrderItem orderItem);

    List<Order> selectOrderByUid(Integer uid);

    List<OrderItem> selectOrderByOid(Integer oid);
}
