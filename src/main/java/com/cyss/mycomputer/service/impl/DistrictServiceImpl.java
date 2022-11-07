package com.cyss.mycomputer.service.impl;

import com.cyss.mycomputer.entity.District;
import com.cyss.mycomputer.mapper.DistrictMapper;
import com.cyss.mycomputer.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.impl
 * @Author: cyss
 * @CreatTime: 2022-09-12 21:01
 * @Description:
 */
@Service
public class DistrictServiceImpl implements IDistrictService {

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> result = districtMapper.findByParent(parent);
        for (District district : result) {
            district.setId(null);
            district.setParent(null);
        }
        return result;
    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}
