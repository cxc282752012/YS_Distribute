package com.system.entity;

import java.util.Date;

public class StoreMasterEntity {
    private Integer storeId;

    private Integer businessId;

    private String storeName;

    private String storeAddress;

    private String storeLinkman;

    private String storePhone;

    private String storeArea;

    private Integer storeType;

    private Double deliveryPrice;

    private Integer storeDiscount;

    private Integer storeStatus;

    private Date createTime;

    private Date updateTime;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    public String getStoreLinkman() {
        return storeLinkman;
    }

    public void setStoreLinkman(String storeLinkman) {
        this.storeLinkman = storeLinkman == null ? null : storeLinkman.trim();
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone == null ? null : storePhone.trim();
    }

    public String getStoreArea() {
        return storeArea;
    }

    public void setStoreArea(String storeArea) {
        this.storeArea = storeArea == null ? null : storeArea.trim();
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getStoreDiscount() {
        return storeDiscount;
    }

    public void setStoreDiscount(Integer storeDiscount) {
        this.storeDiscount = storeDiscount;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
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
}