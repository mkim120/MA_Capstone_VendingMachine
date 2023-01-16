package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeveragesTest {
    //==tests to run==
    //test that dispense prints out correctly and formatted correctly
    protected String newBeverages(){
        Beverages testBev = new Beverages("B1", "Fanta", 1.00);
        String testString = testBev.getName() + " $" + BigDecimal.valueOf(testBev.getPrice()).setScale(2, RoundingMode.HALF_UP) + "\nGlug Glug, Yum!";
        return testString;
    }
    @Test
    public void testDispense(){
        assertEquals("Fanta $1.00\nGlug Glug, Yum!", newBeverages());
    }
}
