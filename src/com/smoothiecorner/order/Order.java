package com.smoothiecorner.order;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<CustomizedMenuItem> menuItemList = new ArrayList<>();

    public void addMenuItem(CustomizedMenuItem menuItem) {
        menuItemList.add(menuItem);
    }

    public List<CustomizedMenuItem> getMenuItemList() {
        return menuItemList;
    }
}
