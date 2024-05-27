package org.example.bank_products.cards;

import org.example.bank_products.IBankProduct;


public interface ICreditCard extends ICard, IBankProduct {
    Double setRandomDebt();
    Double getDebt();
    Double getInterestRate();
    Double setInterestRate(Double newInterestRate);
}
