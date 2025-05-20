package com.example.Product_Service.controller;

import com.example.Product_Service.dto.ProductRequestDto;
import com.example.Product_Service.dto.ProductResponseDto;
import com.example.Product_Service.exception.ProductNotFoundException;
import com.example.Product_Service.mapper.ProductMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Product_Service.model.ProductModel;
import com.example.Product_Service.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController {
    

    private final ProductService productService;

   public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;

    }

    @PostMapping("/save")
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto saveProduct = productService.saveProduct(productRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getProduct(){
        List<ProductResponseDto> product = this.productService.getProduct();
        return ResponseEntity.ok(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("id") int id,@RequestBody ProductRequestDto productRequestDto){
        try {
            ProductResponseDto updateProduct = productService.updateProduct(id, productRequestDto);
            return ResponseEntity.ok(updateProduct);
        }catch (ProductNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProduct(int id){
        boolean foundDelete = this.productService.deleteProduct(id);
        if (foundDelete){
            ResponseEntity.status(HttpStatus.OK).body(foundDelete);
            return true;
        }
        return false;
    }
    }
