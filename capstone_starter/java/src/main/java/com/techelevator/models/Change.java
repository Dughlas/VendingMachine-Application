package com.techelevator.models;

import com.techelevator.application.VendingMachine;

import java.math.BigDecimal;

public class Change  {
    public BigDecimal quarter = BigDecimal.valueOf(0.25);
    public BigDecimal dime = BigDecimal.valueOf(0.10);
    public BigDecimal nickel = BigDecimal.valueOf(0.05);

    public Change() {
    }

    public Change(BigDecimal quarter, BigDecimal dime, BigDecimal nickel) {
        this.quarter = quarter;
        this.dime = dime;
        this.nickel = nickel;
    }

    public BigDecimal getQuarter() {
        return quarter;
    }

    public BigDecimal getDime() {
        return dime;
    }

    public BigDecimal getNickel() {
        return nickel;
    }


    }

