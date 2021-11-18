package com.techelevator.models;

import java.math.BigDecimal;

public class Chip extends VendingMachineItems{
    public Chip(String name, BigDecimal price, int stock, String slotLocation) {
        super(name, price, stock, slotLocation);
    }
}
