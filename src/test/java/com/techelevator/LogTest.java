package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogTest {
    protected Log log = new Log();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
    LocalDateTime now = LocalDateTime.now();
    String dateTimeString = now.format(formatter);
    @Test
    public void testWrite() {
        String testStr = "FEED MONEY:" + " $" + BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP) + " $" + BigDecimal.valueOf(5.00).setScale(2, RoundingMode.HALF_UP);
        assertEquals(dateTimeString + " FEED MONEY: $2.00 $5.00", dateTimeString + " " +  testStr);
    }
}
