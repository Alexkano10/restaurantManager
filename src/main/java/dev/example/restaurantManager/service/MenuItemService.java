package dev.example.restaurantManager.service;

import dev.example.restaurantManager.model.Dessert;
import dev.example.restaurantManager.model.MainCourse;
import dev.example.restaurantManager.model.MenuItem;
import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAllMenuItems();
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem getMenuItemById(String id);
    MenuItem updateMenuItem(String id, MenuItem menuItemDetails);
    boolean deleteMenuItem(String id);
    long countMenuItems();

    // New methods for MainCourse and Dessert
    MainCourse createMainCourse(MainCourse mainCourse);
    Dessert createDessert(Dessert dessert);
}