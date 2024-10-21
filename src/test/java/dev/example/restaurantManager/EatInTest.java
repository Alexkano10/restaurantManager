package dev.example.restaurantManager;


import dev.example.restaurantManager.model.EatInOrderRestaurant;
import dev.example.restaurantManager.model.RestaurantTable;
import dev.example.restaurantManager.repository.EatInRepository;
import dev.example.restaurantManager.repository.TableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@DataJpaTest
public class EatInTest {

    @Autowired
    private EatInRepository eatInRepository;
    @Autowired
    private TableRepository tableRepository;

    @Test
    public void TestCreateEatIn(){

        //Create Table

        RestaurantTable table1 = new RestaurantTable("T01", "Redonda","Mesa pequeña y redonda" , 4,false, new ArrayList<>());
        RestaurantTable table2 = new RestaurantTable("T02", "Cuadrada","Mesa pequeña y cuadrada" ,6,false, new ArrayList<>());
        RestaurantTable table3 = new RestaurantTable("T03", "Rectangular","Mesa grande y rectangular" ,10,false, new ArrayList<>());

        tableRepository.save(table1);
        tableRepository.save(table2);
        tableRepository.save(table3);
        //create EainOrder

        EatInOrderRestaurant order1 = new EatInOrderRestaurant();
        order1.setId("O001");
        order1.setDate(new Date());
        order1.setWaiter("John Doe");
        order1.setPeopleQty(4);
        order1.setTotalPayment(100.50);
        order1.setPaid(true);
        order1.setOrderedTableRestaurant(table1);

        // Asignar la orden a la mesa
        table1.getEatInOrders().add(order1);

        // Guardar mesa y orden
        eatInRepository.save(order1);

        // Verificar que la orden ha sido guardada
        Optional<EatInOrderRestaurant> foundOrder = eatInRepository.findById("O001");
        System.out.println("Order1: ");
        System.out.println(foundOrder.get());
        System.out.println("--------------------");

        // Comprobar que la orden se encuentra presente
        assertThat(foundOrder).isPresent();

    }

    }



