import Utils.ReadCard;
import Utils.Shopping;
import Utils.ReadFile;
import Utils.ReadDataFactory;

public class Billing {

    public static void main(String[] args) {

    System.out.println("Main executing");
        processRead(args);
    }
    private static void processRead(String[] args) {
        {
            ReadDataFactory fileReader = new ReadFile();
            ReadDataFactory cardReader = new ReadCard();

            cardReader.readData(args[0]);
            fileReader.readData(args[1]);
            placeOrder(args[2]);
        
        }
    }

    private static void  placeOrder(String path) {

        Shopping eu = new Shopping();
        eu.outputWriter(path);

    }
}
