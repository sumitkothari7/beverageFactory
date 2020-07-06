package com.smoothiecorner.service;

import com.smoothiecorner.common.IngredientEnum;
import com.smoothiecorner.order.CustomizedMenuItem;
import com.smoothiecorner.menu.Ingredient;
import com.smoothiecorner.order.Order;

public class OrderValidatorService {

    public static final OrderValidatorService INSTANCE = new OrderValidatorService();

    private OrderValidatorService() {

    }

    public static OrderValidatorService getInstance() {
        return INSTANCE;
    }

    public boolean isValidOrder(Order order) {
        if (order == null || order.getMenuItemList().size() == 0) {
            return false;
        }
        for (CustomizedMenuItem customizedMenuItem : order.getMenuItemList()) {
            if (customizedMenuItem.getRemovedIngredients().size() == 0) {
                continue;
            }
            if (customizedMenuItem.getMenuItem().getIngredients() == null ||
                    customizedMenuItem.getMenuItem().getIngredients().size() == customizedMenuItem.getRemovedIngredients().size()) {
                return false;
            }
            Ingredient mandatoryIngredient = customizedMenuItem.getMenuItem().getMandatoryIngredient();
            if (isMandatoryRemoved(customizedMenuItem, mandatoryIngredient)) {
                return false;
            }

            for (IngredientEnum removed: customizedMenuItem.getRemovedIngredients()) {
                if (isValidIngredient(customizedMenuItem, removed)) {
                    return false;
                }
            }


        }

        return true;
    }

    private boolean isMandatoryRemoved(CustomizedMenuItem customizedMenuItem, Ingredient mandatoryIngredient) {
        return customizedMenuItem.getRemovedIngredients().stream()
                .anyMatch( ingredientEnum -> ingredientEnum.equals(mandatoryIngredient.getIngredient()));
    }

    private boolean isValidIngredient(CustomizedMenuItem customizedMenuItem, IngredientEnum removed) {
        return customizedMenuItem.getMenuItem()
                            .getIngredients()
                            .stream()
                            .noneMatch( ing -> removed.equals(ing.getIngredient()));
    }
}
