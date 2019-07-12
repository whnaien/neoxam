package tn.esprit.dao;

import java.util.List;

import tn.esprit.entities.Product;
import tn.esprit.entities.Project;

public interface ProductDao {
	
	public List<Product> allProducts();

	public Product singleProduct(int id);

	public Product saveProduct(Product product);

	public Product updateProduct(Product product) throws Exception;

	public void deleteProduct(int id) throws Exception;
	
	public Project assignProjectToProduct(int product_id, Project project);

}
