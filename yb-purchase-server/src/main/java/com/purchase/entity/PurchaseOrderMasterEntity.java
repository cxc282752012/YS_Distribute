package com.purchase.entity;

import java.util.Date;

public class PurchaseOrderMasterEntity {
    private Integer purchaseId;

    private String purchaseCode;

    private Integer supplierId;

    private Integer storeId;

    private Integer purchaseStatus;

    private Integer paymentStyleName;

    private Double paymentPrice;

    private Integer purchaseQuantity;

    private Integer packageQuantity;

    private Double purchasePrice;

    private Integer userId;

    private String salesManId;

    private String purchaseRemark;

    private Date occurrenceTime;

    private Integer printCount;

    private Integer purchasePlanId;

    private Date createTime;

    private Date updateTime;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseCode() {
        return purchaseCode;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode == null ? null : purchaseCode.trim();
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(Integer purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public Integer getPaymentStyleName() {
        return paymentStyleName;
    }

    public void setPaymentStyleName(Integer paymentStyleName) {
        this.paymentStyleName = paymentStyleName;
    }

    public Double getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(Double paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSalesManId() {
        return salesManId;
    }

    public void setSalesManId(String salesManId) {
        this.salesManId = salesManId == null ? null : salesManId.trim();
    }

    public String getPurchaseRemark() {
        return purchaseRemark;
    }

    public void setPurchaseRemark(String purchaseRemark) {
        this.purchaseRemark = purchaseRemark == null ? null : purchaseRemark.trim();
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }

    public Integer getPurchasePlanId() {
        return purchasePlanId;
    }

    public void setPurchasePlanId(Integer purchasePlanId) {
        this.purchasePlanId = purchasePlanId;
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