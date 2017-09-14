package services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Magnus on 13.09.2017.
 *
 * @author Magnus Conrad Hyll (magnus@hyll.no)
 */
@Path("/msg")
public class MessageService {

    private static String msg;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void changeMessage(String newMsg) {
        System.out.println("Received message: " + newMsg);
        msg = newMsg;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return msg;
    }
}
