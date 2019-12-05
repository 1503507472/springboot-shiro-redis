package com.aaa.service.user;

import com.aaa.model.PermInfo;
import com.aaa.model.UserInfo;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:28
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     * @param principal
     * @return
     */
    UserInfo getUserByUserName(String principal);

    /**
     * 添加用户
     * @param userInfo
     */

    void addUser(UserInfo userInfo);
    /**
     * 根据用户名去数据库中查询该用户所拥有的权限
     * @param userName
     * @return
     */
    List<PermInfo> getPermsByUserName(String userName);
}
