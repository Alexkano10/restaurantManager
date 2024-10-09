package dev.example.restaurantManager.repository;

import dev.example.restaurantManager.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableRepository extends JpaRepository<Table, String> {

    Optional<Table> findByName(String name);

}
