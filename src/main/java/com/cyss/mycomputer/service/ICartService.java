package com.cyss.mycomputer.service;

import com.cyss.mycomputer.vo.CartVO;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-11-02 17:05
 * @Description:
 */
public interface ICartService {

    void  addToCart(Integer uid, Integer pid, Integer amount, String username);

    List<CartVO> getCartVOByUid(Integer uid);

    Integer addNum(Integer cid, Integer uid, String username);

    Integer reductionNum(Integer cid, Integer uid, String username);
}
