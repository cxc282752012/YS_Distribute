package com.warehouse.entity;

import java.util.Date;

public class CheckStockMasterEntity {
    private Integer checkStockId;

    private String checkStockCode;

    private Integer checkStockQuantity;

    private Double checkTotalPrice;

    private Integer checkStockStatus;

    private Integer storeId;

    private Date createTime;

    private Date updateTime;

    public Integer getCheckStockId() {
        return checkStockId;
    }

    public void setCheckStockId(Integer checkStockId) {
        this.checkStockId = checkStockId;
    }

    public String getCheckStockCode() {
        return checkStockCode;
    }

    public void setCheckStockCode(String checkStockCode) {
        this.checkStockCode = checkStockCode == null ? null : checkStockCode.trim();
    }

    public Integer getCheckStockQuantity() {
        return checkStockQuantity;
    }

    public void setCheckStockQuantity(Integer checkStockQuantity) {
        this.checkStockQuantity = checkStockQuantity;
    }

    public Double getCheckTotalPrice() {
        return checkTotalPrice;
    }

    public void setCheckTotalPrice(Double checkTotalPrice) {
        this.checkTotalPrice = checkTotalPrice;
    }

    public Integer getCheckStockStatus() {
        return checkStockStatus;
    }

    public void setCheckStockStatus(Integer checkStockStatus) {
        this.checkStockStatus = checkStockStatus;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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