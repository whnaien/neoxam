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

import tn.esprit.dao.IIndicatorCrud;

import tn.esprit.entities.Indicator;
import tn.esprit.service.IndicatorService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;


@Path("indicator")
@Stateless
public class IndicatorResource {

	@EJB
	IndicatorService indicatorService;
	EntityManager em;
	
	//get All indicators
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return 
				Response.ok(indicatorService.getAllIndicators()).build();
	}
	
	//get indicator
	@GET
	@Path("{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getindicatorByCode(@PathParam(value="code") String code) {
		if (code == "")
			return  Response.status(Status.OK).entity(indicatorService.getAllIndicators()).build();
			else
			return  Response.status(Status.OK).entity(indicatorService.getIndicatorByCode(code)).build();
	}

	//add in indicator
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addIndicator(Indicator ind, @QueryParam ("code")String code) 
	{
		
		try {
			indicatorService.addIndicator(ind);
			return Response.status(Status.CREATED).build();
			
		} catch (Exception e) {
			return Response.status(Status.NOT_ACCEPTABLE).build();

		}
	}
	//delete an indicator
	@DELETE
	@Path("{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteIndicator(@PathParam(value="code") String code) {
			
			try{
				indicatorService.deleteIndicator(code);
				return Response.status(Status.OK).build();
			}
			catch (Exception e) {
				return Response.status(Status.NOT_FOUND).build();
			}
	}
	//update an indicator
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRisk( Indicator indicator)
	{
		try{
			indicatorService.updateIndicator(indicator);
			return Response.status(Status.OK).build();
		}
		catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
