package org.example.bank_products.enums;

public enum Product {
    DEPOSIT("Deposit"),
    DEBIT_CARD("DebitCard"),
    CREDIT_CARD("CreditCard"),
    CURRENCY_DEBIT_CARD("CurrencyDebitCard");

    private String productName;

    Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
