package com.example.TaskManager.service.impltaskservice;

import com.example.TaskManager.dtos.TaskDto;
import com.example.TaskManager.dtos.createTask.CreateTaskDto;
import com.example.TaskManager.dtos.createTask.CreateTaskResponseDto;
import com.example.TaskManager.entities.Task;
import com.example.TaskManager.repository.TaskRepository;
import com.example.TaskManager.service.taskservice.TaskService;
import com.example.TaskManager.utility.UUIDConvertor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ITaskService implements TaskService{

    TaskRepository taskRepository;

    public ITaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    @Override
    public CreateTaskResponseDto createTask(CreateTaskDto task) {

        LocalDate dueDate = task.getDueDate()!=null?task.getDueDate(): LocalDate.now().plusDays(7);
        Task newTask = convertToEntity(task);
        newTask.setDueDate(dueDate);
        Task savedTask = taskRepository.save(newTask);
        return convertToTaskResponse(savedTask);
    }

    @Override
    public CreateTaskResponseDto getTaskById(String id) {
        UUID uuid = UUIDConvertor.StringToUUIDConvertor(id);
        Optional<Task> task = taskRepository.findById(uuid);
        CreateTaskResponseDto taskResponseDto=null;
        if(!task.isPresent()){
            throw new RuntimeException("No Task found with id :"+id);

        }
        return convertToTaskResponse(task.get());


    }

    @Override
    public CreateTaskResponseDto getTaskByStatus(String status){

        return null;
    }

    public Task convertToEntity(CreateTaskDto newTask){
        Task task = new Task();
        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());
        return task;
    }

    public CreateTaskResponseDto convertToTaskResponse(Task task){
        return new CreateTaskResponseDto(task.getId().toString(),task.getTitle().toString(),task.getDescription().toString(),
                task.getDueDate().toString(),task.getStatus().toString());
    }

    public TaskDto convertToDto(Task task){
        TaskDto taskDto = new TaskDto(task.getId().toString(),
                task.getTitle().toString(),
                task.getDescription().toString(),
                task.getStatus().toString(),
                task.getDueDate().toString(),
                task.getCreated_at(),
                task.getCreated_at());
        return taskDto;
    }


}
