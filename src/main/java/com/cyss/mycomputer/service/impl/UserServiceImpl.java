package com.cyss.mycomputer.service.impl;

import com.cyss.mycomputer.entity.User;
import com.cyss.mycomputer.mapper.UserMapper;
import com.cyss.mycomputer.service.IUserService;
import com.cyss.mycomputer.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;
import java.util.regex.PatternSyntaxException;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.service.impl
 * @Author: cyss
 * @CreatTime: 2022-09-10 19:41
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        String username = user.getUsername();
        User result = userMapper.findByUsername(username);
        if(result != null){
            throw new UsernameDuplicatedException("用户名被占用");
        }

        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        String md5Password = getMD5Password(oldPassword, salt);
        user.setPassword(md5Password);

        Integer rows = userMapper.insert(user);
        if(rows != 1){
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }

        String salt = user.getSalt();
        String newMD5Password = getMD5Password(password, salt);
        if(!newMD5Password.equals(user.getPassword())){
            throw new PasswordNotMatchException("用户密码错误");
        }

        if(user.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户不存在");
        }

        //体量变小
        User userSmall = new User();
        userSmall.setUid(user.getUid());
        userSmall.setUsername(user.getUsername());
        userSmall.setAvatar(user.getAvatar());

        return userSmall;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if(result == null){
            throw new UsernameNotFoundException("用户找不到");
        }
        String md5Password = getMD5Password(oldPassword, result.getSalt());
        if(!result.getPassword().equals(md5Password)){
            throw new PasswordNotMatchException("密码错误");
        }
        String newMD5Password = getMD5Password(newPassword, result.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid, newMD5Password, username, new Date());
        if(rows != 1){
            throw new UpdateException("更新数据时产生异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户没有找到");
        }

        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());


        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户没有找到");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        if(rows != 1){
            throw new UpdateException("更新数据时产生异常");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户没有找到");
        }
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if(rows != 1){
            throw new UpdateException("更新数据时产生异常");
        }
    }


    private String getMD5Password(String password, String salt){
        for(int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }

}
