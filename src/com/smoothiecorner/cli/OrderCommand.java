package com.smoothiecorner.cli;

import com.smoothiecorner.exception.IngredientNotFoundException;
import com.smoothiecorner.exception.InvalidOrderException;
import com.smoothiecorner.exception.MenuItemNotFoundException;
import com.smoothiecorner.order.OrderProcessor;

public class OrderCommand implements Command {

    @Override
    public void execute(String command) throws MenuItemNotFoundException, InvalidOrderException, IngredientNotFoundException {
        OrderProcessor processor = new OrderProcessor();
        double orderAmount = processor.processOrder(command);
        System.out.println("Order amount is :: " + orderAmount);
    }
}
