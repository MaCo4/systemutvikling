package services;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Path("/kunder/")
public class KundeService {
	private static Map<String,Kunde> kunder = new HashMap<>();

    @GET
    @Path("/{kundeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kunde getKunde(@PathParam("kundeId") String kundeId) {
        if (!kunder.containsKey(kundeId)) {
            throw new NotFoundException();
        }
        return kunder.get(kundeId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Kunde> getKunder() {
        return kunder.values();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addKunde(Kunde kunde) {
        if (kunder.containsKey(kunde.getId())) {
            throw new ClientErrorException(Response.Status.CONFLICT);
        }

        kunder.put(kunde.getId(), kunde);
    }

    @DELETE
    @Path("/{kundeId}")
    public void deleteKunde(@PathParam("kundeId") String kundeId) {
        kunder.remove(kundeId);
    }

    @PUT
    @Path("/{kundeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateKunde(Kunde kunde, @PathParam("kundeId") String kundeId) {
        if (!kunder.containsKey(kundeId)) {
            throw new NotFoundException();
        }

        kunder.put(kunde.getId(), kunde);
    }
}
