package com.fawry.challenge.entity;

import com.fawry.challenge.custom.Shipping;

public class ShippableProduct extends Product implements Shipping {

    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
