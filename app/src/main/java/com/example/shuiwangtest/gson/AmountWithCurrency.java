package com.example.shuiwangtest.gson;

public class AmountWithCurrency {
    String currency;
    int amount;

    public AmountWithCurrency(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AmountWithCurrency{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
