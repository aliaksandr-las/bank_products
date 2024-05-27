
import org.example.bank_products.cards.CreditCard;
import org.example.bank_products.cards.CurrencyDebitCard;
import org.example.bank_products.cards.DebitCard;
import org.example.bank_products.enums.CardType;
import org.example.bank_products.enums.CurrencyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class BankingProductTest {
    private static Stream<Arguments> provideDebitCardProducts() {
        return Stream.of(
                Arguments.of(1, new DebitCard(CardType.MIR, 234L), new DebitCard(CardType.MIR, 234L), true),
                Arguments.of(2, new DebitCard(CardType.MASTE_CARD, 234L), new DebitCard(CardType.MIR, 234L), false),
                Arguments.of(3, new DebitCard(CardType.VISA, 234L), new DebitCard(CardType.MIR, 234L), false));
    }

    @ParameterizedTest
    @MethodSource("provideDebitCardProducts")
    public void testDebitCard(int num, DebitCard dc1, DebitCard dc2, boolean isSame) {
        System.out.println(String.format(" names:    %s == %s \n cardType: %s == %s \n  currency: %s == %s \n isSame =  %s",
                dc1.getName(), dc2.getName(), dc1.getCardType(), dc2.getCardType(), dc1.getCurrencyType(), dc2.getCurrencyType(), isSame));
        System.out.println(num + ": >>>  " + dc1.isCardEquals(dc2));
        Assertions.assertEquals(dc1.isCardEquals(dc2), isSame);
    }

    private static Stream<Arguments> provideCurrencyDebitCardAndDebitCardProducts() {
        return Stream.of(
                Arguments.of(1, new CurrencyDebitCard(CardType.MIR, 547L, CurrencyType.RUB), new DebitCard(CardType.MIR, 234L), false),
                Arguments.of(2, new CurrencyDebitCard(CardType.MIR, 547L, CurrencyType.US), new DebitCard(CardType.MIR, 234L), false),
                Arguments.of(3, new CurrencyDebitCard(CardType.VISA, 547L, CurrencyType.US), new DebitCard(CardType.MIR, 234L), false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCurrencyDebitCardAndDebitCardProducts")
    public void testCurrencyDebitCard(int num, CurrencyDebitCard dc1, DebitCard dc2, boolean isSame) {
        System.out.println(String.format(" names:    %s == %s \n cardType: %s == %s \n  currency: %s == %s \n isSame =  %s",
                dc1.getName(), dc2.getName(), dc1.getCardType(), dc2.getCardType(), dc1.getCurrencyType(), dc2.getCurrencyType(), isSame));
        System.out.println(num + ": >>>  " + dc1.isCardEquals(dc2));
        Assertions.assertEquals(dc1.isCardEquals(dc2), isSame);
    }

    private static Stream<Arguments> provideCreditCardProducts() {
        return Stream.of(
                Arguments.of(1, new CreditCard(CardType.MIR, 547L, 12.5), new CreditCard(CardType.MIR, 547L, 12.5), true),
                Arguments.of(2, new CreditCard(CardType.MIR, 547L, 24.0), new CreditCard(CardType.MIR, 547L, 57.0), false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCreditCardProducts")
    public void testCreditCard(int num, CreditCard c1, CreditCard c2, boolean isSame) {
        System.out.println(String.format(" names:    %s == %s \n cardType: %s == %s \n  currency: %s == %s \n isSame =  %s",
                c1.getName(), c2.getName(), c1.getCardType(), c2.getCardType(), c1.getCurrencyType(), c2.getCurrencyType(), isSame));
        System.out.println(num + ": >>>  " + c1.isCardEquals(c2));

        Assertions.assertEquals(c1.isCardEquals(c2), isSame);

        // check "Interest Rate" and "debt"
        double interestRate = c1.getInterestRate();
        double debt = c1.setRandomDebt();
        double newInterestRate = interestRate + debt;
        System.out.println("newInterestRate = interestRate + debt");
        System.out.println(String.format("%s = %s + %s", newInterestRate, interestRate, debt));
        c1.setInterestRate(newInterestRate);
        System.out.println("c1.getInterestRate() = " + c1.getInterestRate());

        Assertions.assertEquals(c1.getInterestRate(), newInterestRate);
    }
}
