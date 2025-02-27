package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.Team;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/apis/studio/v1/teams")
public interface TeamsResource {
  @Operation(summary = "List teams", operationId = "listTeams")
  @GET
  @Produces("application/json")
  List<Team> listTeams();
}
