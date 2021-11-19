package com.techelevator.models;

import java.math.BigDecimal;

public class Stock extends VendingMachineItems{
    private int stock=5;


    public Stock(String name, BigDecimal price, String itemType, String slotLocation, int stock) {
        super(name, price, itemType, slotLocation);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}

