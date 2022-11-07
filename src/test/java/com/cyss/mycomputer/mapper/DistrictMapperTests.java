package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Address;
import com.cyss.mycomputer.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class DistrictMapperTests {

    @Autowired
    private DistrictMapper districtMapper;

    @Test
    public void findByParent(){
        List<District> districts = districtMapper.findByParent("210100");
        for (District district : districts) {
            System.out.println(district);
        }
    }

    @Test
    public void findNameByCode(){
        String name = districtMapper.findNameByCode("610000");
        System.out.println(name);
    }

}
