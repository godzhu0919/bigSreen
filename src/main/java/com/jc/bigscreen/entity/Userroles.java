package com.jc.bigscreen.entity;

import java.io.Serializable;

/**
 * (Userroles)实体类
 *
 * @author makejava
 * @since 2024-07-25 17:17:22
 */
public class Userroles implements Serializable {
    private static final long serialVersionUID = 753742412110891237L;
    /**
     * 唯一标识用户角色关系的主键
     */
    private Integer userRoleId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 角色分配给用户的时间
     */
    private String assignedAt;


    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(String assignedAt) {
        this.assignedAt = assignedAt;
    }

}

