package com.techelevator;

import com.techelevator.view.Menu;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineCLITest {

    public String purchase(int choiceTest, double insertTest) {

        switch (choiceTest) {
            case 1:
                System.out.print(System.lineSeparator() + "Insert Bills >>> ");
                try {
                    if (insertTest > 0 && insertTest % 1.00 == 0) {
                        return "Passes";
                    } else {
                        return "Please enter a valid whole dollar amount.";
                    }
                } catch (InputMismatchException e) {
                    return "Please enter a valid dollar amount.";
                }
        }
        return "Please enter a valid whole dollar amount.";
    }

    @Test
    public void testPurchase() {
        assertEquals("Please enter a valid whole dollar amount.", purchase(2, 1.50));
        assertEquals("Please enter a valid whole dollar amount.", purchase(1, -1));
    }
}
