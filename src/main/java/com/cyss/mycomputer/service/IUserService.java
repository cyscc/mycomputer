package com.cyss.mycomputer.service;

import com.cyss.mycomputer.entity.User;

import javax.servlet.http.HttpSession;
import java.lang.ref.SoftReference;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service
 * @Author: cyss
 * @CreatTime: 2022-09-10 19:40
 * @Description:
 */
public interface IUserService {
    void reg(User user);

    User login(String username, String password);

    void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    User getByUid(Integer uid);

    void changeInfo(Integer uid, String username, User user);

    void changeAvatar(Integer uid, String avatar, String username);
}
