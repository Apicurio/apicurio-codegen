package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletionStage;
import org.example.api.beans.CreateGCPSourceRequest;
import org.example.api.beans.Instance;
import org.example.api.beans.PaginatedSearchInstancesRequest;
import org.example.api.beans.PaginatedSearchInstancesResponse;
import org.example.api.beans.Source;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/v1")
public interface V1Resource {
  /**
   * <p>
   * Return a list of all sources.
   * </p>
   *
   */
  @Path("/{org_id}/sources")
  @GET
  @Produces("application/json")
  CompletionStage<List<Source>> list_sources(@PathParam("org_id") String orgId);

  /**
   * <p>
   * Create or update the source identified by a unique ID in the body, parsed by
   * its source type (currently only accepts a service account key for GCP).
   * </p>
   *
   */
  @Path("/{org_id}/sources/gcp")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  CompletionStage<Source> create_gcp_source(@PathParam("org_id") String orgId, @NotNull CreateGCPSourceRequest data);

  @Path("/{org_id}/sources/gcp/{source_id}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  CompletionStage<Source> put_gcp_source(@PathParam("org_id") String orgId, @PathParam("source_id") String sourceId,
      @NotNull CreateGCPSourceRequest data);

  @Path("/{org_id}/sources/{source_id}")
  @GET
  @Produces("application/json")
  CompletionStage<Source> getSource(@PathParam("org_id") String orgId, @PathParam("source_id") String sourceId);

  @Path("/{org_id}/sources/{source_id}")
  @DELETE
  CompletionStage<Void> delete_source(@PathParam("org_id") String orgId, @PathParam("source_id") String sourceId);

  /**
   * <p>
   * Synchronize available instances from the given source.
   * </p>
   *
   */
  @Path("/{org_id}/sources/{source_id}:sync")
  @POST
  CompletionStage<Void> sync_source(@PathParam("org_id") String orgId, @PathParam("source_id") String sourceId);

  /**
   * <p>
   * Search for instances based on a set of filters. Supports pagination based on
   * instance ID cursor. Results are ordered by creation timestamp.
   * </p>
   *
   */
  @Path("/{org_id}/search")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  CompletionStage<PaginatedSearchInstancesResponse> search_instances(@PathParam("org_id") String orgId,
      @QueryParam("page_offset") BigInteger pageOffset, @QueryParam("page_size") BigInteger pageSize,
      @NotNull PaginatedSearchInstancesRequest data);

  /**
   * <p>
   * Get instance details.
   * </p>
   *
   */
  @Path("/{org_id}/instance/{instance_id}")
  @GET
  @Produces("application/json")
  CompletionStage<Instance> get_instance(@PathParam("org_id") String orgId,
      @PathParam("instance_id") String instanceId);

  /**
   * <p>
   * Get the total number of instances in an organization
   * </p>
   *
   */
  @Path("/{org_id}/instances/count")
  @GET
  @Produces("application/json")
  CompletionStage<Long> get_org_instance_count(@PathParam("org_id") String orgId);
}
