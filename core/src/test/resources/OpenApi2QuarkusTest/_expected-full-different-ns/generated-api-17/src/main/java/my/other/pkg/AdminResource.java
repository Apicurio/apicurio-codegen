package my.other.pkg;

import io.apicurio.registry.types.RuleType;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;
import my.other.pkg.beans.ArtifactTypeInfo;
import my.other.pkg.beans.ConfigurationProperty;
import my.other.pkg.beans.RoleMapping;
import my.other.pkg.beans.Rule;
import my.other.pkg.beans.UpdateConfigurationProperty;
import my.other.pkg.beans.UpdateRole;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/apis/registry/v2/admin")
public interface AdminResource {
  /**
   * <p>
   * Gets a list of all the configured artifact types.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets a list of all the configured artifact types.\n\nThis operation can fail for the following reasons:\n\n* A server error occurred (HTTP error `500`)\n", summary = "List artifact types", operationId = "listArtifactTypes")
  @Path("/artifactTypes")
  @GET
  @Produces("application/json")
  List<ArtifactTypeInfo> listArtifactTypes();

  /**
   * <p>
   * Gets a list of all the currently configured global rules (if any).
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets a list of all the currently configured global rules (if any).\n\nThis operation can fail for the following reasons:\n\n* A server error occurred (HTTP error `500`)\n", summary = "List global rules", operationId = "listGlobalRules")
  @Path("/rules")
  @GET
  @Produces("application/json")
  List<RuleType> listGlobalRules();

  /**
   * <p>
   * Adds a rule to the list of globally configured rules.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>The rule type is unknown (HTTP error <code>400</code>)</li>
   * <li>The rule already exists (HTTP error <code>409</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Adds a rule to the list of globally configured rules.\n\nThis operation can fail for the following reasons:\n\n* The rule type is unknown (HTTP error `400`)\n* The rule already exists (HTTP error `409`)\n* A server error occurred (HTTP error `500`)\n", summary = "Create global rule", operationId = "createGlobalRule")
  @Path("/rules")
  @POST
  @Consumes("application/json")
  void createGlobalRule(@NotNull Rule data);

  /**
   * <p>
   * Deletes all globally configured rules.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes all globally configured rules.\n\nThis operation can fail for the following reasons:\n\n* A server error occurred (HTTP error `500`)\n", summary = "Delete all global rules", operationId = "deleteAllGlobalRules")
  @Path("/rules")
  @DELETE
  void deleteAllGlobalRules();

  /**
   * <p>
   * Returns information about the named globally configured rule.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>Invalid rule name/type (HTTP error <code>400</code>)</li>
   * <li>No rule with name/type <code>rule</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns information about the named globally configured rule.\n\nThis operation can fail for the following reasons:\n\n* Invalid rule name/type (HTTP error `400`)\n* No rule with name/type `rule` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get global rule configuration", operationId = "getGlobalRuleConfig")
  @Path("/rules/{rule}")
  @GET
  @Produces("application/json")
  Rule getGlobalRuleConfig(@PathParam("rule") RuleType rule);

  /**
   * <p>
   * Updates the configuration for a globally configured rule.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>Invalid rule name/type (HTTP error <code>400</code>)</li>
   * <li>No rule with name/type <code>rule</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Updates the configuration for a globally configured rule.\n\nThis operation can fail for the following reasons:\n\n* Invalid rule name/type (HTTP error `400`)\n* No rule with name/type `rule` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Update global rule configuration", operationId = "updateGlobalRuleConfig")
  @Path("/rules/{rule}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Rule updateGlobalRuleConfig(@PathParam("rule") RuleType rule, @NotNull Rule data);

  /**
   * <p>
   * Deletes a single global rule. If this is the only rule configured, this is
   * the same as deleting <strong>all</strong> rules.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>Invalid rule name/type (HTTP error <code>400</code>)</li>
   * <li>No rule with name/type <code>rule</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>Rule cannot be deleted (HTTP error <code>409</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes a single global rule.  If this is the only rule configured, this is the same\nas deleting **all** rules.\n\nThis operation can fail for the following reasons:\n\n* Invalid rule name/type (HTTP error `400`)\n* No rule with name/type `rule` exists (HTTP error `404`)\n* Rule cannot be deleted (HTTP error `409`)\n* A server error occurred (HTTP error `500`)\n", summary = "Delete global rule", operationId = "deleteGlobalRule")
  @Path("/rules/{rule}")
  @DELETE
  void deleteGlobalRule(@PathParam("rule") RuleType rule);

  /**
   * <p>
   * Exports registry data as a ZIP archive.
   * </p>
   *
   */
  @Operation(description = "Exports registry data as a ZIP archive.", summary = "Export registry data", operationId = "exportData")
  @Path("/export")
  @GET
  @Produces({"application/json", "application/zip"})
  Response exportData(@QueryParam("forBrowser") Boolean forBrowser);

  /**
   * <p>
   * Imports registry data that was previously exported using the
   * <code>/admin/export</code> operation.
   * </p>
   *
   */
  @Operation(description = "Imports registry data that was previously exported using the `/admin/export` operation.", summary = "Import registry data", operationId = "importData")
  @Path("/import")
  @POST
  @Consumes("application/zip")
  void importData(@HeaderParam("X-Registry-Preserve-GlobalId") Boolean xRegistryPreserveGlobalId,
      @HeaderParam("X-Registry-Preserve-ContentId") Boolean xRegistryPreserveContentId, @NotNull InputStream data);

  /**
   * <p>
   * Gets the details of a single role mapping (by <code>principalId</code>).
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No role mapping for the <code>principalId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets the details of a single role mapping (by `principalId`).\n\nThis operation can fail for the following reasons:\n\n* No role mapping for the `principalId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Return a single role mapping", operationId = "getRoleMapping")
  @Path("/roleMappings/{principalId}")
  @GET
  @Produces("application/json")
  RoleMapping getRoleMapping(@PathParam("principalId") String principalId);

  /**
   * <p>
   * Updates a single role mapping for one user/principal.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No role mapping for the principalId exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Updates a single role mapping for one user/principal.\n\nThis operation can fail for the following reasons:\n\n* No role mapping for the principalId exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Update a role mapping", operationId = "updateRoleMapping")
  @Path("/roleMappings/{principalId}")
  @PUT
  @Consumes("application/json")
  void updateRoleMapping(@PathParam("principalId") String principalId, @NotNull UpdateRole data);

  /**
   * <p>
   * Deletes a single role mapping, effectively denying access to a
   * user/principal.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No role mapping for the principalId exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes a single role mapping, effectively denying access to a user/principal.\n\nThis operation can fail for the following reasons:\n\n* No role mapping for the principalId exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Delete a role mapping", operationId = "deleteRoleMapping")
  @Path("/roleMappings/{principalId}")
  @DELETE
  void deleteRoleMapping(@PathParam("principalId") String principalId);

  /**
   * <p>
   * Gets a list of all role mappings configured in the registry (if any).
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets a list of all role mappings configured in the registry (if any).\n\nThis operation can fail for the following reasons:\n\n* A server error occurred (HTTP error `500`)\n", summary = "List all role mappings", operationId = "listRoleMappings")
  @Path("/roleMappings")
  @GET
  @Produces("application/json")
  List<RoleMapping> listRoleMappings();

  /**
   * <p>
   * Creates a new mapping between a user/principal and a role.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Creates a new mapping between a user/principal and a role.\n\nThis operation can fail for the following reasons:\n\n* A server error occurred (HTTP error `500`)\n\n", summary = "Create a new role mapping", operationId = "createRoleMapping")
  @Path("/roleMappings")
  @POST
  @Consumes("application/json")
  void createRoleMapping(@NotNull RoleMapping data);

  /**
   * <p>
   * Returns a list of all configuration properties that have been set. The list
   * is not paged.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns a list of all configuration properties that have been set.  The list is not paged.\n\nThis operation may fail for one of the following reasons:\n\n* A server error occurred (HTTP error `500`)\n", summary = "List all configuration properties", operationId = "listConfigProperties")
  @Path("/config/properties")
  @GET
  @Produces("application/json")
  List<ConfigurationProperty> listConfigProperties();

  /**
   * <p>
   * Returns the value of a single configuration property.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>Property not found or not configured (HTTP error <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns the value of a single configuration property.\n\nThis operation may fail for one of the following reasons:\n\n* Property not found or not configured (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get configuration property value", operationId = "getConfigProperty")
  @Path("/config/properties/{propertyName}")
  @GET
  @Produces("application/json")
  ConfigurationProperty getConfigProperty(@PathParam("propertyName") String propertyName);

  /**
   * <p>
   * Updates the value of a single configuration property.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>Property not found or not configured (HTTP error <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Updates the value of a single configuration property.\n\nThis operation may fail for one of the following reasons:\n\n* Property not found or not configured (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Update a configuration property", operationId = "updateConfigProperty")
  @Path("/config/properties/{propertyName}")
  @PUT
  @Consumes("application/json")
  void updateConfigProperty(@PathParam("propertyName") String propertyName, @NotNull UpdateConfigurationProperty data);

  /**
   * <p>
   * Resets the value of a single configuration property. This will return the
   * property to its default value (see external documentation for supported
   * properties and their default values).
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>Property not found or not configured (HTTP error <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Resets the value of a single configuration property.  This will return the property to\nits default value (see external documentation for supported properties and their default\nvalues).\n\nThis operation may fail for one of the following reasons:\n\n* Property not found or not configured (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Reset a configuration property", operationId = "resetConfigProperty")
  @Path("/config/properties/{propertyName}")
  @DELETE
  void resetConfigProperty(@PathParam("propertyName") String propertyName);
}
