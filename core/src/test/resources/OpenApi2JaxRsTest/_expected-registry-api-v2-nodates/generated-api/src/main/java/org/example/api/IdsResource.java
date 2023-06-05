package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/v2/ids")
public interface IdsResource {
  /**
   * Gets the content for an artifact version in the registry using the unique content
   * identifier for that content.  This content ID may be shared by multiple artifact
   * versions in the case where the artifact versions are identical.
   *
   * This operation may fail for one of the following reasons:
   *
   * * No content with this `contentId` exists (HTTP error `404`)
   * * A server error occurred (HTTP error `500`)
   *
   */
  @Path("/contentIds/{contentId}/")
  @GET
  @Produces({"application/json", "application/x-protobuf", "application/x-protobuffer"})
  Response getContentById(@PathParam("contentId") long contentId);

  /**
   * Gets the content for an artifact version in the registry using its globally unique
   * identifier.
   *
   * This operation may fail for one of the following reasons:
   *
   * * No artifact version with this `globalId` exists (HTTP error `404`)
   * * A server error occurred (HTTP error `500`)
   *
   */
  @Path("/globalIds/{globalId}")
  @GET
  @Produces({"application/json", "application/x-protobuf", "application/x-protobuffer"})
  Response getContentByGlobalId(@PathParam("globalId") long globalId);

  /**
   * Gets the content for an artifact version in the registry using the unique content
   * identifier for that content.  This content ID may be shared by multiple artifact
   * versions in the case where the artifact versions are identical.
   *
   * This operation may fail for one of the following reasons:
   *
   * * No content with this `contentId` exists (HTTP error `404`)
   * * A server error occurred (HTTP error `500`)
   *
   */
  @Path("/contentHashes/{contentHash}/")
  @GET
  @Produces("*/*")
  Response getContentByHash(@PathParam("contentHash") long contentHash,
      @QueryParam("canonical") Boolean canonical);
}
