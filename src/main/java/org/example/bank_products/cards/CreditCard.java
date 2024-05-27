package org.example.bank_products.cards;

import org.example.bank_products.enums.CardType;
import org.example.bank_products.enums.CurrencyType;

import java.util.List;
import java.util.Random;

public class CreditCard extends AbstractCard implements ICreditCard {
    private Double interestRate;
    private Double debt = 0.0;

    public CreditCard(CardType cardType, Long accountSum, Double interestRate) {
        super(accountSum, CurrencyType.RUB, cardType);
        this.interestRate = interestRate;
    }

    public Double getDebt() {
        return debt;
    }

    public Double setInterestRate(Double newInterestRate) {
        return interestRate = newInterestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return super.toString() + "\ninterestRate: " + interestRate;
    }

    @Override
    public Double setRandomDebt() {
        Random random = new Random();
        Double d = random.nextLong(100) * interestRate;
        return debt = debt + d;
    }

    @Override
    protected List<CurrencyType> currencyRestriction() {
        System.out.println("** CreditCard");
        return List.of(CurrencyType.RUB);         // RUB - only
    }

    public <T extends ICreditCard> boolean isCardEquals(T card) {
        System.out.println("CC+++++++++++");
        if (!this.getClass().getName().equalsIgnoreCase(card.getClass().getName())) {
            System.out.println("if (!this.getClass().getName().equalsIgnoreCase(card.getClass().getName())) = " +
                    (!this.getClass().getName().equalsIgnoreCase(card.getClass().getName())));
            return false;
        }

        CreditCard c = (CreditCard) card;
        if (!interestRate.equals(c.getInterestRate())) {
            System.out.println("interestRate.equals(c.getInterestRate()) = " + interestRate.equals(c.getInterestRate()));
            return false;
        }

        AbstractCard ac = (AbstractCard) card;
        if (!this.getCardType().equals(ac.getCardType())) {
            System.out.println("!this.getCardType().equals(ac.getCardType()) = " + (!this.getCardType().equals(ac.getCardType())));
            return false;
        }

        System.out.println("isBankProductSame(card) = " + isBankProductSame(card));
        return isBankProductSame(card);

    }
}
