package com.cyss.mycomputer.entity;

import lombok.*;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.entity
 * @Author: cyss
 * @CreatTime: 2022-11-02 11:21
 * @Description: 购物车实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Cart extends BaseEntity {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
}
