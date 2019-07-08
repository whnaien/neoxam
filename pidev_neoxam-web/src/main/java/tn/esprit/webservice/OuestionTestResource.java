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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.dao.inter.EmployeDao;
import tn.esprit.entities.OnlineTest;
import tn.esprit.entities.Question;
import tn.esprit.service.impl.OnlineTestServiceImp;
import tn.esprit.service.inter.OnlineTestServiceRemote;
import tn.esprit.service.inter.QuestionServiceRemote;

@Path("question")
@LocalBean
@Stateless
public class OuestionTestResource {
	
	@EJB
	QuestionServiceRemote ots;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListOfQuestion(){
		
		if (ots.getAllQuestionJPQLPerUser().size()>0)
		return Response.status(Status.OK).entity(ots.getAllQuestionJPQLPerUser()).build();
		return Response.status(Status.NOT_FOUND).build();

	}
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionById (@PathParam (value="id") int questionId) {
		
		Question question = ots.getQuestionByIdPerUser(questionId);
		
		if (question!=null)
		return Response.status(Status.OK).entity(question).build();
		return Response.status(Status.NOT_FOUND).build();
		    
		
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CreateQuestion(Question question){
		
		if (ots.createNewQuestionPerUser(question) > 0)
		return Response.status(Status.CREATED).type(MediaType.APPLICATION_JSON).entity("created").build();
		return Response.status(Status.NOT_ACCEPTABLE).entity("not acceptable").build();
	}
	
	
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteQuestion(@PathParam (value="id") int questionId){
		
		if (ots.deleteQuestionByIdPerUser(questionId) != null)
		return Response.status(Status.OK).entity("deleted").build();
		return Response.status(Status.NOT_FOUND).entity("not found").build();
	}
	
	
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifyOnlineTest(@PathParam (value="id") int questionId, Question question){
		
		if (ots.updateQuestionPerUser(questionId, question))
		return Response.status(Status.OK).entity("updated").build();
		return Response.status(Status.NOT_FOUND).entity("not found").build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
