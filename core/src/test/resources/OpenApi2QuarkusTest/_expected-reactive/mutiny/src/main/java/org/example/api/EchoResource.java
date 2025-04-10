package org.example.api;

import io.smallrye.mutiny.Uni;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/echo")
public interface EchoResource {
  /**
   * <p>
   * sample endpoint with parameter
   * </p>
   *
   */
  @Operation(description = "sample endpoint with parameter", summary = "echos the given parameter string.")
  @GET
  @Produces("text/plain")
  Uni<String> echosTheGivenParameterString(@QueryParam("source") @NotNull String source);
}