package tn.esprit.webservice;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import tn.esprit.dao.RisksDao;
import tn.esprit.entities.Employee;
import tn.esprit.entities.Risk;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;


@Path("risks")
@LocalBean
@Stateless
public class RiskResource {

	@EJB
	RisksDao riskDAO;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return 
				Response.ok(riskDAO.getAllRisks()).build();
	}
	
	
	@GET
	@Path("{ref}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRiskByRef(@PathParam(value="ref") int ref) {
		return 
				Response.ok(riskDAO.getRiskByRef(ref)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddRisk(Risk r){
			 riskDAO.addRisk(r);
			  String json = "{'message' : 'success'}";
					    return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("{ref}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteRisks(@PathParam(value="ref") int ref) {
			
			riskDAO.deleteRisks(ref);
			return "deleted with success";	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String sendWeeklyReport(Employee employee){
			 riskDAO.sendWeeklyReport(employee);
			return "Email send with success";	
	}

	
}
