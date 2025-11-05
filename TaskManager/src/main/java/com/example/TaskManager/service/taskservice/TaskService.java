package com.example.TaskManager.service.taskservice;

import com.example.TaskManager.dtos.TaskDto;
import com.example.TaskManager.dtos.createTask.CreateTaskDto;
import com.example.TaskManager.dtos.createTask.CreateTaskResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    List<TaskDto> getAllTasks();
    CreateTaskResponseDto createTask(CreateTaskDto task);
    CreateTaskResponseDto getTaskById(String id);
    CreateTaskResponseDto getTaskByStatus(String status);
}
