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


import tn.esprit.entities.Project;
import tn.esprit.service.ProjectService;




@Path("project")
@Stateless
public class ProjectWebService  {
	

		EntityManager em;
		@EJB
		ProjectService projectService;
		
	@POST
    @Consumes(MediaType.APPLICATION_JSON)

	public Response addProject(Project project) 
	{
		
		try {
			projectService.addProject(project);
			return Response.status(Status.CREATED).build();
			
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();

		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProject( Project project)
	{
		try {
			projectService.updateProject(project);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
		public Response getAllProject(@QueryParam("id")int id,@QueryParam("idProject")int idProject) {
		if (id == 0 && idProject==0)
		return  Response.status(Status.OK).entity(projectService.findAllProjects()).build();
		else if (id!=0 && idProject==0)
		return  Response.status(Status.OK).entity(projectService.findProjectById(id)).build();
		else if(idProject!=0 && id==0)
			return  Response.status(Status.OK).entity(projectService.GetTasksByProject(idProject)).build();
		return Response.status(Status.NOT_ACCEPTABLE).build();
		
		}

	@DELETE
	@Path("{id}")
	public Response DeleteProject(@PathParam(value="id")int id)
	{
		try {
			projectService.removeProject(id);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}
	

}
