package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Product;
import tn.esprit.entities.Project;

@Local
public interface ProductService {
	
	public List<Product> allProducts();

	public Product singleProduct(int id);

	public Product saveProduct(Product position);

	public Product updateProduct(Product product) throws Exception;

	public void deleteProduct(int id) throws Exception;
	
	public Project assignProjectToProduct(int product_id, Project project);

}
