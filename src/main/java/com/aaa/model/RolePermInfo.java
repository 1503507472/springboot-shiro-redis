package com.aaa.model;

import java.io.Serializable;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:32
 */
public class RolePermInfo implements Serializable {
    private Integer rolePermId;
    private Integer roleId;
    private Integer permId;

    public Integer getRolePermId() {
        return rolePermId;
    }

    public void setRolePermId(Integer rolePermId) {
        this.rolePermId = rolePermId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    @Override
    public String toString() {
        return "RolePermInfo{" +
                "rolePermId=" + rolePermId +
                ", roleId=" + roleId +
                ", permId=" + permId +
                '}';
    }
}
