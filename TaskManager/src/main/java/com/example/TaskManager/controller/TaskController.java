package com.example.TaskManager.controller;

import com.example.TaskManager.dtos.TaskDto;
import com.example.TaskManager.dtos.createTask.CreateTaskDto;
import com.example.TaskManager.dtos.createTask.CreateTaskResponseDto;
import com.example.TaskManager.service.taskservice.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllTasks(){
        List<TaskDto> tasks = taskService.getAllTasks();
        if(tasks.isEmpty()){
            Map<String,String> response = Map.of("message", "No tasks found, please create few tasks");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable String id){
        CreateTaskResponseDto task = taskService.getTaskById(id);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }


    @PostMapping
    public ResponseEntity<Object> createTask(@RequestBody CreateTaskDto createTaskDto){
        CreateTaskResponseDto createdTask = taskService.createTask(createTaskDto);

        return ResponseEntity.status(HttpStatus.OK).body(createdTask);
    }



}
