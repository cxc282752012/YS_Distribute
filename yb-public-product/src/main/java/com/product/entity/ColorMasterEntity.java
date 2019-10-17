package com.product.entity;

import java.util.Date;

public class ColorMasterEntity {
    private Integer colorId;

    private String colorCode;

    private String colorName;

    private Integer colorRank;

    private String colorGroupName;

    private Integer storeId;

    private String isSystem;

    private Date createTime;

    private Date updateTime;

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode == null ? null : colorCode.trim();
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName == null ? null : colorName.trim();
    }

    public Integer getColorRank() {
        return colorRank;
    }

    public void setColorRank(Integer colorRank) {
        this.colorRank = colorRank;
    }

    public String getColorGroupName() {
        return colorGroupName;
    }

    public void setColorGroupName(String colorGroupName) {
        this.colorGroupName = colorGroupName == null ? null : colorGroupName.trim();
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