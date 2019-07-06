package tn.esprit.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.impl.EmployeeDaoImp;
import tn.esprit.entities.Employee;
import tn.esprit.entities.User;
import tn.esprit.services.EmployeeService;

@Stateless
@LocalBean
public class EmployeeServiceImpl implements EmployeeService{
	

	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	
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

}
