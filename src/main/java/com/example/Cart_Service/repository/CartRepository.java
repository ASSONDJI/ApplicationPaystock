package com.example.Cart_Service.repository;

import com.example.Cart_Service.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Integer> {
}
