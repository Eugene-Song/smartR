package com.eugene.eugeneblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class ProductDimension {
    private Integer productID;
    private String productName;
    private Integer productGroupID;
    private String productGroupName;
    private String salesStatus;
    private Integer productDeveloperID;
    private String productDeveloper;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date listingDate;

    private Integer productMarketID;
    private Integer marketUniqueID;
    private Integer supplierID;
    private Integer shopID;

    // getters and setters for each of the properties...
    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductGroupID() {
        return productGroupID;
    }

    public void setProductGroupID(Integer productGroupID) {
        this.productGroupID = productGroupID;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public Integer getProductDeveloperID() {
        return productDeveloperID;
    }

    public void setProductDeveloperID(Integer productDeveloperID) {
        this.productDeveloperID = productDeveloperID;
    }

    public String getProductDeveloper() {
        return productDeveloper;
    }

    public void setProductDeveloper(String productDeveloper) {
        this.productDeveloper = productDeveloper;
    }

    public Date getListingDate() {
        return listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    public Integer getProductMarketID() {
        return productMarketID;
    }

    public void setProductMarketID(Integer productMarketID) {
        this.productMarketID = productMarketID;
    }

    public Integer getMarketUniqueID() {
        return marketUniqueID;
    }

    public void setMarketUniqueID(Integer marketUniqueID) {
        this.marketUniqueID = marketUniqueID;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Integer getShopID() {
        return shopID;
    }

    public void setShopID(Integer shopID) {
        this.shopID = shopID;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productID=").append(productID);
        sb.append(", productName=").append(productName);
        sb.append(", productGroupID=").append(productGroupID);
        sb.append(", productGroupName=").append(productGroupName);
        sb.append(", salesStatus=").append(salesStatus);
        sb.append(", productDeveloperID=").append(productDeveloperID);
        sb.append(", productDeveloper=").append(productDeveloper);
        sb.append(", listingDate=").append(listingDate);
        sb.append(", productMarketID=").append(productMarketID);
        sb.append(", marketUniqueID=").append(marketUniqueID);
        sb.append(", supplierID=").append(supplierID);
        sb.append(", shopID=").append(shopID);
        sb.append("]");
        return sb.toString();
    }
}
