public class CreditCard extends Card {
    Float creditLimit;

    public CreditCard(String name, String cardNo, Float creditLimit) {
        this.name = name;
        this.cardNo = cardNo;
        this.creditLimit = creditLimit;
    }

    @Override
    public String getInfo() {
        return String.format("- Credit - owner: %s, card no: %s, credit limit: %.1f, current credit limit: %.1f", name, cardNo, creditLimit, creditLimit + balance);
    }

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
