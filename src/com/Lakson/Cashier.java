package com.Lakson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Cashier {

    public void receipt (List shoppingCart){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));

        System.out.println("Date:" + date);
        System.out.println("---Products---");
        System.out.println(" ");
        for (int i=0; i < shoppingCart.size(); i++) {

        }
    }
}
