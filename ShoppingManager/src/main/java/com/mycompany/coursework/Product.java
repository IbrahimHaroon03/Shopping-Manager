package com.mycompany.coursework;

public abstract class Product implements Comparable<Product> {
    protected String productID;
    protected String productName;
    protected int itemsAvailable;
    protected double price;

    public Product(String productId, String productName, int itemsAvailable, double price) {
        this.productID = productId;
        this.productName = productName;
        this.itemsAvailable = itemsAvailable;
        this.price = price;
    }

    public void setProductID(String productId) {
        this.productID = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setItemsAvailable(int itemsAvailable) {
        this.itemsAvailable = itemsAvailable;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getItemsAvailable() {
        return itemsAvailable;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "PRODUCT INFO\n" 
        + "\n| ID: " + getProductID()
        + "\n| Product Name: " + getProductName()
        + "\n| Items Available: " + getItemsAvailable()
        + "\n| Price: " + getPrice();
    }

    public int compareTo(Product otherProduct) {
        return this.productID.compareTo(otherProduct.getProductID());
    }
}
