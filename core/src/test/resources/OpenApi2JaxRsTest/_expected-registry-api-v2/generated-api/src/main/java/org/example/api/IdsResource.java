package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

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
  @Path("/contentHashes/{contentHash}/")
  @GET
  @Produces("*/*")
  Response getContentByHash(@PathParam("contentHash") long contentHash, @QueryParam("canonical") Boolean canonical);
}
