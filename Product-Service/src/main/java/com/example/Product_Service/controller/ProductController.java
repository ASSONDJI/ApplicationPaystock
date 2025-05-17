package com.example.Product_Service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Product_Service.model.ProductModel;
import com.example.Product_Service.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/Poduct")


public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ProductModel> saveProduct(@org.springframework.web.bind.annotation.RequestBody ProductModel productModel){
        return ResponseEntity.ok(this.productService.saveProduct(productModel));
    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> getProduct(){
        return ResponseEntity.ok().body(this.productService.getProduct());
    }

    @PutMapping("/update{id}")

    public  ResponseEntity<ProductModel> updateProduct(@PathVariable("id") int id, @RequestBody ProductModel productModel) {
        ProductModel u = this.productService.updatedProduct(id, productModel);
        if (u != null) {
            return ResponseEntity.ok().body(u);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") int id){
            Boolean u = productService.deleteProduct(id);
            if (u){
                return ResponseEntity.status(HttpStatus.OK).body(u);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(u);
        }
    }
