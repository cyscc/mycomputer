package com.cyss.mycomputer.entity;

import lombok.*;

import javax.sql.rowset.CachedRowSet;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.entity
 * @Author: cyss
 * @CreatTime: 2022-11-01 17:22
 * @Description: 商品类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Product extends BaseEntity{
    private Integer id;
    private Integer categoryId ;
    private String itemType;
    private String title;
    private String sellPoint;
    private Long price;
    private Integer num;
    private String image;
    private Integer status;
    private String priority;
}
