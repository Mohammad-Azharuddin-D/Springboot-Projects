package com.app.todoapp.services;

import com.app.todoapp.model.Task;
import com.app.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {

        List<Task> tasks = taskRepository.findAll();
        System.out.println(tasks);
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);

    }

        public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }


    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Task"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);



    }
}

