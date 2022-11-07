package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.mapper
 * @Author: cyss
 * @CreatTime: 2022-09-10 17:19
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(9);
        address.setPhone("13571717171");
        address.setName("cyss");;
        Integer rows = addressMapper.insert(address);
        System.out.println(rows);
    }

    @Test
    public void countByUid(){
        Integer result = addressMapper.countByUid(9);
        System.out.println(result);
    }

    @Test
    public void findByUid(){
        List<Address> result = addressMapper.findByUid(9);
        System.out.println(result);
    }

    @Test
    public void findByAid(){
        Address address = addressMapper.findByAid(10);
        System.out.println(address);
    }

    @Test
    public void updateNonDefault(){
        Integer integer = addressMapper.updateNonDefault(9);
        System.out.println(integer);
    }

    @Test
    public void updateDefaultByAid(){
        Integer rows = addressMapper.updateDefaultByAid(10, "cyss", new Date());
        System.out.println(rows);
    }

    @Test
    public void deleteByAid(){
        Integer rows = addressMapper.deleteByAid(12);
        System.out.println(rows);
    }

    @Test
    public void findLastModified(){
        Address address = addressMapper.findLastModified(9);
        System.out.println(address);
    }
}
