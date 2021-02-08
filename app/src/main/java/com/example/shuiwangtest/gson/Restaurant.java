package com.example.shuiwangtest.gson;

public class Restaurant {

    String name;

    Owner owner;
    Cook cook;
    Waiter waiter;

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", owner=" + owner +
                ", cook=" + cook +
                ", waiter=" + waiter +
                '}';
    }
}
