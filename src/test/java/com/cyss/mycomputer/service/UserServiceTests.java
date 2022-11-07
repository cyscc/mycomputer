package com.cyss.mycomputer.service;

import com.cyss.mycomputer.entity.User;
import com.cyss.mycomputer.mapper.UserMapper;
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
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("cys");
            user.setPassword("123123");
            userService.reg(user);
            System.out.println("插入成功");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getCanonicalName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user = userService.login("cyss", "123123");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        userService.changePassword(9, "cyss", "123123", "345345");
    }

    @Test
    public void getByUid(){
        User result = userService.getByUid(9);
        System.out.println(result);
    }

    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("11111111111");
        user.setEmail("2363067648@qq.com");
        user.setGender(1);
        userService.changeInfo(9, "cyss", user);
    }

    @Test
    public void changeAvatar(){
        userService.changeAvatar(9, "/static/test.png", "cyss");
    }
}
