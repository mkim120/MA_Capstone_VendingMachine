package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandyTest {
    //==tests to run==
    //test that dispense prints out correctly and formatted correctly
    protected String newCandy(){
        Beverages testBev = new Beverages("B1", "Twix", 1.00);
        String testString = testBev.getName() + " $" + BigDecimal.valueOf(testBev.getPrice()).setScale(2, RoundingMode.HALF_UP) + "\nMunch Munch, Yum!";
        return testString;
    }
    @Test
    public void testDispense(){
        assertEquals("Twix $1.00\nMunch Munch, Yum!", newCandy());
    }
}
