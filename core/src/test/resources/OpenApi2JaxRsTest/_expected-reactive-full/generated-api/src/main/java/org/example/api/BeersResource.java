package org.example.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;
import java.util.concurrent.CompletionStage;
import org.example.api.beans.Beer;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/beers")
public interface BeersResource {
  /**
   * Returns full information about a single beer.
   */
  @Path("/{beerId}")
  @GET
  @Produces("application/json")
  CompletionStage<Beer> getBeer(@PathParam("beerId") int beerId);

  /**
   * Updates information about a single beer.
   */
  @Path("/{beerId}")
  @PUT
  @Consumes("application/json")
  void updateBeer(@PathParam("beerId") int beerId, Beer data);

  /**
   * Removes a single beer from the data set.
   */
  @Path("/{beerId}")
  @DELETE
  void deleteBeer(@PathParam("beerId") int beerId);

  /**
   * Returns all of the beers in the database.
   */
  @GET
  @Produces("application/json")
  CompletionStage<List<Beer>> listAllBeers();

  /**
   * Adds a single beer to the dataset.
   */
  @POST
  @Consumes("application/json")
  void addBeer(Beer data);
}
