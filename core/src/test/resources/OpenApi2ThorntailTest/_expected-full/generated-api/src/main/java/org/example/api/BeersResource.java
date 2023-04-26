package org.example.api;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
  Beer getBeer(@PathParam("beerId") int beerId);

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
  List<Beer> listAllBeers();

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
