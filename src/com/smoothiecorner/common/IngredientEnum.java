package com.smoothiecorner.common;

import java.util.Arrays;

public enum IngredientEnum {

    COFFEE(1),
    TEA(1),
    BANANA(1),
    STRAWBERRIES(1),
    MOJITO(1),
    LEMON(1),
    MILK(1 ),
    SUGAR(0.5),
    SODA(0.5),
    MINT(0.5),
    WATER(0.5);

    private double price;

    IngredientEnum( double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public static IngredientEnum getIngredientByName(String name) {
        return Arrays.stream(values())
                .filter(i -> i.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
