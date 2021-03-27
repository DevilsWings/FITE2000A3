/**
 * The CreditCard class which implements a credit card using the abstract Card class
 *
 * @author Li Cheuk Hin
 */
public class CreditCard extends Card {
    /**
     * A Float that stores the maximum credit limit of the credit card
     */
    Float creditLimit;

    /**
     * Generator for a DebitCard object
     * @param name A String storing the name of the Credit card Owner
     * @param cardNo A String storing the card number of the credit card.
     * @param creditLimit A Float storing the maximum credit limit of the credit card
     */
    public CreditCard(String name, String cardNo, Float creditLimit) {
        this.name = name;
        this.cardNo = cardNo;
        this.creditLimit = creditLimit;
        this.balance = 0.0f;
    }

    /**
     * Display the status of the credit card.
     * @return A String containing the current status of the credit card.
     */
    @Override
    public String getInfo() {
        return String.format("- Credit - owner: %s, card no: %s, credit limit: %.1f, current credit limit: %.1f", name, cardNo, creditLimit, creditLimit + balance);
    }
    /**
     * Validates and handles the transaction for the payment.
     * @param amount The amount of the transaction
     * @return A String containing a Payment records which details the amount paid and time of the transaction, returns null when unsuccessful
     */
    @Override
    public String pay(float amount) {
        if (amount <= creditLimit+balance) {
             balance -= amount;
            return String.format("Payment record: pay $%.1f, time: %s", amount, Wallet.getCurrentTime());
        }
        System.out.printf("current credit limit is $%.1f, no enough credit limit in Credit Card\n", creditLimit+balance);
        return null;
    }
}
