package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.mapper
 * @Author: cyss
 * @CreatTime: 2022-09-10 17:19
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("Tom123123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void findByUsername(){
        String username = "ccc";
        User user = userMapper.findByUsername(username);
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(2, "34345345", "Tom", new Date());
    }

    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(2));
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(9);
        user.setPhone("13571852826");
        user.setEmail("2363067648@qq.com");
        user.setGender(0);
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println(rows);
    }

    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(9, "/upload/avatar.png", "cyss", new Date());
    }
}
