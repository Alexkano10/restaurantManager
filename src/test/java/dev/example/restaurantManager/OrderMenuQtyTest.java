package dev.example.restaurantManager;

import dev.example.restaurantManager.model.MenuRestaurant;
import dev.example.restaurantManager.model.OrderMenuQty;
import dev.example.restaurantManager.model.OrderRestaurant;
import dev.example.restaurantManager.repository.MenuRepository;
import dev.example.restaurantManager.repository.OrderMenuQtyRepository;
import dev.example.restaurantManager.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class OrderMenuQtyTest {

    @Autowired
    private OrderRepository orderRestaurantRepository;

    @Autowired
    private MenuRepository menuRestaurantRepository;

    @Autowired
    private OrderMenuQtyRepository orderMenuQtyRepository;

    @Test
    public void TestCreateOrderWithMenus() {
        // Create Menus
        MenuRestaurant menu1 = new MenuRestaurant("M10", "Menu 10", 20.0, "Dos platos y bebida", true, true, new ArrayList<>());
        MenuRestaurant menu2 = new MenuRestaurant("M20", "Menu 20", 25.0, "Tres platos y bebida", true, true, new ArrayList<>());
        MenuRestaurant menu3 = new MenuRestaurant("M30", "Menu 30", 30.0, "Cuatro platos y bebida", true, true, new ArrayList<>());

        // Save Menus
        menuRestaurantRepository.save(menu1);
        menuRestaurantRepository.save(menu2);
        menuRestaurantRepository.save(menu3);

        // Create an Order
        OrderRestaurant order = new OrderRestaurant("01", new Date(), "Juan", 4, 100.0, false, new ArrayList<>());

        // Add Menus to Order
        order.addMenu(menu1, 2); // 2 de Menu 10
        order.addMenu(menu2, 2); // 2 de Menu 20
        order.addMenu(menu3, 1); // 1 de Menu 30

        // Save Order
        orderRestaurantRepository.save(order);

        // Verify the relationship using OrderMenuQty
        List<OrderMenuQty> orderMenuQtyList = orderMenuQtyRepository.findAll();

        // Print OrderMenuQty details to console
        System.out.println("Order Menu Quantities:");
        for (OrderMenuQty omq : orderMenuQtyList) {
            System.out.println("Menu: " + omq.getMenuMapped().getName() +
                    ", Quantity: " + omq.getQuantity());
        }

        // Verify the size of OrderMenuQty
        assertThat(orderMenuQtyList).hasSize(3); // Debe haber 3 menús

        // Verify the order contains the correct menus
        Optional<OrderRestaurant> foundOrder = orderRestaurantRepository.findById("01");
        assertThat(foundOrder).isPresent();

        System.out.println("Found Order: " + foundOrder.get());

        // Check that the found order has the expected OrderMenuQty entries
        for (OrderMenuQty omq : foundOrder.get().getOrderMenuQtyList()) {
            System.out.println("Menu: " + omq.getMenuMapped().getName() +
                    ", Quantity: " + omq.getQuantity());

        }
    }
}