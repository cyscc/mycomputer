package com.cyss.mycomputer.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.entity
 * @Author: cyss
 * @CreatTime: 2022-09-12 20:25
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class District extends BaseEntity implements Serializable {
    private Integer id;
    private String parent;
    private String code;
    private String name;
}
