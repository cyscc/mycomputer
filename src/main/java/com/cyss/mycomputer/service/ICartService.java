package com.cyss.mycomputer.service;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-11-02 17:05
 * @Description:
 */
public interface ICartService {

    void  addToCart(Integer uid, Integer pid, Integer amount, String username);

}
