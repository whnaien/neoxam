package tn.esprit.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.dao.impl.ProductDaoImpl;
import tn.esprit.entities.Product;
import tn.esprit.services.ProductService;

@Stateless
@LocalBean
public class ProductServiceImpl implements ProductService {

	
	@PersistenceContext(unitName = "pidev")
	EntityManager em;
	
	@EJB
	ProductDaoImpl productDaoImp;

	@Override
	public List<Product> allProducts() {
		// TODO Auto-generated method stub
		return productDaoImp.allProducts();
	}

	@Override
	public Product singleProduct(int id) {
		// TODO Auto-generated method stub
		return productDaoImp.singleProduct(id);
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productDaoImp.saveProduct(product);
	}

	@Override
	public Product updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return productDaoImp.updateProduct(product);
	}

	@Override
	public void deleteProduct(int id) throws Exception {
		// TODO Auto-generated method stub
		productDaoImp.deleteProduct(id);
		
	}
	
	
	
	


}
