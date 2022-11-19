package com.cyss.mycomputer.service.impl;

import com.cyss.mycomputer.entity.Address;
import com.cyss.mycomputer.mapper.AddressMapper;
import com.cyss.mycomputer.service.IAddressService;
import com.cyss.mycomputer.service.IDistrictService;
import com.cyss.mycomputer.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.impl
 * @Author: cyss
 * @CreatTime: 2022-09-12 19:36
 * @Description:
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private IDistrictService districtService;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewAddress(Address address, Integer uid, String username) {
        Integer count = addressMapper.countByUid(uid);
        if(count >= maxCount){
            throw new AddressCountLimitException("用户收货地址超过20条");
        }

        String areaName = districtService.getNameByCode(address.getAreaCode());
        String cityName = districtService.getNameByCode(address.getCityCode());
        String provinceName = districtService.getNameByCode(address.getProvinceCode());
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        address.setUid(uid);
        Integer isDefault = count == 0 ? 1 : 0;
        address.setIsDefault(isDefault);

        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());

        Integer rows = addressMapper.insert(address);
        if(rows != 1){
            throw new InsertException("地址信息插入异常");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> result = addressMapper.findByUid(uid);
        for (Address address : result) {
//            address.setAid(null);
//            address.setUid(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setTel(null);
            address.setIsDefault(null);
            address.setCreatedUser(null);
            address.setCreatedTime(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);
        }
        return result;
    }

    @Override
    public void setDefault(Integer aid, Integer uid, String modifiedUser) {
        Address result = addressMapper.findByAid(aid);
        if(result == null){
            throw new AddressNotFoundException("收货地址不存在");
        }
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = addressMapper.updateNonDefault(uid);
        if(rows < 1){
            throw new UpdateException("更新数据产生未知异常");
        }
        rows = addressMapper.updateDefaultByAid(aid, modifiedUser, new Date());
        if(rows !=  1){
            throw new UpdateException("更新数据产生未知异常");
        }
    }

    @Override
    public void delete(Integer uid, Integer aid, String username) {
        Address address = addressMapper.findByAid(aid);
        if(address == null){
            throw new AddressNotFoundException("收货地址找不到");
        }
        if(!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = addressMapper.deleteByAid(aid);
        if(rows != 1){
            throw new DeleteException("删除数据产生未知的异常");
        }
        Integer count = addressMapper.countByUid(uid);
        if(count == 0){
            return;
        }
        Address addressLastModified = addressMapper.findLastModified(uid);
        if(address.getIsDefault() == 1){
            rows = addressMapper.updateDefaultByAid(addressLastModified.getAid(), username, new Date());
            if (rows != 1) {
                throw new UpdateException("更新数据时产生未知的异常");
            }
        }
    }

    @Override
    public Address getByAid(Integer aid, Integer uid) {
        Address address = addressMapper.findByAid(aid);
        if(address == null){
            throw new AddressNotFoundException("收货地址数据不存在");
        }
        if(!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        address.setProvinceCode(null);
        address.setCityCode(null);
        address.setAreaCode(null);
        address.setCreatedTime(null);
        address.setCreatedUser(null);
        address.setModifiedTime(null);
        address.setModifiedUser(null);
        return address;
    }
}
