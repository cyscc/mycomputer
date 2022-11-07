package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Product;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.mapper
 * @Author: cyss
 * @CreatTime: 2022-11-01 18:54
 * @Description:
 */
public interface ProductMapper {

    List<Product> queryPriorityProduct();

    Product findById(Integer id);

    List<Product> newProduct();
}
