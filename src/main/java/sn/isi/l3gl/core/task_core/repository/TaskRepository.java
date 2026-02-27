package sn.isi.l3gl.core.task_core.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.l3gl.core.task_core.entity.Status;
import sn.isi.l3gl.core.task_core.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    long countByStatus(Status status);
}