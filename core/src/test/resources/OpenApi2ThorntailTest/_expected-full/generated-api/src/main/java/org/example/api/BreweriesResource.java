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
import org.example.api.beans.Brewery;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/breweries")
public interface BreweriesResource {
  /**
   * <p>
   * Returns a list of all the breweries.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  List<Brewery> listAllBreweries();

  /**
   * <p>
   * Adds a single brewery to the data set.
   * </p>
   * 
   */
  @POST
  @Consumes("application/json")
  void addBrewery(Brewery data);

  /**
   * <p>
   * Returns full information about a single brewery.
   * </p>
   * 
   */
  @Path("/{breweryId}")
  @GET
  @Produces("application/json")
  Brewery getBrewery(@PathParam("breweryId") int breweryId);

  /**
   * <p>
   * Updates information about a single brewery.
   * </p>
   * 
   */
  @Path("/{breweryId}")
  @PUT
  @Consumes("application/json")
  void updateBrewery(@PathParam("breweryId") int breweryId, Brewery data);

  /**
   * <p>
   * Removes a single brewery from the data set.
   * </p>
   * 
   */
  @Path("/{breweryId}")
  @DELETE
  void deleteBrewery(@PathParam("breweryId") int breweryId);

  /**
   * <p>
   * Returns all of the beers made by the brewery.
   * </p>
   * 
   */
  @Path("/{breweryId}/beers")
  @GET
  @Produces("application/json")
  List<Beer> listBreweryBeers(@PathParam("breweryId") int breweryId);

  /**
   * <p>
   * Adds a single beer to the data set for this brewery.
   * </p>
   * 
   */
  @Path("/{breweryId}/beers")
  @POST
  @Consumes("application/json")
  void addBeerToBrewery(@PathParam("breweryId") int breweryId, Beer data);
}
