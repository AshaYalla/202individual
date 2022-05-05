// package Utils;

// import Repo.DatasetStore;

// import java.io.*;

// public class ReadFile implements ReadData{

//     private DatasetStore shopStock = DatasetStore.getInstance();

//     @Override
//     public void readData(String path) {
//         try {
//             BufferedReader bufferreader=new BufferedReader(new FileReader(path));
//             String line="";
//             while(true){
//                 line=bufferreader.readLine();
//                 if(line==null)
//                     break;
//                 if(line.equals("Item Category Quantity Price")){
//                     System.out.println("bleh");
//                     line=bufferreader.readLine();
//                 }
//                 else{
//                     String[] stockitem=line.split(" ");
//                     shopStock.priceStore().put(stockitem[0],stockitem[3]);
//                     shopStock.qtyStore().put(stockitem[0], stockitem[2]);
//                     shopStock.categoryStore().put(stockitem[0], stockitem[1]);
//                 }
//             }
//             bufferreader.close();
//         }
//         catch(Exception e){
//             e.printStackTrace();
//         }
//     }
// }

package Utils;

import Repo.DatasetStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadInventory implements ReadData{

    private DatasetStore shopStock = DatasetStore.getInstance();

    @Override
    public void readData(String path) {
            BufferedReader br = null;
            String ans;

            try {
                br=new BufferedReader(new FileReader(path));
                String line="";
                int c=0;
                while((line=br.readLine())!=null){
                    if(c==0){
                        c=1;
                    }
                    else{
                        String[] stockitems=line.split(",");
                        ans = stockitems[0].toUpperCase();
                        shopStock.priceStore().put(ans,stockitems[3]);
                        shopStock.qtyStore().put(ans, stockitems[2]);
                        shopStock.categoryStore().put(ans, stockitems[1]);
                    }
                }
                br.close();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
    }
}