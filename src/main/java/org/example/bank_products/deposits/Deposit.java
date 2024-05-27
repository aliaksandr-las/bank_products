package org.example.bank_products.deposits;

import org.example.bank_products.AbstractBankProduct;
import org.example.bank_products.enums.CurrencyType;

import java.util.Arrays;
import java.util.List;

public class Deposit extends AbstractBankProduct implements IDeposit {

    public Deposit(Long account, CurrencyType currencyType) {
        super(account, currencyType);
    }

    @Override
    protected List<CurrencyType> currencyRestriction() {
        return Arrays.stream(CurrencyType.values()).toList();
    }

    @Override
    public Long closeDeposit() {
        Long balance = getBalance();
        System.out.println(String.format("Deposit balance = %s ", balance + " is given out to Client"));
        changeBalanceAmount(getCurrencyType(), balance, false);
        balance = getBalance();
        System.out.println(String.format("Deposit (Closed): balance = %s", balance));

        return balance;
    }
}
