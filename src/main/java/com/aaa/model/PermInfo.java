package com.aaa.model;

import java.io.Serializable;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/11/23 14:31
 */
public class PermInfo implements Serializable {
    private Integer permId;
    private String resourcePermName;

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public String getResourcePermName() {
        return resourcePermName;
    }

    public void setResourcePermName(String resourcePermName) {
        this.resourcePermName = resourcePermName;
    }

    @Override
    public String toString() {
        return "PermInfo{" +
                "permId=" + permId +
                ", resourcePermName='" + resourcePermName + '\'' +
                '}';
    }
}
