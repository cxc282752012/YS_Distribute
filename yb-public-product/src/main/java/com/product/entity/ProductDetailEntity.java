package com.product.entity;

import java.util.Date;

public class ProductDetailEntity {
    private Integer productDetailId;

    private Integer productId;

    private String productSku;

    private Integer colorId;

    private Integer sizeId;

    private String productBarcode;

    private Integer productDetailStatus;

    private Double retailPrice;

    private Double lowestPrice;

    private Double memberPrice;

    private Double wholesale;

    private Double websitePrice;

    private Double originalPrice;

    private Double costPrice;

    private Double transfer;

    private Integer storeId;

    private Date createTime;

    private Date updateTime;

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku == null ? null : productSku.trim();
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode == null ? null : productBarcode.trim();
    }

    public Integer getProductDetailStatus() {
        return productDetailStatus;
    }

    public void setProductDetailStatus(Integer productDetailStatus) {
        this.productDetailStatus = productDetailStatus;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public Double getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(Double memberPrice) {
        this.memberPrice = memberPrice;
    }

    public Double getWholesale() {
        return wholesale;
    }

    public void setWholesale(Double wholesale) {
        this.wholesale = wholesale;
    }

    public Double getWebsitePrice() {
        return websitePrice;
    }

    public void setWebsitePrice(Double websitePrice) {
        this.websitePrice = websitePrice;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getTransfer() {
        return transfer;
    }

    public void setTransfer(Double transfer) {
        this.transfer = transfer;
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