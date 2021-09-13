package com.helmes.helmes.web.mvc.controller;

import com.helmes.helmes.dto.CategoryDto;
import com.helmes.helmes.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.helmes.helmes.web.mvc.controller.WebConstants.API_CATEGORY;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(API_CATEGORY)
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok().body(categoryService.getAll());
    }
}
