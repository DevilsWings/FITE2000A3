/**
 * The FPS class which implements a FPS account using the abstract MobilePay class
 *
 * @author Li Cheuk Hin
 */
public class FPS extends MobilePay{
    /**
     * A String storing the phone number of the FPS account
     */
    final String phoneNo;

    /**
     * Generator for the FPS object.
     * @param phoneNo A String storing the phone number of the FPS account.
     * @param balance A Float storing the current balance of the FPS account.
     */
    public FPS(String phoneNo, Float balance) {
        this.phoneNo = phoneNo;
        this.balance = balance;
    }
    /**
     * Display the status of the FPS account.
     * @return A String containing the current status of the FPS account.
     */
    @Override
    public String getInfo() {
        return String.format("– FPS – phone number: %s, balance: %.1f", phoneNo, balance);
    }
    /**
     * An method that prompts the users for the phone number of the receiver for the transaction.
     * @return A String containing the identifier for the receiving user.
     */
    @Override
    public String setReceiver() {
        return Wallet.readInput("Receiver FPS phone number: ");
    }
}
