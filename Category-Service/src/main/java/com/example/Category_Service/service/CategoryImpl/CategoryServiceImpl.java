package com.example.Category_Service.service.CategoryImpl;

import com.example.Category_Service.Dto.CategoryRequestDto;
import com.example.Category_Service.Dto.CategoryResponseDto;
import com.example.Category_Service.Exception.CategoryNotFoundException;
import com.example.Category_Service.Mapper.CategoryMapper;
import com.example.Category_Service.Model.CategoryModel;
import com.example.Category_Service.Repository.CategoryRepository;
import com.example.Category_Service.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
private final CategoryRepository categoryRepository;
private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }
    @Override
    public CategoryResponseDto saveCategory(CategoryRequestDto categoryRequestDto) {
        try {
            CategoryModel entity = categoryMapper.toEntity(categoryRequestDto);
            CategoryModel saved = categoryRepository.save(entity);
            return categoryMapper.toDto(saved);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public List<CategoryResponseDto> getCategorys() {
        try {
            List<CategoryModel> categories = this.categoryRepository.findAll();
            return categories.stream()
                    .map(categoryMapper::toDto)
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public CategoryResponseDto updateCategory(int id, CategoryRequestDto categoryRequestDto) {
        Optional<CategoryModel> foundCategory = this.categoryRepository.findById(id);
        if (foundCategory.isPresent()) {
            CategoryModel updatedCategory = categoryMapper.toEntity(categoryRequestDto);
            updatedCategory.setId_category(id);
            CategoryModel savedCategory = categoryRepository.save(updatedCategory);
            return categoryMapper.toDto(savedCategory);
        }
        throw new CategoryNotFoundException(id);
    }

    @Override
    public boolean deleteCategory(int id) {
        Optional<CategoryModel> foundCategory = this.categoryRepository.findById(id);
        if (foundCategory.isPresent()) {
            categoryRepository.delete(foundCategory.get());
            return true;
        }
        throw new CategoryNotFoundException(id);
    }





}
