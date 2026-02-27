package sn.isi.l3gl.core.task_core.service;


import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.task_core.entity.Status;
import sn.isi.l3gl.core.task_core.entity.Task;
import sn.isi.l3gl.core.task_core.repository.TaskRepository;

import java.util.List;

@Service

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    // Creer une tache
    public Task createTask(Task task) {
        task.setStatus(Status.TODO);
        return taskRepository.save(task);
    }

    // Lister les taches
    public List<Task> listTasks() {
        return taskRepository.findAll();
    }


    // Mettre a jour le status d'une tache
    public Task updateStatus(Long id, Status status) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);
        return taskRepository.save(task);
    }
}
