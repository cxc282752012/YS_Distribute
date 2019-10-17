package com.warehouse.entity;

import java.util.Date;

public class OnStockMasterEntity {
    private Integer onStockId;

    private String onStockCode;

    private Integer onStockTotalQuantity;

    private Double onStockTotalPrice;

    private Integer onStockStatus;

    private Integer storeId;

    private Date createTime;

    private Date updateTime;

    public Integer getOnStockId() {
        return onStockId;
    }

    public void setOnStockId(Integer onStockId) {
        this.onStockId = onStockId;
    }

    public String getOnStockCode() {
        return onStockCode;
    }

    public void setOnStockCode(String onStockCode) {
        this.onStockCode = onStockCode == null ? null : onStockCode.trim();
    }

    public Integer getOnStockTotalQuantity() {
        return onStockTotalQuantity;
    }

    public void setOnStockTotalQuantity(Integer onStockTotalQuantity) {
        this.onStockTotalQuantity = onStockTotalQuantity;
    }

    public Double getOnStockTotalPrice() {
        return onStockTotalPrice;
    }

    public void setOnStockTotalPrice(Double onStockTotalPrice) {
        this.onStockTotalPrice = onStockTotalPrice;
    }

    public Integer getOnStockStatus() {
        return onStockStatus;
    }

    public void setOnStockStatus(Integer onStockStatus) {
        this.onStockStatus = onStockStatus;
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