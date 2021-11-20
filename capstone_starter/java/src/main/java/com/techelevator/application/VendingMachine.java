package com.techelevator.application;

import com.techelevator.models.Change;
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
import java.util.logging.Logger;

public class VendingMachine extends Change {
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

                        itemPresent = true;



                        // check if there is there is enough money to buy



                        }
                    if(itemPresent && currentMoneyProvided.compareTo(item.getPrice()) > 0) {
                        currentMoneyProvided = currentMoneyProvided.subtract(item.getPrice());

                        if (item.getStock() >= 1) {
                            item.setStock(item.getStock() - 1);
                            UserOutput.vendingSound();
                            System.out.println(currentMoneyProvided);
                            break;

                        }
                        if (item.getStock() < 1) {
                            UserOutput.printSoldOut();
                           break;
                        }
                    }
                    if(currentMoneyProvided.compareTo(item.getPrice()) < 0){
                        UserOutput.youreBroke();
                        break;
                    }

                }

                if (!itemPresent) {
                    System.out.println("product doesn't exist");
                }

            }
            else if (choice.equals("finish")) {
                changeCalculator(currentMoneyProvided);
                stay = false;
            }

        } while (stay);


    }
    public void changeCalculator(BigDecimal currentMoneyProvided) {
       Double quarterCount = 0.0;
        Double dimeCount = 0.0;
        Double nickelCount = 0.0;
        Double remainder = 0.0;
        Double remainder2 = 0.0;

        Double cmpDouble = currentMoneyProvided.doubleValue();

        quarterCount = cmpDouble / .25;

        remainder = cmpDouble % 0.25;
        dimeCount = remainder / .10;
        remainder2 = remainder % .10;
        nickelCount = remainder2 / .05;

        Integer quarterInt = quarterCount.intValue();
        Integer dimeInt = dimeCount.intValue();
        Integer nickelInt = nickelCount.intValue();

        System.out.println("Quarters: "+quarterInt+" Dimes: "+dimeInt+ " Nickels: "+nickelInt);
        currentMoneyProvided = BigDecimal.valueOf(0.0);
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
