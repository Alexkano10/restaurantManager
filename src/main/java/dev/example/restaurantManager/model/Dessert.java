package dev.example.restaurantManager.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("DESSERT")

public class Dessert extends MenuItem {

    private boolean isGlutenFree; // indicates if the dessert is gluten-free
    private String flavor;  //Flavor of dessert
    private int sweetnessLevel; //Sweetness Level on a scale from 1 to 10;

    //Constructor that inherits from MenuItem and initializes dessert specific attributes.

    public Dessert (String id, String name, String description, double price, boolean isGlutenFree, String flavor, int sweetnessLevel){
        super(id, name, description, price); // Calls the constructor of the parent class (MenuItem)
        this.isGlutenFree = isGlutenFree;    // Initializes the gluten-free attribute
        this.flavor = flavor;                  // Initializes the flavor attribute
        this.sweetnessLevel = sweetnessLevel;  // Initializes the sweetness level attribute

    }

    //method to get a summary of dessert
    public String getDessertSummary() {
        return String.format("%s - %s (Price: %.2f, Gluten Free: %b, Flavor: %s, Sweetness Level: %d)",
                getName(), getDescription(), getPrice(), isGlutenFree, flavor, sweetnessLevel);
    }

    public boolean isSuitableForDiet(String dietaryNeed) {
        if(dietaryNeed.equalsIgnoreCase("gluten-free")){
            return isGlutenFree; //Checks if the dessert is gluten-free
        }
        return false; //Default case
    }
}
