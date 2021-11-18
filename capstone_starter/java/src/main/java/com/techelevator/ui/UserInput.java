package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.VendingMachineItems;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{

    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        switch (option) {
            case "1":
                return "display";
            case "2":
                return "purchase";
            case "3":
                return "exit";
            default:
                return "";
        }

    }
    public static String getPurchaseMenuOptions()
    {

        System.out.println();

        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction");

        System.out.println();


        System.out.println();
        System.out.println("Please select an option: ");

        String selectedOption2 = scanner.nextLine();
        String option2 = selectedOption2.trim().toLowerCase();

        switch (option2) {
            case "1":
                return "feed";
            case "2":
                return "product";
            case "3":
                return "finish";
            default:
                return "";
        }



    }



    public static BigDecimal putMoneyIn(){
        System.out.println("Please insert your cash here:");
        String moneyIn = scanner.nextLine();
        return new BigDecimal(moneyIn);

    }

}
