package com.TaskTracker.TaskTracker.controller;

import com.TaskTracker.TaskTracker.model.Category;
import com.TaskTracker.TaskTracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/categories")
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
    public void createCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
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
