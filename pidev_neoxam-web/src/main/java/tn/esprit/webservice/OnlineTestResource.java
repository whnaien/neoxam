package tn.esprit.webservice;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.dao.EmployeDao;
import tn.esprit.entities.OnlineTest;
import tn.esprit.service.OnlineTestServiceImp;
import tn.esprit.service.OnlineTestServiceRemote;

@Path("onlineTest")
@LocalBean
@Stateless
public class OnlineTestResource {
	
	@EJB
	OnlineTestServiceRemote ots;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CreateOnlineTest(OnlineTest onlineTest){
		
		if (ots.createNewOnlineTestPerUser(onlineTest) > 0)
		return Response.status(Status.CREATED).type(MediaType.APPLICATION_JSON).entity("created").build();
		return Response.status(Status.NOT_ACCEPTABLE).entity("not acceptable").build();
	}
	
	
	
	

}
