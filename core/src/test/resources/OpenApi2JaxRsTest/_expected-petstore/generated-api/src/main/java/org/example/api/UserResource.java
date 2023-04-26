package org.example.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.example.api.beans.User;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/user")
public interface UserResource {
  /**
   *
   */
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
  @Path("/{username}")
  @PUT
  @Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})
  void updateUser(@PathParam("username") String username, User data);

  /**
   * <p>
   * This can only be done by the logged in user.
   * </p>
   *
   */
  @Path("/{username}")
  @DELETE
  void deleteUser(@PathParam("username") String username);
}