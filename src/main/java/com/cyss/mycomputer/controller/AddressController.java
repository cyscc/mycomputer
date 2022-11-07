package com.cyss.mycomputer.controller;

import com.cyss.mycomputer.entity.Address;
import com.cyss.mycomputer.mapper.AddressMapper;
import com.cyss.mycomputer.service.IAddressService;
import com.cyss.mycomputer.service.impl.AddressServiceImpl;
import com.cyss.mycomputer.util.JsonResult;
import org.apache.ibatis.javassist.compiler.ast.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.rmi.server.UID;
import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.controller
 * @Author: cyss
 * @CreatTime: 2022-09-12 20:01
 * @Description:
 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController{

    @Autowired
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(address, uid, username);
        return new JsonResult<>(OK);
    }

    @RequestMapping({"", "/"})
    public JsonResult<List<Address>> getByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Address> result = addressService.getByUid(uid);
        return new JsonResult<>(OK, result);
    }

    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(HttpSession session, @PathVariable("aid") Integer aid){

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.setDefault(aid, uid, username);
        return new JsonResult<>(OK);
    }

    @RequestMapping("{aid}/delete")
    public JsonResult<Void> delete(@PathVariable("aid") Integer aid, HttpSession session){
        addressService.delete(
                getUidFromSession(session),
                aid,
                getUsernameFromSession(session)
        );
        return new JsonResult<>(OK);
    }
}
