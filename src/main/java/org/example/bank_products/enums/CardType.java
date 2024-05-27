package org.example.bank_products.enums;

public enum CardType {
    MIR("MIR"),
    VISA("VISA"),
    MASTE_CARD("MASTE_CARD");

    private final String name;

    CardType(String name) {
        this.name = name;
    }
}
