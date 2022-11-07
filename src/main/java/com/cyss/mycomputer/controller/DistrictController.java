package com.cyss.mycomputer.controller;

import com.cyss.mycomputer.entity.District;
import com.cyss.mycomputer.service.IDistrictService;
import com.cyss.mycomputer.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller
 * @Author: cyss
 * @CreatTime: 2022-09-12 21:12
 * @Description:
 */
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{

    @Autowired
    private IDistrictService districtService;

    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> result = districtService.getByParent(parent);
        return new JsonResult<>(OK, result);
    }
}
