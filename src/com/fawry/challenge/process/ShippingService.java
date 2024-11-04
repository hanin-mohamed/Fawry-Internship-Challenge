package com.fawry.challenge.process;

import com.fawry.challenge.entity.Product;
import com.fawry.challenge.entity.ShippableProduct;

import java.util.Map;

public class ShippingService {

    public void shippingReport(Map<ShippableProduct, Integer> shoppingCart) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;

        for (Map.Entry<ShippableProduct, Integer> entry : shoppingCart.entrySet()) {
            ShippableProduct product = entry.getKey();
            int quantity = entry.getValue();
            double productWeight = product.getWeight() * quantity;
            totalWeight += productWeight;
            System.out.println(quantity + "x " + product.getName() + "        " + productWeight + "kg");
        }
        System.out.println("Total package weight " + totalWeight + "kg");
    }

}
