package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Beverages extends Product implements Vendable {
    public Beverages(String slotID, String name, Double price) {
        super(slotID, name, price);
    }

    @Override
    public void dispense(String ID) {
        super.dispense(ID);
        //addition
        System.out.println(super.getName() + " $" +
                BigDecimal.valueOf(super.getPrice()).setScale(2, RoundingMode.HALF_UP));

        System.out.println("Glug Glug, Yum!");

        super.update();
    }
}