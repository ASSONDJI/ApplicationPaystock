package com.example.Custumer_Service.exceptions;

public class CustumerNotFoundException extends RuntimeException {
    public CustumerNotFoundException(Long custumerId) {
        super("Custumer not found with ID: " + custumerId);
    }
}
