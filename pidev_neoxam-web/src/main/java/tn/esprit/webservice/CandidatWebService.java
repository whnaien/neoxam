package tn.esprit.webservice;



import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.entities.Candidat;
import tn.esprit.service.CandidatService;




@Path("candidat")
@Stateless
public class CandidatWebService  {
	

		@PersistenceContext(unitName = "pidev")
		EntityManager em;
		@EJB
		CandidatService candidatService;
		
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Response addCandidate(Candidat candidate) 
	{
		if(candidatService.addCandidat(candidate)!="")
				return Response.status(Status.CREATED).build();
				else
				return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response PutRDV( Candidat candidate)
	{
		
		candidatService.updateCandidat(candidate);
		return  Response.status(Status.OK).build();

	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
		public Response getAllCandidat() {
		for (Candidat c : candidatService.findAllCandidats())
		{
			System.out.println(c.getFirstname());
		}
		return  Response.status(Status.OK).entity(candidatService.findAllCandidats()).build();
		
		}

	
	

}
