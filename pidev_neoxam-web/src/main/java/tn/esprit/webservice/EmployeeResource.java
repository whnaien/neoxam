package tn.esprit.webservice;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.dao.inter.EmployeDao;


@Path("employees")
@LocalBean
@Stateless
public class EmployeeResource {

	@EJB
	EmployeDao employeeDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return 
				Response.ok(employeeDAO.getAllEmployees()).build();
	}

//	    @GET
//	    @Path("{id}")
//	    public Response getTodo(@PathParam("id") Long id) {
//	        Todo todo = todoDAO.findById(id);
//
//	        return Response.ok(todo).build();
//	    }
//
//	    @PUT
//	    @Path("{id}")
//	    public Response update(@PathParam("id") Long id, Todo todo) {
//	        Todo updateTodo = todoDAO.findById(id);
//
//	        updateTodo.setTask(todo.getTask());
//	        updateTodo.setDescription(todo.getDescription());
//	        todoDAO.update(updateTodo);
//
//	        return Response.ok().build();
//	    }
//
//	    @POST
//	    public Response create(Todo todo) {
//	        todoDAO.create(todo);
//	        return Response.ok().build();
//	    }
//
//	    @DELETE
//	    @Path("{id}")
//	    public Response delete(@PathParam("id") Long id) {
//	        Todo getTodo = todoDAO.findById(id);
//	        
//	        todoDAO.delete(getTodo);
//
//	        return Response.ok().build();
//	    }

}
