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

    public VendingMachine(String positionInMachine, String nameOfProduct, BigDecimal price, String typeOfItem) {
    }

    public VendingMachine() {

    }


        
    public void run() throws IOException {
        List<VendingMachineItems>vendingMachineItems=readVendingMachine();

        boolean shouldLoop = true;
                while(shouldLoop)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots




                System.out.println(readVendingMachine());

            }
            else if(choice.equals("purchase"))
            {
                String purchaseScreen = UserInput.getPurchaseMenuOptions();

                boolean willLoop = true;
                while(willLoop){
                    if (choice.equals("feed")){

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

            VendingMachineItems vendingMachineItems = new VendingMachineItems(positionInMachine, nameOfProduct, price, typeOfItem);

            localVendingMachineItems.add(vendingMachineItems);
            System.out.println(lineArray[0] +" "+ lineArray[1] +" "+ lineArray[2] +" "+ lineArray[3] +" "+ stock);
        }

        return localVendingMachineItems; }


}
