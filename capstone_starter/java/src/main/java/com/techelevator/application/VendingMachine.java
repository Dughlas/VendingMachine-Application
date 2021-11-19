package com.techelevator.application;

import com.techelevator.models.Vendable;
import com.techelevator.models.VendingMachineItems;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    public BigDecimal currentMoneyProvided = BigDecimal.valueOf(0.0);


    public VendingMachine(BigDecimal currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;

    }

    public BigDecimal getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public void setCurrentMoneyProvided(BigDecimal currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }



    private List<VendingMachineItems> vendingMachineItems;

    public VendingMachine() {
        try {
            this.vendingMachineItems = readVendingMachine();
        } catch (IOException e) {

        }
    }



    public void run() throws IOException {
        while (true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {
                UserOutput.printVendingItems(vendingMachineItems);
            } else if (choice.equals("purchase")) {
                option2Choices();
            } else if (choice.equals("exit")) {
                break;
            }

        }
    }

    public void option2Choices() {

        boolean stay = true;
        do {

            String choice = UserInput.getPurchaseMenuOptions();

            if (choice.equals("feed")) {
                BigDecimal moneyIn = UserInput.putMoneyIn();
                currentMoneyProvided = currentMoneyProvided.add(moneyIn);
                System.out.println("Current money provided: " + currentMoneyProvided);
            }
            else if (choice.equals("product")) {
                UserOutput.printJustItemsAndCodes(vendingMachineItems);
                String code = UserInput.selectItemCode();

                boolean itemPresent = false;


                for (int i = 0; i < vendingMachineItems.size(); i++) {
                    VendingMachineItems item = vendingMachineItems.get(i);

                    if (item.getSlotLocation().equals(code)) {
                        System.out.println("found it");
                        itemPresent = true;


                        // check if there is there is enough money to buy



                        }
                    if(itemPresent && currentMoneyProvided.compareTo(item.getPrice()) > 0){
                        currentMoneyProvided = currentMoneyProvided.subtract(item.getPrice());
                        item.setStock(item.getStock() - 1);

                    }
                }

                if (!itemPresent) {
                    System.out.println("product doesn't exist");
                }

            }
            else if (choice.equals("finish")) {
                stay = false;
            }

        } while (stay);


    }


    private List<VendingMachineItems> readVendingMachine() throws IOException {

        File file = new File("vendingmachine.csv");
        List<VendingMachineItems> localVendingMachineItems = new ArrayList<>();
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] lineArray = line.split("\\|");

            String positionInMachine = lineArray[0];
            String nameOfProduct = lineArray[1];
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble((lineArray[2])));
            String typeOfItem = lineArray[3];


            VendingMachineItems vendingMachineItems = new VendingMachineItems(nameOfProduct, price, typeOfItem, positionInMachine);

            localVendingMachineItems.add(vendingMachineItems);
//            System.out.println(lineArray[0] +" "+ lineArray[1] +" "+ lineArray[2] +" "+ lineArray[3] +" "+ stock);
        }
        System.out.println(localVendingMachineItems.get(1).getName());
        return localVendingMachineItems;
    }

}
