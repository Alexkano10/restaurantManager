package dev.example.restaurantManager.service;

import dev.example.restaurantManager.model.OrderMenuQty;

import java.util.List;

public interface OrderMenuQtyService {

        // Retrieves all OrderMenuQty records
        List<OrderMenuQty> getAllOrderMenuQty();

        // Creates a new OrderMenuQty entry
        OrderMenuQty createOrderMenuQty(OrderMenuQty orderMenuQty);

        // Retrieves an OrderMenuQty entry by ID
        OrderMenuQty getOrderMenuQtyById(String id);

        // Updates an existing OrderMenuQty entry
        OrderMenuQty updateOrderMenuQty(String id, OrderMenuQty orderMenuQtyDetails);

        // Deletes an OrderMenuQty entry by ID
        boolean deleteOrderMenuQty(String id);

        // Counts all OrderMenuQty entries
        long countOrderMenuQty();
    }

