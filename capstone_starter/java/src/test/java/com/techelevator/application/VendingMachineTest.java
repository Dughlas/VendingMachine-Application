package com.techelevator.application;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineTest {

    @Test
    public void change_Calculator_return_five_quarters(){
        BigDecimal neededChange = BigDecimal.valueOf(1.25);
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.changeCalculator(neededChange);


    }
}