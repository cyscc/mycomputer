package com.cyss.mycomputer.entity;

import lombok.*;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.io.Serializable;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.entity
 * @Author: cyss
 * @CreatTime: 2022-09-12 15:12
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseEntity implements Serializable {
    private Integer aid;
    private Integer uid;
    private String name;
    private String provinceName;
    private String provinceCode;
    private String cityName;
    private String cityCode;
    private String areaName;
    private String areaCode;
    private String zip;
    private String address;
    private String phone;
    private String tel;
    private String tag;
    private Integer isDefault;
}
