package com.example.shuiwangtest.gson;

public class Owner {

    String name;

    UserAddress address;

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
