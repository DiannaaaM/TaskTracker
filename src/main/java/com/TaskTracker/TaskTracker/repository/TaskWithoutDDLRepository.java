package com.TaskTracker.TaskTracker.repository;

import com.TaskTracker.TaskTracker.model.TaskWithoutDDL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskWithoutDDLRepository extends JpaRepository<TaskWithoutDDL, Integer> {
    TaskWithoutDDL save(TaskWithoutDDL task);
    TaskWithoutDDL findByName(String name);
    TaskWithoutDDL deleteByName(String name);
    List<TaskWithoutDDL> findAll();
}
