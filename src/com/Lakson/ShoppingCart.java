package com.Lakson;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List itemsInCart = new ArrayList();


    public void addItemToCart(PerishableItems item) {
        this.itemsInCart.add(item);
    }

    public void addItemToCart(ClothesItem item) {
        this.itemsInCart.add(item);
    }

    public void addItemToCart(ApplianceItem item) {
        this.itemsInCart.add(item);
    }

    public List getShoppingCart() {
        return this.itemsInCart;
    }



    public void printItems() {
        for (int i=0; i<itemsInCart.size(); i++) {
            System.out.println(itemsInCart.get(i).toString());
        }
    }
}


