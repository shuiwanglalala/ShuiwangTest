package com.example.shuiwangtest.gson;

public class UserNested {

    String name;
    String email;
    private boolean isDeveloper;
    int age;

    // new, see below!
    UserAddress userAddress;

    public UserNested(String name, String email, int age, boolean isDeveloper, UserAddress userAddress) {
        this.name = name;
//        this.email = email;
//        this.isDeveloper = isDeveloper;
//        this.age = age;
        this.userAddress = userAddress;
    }
}
