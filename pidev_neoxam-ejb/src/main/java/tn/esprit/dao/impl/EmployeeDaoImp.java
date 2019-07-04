package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.EmployeDao;
import tn.esprit.entities.Employee;
import tn.esprit.entities.User;

@Stateless
public class EmployeeDaoImp implements EmployeDao {

	@PersistenceContext(unitName = "pidev")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public int addEmployee(Employee employee) {
		em.persist(employee);
		return employee.getCin();
	}

	@Override
	public void updateEmployee(Employee employe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllEmployees() {
		return (List<User>) em.createQuery(
	              "SELECT e FROM User e").getResultList();
		
		
		
//		List<User> emp = em.createQuery("Select e from User e", User.class).getResultList();
//		return emp;
//		// TODO Auto-generated method stub
//		Employee emp =  em.find(Employee.class, 25);
//		List<Employee> a = new ArrayList<Employee>();
//		a.add(emp);
//		return a;
	}

	@Override
	public Employee getEmployeeById(int cin) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Employee getEmployeeById(int cin) {
//		TypedQuery<Employee> query = em
//				.createQuery("select e from User e WHERE e.cin=:cin", Employee.class);
//		query.setParameter("cin", cin);
//		Employee employe = null;
//		try {
//			employe = query.getSingleResult();
//		} catch (Exception e) {
//			System.out.println("Erreur : " + e);
//		}
//		return employe;
//	}
//
//	@Override
//	public void updateEmployee(Employee employe) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteEmployee(int id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Employee> getAllEmployees() {
//		return em.fin
//	}

//	@Override
//	public void updateEmploye(Employee employe) {
////		Employee emp = em.find(Employee.class, employe.getCin());
////		emp.setPrenom(employe.getPrenom());
////		emp.setNom(employe.getNom());
////		emp.setEmail(employe.getEmail());
////		emp.setPassword(employe.getPassword());
////		emp.setIsActive(employe.getIsActive());
////		emp.setRole(employe.getRole());
//	}

//	@Override
//	public List<Employe> getAllEmployes() {
//		List<Employe> emp = em.createQuery("Select e from Employe e", Employe.class).getResultList();
//		return emp;
//	}
//
//	@Override
//	public void deleteEmploye(int employeId) {
//		em.remove(em.find(Employe.class, employeId));
//	}
//
//	@Override
//	public void updateEmployee(Employee employe) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteEmployee(int id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Employee> getAllEmployees() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Employee getEmployeeById(String email, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
