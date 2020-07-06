package com.smoothiecorner.service;

import com.smoothiecorner.order.CustomizedMenuItem;
import com.smoothiecorner.common.IngredientEnum;
import com.smoothiecorner.order.Order;

import java.util.Set;

public class PriceCalculatorService {

    public static final PriceCalculatorService INSTANCE = new PriceCalculatorService();

    private PriceCalculatorService() {

    }

    public static PriceCalculatorService getInstance() {
        return INSTANCE;
    }

    public double calculatePrice(Order order) {
        if (order == null || order.getMenuItemList().size() == 0) {
            return 0;
        }

        return order.getMenuItemList().stream().mapToDouble(this::getPrice).sum();
    }

    public double getPrice(CustomizedMenuItem menuItem) {
        if (menuItem == null) {
            return 0;
        }

        return menuItem.getMenuItem().getPrice() - getPriceForIngredient(menuItem.getRemovedIngredients());

    }

    private double getPriceForIngredient(Set<IngredientEnum> ingredientEnums) {
        if (ingredientEnums.size() == 0) {
            return 0;
        }
        return ingredientEnums.stream().mapToDouble(IngredientEnum::getPrice).sum();
    }
}
