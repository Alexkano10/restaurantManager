package dev.example.restaurantManager.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantTable {

    private String name;
    private String description;
    private int qty;
    private boolean busy;


}