package com.example.Category_Service.service;

import com.example.Category_Service.Dto.CategoryRequestDto;
import com.example.Category_Service.Dto.CategoryResponseDto;
import com.example.Category_Service.Model.CategoryModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

   public CategoryResponseDto saveCategory(CategoryRequestDto categoryRequestDto);

   public List<CategoryResponseDto> getCategorys();

   public CategoryResponseDto updateCategory(int id,CategoryRequestDto categoryRequestDto);

   public  boolean deleteCategory(int id);

}
