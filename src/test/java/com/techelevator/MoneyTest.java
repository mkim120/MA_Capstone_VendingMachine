package com.techelevator;

import org.junit.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {
    private double balance;
    //private double change;

    private int quarters;
    private int dimes;
    private int nickels;
    private Money money;

    @Before
    public void initialize(){
       money = new Money(5);
    }

    //==tests to run==
    //test that balance is being set correctly
    //test for negative input being added

    public String calculateChange(int balance) {

        double totalChange = balance;
        int change = (int)(Math.ceil(balance*100));

        int dollars = Math.round((int)change/100);
        change=change%100;
        quarters = Math.round((int)change/25);
        change=change%25;
        dimes = Math.round((int)change/10);
        change=change%10;
        nickels = Math.round((int)change/5);
        //change=change%5;
        //int pennies = Math.round((int)change/1);

        money.setBalance(0);

        int totalQuarters = quarters + (dollars * 4);
        return System.lineSeparator() +
                "Quarters: " + totalQuarters + System.lineSeparator() +
                "Dimes: " + dimes + System.lineSeparator() +
                "Nickels: " + nickels + System.lineSeparator() +
                "Total change: $" + BigDecimal.valueOf(totalChange).setScale(2, RoundingMode.HALF_UP) + System.lineSeparator() +
                "Balance: $" + BigDecimal.valueOf(this.balance).setScale(2,RoundingMode.HALF_UP);
    }

    @Test
    public void test_feed_money(){
        money.feedMoney(5);
        assertEquals(10.00, money.getBalance());
    }

    @Test (expected = NullPointerException.class)
    public void test_money_null(){
       money = null;
        assertEquals(10.00, money.getBalance());
    }

    @Test
    public void test_change(){
        assertEquals(System.lineSeparator() +
                "Quarters: " + "40" + System.lineSeparator() +
                "Dimes: " + dimes + System.lineSeparator() +
                "Nickels: " + nickels + System.lineSeparator() +
                "Total change: $" + BigDecimal.valueOf(10).setScale(2, RoundingMode.HALF_UP) + System.lineSeparator() +
                "Balance: $" + BigDecimal.valueOf(this.balance).setScale(2,RoundingMode.HALF_UP),
                this.calculateChange(10));
    }
}
