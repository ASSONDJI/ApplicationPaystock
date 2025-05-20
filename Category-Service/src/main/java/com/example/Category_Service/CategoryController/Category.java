package com.example.Category_Service.CategoryController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/category")
public class Category {
    @GetMapping(path = "/get-all")
    public String category(){
        return  "is my category service";
    }
}
