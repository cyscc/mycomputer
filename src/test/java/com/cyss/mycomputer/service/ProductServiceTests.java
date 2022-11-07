package com.cyss.mycomputer.service;

import com.cyss.mycomputer.entity.Product;
import com.cyss.mycomputer.entity.User;
import com.cyss.mycomputer.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-09-10 19:52
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTests {

    @Autowired
    private IProductService productService;

    @Test
    public void findHotList(){
        List<Product> hotList = productService.findHotList();
        hotList.forEach(System.out::println);
    }

    @Test
    public void findById(){
        Product product = productService.findById(10000017);
        System.out.println(product);
    }

    @Test
    public void findNewList(){
        List<Product> newList = productService.findNewList();
        newList.forEach(System.out::println);
    }

}
