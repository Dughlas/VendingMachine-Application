package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends VendingMachineItems{
    public Candy(String name, BigDecimal price, int stock, String slotLocation) {
        super(name, price, stock, slotLocation);
    }
}
