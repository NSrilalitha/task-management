package com.sample.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.web.app.model.Task;

@Service
public interface TaskService {
	
	public List<Task> getAllTasks();
	
	public void addTask(Task task);
	
	public Task getTaskByName(String name);
	
	public void updateTask(String name, String description);
}
