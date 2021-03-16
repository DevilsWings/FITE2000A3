public class DebitCard extends Card
{
    String password;
    public DebitCard(String name, String cardNo, String password,Float balance) {
        this.name = name;
        this.cardNo = cardNo;
        this.password = password;
        this.balance = balance;
    }
}
