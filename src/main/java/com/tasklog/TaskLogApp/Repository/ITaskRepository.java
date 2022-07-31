package com.tasklog.TaskLogApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasklog.TaskLogApp.Model.Task;

public interface ITaskRepository extends JpaRepository<Task,Integer> {

}
