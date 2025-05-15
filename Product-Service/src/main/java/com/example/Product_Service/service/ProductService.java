package com.example.Product_Service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Product_Service.model.ProductModel;

@Service

public interface ProductService {

    public ProductModel saveProduct(ProductModel productModel);

    public  List<ProductModel> getProduct();

    public ProductModel updatedProduct(int id, ProductModel productModel);

    public boolean deleteProduct(int id);

}
