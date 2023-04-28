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
import jakarta.ws.rs.QueryParam;
import java.io.InputStream;
import java.util.List;
import org.example.api.beans.Widget;
import org.example.api.beans.Widgetv1;
import org.example.api.beans.Widgetv2;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/widgets")
public interface WidgetsResource {
  /**
   * <p>
   * Gets a list of all <code>Widget</code> entities.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  List<Widget> getWidgets(@QueryParam("description") String description, @QueryParam("contentId") Long contentId);

  /**
   * <p>
   * Creates a new instance of a <code>Widget</code>.
   * </p>
   * 
   */
  @POST
  @Consumes("application/json+v2")
  void createWidget(@NotNull Widgetv2 data);

  /**
   * <p>
   * Creates a new instance of a <code>Widget</code>.
   * </p>
   * 
   */
  @POST
  @Consumes("application/json+v1")
  void createWidget(@NotNull Widgetv1 data);

  /**
   * <p>
   * Gets the details of a single instance of a <code>Widget</code>.
   * </p>
   * 
   */
  @Path("/{widgetId}")
  @GET
  @Produces("application/json")
  Widget getWidget(@PathParam("widgetId") String widgetId);

  /**
   * <p>
   * Updates an existing <code>Widget</code>.
   * </p>
   * 
   */
  @Path("/{widgetId}")
  @PUT
  @Consumes("application/json")
  void updateWidget(@PathParam("widgetId") String widgetId, @NotNull Widget data);

  /**
   * <p>
   * Updates an existing <code>Widget</code>.
   * </p>
   * 
   */
  @Path("/{widgetId}")
  @PUT
  @Consumes("*/*")
  void updateWidget(@PathParam("widgetId") String widgetId, @NotNull InputStream data);

  /**
   * <p>
   * Deletes an existing <code>Widget</code>.
   * </p>
   * 
   */
  @Path("/{widgetId}")
  @DELETE
  void deleteWidget(@PathParam("widgetId") String widgetId);
}
