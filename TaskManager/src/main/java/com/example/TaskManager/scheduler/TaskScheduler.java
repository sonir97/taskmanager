package com.example.TaskManager.scheduler;

import com.example.TaskManager.repository.TaskRepository;
import com.example.TaskManager.service.taskservice.TaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskScheduler {

    TaskService taskService;
    TaskRepository taskRepository;

    public TaskScheduler(TaskService taskService, TaskRepository taskRepository){
        this.taskRepository = taskRepository;
        this.taskService = taskService;
    }

    @Scheduled(fixedRate = 60000)
    public void updateTaskStatus(){

    }

}
