import java.util.ArrayList;

/**
 * An abstract card that implements a mobile payment account using the Payment interface.
 */
public abstract class MobilePay implements Payment{
    /**
     * A float that stores the current balance of the Mobile Payment accounts.
     */
    float balance;

    /**
     * An method that prompts the users for an identifier of the receiver that the transaction is sent.
     * @return A String containing the identifier for the receiving user.
     */
    public abstract String setReceiver();
    /**
     * An ArrayList that stores Strings containing the transaction records of the mobile payment account.
     */
    ArrayList<String> records = new ArrayList<>();


    /**
     * Validates and handles the transaction for the payment.
     * @param amount The amount of the transaction
     * @return A String containing a Payment records which details the amount paid, the receiver, and time of the transaction, returns null when unsuccessful
     */
    @Override
    public String pay(float amount) {
        String receiver = setReceiver();
        if(amount <= balance){
            balance -= amount;
            return String.format("Payment record: pay $%.1f, receiver: %s, time: %s", amount, receiver ,Wallet.getCurrentTime());
        }
        System.out.printf("current balance is $%.1f, no enough balance\n", balance);
        return null;
}}
