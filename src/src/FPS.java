public class FPS extends MobilePay{
    String phoneNo;

    public FPS(String phoneNo, Float balance) {
        this.phoneNo = phoneNo;
        this.balance = balance;
    }
    @Override
    public String getInfo() {
        return String.format("– FPS – phone number: %s, balance: %.1f", phoneNo, balance);
    }

    @Override
    public String setReceiver() {
        return Wallet.readInput("Receiver FPS phone number: ");
    }
}
