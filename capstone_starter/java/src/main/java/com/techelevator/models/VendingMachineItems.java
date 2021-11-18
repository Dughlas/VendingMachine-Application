package com.techelevator.models;

import java.math.BigDecimal;

public class VendingMachineItems {
    private String name;
    private BigDecimal price;
    private int stock;
    private String slotLocation;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public VendingMachineItems(String name, BigDecimal price, int stock, String slotLocation) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.slotLocation = slotLocation;

    }
}
