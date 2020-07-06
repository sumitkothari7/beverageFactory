package com.smoothiecorner.common;

import java.util.Arrays;

public enum MenuItemsEnums {
    Coffee,
    Chai,
    BananaSmoothie,
    StrawberryShake,
    Mojito;

    public static MenuItemsEnums getMenuItemByName(String name) {
        return Arrays.stream(values())
                .filter(i -> i.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
