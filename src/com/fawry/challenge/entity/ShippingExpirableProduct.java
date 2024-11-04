package com.fawry.challenge.entity;

import java.time.LocalDate;

import com.fawry.challenge.custom.Expiration;
import com.fawry.challenge.custom.Shipping;

public class ShippingExpirableProduct extends Product implements Shipping, Expiration {
    private double weight;
    private LocalDate expiryDate;

    public ShippingExpirableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public boolean isExpired() {
        return getExpiryDate().isBefore(LocalDate.now());
    }
}
