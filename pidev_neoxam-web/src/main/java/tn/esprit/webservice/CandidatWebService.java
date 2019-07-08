package tn.esprit.webservice;



import java.io.IOException;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.entities.Candidat;
import tn.esprit.service.CandidatService;




@Path("candidat")
@Stateless
public class CandidatWebService  {
	

		EntityManager em;
		@EJB
		CandidatService candidatService;
		
	@POST
    @Consumes(MediaType.APPLICATION_JSON)

	public Response addCandidate(Candidat candidat) 
	{
		
		try {
			candidatService.addCandidat(candidat);
			return Response.status(Status.CREATED).build();
			
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();

		}
			


	}
	/*@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("{entity}")
	public Response addSkill(@PathParam("entity") String entity ,JsonParser   requestEntity) throws JsonParseException, JsonMappingException, IOException 
	{
	    ObjectMapper objectMapper=new ObjectMapper();
		Candidat candidat = new Candidat();
	    HashMap<String, Object> mapper = new HashMap<>(); //Diamond )))

	    //mapper = (HashMap<String, Object>) requestEntity;

	    candidat =objectMapper.readValue( requestEntity,Candidat.class);
		if (entity.equals("candidat"))
		{
			if(candidatService.addCandidat(candidat)!="")
				return Response.status(Status.CREATED).build();
			else
				return Response.status(Status.NOT_ACCEPTABLE).build();
				
		}
		
			
		
			return Response.status(Status.NOT_ACCEPTABLE).build();

	}*/
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCandidat( Candidat candidate)
	{
		try {
			candidatService.updateCandidat(candidate);
			return  Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}


	}
	@POST
	public Response invitCandidat(@QueryParam(value="email") String email ,@QueryParam(value="PSTpath") String PSTpath)
	{
		if (email!="")
		{
		candidatService.invitCandidat("marwensabri@gmail.com");

		return  Response.status(Status.OK).build();
		}
		else if (PSTpath!="")
			candidatService.extarctPst("/Users/marwensabri/Desktop/PI2019/backup.pst");
			return  Response.status(Status.OK).build();

	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
		public Response getAllCandidat(@QueryParam("email")String email) {
		if (email!=null)
			return  Response.status(Status.OK).entity(candidatService.findCandidatById(email)).build();
		else
		return  Response.status(Status.OK).entity(candidatService.findAllCandidats()).build();
		//candidatService.extarctPst("/Users/marwensabri/Desktop/PI2019/backup.pst");
		
		}


	@DELETE
	@Path("{id}")
	public Response DeleteCoach(@PathParam(value="id")String email)
	{
		try {
			candidatService.removeCandidat(email);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
	}
	

}
