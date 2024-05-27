package org.example.bank_products;


import org.example.bank_products.enums.CurrencyType;
import org.example.bank_products.enums.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class AbstractBankProduct implements IBankProduct {
    private Long balance;
    private final Product productName;
    private final CurrencyType currencyType;

    public AbstractBankProduct(Long balance, CurrencyType currencyType) {
        this.productName = setProductName();
        this.balance = balance;
        List<CurrencyType> currencyTypes = currencyRestriction();
        if (!currencyTypes.contains(currencyType)) {
            this.currencyType = currencyTypes.get(0);
            System.out.println(String.format("Wrong Currency = %s for this product. Currency set to %s", currencyTypes.get(0), this.currencyType));
        } else {
            this.currencyType = currencyTypes.get(0);
        }
    }

    protected abstract List<CurrencyType> currencyRestriction();

    private Product setProductName() {
        String name = this.getClass().getSimpleName();
        Optional<Product> optional = Arrays.stream(Product.values())
                .filter(p -> p.getProductName().equalsIgnoreCase(name))
                .findFirst();

        if (optional.isEmpty()) {
            System.out.println("Wrong Product");
            throw new IllegalArgumentException("Wrong Product:= " + name);
        }
        return optional.get();
    }

    @Override
    public Product getName() {
        return productName;
    }

    @Override
    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    @Override
    public Long getBalance() {
        return balance;
    }

    protected void changeBalanceAmount(CurrencyType currencyType, Long sum, boolean isIncrease) {
        if (!isCurrencyTypeEquals(currencyType)) {
            System.out.println("AbstractBankProduct:: changeBalanceAmount() => currencyTypes.get(0) = " + currencyType);
            System.out.println(String.format("Wrong CurrencyType. You give %s, but needed currency %s", currencyType, this.currencyType));
            return;
        } else if (!isIncrease && (balance < sum)) {
            System.out.println(String.format("Error: The sum exceed balance. Balance = %s, but sum = %s", balance, sum));
            return;
        }

        balance = isIncrease ? balance + sum : balance - sum;
    }

    @Override
    public void addMoneyToAccount(CurrencyType currencyType, Long sum) {
        changeBalanceAmount(currencyType, sum, true);
    }

    public boolean isCurrencyTypeEquals(CurrencyType currencyType) {
        return this.currencyType.equals(currencyType);
    }

    @Override
    public <T extends IBankProduct> boolean isBankProductSame(T p) {
        if (p == this) {
            return true;
        } else if (p != null && this.getClass().equals(p.getClass()) && this.productName.equals(p.getName())) {
            return isCurrencyTypeEquals(p.getCurrencyType());
        } else {
            return false;
        }
    }
}
