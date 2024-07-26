package com.jc.bigscreen.entity;

import java.io.Serializable;

/**
 * (Equipment)实体类
 *
 * @author makejava
 * @since 2024-07-26 09:37:12
 */
public class Equipment implements Serializable {
    private static final long serialVersionUID = 819935689373446194L;
    /**
     * 设备id
     */
    private Integer equipmentId;
    /**
     * 设备在线状态
     */
    private String equipmentState;
    /**
     * 绑定用户状态
     */
    private Integer bindUserId;
    /**
     * 绑定用户姓名
     */
    private String bindUsername;
    /**
     * 设备上次通讯时间
     */
    private String lastCommunicateDate;


    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState;
    }

    public Integer getBindUserId() {
        return bindUserId;
    }

    public void setBindUserId(Integer bindUserId) {
        this.bindUserId = bindUserId;
    }

    public String getBindUsername() {
        return bindUsername;
    }

    public void setBindUsername(String bindUsername) {
        this.bindUsername = bindUsername;
    }

    public String getLastCommunicateDate() {
        return lastCommunicateDate;
    }

    public void setLastCommunicateDate(String lastCommunicateDate) {
        this.lastCommunicateDate = lastCommunicateDate;
    }

}

