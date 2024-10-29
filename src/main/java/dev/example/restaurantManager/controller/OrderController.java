package dev.example.restaurantManager.controller;

import dev.example.restaurantManager.model.OrderRestaurant;
import dev.example.restaurantManager.repository.OrderMenuQtyRepository;
import dev.example.restaurantManager.repository.OrderRepository;
import dev.example.restaurantManager.service.OrderRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderRestaurantService orderService;

    private HttpHeaders getCommonHeaders(String description) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", description);
        headers.add("content-type", "application/json");
        headers.add("date", new Date().toString());
        headers.add("server", "H2 Database");
        headers.add("version", "1.0.0");
        headers.add("order-count", String.valueOf(orderService.countOrders())); // Agregando el conteo de órdenes
        headers.add("object", "orders");
        return headers;
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<List<OrderRestaurant>> getAllOrders() {
        List<OrderRestaurant> orders = orderService.getAllOrders();
        HttpHeaders headers = getCommonHeaders("List of all orders");
        return orders != null && !orders.isEmpty()
                ? new ResponseEntity<>(orders, headers, HttpStatus.OK)
                : new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
    }

    // Create a new order
    @PostMapping
    public ResponseEntity<OrderRestaurant> createOrder(@RequestBody OrderRestaurant order) {
        OrderRestaurant savedOrder = orderService.createOrder(order);
        HttpHeaders headers = getCommonHeaders("Order created successfully");
        return new ResponseEntity<>(savedOrder, headers, HttpStatus.CREATED);
    }

    // Update an existing order
    @PutMapping("/{id}")
    public ResponseEntity<OrderRestaurant> updateOrder(@PathVariable String id, @RequestBody OrderRestaurant orderDetails) {
        OrderRestaurant updatedOrder = orderService.updateOrder(id, orderDetails);
        HttpHeaders headers = getCommonHeaders(updatedOrder != null ? "Order updated successfully" : "Order not found");
        return updatedOrder != null
                ? new ResponseEntity<>(updatedOrder, headers, HttpStatus.OK)
                : new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        boolean isDeleted = orderService.deleteOrder(id);
        HttpHeaders headers = getCommonHeaders(isDeleted ? "Order deleted successfully" : "Order not found");
        return isDeleted
                ? new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
    }
}