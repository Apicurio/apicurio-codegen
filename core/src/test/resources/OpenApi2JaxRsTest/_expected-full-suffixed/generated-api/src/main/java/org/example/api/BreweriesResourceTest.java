package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;
import java.util.Set;
import org.example.api.beans.BeerTest;
import org.example.api.beans.BreweryTest;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/breweries")
public interface BreweriesResourceTest {
  /**
   * <p>
   * Returns a list of all the breweries.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  Set<BreweryTest> listAllBreweries();

  /**
   * <p>
   * Adds a single brewery to the data set.
   * </p>
   * 
   */
  @POST
  @Consumes("application/json")
  void addBrewery(@NotNull BreweryTest data);

  /**
   * <p>
   * Returns full information about a single brewery.
   * </p>
   * 
   */
  @Path("/{breweryId}")
  @GET
  @Produces("application/json")
  BreweryTest getBrewery(@PathParam("breweryId") int breweryId);

  /**
   * <p>
   * Updates information about a single brewery.
   * </p>
   * 
   */
  @Path("/{breweryId}")
  @PUT
  @Consumes("application/json")
  void updateBrewery(@PathParam("breweryId") int breweryId, @NotNull BreweryTest data);

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
  List<BeerTest> listBreweryBeers(@PathParam("breweryId") int breweryId);

  /**
   * <p>
   * Adds a single beer to the data set for this brewery.
   * </p>
   * 
   */
  @Path("/{breweryId}/beers")
  @POST
  @Consumes("application/json")
  void addBeerToBrewery(@PathParam("breweryId") int breweryId, @NotNull BeerTest data);
}
