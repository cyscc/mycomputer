package com.cyss.mycomputer.controller;

import com.cyss.mycomputer.entity.Order;
import com.cyss.mycomputer.entity.OrderItem;
import com.cyss.mycomputer.service.IOrderService;
import com.cyss.mycomputer.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller
 * @Author: cyss
 * @CreatTime: 2022-11-12 16:27
 * @Description:
 */
@RestController
@RequestMapping("orders")
public class OrderController extends BaseController{
    @Autowired
    private IOrderService orderService;

    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session){
        Order data = orderService.create(aid, getUidFromSession(session), getUsernameFromSession(session), cids);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("select_orders")
    public JsonResult<List<Order>> selectOrder(HttpSession session){
        List<Order> data = orderService.selectOrder(getUidFromSession(session));
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("{oid}/select_order_items")
    public JsonResult<List<OrderItem>> selectOrderItem(@PathVariable("oid")Integer oid){
        List<OrderItem> data = orderService.selectOrderItem(oid);
        return new JsonResult<>(OK, data);
    }
}
