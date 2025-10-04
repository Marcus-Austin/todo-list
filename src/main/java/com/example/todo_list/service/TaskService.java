package com.example.todo_list.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo_list.models.Task;
import com.example.todo_list.repository.TaskRepository;
@Service
public class TaskService {

 private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
            this.taskRepository = taskRepository;
        }


    public List<Task> getAllTasks() {
        // Lógica para obter todas as tarefas do banco de dados
        return taskRepository.findAll();
    }

    public void createTask(String title){
        // Lógica para criar uma nova tarefa
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        // Lógica para deletar uma tarefa
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id){
     Task task = taskRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada com o ID: " + id));
      task.setCompleted(!task.isCompleted());
      taskRepository.save(task);
    }

}
