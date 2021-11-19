package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends VendingMachineItems{
    public Gum(String name, BigDecimal price, String itemType, String slotLocation) {
        super(name, price, itemType, slotLocation);
    }
}
