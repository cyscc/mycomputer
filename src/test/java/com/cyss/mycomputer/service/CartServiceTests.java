package com.cyss.mycomputer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
