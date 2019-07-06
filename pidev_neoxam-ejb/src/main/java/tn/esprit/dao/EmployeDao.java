package tn.esprit.dao;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Employee;
import tn.esprit.entities.User;

//@Local
public interface EmployeDao {

	public List<Employee> allUsers();

	public User singleUser(int cin);

	public User saveUser(Employee user);

	public User updateUser(Employee user) throws Exception;

	public void deleteUser(int cin) throws Exception;

}
