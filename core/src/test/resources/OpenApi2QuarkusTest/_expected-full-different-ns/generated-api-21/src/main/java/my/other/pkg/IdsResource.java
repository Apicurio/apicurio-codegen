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
  @Path("/contentHashes/{contentHash}/")
  @GET
  @Produces("*/*")
  Response getContentByHash(@PathParam("contentHash") String contentHash);
}
