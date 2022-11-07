package com.cyss.mycomputer.controller;

import com.cyss.mycomputer.entity.Product;
import com.cyss.mycomputer.service.IProductService;
import com.cyss.mycomputer.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller
 * @Author: cyss
 * @CreatTime: 2022-11-01 19:23
 * @Description:
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController{

    @Autowired
    private IProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList(){
        List<Product> hotList = productService.findHotList();
        return new JsonResult<>(OK, hotList);
    }

    @RequestMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id){
        Product product = productService.findById(id);
        return new JsonResult<>(OK, product);
    }

    @RequestMapping("new_list")
    public JsonResult<List<Product>> getNewList(){
        List<Product> newList = productService.findNewList();
        return new JsonResult<>(OK, newList);
    }
}
