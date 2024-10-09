package dev.example.restaurantManager.service;

import dev.example.restaurantManager.model.Table;
import dev.example.restaurantManager.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import java.util.List;

public class TableServiceImpl implements TableService {

    @Autowired
    private TableRepository tableRepository;
    @Override
    public List<Table> getAllTables(){return tableRepository.findAll();}
    @Override
    public Table createTable(Table table){
        if(table.getName() == null || table.getName().isEmpty()){
            table.setName("Default Table name");
        }
        return tableRepository.save(table);
    }
    @Override
    public Table getTableByName(String name) {
        return tableRepository.findByName(name).orElse(null);

    }
    @Override
    public Table updateTable(String name, Table tableDetails){
        Table table = tableRepository.findByName(name).orElse(null);
        if (table == null){
            return null;
        }
        if(tableDetails.getName()!=null) {
            table.setName(tableDetails.getName());
        }

        if(tableDetails.getDescription()!=null) {
            table.setDescription(tableDetails.getDescription());
        }
        if(tableDetails.getQty()>0) {
                table.setQty(tableDetails.getQty());
        }

        table.setBusy(tableDetails.isBusy());

        return tableRepository.save(table);

    }

    @Override
    public boolean deleteTable (String name){

        Table table = tableRepository.findByName(name).orElse(null);
        if(table == null){
            return false;
        }
        tableRepository.delete(table);
        return true;
    }


}

