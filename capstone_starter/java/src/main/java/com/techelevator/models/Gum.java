package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends VendingMachineItems{
    public Gum(String name, BigDecimal price, int stock, String slotLocation) {
        super(name, price, stock, slotLocation);
    }
}
