package com.smoothiecorner.menu;

import java.util.List;


public class MenuItem {

    public MenuItem(String name,
                    double price,
                    List<Ingredient> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    private String name;
    private double price;
    private List<Ingredient> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient getMandatoryIngredient() {
        if (getIngredients() != null && getIngredients().size() > 0) {
            return getIngredients().stream().filter(ing -> ing.isMandatory()).findFirst().orElse(null);
        }
        return null;
    }
}
