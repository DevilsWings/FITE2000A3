public class DebitCard extends Card
{
    String password;
    public DebitCard(String name, String cardNo, String password,Float balance) {
        this.name = name;
        this.cardNo = cardNo;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public String getInfo() {
        return String.format("- Debit - owner: %s, card no: %s, balance: %.1f", name, cardNo, balance);
    }

    @Override
    public String pay(float amount) {
        while(!Wallet.readInput("Please input the password:").equals(password)){
            System.out.println("Password incorrect");
        }
        if(amount <= balance){
            balance -= amount;
            return String.format("Payment record: pay $%.1f, time: %s", amount, Wallet.getCurrentTime());
        }
        System.out.printf("current balance is $%.1f, no enough balance in Debit Card\n", balance);
        return null;
}}
