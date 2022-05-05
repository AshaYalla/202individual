package Utils;

public class ProcessFactory {
    public ReadData getAction(String shapeType){
        if(shapeType == null){
           return null;
        }		
        if(shapeType.equalsIgnoreCase("READCARD")){
           return new ReadCard();
           
        } else if(shapeType.equalsIgnoreCase("READFILE")){
           return new ReadInventory();
        }
        return null;
     }
    
}

