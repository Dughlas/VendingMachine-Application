package com.techelevator.models;

import java.math.BigDecimal;

public class Beverage extends VendingMachineItems{
    public Beverage(String name, BigDecimal price, String itemType, String slotLocation) {
        super(name, price, itemType, slotLocation);
    }

}
