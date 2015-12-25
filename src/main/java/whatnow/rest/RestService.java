package whatnow.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import whatnow.rest.dto.Activity;

@Path("whatnow")
public class RestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.status(Status.OK).entity(new Activity("Finish this app")).build();
    }


}
