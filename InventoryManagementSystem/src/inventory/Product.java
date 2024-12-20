package inventory;

import java.util.List;
import java.util.ArrayList;



/**
 * Represents a product in the inventory system. Implements the Observer design
 * pattern to notify observers when the stock quantity changes.
 */
public class Product implements Subject {

    // Product attributes
    private String productName;
    private int categoryId;
    private double price;
    private int quantity;
    private String description;
    private String supplier;
    private String discountType;
    private double discountValue;
    
    // List to store observers
    private List<Observer> observers = new ArrayList<>();
    


    public Product(String productName, int categoryId, double price, int quantity, String description, String supplier, String discountType, double discountValue) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.supplier = supplier;
        this.discountType = discountType;
        this.discountValue = discountValue;
    }
    
    
    // Subject interface methods
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    // Getters for product attributes
    /**
     * @return The product's name.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @return The category ID of the product.
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return The quantity of the product in stock.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return The description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The supplier's name.
     */
    public String getSupplier() {
        return supplier;
    }

    public String getDiscountType() {
        return discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }

   
    public void setQuantity(int quantity) {
        this.quantity = quantity;

    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

}
