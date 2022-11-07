package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Cart;

import java.util.Date;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.mapper
 * @Author: cyss
 * @CreatTime: 2022-11-02 11:23
 * @Description:
 */
public interface CartMapper {

    Integer insert(Cart cart);

    Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);

    Cart findByUidAndPid(Integer uid, Integer pid);
}
