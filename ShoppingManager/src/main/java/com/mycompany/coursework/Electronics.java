package com.mycompany.coursework;

public class Electronics extends Product {
    private String brandName;
    private double warrantyDuration;

    public Electronics (String productId, String productName, int itemsAvailable, double price, String brandName, double warrantyDuration) {
        super(productId, productName, itemsAvailable, price);
        this.brandName = brandName;
        this.warrantyDuration = warrantyDuration;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setWarrantyDuration(double warrantyDuration) {
        this.warrantyDuration = warrantyDuration;
    }

    public String getBrandName() {
        return brandName;
    }

    public double getWarrantyDuration() {
        return warrantyDuration;
    }

    public String toString() {
        return "ELECTRONIC PRODUCT INFO - " 
        + "ID " + getProductID()
        + " | Product Name: " + getProductName()
        + " | Items Available: " + getItemsAvailable()
        + " | Price: " + getPrice()
        + " | Brand Name: " + getBrandName()
        + " | Warranty Duration: " + getWarrantyDuration();
    }
}
