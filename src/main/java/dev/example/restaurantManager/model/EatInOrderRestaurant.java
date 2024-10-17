package dev.example.restaurantManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EatInOrderRestaurant extends OrderRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Generate ID automatically
    private String id;

    private ArrayList<RestaurantTable> tableRestaurants = new ArrayList<>();
    //private TableRestaurant orderedTableRestaurant;


    public EatInOrderRestaurant(String id, Date date, String waiter, int peopleQty,
                                double totalPayment, boolean paid, ArrayList<MenuRestaurant> menus,
                                ArrayList<RestaurantTable> tableRestaurants) {
        super(id, date, waiter, peopleQty, totalPayment, paid, menus);
        this.tableRestaurants = tableRestaurants;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Type: Eat In\n" +
                "Tables: " + tableRestaurants.stream().map(RestaurantTable::getName).collect(Collectors.joining(", "));
    }
}
