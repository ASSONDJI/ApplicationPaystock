package com.example.Cart_Service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "Cart")
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Cart;

    @Column(name = "CUSTOMER")
    private int id_Customer;


    @Column(name = "DATE_CREATION")
    private Date dateCreation;


}
