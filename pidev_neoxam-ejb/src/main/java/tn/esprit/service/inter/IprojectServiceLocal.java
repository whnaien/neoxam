package tn.esprit.service.inter;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Project;


@Local
public interface IprojectServiceLocal {
	public void addProject(Project project);
	public void removeProject(int id); 
	public void updateProject (Project projectNewValue);
	public Project findProjectById(int id);
	public List<Project> findAllProjects();
	
	
}