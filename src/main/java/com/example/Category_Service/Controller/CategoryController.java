package com.example.Category_Service.Controller;

import com.example.Category_Service.Dto.CategoryRequestDto;
import com.example.Category_Service.Dto.CategoryResponseDto;
import com.example.Category_Service.Exception.CategoryNotFoundException;
import com.example.Category_Service.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryResponseDto> saveCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        CategoryResponseDto savedCategory = categoryService.saveCategory(categoryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getCategorys() {
        List<CategoryResponseDto> categories = categoryService.getCategorys();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable("id") int id,
                                                              @RequestBody CategoryRequestDto categoryRequestDto) {
        try {
            CategoryResponseDto updatedCategory = categoryService.updateCategory(id, categoryRequestDto);
            return ResponseEntity.ok(updatedCategory);
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable int id) {
        boolean foundDelete = this.categoryService.deleteCategory(id);
        if (foundDelete) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }
}
