package com.techelevator.application;

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

public class VendingMachine 
{
    public BigDecimal currentMoneyProvided = BigDecimal.valueOf(0.0);

    public VendingMachine(BigDecimal currentMoneyProvided, int stock) {
        this.currentMoneyProvided = currentMoneyProvided;
        this.stock = stock;
    }

    public BigDecimal getCurrentMoneyProvided() {
        return currentMoneyProvided;
    }

    public void setCurrentMoneyProvided(BigDecimal currentMoneyProvided) {
        this.currentMoneyProvided = currentMoneyProvided;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public VendingMachine(String positionInMachine, String nameOfProduct, BigDecimal price, String typeOfItem) {
    }

    public VendingMachine() {

    }


        
    public void run() throws IOException {
        List<VendingMachineItems>vendingMachineItems=readVendingMachine();


                while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots

            UserOutput.printVendingItems(vendingMachineItems);


            }
            else if(choice.equals("purchase"))
            {
                String purchaseScreen = UserInput.getPurchaseMenuOptions();

                while(true){
                        if (purchaseScreen.equals("feed")) {


                            BigDecimal moneyIn = UserInput.putMoneyIn();
                            currentMoneyProvided= currentMoneyProvided.add(moneyIn);
                            System.out.println("Current money provided: "+currentMoneyProvided);
                            UserInput.getPurchaseMenuOptions();


                        }
                        else if(purchaseScreen.equals("product")){
                            System.out.println("yay");
                            break;
                        }
                        else if (purchaseScreen.equals("finish")){

                        }
                        }
            }
            else if(choice.equals("exit"))
            {
                System.out.println("Good Bye!");
                break;
            }
        }
    }
    int stock = 5;
    private List<VendingMachineItems> readVendingMachine() throws IOException {
        File file = new File("vendingmachine.csv");
        List<VendingMachineItems> localVendingMachineItems = new ArrayList<>();
        Scanner fileScanner = new Scanner(file);
        while  (fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            String[] lineArray = line.split("\\|");

            String positionInMachine = lineArray[0];
            String nameOfProduct = lineArray[1];
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble((lineArray[2])));
            String typeOfItem = lineArray[3];

            VendingMachineItems vendingMachineItems = new VendingMachineItems(nameOfProduct, price, stock, typeOfItem);

            localVendingMachineItems.add(vendingMachineItems);
//            System.out.println(lineArray[0] +" "+ lineArray[1] +" "+ lineArray[2] +" "+ lineArray[3] +" "+ stock);
        }
        System.out.println(localVendingMachineItems.get(1).getName());
        return localVendingMachineItems; }

}
