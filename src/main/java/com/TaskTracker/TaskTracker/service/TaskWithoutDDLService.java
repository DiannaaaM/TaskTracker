package com.TaskTracker.TaskTracker.service;

import com.TaskTracker.TaskTracker.model.Category;
import com.TaskTracker.TaskTracker.model.Status;
import com.TaskTracker.TaskTracker.model.TaskWithDDL;
import com.TaskTracker.TaskTracker.model.TaskWithoutDDL;
import com.TaskTracker.TaskTracker.repository.TaskWithoutDDLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskWithoutDDLService {
    private final TaskWithoutDDLRepository taskWithoutDDLRepository;

    @Autowired
    public TaskWithoutDDLService(TaskWithoutDDLRepository taskWithoutDDLRepository) {
        this.taskWithoutDDLRepository = taskWithoutDDLRepository;
    }

    public TaskWithoutDDL createTaskWithoutDDL(TaskWithoutDDL taskWithoutDDL) {
        TaskWithoutDDL task = new TaskWithoutDDL();
        task.setName(taskWithoutDDL.getName());
        task.setDescription(taskWithoutDDL.getDescription());
        task.setCategory(taskWithoutDDL.getCategory());
        task.setStatus(taskWithoutDDL.getStatus());
        task.setDateToDo(new Date());
        return taskWithoutDDLRepository.save(task);
    }

    public TaskWithoutDDL findByName(String name) {
        try {
            return (TaskWithoutDDL) taskWithoutDDLRepository.findByName(name);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error finding task by name", e);
        }
    }

//    public List<TaskWithoutDDL> findAll() {
//        try {
//            return taskWithoutDDLRepository.findAll();
//        } catch (DataAccessException e) {
//            throw new RuntimeException("Error finding all tasks", e);
//        }
//    }

    public void deleteTaskByName(String name) {
        try {
            taskWithoutDDLRepository.deleteByName(name);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error deleting task by name", e);
        }
    }
}
