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
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/beers")
public interface BeersResource {
  /**
   * <p>
   * Returns full information about a single beer.
   * </p>
   * 
   */
  @Path("/{beerId}")
  @GET
  @Produces("application/json")
  CompletionStage<Beer> getBeer(@PathParam("beerId") int beerId);

  /**
   * <p>
   * Updates information about a single beer.
   * </p>
   * 
   */
  @Path("/{beerId}")
  @PUT
  @Consumes("application/json")
  void updateBeer(@PathParam("beerId") int beerId, Beer data);

  /**
   * <p>
   * Removes a single beer from the data set.
   * </p>
   * 
   */
  @Path("/{beerId}")
  @DELETE
  void deleteBeer(@PathParam("beerId") int beerId);

  /**
   * <p>
   * Returns all of the beers in the database.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  CompletionStage<List<Beer>> listAllBeers();

  /**
   * <p>
   * Adds a single beer to the dataset.
   * </p>
   * 
   */
  @POST
  @Consumes("application/json")
  void addBeer(Beer data);
}
