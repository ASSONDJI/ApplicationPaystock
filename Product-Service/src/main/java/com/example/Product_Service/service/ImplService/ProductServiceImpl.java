package com.example.Product_Service.service.ImplService;

import com.example.Product_Service.model.ProductModel;
import com.example.Product_Service.repository.ProductRepository;
import com.example.Product_Service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private  final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductRepository productRepository1) {

        this.productRepository = productRepository1;
    }

    @Override
    public ProductModel saveProduct(ProductModel productModel) {
        return this.productRepository.save(productModel);
    }

    @Override
    public List<ProductModel> getProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductModel updatedProduct(int id, ProductModel productModel) {
        Optional<ProductModel> foundProduct = this.productRepository.findById(id);
        if(id == productModel.getId_Product() && foundProduct.isPresent()){
            return this.productRepository.save(productModel);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {

        Optional<ProductModel> foundProduct=this.productRepository.findById(id);
        if(foundProduct.isPresent()){
            ProductModel u = foundProduct.get();
             this.productRepository.delete(u);
             return true;
        }
        return false;
    }
}
