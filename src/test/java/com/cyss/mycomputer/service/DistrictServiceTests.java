package com.cyss.mycomputer.service;

import com.cyss.mycomputer.entity.District;
import com.cyss.mycomputer.entity.User;
import com.cyss.mycomputer.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-09-10 19:52
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictServiceTests {

    @Autowired
    private IDistrictService districtService;

    @Test
    public void getByParent(){
        List<District> parent = districtService.getByParent("86");
        for (District district : parent) {
            System.out.println(district);
        }
    }
}
