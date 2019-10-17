package com.sales.entity;

import java.util.Date;

public class CustomerMasterEntity {
    private Integer customerId;

    private String customerCode;

    private String customerName;

    private String customerAddress;

    private String customerPhone;

    private String customerMail;

    private Integer customerSex;

    private Date customerBirthday;

    private String customerWechat;

    private String customerImageUrl;

    private Integer customerHeight;

    private Integer customerWeight;

    private String customerPassword;

    private String isSystem;

    private Integer storeId;

    private Integer customerStatus;

    private String customerRemake;

    private Date createTime;

    private Date updateTime;

    private Double lastIntegral;

    private Double storedValue;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail == null ? null : customerMail.trim();
    }

    public Integer getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(Integer customerSex) {
        this.customerSex = customerSex;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerWechat() {
        return customerWechat;
    }

    public void setCustomerWechat(String customerWechat) {
        this.customerWechat = customerWechat == null ? null : customerWechat.trim();
    }

    public String getCustomerImageUrl() {
        return customerImageUrl;
    }

    public void setCustomerImageUrl(String customerImageUrl) {
        this.customerImageUrl = customerImageUrl == null ? null : customerImageUrl.trim();
    }

    public Integer getCustomerHeight() {
        return customerHeight;
    }

    public void setCustomerHeight(Integer customerHeight) {
        this.customerHeight = customerHeight;
    }

    public Integer getCustomerWeight() {
        return customerWeight;
    }

    public void setCustomerWeight(Integer customerWeight) {
        this.customerWeight = customerWeight;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword == null ? null : customerPassword.trim();
    }

    public String getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem == null ? null : isSystem.trim();
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerRemake() {
        return customerRemake;
    }

    public void setCustomerRemake(String customerRemake) {
        this.customerRemake = customerRemake == null ? null : customerRemake.trim();
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

    public Double getLastIntegral() {
        return lastIntegral;
    }

    public void setLastIntegral(Double lastIntegral) {
        this.lastIntegral = lastIntegral;
    }

    public Double getStoredValue() {
        return storedValue;
    }

    public void setStoredValue(Double storedValue) {
        this.storedValue = storedValue;
    }
}