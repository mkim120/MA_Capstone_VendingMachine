package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GumTest {
    //==tests to run==
    //test that dispense prints out correctly and formatted correctly
    protected String newBeverages(){
        Gum testBev = new Gum("B1", "Hubba Bubba", 1.00);
        String testString = testBev.getName() + " $" + BigDecimal.valueOf(testBev.getPrice()).setScale(2, RoundingMode.HALF_UP) + "\nChew Chew, Yum!";
        return testString;
    }
    @Test
    public void testDispense(){
        assertEquals("Hubba Bubba $1.00\nChew Chew, Yum!", newBeverages());
    }
}
