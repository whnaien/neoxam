package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.dao.EmployeDao;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Position;
import tn.esprit.entities.Project;
import tn.esprit.entities.User;

@Stateless
@LocalBean
public class EmployeeDaoImp implements EmployeDao {

	@PersistenceContext(unitName = "pidev")
	EntityManager em;

	public List<Employee> allUsers() {
		Query q = em.createQuery("SELECT s FROM Employee s where s.active = :active");
		q.setParameter("active", 1);
		return (List<Employee>) q.getResultList();
	}

	public User singleUser(int cin) {
		Query q = em.createQuery("SELECT s FROM Employee s where s.cin = :cin");
		q.setParameter("cin", cin);
		return (User) q.getSingleResult();
	}

//	    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public User saveUser(Employee user) {
		user.setActive(1);
		em.persist(user);
		em.flush();
		return user;
	}

//	    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public User updateUser(Employee user) throws Exception {
		try {
			em.merge(user);
			em.flush();
			return user;
		} catch (Exception e) {

			System.out.println(e);
			return null;
		}
	}

	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteUser(int id) throws Exception {
		try {
			System.out.println("id : " + id);
			Query q = em.createQuery("SELECT s FROM Employee s WHERE s.id = :id");
			q.setParameter("id", id);

			Employee employee = (Employee) q.getSingleResult();

			employee.setActive(0);
			em.merge(employee);

			// em.remove(em.merge(q.getSingleResult()));
			em.flush();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public List<Employee> getEmployeesByResponsable(Employee responsable) {

		Query q = em.createQuery("SELECT s FROM Employee s where s.responsable_id = :responsable_id");
		q.setParameter("responsable_id", responsable.getId());
		return (List<Employee>) q.getResultList();

		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getEmployeesByProject(Project project) {

		Query q = em.createQuery("SELECT s FROM Employee s where s.project_id = :project_id");
		q.setParameter("project_id", project.getId());
		return (List<Employee>) q.getResultList();

	}

	@Override
	public void assignProjectToEmployee(Employee employee, int projectId) {
		Project project = em.find(Project.class, projectId);
		employee.setProject(project);
		em.merge(employee);
		em.flush();

	}

	@Override
	public void assignResponsableToEmployee(Employee employee, int responsable_id) {
		Employee responsable= em.find(Employee.class, responsable_id);
		employee.setResponsable(responsable);
		em.merge(employee);
		em.flush();

	}

	@Override
	public Employee searchForEmployee(String criteria) {
//		Query q = em.createQuery("SELECT s FROM Employee s where s.cri = :cin");
//		q.setParameter("cin", cin);
//		return (User) q.getSingleResult();
		return null;
	}

	@Override
	public void assignPositionToEmployee(Employee employee, int position_id) {
		
		Position position= em.find(Position.class, position_id);
		employee.setPosition(position);
		em.merge(employee);
		em.flush();

		
	}

}
