/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RS;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Ulises
 */
@Path("generic")
public class Rest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Rest
     */
    public Rest() {
    }

    /**
     * Retrieves representation of an instance of RS.Rest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Rest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
    @GET
    @Path("/contertirDivisa/moneda={moneda}&cantidad={cantidad}")
    @Produces(MediaType.TEXT_PLAIN)
    public String convertirDivisa(@PathParam("moneda")String moneda, @PathParam("cantidad") String cantidad){
        Double valor = new Double(cantidad == null || cantidad.isEmpty() ? "0.0" : cantidad);
        System.out.println(cantidad);
        switch (moneda) {
            case "USD":
                valor *= 0.05379;
                break;
            case "EUR":
                valor *= 0.0506699;
                break;
            case "GBP":
                valor *= 0.0430231;
                break;
            case "AUD":
                valor *= 0.0711007;
                break;
            case "CAD":
                valor *= 0.0717013;
                break;
            default:
                break;
        }
        return valor.toString();
    }
}
