/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryManager {

    // Add product to the database
    public static void addProduct(Product product) {
        Connection con = ConnectionProvider.getCon();
        PreparedStatement pst = null;

        try {
            String query = "INSERT INTO products (productName, CategoryID, Price, Quantity, Description, Supplier, discount_type, discount_value) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, product.getProductName());
            pst.setInt(2, product.getCategoryId());
            pst.setDouble(3, product.getPrice());
            pst.setInt(4, product.getQuantity());
            pst.setString(5, product.getDescription());
            pst.setString(6, product.getSupplier());
            pst.setString(7, product.getDiscountType());
            pst.setDouble(8, product.getDiscountValue());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product added successfully with discount!");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting product: " + e.getMessage());
        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}

