package com.example.shuiwangtest.gson;

import java.util.List;

public class GeneralInfo {
    String name;
    String website;
    List<Founder> founders;

    @Override
    public String toString() {
        return "GeneralInfo{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", founders=" + founders +
                '}';
    }
}
