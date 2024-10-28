package dev.example.restaurantManager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EatInOrderRestaurant extends OrderRestaurant {


    //Relation with RestaurantTable Many to One
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TABLE_EATIN_FK_ID")
    @JsonIgnore
    //private ArrayList<RestaurantTable> tableRestaurants = new ArrayList<>();
    private RestaurantTable orderedTableRestaurant;



    public EatInOrderRestaurant(String id, Date date, String waiter, int peopleQty,
                                double totalPayment, boolean paid, List<OrderMenuQty> menus,
                                RestaurantTable orderedTableRestaurant) {
        super(id, date, waiter, peopleQty, totalPayment, paid, menus);
        this.orderedTableRestaurant = orderedTableRestaurant;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Type: Eat In\n" +
                "Tables: " + (orderedTableRestaurant != null ? orderedTableRestaurant.getName() : "No table assigned");
    }
}
