package com.smoothiecorner.menu;

import com.smoothiecorner.MenuItemCache;
import com.smoothiecorner.common.MenuItemsEnums;
import com.smoothiecorner.exception.MenuItemNotFoundException;

public class MenuItemFactory {

    public static MenuItem getMenuItem(String name) throws MenuItemNotFoundException {
        MenuItemsEnums type = MenuItemsEnums.getMenuItemByName(name);
        if (type == null) {
            throw new MenuItemNotFoundException();
        }
        return MenuItemCache.getMenuItemByName(type.name());
    }
}
