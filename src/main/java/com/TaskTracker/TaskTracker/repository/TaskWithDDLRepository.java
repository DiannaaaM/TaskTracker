package com.TaskTracker.TaskTracker.repository;

import com.TaskTracker.TaskTracker.model.TaskWithDDL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskWithDDLRepository extends JpaRepository<TaskWithDDL, Integer> {
    TaskWithDDL save(TaskWithDDL taskWithDDL);
    TaskWithDDL findByName(String name);
    TaskWithDDL deleteByName(String name);
    List<TaskWithDDL> findAll();

}
