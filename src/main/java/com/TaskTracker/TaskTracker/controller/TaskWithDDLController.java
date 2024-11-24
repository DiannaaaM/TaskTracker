package com.TaskTracker.TaskTracker.controller;

import com.TaskTracker.TaskTracker.model.TaskWithDDL;
import com.TaskTracker.TaskTracker.service.TaskWithDDLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskWithDDL")
public class TaskWithDDLController {

    @Autowired
    private TaskWithDDLService taskWithDDLService;

    @PostMapping("/createTaskWithDDL")
    public ResponseEntity<TaskWithDDL> createTaskWithDDL(@RequestBody TaskWithDDL newTask) {
        TaskWithDDL createdTask = taskWithDDLService.createTaskWithDDL(newTask);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<TaskWithDDL> findByName(@PathVariable String name) {
        TaskWithDDL task = taskWithDDLService.findByName(name);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/findTasks")
    public ResponseEntity<List<TaskWithDDL>> findTasks() {
        return ResponseEntity.ok(taskWithDDLService.findAll());
    }

    @DeleteMapping("/deleteTask/{name}")
    public ResponseEntity<Void> deleteTask(@PathVariable String name) {
        taskWithDDLService.deleteTaskByName(name);
        return ResponseEntity.noContent().build();
    }

}


