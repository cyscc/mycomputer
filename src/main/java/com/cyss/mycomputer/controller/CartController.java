package com.cyss.mycomputer.controller;

import com.cyss.mycomputer.service.ICartService;
import com.cyss.mycomputer.util.JsonResult;
import com.cyss.mycomputer.vo.CartVO;
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

    @RequestMapping({"", "/"})
    public JsonResult<List<CartVO>> getCartVOByUid(HttpSession session){
        List<CartVO> cartVOList = cartService.getCartVOByUid(getUidFromSession(session));
        return new JsonResult<>(OK, cartVOList);
    }

    @RequestMapping("{cid}/add_num")
    public JsonResult<Integer> addNum(@PathVariable("cid")Integer cid, HttpSession session){
        Integer num = cartService.addNum(cid, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK, num);
    }

    @RequestMapping("{cid}/reduction_num")
    public JsonResult<Integer> reductionNum(@PathVariable("cid")Integer cid, HttpSession session){
        Integer num = cartService.reductionNum(cid, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK, num);
    }

    @RequestMapping("list")
    public JsonResult<List<CartVO>> getCartVOByCid(Integer[] cids, HttpSession session){
        List<CartVO> cartVOList = cartService.getCartVOByCid(cids, getUidFromSession(session));
        return new JsonResult<>(OK, cartVOList);
    }

    @RequestMapping("{cid}/delete_cartVO")
    public JsonResult<Void> deleteCartVOByCid(@PathVariable("cid")Integer cid, HttpSession session){
        cartService.deleteCartVOByCid(cid, getUidFromSession(session));
        return new JsonResult<>(OK);
    }
}
