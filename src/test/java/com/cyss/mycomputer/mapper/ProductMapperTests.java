package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Product;
import com.cyss.mycomputer.entity.User;
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
public class ProductMapperTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void queryPriorityProduct(){
        List<Product> products = productMapper.queryPriorityProduct();
        products.forEach(System.out::println);
    }

    @Test
    public void findById(){
        Product product = productMapper.findById(10000017);
        System.out.println(product);
    }

    @Test
    public void newProduct(){
        List<Product> products = productMapper.newProduct();
        products.forEach(System.out::println);
    }

}
