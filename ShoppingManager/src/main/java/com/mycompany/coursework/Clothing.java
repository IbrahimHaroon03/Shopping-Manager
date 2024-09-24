package com.mycompany.coursework;

public class Clothing extends Product {
    private String size;
    private String color;
    
    public Clothing(String productId, String productName, int itemsAvailable, double price, String size, String color) {
        super(productId, productName, itemsAvailable, price);
        this.size = size;
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "CLOTHING PRODUCT INFO -  " 
        + "ID " + getProductID()
        + " | Product Name: " + getProductName()
        + " | Items Available: " + getItemsAvailable()
        + " | Price: " + getPrice()
        + " | Size: " + getSize()
        + " | Color: " + getColor();
    }
}
