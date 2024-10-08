package dev.example.restaurantManager.controller;


import dev.example.restaurantManager.model.Table;
import dev.example.restaurantManager.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/table")
@RestController
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/allTables")
    public ResponseEntity<List<Table>>getAllTables(){
        List<Table> tables = tableService.getAllTables();
        return ResponseEntity.ok(tables);
    }

    @PostMapping
    public ResponseEntity<Table> createTable(@RequestBody Table table){
        Table createdTable = tableService.createTable(table);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTable);

    }

    @PutMapping("/{name}")
    public ResponseEntity<Table> updateTable(@PathVariable String name, @RequestBody Table tableDetails) {
        Table updatedTable = tableService.updateTable(name, tableDetails);
        return updatedTable != null ? ResponseEntity.ok(updatedTable) : ResponseEntity.notFound().build();
    }

    // Eliminar una mesa
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteTable(@PathVariable String name) {
        boolean isDeleted = tableService.deleteTable(name);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

