public class Alipay extends MobilePay {
    String accName;

    public Alipay(String accName,Float balance) {
        this.accName = accName;
        this.balance = balance;
    }
}
