package com.TaskTracker.TaskTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.TaskTracker.TaskTracker.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")  // Уникальный префикс для всех маршрутов
public class ViewController {

    private final CategoryService categoryService;

    public ViewController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String viewAllCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "viewAllCategories";
    }

    @GetMapping("/categories/new_category")
    public String addCategory(Model model) {
        return "addCategory";
    }

    @GetMapping("/categories/delete")
    public String deleteCategory(Model model) {
        return "deleteCategory";
    }
}