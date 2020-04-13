package com.sample.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.web.app.model.Task;
import com.sample.web.app.repository.TaskRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
public class TaskServiceImpl implements TaskService {

	// inject repository
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void addTask(Task task) {
		if(task != null) {
			taskRepository.save(task);
		}
	}

	@Override
	public Task getTaskByName(String name) {
		return taskRepository.findByName(name);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void updateTask(String name, String description) {
		taskRepository.updateTaskByName(name, description);
	}

}
