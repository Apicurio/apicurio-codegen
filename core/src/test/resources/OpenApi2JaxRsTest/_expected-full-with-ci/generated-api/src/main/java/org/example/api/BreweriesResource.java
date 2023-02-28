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
import org.example.api.beans.Beer;
import org.example.api.beans.Brewery;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/breweries")
public interface BreweriesResource {
  /**
   * Returns a list of all the breweries.
   */
  @GET
  @Produces("application/json")
  List<Brewery> listAllBreweries();

  /**
   * Adds a single brewery to the data set.
   */
  @POST
  @Consumes("application/json")
  void addBrewery(Brewery data);

  /**
   * Returns full information about a single brewery.
   */
  @Path("/{breweryId}")
  @GET
  @Produces("application/json")
  Brewery getBrewery(@PathParam("breweryId") int breweryId);

  /**
   * Updates information about a single brewery.
   */
  @Path("/{breweryId}")
  @PUT
  @Consumes("application/json")
  void updateBrewery(@PathParam("breweryId") int breweryId, Brewery data);

  /**
   * Removes a single brewery from the data set.
   */
  @Path("/{breweryId}")
  @DELETE
  void deleteBrewery(@PathParam("breweryId") int breweryId);

  /**
   * Returns all of the beers made by the brewery.
   */
  @Path("/{breweryId}/beers")
  @GET
  @Produces("application/json")
  List<Beer> listBreweryBeers(@PathParam("breweryId") int breweryId);

  /**
   * Adds a single beer to the data set for this brewery.
   */
  @Path("/{breweryId}/beers")
  @POST
  @Consumes("application/json")
  void addBeerToBrewery(@PathParam("breweryId") int breweryId, Beer data);
}
