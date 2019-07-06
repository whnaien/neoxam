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

import tn.esprit.entities.Employee;
import tn.esprit.entities.User;
import tn.esprit.services.impl.EmployeeServiceImpl;


@Path("employees")
@LocalBean
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	@EJB
	EmployeeServiceImpl employeeServiceImpl;

	
	@GET
    public List<Employee> getAllUsers() {
        return employeeServiceImpl.allUsers();
    }
 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User addStudent(Employee user) {
        return employeeServiceImpl.saveUser(user);
 
    }
 
    @PUT
    @Path("/{sId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateStudent(@PathParam("sId") int id, Employee user) throws Exception {
        user.setId(id);
        return employeeServiceImpl.updateUser(user);
    }
 
    @DELETE
    @Path("/{sId}")
    public void deleteMessage(@PathParam("sId") int cin) throws Exception {
    	employeeServiceImpl.deleteUser(cin);
    }
 
    //http://localhost:8080/pidev_neoxam-web/rest/employees/2365
    @GET
    @Path("/{sId}")
    public User getUser(@PathParam("sId") int cin) {
        return employeeServiceImpl.singleUser(cin);
    }
    

}
