/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

/**
 *
 * @author Nima
 */
public class InventoryObserver implements Observer {
   
    @Override
    public void update(Product product) {
        System.out.println("Product Updated: " + product.getProductName());
        System.out.println("New Quantity: " + product.getQuantity());
        System.out.println("New Discount Value: " + product.getDiscountValue());
}
}
