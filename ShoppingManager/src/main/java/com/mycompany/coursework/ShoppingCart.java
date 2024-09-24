package com.mycompany.coursework;
import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
    ArrayList<Product> productList = new ArrayList<Product>();

    public void addProduct(Product product) {
       productList.add(product);
    }

    public void removeProduct(String removedProduct) {
        Iterator<Product> iterator = productList.iterator();
    
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getProductID().equals(removedProduct)) {
                iterator.remove();
                break;
            }
        }
    }

    public void calculateTotalCost() {
        double totalCost = 0;
        Iterator<Product> iterator = productList.iterator();
        
        while (iterator.hasNext()) {
            Product p = iterator.next();
            totalCost += p.getPrice();
        }
    }
}
