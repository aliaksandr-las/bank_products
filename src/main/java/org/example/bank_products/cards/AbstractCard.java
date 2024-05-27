package org.example.bank_products.cards;

import org.example.bank_products.AbstractBankProduct;
import org.example.bank_products.enums.CardType;
import org.example.bank_products.enums.CurrencyType;

public abstract class AbstractCard extends AbstractBankProduct implements ICard {
    private final CardType cardType;

    public AbstractCard(Long balance, CurrencyType currencyType, CardType cardType) {
        super(balance, currencyType);
        this.cardType = cardType;
    }

    public CardType getCardType() {
        System.out.println("cardType = " + cardType);
        return cardType;
    }

    @Override
    public <T extends ICard> boolean isCardEquals(T card) {
        if (card instanceof AbstractCard) {
            AbstractCard c = (AbstractCard) card;
            if (cardType.equals(c.getCardType())) {

                return isBankProductSame(card);
            }
        }
        return false;
    }

    @Override
    public void withdrawMoneyFromAccount(CurrencyType currencyType, Long sum) {
        changeBalanceAmount(currencyType, sum, false);
    }
}
