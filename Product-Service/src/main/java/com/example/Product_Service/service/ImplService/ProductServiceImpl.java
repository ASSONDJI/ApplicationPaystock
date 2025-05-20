package com.example.Product_Service.service.ImplService;

import com.example.Product_Service.dto.ProductRequestDto;
import com.example.Product_Service.dto.ProductResponseDto;
import com.example.Product_Service.exception.ProductNotFoundException;
import com.example.Product_Service.mapper.ProductMapper;
import com.example.Product_Service.model.ProductModel;
import com.example.Product_Service.repository.ProductRepository;
import com.example.Product_Service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public ProductResponseDto saveProduct(ProductRequestDto productRequestDto) {
        try {
            ProductModel entity = productMapper.toEntity(productRequestDto);
            ProductModel saved = productRepository.save(entity);
            return ProductMapper.toDto(saved);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ProductResponseDto> getProduct() {
        try {
            List<ProductModel> product = this.productRepository.findAll();
            return (List<ProductResponseDto>) product.stream()
                    .map(ProductMapper::toDto)
                    .toList();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ProductResponseDto updateProduct(int id, ProductRequestDto productDto) {
        Optional<ProductModel> foundProduct = this.productRepository.findById(id);
        if (foundProduct.isPresent()){
            ProductModel updateProduct = productMapper.toEntity(productDto);
            updateProduct.setId(id);
            ProductModel saveProduct = productRepository.save(updateProduct);
            return ProductMapper.toDto(saveProduct);
        }
        throw new ProductNotFoundException(id);
    }

    @Override
    public boolean deleteProduct(int id) {
        Optional<ProductModel> foundProduct = this.productRepository.findById(id);
        if (foundProduct.isPresent()){
            ProductModel u = foundProduct.get();
            this.productRepository.delete(u);
            return true;
        }
        throw new ProductNotFoundException(id);
    }
}
