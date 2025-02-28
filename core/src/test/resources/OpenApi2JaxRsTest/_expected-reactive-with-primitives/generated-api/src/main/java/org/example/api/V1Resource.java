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
import org.eclipse.microprofile.openapi.annotations.Operation;
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
  @Operation(description = "Return a list of all sources.", summary = "Get sources", operationId = "list-sources")
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
  @Operation(description = "Create or update the source identified by a unique ID in the body, parsed by its source type (currently only accepts a service account key for GCP).", summary = "Create or update source", operationId = "create-gcp-source")
  @Path("/{org_id}/sources/gcp")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  CompletionStage<Source> create_gcp_source(@PathParam("org_id") String orgId, @NotNull CreateGCPSourceRequest data);

  @Operation(summary = "Put GCP Source", operationId = "put-gcp-source")
  @Path("/{org_id}/sources/gcp/{source_id}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  CompletionStage<Source> put_gcp_source(@PathParam("org_id") String orgId, @PathParam("source_id") String sourceId,
      @NotNull CreateGCPSourceRequest data);

  @Operation(summary = "Get Source", operationId = "getSource")
  @Path("/{org_id}/sources/{source_id}")
  @GET
  @Produces("application/json")
  CompletionStage<Source> getSource(@PathParam("org_id") String orgId, @PathParam("source_id") String sourceId);

  @Operation(summary = "Delete source", operationId = "delete-source")
  @Path("/{org_id}/sources/{source_id}")
  @DELETE
  CompletionStage<Void> delete_source(@PathParam("org_id") String orgId, @PathParam("source_id") String sourceId);

  /**
   * <p>
   * Synchronize available instances from the given source.
   * </p>
   *
   */
  @Operation(description = "Synchronize available instances from the given source.", summary = "Sync a source", operationId = "sync-source")
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
  @Operation(description = "Search for instances based on a set of filters. Supports pagination based on instance ID cursor. Results are ordered by creation timestamp.", summary = "Search instances", operationId = "search-instances")
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
  @Operation(description = "Get instance details.", summary = "Get instance details", operationId = "get-instance")
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
  @Operation(description = "Get the total number of instances in an organization", summary = "Get Org Instance Count", operationId = "get-org-instance-count")
  @Path("/{org_id}/instances/count")
  @GET
  @Produces("application/json")
  CompletionStage<Long> get_org_instance_count(@PathParam("org_id") String orgId);
}