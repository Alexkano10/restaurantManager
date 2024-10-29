package dev.example.restaurantManager.service;

import dev.example.restaurantManager.model.OrderRestaurant;
import dev.example.restaurantManager.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderRestaurantServiceImpl implements OrderRestaurantService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderRestaurant> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderRestaurant createOrder(OrderRestaurant order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderRestaurant getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public OrderRestaurant updateOrder(String id, OrderRestaurant orderDetails) {
        OrderRestaurant existingOrder = getOrderById(id);
        if (existingOrder != null) {
            existingOrder.setDate(orderDetails.getDate());
            existingOrder.setWaiter(orderDetails.getWaiter());
            existingOrder.setPeopleQty(orderDetails.getPeopleQty());
            existingOrder.setTotalPayment(orderDetails.getTotalPayment());
            existingOrder.setPaid(orderDetails.isPaid());
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    @Override
    public boolean deleteOrder(String id) {
        OrderRestaurant existingOrder = getOrderById(id);
        if (existingOrder != null) {
            orderRepository.delete(existingOrder);
            return true;
        }
        return false;
    }
    @Override
    public long countOrders() {
        return orderRepository.count(); //
    }

}



