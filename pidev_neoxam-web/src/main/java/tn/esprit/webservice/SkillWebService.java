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


import tn.esprit.entities.Skill;
import tn.esprit.service.SkillService;




@Path("skill")
@Stateless
public class SkillWebService  {
	

		EntityManager em;
		@EJB
		SkillService skillService;
		
	@POST
    @Consumes(MediaType.APPLICATION_JSON)

	public Response addSkill(Skill skill,@QueryParam ("email")String email) 
	{
		
		try {
			skillService.addSkills(skill,email);
			return Response.status(Status.CREATED).build();
			
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();

		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSkill( Skill skill)
	{
		try {
			skillService.updateSkill(skill);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
		public Response getAllSkill(@PathParam(value="id")int id) {
		if (id == 0)
		return  Response.status(Status.OK).entity(skillService.findAllSkills()).build();
		else
		return  Response.status(Status.OK).entity(skillService.findSkillById(id)).build();

		
		}

	@DELETE
	@Path("{id}")
	public Response DeleteSkill(@PathParam(value="id")int id)
	{
		try {
			skillService.removeSkill(id);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}
	

}
