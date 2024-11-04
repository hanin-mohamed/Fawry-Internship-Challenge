package com.fawry.challenge.process;

import java.util.HashMap;
import java.util.Map;

import com.fawry.challenge.entity.*;

public class CheckoutOrder {

    private Customer customer;
    private ShoppingCart shoppingCart;

    public CheckoutOrder(final Customer customer, final ShoppingCart shoppingCart) {
        this.customer = customer;
        this.shoppingCart = shoppingCart;
    }

    public void startValidateProducts() {
        ValidateShoppingCartAvailability();
        validateProductsQuantity();
        validateProductsExpiration();
        validateCustomerBalance();
    }
    private void ValidateShoppingCartAvailability() {
        if (shoppingCart == null || shoppingCart.getProducts().isEmpty())
            throw new RuntimeException("Shopping cart is empty");
        int totalQuantity=0;
        for (Map.Entry<Product, Integer> entry : shoppingCart.getProducts().entrySet()) {
            totalQuantity += entry.getValue();
        }
        if (totalQuantity == 0)
            throw new RuntimeException("Shopping cart is empty");
    }

    private void validateProductsQuantity(){
        Map<Product, Integer> products = shoppingCart.getProducts();
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product.getQuantity() < quantity)
                throw new RuntimeException("You can't buy more than the available quantity");
        }
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            int quantity = entry.getValue();
            if (quantity==0)
                throw new RuntimeException("Product quantity must be greater than zero");
        }
    }

    private void validateProductsExpiration(){
        Map<Product, Integer> products = shoppingCart.getProducts();
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            if ((product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired() )||(product instanceof ShippingExpirableProduct && ((ShippingExpirableProduct) product).isExpired())) {
                throw new RuntimeException("This product is expired");
            }
        }
    }

    private void validateCustomerBalance(){
        double totalCost = shoppingCart.calculateSubTotal() + shoppingCart.calcTotalShippingFees();
        if (totalCost > customer.getBalance()){
            throw new RuntimeException(" You don't have enough money in your balance");
        }
    }

    Map<ShippableProduct, Integer> shippableProducts = new HashMap<>();

    public void checkout() {
        Double totalCost = shoppingCart.calculateSubTotal();
        double totalRequired = totalCost + shoppingCart.calcTotalShippingFees();
        customer.setBalance(totalCost);

        for (Map.Entry<Product, Integer> entry : shoppingCart.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.setQuantity(product.getQuantity() - quantity);

            if (product instanceof ShippableProduct) {
                shippableProducts.put((ShippableProduct) product, quantity);
            }
        }

        ShippingService shippingService = new ShippingService();
        shippingService.shippingReport(shippableProducts);

        System.out.println("\n\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : shoppingCart.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(quantity + "x " + product.getName() + "        " + product.getPrice() * quantity);
        }
        System.out.println("-------------------");
        System.out.println("Subtotal         " + shoppingCart.calculateSubTotal());
        System.out.println("Shipping         " + shoppingCart.calcTotalShippingFees());
        System.out.println("Total            " + totalRequired);
    }
}

