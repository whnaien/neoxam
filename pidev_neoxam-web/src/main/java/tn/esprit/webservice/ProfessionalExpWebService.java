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


import tn.esprit.entities.ProfessionalExp;
import tn.esprit.service.ProfessionalExpService;




@Path("professionalExp")
@Stateless
public class ProfessionalExpWebService  {
	

		EntityManager em;
		@EJB
		ProfessionalExpService professionalExpService;
		
	@POST
    @Consumes(MediaType.APPLICATION_JSON)

	public Response addProfessionalExp(ProfessionalExp professionalExp,@QueryParam ("email")String email) 
	{
		
		try {
			professionalExpService.addProfessionalExp(professionalExp,email);
			return Response.status(Status.CREATED).build();
			
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();

		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProfessionalExp( ProfessionalExp professionalExp)
	{
		try {
			professionalExpService.updateProfessionalExp(professionalExp);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
		public Response getAllProfessionalExp(@PathParam(value="id")int id) {
		if (id == 0)
		return  Response.status(Status.OK).entity(professionalExpService.findAllProfessionalExps()).build();
		else
		return  Response.status(Status.OK).entity(professionalExpService.findProfessionalExpById(id)).build();

		
		}

	@DELETE
	@Path("{id}")
	public Response DeleteProfessionalExp(@PathParam(value="id")int id)
	{
		try {
			professionalExpService.removeProfessionalExp(id);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}
	

}
