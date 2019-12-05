package com.aaa.model;

import java.io.Serializable;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:32
 */
public class UserRoleInfo implements Serializable {
    private Long userRoleId;
    private Long userId;
    private Integer roleId;

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRoleInfo{" +
                "userRoleId=" + userRoleId +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
