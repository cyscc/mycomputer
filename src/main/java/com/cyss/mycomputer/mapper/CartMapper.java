package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Cart;
import com.cyss.mycomputer.vo.CartVO;

import java.util.Date;
import java.util.List;

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

    List<CartVO> findByUid(Integer uid);

    Cart findByCid(Integer cid);

    List<CartVO> findCartVOByCid(Integer[] cids);

    Integer deleteByCid(Integer cid);
}
