package com.cyss.mycomputer.service.impl;

import com.cyss.mycomputer.entity.Product;
import com.cyss.mycomputer.mapper.ProductMapper;
import com.cyss.mycomputer.service.IProductService;
import com.cyss.mycomputer.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.impl
 * @Author: cyss
 * @CreatTime: 2022-11-01 19:13
 * @Description:
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findHotList() {
        List<Product> products = productMapper.queryPriorityProduct();
        for(Product product : products){
            product.setPriority(null);
            product.setCreatedTime(null);
            product.setCreatedUser(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        }
        return products;
    }

    @Override
    public Product findById(Integer id) {
        Product product = productMapper.findById(id);
        if(product == null){
            throw new ProductNotFoundException();
        }
        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);

        return product;
    }

    @Override
    public List<Product> findNewList() {
        List<Product> products = productMapper.newProduct();
        for(Product product : products){
            product.setPriority(null);
            product.setCreatedTime(null);
            product.setCreatedUser(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        }
        return products;
    }
}
