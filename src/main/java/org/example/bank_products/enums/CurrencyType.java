package org.example.bank_products.enums;

public enum CurrencyType {
    RUB ("Russian Ruble"),
    EUR("Euro"),
    US("United State Dollar"),
    BLR("Belarusian Ruble");

   private String name;

    CurrencyType(String name) {
        this.name = name;
    }
}
