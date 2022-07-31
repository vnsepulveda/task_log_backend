package com.tasklog.TaskLogApp.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.tasklog.TaskLogApp.Model.Task;
import com.tasklog.TaskLogApp.Repository.ITaskRepository;

class TaskServiceImplTest {
	
	@Mock
	private ITaskRepository repository;
	
	@InjectMocks
	private TaskServiceImpl taskServiceImpl;
	
	private Task task;
	
	@BeforeEach
	void setUp(){
		MockitoAnnotations.initMocks(this);
		task = new Task();
		task.setId(1);
		task.setDescripcion("description");
		task.setInsert_time(LocalDateTime.now());
		task.setValid(true);
	}
	
	@Test
	void getAll() {
		when(repository.findAll()).thenReturn(Arrays.asList(task));
		assertNotNull(taskServiceImpl.getAll());
	}
	
	@Test
	void register() {
		when(repository.save(task)).thenReturn(task);
		assertNotNull(taskServiceImpl.register(task));
	}
	
	@Test
	void update() {
		when(repository.save(task)).thenReturn(task);
		assertNotNull(taskServiceImpl.update(task));
	}
	
	@Test
	void delete() {
		when(repository.getById(1)).thenReturn(task).thenReturn(null);
		assertNotNull(taskServiceImpl.update(task));
	}
	
	
}
