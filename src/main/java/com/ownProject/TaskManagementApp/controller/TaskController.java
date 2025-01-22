package com.ownProject.TaskManagementApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ownProject.TaskManagementApp.model.Task;
import com.ownProject.TaskManagementApp.service.TaskService;

@RestController
@RequestMapping("/api")

public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@PostMapping("/saveTask")
	public Task saveTask(@RequestBody Task task) {
		return taskService.SaveTask(task);
	}
	
	@GetMapping("/alltasks")
	public List<Task> fetchAllTask(){
		return taskService.fetchAllTask();
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable("id") Long taskId) {
		taskService.deleteTask(taskId);
		return "deleted succesfully";
	}
	
	@GetMapping("/getTask/{holderName}")
	public Task getHolderName(@PathVariable("holderName") String holderName) {
		return taskService.getByName(holderName);
	}
	
	@PutMapping("/changeStatus/{id}")
	public Task updateTask(@PathVariable("id") Long taskId,@RequestBody Task task) {
		return taskService.updateTask(taskId,task);
	}
	
}
