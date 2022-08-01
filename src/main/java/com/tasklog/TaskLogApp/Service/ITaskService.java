package com.tasklog.TaskLogApp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tasklog.TaskLogApp.Model.Task;

@Service
public interface ITaskService {
	
	String register(Task task);
	List<Task> getAll();
	String delete(Integer idTask);
	Task getById(Integer idTask);
	String update(Task task);
}
