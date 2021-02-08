package com.example.shuiwangtest.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserSimple {
    @SerializedName("fullName")
    @Expose()
    String name;
    String email;
    int age;
    boolean isDeveloper;

    public UserSimple(String name, String email, int age, boolean isDeveloper) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDeveloper = isDeveloper;
    }

    @Override
    public String toString() {
        return "UserSimple{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isDeveloper=" + isDeveloper +
                '}';
    }
}
