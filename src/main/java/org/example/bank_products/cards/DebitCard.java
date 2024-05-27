package org.example.bank_products.cards;

import org.example.bank_products.enums.CardType;
import org.example.bank_products.enums.CurrencyType;

import java.util.List;

public class DebitCard extends AbstractCard {
    public DebitCard(CardType cardType, Long accountSum) {
        super(accountSum, CurrencyType.RUB, cardType);

    }

    @Override
    protected List<CurrencyType> currencyRestriction() {
        System.out.println("** Debit Card");
        return List.of(CurrencyType.RUB);         // RUB - only
    }
}
