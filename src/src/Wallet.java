import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * The Wallet class, used for implementing a e-wallet that contains payment methods and the user interface.
 *
 * @author Li Cheuk Hin
 */
public class Wallet {

    /**
     * An ArrayList that stores payment tools that implements the Payment interface.
     */
    ArrayList<Payment> tools = new ArrayList<>();
    public static void main(String[] args) {
        Wallet w = new Wallet();
        w.phaseOne();
    }

    private void phaseOne(){
        boolean flag = true;
        String name,cardNo,password,phoneNo,accName;
        Float creditLimit, balance;
        System.out.println("------------Phase 1: Initialization------------");
        while (flag) {
            switch (readInput("Initialize payment tool (Debit/Credit/FPS/Alipay):")) {
                case "Debit":
                    name = readInput("Initialize one debit card, Please input the owner name:");
                    cardNo = readInput("Please input the Card No:");
                    password = readInput("Please input the password:");
                    balance = Float.parseFloat(readInput("Please input balance:"));
                    tools.add(new DebitCard(name, cardNo, password, balance));
                    break;
                case "Credit":
                    name = readInput("Initialize one Credit card, Please input the owner name:");
                    cardNo = readInput("Please input the Card No:");
                    creditLimit = Float.parseFloat(readInput("Please input the creditLimit:"));
                    tools.add(new CreditCard(name, cardNo, creditLimit));
                    break;
                case "FPS":
                    phoneNo = readInput("Initialize FPS, Please input your phone number:");
                    balance = Float.parseFloat(readInput("Please input balance:"));
                    tools.add(new FPS(phoneNo, balance));
                    break;
                case "Alipay":
                    accName = readInput("Initialize Alipay, Please input your account name:");
                    balance = Float.parseFloat(readInput("Please input balance:"));
                    tools.add(new Alipay(accName, balance));
                    break;
                case "pay":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
        phaseTwo();
    }
    private void listToolsStatus(){
        ArrayList<String> curRecords;
        for(Integer i = 1; i <= tools.size();i++){
            System.out.println(i.toString() +" "+tools.get(i-1).getInfo());
                if(tools.get(i-1) instanceof MobilePay){
                    curRecords = ((MobilePay) tools.get(i-1)).records;
                }else{
                    curRecords = ((Card) tools.get(i-1)).records;
                }
            for(String j: curRecords)
                System.out.println(j);
        }
    }
    private void phaseTwo(){
        boolean flag = true;
        String input;
        Payment selected;
        System.out.println("------------Phase 2: Pay------------\nHere are your payment tools:");
        listToolsStatus();
        while(true){
            input = readInput("Please input the index to choose the payment method:");
            if(input.equals("show"))
                break;
            selected = tools.get(Integer.parseInt(input)-1);
            String transactionRecord = selected.pay(Float.parseFloat(readInput("Pay money $:")));
            if(transactionRecord != null){
                if(selected instanceof MobilePay){
                    ((MobilePay) selected).records.add(transactionRecord);
                }else{
                    ((Card) selected).records.add(transactionRecord);
                }
                System.out.println("Payment Successful!\n"+transactionRecord);
            }
        }
        listToolsStatus();
    }

    /**
     * Read the user input from the console
     * @return the user input as a String
     */
    public static String readInput(String printText) {
        System.out.print(printText+" ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = null;
        try {
            inputLine = input.readLine();
            //System.out.println(inputLine);
            return inputLine;
        } catch (IOException e) {
            System.err.println("Input ERROR.");
        }
        // return empty string if error occurs
        return inputLine;

    }
    /**
     * You can use this method to get current system time as a String
     * @return a String for the system time in specific format.
     */
    public static String getCurrentTime() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd '-' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        //System.out.println(formatter.format(date));
        return formatter.format(date);
    }
}
