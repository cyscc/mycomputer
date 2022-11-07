package com.cyss.mycomputer.service;

import com.cyss.mycomputer.entity.Product;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-11-01 19:13
 * @Description:
 */
public interface IProductService {
    List<Product> findHotList();

    Product findById(Integer id);

    List<Product> findNewList();
}
