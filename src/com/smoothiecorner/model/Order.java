package com.smoothiecorner.model;

import com.smoothiecorner.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class Order implements Validator {

    private List<CustomizedMenuItem> menuItemList = new ArrayList<>();

    public void addMenuItem(CustomizedMenuItem menuItem) {
        menuItemList.add(menuItem);
    }

    public List<CustomizedMenuItem> getMenuItemList() {
        return menuItemList;
    }

    @Override
    public boolean isValid() {
        if (getMenuItemList().size() == 0) {
            return false;
        }
        return getMenuItemList()
                .stream()
                .allMatch(CustomizedMenuItem::isValid);
    }
}
