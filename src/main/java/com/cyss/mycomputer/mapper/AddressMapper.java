package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.Address;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.mapper
 * @Author: cyss
 * @CreatTime: 2022-09-12 15:17
 * @Description:
 */
public interface AddressMapper {

    Integer insert(Address address);

    Integer countByUid(Integer uid);

    List<Address> findByUid(Integer uid);

    Address findByAid(Integer aid);

    Integer updateNonDefault(Integer uid);

    Integer updateDefaultByAid(Integer aid, String modifiedUser, Date modifiedTime);

    Integer deleteByAid(Integer aid);

    Address findLastModified(Integer uid);

}
