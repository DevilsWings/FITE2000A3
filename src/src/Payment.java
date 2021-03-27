/**
 * The Payment interface, outlining the functions required for a payment method to handle payments
 *
 * @author Li Cheuk Hin
 */
public interface Payment {

    /**
     * Conduct authorization, validation and transaction process for a payment
     * @param amount the amount of the transaction
     * @return A String containing the transaction record, returns null if the payment is unsuccessful
     */
    String pay(float amount);

    /**
     * Display the status of the payment method.
     * @return A String containing the current status of the payment method
     */
    String getInfo();
}
