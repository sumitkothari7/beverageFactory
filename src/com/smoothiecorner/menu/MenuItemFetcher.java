package com.smoothiecorner.menu;

import com.smoothiecorner.MenuCard;
import com.smoothiecorner.exception.MenuItemNotFoundException;
import com.smoothiecorner.model.MenuItem;

public class MenuItemFetcher {

    public static MenuItem getMenuItem(String name) throws MenuItemNotFoundException {
        MenuItem menuItem = MenuCard.getMenuItemByName(name.trim().toLowerCase());
        if (menuItem == null) {
            throw new MenuItemNotFoundException();
        }
        return menuItem;
    }
}
