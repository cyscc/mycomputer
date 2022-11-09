package com.cyss.mycomputer.controller;

import com.cyss.mycomputer.service.ICartService;
import com.cyss.mycomputer.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller
 * @Author: cyss
 * @CreatTime: 2022-11-09 10:33
 * @Description:
 */
@RestController
@RequestMapping("carts")
public class CartController extends BaseController{
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session){
        cartService.addToCart(getUidFromSession(session), pid, amount, getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
}
