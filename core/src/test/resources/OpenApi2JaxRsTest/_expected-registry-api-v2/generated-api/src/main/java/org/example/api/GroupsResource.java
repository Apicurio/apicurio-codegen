package org.example.api;

import io.apicurio.registry.types.ArtifactType;
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
import java.util.concurrent.CompletionStage;
import org.example.api.beans.ArtifactMetaData;
import org.example.api.beans.ArtifactSearchResults;
import org.example.api.beans.EditableMetaData;
import org.example.api.beans.IfExists;
import org.example.api.beans.Rule;
import org.example.api.beans.SortBy;
import org.example.api.beans.SortOrder;
import org.example.api.beans.UpdateState;
import org.example.api.beans.VersionMetaData;
import org.example.api.beans.VersionSearchResults;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/v2/groups")
public interface GroupsResource {
  /**
   * <p>
   * Returns the latest version of the artifact in its raw form. The
   * <code>Content-Type</code> of the response depends on the artifact type. In
   * most cases, this is <code>application/json</code>, but for some types it may
   * be different (for example, <code>PROTOBUF</code>).
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>No artifact with this <code>artifactId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   * 
   */
  @Path("/{groupId}/artifacts/{artifactId}")
  @GET
  @Produces({"application/json", "application/graphql", "application/x-protobuf", "application/x-protobuffer"})
  Response getLatestArtifact(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId);

  /**
   * <p>
   * Updates an artifact by uploading new content. The body of the request should
   * be the raw content of the artifact. This is typically in JSON format for
   * <em>most</em> of the supported types, but may be in another format for a few
   * (for example, <code>PROTOBUF</code>). The type of the content should be
   * compatible with the artifact's type (it would be an error to update an
   * <code>AVRO</code> artifact with new <code>OPENAPI</code> content, for
   * example).
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
  @Path("/{groupId}/artifacts/{artifactId}")
  @PUT
  @Produces("application/json")
  @Consumes("*/*")
  CompletionStage<ArtifactMetaData> updateArtifact(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @NotNull InputStream data);

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
  @Path("/{groupId}/artifacts/{artifactId}")
  @DELETE
  void deleteArtifact(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId);

  /**
   * <p>
   * Gets the metadata for an artifact in the registry. The returned metadata
   * includes both generated (read-only) and editable metadata (such as name and
   * description).
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
  @Path("/{groupId}/artifacts/{artifactId}/meta")
  @PUT
  @Consumes("*/*")
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
  @Path("/{groupId}/artifacts/{artifactId}/meta")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  VersionMetaData getArtifactVersionMetaDataByContent(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @QueryParam("canonical") Boolean canonical,
      @NotNull InputStream data);

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
  @Path("/{groupId}/artifacts/{artifactId}/rules/{rule}")
  @DELETE
  void deleteArtifactRule(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("rule") RuleType rule);

  /**
   * <p>
   * Updates the state of the artifact. For example, you can use this to mark the
   * latest version of an artifact as <code>DEPRECATED</code>. The operation
   * changes the state of the latest version of the artifact. If multiple versions
   * exist, only the most recent is changed.
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
  @Path("/{groupId}/artifacts/{artifactId}/state")
  @PUT
  @Consumes("application/json")
  void updateArtifactState(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @NotNull UpdateState data);

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
  @Path("/{groupId}/artifacts/{artifactId}/test")
  @PUT
  @Consumes("*/*")
  void testUpdateArtifact(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @NotNull InputStream data);

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
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}")
  @GET
  @Produces({"application/json", "application/graphql", "application/x-protobuf", "application/x-protobuffer"})
  Response getArtifactVersion(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("version") String version);

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
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/meta")
  @DELETE
  void deleteArtifactVersionMetaData(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
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
  @Path("/{groupId}/artifacts/{artifactId}/versions/{version}/state")
  @PUT
  @Consumes("application/json")
  void updateArtifactVersionState(@PathParam("groupId") String groupId, @PathParam("artifactId") String artifactId,
      @PathParam("version") String version, @NotNull UpdateState data);

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
   * The body of the request should be the raw content of the new artifact
   * version, and the type of that content should match the artifact's type (for
   * example if the artifact type is <code>AVRO</code> then the content of the
   * request should be an Apache Avro document).
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
  @Path("/{groupId}/artifacts/{artifactId}/versions")
  @POST
  @Produces("application/json")
  @Consumes("*/*")
  CompletionStage<VersionMetaData> createArtifactVersion(@PathParam("groupId") String groupId,
      @PathParam("artifactId") String artifactId, @HeaderParam("X-Registry-Version") String xRegistryVersion,
      @NotNull InputStream data);

  /**
   * <p>
   * Returns a list of all artifacts in the group. This list is paged.
   * </p>
   * 
   */
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
   * <li>Protobuf File Descriptor (<code>PROTOBUF_FD</code>)</li>
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
  @Path("/{groupId}/artifacts")
  @POST
  @Produces("application/json")
  @Consumes("*/*")
  CompletionStage<ArtifactMetaData> createArtifact(@PathParam("groupId") String groupId,
      @HeaderParam("X-Registry-ArtifactType") ArtifactType xRegistryArtifactType,
      @HeaderParam("X-Registry-ArtifactId") String xRegistryArtifactId,
      @HeaderParam("X-Registry-Version") String xRegistryVersion, @QueryParam("ifExists") IfExists ifExists,
      @QueryParam("canonical") Boolean canonical, @NotNull InputStream data);

  /**
   * <p>
   * Deletes all of the artifacts that exist in a given group.
   * </p>
   * 
   */
  @Path("/{groupId}/artifacts")
  @DELETE
  void deleteArtifactsInGroup(@PathParam("groupId") String groupId);
}
