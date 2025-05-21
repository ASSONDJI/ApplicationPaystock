package com.example.Custumer_Service.exceptions;

public class CustumerNotFoundException extends RuntimeException {
    public CustumerNotFoundException(Long id_client) {
        super("Custumer not found with ID: " + id_client);
    }
}
