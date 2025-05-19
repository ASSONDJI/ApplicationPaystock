package com.example.Cart_Service.exception;

public class CartNotFoundException extends RuntimeException {

    public CartNotFoundException(Integer id_Cart){
        super("Cart not found exception" + id_Cart);
    }
}
