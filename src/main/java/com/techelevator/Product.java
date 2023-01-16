package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private String slotID;
    private Double price;
    //private String type;
    private String name;
    private int stock;
    public static Log log = new Log();
    private final String SOLD_OUT = "SOLD OUT";

    protected ArrayList<Product> productArrayList = new ArrayList<>() {
    };

    public Product(String slotID, String name, Double price) {
        this.slotID = slotID;
        this.price = price;
        this.name = name;
        this.stock = 5;
    }

    public Product() {

    }

    public int getStock() {
        return stock;
    }

    public String getSlotID() {
        return slotID;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setStock(int stock) {
        if(stock > -1){
            this.stock = stock;
        }
    } //added catch in case a stock of <0 was added.

    public void readInFile() {
        File file = new File("vendingmachine.csv");
        Scanner read = null;
        Product product;
        try {
            read = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        read.useDelimiter("[|\n]|(\r\n)");
        while (read.hasNextLine()) {
            //Product or item class that uses constructor to set values to read values.
            this.slotID = read.next();
            this.name = read.next();
            this.price = read.nextDouble();
            switch (read.next()) {
                case "Chip":
                    productArrayList.add(new Chips(slotID, name, price));
                    break;
                case "Drink":
                    productArrayList.add(new Beverages(this.slotID, this.name, this.price));
                    break;
                case "Candy":
                    productArrayList.add(new Candy(this.slotID, this.name, this.price));
                    break;
                case "Gum":
                    productArrayList.add(new Gum(this.slotID, this.name, this.price));
                    break;
                default:
                    return;
            }
        }
        read.close();
    }

    public ArrayList<Product> arrayList() {
        return productArrayList;
    }

    public void update() {
        log.log(getName() + " " + getSlotID() + " $" + getPrice() + " $" +
                BigDecimal.valueOf(VendingMachineCLI.money.getBalance()).setScale(2, RoundingMode.HALF_UP));
        this.stock -= 1;
    }

    protected void dispense(String ID) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getSlotID().equalsIgnoreCase(ID)) {
                productArrayList.get(i).dispense(ID); //implemented product name + cost + money remaining
            }
        }
    }

    public boolean checkForID(String ID) {
        for (Product i : productArrayList) {
            if (i.getSlotID().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    protected void calculateNewBalance(Money money, String ID) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getSlotID().equalsIgnoreCase(ID)) {
                if (money.getBalance() > productArrayList.get(i).getPrice()) { // check to see if there is enough balance
                    if (productArrayList.get(i).getStock() > 0) { // check if the item is in stock
                        money.setBalance(money.getBalance() - productArrayList.get(i).getPrice());
                        System.out.println();
                        productArrayList.get(i).dispense(ID);
                        break;
                    } else {
                        System.out.println(System.lineSeparator() + "PRODUCT SOLD OUT");
                    }
                } else {
                    System.out.println(System.lineSeparator() + "Balance not enough for this item.");
                }
            }
        }
    }

    public void showItems() {
        System.out.println();
        for (Product i : productArrayList) {
            if (i.stock <= 0) { //if-statement to display an item is out of stock.
//                System.out.println(i.getSlotID() + " " + i.getName() + " $" +
//                        BigDecimal.valueOf(i.getPrice()).setScale(2, RoundingMode.HALF_UP) + " Stock: " + i.SOLD_OUT);

                // printf formatting to display items cleaner
                System.out.printf("%-3s %-18s %-6s %-15s%n", i.getSlotID(), i.getName(), " $" +
                        BigDecimal.valueOf(i.getPrice()).setScale(2, RoundingMode.HALF_UP), " Stock: " + i.SOLD_OUT);
                //BigDecimal.valueOf(i.getPrice()).setScale(2, RoundingMode.HALF_UP))
            } else {
                System.out.printf("%-3s %-18s %-6s %-9s%n", i.getSlotID(), i.getName(), " $" +
                        BigDecimal.valueOf(i.getPrice()).setScale(2, RoundingMode.HALF_UP), " Stock: " + i.getStock());
                // ^ format price tag based on local currency without manually adding $
            }
        }
    }
}
