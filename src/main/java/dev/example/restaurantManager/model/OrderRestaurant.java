package dev.example.restaurantManager.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_RESTAURANT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class OrderRestaurant {

    @Id
    private String id;
    private Date date;
    private String waiter;
    private int peopleQty;
    private double totalPayment;
    private boolean paid;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ORDER_MENU",
            joinColumns = @JoinColumn(name = "ORDER_ID_FK"),
            inverseJoinColumns = @JoinColumn(name = "MENU_ID_FK")
    )
    private List<MenuRestaurant> menus = new ArrayList<>();

    public void addMenu(MenuRestaurant menu) {
        this.menus.add(menu);
        menu.getOrders().add(this);
    }

    public void removeMenu(MenuRestaurant menu) {
        this.menus.remove(menu);
        menu.getOrders().remove(this);
    }

    public List<MenuRestaurant> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuRestaurant> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "OrderRestaurant{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", waiter='" + waiter + '\'' +
                ", peopleQty=" + peopleQty +
                ", totalPayment=" + totalPayment +
                ", paid=" + paid +
                ", menusCount=" + (menus != null ? menus.size() : 0) +
                ", menus=" +  (menus != null ? menus : "no menus")  +
                '}';
    }

}