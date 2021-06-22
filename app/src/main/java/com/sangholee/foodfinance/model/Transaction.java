package com.sangholee.foodfinance.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private int id;
    private String title;
    private Date date;
    private String details;
    private double amount;
    private String category;

    public Transaction(int id, String title, Date date, String details, double amount, String category) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.details = details;
        this.amount = amount;
        this.category = category;
    }

    public Transaction(int id, String title, String details, double amount, String category) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.amount = amount;
        this.category = category;
        this.date = null;
    }
    public String getTitle() {
        return title;
    }
    public String getAmount() {
        return Double.toString(amount);
    }
    public String getDate() {
        DateFormat format = new SimpleDateFormat("mm-dd-yyyy");
        return format.format(date);
    }
    public String getCategory() {
        return category;
    }

    public static ArrayList<Transaction> dummyList() {
        ArrayList<Transaction> list = new ArrayList<Transaction>();

        list.add(new Transaction(1,"Lunch","LunchDetails",10.00,"UBR"));
        list.add(new Transaction(2,"Dinner","DinnerDetails",20.00,"CSH"));
        list.add(new Transaction(3,"Breakfast","BreakfastDetails",100.00,"CSH"));
        list.add(new Transaction(4,"TeaTime","TeatTimeDetails",125.20,"DIL"));
        list.add(new Transaction(5,"Snack","SnackDetails",9999,"ARK"));
        return list;
    }
}
