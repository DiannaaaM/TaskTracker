package com.TaskTracker.TaskTracker.service;

import com.TaskTracker.TaskTracker.model.TaskWithDDL;
import com.TaskTracker.TaskTracker.repository.TaskWithDDLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskWithDDLService {
    private final TaskWithDDLRepository taskWithDDLRepository;

    @Autowired
    public TaskWithDDLService(TaskWithDDLRepository taskWithDDLRepository) {
        this.taskWithDDLRepository = taskWithDDLRepository;
    }

    public TaskWithDDL createTaskWithDDL(TaskWithDDL taskWithDDL) {
        TaskWithDDL task = new TaskWithDDL();
        task.setName(taskWithDDL.getName());
        task.setDescription(taskWithDDL.getDescription());
        task.setCategory(taskWithDDL.getCategory());
        task.setStatus(taskWithDDL.getStatus());
        task.setStartDate(taskWithDDL.getStartDate());
        task.setEndDate(taskWithDDL.getEndDate());
        task.setStartTime(taskWithDDL.getStartTime());
        task.setEndTime(taskWithDDL.getEndTime());
        task.setCreatedDate(new Date());
        return taskWithDDLRepository.save(task);
    }
    public TaskWithDDL findByName(String name) {
        try {
            return taskWithDDLRepository.findByName(name);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error finding task by name", e);
        }
    }

    public List<TaskWithDDL> findAll() {
        try {
            return taskWithDDLRepository.findAll();
        } catch (DataAccessException e) {
            throw new RuntimeException("Error finding all tasks", e);
        }
    }

    public void deleteTaskByName(String name) {
        try {
            taskWithDDLRepository.deleteByName(name);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error deleting task by name", e);
        }
    }
}
