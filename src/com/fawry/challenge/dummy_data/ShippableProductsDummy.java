package com.fawry.challenge.dummy_data;

import java.util.ArrayList;
import java.util.List;

import com.fawry.challenge.entity.ShippableProduct;

public class ShippableProductsDummy {

    public static List<ShippableProduct> getShippableProducts() {
        List<ShippableProduct> products = new ArrayList<>();
        products.add(new ShippableProduct("Laptop HP", 135.0, 20, 25.0));
        products.add(new ShippableProduct("FAN Toshiba", 200.0, 10, 10.0));
        return products;
    }

}
