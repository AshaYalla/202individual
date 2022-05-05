package Utils;
import Repo.DatasetStore;
import java.io.*;
import java.util.HashMap;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OrderGeneration {
    Path currentRelativePath = Paths.get("");
    String s = currentRelativePath.toAbsolutePath().toString();
    String strNew = s.substring(0, s.length()-4);

    public void checkCardNumber(String cardNumber) {
        boolean flag = false;
        Cards cardsListObj = Cards.getInstance();
        IContainer iCards = Cards.getInstance();
        Iterator iterator = iCards.createIterator();
        try{
            FileWriter cwriter = new FileWriter(strNew+"/resources/CreditCards.csv" ,true);
            BufferedWriter out=new BufferedWriter(cwriter);
            

            while(iterator.hasNext()) {
                Object object = iterator.next();
                if(object.equals(cardNumber)) {
                    System.out.println("Card already exists");
                    flag = true;
                }
            }
            if(!flag) {
                cardsListObj.getCardsList().add(cardNumber);
                System.out.println("New card added successfully" + "{CardNumber = " + cardNumber + "}"  );
                out.newLine();
                out.write(cardNumber);
                out.close();
                
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

        



    public void outputWriter(String pathinput)
        {
            DatasetStore shopStock = DatasetStore.getInstance();
            String inputFilePath = pathinput;
            Double totalamount=0.0;
            HashMap<String,String> limitqty =new HashMap<String,String>();
            try{
                limitqty.put("Essentials","10");
                limitqty.put("Luxury","10");
                limitqty.put("Misc","10");
                int error=0;
                String cardNumber = null;
               
               
                //System.out.println("Current absolute path is: " + strNew);
                BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
                PrintWriter writer = new PrintWriter(strNew+"/resources/output.txt");
                PrintWriter correctwriter = new PrintWriter(strNew+"/resources/output.csv");
                // FileWriter cwriter = new FileWriter(strNew+"/resources/CreditCards.csv" ,true);
                // BufferedWriter out=new BufferedWriter(cwriter);
                BufferedReader bufferreader3=new BufferedReader(new FileReader(inputFilePath));
                String line = bufferedReader.readLine();
                String[] data;
                while (true) {
                    line = bufferedReader.readLine();
                    if (line==null)
                        break;

                    data = line.split(",");
                    if (data.length == 3) {
                        cardNumber = data[2];
                        checkCardNumber(cardNumber);
                    }
                    // if(!shopStock.cardStore().contains(cardNumber)){
                    //                 out.newLine();
                    //                 out.write(cardNumber);
                    //                 shopStock.cardStore().add(cardNumber);
                    //             }

                    
                }

                // bufferedReader.close();
                //CheckCard checkCard = new CheckCard();
                


                    




                String line2="";
                String wrongitems = " ";
                String correctitems = " ";
                int c2=0;
                while((line2=bufferreader3.readLine())!=null){
                    if(c2==0){
                        c2=1;
                    }else{
                        String[] ans=line2.split(",");
                        //System.out.println(ans[0]);
                        String item=ans[0].toUpperCase();
                        Double quanty=Double.valueOf(ans[1]);
                        //System.out.println(shopStock.categoryStore().get(item));
                        //System.out.println(limitqty.get(shopStock.categoryStore().get(item)));
                        if(Double.valueOf(limitqty.get(shopStock.categoryStore().get(item)))>= quanty){

                            if(Double.valueOf(shopStock.qtyStore().get(item))>=quanty){
                                Double currentprice = quanty*Double.valueOf(shopStock.priceStore().get(item));
                                totalamount+=currentprice;
                                Double updatedstoreQty=Double.valueOf(shopStock.qtyStore().get(item)) - quanty;
                                shopStock.qtyStore().put(item,Double.toString(updatedstoreQty));
                                Double updatedlimitQty=Double.valueOf(limitqty.get(shopStock.categoryStore().get(item)))-quanty;
                                limitqty.put(shopStock.categoryStore().get(item),Double.toString(updatedlimitQty));
                                System.out.println(item+" " +quanty+ " "+ currentprice  );
                                correctitems = correctitems +item+"," +quanty+ ","+ currentprice + "\n" + "                                                      " + "\n";    
                            }
                            else{
                                wrongitems = wrongitems +" "+ item;
                                //System.out.println("b " + wrongitems);
                                error=1;
                            }
                        }
                        else{
                            //writer.write(" \n" + "Please correct quantities of one of the items: " + item);
                            wrongitems = wrongitems +" "+ item;
                            //System.out.println("be " + wrongitems);
                            
                            error=1;
                            } } }
                if(error==0){
                    correctwriter.write(correctitems);
                    
                    correctwriter.close();
                    BufferedReader brTest = new BufferedReader(new FileReader(strNew+"/resources/output.csv"));
                    String text = brTest.readLine();
                    brTest.close();
                    text = "Item, Quantity, Price, TotalPrice" + "\n" + text + "," + totalamount;
                    RandomAccessFile f = new RandomAccessFile(new File(strNew+"/resources/output.csv"), "rw");
                    f.seek(0); // to the beginning
                    f.write(text.getBytes());
                    f.close();
                    //System.out.println("Firstline is : " + text);
                }
                else{
                    writer.flush();
                    writer.write(" \n" + "Please correct quantities of  items: " + wrongitems);
                }
                // out.close();
                writer.close();
                bufferreader3.close();
                
             
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }

        

}
