package org.example.bank_products.cards;

import org.example.bank_products.enums.CardType;
import org.example.bank_products.enums.CurrencyType;
import org.example.bank_products.IBankProduct;


public interface ICard extends IBankProduct {
    CardType getCardType();
    <T extends ICard> boolean isCardEquals(T card);
    void withdrawMoneyFromAccount(CurrencyType currencyType, Long sum);
}
