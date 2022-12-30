package com.example.SoftwareApiProject.Models;

import java.util.ArrayList;

public interface Services {

    public abstract double pay();

    public String getName();

    public double getPrice();
    public double getDiscountPercentage();
    public void setDiscountPercentage(double discountPercentage);

    public ArrayList<User> getArray();

    public String description();

    void setPayment(Payment payMethod);
}
