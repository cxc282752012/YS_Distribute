package com.product.entity;

import java.util.Date;

public class BrandMasterEntity {
    private Integer brandId;

    private String brandName;

    private String brandShortName;

    private String brandSerchKey;

    private String brandStatus;

    private String isSystem;

    private Integer storeId;

    private Date createTime;

    private Date updateTime;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandShortName() {
        return brandShortName;
    }

    public void setBrandShortName(String brandShortName) {
        this.brandShortName = brandShortName == null ? null : brandShortName.trim();
    }

    public String getBrandSerchKey() {
        return brandSerchKey;
    }

    public void setBrandSerchKey(String brandSerchKey) {
        this.brandSerchKey = brandSerchKey == null ? null : brandSerchKey.trim();
    }

    public String getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(String brandStatus) {
        this.brandStatus = brandStatus == null ? null : brandStatus.trim();
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