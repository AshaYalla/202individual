package Repo;

import java.util.HashMap;
import java.util.HashSet;


public class DataStorage {
    private static DataStorage instance;

    HashMap<String,String> prices=new HashMap<String,String>();
    HashMap<String,String> quantities=new HashMap<String,String>();
    HashMap<String,String> categoryItem=new HashMap<String,String>();
    HashSet<String> card=new HashSet<String>();

    private DataStorage(){}

    public static DataStorage getInstance(){
        if( instance == null){
            instance = new DataStorage();
        }
        return instance;
    }

    public HashMap<String,String>  getPrices(){
        return prices;
    }
    public HashMap<String,String>  getquantities(){
        return quantities;
    }
    public HashMap<String,String>  getcategoryItems(){
        return categoryItem;
    }

    public HashSet<String>  getcards(){
        return card;
    }
}