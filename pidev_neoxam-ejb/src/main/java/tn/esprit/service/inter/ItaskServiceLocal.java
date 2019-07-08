package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Task;


@Local
public interface ItaskServiceLocal {
	public void addTask(Task task, int idProject, int idEmployee);
	public void removeTask(int id); 
	public void updateTask (Task taskNewValue);
	public Task findTaskById(int id);
	public List<Task> findAllTasks();
	
	
}
