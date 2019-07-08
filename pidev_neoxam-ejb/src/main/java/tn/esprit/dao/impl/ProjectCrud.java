package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.dao.IProjectCrud;
import tn.esprit.entities.Project;

@Stateless
@LocalBean
public class ProjectCrud implements IProjectCrud {
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	@Override
	public void addProject(Project project)
	{

		em.persist(project);
		
	}


	@Override
	public void removeProject(int id) {
		em.remove(em.find(Project.class,id ));		
		
	}

	@Override
	public void updateProject(Project projectNewValue) {

		em.merge(projectNewValue);
		em.flush();
	}

	@Override
	public Project findProjectById(int id) {
		Project project = em.find(Project.class, id);
		return project;
	}

	@Override
	public List<Project> findAllProjects() {
		List<Project> projects = em.createQuery("from Project", Project.class).getResultList();
		return projects;
	}


}
