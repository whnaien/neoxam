package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.dao.ITaskCrud;
import tn.esprit.entities.Candidat;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Project;
import tn.esprit.entities.Task;

@Stateless
@LocalBean
public class TaskCrud implements ITaskCrud {
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	@Override
	public void addTask(Task task, int idProject)
	{
		Project project =em.find(Project.class,idProject );
		//task.setEmployee(employee);
		task.setProject(project);
		
		em.persist(task);
		
	}
public void affectEmployeeToTask(int idTask , int idEmployee)
{
	Task task = em.find(Task.class, idTask );
	Employee employee = em.find(Employee.class, idEmployee );
	task.setEmployee(employee);
	em.merge(task);
	em.flush();



	}

	@Override
	public void removeTask(int id) {
		em.remove(em.find(Task.class,id ));		
		
	}

	@Override
	public void updateTask(Task taskNewValue) {

		em.merge(taskNewValue);
		em.flush();
	}

	@Override
	public Task findTaskById(int id) {
		Task task = em.find(Task.class, id);
		return task;
	}

	@Override
	public List<Task> findAllTasks() {
		List<Task> tasks = em.createQuery("from Task", Task.class).getResultList();
		return tasks;
	}


}
