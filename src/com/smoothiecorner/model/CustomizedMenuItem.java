package com.smoothiecorner.model;

import com.smoothiecorner.validation.Validator;

import java.util.HashSet;
import java.util.Set;

public class CustomizedMenuItem implements Validator {

    public CustomizedMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    private MenuItem menuItem;
    private Set<Ingredient> removedIngredients = new HashSet<>();

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Set<Ingredient> getRemovedIngredients() {
        return removedIngredients;
    }

    public void removeIngredient(Ingredient ingredientToRemove) {
        removedIngredients.add(ingredientToRemove);
    }

    @Override
    public boolean isValid() {
        if (getRemovedIngredients().size() == 0) {
            return true;
        }
        if (getMenuItem().getIngredients() == null ||
                getMenuItem().getIngredients().size() == getRemovedIngredients().size()) {
            return false;
        }

        for (Ingredient removed : getRemovedIngredients()) {
            if (isValidIngredient(removed)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIngredient(Ingredient removed) {
        return getMenuItem()
                .getIngredients()
                .stream()
                .noneMatch(ing -> removed.getName().equals(ing.getName()));
    }
}
