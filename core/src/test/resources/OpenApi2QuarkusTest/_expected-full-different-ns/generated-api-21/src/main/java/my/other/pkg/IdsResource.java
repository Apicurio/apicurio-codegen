package my.other.pkg;

import io.apicurio.registry.types.ReferenceType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.util.List;
import my.other.pkg.beans.ArtifactReference;
import my.other.pkg.beans.HandleReferencesType;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/apis/registry/v2/ids")
public interface IdsResource {
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
  @Produces("*/*")
  Response getContentByGlobalId(@PathParam("globalId") long globalId,
      @QueryParam("references") HandleReferencesType references);

  /**
   * <p>
   * Returns a list containing all the artifact references using the artifact
   * content hash.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns a list containing all the artifact references using the artifact content hash.\n\nThis operation may fail for one of the following reasons:\n\n* A server error occurred (HTTP error `500`)\n", summary = "List artifact references by hash", operationId = "referencesByContentHash")
  @Path("/contentHashes/{contentHash}/references")
  @GET
  @Produces("application/json")
  List<ArtifactReference> referencesByContentHash(@PathParam("contentHash") String contentHash);

  /**
   * <p>
   * Returns a list containing all the artifact references using the artifact
   * content ID.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns a list containing all the artifact references using the artifact content ID.\n\nThis operation may fail for one of the following reasons:\n\n* A server error occurred (HTTP error `500`)", summary = "List artifact references by content ID", operationId = "referencesByContentId")
  @Path("/contentIds/{contentId}/references")
  @GET
  @Produces("application/json")
  List<ArtifactReference> referencesByContentId(@PathParam("contentId") long contentId);

  /**
   * <p>
   * Returns a list containing all the artifact references using the artifact
   * global ID.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns a list containing all the artifact references using the artifact global ID.\n\nThis operation may fail for one of the following reasons:\n\n* A server error occurred (HTTP error `500`)", summary = "List artifact references by global ID", operationId = "referencesByGlobalId")
  @Path("/globalIds/{globalId}/references")
  @GET
  @Produces("application/json")
  List<ArtifactReference> referencesByGlobalId(@PathParam("globalId") long globalId,
      @QueryParam("refType") ReferenceType refType);

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
  @Produces("*/*")
  Response getContentById(@PathParam("contentId") long contentId);

  /**
   * <p>
   * Gets the content for an artifact version in the registry using the SHA-256
   * hash of the content. This content hash may be shared by multiple artifact
   * versions in the case where the artifact versions have identical content.
   * </p>
   * <p>
   * This operation may fail for one of the following reasons:
   * </p>
   * <ul>
   * <li>No content with this <code>contentHash</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets the content for an artifact version in the registry using the \nSHA-256 hash of the content.  This content hash may be shared by multiple artifact\nversions in the case where the artifact versions have identical content.\n\nThis operation may fail for one of the following reasons:\n\n* No content with this `contentHash` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get artifact content by SHA-256 hash", operationId = "getContentByHash")
  @Path("/contentHashes/{contentHash}/")
  @GET
  @Produces("*/*")
  Response getContentByHash(@PathParam("contentHash") String contentHash);
}
