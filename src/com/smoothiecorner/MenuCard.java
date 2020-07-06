package com.smoothiecorner;

import com.smoothiecorner.model.Ingredient;
import com.smoothiecorner.model.MenuItem;

import java.util.*;

public class MenuCard {
    public static Map<String, MenuItem> menuItemsMap = new HashMap<>();
    public static Map<String, Ingredient> ingredientsMap = new HashMap<>();

    static {
        initializeMenuItems();
    }

    public static MenuItem getMenuItemByName(String name) {
        return menuItemsMap.get(name);
    }

    private static void initializeMenuItems() {
        ingredientsMap.put("sugar", new Ingredient("sugar", 0.5));
        ingredientsMap.put("soda", new Ingredient("soda", 0.5));
        ingredientsMap.put("mint", new Ingredient("mint", 0.5));
        ingredientsMap.put("water", new Ingredient("water", 0.5));
        ingredientsMap.put("milk", new Ingredient("milk", 1));

        menuItemsMap.put("coffee", new MenuItem("coffee", 5,
                getIngredientsList(Arrays.asList("sugar", "milk", "water"))));

        menuItemsMap.put("chai", new MenuItem("chai", 4,
                getIngredientsList(Arrays.asList("sugar", "milk", "water"))));

        menuItemsMap.put("bananaSmoothie".toLowerCase(), new MenuItem("coffee", 6,
                getIngredientsList(Arrays.asList("sugar", "milk", "water"))));

        menuItemsMap.put("strawberryShake".toLowerCase(), new MenuItem("coffee", 7,
                getIngredientsList(Arrays.asList("sugar", "milk", "water"))));

        menuItemsMap.put("mojito", new MenuItem("coffee", 7.5,
                getIngredientsList(Arrays.asList("sugar", "soda", "mint", "water"))));
    }

    private static List<Ingredient> getIngredientsList(List<String> optional) {
        List<Ingredient> ingredientsList = new ArrayList<>();

        optional.stream().forEach(str -> {
            ingredientsList.add(getIngredientByName(str));
        });
        return ingredientsList;
    }

    public static Ingredient getIngredientByName(String name) {
        return ingredientsMap.get(name);
    }

    public static MenuItem getMenuByName(String name) {
        return menuItemsMap.get(name);
    }
}
