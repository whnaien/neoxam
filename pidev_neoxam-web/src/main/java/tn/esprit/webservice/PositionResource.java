package tn.esprit.webservice;

import java.util.List;

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

import tn.esprit.entities.Position;
import tn.esprit.services.impl.PositionServiceImpl;

@Path("positions")
@LocalBean
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PositionResource {
	
	@EJB
	PositionServiceImpl positionServiceImpl;

	
	@GET
    public List<Position> getAllPositions() {
        return positionServiceImpl.allPositions();
    }
 
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Position addPosition(Position position) {
        return positionServiceImpl.savePosition(position);
 
    }
 
    @PUT
    @Path("/{sId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Position updatePosition(@PathParam("sId") int id, Position position) throws Exception {
        position.setId(id);
        return positionServiceImpl.updatePosition(position);
    }
 
    @DELETE
    @Path("/{sId}")
    public void deletePosition(@PathParam("sId") int id) throws Exception {
    	positionServiceImpl.deletePosition(id);
    }
 
    //http://localhost:8080/pidev_neoxam-web/rest/employees/2365
    @GET
    @Path("/{sId}")
    public Position getPosition(@PathParam("sId") int id) {
        return positionServiceImpl.singlePosition(id);
    }
    


}
