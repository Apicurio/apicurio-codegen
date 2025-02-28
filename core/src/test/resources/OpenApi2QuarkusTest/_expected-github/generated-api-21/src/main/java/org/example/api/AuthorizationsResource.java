package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
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
@Path("/authorizations")
public interface AuthorizationsResource {
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
  @Operation(description = "**Deprecation Notice:** GitHub will discontinue the [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/), which is used by integrations to create personal access tokens and OAuth tokens, and you must now create these tokens using our [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow). The [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/) will be removed on November, 13, 2020. For more information, including scheduled brownouts, see the [blog post](https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/).", summary = "List your authorizations", operationId = "oauth-authorizations/list-authorizations")
  @GET
  @Produces("application/json")
  Response oauth_authorizations_list_authorizations(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
   * <strong>Warning:</strong> Apps must use the <a href=
   * "https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow">web
   * application flow</a> to obtain OAuth tokens that work with GitHub SAML
   * organizations. OAuth tokens created using the Authorizations API will be
   * unable to access GitHub SAML organizations. For more information, see the
   * <a href=
   * "https://developer.github.com/changes/2019-11-05-deprecated-passwords-and-authorizations-api">blog
   * post</a>.
   * </p>
   * <p>
   * Creates OAuth tokens using
   * <a href="https://developer.github.com/v3/auth#basic-authentication">Basic
   * Authentication</a>. If you have two-factor authentication setup, Basic
   * Authentication for this endpoint requires that you use a one-time password
   * (OTP) and your username and password instead of tokens. For more information,
   * see &quot;<a href=
   * "https://developer.github.com/v3/auth/#working-with-two-factor-authentication">Working
   * with two-factor authentication</a>.&quot;
   * </p>
   * <p>
   * To create tokens for a particular OAuth application using this endpoint, you
   * must authenticate as the user you want to create an authorization for and
   * provide the app's client ID and secret, found on your OAuth application's
   * settings page. If your OAuth application intends to create multiple tokens
   * for one user, use <code>fingerprint</code> to differentiate between them.
   * </p>
   * <p>
   * You can also create tokens on GitHub from the
   * <a href="https://github.com/settings/tokens">personal access tokens
   * settings</a> page. Read more about these tokens in <a href=
   * "https://help.github.com/articles/creating-an-access-token-for-command-line-use">the
   * GitHub Help documentation</a>.
   * </p>
   * <p>
   * Organizations that enforce SAML SSO require personal access tokens to be
   * allowed. Read more about allowing tokens in <a href=
   * "https://help.github.com/articles/about-identity-and-access-management-with-saml-single-sign-on">the
   * GitHub Help documentation</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** GitHub will discontinue the [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/), which is used by integrations to create personal access tokens and OAuth tokens, and you must now create these tokens using our [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow). The [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/) will be removed on November, 13, 2020. For more information, including scheduled brownouts, see the [blog post](https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/).\n\n**Warning:** Apps must use the [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow) to obtain OAuth tokens that work with GitHub SAML organizations. OAuth tokens created using the Authorizations API will be unable to access GitHub SAML organizations. For more information, see the [blog post](https://developer.github.com/changes/2019-11-05-deprecated-passwords-and-authorizations-api).\n\nCreates OAuth tokens using [Basic Authentication](https://developer.github.com/v3/auth#basic-authentication). If you have two-factor authentication setup, Basic Authentication for this endpoint requires that you use a one-time password (OTP) and your username and password instead of tokens. For more information, see \"[Working with two-factor authentication](https://developer.github.com/v3/auth/#working-with-two-factor-authentication).\"\n\nTo create tokens for a particular OAuth application using this endpoint, you must authenticate as the user you want to create an authorization for and provide the app's client ID and secret, found on your OAuth application's settings page. If your OAuth application intends to create multiple tokens for one user, use `fingerprint` to differentiate between them.\n\nYou can also create tokens on GitHub from the [personal access tokens settings](https://github.com/settings/tokens) page. Read more about these tokens in [the GitHub Help documentation](https://help.github.com/articles/creating-an-access-token-for-command-line-use).\n\nOrganizations that enforce SAML SSO require personal access tokens to be allowed. Read more about allowing tokens in [the GitHub Help documentation](https://help.github.com/articles/about-identity-and-access-management-with-saml-single-sign-on).", summary = "Create a new authorization", operationId = "oauth-authorizations/create-authorization")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response oauth_authorizations_create_authorization(@NotNull InputStream data);

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
   * <strong>Warning:</strong> Apps must use the <a href=
   * "https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow">web
   * application flow</a> to obtain OAuth tokens that work with GitHub SAML
   * organizations. OAuth tokens created using the Authorizations API will be
   * unable to access GitHub SAML organizations. For more information, see the
   * <a href=
   * "https://developer.github.com/changes/2019-11-05-deprecated-passwords-and-authorizations-api">blog
   * post</a>.
   * </p>
   * <p>
   * This method will create a new authorization for the specified OAuth
   * application, only if an authorization for that application and fingerprint do
   * not already exist for the user. The URL includes the 20 character client ID
   * for the OAuth app that is requesting the token. <code>fingerprint</code> is a
   * unique string to distinguish an authorization from others created for the
   * same client ID and user. It returns the user's existing authorization for the
   * application if one is present. Otherwise, it creates and returns a new one.
   * </p>
   * <p>
   * If you have two-factor authentication setup, Basic Authentication for this
   * endpoint requires that you use a one-time password (OTP) and your username
   * and password instead of tokens. For more information, see &quot;<a href=
   * "https://developer.github.com/v3/auth/#working-with-two-factor-authentication">Working
   * with two-factor authentication</a>.&quot;
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** GitHub will discontinue the [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/), which is used by integrations to create personal access tokens and OAuth tokens, and you must now create these tokens using our [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow). The [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/) will be removed on November, 13, 2020. For more information, including scheduled brownouts, see the [blog post](https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/).\n\n**Warning:** Apps must use the [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow) to obtain OAuth tokens that work with GitHub SAML organizations. OAuth tokens created using the Authorizations API will be unable to access GitHub SAML organizations. For more information, see the [blog post](https://developer.github.com/changes/2019-11-05-deprecated-passwords-and-authorizations-api).\n\nThis method will create a new authorization for the specified OAuth application, only if an authorization for that application and fingerprint do not already exist for the user. The URL includes the 20 character client ID for the OAuth app that is requesting the token. `fingerprint` is a unique string to distinguish an authorization from others created for the same client ID and user. It returns the user's existing authorization for the application if one is present. Otherwise, it creates and returns a new one.\n\nIf you have two-factor authentication setup, Basic Authentication for this endpoint requires that you use a one-time password (OTP) and your username and password instead of tokens. For more information, see \"[Working with two-factor authentication](https://developer.github.com/v3/auth/#working-with-two-factor-authentication).\"", summary = "Get-or-create an authorization for a specific app and fingerprint", operationId = "oauth-authorizations/get-or-create-authorization-for-app-and-fingerprint")
  @Path("/clients/{client_id}/{fingerprint}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response oauth_authorizations_get_or_create_authorization_for_app_and_fingerprint(
      @PathParam("client_id") String clientId, @PathParam("fingerprint") String fingerprint, @NotNull InputStream data);

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
  @Operation(description = "**Deprecation Notice:** GitHub will discontinue the [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/), which is used by integrations to create personal access tokens and OAuth tokens, and you must now create these tokens using our [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow). The [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/) will be removed on November, 13, 2020. For more information, including scheduled brownouts, see the [blog post](https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/).", summary = "Get a single authorization", operationId = "oauth-authorizations/get-authorization")
  @Path("/{authorization_id}")
  @GET
  @Produces("application/json")
  Response oauth_authorizations_get_authorization(@PathParam("authorization_id") BigInteger authorizationId);

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
  @Operation(description = "**Deprecation Notice:** GitHub will discontinue the [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/), which is used by integrations to create personal access tokens and OAuth tokens, and you must now create these tokens using our [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow). The [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/) will be removed on November, 13, 2020. For more information, including scheduled brownouts, see the [blog post](https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/).", summary = "Delete an authorization", operationId = "oauth-authorizations/delete-authorization")
  @Path("/{authorization_id}")
  @DELETE
  void oauth_authorizations_delete_authorization(@PathParam("authorization_id") BigInteger authorizationId);

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
   * If you have two-factor authentication setup, Basic Authentication for this
   * endpoint requires that you use a one-time password (OTP) and your username
   * and password instead of tokens. For more information, see &quot;<a href=
   * "https://developer.github.com/v3/auth/#working-with-two-factor-authentication">Working
   * with two-factor authentication</a>.&quot;
   * </p>
   * <p>
   * You can only send one of these scope keys at a time.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** GitHub will discontinue the [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/), which is used by integrations to create personal access tokens and OAuth tokens, and you must now create these tokens using our [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow). The [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/) will be removed on November, 13, 2020. For more information, including scheduled brownouts, see the [blog post](https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/).\n\nIf you have two-factor authentication setup, Basic Authentication for this endpoint requires that you use a one-time password (OTP) and your username and password instead of tokens. For more information, see \"[Working with two-factor authentication](https://developer.github.com/v3/auth/#working-with-two-factor-authentication).\"\n\nYou can only send one of these scope keys at a time.", summary = "Update an existing authorization", operationId = "oauth-authorizations/update-authorization")
  @Path("/{authorization_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response oauth_authorizations_update_authorization(@PathParam("authorization_id") BigInteger authorizationId,
      @NotNull InputStream data);

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
   * <strong>Warning:</strong> Apps must use the <a href=
   * "https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow">web
   * application flow</a> to obtain OAuth tokens that work with GitHub SAML
   * organizations. OAuth tokens created using the Authorizations API will be
   * unable to access GitHub SAML organizations. For more information, see the
   * <a href=
   * "https://developer.github.com/changes/2019-11-05-deprecated-passwords-and-authorizations-api">blog
   * post</a>.
   * </p>
   * <p>
   * Creates a new authorization for the specified OAuth application, only if an
   * authorization for that application doesn't already exist for the user. The
   * URL includes the 20 character client ID for the OAuth app that is requesting
   * the token. It returns the user's existing authorization for the application
   * if one is present. Otherwise, it creates and returns a new one.
   * </p>
   * <p>
   * If you have two-factor authentication setup, Basic Authentication for this
   * endpoint requires that you use a one-time password (OTP) and your username
   * and password instead of tokens. For more information, see &quot;<a href=
   * "https://developer.github.com/v3/auth/#working-with-two-factor-authentication">Working
   * with two-factor authentication</a>.&quot;
   * </p>
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
  @Operation(description = "**Deprecation Notice:** GitHub will discontinue the [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/), which is used by integrations to create personal access tokens and OAuth tokens, and you must now create these tokens using our [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow). The [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/) will be removed on November, 13, 2020. For more information, including scheduled brownouts, see the [blog post](https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/).\n\n**Warning:** Apps must use the [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow) to obtain OAuth tokens that work with GitHub SAML organizations. OAuth tokens created using the Authorizations API will be unable to access GitHub SAML organizations. For more information, see the [blog post](https://developer.github.com/changes/2019-11-05-deprecated-passwords-and-authorizations-api).\n\nCreates a new authorization for the specified OAuth application, only if an authorization for that application doesn't already exist for the user. The URL includes the 20 character client ID for the OAuth app that is requesting the token. It returns the user's existing authorization for the application if one is present. Otherwise, it creates and returns a new one.\n\nIf you have two-factor authentication setup, Basic Authentication for this endpoint requires that you use a one-time password (OTP) and your username and password instead of tokens. For more information, see \"[Working with two-factor authentication](https://developer.github.com/v3/auth/#working-with-two-factor-authentication).\"\n\n**Deprecation Notice:** GitHub will discontinue the [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/), which is used by integrations to create personal access tokens and OAuth tokens, and you must now create these tokens using our [web application flow](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/#web-application-flow). The [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/) will be removed on November, 13, 2020. For more information, including scheduled brownouts, see the [blog post](https://developer.github.com/changes/2020-02-14-deprecating-oauth-auth-endpoint/).", summary = "Get-or-create an authorization for a specific app", operationId = "oauth-authorizations/get-or-create-authorization-for-app")
  @Path("/clients/{client_id}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response oauth_authorizations_get_or_create_authorization_for_app(@PathParam("client_id") String clientId,
      @NotNull InputStream data);
}
