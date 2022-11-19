package com.cyss.mycomputer.service;

import com.cyss.mycomputer.entity.Address;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-09-12 17:29
 * @Description:
 */
public interface IAddressService {
    void addNewAddress(Address address, Integer uid, String username);

    List<Address> getByUid(Integer uid);

    void setDefault(Integer aid, Integer uid, String modifiedUser);

    void delete(Integer uid, Integer aid, String username);

    Address getByAid(Integer aid, Integer uid);
}
