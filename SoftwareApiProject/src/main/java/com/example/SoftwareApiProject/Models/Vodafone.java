package com.example.SoftwareApiProject.Models;

import java.util.ArrayList;

public interface Vodafone extends Provider{

    public static ArrayList<User> usersSubscribed = new ArrayList<User>();
    public String getName();

    public double getPrice();

    public ArrayList<User> getArray();

    public String description();
}
