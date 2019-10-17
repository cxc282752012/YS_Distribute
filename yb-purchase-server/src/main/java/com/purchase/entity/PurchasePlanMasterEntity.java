package com.purchase.entity;

import java.util.Date;

public class PurchasePlanMasterEntity {
    private Integer purchasePlanId;

    private String planCode;

    private Integer supplierId;

    private Integer storeId;

    private Integer planStatus;

    private String paymentStyleName;

    private Double paymentPrice;

    private Integer planQuantity;

    private Integer packageQuantity;

    private Double planTotalPrice;

    private Integer userId;

    private Integer salesManId;

    private String planRemark;

    private Date occurrenceTime;

    private Integer printCount;

    private Integer salesPlanId;

    private Date createTime;

    private Date updateTime;

    public Integer getPurchasePlanId() {
        return purchasePlanId;
    }

    public void setPurchasePlanId(Integer purchasePlanId) {
        this.purchasePlanId = purchasePlanId;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode == null ? null : planCode.trim();
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

    public Integer getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    public String getPaymentStyleName() {
        return paymentStyleName;
    }

    public void setPaymentStyleName(String paymentStyleName) {
        this.paymentStyleName = paymentStyleName == null ? null : paymentStyleName.trim();
    }

    public Double getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(Double paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public Integer getPlanQuantity() {
        return planQuantity;
    }

    public void setPlanQuantity(Integer planQuantity) {
        this.planQuantity = planQuantity;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public Double getPlanTotalPrice() {
        return planTotalPrice;
    }

    public void setPlanTotalPrice(Double planTotalPrice) {
        this.planTotalPrice = planTotalPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSalesManId() {
        return salesManId;
    }

    public void setSalesManId(Integer salesManId) {
        this.salesManId = salesManId;
    }

    public String getPlanRemark() {
        return planRemark;
    }

    public void setPlanRemark(String planRemark) {
        this.planRemark = planRemark == null ? null : planRemark.trim();
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

    public Integer getSalesPlanId() {
        return salesPlanId;
    }

    public void setSalesPlanId(Integer salesPlanId) {
        this.salesPlanId = salesPlanId;
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