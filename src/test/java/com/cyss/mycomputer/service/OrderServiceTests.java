package com.cyss.mycomputer.service;

import com.cyss.mycomputer.entity.User;
import com.cyss.mycomputer.service.ex.ServiceException;
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
public class OrderServiceTests {

    @Autowired
    private IOrderService orderService;

    @Test
    public void create(){
        System.out.println(orderService.create(3, 1, "cyss", new Integer[]{1, 2, 4}));
    }
}
