import java.util.ArrayList;

public abstract class MobilePay implements Payment{
    float balance;
    public abstract String setReceiver();
    ArrayList<String> records = new ArrayList<>();
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
