package com.mycompany.coursework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ShoppingGUI {
    private static JFrame frame;
    private static JTable productTable;
    private static JComboBox<String> dropDownMenu;
    private static JTable shoppingCartTable;
    private static JPanel topPanel;
    private static JLabel totalLabel;
    private static JLabel categoryDiscountLabel;
    private static JLabel finalTotalLabel;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> runGUI());
    }

    public static void runGUI() {
        frame = new JFrame("Westminster Shopping Centre");
        frame.setSize(1000, 500);
        frame.setLayout(new BorderLayout()); // Change layout to BorderLayout
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, frame.getBackground()));

        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // New top panel
        dropDownMenu();
        addShoppingCartButton();
        topPanel.add(dropDownMenu);
        topPanel.add(new JLabel("   ")); // Add some space between drop-down and button
        topPanel.add(addShoppingCartButton());

        frame.add(topPanel, BorderLayout.NORTH); // Add top panel to NORTH position

        productTable();
        selectedProductDetails();

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void dropDownMenu() {
        JLabel label = new JLabel("Select Product Category");
        String[] category = {"All", "Electronics", "Clothing"};
        dropDownMenu = new JComboBox<>(category);

        dropDownMenu.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateTable();
            }
        });

        topPanel.add(label);
        topPanel.add(dropDownMenu);
    }

    public static void productTable() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        String[] columnNames = {"Product ID", "Name", "Category", "Price", "Info"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(tableModel);

        productTable.setGridColor(Color.BLACK);
        productTable.setShowGrid(true);
        productTable.setShowVerticalLines(true);

        productTable.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(productTable);

        panel.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.CENTER);

        ArrayList<Product> productList2 = new ArrayList<>(WestminsterShoppingManager.productList);

        for (int i = 0; i < productList2.size(); i++) {
            if (productList2.get(i) instanceof Electronics) {
                Electronics electronicProduct = (Electronics) productList2.get(i);

                String eID = electronicProduct.getProductID();
                String eName = electronicProduct.getProductName();
                String eCategory = "Electronics";
                double ePrice = electronicProduct.getPrice();
                String eBrandName = electronicProduct.getBrandName();
                double eWarranty = electronicProduct.getWarrantyDuration();
                String eInfo = eBrandName + ", " + eWarranty + " weeks warranty";
                int itemsAvailable = electronicProduct.getItemsAvailable();

                tableModel.addRow(new Object[]{eID, eName, eCategory, ePrice, eInfo});

            } else if (productList2.get(i) instanceof Clothing) {
                Clothing clothingProduct = (Clothing) productList2.get(i);

                String cID = clothingProduct.getProductID();
                String cName = clothingProduct.getProductName();
                String cCategory = "Clothing";
                double cPrice = clothingProduct.getPrice();
                String cSize = clothingProduct.getSize();
                String cColor = clothingProduct.getColor();
                String cInfo = cSize + ", " + cColor;
                int itemsAvailable = clothingProduct.getItemsAvailable();

                tableModel.addRow(new Object[]{cID, cName, cCategory, cPrice, cInfo});
            }
        }

        ListSelectionModel selectionModel = productTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    updateSelectedProductDetails();
                }
            }
        });

        updateTable();
    }

    public static void updateTable() {
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
        tableModel.setRowCount(0);  // Clear the table

        ArrayList<Product> productList2 = new ArrayList<>(WestminsterShoppingManager.productList);

        String selectedCategory = (String) dropDownMenu.getSelectedItem();

        for (int i = 0; i < productList2.size(); i++) {
            Product product = productList2.get(i);

            if (selectedCategory.equals("All") || (selectedCategory.equals("Electronics") && product instanceof Electronics)
                    || (selectedCategory.equals("Clothing") && product instanceof Clothing)) {

                String productID = product.getProductID();
                String productName = product.getProductName();
                String productCategory = (product instanceof Electronics) ? "Electronics" : "Clothing";
                double productPrice = product.getPrice();
                String productInfo = getProductInfo(product);

                tableModel.addRow(new Object[]{productID, productName, productCategory, productPrice, productInfo});
            }
        }
    }

    private static String getProductInfo(Product product) {
        if (product instanceof Electronics) {
            Electronics electronicProduct = (Electronics) product;
            return electronicProduct.getBrandName() + ", " + electronicProduct.getWarrantyDuration() + " weeks warranty";
        } else if (product instanceof Clothing) {
            Clothing clothingProduct = (Clothing) product;
            return clothingProduct.getSize() + ", " + clothingProduct.getColor();
        }
        return ""; 
    }

    public static void selectedProductDetails() {
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
    
        detailsPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        JLabel titleLabel = new JLabel("Selected Product - Details");
        detailsPanel.add(titleLabel);
    
        detailsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        JButton addToCartButton = createAddToCartButton();
        detailsPanel.add(addToCartButton);

        frame.add(detailsPanel, BorderLayout.SOUTH);
    }
    
    private static void updateSelectedProductDetails() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            String productID = (String) productTable.getValueAt(selectedRow, 0);
            String productName = (String) productTable.getValueAt(selectedRow, 1);
            String productCategory = (String) productTable.getValueAt(selectedRow, 2);
            double productPrice = (double) productTable.getValueAt(selectedRow, 3);
            String productInfo = (String) productTable.getValueAt(selectedRow, 4);
    
            // Update the details panel with the selected product's information
            JPanel detailsPanel = (JPanel) frame.getContentPane().getComponent(2);
            detailsPanel.removeAll();
    
            JLabel titleLabel = new JLabel("Selected Product - Details");
            detailsPanel.add(titleLabel);
    
            JLabel idLabel = new JLabel("ID: " + productID);
            JLabel nameLabel = new JLabel("Name: " + productName);
            JLabel categoryLabel = new JLabel("Category: " + productCategory);
            JLabel priceLabel = new JLabel("Price: " + productPrice);
            JLabel infoLabel = new JLabel("Info: " + productInfo);
    
            detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            detailsPanel.add(idLabel);
            detailsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between details
            detailsPanel.add(nameLabel);
            detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            detailsPanel.add(categoryLabel);
            detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            detailsPanel.add(priceLabel);
            detailsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            detailsPanel.add(infoLabel);
    
            detailsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            JButton addToCartButton = createAddToCartButton();
            detailsPanel.add(addToCartButton);

            frame.revalidate();
            frame.repaint();
        }
    }
    
    public static JButton addShoppingCartButton() {
        JButton shoppingCartButton = new JButton("Shopping Cart");
        shoppingCartButton.addActionListener(e -> openShoppingCart()); // Add ActionListener
        return shoppingCartButton;
    }
    
    public static void openShoppingCart() {
        JFrame cartFrame = new JFrame("Shopping Cart");
        cartFrame.setSize(400, 400);
    
        JPanel cartPanel = new JPanel(new BorderLayout());
    
        // Initialize the shoppingCartTable only once
        String[] cartColumnNames = {"Product", "Quantity", "Price"};
        DefaultTableModel cartTableModel = new DefaultTableModel(cartColumnNames, 0);
        shoppingCartTable = new JTable(cartTableModel);
    
        JScrollPane cartScrollPane = new JScrollPane(shoppingCartTable);
    
        // Add labels for total, category discount, and final total
        totalLabel = new JLabel("Total: £0.00");
        categoryDiscountLabel = new JLabel("Category Discount: £0.00");
        finalTotalLabel = new JLabel("Final Total: £0.00");
    
        JPanel labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        labelsPanel.add(totalLabel);
        labelsPanel.add(categoryDiscountLabel);
        labelsPanel.add(finalTotalLabel);
    
        cartPanel.add(cartScrollPane, BorderLayout.CENTER);
        cartPanel.add(labelsPanel, BorderLayout.SOUTH);
        cartFrame.add(cartPanel);
    
        cartFrame.setVisible(true);
    }

    public static JButton createAddToCartButton() {
        JButton addToCartButton = new JButton("Add to Shopping Cart");
        addToCartButton.addActionListener(e -> addToShoppingCart());
        return addToCartButton;
    }

    private static void addToShoppingCart() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            String productId = (String) productTable.getValueAt(selectedRow, 0);
            String productName = (String) productTable.getValueAt(selectedRow, 1);
            String productInfo = (String) productTable.getValueAt(selectedRow, 4);
            int column2 = 0;
    
            ArrayList<Product> productList3 = new ArrayList<>(WestminsterShoppingManager.productList);
    
            for (int i = 0; i < productList3.size(); i++) {
                if (productId.equals(productList3.get(i).getProductID())) {
                    column2 = productList3.get(i).getItemsAvailable();
                }
            }
    
            String column1 = productId + "\n" + productName + "\n" + productInfo;
            double productPrice = Double.parseDouble(productTable.getValueAt(selectedRow, 3).toString());
    
            // Check if shoppingCartTable is null and initialize it if needed
            if (shoppingCartTable == null) {
                openShoppingCart();
            }
    
            // Get the existing table model and add a new row
            DefaultTableModel cartTableModel = (DefaultTableModel) shoppingCartTable.getModel();
            cartTableModel.addRow(new Object[]{column1, column2, productPrice});
    
            // Calculate final price and apply discounts
            calculateFinalPriceAndApplyDiscount(cartTableModel);
        }
    }

    private static void calculateFinalPriceAndApplyDiscount(DefaultTableModel cartTableModel) {
        int rowCount = cartTableModel.getRowCount();
    
        // Count the number of products in each category
        int electronicsCount = 0;
        int clothingCount = 0;
    
        double total = 0.0;
    
        for (int i = 0; i < rowCount; i++) {
            String productCategory = ((String) cartTableModel.getValueAt(i, 0)).split("\n")[2].trim();
            double productPrice = (double) cartTableModel.getValueAt(i, 2);
            total += productPrice;
    
            if ("Electronics".equals(productCategory)) {
                electronicsCount++;
            } else if ("Clothing".equals(productCategory)) {
                clothingCount++;
            }
        }
    
        // Update the total label
        totalLabel.setText("Total: £" + String.format("%.2f", total));
    
        // Check if discounts apply
        double categoryDiscount = 0.0;
    
        if (electronicsCount >= 3) {
            categoryDiscount += applyDiscount(cartTableModel, "Electronics");
        }
        if (clothingCount >= 3) {
            categoryDiscount += applyDiscount(cartTableModel, "Clothing");
        }
    
        // Calculate the final total and update the label
        double finalTotal = total - categoryDiscount;
        finalTotalLabel.setText("Final Total: £" + String.format("%.2f", finalTotal));
    
        // Update the category discount label
        categoryDiscountLabel.setText("Category Discount: £" + String.format("%.2f", categoryDiscount));
    }
     
    private static double applyDiscount(DefaultTableModel cartTableModel, String category) {
        double discountPercentage = 20.0; // 20% discount
        double categoryDiscount = 0.0;
    
        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            String productId = ((String) cartTableModel.getValueAt(i, 0)).split("\n")[0];
            String productCategory = getProductCategoryFromTable(productId);
            if (category.equals(productCategory)) {
                double originalPrice = (double) cartTableModel.getValueAt(i, 2);
                double discountedPrice = originalPrice - (originalPrice * (discountPercentage / 100.0));
                cartTableModel.setValueAt(discountedPrice, i, 2);
                categoryDiscount += originalPrice - discountedPrice;
            }
        }
    
        // Display a message about the discount
        JOptionPane.showMessageDialog(frame, "Discount applied: " + discountPercentage + "% for " + category + " products.\nFinal cost updated.");
    
        return categoryDiscount;
    }

    private static String getProductCategoryFromTable(String productId) {
        DefaultTableModel productTableModel = (DefaultTableModel) productTable.getModel();
        for (int row = 0; row < productTableModel.getRowCount(); row++) {
            String tableProductId = (String) productTableModel.getValueAt(row, 0);
            if (productId.equals(tableProductId)) {
                return (String) productTableModel.getValueAt(row, 2); // Assuming category is at index 2
            }
        }
        return ""; // Return an empty string if not found (you may handle this case differently)
    }

}





