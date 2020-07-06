package com.smoothiecorner;

import com.smoothiecorner.common.IngredientEnum;
import com.smoothiecorner.common.MenuItemsEnums;
import com.smoothiecorner.menu.Ingredient;
import com.smoothiecorner.menu.MenuItem;

import java.util.*;

public class MenuItemCache {

    public static Map<String, MenuItem> menuItemCache = new HashMap<>();

    static {
        initializeMenuItems();
    }

    public static MenuItem getMenuItemByName(String name) {
        return menuItemCache.get(name);
    }

    private static void initializeMenuItems() {

        menuItemCache.put(MenuItemsEnums.Coffee.name(), new MenuItem(MenuItemsEnums.Coffee.name(), 5,
                getIngredientsList(IngredientEnum.COFFEE.name(),
                        Arrays.asList(IngredientEnum.SUGAR.name(),
                                IngredientEnum.MILK.name(),
                                IngredientEnum.WATER.name()))));

        menuItemCache.put(MenuItemsEnums.Chai.name(), new MenuItem(MenuItemsEnums.Chai.name(), 4,
                getIngredientsList(IngredientEnum.TEA.name(),
                        Arrays.asList(IngredientEnum.SUGAR.name(),
                                IngredientEnum.MILK.name(),
                                IngredientEnum.WATER.name()))));

        menuItemCache.put(MenuItemsEnums.BananaSmoothie.name(), new MenuItem(MenuItemsEnums.BananaSmoothie.name(), 6,
                getIngredientsList(IngredientEnum.BANANA.name(),
                        Arrays.asList(IngredientEnum.SUGAR.name(),
                                IngredientEnum.MILK.name(),
                                IngredientEnum.WATER.name()))));

        menuItemCache.put(MenuItemsEnums.StrawberryShake.name(), new MenuItem(MenuItemsEnums.StrawberryShake.name(), 7,
                getIngredientsList(IngredientEnum.STRAWBERRIES.name(),
                        Arrays.asList(IngredientEnum.SUGAR.name(),
                                IngredientEnum.MILK.name(),
                                IngredientEnum.WATER.name()))));

        menuItemCache.put(MenuItemsEnums.Mojito.name(), new MenuItem(MenuItemsEnums.Mojito.name(), 7.5,
                getIngredientsList(IngredientEnum.LEMON.name(),
                        Arrays.asList(IngredientEnum.SUGAR.name(),
                                IngredientEnum.SODA.name(),
                                IngredientEnum.MINT.name(),
                                IngredientEnum.WATER.name()))));
    }

    private static List<Ingredient> getIngredientsList(String mandatory, List<String> optional) {
        List<Ingredient> ingredientsList = new ArrayList<>();
        IngredientEnum mandatoryIngredient = IngredientEnum.getIngredientByName(mandatory);
        ingredientsList.add(getIngredient(mandatoryIngredient, true));

        optional.stream().forEach(str -> {
            ingredientsList.add(getIngredient(IngredientEnum.getIngredientByName(str), false));
        });
        return ingredientsList;
    }

    private static Ingredient getIngredient(IngredientEnum ingredient, boolean isMandatory) {
        return new Ingredient(ingredient, isMandatory);
    }
}
