public class CreditCard extends Card{
    Float creditLimit;

    public CreditCard(String name, String cardNo, Float creditLimit) {
        this.name = name;
        this.cardNo = cardNo;
        this.creditLimit = creditLimit;
    }
}
