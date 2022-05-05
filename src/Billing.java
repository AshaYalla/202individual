import Utils.ReadCard;
import Utils.OrderGeneration;
import Utils.ReadInventory;
import Utils.ReadData;
import Utils.ProcessFactory;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Billing {

    public static void main(String[] args) {

        processInput(args);
    }
    private static void processInput(String[] args) {

        {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            String strNew = s.substring(0, s.length()-4);
         
            ProcessFactory processFactory = new ProcessFactory();

            ReadData readFile = processFactory.getAction("READFILE");
            ReadData readCard = processFactory.getAction("READCARD");

            // readCard.readData(args[0]);
            // readFile.readData(args[1]);
        
            readCard.readData(strNew + "/resources/CreditCards.csv");
           
            readFile.readData(strNew+ "/resources/Dataset.csv");
            
            placeOrder(args[0]);
        
        }
    }

    private static void  placeOrder(String pathinput) {

        OrderGeneration ordergeneration = new OrderGeneration();
        ordergeneration.outputWriter(pathinput);

    }
}
