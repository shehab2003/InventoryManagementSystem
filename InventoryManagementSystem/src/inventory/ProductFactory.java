package inventory;

// Factory design pattern: A method to create a new product instance
public class ProductFactory {
    
    public static Product createProduct(String name, int categoryId, double price, int quantity, String description, String supplier, String discountType , double discountValue) {
        return new Product(name, categoryId, price, quantity, description, supplier,discountType ,discountValue);
    }
}
