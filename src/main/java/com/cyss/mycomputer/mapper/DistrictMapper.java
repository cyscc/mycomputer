package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Address;
import com.cyss.mycomputer.entity.District;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.mapper
 * @Author: cyss
 * @CreatTime: 2022-09-12 20:30
 * @Description:
 */
public interface DistrictMapper {

    List<District> findByParent(String parent);

    String findNameByCode(String code);
}
