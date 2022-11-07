package com.cyss.mycomputer.mapper;

import com.cyss.mycomputer.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.mapper
 * @Author: cyss
 * @CreatTime: 2022-09-10 16:35
 * @Description:
 */
public interface UserMapper {
    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数
     */
    Integer insert(User user);

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 找到返回用户，没有返回null
     */
    User findByUsername(String username);

    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    User findByUid(Integer uid);

    Integer updateInfoByUid(User user);

    // @Param：Integer uid 的值对应到占位符 “uid” 上
    Integer updateAvatarByUid(@Param("uid") Integer uid, String avatar, String modifiedUser, Date modifiedTime);
}
