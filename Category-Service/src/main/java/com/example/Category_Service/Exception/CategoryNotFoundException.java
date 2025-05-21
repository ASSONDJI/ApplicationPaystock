package com.example.Category_Service.Exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Integer id_category) {
        super("category not found" + id_category);
    }
}
