package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.dao.EmployeDao;
import tn.esprit.entities.Employee;
import tn.esprit.entities.User;

@Stateless
@LocalBean
public class EmployeeDaoImp implements EmployeDao {

	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	
	
	 public List<Employee> allUsers() {
	        Query q = em.createQuery("SELECT s FROM Employee s");
	        return (List<Employee>) q.getResultList();
	    }
	 
	    public User singleUser(int cin) {
	        Query q = em.createQuery("SELECT s FROM Employee s where s.cin = :cin");
	        q.setParameter("cin", cin);
	        return (User) q.getSingleResult();
	    }
	     
//	    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	    public User saveUser(Employee user) {
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
	    public void deleteUser(int cin) throws Exception {
	        try {
	            System.out.println("cin : " + cin);
	            Query q = em.createQuery("SELECT s FROM Employee s WHERE s.cin = :cin");
	            q.setParameter("cin", cin);
	             
	            em.remove(em.merge(q.getSingleResult()));
	            em.flush();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    
	    
	
	

}
