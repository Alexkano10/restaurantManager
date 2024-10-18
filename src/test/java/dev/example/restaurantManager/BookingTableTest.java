package dev.example.restaurantManager;


import dev.example.restaurantManager.model.Booking;
import dev.example.restaurantManager.model.RestaurantTable;
import dev.example.restaurantManager.repository.BookingRepository;
import dev.example.restaurantManager.repository.TableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookingTableTest {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TableRepository tableRepository;

    @Test
    public void TestCreateBookingTable() {

        // Create booking object
        Booking booking1 = new Booking();
        booking1.setId("BO01");
        booking1.setConfirmed(false);
        booking1.setDate(new Date());
        booking1.setName("Emma and friends");
        booking1.setPeopleQty(4);
        booking1.setPhoneNumber("561-651-25-25");

        // Create tableRestaurant object
       /* RestaurantTable tableRestaurant1 = new RestaurantTable("TR01", "Table 01",
                "TABLE 01 for 4 people outdoors",  4, false, new ArrayList<>());

        // assign  booking to tableRestaurant
        tableRestaurant1.getBookings().add(booking1);

        // assign tableRestaurant to booking
        booking1.setTableRestaurantMapped(tableRestaurant1);
        tableRestaurant1.setBusy(true);

        // save booking and table
        tableRestaurantRepository.save(tableRestaurant1);
        bookingRepository.save(booking1);

        // FETCH DATA BO01
        Optional<Booking> found = bookingRepository.findById("BO01");
        // Print
        System.out.println("Booking1: " );
        System.out.println(found.get());
        System.out.println("--------------------");

        // then
        assertThat(found).isPresent();


        */
    }

}

