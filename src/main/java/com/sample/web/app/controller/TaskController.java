package com.sample.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sample.web.app.model.Task;
import com.sample.web.app.service.TaskService;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://bpvog76086dns1.eastus2.cloudapp.azure.com:8080", "http://172.18.0.1:8080"})
public class TaskController {

	// inject service
	@Autowired
	private TaskService taskService;
	
	/**
	 * This method is to display home page which has form to submit task details.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/home", method = RequestMethod.GET)
    public String showHomePage(ModelMap model){
        return "home";
    }
	
	/**
	 * This method saves the task information in database and map the ModelMap object 
	 * with tasks information.
	 * 
	 * @param model
	 * @param name
	 * @param description
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value="/home")
	public String addTask(ModelMap model, @RequestParam String name, @RequestParam String description) {
		if (null != name && null != description) {
			Task task = new Task();
			task.setName(name);
			task.setDescription(description);
			// Add task to db
			taskService.addTask(task);
			// return to welcome page on successful addition of task.
			return "welcome";
		}
		model.put("errorMessage", "Fields should not be empty");
		// upon failure return to home page with error message.
		return "home";
	}
	
	/**
	 * This method is to retrieve task updation page where we can enter task details
	 * to update it.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/update-task")
	public String getTaskUpdationPage(ModelMap model) {
		// return to task page where you can update task by its name.
		return "task";
	}
	
	/**
	 * This method is to update task details in db.
	 * 
	 * @param model
	 * @param name
	 * @param description
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value="/update-task")
	public String updateTaskByName(ModelMap model, @RequestParam String name, @RequestParam String description) {
		// if name or description is empty return to same page with error message.
		if (null != name && description != null) {
			Task task = taskService.getTaskByName(name);
			if (task == null) {
				model.put("errorMessage", "Task is not available with mentioned name");
				/*
				 * if task is not avialable with that name return to same page with error
				 * message.
				 */
				return "task";
			}
			// update task description
			taskService.updateTask(name, description);
			// return to welcome page on successful updation of task.
			return "welcome";
		}
		model.put("errorMessage", "Fields should not be empty");
		return "task";
	}
	
	/**
	 * This method is to return all tasks available in db.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/tasks", method = RequestMethod.GET)
	public String viewAllTask(ModelMap model) {
		// retrieve tasks from db and map it to ModelMap which can be visible in UI
		model.put("tasks", taskService.getAllTasks());
		return "view";
	}
	
}
