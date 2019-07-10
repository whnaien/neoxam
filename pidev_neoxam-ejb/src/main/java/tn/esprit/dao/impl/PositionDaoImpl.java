package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.dao.PositionDao;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Position;

@Stateless
@LocalBean
public class PositionDaoImpl implements PositionDao {

	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	
	
		@Override
		public List<Position> allPositions() {
			// TODO Auto-generated method stub
			Query q = em.createQuery("SELECT s FROM Position s");
	        return (List<Position>) q.getResultList();		}

		@Override
		public Position singlePosition(int id) {
			 Query q = em.createQuery("SELECT s FROM Position s where s.id = :id");
		        q.setParameter("id", id);
		        return (Position) q.getSingleResult();
		        }

		@Override
		public Position savePosition(Position position) {
			 em.persist(position);
		        em.flush();
		        return position;
		}

		@Override
		public Position updatePosition(Position position) throws Exception {
			 try {
		            em.merge(position);
		            em.flush();
		            return position;
		        } catch (Exception e) {
		 
		            System.out.println(e);
		            return null;
		        }
		}

		@Override
		public void deletePosition(int id) throws Exception {
			  try {
		            System.out.println("id : " + id);
		            Query q = em.createQuery("SELECT s FROM Position s WHERE s.id = :id");
		            q.setParameter("id", id);
		             
		            em.remove(em.merge(q.getSingleResult()));
		            em.flush();
		        } catch (Exception e) {
		            System.out.println(e);
		        }			
		}

		@Override
		public List<Employee> getEmployeesByPosition(Position position) {
			
			 Query q = em.createQuery("SELECT s FROM Employee s where s.position_id = :id");
		        q.setParameter("id", position.getId());
		        return (List<Employee>) q.getResultList();
		        }
		
	    
	
	

}