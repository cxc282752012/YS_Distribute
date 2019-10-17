package com.sales.entity;

import java.util.Date;

public class SalesOrderMasterEntity {
    private Integer salesOrderId;

    private String salesOrderCode;

    private Integer customerId;

    private String customerName;

    private Integer storeId;

    private Integer salesStatus;

    private String paymentStyleName;

    private Double paymentPrice;

    private Integer salesQuantity;

    private Integer packageQuantity;

    private Double salesTotalPrice;

    private Integer userId;

    private Integer salesManId;

    private String salesRemake;

    private Date occurrenceTime;

    private Integer printCount;

    private Integer salesType;

    private Integer salesStyle;

    private Double balance;

    private Integer salesPlanId;

    private Date createTime;

    private Date updateTime;

    public Integer getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getSalesOrderCode() {
        return salesOrderCode;
    }

    public void setSalesOrderCode(String salesOrderCode) {
        this.salesOrderCode = salesOrderCode == null ? null : salesOrderCode.trim();
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

    public Integer getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(Integer salesStatus) {
        this.salesStatus = salesStatus;
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

    public Integer getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Integer salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public Double getSalesTotalPrice() {
        return salesTotalPrice;
    }

    public void setSalesTotalPrice(Double salesTotalPrice) {
        this.salesTotalPrice = salesTotalPrice;
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

    public String getSalesRemake() {
        return salesRemake;
    }

    public void setSalesRemake(String salesRemake) {
        this.salesRemake = salesRemake == null ? null : salesRemake.trim();
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

    public Integer getSalesType() {
        return salesType;
    }

    public void setSalesType(Integer salesType) {
        this.salesType = salesType;
    }

    public Integer getSalesStyle() {
        return salesStyle;
    }

    public void setSalesStyle(Integer salesStyle) {
        this.salesStyle = salesStyle;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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