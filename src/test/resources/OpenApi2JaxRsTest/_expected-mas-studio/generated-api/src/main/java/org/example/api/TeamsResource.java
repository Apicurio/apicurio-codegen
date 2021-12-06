package org.example.api;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.example.api.beans.Team;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/apis/studio/v1/teams")
public interface TeamsResource {
  @GET
  @Produces("application/json")
  List<Team> listTeams();
}
