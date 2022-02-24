package com.Lakson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class ApplianceItem {

    private final String name;
    private final String brand;
    private final double price;
    private final String model;
    private final String productionDate;
    private final double weight;
    private double quantity;
    private double discount;
    private double discountCounter;
    private double total;

    public ApplianceItem(String name, String brand, double price, String model, String productionDate, double weight) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.model = model;
        this.productionDate = productionDate;
        this.weight = weight;
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

    public String getModel() {
        return model;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public double getWeight() {
        return weight;
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
        Calendar cal = Calendar.getInstance();
        int today = cal.get(Calendar.DAY_OF_WEEK);
        if ((today == 7 || today == 8) && (this.price > 999)) {
            discountCounter = 0.07;
            this.discount = total(quantity, price) * discountCounter;
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

