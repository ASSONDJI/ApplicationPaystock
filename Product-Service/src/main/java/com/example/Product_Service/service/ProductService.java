package com.example.Product_Service.service;

import java.util.List;

import com.example.Product_Service.dto.ProductRequestDto;
import com.example.Product_Service.dto.ProductResponseDto;


public interface ProductService {

    public ProductResponseDto saveProduct(ProductRequestDto productRequestDto);

    public List<ProductResponseDto> getProduct();

    public ProductResponseDto updateProduct(int id, ProductRequestDto productDto);

    public boolean deleteProduct(int id);

}
