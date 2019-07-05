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

import tn.esprit.dao.IIndicatorCrud;

import tn.esprit.entities.Indicator;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;


@Path("indicators")
@LocalBean
@Stateless
public class IndicatorResource {

	@EJB
	IIndicatorCrud indicatorsDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return 
				Response.ok(indicatorsDao.getAllIndicators()).build();
	}
	
	
	@GET
	@Path("{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getindicatorByCode(@PathParam(value="code") String code) {
		return 
				Response.ok(indicatorsDao.getIndicatorByCode(code)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addIndicator(Indicator ind){
			return indicatorsDao.addIndicator(ind);
	}
	
	@DELETE
	@Path("{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteIndicator(@PathParam(value="code") String code) {
			
			indicatorsDao.deleteIndicator(code);;
			return "deleted with success";	
	}
	
	
}
