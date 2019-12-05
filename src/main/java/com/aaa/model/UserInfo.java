package com.aaa.model;

import java.io.Serializable;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:32
 */
public class UserInfo implements Serializable {
    private Long userId;
    private String userName;
    private String userPassword;
    private Integer userStatus;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
