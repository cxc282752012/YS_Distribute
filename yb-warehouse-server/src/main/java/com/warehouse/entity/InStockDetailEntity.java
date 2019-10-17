package com.warehouse.entity;

import java.util.Date;

public class InStockDetailEntity {
    private Integer inStockDetailId;

    private Integer inStockId;

    private Integer productId;

    private String productSpu;

    private String productName;

    private String productSku;

    private String colorName;

    private String sizeName;

    private Integer productQuantity;

    private Double productPrice;

    private Double productTotalPrice;

    private Date createTime;

    private Date updateTime;

    public Integer getInStockDetailId() {
        return inStockDetailId;
    }

    public void setInStockDetailId(Integer inStockDetailId) {
        this.inStockDetailId = inStockDetailId;
    }

    public Integer getInStockId() {
        return inStockId;
    }

    public void setInStockId(Integer inStockId) {
        this.inStockId = inStockId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductSpu() {
        return productSpu;
    }

    public void setProductSpu(String productSpu) {
        this.productSpu = productSpu == null ? null : productSpu.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
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