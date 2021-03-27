/**
 * The Alipay class which implements a Alipay account using the abstract Card class
 *
 * @author Li Cheuk Hin
 */
public class Alipay extends MobilePay {
    /**
     * A String storing the account number of the Alipay account
     */
    final String accName;

    /**
     * Generator for the Alipay object.
     * @param accName A String storing the phone number of the FPS account.
     * @param balance A Float storing the current balance of the FPS account.
     */
    public Alipay(String accName,Float balance) {
        this.accName = accName;
        this.balance = balance;
    }
    /**
     * Display the status of the FPS account.
     * @return A String containing the current status of the Alipay account.
     */
    @Override
    public String getInfo() {
        return String.format("– Alipay – account name: %s, balance: %.1f", accName, balance);
    }
    /**
     * An method that prompts the users for the account name of the receiver for the transaction.
     * @return A String containing the identifier for the receiving user.
     */
    @Override
    public String setReceiver() {
        return Wallet.readInput("Receiver Alipay account name: ");
    }
}
