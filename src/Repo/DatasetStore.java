package Repo;

import java.util.HashMap;
import java.util.HashSet;


public class DatasetStore {
    private static DatasetStore instance;

    HashMap<String,String> price=new HashMap<String,String>();
    HashMap<String,String> qty=new HashMap<String,String>();
    HashMap<String,String> category=new HashMap<String,String>();
    HashSet<String> card=new HashSet<String>();

    private DatasetStore(){}

    public static DatasetStore getInstance(){
        if( instance == null){
            instance = new DatasetStore();
        }
        return instance;
    }

    public HashMap<String,String>  priceStore(){
        return price;
    }
    public HashMap<String,String>  qtyStore(){
        return qty;
    }
    public HashMap<String,String>  categoryStore(){
        return category;
    }

    public HashSet<String>  cardStore(){
        return card;
    }
}