package tn.esprit.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.entities.Product;
import tn.esprit.services.impl.ProductServiceImpl;

@Path("products")
@LocalBean
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

	@EJB
	ProductServiceImpl productServiceImpl;

	
	@GET
    public List<Product> getAllProducts() {
        return productServiceImpl.allProducts();
    }
 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product addProduct(Product product) {
        return productServiceImpl.saveProduct(product);
 
    }
 
    @PUT
    @Path("/{sId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product updateProduct(@PathParam("sId") int id, Product product) throws Exception {
        product.setId(id);
        return productServiceImpl.updateProduct(product);
    }
 
    @DELETE
    @Path("/{sId}")
    public void deleteProduct(@PathParam("sId") int id) throws Exception {
    	productServiceImpl.deleteProduct(id);
    }
 
    //http://localhost:8080/pidev_neoxam-web/rest/employees/2365
    @GET
    @Path("/{sId}")
    public Product getProduct(@PathParam("sId") int id) {
        return productServiceImpl.singleProduct(id);
    }

}
