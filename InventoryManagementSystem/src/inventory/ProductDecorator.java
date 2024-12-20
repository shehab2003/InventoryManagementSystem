/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Decorator design pattern: Adding discount to product

package inventory;

abstract class ProductDecorator extends Product {
    protected Product decoratedProduct;

    public ProductDecorator(Product product) {
        super(product.getProductName(), product.getCategoryId(), product.getPrice(), product.getQuantity(), product.getDescription(), product.getSupplier(), product.getDiscountType(), product.getDiscountValue());
        this.decoratedProduct = product;
    }

    public abstract double getPrice();
}

class DiscountedProduct extends ProductDecorator {

    private Discount discount; // Using the new Discount interface

    public DiscountedProduct(Product product, Discount discount) {
        super(product);
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return discount.applyDiscount(decoratedProduct.getPrice());
    }
}

