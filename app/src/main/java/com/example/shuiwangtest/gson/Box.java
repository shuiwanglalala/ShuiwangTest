package com.example.shuiwangtest.gson;

public class Box<T> {
    private T boxContent;

    public Box(T t) {
        this.boxContent = t;
    }
}
