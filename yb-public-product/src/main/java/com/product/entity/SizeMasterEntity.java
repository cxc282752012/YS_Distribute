package com.product.entity;

import java.util.Date;

public class SizeMasterEntity {
    private Integer sizeId;

    private String sizeCode;

    private String sizeName;

    private Integer sizeRank;

    private String sizeGroupName;

    private Integer storeId;

    private String isSystem;

    private Date createTime;

    private Date updateTime;

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeCode() {
        return sizeCode;
    }

    public void setSizeCode(String sizeCode) {
        this.sizeCode = sizeCode == null ? null : sizeCode.trim();
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName == null ? null : sizeName.trim();
    }

    public Integer getSizeRank() {
        return sizeRank;
    }

    public void setSizeRank(Integer sizeRank) {
        this.sizeRank = sizeRank;
    }

    public String getSizeGroupName() {
        return sizeGroupName;
    }

    public void setSizeGroupName(String sizeGroupName) {
        this.sizeGroupName = sizeGroupName == null ? null : sizeGroupName.trim();
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