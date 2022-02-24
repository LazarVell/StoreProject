package com.Lakson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PerishableItems {
    private final String name;
    private final String brand;
    private double price;
    private final String expirationDate;
    private double quantity;
    private double total;
    private double discount;
    private double discountCounter;

    public PerishableItems(String name, String brand, double price, String expirationDate) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.expirationDate = expirationDate;
    }


    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void addQuantity ( double quantity) {
        this.quantity = quantity;
    }

    public double total ( double quantity, double price){
        this.total = quantity * price;
        double roundedTotal = Math.round(total * 100);
        roundedTotal = roundedTotal/100;
        return roundedTotal;
    }

    public void discount() {
        this.discount = 0;
        this.discountCounter = 0;
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(formatter);
        LocalDate from = LocalDate.parse(expirationDate);
        LocalDate to = LocalDate.parse(date);
        long days = ChronoUnit.DAYS.between(from, to);
        if (days <= 5) {
            discountCounter = 0.3;
            this.discount = total(quantity, price) * discountCounter;
        } else {
            if (days == 0) {
                discountCounter = 0.7;
                this.discount = total(quantity, price) *discountCounter;
            }

        }
        double roundedDiscount = Math.round(discount * 100);
        roundedDiscount = roundedDiscount/100;
        discount = roundedDiscount;
    };

    @Override
    public String toString() {
        discount();
        String returnString = this.getName() + " " + this.getBrand() + "\n" +
                this.quantity+ " x $" + this.price + " = $" + total(quantity, price);
        String finalString = returnString +"\n";
        if (this.discount != 0) {
            String discountString = "\n" +
                    "#discount " + ((int)(discountCounter *100)) + "% -$"+ this.discount;
            finalString = returnString + discountString +"\n";
        };
        return finalString;
    }
}
