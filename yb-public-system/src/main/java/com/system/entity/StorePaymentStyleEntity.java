package com.system.entity;

import java.util.Date;

public class StorePaymentStyleEntity {
    private Integer paymentStyleId;

    private String paymentStyleName;

    private String paymentStyleCode;

    private String paymentShortName;

    private String paymentAccountName;

    private Integer storeId;

    private String isSystem;

    private String isDefault;

    private String isFirstUse;

    private String isFlag;

    private Date createTime;

    private Date updateTime;

    private Double balance;

    public Integer getPaymentStyleId() {
        return paymentStyleId;
    }

    public void setPaymentStyleId(Integer paymentStyleId) {
        this.paymentStyleId = paymentStyleId;
    }

    public String getPaymentStyleName() {
        return paymentStyleName;
    }

    public void setPaymentStyleName(String paymentStyleName) {
        this.paymentStyleName = paymentStyleName == null ? null : paymentStyleName.trim();
    }

    public String getPaymentStyleCode() {
        return paymentStyleCode;
    }

    public void setPaymentStyleCode(String paymentStyleCode) {
        this.paymentStyleCode = paymentStyleCode == null ? null : paymentStyleCode.trim();
    }

    public String getPaymentShortName() {
        return paymentShortName;
    }

    public void setPaymentShortName(String paymentShortName) {
        this.paymentShortName = paymentShortName == null ? null : paymentShortName.trim();
    }

    public String getPaymentAccountName() {
        return paymentAccountName;
    }

    public void setPaymentAccountName(String paymentAccountName) {
        this.paymentAccountName = paymentAccountName == null ? null : paymentAccountName.trim();
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem == null ? null : isSystem.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public String getIsFirstUse() {
        return isFirstUse;
    }

    public void setIsFirstUse(String isFirstUse) {
        this.isFirstUse = isFirstUse == null ? null : isFirstUse.trim();
    }

    public String getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag == null ? null : isFlag.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}