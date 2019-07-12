package tn.esprit.webservice;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.dao.inter.EmployeDao;
import tn.esprit.entities.OnlineTest;
import tn.esprit.entities.OnlineTestResult;
import tn.esprit.entities.Question;
import tn.esprit.service.impl.OnlineTestServiceImp;
import tn.esprit.service.inter.OnlineTestServiceRemote;

@Path("onlineTest")
@LocalBean
@Stateless
public class OnlineTestResource {
	
	@EJB
	OnlineTestServiceRemote ots;
	
	
	
	@POST
	@Path("/SendScore")
	@Produces("text/plain")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response sendOnlineTestScore ( @QueryParam (value="email") String email, String body) throws MessagingException  {
		
		if (ots.sendAnEmailToCandidate(email,body ))
		return Response.status(Status.OK).entity("email sent").build();
		return Response.status(Status.NOT_FOUND).entity("email issue").build();
		    
		
	}
	
	
	
	@POST
	@Path("/sourceCode")
	@Produces("text/plain")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response compileExecuteCode (String sourceCode) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		String response = ots.javaCompilerExecution(sourceCode);
		if (response!=null)
		return Response.status(Status.OK).entity(response).build();
		return Response.status(Status.NOT_FOUND).entity(response).build();
		    
		
	}
	
	

	@POST
	@Path("/score/{onlineTestId}/{candidatId}")
	@Produces("text/plain")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getScoreByTestById (@PathParam (value="onlineTestId") int onlineTestId,@PathParam (value="candidatId") int candidatId, String score) throws URISyntaxException {
		
		URI u = new URI(HttpHeaders.LOCATION);
		if (ots.scoreAllocationToCandiadte(onlineTestId,candidatId,score) == true)
		return Response.status(Status.OK).entity(score).build();
		return Response.status(Status.NOT_FOUND).build();
		    
		
	}
	
	@POST
	@Path("/score/{id}")
	@Produces("text/plain")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getScoreByTestById (@PathParam (value="id") int onlineTestId, OnlineTest onlineTest) {
		
		int score = ots.calculatecorrectOnlineTest(onlineTestId, onlineTest);
		if (score >0)
		return Response.status(Status.OK).entity(score).build();
		return Response.status(Status.NOT_FOUND).build();
		    
		
	}
	
	
	
	@PUT
	@Path("{idTest}/{idQuestion}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response assignQuestToOnlineTest(@PathParam(value="idTest") int idTest,@PathParam(value="idQuestion") int idQuestion){
		
		if (ots.affecterQuestionToOnlineTest(idTest, idQuestion))
		return Response.status(Status.OK).entity("updated").build();
		return Response.status(Status.NOT_FOUND).entity("not found").build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListOfOnlineTest(){
		
		if (ots.getAllOnlineTestJPQLPerUser().size()>0)
		return Response.status(Status.OK).entity(ots.getAllOnlineTestJPQLPerUser()).build();
		return Response.status(Status.NOT_FOUND).build();

	}
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRDVById (@PathParam (value="id") int onlineTestId) {
		
		OnlineTest onlineTest = ots.getOnlineTestByIdPerUser(onlineTestId);
		
		if (onlineTest!=null)
		return Response.status(Status.OK).entity(onlineTest).build();
		return Response.status(Status.NOT_FOUND).build();
		    
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CreateOnlineTest(OnlineTest onlineTest){
		
		if (ots.createNewOnlineTestPerUser(onlineTest) > 0)
		return Response.status(Status.CREATED).type(MediaType.APPLICATION_JSON).entity("created").build();
		return Response.status(Status.NOT_ACCEPTABLE).entity("not acceptable").build();
	}
	
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteOnlineTest(@PathParam (value="id") int onlineTestId){
		
		if (ots.deleteOnlineTestByIdPerUser(onlineTestId) != null)
		return Response.status(Status.OK).entity("deleted").build();
		return Response.status(Status.NOT_FOUND).entity("not found").build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyOnlineTest(@PathParam (value="id") int onlineTestId, OnlineTest onlineTest){
		
		if (ots.updateOnlineTestPerUser(onlineTestId,onlineTest))
		return Response.status(Status.OK).entity("updated").build();
		return Response.status(Status.NOT_FOUND).entity("not found").build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
