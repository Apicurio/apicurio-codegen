package org.example.api;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.math.BigInteger;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/installation")
public interface InstallationResource {
  /**
   * <p>
   * List repositories that an app installation can access.
   * </p>
   * <p>
   * You must use an <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-an-installation">installation
   * access token</a> to access this endpoint.
   * </p>
   * 
   */
  @Path("/repositories")
  @GET
  @Produces("application/json")
  Response apps_list_repos_accessible_to_installation(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Revokes the installation token you're using to authenticate as an
   * installation and access this endpoint.
   * </p>
   * <p>
   * Once an installation token is revoked, the token is invalidated and cannot be
   * used. Other endpoints that require the revoked installation token must have a
   * new installation token to work. You can create a new token using the
   * &quot;<a href=
   * "https://developer.github.com/v3/apps/#create-an-installation-access-token-for-an-app">Create
   * an installation access token for an app</a>&quot; endpoint.
   * </p>
   * <p>
   * You must use an <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-an-installation">installation
   * access token</a> to access this endpoint.
   * </p>
   * 
   */
  @Path("/token")
  @DELETE
  void apps_revoke_installation_access_token();
}
