package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/apps")
public interface AppsResource {
  /**
   * <p>
   * <strong>Note</strong>: The <code>:app_slug</code> is just the URL-friendly
   * name of your GitHub App. You can find this on the settings page for your
   * GitHub App (e.g., <code>https://github.com/settings/apps/:app_slug</code>).
   * </p>
   * <p>
   * If the GitHub App you specify is public, you can access this endpoint without
   * authenticating. If the GitHub App you specify is private, you must
   * authenticate with a <a href=
   * "https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/">personal
   * access token</a> or an <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-an-installation">installation
   * access token</a> to access this endpoint.
   * </p>
   * 
   */
  @Path("/{app_slug}")
  @GET
  @Produces("application/json")
  Response apps_get_by_slug(@PathParam("app_slug") String appSlug);
}
