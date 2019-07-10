package tn.esprit.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.dao.impl.EmployeeDaoImp;
import tn.esprit.entities.Employee;
import tn.esprit.entities.User;
import tn.esprit.services.EmployeeService;

@Stateless
@LocalBean
public class EmployeeServiceImpl implements EmployeeService{
	

	
	
	
	
	@EJB
	EmployeeDaoImp employeeDaoImp;
	
	@Override
	public List<Employee> allUsers() {
		// TODO Auto-generated method stub
		return employeeDaoImp.allUsers();
	}

	@Override
	public User singleUser(int cin) {
		// TODO Auto-generated method stub
		return employeeDaoImp.singleUser(cin);
	}

	@Override
	public User saveUser(Employee user) {
		// TODO Auto-generated method stub
		return employeeDaoImp.saveUser(user);
	}

	@Override
	public User updateUser(Employee user) throws Exception {
		// TODO Auto-generated method stub
		return employeeDaoImp.updateUser(user);
	}

	@Override
	public void deleteUser(int cin) throws Exception {
		// TODO Auto-generated method stub
		employeeDaoImp.deleteUser(cin);
		
	}

	@Override
	public List<Employee> getEmployeesByResponsable(int responsable_id) {
		return employeeDaoImp.getEmployeesByResponsable(responsable_id);
		
	}

	@Override
	public List<Employee> getEmployeesByProject(int project_id) {
		// TODO Auto-generated method stub
		return employeeDaoImp.getEmployeesByProject(project_id);
	}

	@Override
	public Employee assignProjectToEmployee(Employee employee, int projectId) {
		return employeeDaoImp.assignProjectToEmployee(employee, projectId);
		
	}

	@Override
	public Employee assignResponsableToEmployee(Employee employee, int responsable_id) {
		return employeeDaoImp.assignResponsableToEmployee(employee, responsable_id);
		
	}

	@Override
	public Employee searchForEmployee(String criteria) {
		// TODO Auto-generated method stub
		return employeeDaoImp.searchForEmployee(criteria);
	}

	@Override
	public User assignPositionToUser(User employee, int position_id) {
		// TODO Auto-generated method stub
		return employeeDaoImp.assignPositionToUser(employee, position_id);
		
	}
	
	

}
