package dev.example.restaurantManager.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data

@NoArgsConstructor
@Entity
public class TableRestaurant {

    @Id
    private String id;
    private String name;
    private String description;
    private int qty;
    private boolean busy;

    @OneToMany(mappedBy = "tableRestaurantMapped", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    //inicializar bookings en el constructor.
    public TableRestaurant(String id, String name, String description, int qty, boolean busy, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.qty = qty;
        this.busy = busy;
        this.bookings = bookings != null ? bookings : new ArrayList<>();  // Inicializamos la lista con los valores pasados, si no son nulos
    }


    //method to add
//    public void addBooking(Booking booking) {
//        this.getBookings().add(booking);
//        if (booking.getTableRestaurantMapped() != null)
//            booking.getTableRestaurantMapped().getBookings().remove(booking);
//        booking.setTableRestaurantMapped(this);
//    }


    public void addBooking(Booking booking) {
        if (booking.getTableRestaurantMapped() != null) {
            List<Booking> bookings = booking.getTableRestaurantMapped().getBookings();
            if(bookings!=null){
                bookings.remove(booking);
            }
        }

        if (this.getBookings() == null){
            this.setBookings(new ArrayList<>());
        }
        this.getBookings().add(booking);


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
                ", bookings=" + bookings +
                '}';
    }


}