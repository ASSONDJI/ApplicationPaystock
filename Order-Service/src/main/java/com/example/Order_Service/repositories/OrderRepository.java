package com.example.Order_Service.repositories;

import com.example.Order_Service.models.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {

    // Charger les items en même temps que la commande
    @EntityGraph(attributePaths = "items")
    Optional<Order> findById(Long id);
}
