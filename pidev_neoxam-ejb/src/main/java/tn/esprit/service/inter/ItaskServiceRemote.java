package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Task;


@Remote
public interface ItaskServiceRemote {
	public void addTask(Task task, int idProject, int idEmployee);
	public void removeTask(int id); 
	public void updateTask (Task taskNewValue);
	public Task findTaskById(int id);
	public List<Task> findAllTasks();
}
