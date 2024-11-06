package dev.example.restaurantManager.repository;

import dev.example.restaurantManager.model.Dessert;
import dev.example.restaurantManager.model.MainCourse;
import dev.example.restaurantManager.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, String> {

    // Búsqueda solo de main courses
    @Query("SELECT m FROM MainCourse m")
    List<MainCourse> findAllMainCourses();

    // Búsqueda solo de desserts
    @Query("SELECT d FROM Dessert d")
    List<Dessert> findAllDesserts();

}