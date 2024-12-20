/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryGUI {

    private JFrame frame;
    private JTextField productNameField;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextField descriptionField;
    private JTextField supplierField;
    private JComboBox<String> categoryComboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                InventoryGUI window = new InventoryGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public InventoryGUI() {
        initialize();
    }

    private void initialize() {
    // Frame Setup
    frame = new JFrame();
    frame.setBounds(100, 100, 500, 500); // Increased size for new components
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    // Product Name Label and Text Field
    JLabel productNameLabel = new JLabel("Product Name:");
    productNameLabel.setBounds(10, 20, 100, 25);
    frame.getContentPane().add(productNameLabel);
    productNameField = new JTextField();
    productNameField.setBounds(120, 20, 200, 25);
    frame.getContentPane().add(productNameField);
    productNameField.setColumns(10);

    // Price Label and Text Field
    JLabel priceLabel = new JLabel("Price:");
    priceLabel.setBounds(10, 60, 100, 25);
    frame.getContentPane().add(priceLabel);
    priceField = new JTextField();
    priceField.setBounds(120, 60, 200, 25);
    frame.getContentPane().add(priceField);
    priceField.setColumns(10);

    // Quantity Label and Text Field
    JLabel quantityLabel = new JLabel("Quantity:");
    quantityLabel.setBounds(10, 100, 100, 25);
    frame.getContentPane().add(quantityLabel);
    quantityField = new JTextField();
    quantityField.setBounds(120, 100, 200, 25);
    frame.getContentPane().add(quantityField);
    quantityField.setColumns(10);

    // Description Label and Text Field
    JLabel descriptionLabel = new JLabel("Description:");
    descriptionLabel.setBounds(10, 140, 100, 25);
    frame.getContentPane().add(descriptionLabel);
    descriptionField = new JTextField();
    descriptionField.setBounds(120, 140, 200, 25);
    frame.getContentPane().add(descriptionField);
    descriptionField.setColumns(10);

    // Supplier Label and Text Field
    JLabel supplierLabel = new JLabel("Supplier:");
    supplierLabel.setBounds(10, 180, 100, 25);
    frame.getContentPane().add(supplierLabel);
    supplierField = new JTextField();
    supplierField.setBounds(120, 180, 200, 25);
    frame.getContentPane().add(supplierField);
    supplierField.setColumns(10);

    // Category Label and ComboBox
    JLabel categoryLabel = new JLabel("Category:");
    categoryLabel.setBounds(10, 220, 100, 25);
    frame.getContentPane().add(categoryLabel);
    categoryComboBox = new JComboBox<>(new String[] {"Electronics", "Furniture", "Clothing"});
    categoryComboBox.setBounds(120, 220, 200, 25);
    frame.getContentPane().add(categoryComboBox);

    // Discount Type Label and ComboBox
    JLabel discountTypeLabel = new JLabel("Discount Type:");
    discountTypeLabel.setBounds(10, 260, 100, 25);
    frame.getContentPane().add(discountTypeLabel);
    JComboBox<String> discountTypeComboBox = new JComboBox<>(new String[] {"Percentage", "Fixed Amount"});
    discountTypeComboBox.setBounds(120, 260, 200, 25);
    frame.getContentPane().add(discountTypeComboBox);

    // Discount Value Label and TextField
    JLabel discountValueLabel = new JLabel("Discount Value:");
    discountValueLabel.setBounds(10, 300, 100, 25);
    frame.getContentPane().add(discountValueLabel);
    JTextField discountValueField = new JTextField();
    discountValueField.setBounds(120, 300, 200, 25);
    frame.getContentPane().add(discountValueField);

    // Add Product Button
    JButton addButton = new JButton("Add Product");
    addButton.setBounds(120, 340, 200, 30);
    frame.getContentPane().add(addButton);

    // Add ActionListener to Button
    addButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            String name = productNameField.getText();
            int categoryId = categoryComboBox.getSelectedIndex() + 1;
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            String description = descriptionField.getText();
            String supplier = supplierField.getText();
            String discountType = (String) discountTypeComboBox.getSelectedItem();
            double discountValue = Double.parseDouble(discountValueField.getText());

            Product product = new Product(name, categoryId, price, quantity, description, supplier, discountType, discountValue);

            InventoryManager.addProduct(product);

            JOptionPane.showMessageDialog(frame, "Product added successfully with discount!");
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for price, quantity, and discount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

}

// Method to clear input fields after adding a product
private void clearFields() {
    productNameField.setText("");
    priceField.setText("");
    quantityField.setText("");
    descriptionField.setText("");
    supplierField.setText("");
}
}