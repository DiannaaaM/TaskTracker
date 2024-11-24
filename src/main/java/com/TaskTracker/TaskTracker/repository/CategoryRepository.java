package com.TaskTracker.TaskTracker.repository;

import com.TaskTracker.TaskTracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
    void deleteCategoryByName(String name);
    List<Category> findAll();
}
