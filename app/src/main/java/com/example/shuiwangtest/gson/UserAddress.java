package com.example.shuiwangtest.gson;

public class UserAddress {

    private String street;
    String houseNumber;
    String city;
    String country;

    public UserAddress(String street, String houseNumber, String city, String country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.country = country;
    }

    public UserAddress(String street, String houseNumber, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
