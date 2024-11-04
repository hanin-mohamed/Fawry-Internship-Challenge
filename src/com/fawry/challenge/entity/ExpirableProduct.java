package com.fawry.challenge.entity;


import java.time.LocalDate;
import java.util.Date;

import com.fawry.challenge.custom.Expiration;

public class ExpirableProduct extends Product implements Expiration {

    private LocalDate expiryDate;


    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
