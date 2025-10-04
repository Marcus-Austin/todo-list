package com.example.todo_list.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.todo_list.models.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{

}
