package com.cyss.mycomputer.service;

import com.cyss.mycomputer.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.TreeSet;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-09-10 19:52
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartServiceTests {

    @Autowired
    private ICartService cartService;

    @Test
    public void addToCart(){
        cartService.addToCart(1, 10000026, 2, "cyss");
    }

    @Test
    public void getCartVOByUid(){
        for (CartVO cartVO : cartService.getCartVOByUid(1)) {
            System.out.println(cartVO);
        }
    }

    @Test
    public void addNum(){
        System.out.println(cartService.addNum(1, 1, "cyss"));
    }

    @Test
    public void reductionNum(){
        System.out.println(cartService.reductionNum(1, 1, "cyss"));
    }

    @Test
    public void deleteCartVOByCid(){
        Integer rows = cartService.deleteCartVOByCid(5, 1);
        System.out.println(rows);
    }
}
