package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends VendingMachineItems{
    public Candy(String name, BigDecimal price, String itemType, String slotLocation) {
        super(name, price, itemType, slotLocation);
    }
}
