package com.techelevator.application;
import com.techelevator.models.Logger;
import com.techelevator.models.VendingMachineItems;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import java.time.LocalDateTime;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VendingMachine {
    public BigDecimal currentMoneyProvided = BigDecimal.valueOf(0.0);






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
                Logger logger = new Logger("Log.txt");
                BigDecimal moneyIn = UserInput.putMoneyIn();
                if (moneyIn.equals(BigDecimal.valueOf(5)) || moneyIn.equals(BigDecimal.valueOf(10)) || moneyIn.equals(BigDecimal.valueOf(1)) || moneyIn.equals(BigDecimal.valueOf(20))) {
                    currentMoneyProvided = currentMoneyProvided.add(moneyIn);
                    System.out.println("Current money provided: " + currentMoneyProvided);
                    logger.write(LocalDateTime.now().toString() + " Feed Me! " + currentMoneyProvided);
                } else {
                    System.out.println("UNACCEPTABLE!!!!");
                }
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
                            Logger logger = new Logger("Log.txt");
                            logger.write(LocalDateTime.now().toString() +" "+ item.getName() +" "+ item.getSlotLocation() +" "+
                                    currentMoneyProvided.add(item.getPrice()) +" "+ currentMoneyProvided );
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
                Logger logger = new Logger("Log.txt");
                logger.write(LocalDateTime.now().toString() + " Give Change " + currentMoneyProvided +" 0.0 ");
                currentMoneyProvided.equals(BigDecimal.valueOf(0.0));
                        stay = false;

            }

        } while (stay);


    }
    public void changeCalculator(BigDecimal neededChange) {

        int remainder ;


        double d = neededChange.doubleValue() * 100;

        int numberOfQuarters = (int) (d/25);
        remainder = (int) (d%25);
        int numberOfDimes = remainder /10;
        remainder = remainder % 10;
        int numberOfNickels = remainder / 5;

        System.out.println("Number of Quarters: " + numberOfQuarters + " Number of Dimes: " + numberOfDimes + " Number of Nickels " + numberOfNickels);

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
