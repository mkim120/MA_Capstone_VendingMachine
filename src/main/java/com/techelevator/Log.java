package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Log {
    public static Log log = new Log();
    private String logList = "";
    private Product product = new Product();
    public Log(){

    }

    public void log(String message) {
        try (FileWriter dataOutput = new FileWriter("Log.txt", true)) {
            DateTimeFormatter formatter
                    = DateTimeFormatter.ofPattern(
                    "dd/MM/yyyy hh:mm:ss a");
            LocalDateTime now = LocalDateTime.now();
            String dateTimeString = now.format(formatter);
            // output needed for every time money is fed, every purchase, and final change given
            dataOutput.write(dateTimeString + " " +  message + System.lineSeparator());
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getSalesReport(Product product) {
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.format(formatter);
        try (PrintWriter dataOutput = new PrintWriter(new File(dateTimeString + "-Sales-Report.txt"))) {

            //LocalDateTime datetime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            System.out.println(System.lineSeparator() + "Sales Report file created.");

            BigDecimal totalSales = new BigDecimal("0.00");

            for (int i = 0; i < product.arrayList().size(); i++) {
                // output product name and remaining stock to file
                dataOutput.println(product.productArrayList.get(i).getName() + "|" + (5 - product.productArrayList.get(i).getStock()));
                // ^ get max stock from Product object instead of hard coding 5
                totalSales = totalSales.add(BigDecimal.valueOf(product.productArrayList.get(i).getPrice()).setScale(2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(5 - product.productArrayList.get(i).getStock())));
            }
            // output total sales to file
            dataOutput.println(System.lineSeparator() + "TOTAL SALES: " + totalSales);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        }
    }

    public String getLogList() {
        return logList;
    }
}
