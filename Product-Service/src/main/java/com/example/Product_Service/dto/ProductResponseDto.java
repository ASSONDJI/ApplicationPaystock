package com.example.Product_Service.dto;

import com.example.Product_Service.model.ProductModel;

public record ProductResponseDto(
        int id,
        String name,
        String label,
        int purchasingPrice,
        int unitPrice,
        int sellingPrice,
        int quantity

)  {

}
