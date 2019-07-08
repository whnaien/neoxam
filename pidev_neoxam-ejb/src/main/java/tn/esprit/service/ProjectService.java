package tn.esprit.service;

import java.util.ArrayList;
import java.util.List;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import tn.esprit.dao.impl.ProjectCrud;
import tn.esprit.entities.Project;
import tn.esprit.entities.Task;
import tn.esprit.service.inter.IprojectServiceLocal;
import tn.esprit.service.inter.IprojectServiceRemote;



@Stateless
@LocalBean
public class ProjectService implements IprojectServiceLocal,IprojectServiceRemote  {
	
		@PersistenceContext(unitName = "pidev")
		EntityManager em;
		@EJB
		ProjectCrud projectCrud;
		

	@Override
	public void addProject(Project project) {
		 projectCrud.addProject(project);
		
			
	}

	@Override
	public void removeProject(int id) {
		projectCrud.removeProject(id);
		
	}

	@Override
	public void updateProject(Project projectNewValue) {

		projectCrud.updateProject(projectNewValue);
	}

	@Override
	public Project findProjectById(int  id) {
		// TODO Auto-generated method stub
		return projectCrud.findProjectById(id);
	}

	@Override
	public List<Project> findAllProjects() {
		// TODO Auto-generated method stub
		return projectCrud.findAllProjects();
	}

	@Override
	public List<Task> GetTasksByProject(int idProject) {
		Project project = em.find(Project.class, idProject);
		List<Task> tasks = new ArrayList<Task>();
		for (Task task : project.getTasks()) {
			tasks.add(task);
		}
		return tasks;	
		
	}



}
