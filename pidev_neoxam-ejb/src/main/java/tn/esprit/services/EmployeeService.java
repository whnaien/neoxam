package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Project;
import tn.esprit.entities.User;

@Local
public interface EmployeeService {

	public List<Employee> allUsers();

	public User singleUser(int id);
	
	public Employee searchForEmployee(String criteria);


	public User saveUser(Employee user);

	public User updateUser(Employee user) throws Exception;

	public void deleteUser(int id) throws Exception;

	public List<Employee> getEmployeesByResponsable(Employee responsable);

	public List<Employee> getEmployeesByProject(Project project);

	public void assignProjectToEmployee(Employee employee, int projectId);

	public void assignResponsableToEmployee(Employee employee, int responsable_id);

}
