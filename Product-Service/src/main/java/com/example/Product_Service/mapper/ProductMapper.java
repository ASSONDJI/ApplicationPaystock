package com.example.Product_Service.mapper;

import com.example.Product_Service.dto.ProductRequestDto;
import com.example.Product_Service.dto.ProductResponseDto;
import com.example.Product_Service.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductModel toEntity(ProductRequestDto dto){
        ProductModel model = new ProductModel();
        model.setName(dto.name());
        model.setLabel(dto.label());
        model.setUnitPrice(dto.unitPrice());
        model.setPurchasingprice(dto.purchasingPrice());
        model.setSellingPrice(dto.sellingPrice());
        model.setQuantity(dto.quantity());
        return model;

    }
    public static ProductResponseDto toDto(ProductModel model){
        return new ProductResponseDto(
                model.getId(),
                model.getName(),
                model.getLabel(),
                model.getSellingPrice(),
                model.getPurchasingprice(),
                model.getQuantity(),
                model.getUnitPrice()

        );
    }

}
