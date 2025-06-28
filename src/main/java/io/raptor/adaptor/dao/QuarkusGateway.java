package io.raptor.adaptor.dao;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/beta")
public class QuarkusGateway {
    /*** ---- members --- */
    private Logger logger = Logger.getLogger(QuarkusGateway.class);

    public QuarkusGateway() {
        super();
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "Hello from Quarkus REST.";
    }

}
