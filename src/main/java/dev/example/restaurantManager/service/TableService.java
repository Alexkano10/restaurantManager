package dev.example.restaurantManager.service;

import dev.example.restaurantManager.model.Table;

import java.util.List;

public interface TableService {
    List<Table> getAllTables();
    Table createTable(Table table);
    Table getTableByName (String name);
    Table updateTable (String name, Table tableDetails);
    boolean deleteTable(String name);

}
