package tn.esprit.webservice;



import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import tn.esprit.entities.Task;
import tn.esprit.service.TaskService;




@Path("task")
@Stateless
public class TaskWebService  {
	

		EntityManager em;
		@EJB
		TaskService taskService;
		
	@POST
    @Consumes(MediaType.APPLICATION_JSON)

	public Response addTask(Task task,@QueryParam ("idProject")int idProject,@QueryParam ("idEmployee")int idEmployee) 
	{
		if (idProject!=0) {
		try {
			taskService.addTask(task,idProject);
			return Response.status(Status.CREATED).build();
			
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();

		}
		}
		else if (idEmployee!=0)
		{
			try {
				taskService.affectEmployeeToTask(task.getId(), idEmployee);
				return Response.status(Status.CREATED).build();
				
			} catch (Exception e) {
				return Response.status(Status.NOT_ACCEPTABLE).build();

			}
		}
		 return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTask( Task task)
	{
		try {
			taskService.updateTask(task);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
		public Response getAllTask(@PathParam(value="id")int id) {
		if (id == 0)
		return  Response.status(Status.OK).entity(taskService.findAllTasks()).build();
		else
		return  Response.status(Status.OK).entity(taskService.findTaskById(id)).build();

		
		}

	@DELETE
	@Path("{id}")
	public Response DeleteTask(@PathParam(value="id")int id)
	{
		try {
			taskService.removeTask(id);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}
	

}
