package com.warehouse.entity;

import java.util.Date;

public class InStockMasterEntity {
    private Integer inStockId;

    private String inStockCode;

    private Integer inStockTotalQuantity;

    private Double inStockTotalPrice;

    private Integer inStockStatus;

    private Integer storeId;

    private Date createTime;

    private Date updateTime;

    public Integer getInStockId() {
        return inStockId;
    }

    public void setInStockId(Integer inStockId) {
        this.inStockId = inStockId;
    }

    public String getInStockCode() {
        return inStockCode;
    }

    public void setInStockCode(String inStockCode) {
        this.inStockCode = inStockCode == null ? null : inStockCode.trim();
    }

    public Integer getInStockTotalQuantity() {
        return inStockTotalQuantity;
    }

    public void setInStockTotalQuantity(Integer inStockTotalQuantity) {
        this.inStockTotalQuantity = inStockTotalQuantity;
    }

    public Double getInStockTotalPrice() {
        return inStockTotalPrice;
    }

    public void setInStockTotalPrice(Double inStockTotalPrice) {
        this.inStockTotalPrice = inStockTotalPrice;
    }

    public Integer getInStockStatus() {
        return inStockStatus;
    }

    public void setInStockStatus(Integer inStockStatus) {
        this.inStockStatus = inStockStatus;
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