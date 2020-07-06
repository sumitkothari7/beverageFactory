package com.smoothiecorner.order;

import com.smoothiecorner.menu.MenuItem;
import com.smoothiecorner.common.IngredientEnum;

import java.util.HashSet;
import java.util.Set;

public class CustomizedMenuItem {

    public CustomizedMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    private MenuItem menuItem;
    private Set<IngredientEnum> removedIngredients = new HashSet<>();

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Set<IngredientEnum> getRemovedIngredients() {
        return removedIngredients;
    }

    public void removeIngredient(IngredientEnum in) {
        removedIngredients.add(in);
    }
}
