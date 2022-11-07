package com.cyss.mycomputer.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.entity
 * @Author: cyss
 * @CreatTime: 2022-09-10 16:23
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class User extends BaseEntity implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;
}
