package com.TaskTracker.TaskTracker.controller;

import com.TaskTracker.TaskTracker.model.TaskWithoutDDL;
import com.TaskTracker.TaskTracker.service.TaskWithoutDDLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskWithoutDDL")
public class TaskWithoutDDLController {

    @Autowired
    private TaskWithoutDDLService taskWithoutDDLService;

    @PostMapping("/createTaskWithDDL")
    public ResponseEntity<TaskWithoutDDL> createTaskWithDDL(@RequestBody TaskWithoutDDL newTask) {
        TaskWithoutDDL createdTask = taskWithoutDDLService.createTaskWithoutDDL(newTask);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<TaskWithoutDDL> findByName(@PathVariable String name) {
        TaskWithoutDDL task = taskWithoutDDLService.findByName(name);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/findTasks")
    public ResponseEntity<List<TaskWithoutDDL>> findTasks() {
        return ResponseEntity.ok(taskWithoutDDLService.findAll());
    }

    @DeleteMapping("/deleteTask/{name}")
    public ResponseEntity<Void> deleteTask(@PathVariable String name) {
        taskWithoutDDLService.deleteTaskByName(name);
        return ResponseEntity.noContent().build();
    }

}
