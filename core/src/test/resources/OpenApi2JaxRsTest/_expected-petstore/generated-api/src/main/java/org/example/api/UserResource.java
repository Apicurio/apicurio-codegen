package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.User;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/user")
public interface UserResource {
  /**
   *
   */
  @Operation(description = "", summary = "Get user by user name", operationId = "getUserByName")
  @Path("/{username}")
  @GET
  @Produces({"application/xml", "application/json"})
  User getUserByName(@PathParam("username") String username);

  /**
   * <p>
   * This can only be done by the logged in user.
   * </p>
   *
   */
  @Operation(description = "This can only be done by the logged in user.", summary = "Update user", operationId = "updateUser")
  @Path("/{username}")
  @PUT
  @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
  void updateUser(@PathParam("username") String username, @NotNull User data);

  /**
   * <p>
   * This can only be done by the logged in user.
   * </p>
   *
   */
  @Operation(description = "This can only be done by the logged in user.", summary = "Delete user", operationId = "deleteUser")
  @Path("/{username}")
  @DELETE
  void deleteUser(@PathParam("username") String username);
}
