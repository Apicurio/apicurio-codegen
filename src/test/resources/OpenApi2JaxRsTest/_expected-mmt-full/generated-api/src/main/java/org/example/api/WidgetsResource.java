package org.example.api;

import java.io.InputStream;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.example.api.beans.Widget;
import org.example.api.beans.Widgetv1;
import org.example.api.beans.Widgetv2;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/widgets")
public interface WidgetsResource {
  /**
   * Gets a list of all `Widget` entities.
   */
  @GET
  @Produces("application/json")
  List<Widget> getWidgets();

  /**
   * Creates a new instance of a `Widget`.
   */
  @POST
  @Consumes("application/json+v1")
  void createWidget(Widgetv1 data);

  /**
   * Creates a new instance of a `Widget`.
   */
  @POST
  @Consumes("application/json+v2")
  void createWidget(Widgetv2 data);

  /**
   * Gets the details of a single instance of a `Widget`.
   */
  @Path("/{widgetId}")
  @GET
  @Produces("application/json")
  Widget getWidget(@PathParam("widgetId") String widgetId);

  /**
   * Updates an existing `Widget`.
   */
  @Path("/{widgetId}")
  @PUT
  @Consumes("application/json")
  void updateWidget(@PathParam("widgetId") String widgetId, Widget data);

  /**
   * Updates an existing `Widget`.
   */
  @Path("/{widgetId}")
  @PUT
  @Consumes("*/*")
  void updateWidget(@PathParam("widgetId") String widgetId, InputStream data);

  /**
   * Deletes an existing `Widget`.
   */
  @Path("/{widgetId}")
  @DELETE
  void deleteWidget(@PathParam("widgetId") String widgetId);
}
