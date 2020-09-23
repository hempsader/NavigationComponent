package com.example.navigationcomponent.data;

import java.util.HashMap;

public class Database {
    private static Database instance;
    private static HashMap<String,Integer> db = null;

    public static Database getInstance()
    {
        if(instance == null)
        {
            instance = new Database();
        }
        return instance;
    }

    private Database()
    {
        db = new HashMap<>();
        db.put("food",400);
        db.put("data",200);
        db.put("games",100);
        db.put("rent",300);
    }

    public HashMap<String,Integer> getDb()
    {
        return db;
    }
    public void addData(String data, int amount)
    {
        db.put(data,amount);
    }


}
