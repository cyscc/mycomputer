package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Cart;
import com.cyss.mycomputer.entity.User;
import com.cyss.mycomputer.vo.CartVO;
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
public class CartMapperTests {

    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(9);
        cart.setPid(10000027);
        cart.setNum(1);
        cart.setPrice(2000L);
        Integer rows = cartMapper.insert(cart);
        System.out.println(rows);
    }

    @Test
    public void updateNumByCid(){
        Integer rows = cartMapper.updateNumByCid(1, 13, "cyss", new Date());
        System.out.println(rows);
    }

    @Test
    public void findByUidAndPid(){
        Cart cart = cartMapper.findByUidAndPid(9, 10000026);
        System.out.println(cart);
    }

    @Test
    public void findByUid(){
        List<CartVO> carts = cartMapper.findByUid(1);
        carts.forEach(System.out::println);
    }

    @Test
    public void findByCid(){
        System.out.println(cartMapper.findByCid(1));
    }

}
