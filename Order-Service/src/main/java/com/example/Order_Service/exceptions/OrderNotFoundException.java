package com.example.Order_Service.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long id) {
        super("La commande avec l'ID " + id + " n'existe pas.");
    }
}
