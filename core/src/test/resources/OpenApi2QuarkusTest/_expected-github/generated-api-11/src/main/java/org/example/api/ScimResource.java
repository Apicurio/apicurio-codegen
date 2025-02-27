package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
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
@Path("/scim")
public interface ScimResource {
  /**
   *
   */
  @Operation(description = "", summary = "Get SCIM provisioning information for a user", operationId = "scim/get-provisioning-information-for-user")
  @Path("/v2/organizations/{org}/Users/{scim_user_id}")
  @GET
  @Produces("application/scim+json")
  Response scim_get_provisioning_information_for_user(@PathParam("org") String org,
      @PathParam("scim_user_id") String scimUserId);

  /**
   * <p>
   * Replaces an existing provisioned user's information. You must provide all the
   * information required for the user as if you were provisioning them for the
   * first time. Any existing user information that you don't provide will be
   * removed. If you want to only update a specific attribute, use the <a href=
   * "https://developer.github.com/v3/scim/#update-an-attribute-for-a-scim-user">Update
   * an attribute for a SCIM user</a> endpoint instead.
   * </p>
   * <p>
   * You must at least provide the required values for the user:
   * <code>userName</code>, <code>name</code>, and <code>emails</code>.
   * </p>
   * <p>
   * <strong>Warning:</strong> Setting <code>active: false</code> removes the user
   * from the organization, deletes the external identity, and deletes the
   * associated <code>{scim_user_id}</code>.
   * </p>
   *
   */
  @Operation(description = "Replaces an existing provisioned user's information. You must provide all the information required for the user as if you were provisioning them for the first time. Any existing user information that you don't provide will be removed. If you want to only update a specific attribute, use the [Update an attribute for a SCIM user](https://developer.github.com/v3/scim/#update-an-attribute-for-a-scim-user) endpoint instead.\n\nYou must at least provide the required values for the user: `userName`, `name`, and `emails`.\n\n**Warning:** Setting `active: false` removes the user from the organization, deletes the external identity, and deletes the associated `{scim_user_id}`.", summary = "Update a provisioned organization membership", operationId = "scim/set-information-for-provisioned-user")
  @Path("/v2/organizations/{org}/Users/{scim_user_id}")
  @PUT
  @Produces("application/scim+json")
  @Consumes("application/json")
  Response scim_set_information_for_provisioned_user(@PathParam("org") String org,
      @PathParam("scim_user_id") String scimUserId, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a SCIM user from an organization", operationId = "scim/delete-user-from-org")
  @Path("/v2/organizations/{org}/Users/{scim_user_id}")
  @DELETE
  void scim_delete_user_from_org(@PathParam("org") String org, @PathParam("scim_user_id") String scimUserId);

  /**
   * <p>
   * Allows you to change a provisioned user's individual attributes. To change a
   * user's values, you must provide a specific <code>Operations</code> JSON
   * format that contains at least one of the <code>add</code>,
   * <code>remove</code>, or <code>replace</code> operations. For examples and
   * more information on the SCIM operations format, see the
   * <a href="https://tools.ietf.org/html/rfc7644#section-3.5.2">SCIM
   * specification</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> Complicated SCIM <code>path</code> selectors that
   * include filters are not supported. For example, a <code>path</code> selector
   * defined as
   * <code>&quot;path&quot;: &quot;emails[type eq \&quot;work\&quot;]&quot;</code>
   * will not work.
   * </p>
   * <p>
   * <strong>Warning:</strong> If you set <code>active:false</code> using the
   * <code>replace</code> operation (as shown in the JSON example below), it
   * removes the user from the organization, deletes the external identity, and
   * deletes the associated <code>:scim_user_id</code>.
   * </p>
   *
   * <pre>
   * <code>{
    &quot;Operations&quot;:[{
  &quot;op&quot;:&quot;replace&quot;,
  &quot;value&quot;:{
    &quot;active&quot;:false
  }
    }]
  }
  </code>
   * </pre>
   *
   */
  @Operation(description = "Allows you to change a provisioned user's individual attributes. To change a user's values, you must provide a specific `Operations` JSON format that contains at least one of the `add`, `remove`, or `replace` operations. For examples and more information on the SCIM operations format, see the [SCIM specification](https://tools.ietf.org/html/rfc7644#section-3.5.2).\n\n**Note:** Complicated SCIM `path` selectors that include filters are not supported. For example, a `path` selector defined as `\"path\": \"emails[type eq \\\"work\\\"]\"` will not work.\n\n**Warning:** If you set `active:false` using the `replace` operation (as shown in the JSON example below), it removes the user from the organization, deletes the external identity, and deletes the associated `:scim_user_id`.\n\n```\n{\n  \"Operations\":[{\n    \"op\":\"replace\",\n    \"value\":{\n      \"active\":false\n    }\n  }]\n}\n```", summary = "Update an attribute for a SCIM user", operationId = "scim/update-attribute-for-user")
  @Path("/v2/organizations/{org}/Users/{scim_user_id}")
  @PATCH
  @Produces("application/scim+json")
  @Consumes("application/json")
  Response scim_update_attribute_for_user(@PathParam("org") String org, @PathParam("scim_user_id") String scimUserId,
      @NotNull InputStream data);

  /**
   * <p>
   * Retrieves a paginated list of all provisioned organization members, including
   * pending invitations. If you provide the <code>filter</code> parameter, the
   * resources for all matching provisions members are returned.
   * </p>
   * <p>
   * When a user with a SAML-provisioned external identity leaves (or is removed
   * from) an organization, the account's metadata is immediately removed.
   * However, the returned list of user accounts might not always match the
   * organization or enterprise member list you see on GitHub. This can happen in
   * certain cases where an external identity associated with an organization will
   * not match an organization member:
   * </p>
   * <ul>
   * <li>When a user with a SCIM-provisioned external identity is removed from an
   * organization, the account's metadata is preserved to allow the user to
   * re-join the organization in the future.</li>
   * <li>When inviting a user to join an organization, you can expect to see their
   * external identity in the results before they accept the invitation, or if the
   * invitation is cancelled (or never accepted).</li>
   * <li>When a user is invited over SCIM, an external identity is created that
   * matches with the invitee's email address. However, this identity is only
   * linked to a user account when the user accepts the invitation by going
   * through SAML SSO.</li>
   * </ul>
   * <p>
   * The returned list of external identities can include an entry for a
   * <code>null</code> user. These are unlinked SAML identities that are created
   * when a user goes through the following Single Sign-On (SSO) process but does
   * not sign in to their GitHub account after completing SSO:
   * </p>
   * <ol>
   * <li>
   * <p>
   * The user is granted access by the IdP and is not a member of the GitHub
   * organization.
   * </p>
   * </li>
   * <li>
   * <p>
   * The user attempts to access the GitHub organization and initiates the SAML
   * SSO process, and is not currently signed in to their GitHub account.
   * </p>
   * </li>
   * <li>
   * <p>
   * After successfully authenticating with the SAML SSO IdP, the
   * <code>null</code> external identity entry is created and the user is prompted
   * to sign in to their GitHub account:
   * </p>
   * <ul>
   * <li>If the user signs in, their GitHub account is linked to this entry.</li>
   * <li>If the user does not sign in (or does not create a new account when
   * prompted), they are not added to the GitHub organization, and the external
   * identity <code>null</code> entry remains in place.</li>
   * </ul>
   * </li>
   * </ol>
   *
   */
  @Operation(description = "Retrieves a paginated list of all provisioned organization members, including pending invitations. If you provide the `filter` parameter, the resources for all matching provisions members are returned.\n\nWhen a user with a SAML-provisioned external identity leaves (or is removed from) an organization, the account's metadata is immediately removed. However, the returned list of user accounts might not always match the organization or enterprise member list you see on GitHub. This can happen in certain cases where an external identity associated with an organization will not match an organization member:\n  - When a user with a SCIM-provisioned external identity is removed from an organization, the account's metadata is preserved to allow the user to re-join the organization in the future.\n  - When inviting a user to join an organization, you can expect to see their external identity in the results before they accept the invitation, or if the invitation is cancelled (or never accepted).\n  - When a user is invited over SCIM, an external identity is created that matches with the invitee's email address. However, this identity is only linked to a user account when the user accepts the invitation by going through SAML SSO.\n\nThe returned list of external identities can include an entry for a `null` user. These are unlinked SAML identities that are created when a user goes through the following Single Sign-On (SSO) process but does not sign in to their GitHub account after completing SSO:\n\n1. The user is granted access by the IdP and is not a member of the GitHub organization.\n\n1. The user attempts to access the GitHub organization and initiates the SAML SSO process, and is not currently signed in to their GitHub account.\n\n1. After successfully authenticating with the SAML SSO IdP, the `null` external identity entry is created and the user is prompted to sign in to their GitHub account:\n   - If the user signs in, their GitHub account is linked to this entry.\n   - If the user does not sign in (or does not create a new account when prompted), they are not added to the GitHub organization, and the external identity `null` entry remains in place.", summary = "List SCIM provisioned identities", operationId = "scim/list-provisioned-identities")
  @Path("/v2/organizations/{org}/Users")
  @GET
  @Produces("application/scim+json")
  Response scim_list_provisioned_identities(@PathParam("org") String org,
      @QueryParam("startIndex") BigInteger startIndex, @QueryParam("count") BigInteger count,
      @QueryParam("filter") String filter);

  /**
   * <p>
   * Provision organization membership for a user, and send an activation email to
   * the email address.
   * </p>
   *
   */
  @Operation(description = "Provision organization membership for a user, and send an activation email to the email address.", summary = "Provision and invite a SCIM user", operationId = "scim/provision-and-invite-user")
  @Path("/v2/organizations/{org}/Users")
  @POST
  @Produces("application/scim+json")
  @Consumes("application/json")
  Response scim_provision_and_invite_user(@PathParam("org") String org, @NotNull InputStream data);
}
