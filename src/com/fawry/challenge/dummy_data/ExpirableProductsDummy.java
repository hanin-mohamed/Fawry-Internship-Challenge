package com.fawry.challenge.dummy_data;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fawry.challenge.entity.ExpirableProduct;

public class ExpirableProductsDummy {

    public static List<ExpirableProduct> getExpirableProducts() {
        List<ExpirableProduct> products = new ArrayList<>();
        products.add(new ExpirableProduct("President Cheese", 15.0, 10,LocalDate.now().plusDays(10)));
        products.add(new ExpirableProduct("Americana Burger", 30.0, 10, LocalDate.now().plusDays(1)));
        return products;
    }

}
