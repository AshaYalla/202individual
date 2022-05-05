package Utils;

import Repo.DatasetStore;

import java.io.*;

public class ReadCard implements ReadData{

    private DatasetStore shopStock = DatasetStore.getInstance();

    @Override
    public void readData(String path) {
        try {
            BufferedReader bufferreader1 = new BufferedReader(new FileReader(path));
                String line1="";
                while(true){
                    line1=bufferreader1.readLine();
                    if(line1==null)
                        break;
                    if(line1.equals("CardNumber")){
                        line1=bufferreader1.readLine();
                    }
                    else{
                        shopStock.cardStore().add(line1);
                    }
                }
                bufferreader1.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
