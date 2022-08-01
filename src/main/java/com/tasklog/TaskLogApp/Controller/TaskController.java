package com.tasklog.TaskLogApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasklog.TaskLogApp.Model.Task;
import com.tasklog.TaskLogApp.Service.ITaskService;

@Service
@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private ITaskService taskService;
	
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<String> register(@RequestBody Task task) {
		try {
			String result = taskService.register(task);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/all")
	@CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAll();
        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }
	
	@DeleteMapping(value = "/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	 public ResponseEntity<String> deleteTaskById(@PathVariable("id") Integer taskId) {
        String result = taskService.delete(taskId);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
	
	@GetMapping(value = "/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer taskId) {
        Task task = taskService.getById(taskId);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
	
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> updateMovement(@RequestBody Task task) {
        try {
            String result = taskService.update(task);
            return new ResponseEntity<String>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
