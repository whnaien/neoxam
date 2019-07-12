package tn.esprit.dao;

import java.util.List;

import tn.esprit.entities.Employee;
import tn.esprit.entities.User;

//@Local
public interface EmployeDao {

	public List<Employee> allUsers();

	public User singleUser(int id);
	
	public Employee searchForEmployee(String criteria);

	public User saveUser(Employee user);

	public User updateUser(Employee user) throws Exception;

	public void deleteUser(int id) throws Exception;
	
	public List<Employee> getEmployeesByResponsable(int responsable_id);

	public List<Employee> getEmployeesByProject(int project_id);
	
	public Employee assignProjectToEmployee(Employee employee, int projectId);
	
	public Employee assignResponsableToEmployee(Employee employee, int responsable_id);
	
	public User assignPositionToUser(User user, int position_id);

}
