package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/widgets")
public interface WidgetsResource {
  @Operation(summary = "Get widgets", operationId = "getWidgets")
  @Path("/{widgetId}")
  @GET
  @Produces("application/json")
  Response getWidgets(@PathParam("widgetId") String widgetId);
}