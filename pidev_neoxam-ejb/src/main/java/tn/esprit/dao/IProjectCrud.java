package tn.esprit.dao;

import java.util.List;

import tn.esprit.entities.Project;


public interface IProjectCrud {
	public void addProject(Project project);
	public void removeProject(int id); 
	public void updateProject (Project projectNewValue);
	public Project findProjectById(int id);
	public List<Project> findAllProjects();
}
