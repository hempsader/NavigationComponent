package com.example.navigationcomponent.data;

import java.util.HashMap;

public class Database {
    private static HashMap<String,Integer> db = new HashMap<>();
    private Database(){}
    public static HashMap<String,Integer> getDb()
    {
        if(db == null)
        {
            db = new HashMap<>();
        }
        db.put("food",400);
        db.put("data",200);
        db.put("games",100);
        db.put("rent",300);
        return db;
    }

    public static void setData(String key, int amount)
    {
        db.put(key,amount);
    }

}
