package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Order;
import com.cyss.mycomputer.entity.OrderItem;
import com.cyss.mycomputer.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.mapper
 * @Author: cyss
 * @CreatTime: 2022-09-10 17:19
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertOrder(){
        Order order = new Order();
        order.setUid(1);
        order.setRecvName("cyss");
        order.setRecvPhone("13577777777");
        System.out.println(orderMapper.insertOrder(order));
    }

    @Test
    public void insertOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(10000026);
        orderItem.setTitle("联想（Lenovo）YOGA710 14英寸（i7-7500U 8G 256GSSD 2G独显）金色");
        System.out.println(orderMapper.insertOrderItem(orderItem));
    }

    @Test
    public void selectOrderByUid(){
        List<Order> orders = orderMapper.selectOrderByUid(1);
        orders.forEach(System.out::println);
    }

    @Test
    public void selectOrderByOid(){
        orderMapper.selectOrderByOid(2).forEach(System.out::println);
    }

}
