package com.example.Product_Service.dto;

public record ProductRequestDto(
        String name,
        String label,
        int purchasingPrice,
        int unitPrice,
        int sellingPrice,
        int quantity
) {
}
