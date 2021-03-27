public class Alipay extends MobilePay {
    String accName;

    public Alipay(String accName,Float balance) {
        this.accName = accName;
        this.balance = balance;
    }
    @Override
    public String getInfo() {
        return String.format("– Alipay – account name: %s, balance: %.1f", accName, balance);
    }
    @Override
    public String setReceiver() {
        return Wallet.readInput("Receiver Alipay account name: ");
    }
}
