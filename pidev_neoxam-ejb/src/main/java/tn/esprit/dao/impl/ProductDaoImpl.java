package tn.esprit.dao.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.dao.ProductDao;
import tn.esprit.entities.Product;

@Stateless
@LocalBean
public class ProductDaoImpl  implements ProductDao {

	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	
	
		@Override
		public List<Product> allProducts() {
			// TODO Auto-generated method stub
			Query q = em.createQuery("SELECT s FROM Product s");
	        return (List<Product>) q.getResultList();		}

		@Override
		public Product singleProduct(int id) {
			 Query q = em.createQuery("SELECT s FROM Product s where s.id = :id");
		        q.setParameter("id", id);
		        return (Product) q.getSingleResult();
		        }

		@Override
		public Product saveProduct(Product product) {
			 em.persist(product);
		        em.flush();
		        return product;
		}

		@Override
		public Product updateProduct(Product product) throws Exception {
			 try {
		            em.merge(product);
		            em.flush();
		            return product;
		        } catch (Exception e) {
		 
		            System.out.println(e);
		            return null;
		        }
		}

		@Override
		public void deleteProduct(int id) throws Exception {
			  try {
		            System.out.println("id : " + id);
		            Query q = em.createQuery("SELECT s FROM Product s WHERE s.id = :id");
		            q.setParameter("id", id);
		             
		            em.remove(em.merge(q.getSingleResult()));
		            em.flush();
		        } catch (Exception e) {
		            System.out.println(e);
		        }			
		}
	    
	    
	
	

}