package dev.example.restaurantManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MenuItem {
    @Id
    @GeneratedValue(generator = "UUID")

    private String id;

    private String name;
    private String description;
    private boolean isSpicy;
    private boolean hasGluten;
    private boolean isAvailable;
    @Enumerated(EnumType.STRING)
    private CourseType courseType;


    @ManyToMany(mappedBy = "menuItems")
    private Set<MenuRestaurant> menus = new HashSet<>();


    public boolean hasGluten() {
        return hasGluten;
    }
}





