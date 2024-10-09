package dev.example.restaurantManager.utilities;

import com.github.javafaker.Faker;
import dev.example.restaurantManager.model.Customer;
import dev.example.restaurantManager.model.RestaurantTable;
import dev.example.restaurantManager.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.UUID;

@Component
public class TableDataLoader {

    @Autowired
    private TableRepository tableRepository;

    public void createFakeTables(){

        // Check if the database is empty
        if (tableRepository.count() == 0) {
            System.out.println(" 0 records at the database found");
            Faker faker = new Faker(new Locale("en-US"));

            int qty = 50;
            // Create and save 100 fake customers
            for (int i = 0; i < qty; i++) {
                RestaurantTable table = new RestaurantTable();

                // Using Faker to generate fake data
                table.setName(faker.company().name());  // Fake name of the restaurant table
                table.setDescription(faker.lorem().sentence());  // Fake description
                table.setQty(faker.number().numberBetween(1, 10));  // Random seat count between 1 and 10
                table.setBusy(faker.bool().bool());  // Random busy status (true/false)



                tableRepository.save(table);
            }

            System.out.println(qty + " fake tables have been created and saved to the database.");
        }
    }


}
