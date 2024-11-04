package com.fawry.challenge.dummy_data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fawry.challenge.entity.ShippingExpirableProduct;

public class ShippingExpirableProductsDummy {

    public static List<ShippingExpirableProduct> getShippingExpirableProducts() {
        List<ShippingExpirableProduct> products = new ArrayList<>();
        products.add(new ShippingExpirableProduct("Samsung TV", 150.0, 10, 3.0, LocalDate.now().plusDays(10)));
        products.add(new ShippingExpirableProduct("IPhone 15", 300.0, 30, 8.0,LocalDate.now().plusDays(1)));
        return products;
    }

}
