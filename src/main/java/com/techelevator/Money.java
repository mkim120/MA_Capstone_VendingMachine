package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private double balance;
    //private double change;

    private int quarters;
    private int dimes;
    private int nickels;

    public Money(int moneyInserted) {
        this.balance = moneyInserted;
    }

    public Money() {

    }

    public void feedMoney(double money) {
        setBalance((balance += money));
        Product.log.log("FEED MONEY: " + "$" + BigDecimal.valueOf(money).setScale(2, RoundingMode.HALF_UP) + " $" + BigDecimal.valueOf(getBalance()).setScale(2, RoundingMode.HALF_UP));
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void calculateChange() {

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

        setBalance(0);

        int totalQuarters = quarters + (dollars * 4);

        System.out.println(System.lineSeparator() +
                "Quarters: " + totalQuarters + System.lineSeparator() +
                "Dimes: " + dimes + System.lineSeparator() +
                "Nickels: " + nickels + System.lineSeparator() +
                "Total change: $" + BigDecimal.valueOf(totalChange).setScale(2, RoundingMode.HALF_UP) + System.lineSeparator() +
                "Balance: $" + BigDecimal.valueOf(this.balance).setScale(2,RoundingMode.HALF_UP));
        Product.log.log("GIVE CHANGE: $" + BigDecimal.valueOf(totalChange).setScale(2, RoundingMode.HALF_UP) + " $" + BigDecimal.valueOf(getBalance()).setScale(2, RoundingMode.HALF_UP));
    }
}
