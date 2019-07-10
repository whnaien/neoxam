package tn.esprit.webservice;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.core.QueryParamInjector;

import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;
import tn.esprit.service.RiskService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;


@Path("risk")
@Stateless
@LocalBean
public class RiskResource {
	
	EntityManager em;
	@EJB
	RiskService riskService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		
		if (riskService.getAllRisks() != null)
		return Response.status(Status.OK).entity(riskService.getAllRisks()).build();
		return Response.status(Status.NOT_FOUND).build();
		
	}
	
	
	@GET
	@Path("{ref}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRiskByRef(@PathParam(value="ref") String ref) {
		if (ref == "")
			return  Response.status(Status.OK).entity(riskService.getAllRisks()).build();
			else
			return  Response.status(Status.OK).entity(riskService.getRiskByRef(ref)).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRisk(Risk risks) 
	{
		if(riskService.addRisk(risks)!="")
				return Response.status(Status.CREATED).build();
				else
				return Response.status(Status.NOT_ACCEPTABLE).build();

	}
	
	@PUT
	@Path("{ref}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRisk(@PathParam(value="ref") String ref, Risk risk)
	{
		try {
			riskService.updateRisks(risk,ref);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}

	}

	
	@DELETE
	@Path("{ref}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteRisks(@PathParam(value="ref") String ref) {
		try {
			riskService.deleteRisks(ref);
			return  Response.status(Status.OK).build();

		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
			
						
	}
	 
	@POST
	@Path("/sendWeeklyReport")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String sendWeeklyReport(Employee employee){
			 riskService.sendWeeklyReport(employee);
			return "Email send with success";	
	}

	
	
}
