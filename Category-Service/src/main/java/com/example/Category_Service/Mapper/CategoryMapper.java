package com.example.Category_Service.Mapper;

import com.example.Category_Service.Dto.CategoryRequestDto;
import com.example.Category_Service.Dto.CategoryResponseDto;
import com.example.Category_Service.Model.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryModel toEntity(CategoryRequestDto dto){
        if (dto == null) return null;
        CategoryModel entity = new CategoryModel();
        entity.setNom_cat(dto.nom_cat());
        return entity;
    }
    public CategoryResponseDto toDto(CategoryModel entity){
        if (entity == null) return null;

        return new CategoryResponseDto(
                entity.getNom_cat(),
                entity.getId_category()
        );
    }
}
