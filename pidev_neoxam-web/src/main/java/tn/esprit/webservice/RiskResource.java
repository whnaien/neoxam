package tn.esprit.webservice;

import java.util.List;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;
import tn.esprit.service.RiskService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;


@Path("risks")
@LocalBean
@Stateless
public class RiskResource {

	@EJB
	RiskService riskService;
	
	/*@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public Response addRisk(Risk risks) 
	{
		if(riskService.addRisk(risks)!="")
				return Response.status(Status.CREATED).build();
				else
				return Response.status(Status.NOT_ACCEPTABLE).build();

	}*/
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok(riskDAO.getAllRisks()).build();
		//return Response.status(Status.OK).entity(riskDAO.getAllRisks()).build();
		
	}*/
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	 public List<Risk> getRisks_JSON() {
	        List<Risk> listOfRisks = riskService.addRisk(risks);
	        return listOfRisks;
	    }*/
	
	
	@GET
	@Path("{ref}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRiskByRef(@PathParam(value="ref") String ref) {
		return 
				Response.ok(riskService.getRiskByRef(ref)).build();
	}

	@PUT
	@Path("/AddRisk")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddRisk(Risk r){
			 riskService.addRisk(r);
			  String json = "{'message' : 'success'}";
					    return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("{ref}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteRisks(@PathParam(value="ref") String ref) {
			
			riskService.deleteRisks(ref);
			return "deleted with success";	
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
