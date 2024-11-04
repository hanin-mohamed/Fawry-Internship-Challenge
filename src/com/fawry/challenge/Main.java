package com.fawry.challenge;

import com.fawry.challenge.dummy_data.ExpirableProductsDummy;
import com.fawry.challenge.dummy_data.ProductsDummy;
import com.fawry.challenge.dummy_data.ShippableProductsDummy;
import com.fawry.challenge.dummy_data.ShippingExpirableProductsDummy;
import com.fawry.challenge.entity.Customer;
import com.fawry.challenge.entity.ExpirableProduct;
import com.fawry.challenge.entity.Product;
import com.fawry.challenge.entity.ShippableProduct;
import com.fawry.challenge.entity.ShippingExpirableProduct;
import com.fawry.challenge.process.CheckoutOrder;
import com.fawry.challenge.process.ShoppingCart;

public class Main {

    public static ShoppingCart shoppingCart = new ShoppingCart();
    public static Customer customer = new Customer("Haneen", "Cairo", "0777", 20000.0);

    public static void main(String[] args) {
        createShoppingCartData();
        CheckoutOrder checkoutOrder = new CheckoutOrder(customer, shoppingCart);
        checkoutOrder.startValidateProducts();
        checkoutOrder.checkout();
    }

    private static void createShoppingCartData() {
        for (Product product : ProductsDummy.getProducts()) {
            shoppingCart.addProduct(product, 1);
        }

        for (ShippableProduct product : ShippableProductsDummy.getShippableProducts()) {
            shoppingCart.addProduct(product, 3);
        }

        for (ExpirableProduct product : ExpirableProductsDummy.getExpirableProducts()) {
            shoppingCart.addProduct(product, 10);
        }

        for (ShippingExpirableProduct product : ShippingExpirableProductsDummy.getShippingExpirableProducts()) {
            shoppingCart.addProduct(product, 1);
        }
    }
}