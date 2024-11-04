package com.fawry.challenge.dummy_data;

import java.util.ArrayList;
import java.util.List;

import com.fawry.challenge.entity.Product;

public class ProductsDummy {

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Camera LG", 15.0, 10));
        products.add(new Product("Bed", 30.0, 10));
        return products;
    }

}
