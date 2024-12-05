package com.TaskTracker.TaskTracker.controller;

import com.TaskTracker.TaskTracker.model.Category;
import com.TaskTracker.TaskTracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")  // Префикс для API маршрутов
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/new_category")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        try {
            categoryService.addCategory(category);
            return ResponseEntity.ok("Категория успешно добавлена");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при добавлении категории: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public void deleteCategory(@RequestBody Category category) {
        categoryService.deleteCategory(category);
    }

    @PutMapping("/update_category")
    public void updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @GetMapping("/find_category")
    public Category findCategory(@RequestBody String name) {
        return categoryService.getCategoryByName(name);
    }
}
