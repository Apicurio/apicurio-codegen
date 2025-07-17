package org.example.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.math.BigInteger;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.Pet;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/pets")
public interface PetsResource {
  @Operation(summary = "Add a new pet")
  @POST
  @Consumes("application/json")
  void addANewPet(@Valid @NotNull Pet data);

  @Operation(summary = "Update a pet")
  @Path("/{petId}")
  @PUT
  @Consumes("application/json")
  void updateAPet(@PathParam("petId") @Valid BigInteger petId, @Valid @NotNull Pet data);
}