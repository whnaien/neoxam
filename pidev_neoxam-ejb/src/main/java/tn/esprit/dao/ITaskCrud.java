package tn.esprit.dao;

import java.util.List;


import tn.esprit.entities.Task;





public interface ITaskCrud {
	public void addTask(Task task, int idProject);
	public void affectEmployeeToTask(int idTask , int idEmployee);
	public void removeTask(int id); 
	public void updateTask (Task taskNewValue);
	public Task findTaskById(int id);
	public List<Task> findAllTasks();
}
