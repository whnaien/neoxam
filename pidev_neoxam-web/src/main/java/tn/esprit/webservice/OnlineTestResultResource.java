package tn.esprit.webservice;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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

import tn.esprit.dao.inter.EmployeDao;
import tn.esprit.dao.inter.OnlineTestResultRemoteDao;
import tn.esprit.entities.OnlineTest;
import tn.esprit.entities.OnlineTestResult;
import tn.esprit.entities.OnlineTestResultPk;
import tn.esprit.service.impl.OnlineTestServiceImp;
import tn.esprit.service.inter.OnlineTestResultServiceRemote;
import tn.esprit.service.inter.OnlineTestServiceRemote;

@Path("onlineTestResult")
@LocalBean
@Stateless
public class OnlineTestResultResource {
	
	@EJB
	OnlineTestResultServiceRemote ots;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CreateOnlineTest(OnlineTestResult onlineTestResult){
		
		if (ots.createNewOnlineTestResultPerUser(onlineTestResult) !=null)
		return Response.status(Status.CREATED).type(MediaType.APPLICATION_JSON).entity("created").build();
		return Response.status(Status.NOT_ACCEPTABLE).entity("not acceptable").build();
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListOfOnlineTestResult(){
		
		if (ots.getAllOnlineTestResultJPQLPerUser() != null)
		return Response.status(Status.OK).entity(ots.getAllOnlineTestResultJPQLPerUser()).build();
		return Response.status(Status.NOT_FOUND).build();

	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOnlineTestResultById (@QueryParam(value="idUser") int idUser,@QueryParam(value="idTest") int idTest) {
		
		OnlineTestResult onlineTestResult = ots.getOnlineTestResultByIdPerUser(idUser,idTest);
		
		if (onlineTestResult!=null)
		return Response.status(Status.OK).entity(onlineTestResult).build();
		return Response.status(Status.NOT_FOUND).build();
		    
		
	}
	
	

	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteOnlineTestResult(@QueryParam(value="idUser") int idUser,@QueryParam(value="idTest") int idTest){
		
		if (ots.deleteOnlineTestResultByIdPerUser(idUser,idTest))
		return Response.status(Status.OK).entity("deleted").build();
		return Response.status(Status.NOT_FOUND).entity("not found").build();
	}
	
	
	
	@PUT
	@Path("{idUser}/{idTest}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyOnlineTest(@PathParam(value="idUser") int idUser,@PathParam(value="idTest") int idTest, OnlineTestResult onlineTestResult){
		
		if (ots.updateOnlineTestResultPerUser(onlineTestResult,idUser,idTest))
		return Response.status(Status.OK).entity("updated").build();
		return Response.status(Status.NOT_FOUND).entity("not found").build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
