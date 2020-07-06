package com.somoothiecorner.order;

import com.smoothiecorner.exception.IngredientNotFoundException;
import com.smoothiecorner.exception.InvalidOrderException;
import com.smoothiecorner.exception.MenuItemNotFoundException;
import com.smoothiecorner.order.OrderProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderProcessorTest {

    OrderProcessor processor = null;

    @Before
    public void setUp() {
        processor = new OrderProcessor();
    }


    @Test(expected = InvalidOrderException.class)
    public void test_buildOrder_ToThrowException_whenInputStringIsNull() throws Exception {
        processor.processOrder(null);
    }

    @Test(expected = InvalidOrderException.class)
    public void test_buildOrder_ToThrowException_whenInputStringIsEmpty() throws Exception {
        processor.processOrder("");
    }

    @Test(expected = MenuItemNotFoundException.class)
    public void test_buildOrder_ToThrowException_whenMenuIsWrong() throws Exception {
        processor.processOrder("coff");
    }

    @Test(expected = IngredientNotFoundException.class)
    public void test_buildOrder_ToThrowException_whenIngredientIsWrong() throws Exception {
        processor.processOrder("coffee -su");
    }

    @Test(expected = MenuItemNotFoundException.class)
    public void test_buildOrder_ToThrowException_whenIngredientIsRemovedBeforeMenu() throws Exception {
        processor.processOrder("-sugar coffee");
    }

    @Test(expected = IngredientNotFoundException.class)
    public void test_buildOrder_ToThrowException_whenMandatoryIngredientIsRemoved() throws Exception {
        processor.processOrder("coffee -coffee");
    }

    @Test(expected = InvalidOrderException.class)
    public void test_buildOrder_ToGerOrderAmount_whenChaiWithSoda() throws Exception {
        processor.processOrder("chai -soda ");
    }

    @Test
    public void test_buildOrder_ToGerOrderAmount5_whenCoffeeOrderPlaced() throws Exception {
        Assert.assertEquals("Order Amount tally",
                5.0, processor.processOrder("coffee"), 0);
    }

    @Test
    public void test_buildOrder_ToGerOrderAmount_whenCoffeeWithoutSugarOrderPlaced() throws Exception {
        Assert.assertEquals("Order Amount tally",
                4.5, processor.processOrder("coffee -sugar"), 0);
    }

    @Test
    public void test_buildOrder_ToGerOrderAmount_whenCoffeeWithoutSugarMilkOrderPlaced() throws Exception {
        Assert.assertEquals("Order Amount tally",
                3.5, processor.processOrder("coffee -sugar -milk"), 0);
    }

    @Test
    public void test_buildOrder_ToGerOrderAmount_whenCoffeeWithoutSugarMilkAndChaiOrderPlaced() throws Exception {
        Assert.assertEquals("Order Amount tally",
                7.5, processor.processOrder("coffee -sugar -milk chai"), 0);
    }

    @Test
    public void test_buildOrder_ToGerOrderAmount_whenCoffeeChaiBananaStrawberryMojitoOrderPlaced() throws Exception {
        Assert.assertEquals("Order Amount tally",
                29.5, processor.processOrder("coffee chai bananaSmoothie strawberryShake mojito"), 0);
    }

    @Test
    public void test_buildOrder_ToGerOrderAmount_whenCoffeeWithoutMultipleSameIngredientRemovedOrderPlaced() throws Exception {
        Assert.assertEquals("Order Amount tally",
                3.5, processor.processOrder("coffee -sugar -milk -sugar"), 0);
    }

}
