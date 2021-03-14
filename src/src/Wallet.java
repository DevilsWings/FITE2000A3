import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Wallet {
    ArrayList<Payment> tools = new ArrayList<Payment>;
    public static void main(String[] args) {
        Wallet w = new Wallet();
        w.go();
    }

    public static void go() {
        boolean flag = true;
        System.out.println("------------Phase 1: Initialization------------");
        while (flag) {
            System.out.print("Initialize payment tool (Debit/Credit/FPS/Alipay):");
            switch (readInput()) {
                case "Debit":
                    String name = readInput("Initialize one debit card, Please input the owner name:");
                    String cardNo = readInput("Please input the Card No:");
                    String password = readInput("Please input the passwaord:");
                    Float balance = Float.parseFloat(readInput("Please input balance:"));
                    break;
                case "Credit":
                    String name = readInput("Initialize one Credit card, Please input the owner name:");
                    String cardNo = readInput("Please input the Card No:");
                    String creditLimit = readInput("Please input the creditLimit:");
                    Float balance = 0;
                    break;
                case "FPS":
                    String phoneNo = readInput("Initialize FPS, Please input your phone number:");
                    Float balance = Float.parseFloat(readInput("Please input balance:"));
                    break;
                case "Alipay":
                    String accName = readInput("Initialize Alipay, Please input your account name:");
                    Float balance = Float.parseFloat(readInput("Please input balance:"));
                    break;
                case "pay":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }

    /**
     * Read the user input from the console
     * @return the user input as a String
     */
    public static String readInput(String printText) {
        System.out.print(printText);
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
    public String getCurrentTime() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd '-' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        //System.out.println(formatter.format(date));
        return formatter.format(date);
    }
}
