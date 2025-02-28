package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/v2/ids")
public interface IdsResource {
  /**
   * <p>
   * Gets the content for an artifact version in the registry using the unique
   * content identifier for that content. This content ID may be shared by
   * multiple artifact versions in the case where the artifact versions are
   * identical.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>No content with this <code>contentId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets the content for an artifact version in the registry using the unique content\nidentifier for that content.  This content ID may be shared by multiple artifact\nversions in the case where the artifact versions are identical.\n\nThis operation may fail for one of the following reasons:\n\n* No content with this `contentId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get artifact content by ID", operationId = "getContentById")
  @Path("/contentIds/{contentId}/")
  @GET
  @Produces({"application/json", "application/x-protobuf", "application/x-protobuffer"})
  Response getContentById(@PathParam("contentId") long contentId);

  /**
   * <p>
   * Gets the content for an artifact version in the registry using its globally
   * unique identifier.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>No artifact version with this <code>globalId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets the content for an artifact version in the registry using its globally unique\nidentifier.\n\nThis operation may fail for one of the following reasons:\n\n* No artifact version with this `globalId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get artifact by global ID", operationId = "getContentByGlobalId")
  @Path("/globalIds/{globalId}")
  @GET
  @Produces({"application/json", "application/x-protobuf", "application/x-protobuffer"})
  Response getContentByGlobalId(@PathParam("globalId") long globalId);

  /**
   * <p>
   * Gets the content for an artifact version in the registry using the unique
   * content identifier for that content. This content ID may be shared by
   * multiple artifact versions in the case where the artifact versions are
   * identical.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>No content with this <code>contentId</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets the content for an artifact version in the registry using the unique content\nidentifier for that content.  This content ID may be shared by multiple artifact\nversions in the case where the artifact versions are identical.\n\nThis operation may fail for one of the following reasons:\n\n* No content with this `contentId` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get artifact content by SHA-256 hash", operationId = "getContentByHash")
  @Path("/contentHashes/{contentHash}/")
  @GET
  @Produces("*/*")
  Response getContentByHash(@PathParam("contentHash") long contentHash, @QueryParam("canonical") Boolean canonical);
}
