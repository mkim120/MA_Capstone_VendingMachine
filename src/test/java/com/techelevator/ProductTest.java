package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    private Product product0;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product;
    private Product nullProduct;
    private Money money;

    @Before
    public void initialize() {
        product = new Product();
        product0 = new Beverages("A0","test0",0d);
        product1 = new Chips("A1", "test1", 10d);
        product2 = new Gum("A2", "test2", 20d);
        product3 = new Beverages("A3", "test3", 30d);
        product.productArrayList.add(product0);
        product.productArrayList.add(product1);
        product.productArrayList.add(product2);
        product.productArrayList.add(product3);
        nullProduct = new Product(null, null, null);
        money = new Money(100);
    }

    @Test
    public void id_is_not_in_the_arraylist(){
        product.checkForID("A4");
        assertEquals("ID is located in arraylist.", false, product.checkForID("A4"));
    }

    @Test
    public void id_is_in_the_arraylist(){
        product.checkForID("A0");
        assertEquals("ID not located in arraylist.", true, product.checkForID("A0"));
    }
    @Test
    public void product_is_not_null(){
        nullProduct = new Product("A2", "test", 3.50);
        assertNotNull("Test failed, name is null", nullProduct.getName());
        assertNotNull("Test failed, slotID is null", nullProduct.getSlotID());
        assertNotNull("Test failed, price is null", nullProduct.getPrice());
    }

    @Test
    public void product_is_not_in_stock(){
        money.setBalance(100);
        product0.setStock(0);
        product.calculateNewBalance(money,"A0");
        assertEquals(0, product0.getStock());
    }

    @Test
    public void product_is_in_stock(){
        assertEquals(true , product1.getStock()>0);
    }

    @Test
    public void stock_is_not_greater_than_0(){
        nullProduct.setStock(-1); //do we need to include the set stock function?
        assertEquals(5, nullProduct.getStock()); //make sure stock can't be set to -1
    }

    @Test (expected = NullPointerException.class)
    public void product_is_null(){
        nullProduct = null;
        assertEquals("Test Failed", "", nullProduct.getName());
    }
}
