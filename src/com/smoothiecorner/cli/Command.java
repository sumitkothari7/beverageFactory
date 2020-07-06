package com.smoothiecorner.cli;

import com.smoothiecorner.exception.IngredientNotFoundException;
import com.smoothiecorner.exception.InvalidOrderException;
import com.smoothiecorner.exception.MenuItemNotFoundException;

@FunctionalInterface
public interface Command {

    void execute(String command) throws MenuItemNotFoundException, InvalidOrderException, IngredientNotFoundException;
}
