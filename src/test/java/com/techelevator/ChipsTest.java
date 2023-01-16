package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChipsTest {
    //==tests to run==
    //test that dispense prints out correctly and formatted correctly
    protected String newBeverages(){
        Chips testBev = new Chips("B1", "Lays", 1.00);
        String testString = testBev.getName() + " $" + BigDecimal.valueOf(testBev.getPrice()).setScale(2, RoundingMode.HALF_UP) + "\nCrunch Crunch, Yum!";
        return testString;
    }
    @Test
    public void testDispense(){
        assertEquals("Lays $1.00\nCrunch Crunch, Yum!", newBeverages());
    }
}
