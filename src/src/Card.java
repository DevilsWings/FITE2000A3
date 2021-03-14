import java.util.ArrayList;

public abstract class Card implements Payment{

    String name;
    String cardNo;
    float balance;
    ArrayList<transaction> records = new ArrayList<>();
}
