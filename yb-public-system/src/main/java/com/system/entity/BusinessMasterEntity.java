package com.system.entity;

import java.util.Date;

public class BusinessMasterEntity {
    private Integer businessId;

    private String businessCode;

    private String businessName;

    private String businessAddress;

    private String businessPhone;

    private String businessMail;

    private String businessLinkman;

    private String businessPassword;

    private String businessWebsiteUrl;

    private String businessImageUrl;

    private Integer businessStatus;

    private String businessRemark;

    private Date createTime;

    private Date updateTime;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode == null ? null : businessCode.trim();
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress == null ? null : businessAddress.trim();
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone == null ? null : businessPhone.trim();
    }

    public String getBusinessMail() {
        return businessMail;
    }

    public void setBusinessMail(String businessMail) {
        this.businessMail = businessMail == null ? null : businessMail.trim();
    }

    public String getBusinessLinkman() {
        return businessLinkman;
    }

    public void setBusinessLinkman(String businessLinkman) {
        this.businessLinkman = businessLinkman == null ? null : businessLinkman.trim();
    }

    public String getBusinessPassword() {
        return businessPassword;
    }

    public void setBusinessPassword(String businessPassword) {
        this.businessPassword = businessPassword == null ? null : businessPassword.trim();
    }

    public String getBusinessWebsiteUrl() {
        return businessWebsiteUrl;
    }

    public void setBusinessWebsiteUrl(String businessWebsiteUrl) {
        this.businessWebsiteUrl = businessWebsiteUrl == null ? null : businessWebsiteUrl.trim();
    }

    public String getBusinessImageUrl() {
        return businessImageUrl;
    }

    public void setBusinessImageUrl(String businessImageUrl) {
        this.businessImageUrl = businessImageUrl == null ? null : businessImageUrl.trim();
    }

    public Integer getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(Integer businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getBusinessRemark() {
        return businessRemark;
    }

    public void setBusinessRemark(String businessRemark) {
        this.businessRemark = businessRemark == null ? null : businessRemark.trim();
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