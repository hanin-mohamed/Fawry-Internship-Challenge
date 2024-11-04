package com.fawry.challenge.entity;

public class Customer {
    private String name;
    private String address;
    private String phone;
    private double balance;

    public Customer() {
    }

    public Customer(String name, String address, String phone, double balance) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }
}
