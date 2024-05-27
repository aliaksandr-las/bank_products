package org.example.bank_products;

import org.example.bank_products.enums.CurrencyType;
import org.example.bank_products.enums.Product;


public interface IBankProduct  {
    Product getName();
    CurrencyType getCurrencyType();
    Long getBalance();
    void addMoneyToAccount(CurrencyType currencyType, Long sum);
    boolean isCurrencyTypeEquals(CurrencyType currencyType);
    public  <T extends IBankProduct> boolean isBankProductSame(T p);
}
