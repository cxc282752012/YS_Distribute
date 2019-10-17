package com.sales.entity;

import java.util.Date;

public class SalesPlanMasterEntity {
    private Integer salesPlanId;

    private String salesPlanCode;

    private Integer customerId;

    private String customerName;

    private Integer storeId;

    private Integer salesPlanStatus;

    private String paymentStyleName;

    private Double paymentPrice;

    private Integer salesPlanQuantity;

    private Integer packageQuantity;

    private Double salesPlanTotalPrice;

    private Integer userId;

    private Integer salesManId;

    private String salesPlanRemake;

    private Date occurrenceTime;

    private Integer printCount;

    private Integer salesPlanType;

    private Integer salesPlanStyle;

    private Date createTime;

    private Date updateTime;

    public Integer getSalesPlanId() {
        return salesPlanId;
    }

    public void setSalesPlanId(Integer salesPlanId) {
        this.salesPlanId = salesPlanId;
    }

    public String getSalesPlanCode() {
        return salesPlanCode;
    }

    public void setSalesPlanCode(String salesPlanCode) {
        this.salesPlanCode = salesPlanCode == null ? null : salesPlanCode.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getSalesPlanStatus() {
        return salesPlanStatus;
    }

    public void setSalesPlanStatus(Integer salesPlanStatus) {
        this.salesPlanStatus = salesPlanStatus;
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

    public Integer getSalesPlanQuantity() {
        return salesPlanQuantity;
    }

    public void setSalesPlanQuantity(Integer salesPlanQuantity) {
        this.salesPlanQuantity = salesPlanQuantity;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public Double getSalesPlanTotalPrice() {
        return salesPlanTotalPrice;
    }

    public void setSalesPlanTotalPrice(Double salesPlanTotalPrice) {
        this.salesPlanTotalPrice = salesPlanTotalPrice;
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

    public String getSalesPlanRemake() {
        return salesPlanRemake;
    }

    public void setSalesPlanRemake(String salesPlanRemake) {
        this.salesPlanRemake = salesPlanRemake == null ? null : salesPlanRemake.trim();
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

    public Integer getSalesPlanType() {
        return salesPlanType;
    }

    public void setSalesPlanType(Integer salesPlanType) {
        this.salesPlanType = salesPlanType;
    }

    public Integer getSalesPlanStyle() {
        return salesPlanStyle;
    }

    public void setSalesPlanStyle(Integer salesPlanStyle) {
        this.salesPlanStyle = salesPlanStyle;
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