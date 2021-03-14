/**
 * The transaction class, defines the attribute of each transaction record within the card class.
 * @author andyli
 */
public class transaction {

    /**
     * A string that store the transaction amount of the transaction.
     */
    String Amount;

    /**
     * A string that store the timestamp when the transaction occurs.
     */
    String Time;

    /**
     * Create an transaction object to store the transaction record.
     * @param amount The transacted amount of the transaction
     * @param time Timestamp of the transaction
     */
    public transaction(String amount, String time) {
        Time = time;
        Amount = amount;
    }
}