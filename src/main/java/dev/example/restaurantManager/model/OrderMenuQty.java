package dev.example.restaurantManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.awt.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class OrderMenuQty {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderRestaurant orderMapped;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuRestaurant menuMapped;

    private int quantity;


    // Constructor con parámetros para inicializar los atributos
    public OrderMenuQty(OrderRestaurant orderRestaurant, MenuRestaurant menuRestaurant, int quantity) {
        this.orderMapped = orderRestaurant;  // Inicializa el campo orderMapped
        this.menuMapped = menuRestaurant;    // Inicializa el campo menuMapped
        this.quantity = quantity;             // Inicializa el campo quantity
    }
    @Override
    public String toString() {
        return "OrderMenuQty{" +
                "id='" + id + '\'' +
                ", orderMapped=" + orderMapped.getId() +  // Solo el ID para evitar un bucle
                ", menuMapped=" + menuMapped.getName() +  // Solo el nombre del menú
                ", quantity=" + quantity +
                '}';
    }

    }


