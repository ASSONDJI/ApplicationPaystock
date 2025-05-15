package com.example.Product_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Product_Service.model.ProductModel;

@Repository

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

}
