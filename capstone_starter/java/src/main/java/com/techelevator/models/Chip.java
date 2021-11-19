package com.techelevator.models;

import java.math.BigDecimal;

public class Chip extends VendingMachineItems{
    public Chip(String name, BigDecimal price, String itemType, String slotLocation) {
        super(name, price, itemType, slotLocation);
    }
}
