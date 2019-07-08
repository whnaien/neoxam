package tn.esprit.service;

import java.util.List;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import tn.esprit.dao.impl.TaskCrud;
import tn.esprit.entities.Task;
import tn.esprit.service.inter.ItaskServiceLocal;
import tn.esprit.service.inter.ItaskServiceRemote;



@Stateless
@LocalBean
public class TaskService implements ItaskServiceLocal,ItaskServiceRemote  {
	
		@PersistenceContext(unitName = "pidev")
		EntityManager em;
		@EJB
		TaskCrud taskCrud;
		

	@Override
	public void addTask(Task task,int idProject , int idEmployee) {
		 taskCrud.addTask(task,idProject,idEmployee);
		
			
	}

	@Override
	public void removeTask(int id) {
		taskCrud.removeTask(id);
		
	}

	@Override
	public void updateTask(Task taskNewValue) {

		taskCrud.updateTask(taskNewValue);
	}

	@Override
	public Task findTaskById(int  id) {
		// TODO Auto-generated method stub
		return taskCrud.findTaskById(id);
	}

	@Override
	public List<Task> findAllTasks() {
		// TODO Auto-generated method stub
		return taskCrud.findAllTasks();
	}



}
