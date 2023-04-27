package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.io.InputStream;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/applications")
public interface ApplicationsResource {
  /**
   * <p>
   * <strong>Deprecation Notice:</strong> GitHub will discontinue the
   * <a href="https://developer.github.com/v3/oauth_authorizations/">OAuth
   * Authorizations API</a>, which is used by integrations to create personal
   * access tokens and OAuth tokens, and you must now create these tokens using
   * our <a href=
   * "https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow">web
   * application flow</a>. The
   * <a href="https://developer.github.com/v3/oauth_authorizations/">OAuth
   * Authorizations API</a> will be removed on November, 13, 2020. For more
   * information, including scheduled brownouts, see the <a href=
   * "https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/">blog
   * post</a>.
   * </p>
   * <p>
   * You can use this API to list the set of OAuth applications that have been
   * granted access to your account. Unlike the <a href=
   * "https://developer.github.com/v3/oauth_authorizations/#list-your-authorizations">list
   * your authorizations</a> API, this API does not manage individual tokens. This
   * API will return one entry for each OAuth application that has been granted
   * access to your account, regardless of the number of tokens an application has
   * generated for your user. The list of OAuth applications returned matches what
   * is shown on <a href="https://github.com/settings/applications#authorized">the
   * application authorizations settings screen within GitHub</a>. The
   * <code>scopes</code> returned are the union of scopes authorized for the
   * application. For example, if an application has one token with
   * <code>repo</code> scope and another token with <code>user</code> scope, the
   * grant will return <code>[&quot;repo&quot;, &quot;user&quot;]</code>.
   * </p>
   * 
   */
  @Path("/grants")
  @GET
  @Produces("application/json")
  Response oauth_authorizations_list_grants(@QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> GitHub will discontinue the
   * <a href="https://developer.github.com/v3/oauth_authorizations/">OAuth
   * Authorizations API</a>, which is used by integrations to create personal
   * access tokens and OAuth tokens, and you must now create these tokens using
   * our <a href=
   * "https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow">web
   * application flow</a>. The
   * <a href="https://developer.github.com/v3/oauth_authorizations/">OAuth
   * Authorizations API</a> will be removed on November, 13, 2020. For more
   * information, including scheduled brownouts, see the <a href=
   * "https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/">blog
   * post</a>.
   * </p>
   * 
   */
  @Path("/grants/{grant_id}")
  @GET
  @Produces("application/json")
  Response oauth_authorizations_get_grant(@PathParam("grant_id") Integer grantId);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> GitHub will discontinue the
   * <a href="https://developer.github.com/v3/oauth_authorizations/">OAuth
   * Authorizations API</a>, which is used by integrations to create personal
   * access tokens and OAuth tokens, and you must now create these tokens using
   * our <a href=
   * "https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow">web
   * application flow</a>. The
   * <a href="https://developer.github.com/v3/oauth_authorizations/">OAuth
   * Authorizations API</a> will be removed on November, 13, 2020. For more
   * information, including scheduled brownouts, see the <a href=
   * "https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/">blog
   * post</a>.
   * </p>
   * <p>
   * Deleting an OAuth application's grant will also delete all OAuth tokens
   * associated with the application for your user. Once deleted, the application
   * has no access to your account and is no longer listed on
   * <a href="https://github.com/settings/applications#authorized">the application
   * authorizations settings screen within GitHub</a>.
   * </p>
   * 
   */
  @Path("/grants/{grant_id}")
  @DELETE
  void oauth_authorizations_delete_grant(@PathParam("grant_id") Integer grantId);

  /**
   * <p>
   * OAuth applications can use a special API method for checking OAuth token
   * validity without exceeding the normal rate limits for failed login attempts.
   * Authentication works differently with this particular endpoint. You must use
   * <a href="https://developer.github.com/v3/auth#basic-authentication">Basic
   * Authentication</a> to use this endpoint, where the username is the OAuth
   * application <code>client_id</code> and the password is its
   * <code>client_secret</code>. Invalid tokens will return
   * <code>404 NOT FOUND</code>.
   * </p>
   * 
   */
  @Path("/{client_id}/token")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response apps_check_token(@PathParam("client_id") String clientId, @NotNull InputStream data);

  /**
   * <p>
   * OAuth application owners can revoke a single token for an OAuth application.
   * You must use
   * <a href="https://developer.github.com/v3/auth#basic-authentication">Basic
   * Authentication</a> when accessing this endpoint, using the OAuth
   * application's <code>client_id</code> and <code>client_secret</code> as the
   * username and password.
   * </p>
   * 
   */
  @Path("/{client_id}/token")
  @DELETE
  @Consumes("application/json")
  void apps_delete_token(@PathParam("client_id") String clientId, @NotNull InputStream data);

  /**
   * <p>
   * OAuth applications can use this API method to reset a valid OAuth token
   * without end-user involvement. Applications must save the &quot;token&quot;
   * property in the response because changes take effect immediately. You must
   * use <a href="https://developer.github.com/v3/auth#basic-authentication">Basic
   * Authentication</a> when accessing this endpoint, using the OAuth
   * application's <code>client_id</code> and <code>client_secret</code> as the
   * username and password. Invalid tokens will return <code>404 NOT FOUND</code>.
   * </p>
   * 
   */
  @Path("/{client_id}/token")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response apps_reset_token(@PathParam("client_id") String clientId, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> GitHub will replace and discontinue
   * OAuth endpoints containing <code>access_token</code> in the path parameter.
   * We are introducing new endpoints that allow you to securely manage tokens for
   * OAuth Apps by using <code>access_token</code> as an input parameter. The
   * OAuth Application API will be removed on May 5, 2021. For more information,
   * including scheduled brownouts, see the <a href=
   * "https://developer.github.com/changes/2020-02-14-deprecating-oauth-app-endpoint/">blog
   * post</a>.
   * </p>
   * <p>
   * OAuth application owners can revoke a grant for their OAuth application and a
   * specific user. You must use
   * <a href="https://developer.github.com/v3/auth#basic-authentication">Basic
   * Authentication</a> when accessing this endpoint, using the OAuth
   * application's <code>client_id</code> and <code>client_secret</code> as the
   * username and password. You must also provide a valid token as
   * <code>:access_token</code> and the grant for the token's owner will be
   * deleted.
   * </p>
   * <p>
   * Deleting an OAuth application's grant will also delete all OAuth tokens
   * associated with the application for the user. Once deleted, the application
   * will have no access to the user's account and will no longer be listed on
   * <a href="https://github.com/settings/applications#authorized">the
   * Applications settings page under &quot;Authorized OAuth Apps&quot; on
   * GitHub</a>.
   * </p>
   * 
   */
  @Path("/{client_id}/grants/{access_token}")
  @DELETE
  void apps_revoke_grant_for_application(@PathParam("client_id") String clientId,
      @PathParam("access_token") String accessToken);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> GitHub will replace and discontinue
   * OAuth endpoints containing <code>access_token</code> in the path parameter.
   * We are introducing new endpoints that allow you to securely manage tokens for
   * OAuth Apps by using <code>access_token</code> as an input parameter. The
   * OAuth Application API will be removed on May 5, 2021. For more information,
   * including scheduled brownouts, see the <a href=
   * "https://developer.github.com/changes/2020-02-14-deprecating-oauth-app-endpoint/">blog
   * post</a>.
   * </p>
   * <p>
   * OAuth applications can use a special API method for checking OAuth token
   * validity without exceeding the normal rate limits for failed login attempts.
   * Authentication works differently with this particular endpoint. You must use
   * <a href="https://developer.github.com/v3/auth#basic-authentication">Basic
   * Authentication</a> when accessing this endpoint, using the OAuth
   * application's <code>client_id</code> and <code>client_secret</code> as the
   * username and password. Invalid tokens will return <code>404 NOT FOUND</code>.
   * </p>
   * 
   */
  @Path("/{client_id}/tokens/{access_token}")
  @GET
  @Produces("application/json")
  Response apps_check_authorization(@PathParam("client_id") String clientId,
      @PathParam("access_token") String accessToken);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> GitHub will replace and discontinue
   * OAuth endpoints containing <code>access_token</code> in the path parameter.
   * We are introducing new endpoints that allow you to securely manage tokens for
   * OAuth Apps by using <code>access_token</code> as an input parameter. The
   * OAuth Application API will be removed on May 5, 2021. For more information,
   * including scheduled brownouts, see the <a href=
   * "https://developer.github.com/changes/2020-02-14-deprecating-oauth-app-endpoint/">blog
   * post</a>.
   * </p>
   * <p>
   * OAuth applications can use this API method to reset a valid OAuth token
   * without end-user involvement. Applications must save the &quot;token&quot;
   * property in the response because changes take effect immediately. You must
   * use <a href="https://developer.github.com/v3/auth#basic-authentication">Basic
   * Authentication</a> when accessing this endpoint, using the OAuth
   * application's <code>client_id</code> and <code>client_secret</code> as the
   * username and password. Invalid tokens will return <code>404 NOT FOUND</code>.
   * </p>
   * 
   */
  @Path("/{client_id}/tokens/{access_token}")
  @POST
  @Produces("application/json")
  Response apps_reset_authorization(@PathParam("client_id") String clientId,
      @PathParam("access_token") String accessToken);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> GitHub will replace and discontinue
   * OAuth endpoints containing <code>access_token</code> in the path parameter.
   * We are introducing new endpoints that allow you to securely manage tokens for
   * OAuth Apps by using <code>access_token</code> as an input parameter. The
   * OAuth Application API will be removed on May 5, 2021. For more information,
   * including scheduled brownouts, see the <a href=
   * "https://developer.github.com/changes/2020-02-14-deprecating-oauth-app-endpoint/">blog
   * post</a>.
   * </p>
   * <p>
   * OAuth application owners can revoke a single token for an OAuth application.
   * You must use
   * <a href="https://developer.github.com/v3/auth#basic-authentication">Basic
   * Authentication</a> when accessing this endpoint, using the OAuth
   * application's <code>client_id</code> and <code>client_secret</code> as the
   * username and password.
   * </p>
   * 
   */
  @Path("/{client_id}/tokens/{access_token}")
  @DELETE
  void apps_revoke_authorization_for_application(@PathParam("client_id") String clientId,
      @PathParam("access_token") String accessToken);

  /**
   * <p>
   * OAuth application owners can revoke a grant for their OAuth application and a
   * specific user. You must use
   * <a href="https://developer.github.com/v3/auth#basic-authentication">Basic
   * Authentication</a> when accessing this endpoint, using the OAuth
   * application's <code>client_id</code> and <code>client_secret</code> as the
   * username and password. You must also provide a valid OAuth
   * <code>access_token</code> as an input parameter and the grant for the token's
   * owner will be deleted. Deleting an OAuth application's grant will also delete
   * all OAuth tokens associated with the application for the user. Once deleted,
   * the application will have no access to the user's account and will no longer
   * be listed on
   * <a href="https://github.com/settings/applications#authorized">the application
   * authorizations settings screen within GitHub</a>.
   * </p>
   * 
   */
  @Path("/{client_id}/grant")
  @DELETE
  @Consumes("application/json")
  void apps_delete_authorization(@PathParam("client_id") String clientId, @NotNull InputStream data);
}
