package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.io.InputStream;
import java.math.BigInteger;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/app")
public interface AppResource {
  /**
   * <p>
   * <strong>Note:</strong> Suspending a GitHub App installation is currently in
   * beta and subject to change. Before you can suspend a GitHub App, the app
   * owner must enable suspending installations for the app by opting-in to the
   * beta. For more information, see &quot;<a href=
   * "https://developer.github.com/apps/managing-github-apps/suspending-a-github-app-installation/">Suspending
   * a GitHub App installation</a>.&quot;
   * </p>
   * <p>
   * Suspends a GitHub App on a user, organization, or business account, which
   * blocks the app from accessing the account's resources. When a GitHub App is
   * suspended, the app's access to the GitHub API or webhook events is blocked
   * for that account.
   * </p>
   * <p>
   * To suspend a GitHub App, you must be an account owner or have admin
   * permissions in the repository or organization where the app is installed.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint.
   * </p>
   *
   */
  @Operation(description = "**Note:** Suspending a GitHub App installation is currently in beta and subject to change. Before you can suspend a GitHub App, the app owner must enable suspending installations for the app by opting-in to the beta. For more information, see \"[Suspending a GitHub App installation](https://developer.github.com/apps/managing-github-apps/suspending-a-github-app-installation/).\"\n\nSuspends a GitHub App on a user, organization, or business account, which blocks the app from accessing the account's resources. When a GitHub App is suspended, the app's access to the GitHub API or webhook events is blocked for that account.\n\nTo suspend a GitHub App, you must be an account owner or have admin permissions in the repository or organization where the app is installed.\n\nYou must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint.", summary = "Suspend an app installation", operationId = "apps/suspend-installation")
  @Path("/installations/{installation_id}/suspended")
  @PUT
  void apps_suspend_installation(@PathParam("installation_id") BigInteger installationId);

  /**
   * <p>
   * <strong>Note:</strong> Suspending a GitHub App installation is currently in
   * beta and subject to change. Before you can suspend a GitHub App, the app
   * owner must enable suspending installations for the app by opting-in to the
   * beta. For more information, see &quot;<a href=
   * "https://developer.github.com/apps/managing-github-apps/suspending-a-github-app-installation/">Suspending
   * a GitHub App installation</a>.&quot;
   * </p>
   * <p>
   * Removes a GitHub App installation suspension.
   * </p>
   * <p>
   * To unsuspend a GitHub App, you must be an account owner or have admin
   * permissions in the repository or organization where the app is installed and
   * suspended.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint.
   * </p>
   *
   */
  @Operation(description = "**Note:** Suspending a GitHub App installation is currently in beta and subject to change. Before you can suspend a GitHub App, the app owner must enable suspending installations for the app by opting-in to the beta. For more information, see \"[Suspending a GitHub App installation](https://developer.github.com/apps/managing-github-apps/suspending-a-github-app-installation/).\"\n\nRemoves a GitHub App installation suspension.\n\nTo unsuspend a GitHub App, you must be an account owner or have admin permissions in the repository or organization where the app is installed and suspended.\n\nYou must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint.", summary = "Unsuspend an app installation", operationId = "apps/unsuspend-installation")
  @Path("/installations/{installation_id}/suspended")
  @DELETE
  void apps_unsuspend_installation(@PathParam("installation_id") BigInteger installationId);

  /**
   * <p>
   * Creates an installation access token that enables a GitHub App to make
   * authenticated API requests for the app's installation on an organization or
   * individual account. Installation tokens expire one hour from the time you
   * create them. Using an expired token produces a status code of
   * <code>401 - Unauthorized</code>, and requires creating a new installation
   * token. By default the installation token has access to all repositories that
   * the installation can access. To restrict the access to specific repositories,
   * you can provide the <code>repository_ids</code> when creating the token. When
   * you omit <code>repository_ids</code>, the response does not contain the
   * <code>repositories</code> key.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint.
   * </p>
   *
   */
  @Operation(description = "Creates an installation access token that enables a GitHub App to make authenticated API requests for the app's installation on an organization or individual account. Installation tokens expire one hour from the time you create them. Using an expired token produces a status code of `401 - Unauthorized`, and requires creating a new installation token. By default the installation token has access to all repositories that the installation can access. To restrict the access to specific repositories, you can provide the `repository_ids` when creating the token. When you omit `repository_ids`, the response does not contain the `repositories` key.\n\nYou must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint.", summary = "Create an installation access token for an app", operationId = "apps/create-installation-access-token")
  @Path("/installations/{installation_id}/access_tokens")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response apps_create_installation_access_token(@PathParam("installation_id") BigInteger installationId,
      @NotNull InputStream data);

  /**
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint.
   * </p>
   * <p>
   * The permissions the installation has are included under the
   * <code>permissions</code> key.
   * </p>
   *
   */
  @Operation(description = "You must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint.\n\nThe permissions the installation has are included under the `permissions` key.", summary = "List installations for the authenticated app", operationId = "apps/list-installations")
  @Path("/installations")
  @GET
  @Produces("application/json")
  Response apps_list_installations(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page, @QueryParam("since") String since,
      @QueryParam("outdated") String outdated);

  /**
   * <p>
   * Use this endpoint to complete the handshake necessary when implementing the
   * <a href=
   * "https://developer.github.com/apps/building-github-apps/creating-github-apps-from-a-manifest/">GitHub
   * App Manifest flow</a>. When you create a GitHub App with the manifest flow,
   * you receive a temporary <code>code</code> used to retrieve the GitHub App's
   * <code>id</code>, <code>pem</code> (private key), and
   * <code>webhook_secret</code>.
   * </p>
   *
   */
  @Operation(description = "Use this endpoint to complete the handshake necessary when implementing the [GitHub App Manifest flow](https://developer.github.com/apps/building-github-apps/creating-github-apps-from-a-manifest/). When you create a GitHub App with the manifest flow, you receive a temporary `code` used to retrieve the GitHub App's `id`, `pem` (private key), and `webhook_secret`.", summary = "Create a GitHub App from a manifest", operationId = "apps/create-from-manifest")
  @Path("-manifests/{code}/conversions")
  @POST
  @Produces("application/json")
  Response apps_create_from_manifest(@PathParam("code") String code);

  /**
   * <p>
   * Returns the GitHub App associated with the authentication credentials used.
   * To see how many app installations are associated with this GitHub App, see
   * the <code>installations_count</code> in the response. For more details about
   * your app's installations, see the &quot;<a href=
   * "https://developer.github.com/v3/apps/#list-installations-for-the-authenticated-app">List
   * installations for the authenticated app</a>&quot; endpoint.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint.
   * </p>
   *
   */
  @Operation(description = "Returns the GitHub App associated with the authentication credentials used. To see how many app installations are associated with this GitHub App, see the `installations_count` in the response. For more details about your app's installations, see the \"[List installations for the authenticated app](https://developer.github.com/v3/apps/#list-installations-for-the-authenticated-app)\" endpoint.\n\nYou must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint.", summary = "Get the authenticated app", operationId = "apps/get-authenticated")
  @GET
  @Produces("application/json")
  Response apps_get_authenticated();

  /**
   * <p>
   * Enables an authenticated GitHub App to find an installation's information
   * using the installation id. The installation's account type
   * (<code>target_type</code>) will be either an organization or a user account,
   * depending which account the repository belongs to.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint.
   * </p>
   *
   */
  @Operation(description = "Enables an authenticated GitHub App to find an installation's information using the installation id. The installation's account type (`target_type`) will be either an organization or a user account, depending which account the repository belongs to.\n\nYou must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint.", summary = "Get an installation for the authenticated app", operationId = "apps/get-installation")
  @Path("/installations/{installation_id}")
  @GET
  @Produces("application/json")
  Response apps_get_installation(@PathParam("installation_id") BigInteger installationId);

  /**
   * <p>
   * Uninstalls a GitHub App on a user, organization, or business account. If you
   * prefer to temporarily suspend an app's access to your account's resources,
   * then we recommend the &quot;<a href=
   * "https://developer.github.com/v3/apps/#suspend-an-app-installation">Suspend
   * an app installation</a>&quot; endpoint.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint.
   * </p>
   *
   */
  @Operation(description = "Uninstalls a GitHub App on a user, organization, or business account. If you prefer to temporarily suspend an app's access to your account's resources, then we recommend the \"[Suspend an app installation](https://developer.github.com/v3/apps/#suspend-an-app-installation)\" endpoint.\n\nYou must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint.", summary = "Delete an installation for the authenticated app", operationId = "apps/delete-installation")
  @Path("/installations/{installation_id}")
  @DELETE
  void apps_delete_installation(@PathParam("installation_id") BigInteger installationId);
}
