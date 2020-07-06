package com.smoothiecorner.menu;

import com.smoothiecorner.common.IngredientEnum;

public class Ingredient {

    private IngredientEnum ingredient;
    private boolean isMandatory;

    public Ingredient(IngredientEnum ingredient, boolean isMandatory) {
        this.ingredient = ingredient;
        this.isMandatory = isMandatory;
    }

    public IngredientEnum getIngredient() {
        return ingredient;
    }

    public boolean isMandatory() {
        return isMandatory;
    }
}
