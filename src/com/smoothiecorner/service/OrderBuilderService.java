package com.smoothiecorner.service;

import com.smoothiecorner.common.Constants;
import com.smoothiecorner.exception.IngredientNotFoundException;
import com.smoothiecorner.exception.InvalidOrderException;
import com.smoothiecorner.exception.MenuItemNotFoundException;
import com.smoothiecorner.order.CustomizedMenuItem;
import com.smoothiecorner.common.IngredientEnum;
import com.smoothiecorner.menu.MenuItem;
import com.smoothiecorner.menu.MenuItemFactory;
import com.smoothiecorner.order.Order;

public class OrderBuilderService {

    public static final OrderBuilderService INSTANCE = new OrderBuilderService();

    private OrderBuilderService() {

    }

    public static OrderBuilderService getInstance() {
        return INSTANCE;
    }

    public Order buildOrder(String inputString) throws InvalidOrderException, MenuItemNotFoundException, IngredientNotFoundException {
        if (inputString == null || "".equalsIgnoreCase(inputString)) {
            throw new InvalidOrderException();
        }
        String[] orderArrayInput = inputString.split(" ");
        if (orderArrayInput == null || orderArrayInput.length == 0) {
            throw new InvalidOrderException();
        }
        Order order = createOrder(orderArrayInput);
        return order;
    }

    private Order createOrder(String[] orderArrayInput) throws MenuItemNotFoundException, IngredientNotFoundException {
        Order order = new Order();
        CustomizedMenuItem customizedMenuItem = null;
        for (String orderString : orderArrayInput) {
            orderString = orderString.trim();
            if (isMenu(orderString)) {
                customizedMenuItem = getCustomizedMenuItem(order, orderString);
            } else {
                removeIngredientFromMenuItem(customizedMenuItem, orderString);
            }
        }
        return order;
    }

    private void removeIngredientFromMenuItem(CustomizedMenuItem customizedMenuItem,
                                              String orderString) throws MenuItemNotFoundException, IngredientNotFoundException {
        if (customizedMenuItem == null) {
            throw new MenuItemNotFoundException();
        }
        IngredientEnum e = IngredientEnum.getIngredientByName(orderString.substring(1));
        if (e == null) {
            throw new IngredientNotFoundException();
        }
        customizedMenuItem.removeIngredient(e);
    }

    private CustomizedMenuItem getCustomizedMenuItem(Order order,
                                                     String orderString) throws MenuItemNotFoundException {
        CustomizedMenuItem customizedMenuItem;
        MenuItem menuItem = MenuItemFactory.getMenuItem(orderString);
        customizedMenuItem = new CustomizedMenuItem(menuItem);
        order.addMenuItem(customizedMenuItem);
        return customizedMenuItem;
    }

    private boolean isMenu(String order) {
        return !isIngredient(order);
    }

    private boolean isIngredient(String order) {
        if (order == null) {
            return false;
        }
        return Constants.MINUS.equals(order.charAt(0));
    }
}
