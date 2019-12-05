package com.aaa.service.user.impl;

import com.aaa.mapper.user.UserMapper;
import com.aaa.model.PermInfo;
import com.aaa.model.UserInfo;
import com.aaa.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:28
 */
@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserInfo getUserByUserName(String principal) {

        UserInfo userInfo = userMapper.getUserByUserName(principal);

        if (userInfo == null) {
            logger.warn("user is null");
            return null;
        }

        return userInfo;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userMapper.addUser(userInfo);
    }
    @Override
    public List<PermInfo> getPermsByUserName(String userName) {
        List<PermInfo> permInfos = userMapper.getPermsByUserName(userName);
        if (permInfos == null || permInfos.isEmpty()) {
            logger.warn("perms num is zero");
            return null;
        }
        return permInfos;
    }
}
