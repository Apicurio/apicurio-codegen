package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.TestObject;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/test")
public interface TestResource {
  @Operation(summary = "Test endpoint", operationId = "getTest")
  @GET
  @Produces("application/json")
  TestObject getTest();
}