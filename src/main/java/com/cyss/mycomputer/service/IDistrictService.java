package com.cyss.mycomputer.service;

import com.cyss.mycomputer.entity.District;
import com.cyss.mycomputer.mapper.DistrictMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-09-12 20:58
 * @Description:
 */
public interface IDistrictService {

    List<District> getByParent(String parent);

    String getNameByCode(String code);

}
