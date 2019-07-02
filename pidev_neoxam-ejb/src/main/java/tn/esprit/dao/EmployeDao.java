package tn.esprit.dao;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Employee;
import tn.esprit.entities.User;


@Local
public interface EmployeDao {
	public int addEmployee(Employee employe);
	public void updateEmployee(Employee employe);
	public void deleteEmployee(int id);
	public List<User> getAllEmployees();
	public Employee getEmployeeById(int cin);




}
