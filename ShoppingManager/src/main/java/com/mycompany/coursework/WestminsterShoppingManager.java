package com.mycompany.coursework;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class WestminsterShoppingManager implements ShoppingManager {
    public static ArrayList<Product> productList;

    public WestminsterShoppingManager() {
        productList = new ArrayList<Product>();
    }
    public static void main(String[] args) {
        ShoppingManager sys = new WestminsterShoppingManager();

        boolean exit = false;

        while (!exit) {
            exit = sys.runMenu();
        }
    }

    public boolean runMenu() {
        boolean exit = false;

        System.out.println("***** Westminster Shopping Manager *****");
        System.out.println("1. Add a new product");
        System.out.println("2. Delete a product");
        System.out.println("3. Print list of products");
        System.out.println("4. Save to file");
        System.out.println("5. Read file");
        System.out.println("6. Open GUI");
        System.out.println("7. Quit");
        
        int optionSelected;
        Scanner x = new Scanner(System.in);

        do {
            System.out.print("\nEnter option: ");
            while (!x.hasNextInt()) {
                String input = x.next();
                System.out.println("Invalid input. Must be an integer between 1 and 7");
                System.out.print("\nEnter option: ");
            }
            optionSelected = x.nextInt();
        } while (!(optionSelected > 0 && optionSelected < 8 ));

        switch (optionSelected) {
            case 1:
                System.out.println();

                if (productList.size() < 50) {
                    addNewProduct();
                } else if (productList.size() > 50) {
                    System.out.println("Maximum number of products reached");
                }
                System.err.println();
                break;

            case 2:
                System.err.println();
                deleteProduct();
                System.err.println();
                break;

            case 3:
                System.err.println();
                printProductList();
                System.err.println();
                break;
                
            case 4:
                System.err.println();
                writeToFile();
                System.err.println();
                break;
            
            case 5:
                System.err.println();
                readFile();
                System.err.println();
                break;

            case 6:
                ShoppingGUI y = new ShoppingGUI();
                y.runGUI();
                break;
                
            case 7:
                exit = true;
                x.close();
                System.out.println("Goodbye!");
                break;
        
            default:
                break;
        }

        return exit;

    }

    public void addNewProduct() {
        System.out.println("***** Add New Product Menu *****");
        Scanner x = new Scanner(System.in);

        String productChoice;

        do {
            System.out.print("Electronic or Clothing Product? (E or C) ");
            productChoice = x.nextLine().toUpperCase(); 
            System.out.println();

            if (!productChoice.matches("[EC]")) {
                System.out.println("Invalid input. Must be the letter E or C");
            }
        } while (!productChoice.matches("[EC]"));

        if (productChoice.equals("E")) {
            System.out.print("Product ID: ");
            String productID = x.nextLine();

            System.out.print("Product Name: ");
            String productName = x.nextLine();

            int itemsAvailable;
            do {
                System.out.print("Items Available: ");
                while (!x.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    System.out.print("Items Available: ");
                    x.next(); 
                }
                itemsAvailable = x.nextInt();
            } while (itemsAvailable < 0);

            double price;
            do {
                System.out.print("Price: ");
                while (!x.hasNextDouble()) {
                    System.out.println("Please enter a valid number.");
                    System.out.print("Price: ");
                    x.next(); // Consume the invalid input
                }
                price = x.nextDouble();
                x.nextLine(); // Consume the newline character
            } while (price < 0);

            System.out.print("Brand Name: ");
            String brandName = x.nextLine();

            double warrantyDuration;

            do {
                System.out.print("Warranty Duration: ");
                while (!x.hasNextDouble()) {
                    System.out.println("Please enter a valid number.");
                    System.out.print("Warranty Duration: ");
                    x.next(); 
                }
                warrantyDuration = x.nextDouble();
                x.nextLine(); 
            } while (warrantyDuration < 0);

            Electronics newProduct = new Electronics(productID, productName, itemsAvailable, price, brandName, warrantyDuration);
            productList.add(newProduct);

        } else if (productChoice.equals("C")) {
            System.out.print("Product ID: ");
            String productID = x.nextLine();

            System.out.print("Product Name: ");
            String productName = x.nextLine();

            int itemsAvailable;
            do {
                System.out.print("Items Available: ");
                while (!x.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    System.out.print("Items Available: ");
                    x.next(); 
                }
                itemsAvailable = x.nextInt();
            } while (itemsAvailable < 0);

            double price;
            do {
                System.out.print("Price: ");
                while (!x.hasNextDouble()) {
                    System.out.println("Please enter a valid number.");
                    System.out.print("Price: ");
                    x.next(); 
                }
                price = x.nextDouble();
                x.nextLine(); 
            } while (price < 0);

            String size;

            do {
                System.out.print("Size: ");
                size = x.nextLine();
            } while (!size.matches("[a-zA-Z]+"));

            String color;
            do {
                System.out.print("Color: ");
                color = x.nextLine();
            } while (!color.matches("[a-zA-Z]+"));

            Clothing newProduct = new Clothing(productID, productName, itemsAvailable, price, size, color);
            productList.add(newProduct);
        }
    }

    public void deleteProduct() {
        System.out.println("***** Delete Product Menu *****");
        Scanner x  = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String productID = x.nextLine();
        System.err.println();

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID().equals(productID)) {
                System.out.println(productList.get(i).toString());
                productList.remove(i);
                System.out.println("TOTAL PRODUCTS LEFT: " + productList.size());
            }
        }
    }

    public void printProductList() {
        Collections.sort(productList);

        for (int i = 0; i < productList.size(); i ++) {
            System.out.println(productList.get(i).toString());
        }
    }

    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter("ProductList.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < productList.size(); i++) {
                bufferedWriter.write(productList.get(i).toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            bufferedWriter.close();

            System.out.println("PRODUCT INFO WRITTEN TO: ProductList.txt");

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader("ProductList.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }


}
