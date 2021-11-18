package com.techelevator.models;

import java.math.BigDecimal;

public class Beverage extends VendingMachineItems{
    public Beverage(String name, BigDecimal price, int stock, String slotLocation) {
        super(name, price, stock, slotLocation);
    }

}
