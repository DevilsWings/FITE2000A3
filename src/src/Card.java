import java.util.ArrayList;

/**
 * The abstract Card class which implements a card with card Number using the Payment interface
 * @author Li Cheuk Hin
 */
public abstract class Card implements Payment{


    /**
     * A String that stores the name of the owner of the card.
     */
    String name; //Owner Name of the card
    /**
     * A String that stores the card number of the card.
     */
    String cardNo; //Card Number of the card
    /**
     * A float that stores the current balance of the card, can be less than zero for credit card.
     */
    float balance; //Current balance of the card
    /**
     * An ArrayList that stores Strings containing the transaction records of the card.
     */
    ArrayList<String> records = new ArrayList<>(); //An ArrayList which stores the transaction records of the card
}
