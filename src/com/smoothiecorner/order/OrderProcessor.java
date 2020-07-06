package com.smoothiecorner.order;

import com.smoothiecorner.exception.IngredientNotFoundException;
import com.smoothiecorner.exception.InvalidOrderException;
import com.smoothiecorner.exception.MenuItemNotFoundException;
import com.smoothiecorner.model.Order;
import com.smoothiecorner.service.OrderBuilderService;
import com.smoothiecorner.service.PriceCalculatorService;

public class OrderProcessor {

    public double processOrder(String orderString) throws InvalidOrderException,
            MenuItemNotFoundException, IngredientNotFoundException {
        if (orderString == null) {
            throw new InvalidOrderException();
        }
        Order order = OrderBuilderService.getInstance().buildOrder(orderString);
        if (order.isValid()) {
            return PriceCalculatorService.getInstance().calculatePrice(order);
        } else {
            throw new InvalidOrderException();
        }
    }
}
