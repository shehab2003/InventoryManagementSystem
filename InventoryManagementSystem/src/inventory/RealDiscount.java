/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Proxy Design Pattern
package inventory;

// Interface for discount


// Real discount class that performs actual discount calculation
class RealDiscount implements Discount {
    private double discount;

    public RealDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount(double price) {
        return price * (1 - discount / 100);
    }
}

// Proxy class that controls access to the real discount
class DiscountProxy implements Discount {
    private RealDiscount realDiscount;
    private boolean hasAccess; // Control flag for applying the discount

    public DiscountProxy(double discount, boolean hasAccess) {
        this.realDiscount = new RealDiscount(discount);
        this.hasAccess = hasAccess;
    }

    @Override
    public double applyDiscount(double price) {
        if (hasAccess) {
            System.out.println("Applying discount through proxy...");
            return realDiscount.applyDiscount(price);
        } else {
            System.out.println("Access denied: Discount cannot be applied.");
            return price; // No discount applied if access is denied
        }
    }
}


