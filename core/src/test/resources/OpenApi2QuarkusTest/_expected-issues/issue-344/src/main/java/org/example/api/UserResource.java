package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.User;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/user")
public interface UserResource {
  /**
   * <p>
   * Accepts a user object and validates its fields like Bean Validation
   * </p>
   *
   */
  @Operation(description = "Accepts a user object and validates its fields like Bean Validation", summary = "Creates a new user.")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  User createsANewUser(@Valid @NotNull User data);
}