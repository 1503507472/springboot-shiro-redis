package com.aaa.model;

import java.io.Serializable;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:32
 */
public class RoleInfo implements Serializable {
    private Integer roleId;
    private String roleName;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
