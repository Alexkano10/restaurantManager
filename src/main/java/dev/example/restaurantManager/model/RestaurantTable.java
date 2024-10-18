package dev.example.restaurantManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RestaurantTable {

    @Id
    private String id;
    private String name;
    private String description;
    private int qty;
    private boolean busy;

    // One table can have many bookings
    @OneToMany(mappedBy = "tableRestaurantMapped", cascade = CascadeType.ALL)
    private ArrayList<Booking> bookings ;

    // One table can have many eat-in orders
    @OneToMany(mappedBy = "orderedTableRestaurant", cascade = CascadeType.ALL)
    private ArrayList<EatInOrderRestaurant> eatInOrders;

    // we must create a VERY CONCRETE constructor to RUN the OLD tests
    public RestaurantTable(String name, String description , int qty, boolean busy) {
        this.name = name;
        this.description = description;
        this.qty = qty;
        this.busy = busy;
    }


    //method to add bookings
    public void addBooking(Booking booking) {
        this.getBookings().add(booking);
        if (booking.getTableRestaurantMapped() != null) booking.getTableRestaurantMapped().getBookings().remove(booking);
        booking.setTableRestaurantMapped(this);
    }

    @Override
    public String toString() {
        return "Table{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", busy=" + busy +
                '}';
    }


}