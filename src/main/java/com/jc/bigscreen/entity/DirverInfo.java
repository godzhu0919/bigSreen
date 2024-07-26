package com.jc.bigscreen.entity;

import java.io.Serializable;

/**
 * (DirverInfo)实体类
 *
 * @author makejava
 * @since 2024-07-26 09:34:49
 */
public class DirverInfo implements Serializable {
    private static final long serialVersionUID = 172654739734498544L;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 证件号
     */
    private String idNum;
    /**
     * 电话号码
     */
    private String phoneNum;
    /**
     * 心率
     */
    private Integer heartRate;
    /**
     * t体温
     */
    private Double temperature;
    /**
     * 呼吸率
     */
    private Integer respiratoryRate;
    /**
     * 步数
     */
    private Integer stepNumber;
    /**
     * 血氧
     */
    private Integer bloodOxygen;
    /**
     * 压力
     */
    private Integer stress;
    /**
     * 情绪
     */
    private Integer emo;
    /**
     * 疲劳
     */
    private Integer istired;
    /**
     * 采集日期
     */
    private String collectionDate;
    /**
     * 备用1
     */
    private String reserve;
    
    private String reserve2;
    
    private String reserve3;
    
    private String reserve4;
    
    private String reserve5;
    
    private String reserve6;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(Integer respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public Integer getBloodOxygen() {
        return bloodOxygen;
    }

    public void setBloodOxygen(Integer bloodOxygen) {
        this.bloodOxygen = bloodOxygen;
    }

    public Integer getStress() {
        return stress;
    }

    public void setStress(Integer stress) {
        this.stress = stress;
    }

    public Integer getEmo() {
        return emo;
    }

    public void setEmo(Integer emo) {
        this.emo = emo;
    }

    public Integer getIstired() {
        return istired;
    }

    public void setIstired(Integer istired) {
        this.istired = istired;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    public String getReserve5() {
        return reserve5;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    public String getReserve6() {
        return reserve6;
    }

    public void setReserve6(String reserve6) {
        this.reserve6 = reserve6;
    }

}

