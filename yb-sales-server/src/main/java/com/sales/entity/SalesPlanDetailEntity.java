package com.sales.entity;

import java.util.Date;

public class SalesPlanDetailEntity {
    private Integer salesPlanDetailId;

    private Integer salesPlanId;

    private Integer productId;

    private String productName;

    private String productSpu;

    private String customCode;

    private Integer productDetailId;

    private String productSku;

    private String colorName;

    private String sizeName;

    private String productBarcode;

    private Integer productQuantity;

    private Integer planPackageQuantity;

    private Double productPrice;

    private Double productTotalPrice;

    private Double productDiscount;

    private Integer storeId;

    private String salesPlanDetailRemake;

    private Date createTime;

    private Date updateTime;

    public Integer getSalesPlanDetailId() {
        return salesPlanDetailId;
    }

    public void setSalesPlanDetailId(Integer salesPlanDetailId) {
        this.salesPlanDetailId = salesPlanDetailId;
    }

    public Integer getSalesPlanId() {
        return salesPlanId;
    }

    public void setSalesPlanId(Integer salesPlanId) {
        this.salesPlanId = salesPlanId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductSpu() {
        return productSpu;
    }

    public void setProductSpu(String productSpu) {
        this.productSpu = productSpu == null ? null : productSpu.trim();
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode == null ? null : customCode.trim();
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku == null ? null : productSku.trim();
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName == null ? null : colorName.trim();
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName == null ? null : sizeName.trim();
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode == null ? null : productBarcode.trim();
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getPlanPackageQuantity() {
        return planPackageQuantity;
    }

    public void setPlanPackageQuantity(Integer planPackageQuantity) {
        this.planPackageQuantity = planPackageQuantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(Double productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public Double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(Double productDiscount) {
        this.productDiscount = productDiscount;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getSalesPlanDetailRemake() {
        return salesPlanDetailRemake;
    }

    public void setSalesPlanDetailRemake(String salesPlanDetailRemake) {
        this.salesPlanDetailRemake = salesPlanDetailRemake == null ? null : salesPlanDetailRemake.trim();
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