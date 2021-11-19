package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.Gum;
import com.techelevator.models.Stock;
import com.techelevator.models.Vendable;
import com.techelevator.models.VendingMachineItems;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * <p>
 * Dependencies: None
 */
public class UserOutput {


    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void printVendingItems(List<VendingMachineItems> printList) {
        for (VendingMachineItems item : printList) {

            System.out.println(item.getSlotLocation() + " " + item.getName() + " " + item.getPrice() + " " + item.getItemType() + " " + item.getStockString());

        }


    }

    public static void printJustItemsAndCodes(List<VendingMachineItems> printList) {
        for (VendingMachineItems item : printList) {
            System.out.println(item.getSlotLocation() + " " + item.getName());

        }

    }

    public static void printInvalid() {
        System.out.println("Invalid selection");

    }

    public static void printSoldOut(List<VendingMachineItems> printList) {
        for (VendingMachineItems item : printList) {
            if (item.getStock() < 1) {
                System.out.println("SOLDOUT");

            }

        }

    }
    public static void vendingSound(){
        Vendable[] vendable = new Vendable[]{(Vendable) new Gum()};
        for(Vendable sound : vendable)
        String noise = sound.getSound();
        System.out.println();
    }

}
