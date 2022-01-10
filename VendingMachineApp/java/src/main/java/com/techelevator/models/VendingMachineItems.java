package com.techelevator.models;

import java.math.BigDecimal;

public class VendingMachineItems implements Vendable {

    private String name;
    private BigDecimal price;
    private String itemType;
    private String slotLocation;
    private int stock = 5;
    private String sound;

    public VendingMachineItems(String sound) {
        this.sound = sound;
    }

    public VendingMachineItems(String name, BigDecimal price, String itemType, String slotLocation, int stock) {
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.slotLocation = slotLocation;
        this.stock = stock;
    }




    public String getSound() {
        return sound;
    }

    public String getStockString(){
        if(this.stock==0){
            return "Sold Out";
        }
        return this.stock+"";
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public VendingMachineItems(String name, BigDecimal price, String itemType, String slotLocation) {
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.slotLocation = slotLocation;

    }

}
