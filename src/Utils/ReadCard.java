package Utils;

import Repo.DataStorage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCard implements ReadDataFactory{

    private DataStorage stockRepository = DataStorage.getInstance();

    @Override
    public void readData(String path) {

            String creditFilePath = path;
            BufferedReader br1 = null;

            try {
                br1=new BufferedReader(new FileReader(creditFilePath));
                String line1="";
                int c1=0;
                while((line1=br1.readLine())!=null){
                    if(c1==0){
                        c1=1;
                    }
                    else{
                        stockRepository.getcards().add(line1);
                    }

                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            if (br1 != null) {
                try {
                    br1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }
}
