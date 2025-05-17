package com.example.Product_Service.exception;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(Integer ProductId) {
    super("Product not found exception" + ProductId);
  }
}
