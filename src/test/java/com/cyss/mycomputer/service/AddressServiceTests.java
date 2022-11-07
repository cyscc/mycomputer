package com.cyss.mycomputer.service;

import com.cyss.mycomputer.entity.Address;
import com.cyss.mycomputer.entity.User;
import com.cyss.mycomputer.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-09-10 19:52
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {

    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress(){
        Address address = new Address();
        address.setUid(9);
        address.setPhone("13571717171");

        addressService.addNewAddress(address, 9, "cyss");
    }

    @Test
    public void setDefault(){
        addressService.setDefault(11, 9, "cyss");
    }

    @Test
    public void delete(){
        addressService.delete(9, 10, "cyss");
    }
}
