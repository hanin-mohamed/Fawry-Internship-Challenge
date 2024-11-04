package com.fawry.challenge.process;

import java.util.HashMap;
import java.util.Map;

import com.fawry.challenge.entity.ExpirableProduct;
import com.fawry.challenge.entity.Product;
import com.fawry.challenge.entity.ShippableProduct;
import com.fawry.challenge.entity.ShippingExpirableProduct;

public class ShoppingCart {

    private Map<Product, Integer> products;
    private Double shippingFees;

    public ShoppingCart() {
        products = new HashMap<>();
    }

    public Map<Product, Integer> getProducts() {
        return this.products;
    }

    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new RuntimeException("You can't buy more than the available quantity");
        }
        if ((product instanceof ExpirableProduct && ((ExpirableProduct) product).isExpired()) || (product instanceof ShippingExpirableProduct && ((ShippingExpirableProduct) product).isExpired())) {
            throw new RuntimeException("Product is expired");
        }

        products.put(product, quantity);
    }

    public Double calculateSubTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            total += (entry.getKey().getPrice() * entry.getValue());
        }
        return total;
    }

    public Double calculateTotalWeight() {
        double totalWeight = 0;

        if (products.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            if (product instanceof ShippableProduct)
                totalWeight += ((ShippableProduct) product).getWeight()*entry.getValue();
        }
        return totalWeight;
    }

    public Double calcTotalShippingFees() {
        return this.shippingFees = calculateTotalWeight() * 3;
    }
//    public Double calculateTotalCost() {
//        return calculateSubTotal() + calcTotalShippingFees();
//    }
}
