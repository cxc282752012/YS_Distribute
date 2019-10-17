package com.product.entity;

import java.util.Date;
import java.util.List;

public class ProductMasterEntity {
    private Integer productId;

    private String productName;

    private String productSpu;

    private String productShotName;

    private String productSearchKey;

    private String customCode;

    private Integer categoryId;

    private Integer brandsId;

    private Integer unitId;

    private String productBarcode;

    private Double purchasePrice;

    private Double retailPrice;

    private Double lowestPrice;

    private Double memberPrice;

    private Double wholesalePrice;

    private Double websitePrice;

    private Double transferPrice;

    private Integer supplieId;

    private String isMember;

    private String isPromotion;

    private String isIntegral;

    private String isRedeem;

    private String isBargain;

    private String isDiscount;

    private String isGift;

    private Integer productStatus;

    private String seasonName;

    private Date productionTime;

    private String productRemark;

    private Integer storeId;

    private Date createTime;

    private Date updateTime;

    private List<ProductDetailEntity> productDetailList;

    public List<ProductDetailEntity> getProductDetailList() {
        return productDetailList;
    }

    public void setProductDetailList(List<ProductDetailEntity> productDetailList) {
        this.productDetailList = productDetailList;
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

    public String getProductShotName() {
        return productShotName;
    }

    public void setProductShotName(String productShotName) {
        this.productShotName = productShotName == null ? null : productShotName.trim();
    }

    public String getProductSearchKey() {
        return productSearchKey;
    }

    public void setProductSearchKey(String productSearchKey) {
        this.productSearchKey = productSearchKey == null ? null : productSearchKey.trim();
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode == null ? null : customCode.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandsId() {
        return brandsId;
    }

    public void setBrandsId(Integer brandsId) {
        this.brandsId = brandsId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode == null ? null : productBarcode.trim();
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
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

    public Double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(Double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public Double getWebsitePrice() {
        return websitePrice;
    }

    public void setWebsitePrice(Double websitePrice) {
        this.websitePrice = websitePrice;
    }

    public Double getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(Double transferPrice) {
        this.transferPrice = transferPrice;
    }

    public Integer getSupplieId() {
        return supplieId;
    }

    public void setSupplieId(Integer supplieId) {
        this.supplieId = supplieId;
    }

    public String getIsMember() {
        return isMember;
    }

    public void setIsMember(String isMember) {
        this.isMember = isMember == null ? null : isMember.trim();
    }

    public String getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(String isPromotion) {
        this.isPromotion = isPromotion == null ? null : isPromotion.trim();
    }

    public String getIsIntegral() {
        return isIntegral;
    }

    public void setIsIntegral(String isIntegral) {
        this.isIntegral = isIntegral == null ? null : isIntegral.trim();
    }

    public String getIsRedeem() {
        return isRedeem;
    }

    public void setIsRedeem(String isRedeem) {
        this.isRedeem = isRedeem == null ? null : isRedeem.trim();
    }

    public String getIsBargain() {
        return isBargain;
    }

    public void setIsBargain(String isBargain) {
        this.isBargain = isBargain == null ? null : isBargain.trim();
    }

    public String getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(String isDiscount) {
        this.isDiscount = isDiscount == null ? null : isDiscount.trim();
    }

    public String getIsGift() {
        return isGift;
    }

    public void setIsGift(String isGift) {
        this.isGift = isGift == null ? null : isGift.trim();
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName == null ? null : seasonName.trim();
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark == null ? null : productRemark.trim();
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