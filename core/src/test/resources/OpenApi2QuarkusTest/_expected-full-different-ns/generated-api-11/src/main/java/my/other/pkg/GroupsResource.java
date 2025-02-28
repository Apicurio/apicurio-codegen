package my.other.pkg;

import io.apicurio.registry.types.ReferenceType;
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
import java.math.BigInteger;
import java.util.List;
import my.other.pkg.beans.ArtifactContent;
import my.other.pkg.beans.ArtifactMetaData;
import my.other.pkg.beans.ArtifactOwner;
import my.other.pkg.beans.ArtifactReference;
import my.other.pkg.beans.ArtifactSearchResults;
import my.other.pkg.beans.Comment;
import my.other.pkg.beans.CreateGroupMetaData;
import my.other.pkg.beans.EditableMetaData;
import my.other.pkg.beans.GroupMetaData;
import my.other.pkg.beans.GroupSearchResults;
import my.other.pkg.beans.HandleReferencesType;
import my.other.pkg.beans.IfExists;
import my.other.pkg.beans.NewComment;
import my.other.pkg.beans.Rule;
import my.other.pkg.beans.SortBy;
import my.other.pkg.beans.SortOrder;
import my.other.pkg.beans.UpdateState;
import my.other.pkg.beans.VersionMetaData;
import my.other.pkg.beans.VersionSearchResults;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/apis/registry/v2/groups")
public interface GroupsResource {
  /**
   * <p>
   * Updates the state of the artifact. For example, you can use this to mark the
   * latest version of an artifact as <code>DEPRECATED</code>. The operation
   * changes the state of the latest version of the artifact, even if this version
   * is <code>DISABLED</code>. If multiple versions exist, only the most recent is
   * changed.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Updates the state of the artifact.  For example, you can use this to mark the latest version of an artifact as `DEPRECATED`. The operation changes the state of the latest version of the artifact, even if this version is `DISABLED`. If multiple versions exist, only the most recent is changed.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Update artifact state", operationId = "updateArtifactState")
  @Path("/{groupId}/artifacts/{artifactId}/state")
  @PUT
  @Consumes("application/json")
  void updateArtifactState(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @NotNull UpdateState data);

  /**
   * <p>
   * Retrieves the metadata for a single version of the artifact. The version
   * metadata is a subset of the artifact metadata and only includes the metadata
   * that is specific to the version (for example, this doesn't include
   * <code>modifiedOn</code>).
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Retrieves the metadata for a single version of the artifact.  The version metadata is \na subset of the artifact metadata and only includes the metadata that is specific to\nthe version (for example, this doesn't include `modifiedOn`).\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get artifact version metadata", operationId = "getArtifactVersionMetaData")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/meta")
  @GET
  @Produces("application/json")
  VersionMetaData getArtifactVersionMetaData(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @PathParam("version") String version);

  /**
   * <p>
   * Updates the user-editable portion of the artifact version's metadata. Only
   * some of the metadata fields are editable by the user. For example,
   * <code>description</code> is editable, but <code>createdOn</code> is not.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Updates the user-editable portion of the artifact version's metadata.  Only some of \nthe metadata fields are editable by the user.  For example, `description` is editable, \nbut `createdOn` is not.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Update artifact version metadata", operationId = "updateArtifactVersionMetaData")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/meta")
  @PUT
  @Consumes("application/json")
  void updateArtifactVersionMetaData(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("version") String version, @NotNull EditableMetaData data);

  /**
   * <p>
   * Deletes the user-editable metadata properties of the artifact version. Any
   * properties that are not user-editable are preserved.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes the user-editable metadata properties of the artifact version.  Any properties\nthat are not user-editable are preserved.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Delete artifact version metadata", operationId = "deleteArtifactVersionMetaData")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/meta")
  @DELETE
  void deleteArtifactVersionMetaData(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("version") String version);

  /**
   * <p>
   * Retrieves a single version of the artifact content. Both the
   * <code>artifactId</code> and the unique <code>version</code> number must be
   * provided. The <code>Content-Type</code> of the response depends on the
   * artifact type. In most cases, this is <code>application/json</code>, but for
   * some types it may be different (for example, <code>PROTOBUF</code>).
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Retrieves a single version of the artifact content.  Both the `artifactId` and the\nunique `version` number must be provided.  The `Content-Type` of the response depends \non the artifact type.  In most cases, this is `application/json`, but for some types \nit may be different (for example, `PROTOBUF`).\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get artifact version", operationId = "getArtifactVersion")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}")
  @GET
  @Produces("*/*")
  Response getArtifactVersion(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("version") String version, @QueryParam("references") HandleReferencesType references);

  /**
   * <p>
   * Deletes a single version of the artifact. Parameters <code>groupId</code>,
   * <code>artifactId</code> and the unique <code>version</code> are needed. If
   * this is the only version of the artifact, this operation is the same as
   * deleting the entire artifact.
   * </p>
   * <p>
   * This feature is disabled by default and it's discouraged for normal usage. To
   * enable it, set the <code>registry.rest.artifact.deletion.enabled</code>
   * property to true. This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>Feature is disabled (HTTP error <code>405</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes a single version of the artifact. Parameters `groupId`, `artifactId` and the unique `version`\nare needed. If this is the only version of the artifact, this operation is the same as \ndeleting the entire artifact.\n\nThis feature is disabled by default and it's discouraged for normal usage. To enable it, set the `registry.rest.artifact.deletion.enabled` property to true. This operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n * Feature is disabled (HTTP error `405`)\n * A server error occurred (HTTP error `500`)\n", summary = "Delete artifact version", operationId = "deleteArtifactVersion")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}")
  @DELETE
  void deleteArtifactVersion(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("version") String version);

  /**
   * <p>
   * Updates the state of a specific version of an artifact. For example, you can
   * use this operation to disable a specific version.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Updates the state of a specific version of an artifact.  For example, you can use \nthis operation to disable a specific version.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Update artifact version state", operationId = "updateArtifactVersionState")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/state")
  @PUT
  @Consumes("application/json")
  void updateArtifactVersionState(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("version") String version, @NotNull UpdateState data);

  /**
   * <p>
   * Returns a list of all rules configured for the artifact. The set of rules
   * determines how the content of an artifact can evolve over time. If no rules
   * are configured for an artifact, the set of globally configured rules are
   * used. If no global rules are defined, there are no restrictions on content
   * evolution.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns a list of all rules configured for the artifact.  The set of rules determines\nhow the content of an artifact can evolve over time.  If no rules are configured for\nan artifact, the set of globally configured rules are used.  If no global rules \nare defined, there are no restrictions on content evolution.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)", summary = "List artifact rules", operationId = "listArtifactRules")
  @Path("/{groupId}/artifacts/{artifactId}/rules")
  @GET
  @Produces("application/json")
  List<RuleType> listArtifactRules(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId);

  /**
   * <p>
   * Adds a rule to the list of rules that get applied to the artifact when adding
   * new versions. All configured rules must pass to successfully add a new
   * artifact version.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>Rule (named in the request body) is unknown (HTTP error
   * <code>400</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Adds a rule to the list of rules that get applied to the artifact when adding new\nversions.  All configured rules must pass to successfully add a new artifact version.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* Rule (named in the request body) is unknown (HTTP error `400`)\n* A server error occurred (HTTP error `500`)", summary = "Create artifact rule", operationId = "createArtifactRule")
  @Path("/{groupId}/artifacts/{artifactId}/rules")
  @POST
  @Consumes("application/json")
  void createArtifactRule(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @NotNull Rule data);

  /**
   * <p>
   * Deletes all of the rules configured for the artifact. After this is done, the
   * global rules apply to the artifact again.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes all of the rules configured for the artifact.  After this is done, the global\nrules apply to the artifact again.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)", summary = "Delete artifact rules", operationId = "deleteArtifactRules")
  @Path("/{groupId}/artifacts/{artifactId}/rules")
  @DELETE
  void deleteArtifactRules(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId);

  /**
   * <p>
   * Returns information about a single rule configured for an artifact. This is
   * useful when you want to know what the current configuration settings are for
   * a specific rule.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No rule with this name/type is configured for this artifact (HTTP error
   * <code>404</code>)</li>
   * <li>Invalid rule type (HTTP error <code>400</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns information about a single rule configured for an artifact.  This is useful\nwhen you want to know what the current configuration settings are for a specific rule.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No rule with this name/type is configured for this artifact (HTTP error `404`)\n* Invalid rule type (HTTP error `400`)\n* A server error occurred (HTTP error `500`)", summary = "Get artifact rule configuration", operationId = "getArtifactRuleConfig")
  @Path("/{groupId}/artifacts/{artifactId}/rules/{rule}")
  @GET
  @Produces("application/json")
  Rule getArtifactRuleConfig(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("rule") RuleType rule);

  /**
   * <p>
   * Updates the configuration of a single rule for the artifact. The
   * configuration data is specific to each rule type, so the configuration of the
   * <code>COMPATIBILITY</code> rule is in a different format from the
   * configuration of the <code>VALIDITY</code> rule.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No rule with this name/type is configured for this artifact (HTTP error
   * <code>404</code>)</li>
   * <li>Invalid rule type (HTTP error <code>400</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Updates the configuration of a single rule for the artifact.  The configuration data\nis specific to each rule type, so the configuration of the `COMPATIBILITY` rule \nis in a different format from the configuration of the `VALIDITY` rule.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No rule with this name/type is configured for this artifact (HTTP error `404`)\n* Invalid rule type (HTTP error `400`)\n* A server error occurred (HTTP error `500`)\n", summary = "Update artifact rule configuration", operationId = "updateArtifactRuleConfig")
  @Path("/{groupId}/artifacts/{artifactId}/rules/{rule}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Rule updateArtifactRuleConfig(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("rule") RuleType rule, @NotNull Rule data);

  /**
   * <p>
   * Deletes a rule from the artifact. This results in the rule no longer applying
   * for this artifact. If this is the only rule configured for the artifact, this
   * is the same as deleting <strong>all</strong> rules, and the globally
   * configured rules now apply to this artifact.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No rule with this name/type is configured for this artifact (HTTP error
   * <code>404</code>)</li>
   * <li>Invalid rule type (HTTP error <code>400</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes a rule from the artifact.  This results in the rule no longer applying for\nthis artifact.  If this is the only rule configured for the artifact, this is the \nsame as deleting **all** rules, and the globally configured rules now apply to\nthis artifact.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No rule with this name/type is configured for this artifact (HTTP error `404`)\n* Invalid rule type (HTTP error `400`)\n* A server error occurred (HTTP error `500`)", summary = "Delete artifact rule", operationId = "deleteArtifactRule")
  @Path("/{groupId}/artifacts/{artifactId}/rules/{rule}")
  @DELETE
  void deleteArtifactRule(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("rule") RuleType rule);

  /**
   * <p>
   * Retrieves all references for a single version of an artifact. Both the
   * <code>artifactId</code> and the unique <code>version</code> number must be
   * provided. Using the <code>refType</code> query parameter, it is possible to
   * retrieve an array of either the inbound or outbound references.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Retrieves all references for a single version of an artifact.  Both the `artifactId` and the\nunique `version` number must be provided.  Using the `refType` query parameter, it is possible\nto retrieve an array of either the inbound or outbound references.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get artifact version references", operationId = "getArtifactVersionReferences")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/references")
  @GET
  @Produces("application/json")
  List<ArtifactReference> getArtifactVersionReferences(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @PathParam("version") String version,
      @QueryParam("refType") ReferenceType refType);

  /**
   * <p>
   * Returns the latest version of the artifact in its raw form. The
   * <code>Content-Type</code> of the response depends on the artifact type. In
   * most cases, this is <code>application/json</code>, but for some types it may
   * be different (for example, <code>PROTOBUF</code>). If the latest version of
   * the artifact is marked as <code>DISABLED</code>, the next available
   * non-disabled version will be used.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists or all versions are
   * <code>DISABLED</code> (HTTP error <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns the latest version of the artifact in its raw form.  The `Content-Type` of the\nresponse depends on the artifact type.  In most cases, this is `application/json`, but \nfor some types it may be different (for example, `PROTOBUF`).\nIf the latest version of the artifact is marked as `DISABLED`, the next available non-disabled version will be used.\n\nThis operation may fail for one of the following reasons:\n\n* No artifact with this `artifactId` exists or all versions are `DISABLED` (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get latest artifact", operationId = "getLatestArtifact")
  @Path("/{groupId}/artifacts/{artifactId}")
  @GET
  @Produces("*/*")
  Response getLatestArtifact(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @QueryParam("references") HandleReferencesType references);

  /**
   * <p>
   * Updates an artifact by uploading new content. The body of the request can be
   * the raw content of the artifact or a JSON object containing both the raw
   * content and a set of references to other artifacts.. This is typically in
   * JSON format for <em>most</em> of the supported types, but may be in another
   * format for a few (for example, <code>PROTOBUF</code>). The type of the
   * content should be compatible with the artifact's type (it would be an error
   * to update an <code>AVRO</code> artifact with new <code>OPENAPI</code>
   * content, for example).
   * </p>
   * <p>
   * The update could fail for a number of reasons including:
   * </p>
   * <ul>
   * <li>Provided content (request body) was empty (HTTP error
   * <code>400</code>)</li>
   * <li>No artifact with the <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>The new content violates one of the rules configured for the artifact
   * (HTTP error <code>409</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   * <p>
   * When successful, this creates a new version of the artifact, making it the
   * most recent (and therefore official) version of the artifact.
   * </p>
   *
   */
  @Operation(description = "Updates an artifact by uploading new content.  The body of the request can\nbe the raw content of the artifact or a JSON object containing both the raw content and\na set of references to other artifacts..  This is typically in JSON format for *most*\nof the supported types, but may be in another format for a few (for example, `PROTOBUF`).\nThe type of the content should be compatible with the artifact's type (it would be\nan error to update an `AVRO` artifact with new `OPENAPI` content, for example).\n\nThe update could fail for a number of reasons including:\n\n* Provided content (request body) was empty (HTTP error `400`)\n* No artifact with the `artifactId` exists (HTTP error `404`)\n* The new content violates one of the rules configured for the artifact (HTTP error `409`)\n* A server error occurred (HTTP error `500`)\n\nWhen successful, this creates a new version of the artifact, making it the most recent\n(and therefore official) version of the artifact.", summary = "Update artifact", operationId = "updateArtifact")
  @Path("/{groupId}/artifacts/{artifactId}")
  @PUT
  @Produces("application/json")
  @Consumes("*/*")
  ArtifactMetaData updateArtifact(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @HeaderParam("X-Registry-Version") String xRegistryVersion, @HeaderParam("X-Registry-Name") String xRegistryName,
      @HeaderParam("X-Registry-Name-Encoded") String xRegistryNameEncoded,
      @HeaderParam("X-Registry-Description") String xRegistryDescription,
      @HeaderParam("X-Registry-Description-Encoded") String xRegistryDescriptionEncoded, @NotNull InputStream data);

  /**
   * <p>
   * Updates an artifact by uploading new content. The body of the request can be
   * the raw content of the artifact or a JSON object containing both the raw
   * content and a set of references to other artifacts.. This is typically in
   * JSON format for <em>most</em> of the supported types, but may be in another
   * format for a few (for example, <code>PROTOBUF</code>). The type of the
   * content should be compatible with the artifact's type (it would be an error
   * to update an <code>AVRO</code> artifact with new <code>OPENAPI</code>
   * content, for example).
   * </p>
   * <p>
   * The update could fail for a number of reasons including:
   * </p>
   * <ul>
   * <li>Provided content (request body) was empty (HTTP error
   * <code>400</code>)</li>
   * <li>No artifact with the <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>The new content violates one of the rules configured for the artifact
   * (HTTP error <code>409</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   * <p>
   * When successful, this creates a new version of the artifact, making it the
   * most recent (and therefore official) version of the artifact.
   * </p>
   *
   */
  @Operation(description = "Updates an artifact by uploading new content.  The body of the request can\nbe the raw content of the artifact or a JSON object containing both the raw content and\na set of references to other artifacts..  This is typically in JSON format for *most*\nof the supported types, but may be in another format for a few (for example, `PROTOBUF`).\nThe type of the content should be compatible with the artifact's type (it would be\nan error to update an `AVRO` artifact with new `OPENAPI` content, for example).\n\nThe update could fail for a number of reasons including:\n\n* Provided content (request body) was empty (HTTP error `400`)\n* No artifact with the `artifactId` exists (HTTP error `404`)\n* The new content violates one of the rules configured for the artifact (HTTP error `409`)\n* A server error occurred (HTTP error `500`)\n\nWhen successful, this creates a new version of the artifact, making it the most recent\n(and therefore official) version of the artifact.", summary = "Update artifact", operationId = "updateArtifact")
  @Path("/{groupId}/artifacts/{artifactId}")
  @PUT
  @Produces("application/json")
  @Consumes({"application/vnd.create.extended+json", "application/create.extended+json"})
  ArtifactMetaData updateArtifact(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @HeaderParam("X-Registry-Version") String xRegistryVersion, @HeaderParam("X-Registry-Name") String xRegistryName,
      @HeaderParam("X-Registry-Name-Encoded") String xRegistryNameEncoded,
      @HeaderParam("X-Registry-Description") String xRegistryDescription,
      @HeaderParam("X-Registry-Description-Encoded") String xRegistryDescriptionEncoded, @NotNull ArtifactContent data);

  /**
   * <p>
   * Deletes an artifact completely, resulting in all versions of the artifact
   * also being deleted. This may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with the <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes an artifact completely, resulting in all versions of the artifact also being\ndeleted.  This may fail for one of the following reasons:\n\n* No artifact with the `artifactId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)", summary = "Delete artifact", operationId = "deleteArtifact")
  @Path("/{groupId}/artifacts/{artifactId}")
  @DELETE
  void deleteArtifact(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId);

  /**
   * <p>
   * Returns a list of all artifacts in the group. This list is paged.
   * </p>
   *
   */
  @Operation(description = "Returns a list of all artifacts in the group.  This list is paged.", summary = "List artifacts in group", operationId = "listArtifactsInGroup")
  @Path("/{groupId}/artifacts")
  @GET
  @Produces("application/json")
  ArtifactSearchResults listArtifactsInGroup(@PathParam("groupId") String groupId,
      @QueryParam("limit") BigInteger limit, @QueryParam("offset") BigInteger offset,
      @QueryParam("order") SortOrder order, @QueryParam("orderby") SortBy orderby);

  /**
   * <p>
   * Creates a new artifact by posting the artifact content. The body of the
   * request should be the raw content of the artifact. This is typically in JSON
   * format for <em>most</em> of the supported types, but may be in another format
   * for a few (for example, <code>PROTOBUF</code>).
   * </p>
   * <p>
   * The registry attempts to figure out what kind of artifact is being added from
   * the following supported list:
   * </p>
   * <ul>
   * <li>Avro (<code>AVRO</code>)</li>
   * <li>Protobuf (<code>PROTOBUF</code>)</li>
   * <li>JSON Schema (<code>JSON</code>)</li>
   * <li>Kafka Connect (<code>KCONNECT</code>)</li>
   * <li>OpenAPI (<code>OPENAPI</code>)</li>
   * <li>AsyncAPI (<code>ASYNCAPI</code>)</li>
   * <li>GraphQL (<code>GRAPHQL</code>)</li>
   * <li>Web Services Description Language (<code>WSDL</code>)</li>
   * <li>XML Schema (<code>XSD</code>)</li>
   * </ul>
   * <p>
   * Alternatively, you can specify the artifact type using the
   * <code>X-Registry-ArtifactType</code> HTTP request header, or include a hint
   * in the request's <code>Content-Type</code>. For example:
   * </p>
   *
   * <pre>
   * <code>Content-Type: application/json; artifactType=AVRO
  </code>
   * </pre>
   * <p>
   * An artifact is created using the content provided in the body of the request.
   * This content is created under a unique artifact ID that can be provided in
   * the request using the <code>X-Registry-ArtifactId</code> request header. If
   * not provided in the request, the server generates a unique ID for the
   * artifact. It is typically recommended that callers provide the ID, because
   * this is typically a meaningful identifier, and for most use cases should be
   * supplied by the caller.
   * </p>
   * <p>
   * If an artifact with the provided artifact ID already exists, the default
   * behavior is for the server to reject the content with a 409 error. However,
   * the caller can supply the <code>ifExists</code> query parameter to alter this
   * default behavior. The <code>ifExists</code> query parameter can have one of
   * the following values:
   * </p>
   * <ul>
   * <li><code>FAIL</code> (<em>default</em>) - server rejects the content with a
   * 409 error</li>
   * <li><code>UPDATE</code> - server updates the existing artifact and returns
   * the new metadata</li>
   * <li><code>RETURN</code> - server does not create or add content to the
   * server, but instead returns the metadata for the existing artifact</li>
   * <li><code>RETURN_OR_UPDATE</code> - server returns an existing
   * <strong>version</strong> that matches the provided content if such a version
   * exists, otherwise a new version is created</li>
   * </ul>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>An invalid <code>ArtifactType</code> was indicated (HTTP error
   * <code>400</code>)</li>
   * <li>No <code>ArtifactType</code> was indicated and the server could not
   * determine one from the content (HTTP error <code>400</code>)</li>
   * <li>Provided content (request body) was empty (HTTP error
   * <code>400</code>)</li>
   * <li>An artifact with the provided ID already exists (HTTP error
   * <code>409</code>)</li>
   * <li>The content violates one of the configured global rules (HTTP error
   * <code>409</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Creates a new artifact by posting the artifact content.  The body of the request should\nbe the raw content of the artifact.  This is typically in JSON format for *most* of the \nsupported types, but may be in another format for a few (for example, `PROTOBUF`).\n\nThe registry attempts to figure out what kind of artifact is being added from the\nfollowing supported list:\n\n* Avro (`AVRO`)\n* Protobuf (`PROTOBUF`)\n* JSON Schema (`JSON`)\n* Kafka Connect (`KCONNECT`)\n* OpenAPI (`OPENAPI`)\n* AsyncAPI (`ASYNCAPI`)\n* GraphQL (`GRAPHQL`)\n* Web Services Description Language (`WSDL`)\n* XML Schema (`XSD`)\n\nAlternatively, you can specify the artifact type using the `X-Registry-ArtifactType` \nHTTP request header, or include a hint in the request's `Content-Type`.  For example:\n\n```\nContent-Type: application/json; artifactType=AVRO\n```\n\nAn artifact is created using the content provided in the body of the request.  This\ncontent is created under a unique artifact ID that can be provided in the request\nusing the `X-Registry-ArtifactId` request header.  If not provided in the request,\nthe server generates a unique ID for the artifact.  It is typically recommended\nthat callers provide the ID, because this is typically a meaningful identifier, \nand for most use cases should be supplied by the caller.\n\nIf an artifact with the provided artifact ID already exists, the default behavior\nis for the server to reject the content with a 409 error.  However, the caller can\nsupply the `ifExists` query parameter to alter this default behavior. The `ifExists`\nquery parameter can have one of the following values:\n\n* `FAIL` (*default*) - server rejects the content with a 409 error\n* `UPDATE` - server updates the existing artifact and returns the new metadata\n* `RETURN` - server does not create or add content to the server, but instead \nreturns the metadata for the existing artifact\n* `RETURN_OR_UPDATE` - server returns an existing **version** that matches the \nprovided content if such a version exists, otherwise a new version is created\n\nThis operation may fail for one of the following reasons:\n\n* An invalid `ArtifactType` was indicated (HTTP error `400`)\n* No `ArtifactType` was indicated and the server could not determine one from the content (HTTP error `400`)\n* Provided content (request body) was empty (HTTP error `400`)\n* An artifact with the provided ID already exists (HTTP error `409`)\n* The content violates one of the configured global rules (HTTP error `409`)\n* A server error occurred (HTTP error `500`)\n", summary = "Create artifact", operationId = "createArtifact")
  @Path("/{groupId}/artifacts")
  @POST
  @Produces("application/json")
  @Consumes("*/*")
  ArtifactMetaData createArtifact(@PathParam("groupId") String groupId,
      @HeaderParam("X-Registry-ArtifactType") String xRegistryArtifactType,
      @HeaderParam("X-Registry-ArtifactId") String xRegistryArtifactId,
      @HeaderParam("X-Registry-Version") String xRegistryVersion, @QueryParam("ifExists") IfExists ifExists,
      @QueryParam("canonical") Boolean canonical, @HeaderParam("X-Registry-Description") String xRegistryDescription,
      @HeaderParam("X-Registry-Description-Encoded") String xRegistryDescriptionEncoded,
      @HeaderParam("X-Registry-Name") String xRegistryName,
      @HeaderParam("X-Registry-Name-Encoded") String xRegistryNameEncoded,
      @HeaderParam("X-Registry-Content-Hash") String xRegistryContentHash,
      @HeaderParam("X-Registry-Hash-Algorithm") String xRegistryHashAlgorithm, @NotNull InputStream data);

  /**
   * <p>
   * Creates a new artifact by posting the artifact content. The body of the
   * request should be the raw content of the artifact. This is typically in JSON
   * format for <em>most</em> of the supported types, but may be in another format
   * for a few (for example, <code>PROTOBUF</code>).
   * </p>
   * <p>
   * The registry attempts to figure out what kind of artifact is being added from
   * the following supported list:
   * </p>
   * <ul>
   * <li>Avro (<code>AVRO</code>)</li>
   * <li>Protobuf (<code>PROTOBUF</code>)</li>
   * <li>JSON Schema (<code>JSON</code>)</li>
   * <li>Kafka Connect (<code>KCONNECT</code>)</li>
   * <li>OpenAPI (<code>OPENAPI</code>)</li>
   * <li>AsyncAPI (<code>ASYNCAPI</code>)</li>
   * <li>GraphQL (<code>GRAPHQL</code>)</li>
   * <li>Web Services Description Language (<code>WSDL</code>)</li>
   * <li>XML Schema (<code>XSD</code>)</li>
   * </ul>
   * <p>
   * Alternatively, you can specify the artifact type using the
   * <code>X-Registry-ArtifactType</code> HTTP request header, or include a hint
   * in the request's <code>Content-Type</code>. For example:
   * </p>
   *
   * <pre>
   * <code>Content-Type: application/json; artifactType=AVRO
  </code>
   * </pre>
   * <p>
   * An artifact is created using the content provided in the body of the request.
   * This content is created under a unique artifact ID that can be provided in
   * the request using the <code>X-Registry-ArtifactId</code> request header. If
   * not provided in the request, the server generates a unique ID for the
   * artifact. It is typically recommended that callers provide the ID, because
   * this is typically a meaningful identifier, and for most use cases should be
   * supplied by the caller.
   * </p>
   * <p>
   * If an artifact with the provided artifact ID already exists, the default
   * behavior is for the server to reject the content with a 409 error. However,
   * the caller can supply the <code>ifExists</code> query parameter to alter this
   * default behavior. The <code>ifExists</code> query parameter can have one of
   * the following values:
   * </p>
   * <ul>
   * <li><code>FAIL</code> (<em>default</em>) - server rejects the content with a
   * 409 error</li>
   * <li><code>UPDATE</code> - server updates the existing artifact and returns
   * the new metadata</li>
   * <li><code>RETURN</code> - server does not create or add content to the
   * server, but instead returns the metadata for the existing artifact</li>
   * <li><code>RETURN_OR_UPDATE</code> - server returns an existing
   * <strong>version</strong> that matches the provided content if such a version
   * exists, otherwise a new version is created</li>
   * </ul>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>An invalid <code>ArtifactType</code> was indicated (HTTP error
   * <code>400</code>)</li>
   * <li>No <code>ArtifactType</code> was indicated and the server could not
   * determine one from the content (HTTP error <code>400</code>)</li>
   * <li>Provided content (request body) was empty (HTTP error
   * <code>400</code>)</li>
   * <li>An artifact with the provided ID already exists (HTTP error
   * <code>409</code>)</li>
   * <li>The content violates one of the configured global rules (HTTP error
   * <code>409</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Creates a new artifact by posting the artifact content.  The body of the request should\nbe the raw content of the artifact.  This is typically in JSON format for *most* of the \nsupported types, but may be in another format for a few (for example, `PROTOBUF`).\n\nThe registry attempts to figure out what kind of artifact is being added from the\nfollowing supported list:\n\n* Avro (`AVRO`)\n* Protobuf (`PROTOBUF`)\n* JSON Schema (`JSON`)\n* Kafka Connect (`KCONNECT`)\n* OpenAPI (`OPENAPI`)\n* AsyncAPI (`ASYNCAPI`)\n* GraphQL (`GRAPHQL`)\n* Web Services Description Language (`WSDL`)\n* XML Schema (`XSD`)\n\nAlternatively, you can specify the artifact type using the `X-Registry-ArtifactType` \nHTTP request header, or include a hint in the request's `Content-Type`.  For example:\n\n```\nContent-Type: application/json; artifactType=AVRO\n```\n\nAn artifact is created using the content provided in the body of the request.  This\ncontent is created under a unique artifact ID that can be provided in the request\nusing the `X-Registry-ArtifactId` request header.  If not provided in the request,\nthe server generates a unique ID for the artifact.  It is typically recommended\nthat callers provide the ID, because this is typically a meaningful identifier, \nand for most use cases should be supplied by the caller.\n\nIf an artifact with the provided artifact ID already exists, the default behavior\nis for the server to reject the content with a 409 error.  However, the caller can\nsupply the `ifExists` query parameter to alter this default behavior. The `ifExists`\nquery parameter can have one of the following values:\n\n* `FAIL` (*default*) - server rejects the content with a 409 error\n* `UPDATE` - server updates the existing artifact and returns the new metadata\n* `RETURN` - server does not create or add content to the server, but instead \nreturns the metadata for the existing artifact\n* `RETURN_OR_UPDATE` - server returns an existing **version** that matches the \nprovided content if such a version exists, otherwise a new version is created\n\nThis operation may fail for one of the following reasons:\n\n* An invalid `ArtifactType` was indicated (HTTP error `400`)\n* No `ArtifactType` was indicated and the server could not determine one from the content (HTTP error `400`)\n* Provided content (request body) was empty (HTTP error `400`)\n* An artifact with the provided ID already exists (HTTP error `409`)\n* The content violates one of the configured global rules (HTTP error `409`)\n* A server error occurred (HTTP error `500`)\n", summary = "Create artifact", operationId = "createArtifact")
  @Path("/{groupId}/artifacts")
  @POST
  @Produces("application/json")
  @Consumes({"application/vnd.create.extended+json", "application/create.extended+json"})
  ArtifactMetaData createArtifact(@PathParam("groupId") String groupId,
      @HeaderParam("X-Registry-ArtifactType") String xRegistryArtifactType,
      @HeaderParam("X-Registry-ArtifactId") String xRegistryArtifactId,
      @HeaderParam("X-Registry-Version") String xRegistryVersion, @QueryParam("ifExists") IfExists ifExists,
      @QueryParam("canonical") Boolean canonical, @HeaderParam("X-Registry-Description") String xRegistryDescription,
      @HeaderParam("X-Registry-Description-Encoded") String xRegistryDescriptionEncoded,
      @HeaderParam("X-Registry-Name") String xRegistryName,
      @HeaderParam("X-Registry-Name-Encoded") String xRegistryNameEncoded,
      @HeaderParam("X-Registry-Content-Hash") String xRegistryContentHash,
      @HeaderParam("X-Registry-Hash-Algorithm") String xRegistryHashAlgorithm, @NotNull ArtifactContent data);

  /**
   * <p>
   * Deletes all of the artifacts that exist in a given group.
   * </p>
   *
   */
  @Operation(description = "Deletes all of the artifacts that exist in a given group.", summary = "Delete artifacts in group", operationId = "deleteArtifactsInGroup")
  @Path("/{groupId}/artifacts")
  @DELETE
  void deleteArtifactsInGroup(@PathParam("groupId") String groupId);

  /**
   * <p>
   * Tests whether an update to the artifact's content <em>would</em> succeed for
   * the provided content. Ultimately, this applies any rules configured for the
   * artifact against the given content to determine whether the rules would pass
   * or fail, but without actually updating the artifact content.
   * </p>
   * <p>
   * The body of the request should be the raw content of the artifact. This is
   * typically in JSON format for <em>most</em> of the supported types, but may be
   * in another format for a few (for example, <code>PROTOBUF</code>).
   * </p>
   * <p>
   * The update could fail for a number of reasons including:
   * </p>
   * <ul>
   * <li>Provided content (request body) was empty (HTTP error
   * <code>400</code>)</li>
   * <li>No artifact with the <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>The new content violates one of the rules configured for the artifact
   * (HTTP error <code>409</code>)</li>
   * <li>The provided artifact type is not recognized (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   * <p>
   * When successful, this operation simply returns a <em>No Content</em>
   * response. This response indicates that the content is valid against the
   * configured content rules for the artifact (or the global rules if no artifact
   * rules are enabled).
   * </p>
   *
   */
  @Operation(description = "Tests whether an update to the artifact's content *would* succeed for the provided content.\nUltimately, this applies any rules configured for the artifact against the given content\nto determine whether the rules would pass or fail, but without actually updating the artifact\ncontent.\n\nThe body of the request should be the raw content of the artifact.  This is typically in \nJSON format for *most* of the supported types, but may be in another format for a few \n(for example, `PROTOBUF`).\n\nThe update could fail for a number of reasons including:\n\n* Provided content (request body) was empty (HTTP error `400`)\n* No artifact with the `artifactId` exists (HTTP error `404`)\n* The new content violates one of the rules configured for the artifact (HTTP error `409`)\n* The provided artifact type is not recognized (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n\nWhen successful, this operation simply returns a *No Content* response.  This response\nindicates that the content is valid against the configured content rules for the \nartifact (or the global rules if no artifact rules are enabled).", summary = "Test update artifact", operationId = "testUpdateArtifact")
  @Path("/{groupId}/artifacts/{artifactId}/test")
  @PUT
  @Consumes("*/*")
  void testUpdateArtifact(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @NotNull InputStream data);

  /**
   * <p>
   * Returns a list of all versions of the artifact. The result set is paged.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns a list of all versions of the artifact.  The result set is paged.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "List artifact versions", operationId = "listArtifactVersions")
  @Path("/{groupId}/artifacts/{artifactId}/versions")
  @GET
  @Produces("application/json")
  VersionSearchResults listArtifactVersions(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @QueryParam("offset") BigInteger offset,
      @QueryParam("limit") BigInteger limit);

  /**
   * <p>
   * Creates a new version of the artifact by uploading new content. The
   * configured rules for the artifact are applied, and if they all pass, the new
   * content is added as the most recent version of the artifact. If any of the
   * rules fail, an error is returned.
   * </p>
   * <p>
   * The body of the request can be the raw content of the new artifact version,
   * or the raw content and a set of references pointing to other artifacts, and
   * the type of that content should match the artifact's type (for example if the
   * artifact type is <code>AVRO</code> then the content of the request should be
   * an Apache Avro document).
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>Provided content (request body) was empty (HTTP error
   * <code>400</code>)</li>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>The new content violates one of the rules configured for the artifact
   * (HTTP error <code>409</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Creates a new version of the artifact by uploading new content.  The configured rules for\nthe artifact are applied, and if they all pass, the new content is added as the most recent \nversion of the artifact.  If any of the rules fail, an error is returned.\n\nThe body of the request can be the raw content of the new artifact version, or the raw content \nand a set of references pointing to other artifacts, and the type\nof that content should match the artifact's type (for example if the artifact type is `AVRO`\nthen the content of the request should be an Apache Avro document).\n\nThis operation can fail for the following reasons:\n\n* Provided content (request body) was empty (HTTP error `400`)\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* The new content violates one of the rules configured for the artifact (HTTP error `409`)\n* A server error occurred (HTTP error `500`)\n", summary = "Create artifact version", operationId = "createArtifactVersion")
  @Path("/{groupId}/artifacts/{artifactId}/versions")
  @POST
  @Produces("application/json")
  @Consumes("*/*")
  VersionMetaData createArtifactVersion(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @HeaderParam("X-Registry-Version") String xRegistryVersion,
      @HeaderParam("X-Registry-Name") String xRegistryName,
      @HeaderParam("X-Registry-Description") String xRegistryDescription,
      @HeaderParam("X-Registry-Description-Encoded") String xRegistryDescriptionEncoded,
      @HeaderParam("X-Registry-Name-Encoded") String xRegistryNameEncoded, @NotNull InputStream data);

  /**
   * <p>
   * Creates a new version of the artifact by uploading new content. The
   * configured rules for the artifact are applied, and if they all pass, the new
   * content is added as the most recent version of the artifact. If any of the
   * rules fail, an error is returned.
   * </p>
   * <p>
   * The body of the request can be the raw content of the new artifact version,
   * or the raw content and a set of references pointing to other artifacts, and
   * the type of that content should match the artifact's type (for example if the
   * artifact type is <code>AVRO</code> then the content of the request should be
   * an Apache Avro document).
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>Provided content (request body) was empty (HTTP error
   * <code>400</code>)</li>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>The new content violates one of the rules configured for the artifact
   * (HTTP error <code>409</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Creates a new version of the artifact by uploading new content.  The configured rules for\nthe artifact are applied, and if they all pass, the new content is added as the most recent \nversion of the artifact.  If any of the rules fail, an error is returned.\n\nThe body of the request can be the raw content of the new artifact version, or the raw content \nand a set of references pointing to other artifacts, and the type\nof that content should match the artifact's type (for example if the artifact type is `AVRO`\nthen the content of the request should be an Apache Avro document).\n\nThis operation can fail for the following reasons:\n\n* Provided content (request body) was empty (HTTP error `400`)\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* The new content violates one of the rules configured for the artifact (HTTP error `409`)\n* A server error occurred (HTTP error `500`)\n", summary = "Create artifact version", operationId = "createArtifactVersion")
  @Path("/{groupId}/artifacts/{artifactId}/versions")
  @POST
  @Produces("application/json")
  @Consumes({"application/vnd.create.extended+json", "application/create.extended+json"})
  VersionMetaData createArtifactVersion(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @HeaderParam("X-Registry-Version") String xRegistryVersion,
      @HeaderParam("X-Registry-Name") String xRegistryName,
      @HeaderParam("X-Registry-Description") String xRegistryDescription,
      @HeaderParam("X-Registry-Description-Encoded") String xRegistryDescriptionEncoded,
      @HeaderParam("X-Registry-Name-Encoded") String xRegistryNameEncoded, @NotNull ArtifactContent data);

  /**
   * <p>
   * Gets the owner of an artifact in the registry.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets the owner of an artifact in the registry.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)", summary = "Get artifact owner", operationId = "getArtifactOwner")
  @Path("/{groupId}/artifacts/{artifactId}/owner")
  @GET
  @Produces("application/json")
  ArtifactOwner getArtifactOwner(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId);

  /**
   * <p>
   * Changes the ownership of an artifact.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Changes the ownership of an artifact.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)", summary = "Update artifact owner", operationId = "updateArtifactOwner")
  @Path("/{groupId}/artifacts/{artifactId}/owner")
  @PUT
  @Consumes("application/json")
  void updateArtifactOwner(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @NotNull ArtifactOwner data);

  /**
   * <p>
   * Returns a group using the specified id.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No group exists with the specified ID (HTTP error <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns a group using the specified id.\n\nThis operation can fail for the following reasons:\n\n* No group exists with the specified ID (HTTP error `404`)\n* A server error occurred (HTTP error `500`)", summary = "Get a group by the specified ID.", operationId = "getGroupById")
  @Path("/{groupId}")
  @GET
  @Produces("application/json")
  GroupMetaData getGroupById(@PathParam("groupId") String groupId);

  /**
   * <p>
   * Deletes a group by identifier.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * <li>The group does not exist (HTTP error <code>404</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes a group by identifier.\n\nThis operation can fail for the following reasons:\n\n* A server error occurred (HTTP error `500`)\n* The group does not exist (HTTP error `404`)\n", summary = "Delete a group by the specified ID.", operationId = "deleteGroupById")
  @Path("/{groupId}")
  @DELETE
  void deleteGroupById(@PathParam("groupId") String groupId);

  /**
   * <p>
   * Returns a list of all groups. This list is paged.
   * </p>
   *
   */
  @Operation(description = "Returns a list of all groups.  This list is paged.", summary = "List groups", operationId = "listGroups")
  @GET
  @Produces("application/json")
  GroupSearchResults listGroups(@QueryParam("limit") BigInteger limit, @QueryParam("offset") BigInteger offset,
      @QueryParam("order") SortOrder order, @QueryParam("orderby") SortBy orderby);

  /**
   * <p>
   * Creates a new group.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * <li>The group already exist (HTTP error <code>409</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Creates a new group.\n\nThis operation can fail for the following reasons:\n\n* A server error occurred (HTTP error `500`)\n* The group already exist (HTTP error `409`)\n", summary = "Create a new group", operationId = "createGroup")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  GroupMetaData createGroup(@NotNull CreateGroupMetaData data);

  /**
   * <p>
   * Gets the metadata for an artifact in the registry, based on the latest
   * version. If the latest version of the artifact is marked as
   * <code>DISABLED</code>, the next available non-disabled version will be used.
   * The returned metadata includes both generated (read-only) and editable
   * metadata (such as name and description).
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists or all versions are
   * <code>DISABLED</code> (HTTP error <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets the metadata for an artifact in the registry, based on the latest version. If the latest version of the artifact is marked as `DISABLED`, the next available non-disabled version will be used. The returned metadata includes\nboth generated (read-only) and editable metadata (such as name and description).\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists  or all versions are `DISABLED` (HTTP error `404`)\n* A server error occurred (HTTP error `500`)", summary = "Get artifact metadata", operationId = "getArtifactMetaData")
  @Path("/{groupId}/artifacts/{artifactId}/meta")
  @GET
  @Produces("application/json")
  ArtifactMetaData getArtifactMetaData(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId);

  /**
   * <p>
   * Updates the editable parts of the artifact's metadata. Not all metadata
   * fields can be updated. For example, <code>createdOn</code> and
   * <code>createdBy</code> are both read-only properties.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with the <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Updates the editable parts of the artifact's metadata.  Not all metadata fields can\nbe updated.  For example, `createdOn` and `createdBy` are both read-only properties.\n\nThis operation can fail for the following reasons:\n\n* No artifact with the `artifactId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)", summary = "Update artifact metadata", operationId = "updateArtifactMetaData")
  @Path("/{groupId}/artifacts/{artifactId}/meta")
  @PUT
  @Consumes("application/json")
  void updateArtifactMetaData(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @NotNull EditableMetaData data);

  /**
   * <p>
   * Gets the metadata for an artifact that matches the raw content. Searches the
   * registry for a version of the given artifact matching the content provided in
   * the body of the POST.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>Provided content (request body) was empty (HTTP error
   * <code>400</code>)</li>
   * <li>No artifact with the <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No artifact version matching the provided content exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets the metadata for an artifact that matches the raw content.  Searches the registry\nfor a version of the given artifact matching the content provided in the body of the\nPOST.\n\nThis operation can fail for the following reasons:\n\n* Provided content (request body) was empty (HTTP error `400`)\n* No artifact with the `artifactId` exists (HTTP error `404`)\n* No artifact version matching the provided content exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get artifact version metadata by content", operationId = "getArtifactVersionMetaDataByContent")
  @Path("/{groupId}/artifacts/{artifactId}/meta")
  @POST
  @Produces("application/json")
  @Consumes("*/*")
  VersionMetaData getArtifactVersionMetaDataByContent(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @QueryParam("canonical") Boolean canonical,
      @NotNull InputStream data);

  /**
   * <p>
   * Gets the metadata for an artifact that matches the raw content. Searches the
   * registry for a version of the given artifact matching the content provided in
   * the body of the POST.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>Provided content (request body) was empty (HTTP error
   * <code>400</code>)</li>
   * <li>No artifact with the <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No artifact version matching the provided content exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets the metadata for an artifact that matches the raw content.  Searches the registry\nfor a version of the given artifact matching the content provided in the body of the\nPOST.\n\nThis operation can fail for the following reasons:\n\n* Provided content (request body) was empty (HTTP error `400`)\n* No artifact with the `artifactId` exists (HTTP error `404`)\n* No artifact version matching the provided content exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get artifact version metadata by content", operationId = "getArtifactVersionMetaDataByContent")
  @Path("/{groupId}/artifacts/{artifactId}/meta")
  @POST
  @Produces("application/json")
  @Consumes({"application/vnd.get.extended+json", "application/get.extended+json"})
  VersionMetaData getArtifactVersionMetaDataByContent(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @QueryParam("canonical") Boolean canonical,
      @NotNull ArtifactContent data);

  /**
   * <p>
   * Retrieves all comments for a version of an artifact. Both the
   * <code>artifactId</code> and the unique <code>version</code> number must be
   * provided.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Retrieves all comments for a version of an artifact.  Both the `artifactId` and the\nunique `version` number must be provided.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get artifact version comments", operationId = "getArtifactVersionComments")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/comments")
  @GET
  @Produces("application/json")
  List<Comment> getArtifactVersionComments(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @PathParam("version") String version);

  /**
   * <p>
   * Adds a new comment to the artifact version. Both the <code>artifactId</code>
   * and the unique <code>version</code> number must be provided.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Adds a new comment to the artifact version.  Both the `artifactId` and the\nunique `version` number must be provided.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Add new comment", operationId = "addArtifactVersionComment")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Comment addArtifactVersionComment(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("version") String version, @NotNull NewComment data);

  /**
   * <p>
   * Updates the value of a single comment in an artifact version. Only the owner
   * of the comment can modify it. The <code>artifactId</code>, unique
   * <code>version</code> number, and <code>commentId</code> must be provided.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No comment with this <code>commentId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Updates the value of a single comment in an artifact version.  Only the owner of the\ncomment can modify it.  The `artifactId`, unique `version` number, and `commentId` \nmust be provided.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n* No comment with this `commentId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Update a comment", operationId = "updateArtifactVersionComment")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/comments/{commentId}")
  @PUT
  @Consumes("application/json")
  void updateArtifactVersionComment(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("version") String version, @PathParam("commentId") String commentId, @NotNull NewComment data);

  /**
   * <p>
   * Deletes a single comment in an artifact version. Only the owner of the
   * comment can delete it. The <code>artifactId</code>, unique
   * <code>version</code> number, and <code>commentId</code> must be provided.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No version with this <code>version</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>No comment with this <code>commentId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes a single comment in an artifact version.  Only the owner of the\ncomment can delete it.  The `artifactId`, unique `version` number, and `commentId` \nmust be provided.\n\nThis operation can fail for the following reasons:\n\n* No artifact with this `artifactId` exists (HTTP error `404`)\n* No version with this `version` exists (HTTP error `404`)\n* No comment with this `commentId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Delete a single comment", operationId = "deleteArtifactVersionComment")
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/comments/{commentId}")
  @DELETE
  void deleteArtifactVersionComment(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("version") String version, @PathParam("commentId") String commentId);
}
