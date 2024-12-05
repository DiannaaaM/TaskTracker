package com.TaskTracker.TaskTracker.service;

import com.TaskTracker.TaskTracker.model.Category;
import com.TaskTracker.TaskTracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }


    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        Optional<Category> existingCategory = Optional.ofNullable( categoryRepository.findByName( category.getName() ) );
        if (existingCategory.isPresent()) {
            categoryRepository.delete(existingCategory.get());
        } else {
            throw new RuntimeException("Категория не найдена: " + category.getName());
        }
    }

}
