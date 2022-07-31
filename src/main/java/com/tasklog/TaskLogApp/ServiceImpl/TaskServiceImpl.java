package com.tasklog.TaskLogApp.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasklog.TaskLogApp.Model.Task;
import com.tasklog.TaskLogApp.Repository.ITaskRepository;
import com.tasklog.TaskLogApp.Service.ITaskService;

@Service
public class TaskServiceImpl implements ITaskService {
	
	@Autowired
	public ITaskRepository repository;
	
	public String register(Task task) {
		String result = "";
		try {
			task.setInsert_time(LocalDateTime.now());
			repository.save(task);
			result = "Task saved succesfully";
		}catch(Exception e) {
			result = e.getMessage();
		}
		return result;
	}
	
	public List<Task> getAll(){
		return repository.findAll();
	}
	
	public String delete(Integer idTask) {
		String result = "";
		try {
			repository.deleteById(idTask);
			result = "Task deleted succesfully";
		}catch(Exception e) {
			result = e.getMessage();
		}
		return result;
	}
	
	
	public String update(Task task) {
		String result = "";
		try {
			Task existingTask = repository.getById(task.getId());
			existingTask.setDescripcion(task.getDescripcion());
			existingTask.setValid(task.getValid());
			repository.save(existingTask);
			result = "Task updated succesfully";
		}catch(Exception e) {
			result = e.getMessage();
		}
		return result;
	}
	
}
