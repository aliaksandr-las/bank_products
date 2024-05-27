package org.example.bank_products.cards;

import org.example.bank_products.enums.CardType;
import org.example.bank_products.enums.CurrencyType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyDebitCard extends AbstractCard {
    public CurrencyDebitCard(CardType cardType, Long accountSum, CurrencyType currencyType) {
        super(accountSum, currencyType, cardType);
    }

    @Override
    protected List<CurrencyType> currencyRestriction() {
        return Arrays.stream(CurrencyType.values())
                .filter(c -> !c.equals(CurrencyType.RUB))     // All currency except RUB
                .collect(Collectors.toList());
    }
}
