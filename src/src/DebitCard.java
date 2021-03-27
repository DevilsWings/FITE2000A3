/**
 * The DebitCard class which implements a debit card using the abstract Card class
 *
 * @author Li Cheuk Hin
 */
public class DebitCard extends Card
{

    /**
     * A String that contains the password for using the Debit Card
     */
    final String password;

    /**
     * Generator for a DebitCard object
     * @param name A String storing the name of the debit card owner.
     * @param cardNo A String storing the card number of the debit card.
     * @param password A String storing the password of the debit card.
     * @param balance A Float that stores the current balance of the debit card.
     */
    public DebitCard(String name, String cardNo, String password,Float balance) {
        this.name = name;
        this.cardNo = cardNo;
        this.password = password;
        this.balance = balance;
    }

    /**
     * Display the status of the debit card.
     * @return A String containing the current status of the debit card.
     */
    @Override
    public String getInfo() {
        return String.format("- Debit - owner: %s, card no: %s, balance: %.1f", name, cardNo, balance);
    }

    /**
     * Authenticate the owner, validates and handles the transaction for the payment.
     * @param amount The amount of the transaction
     * @return A String containing a Payment records which details the amount paid and time of the transaction, returns null when unsuccessful
     */
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
