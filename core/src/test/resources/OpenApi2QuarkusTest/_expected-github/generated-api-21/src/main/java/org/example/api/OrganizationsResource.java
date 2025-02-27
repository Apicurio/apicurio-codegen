package org.example.api;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.math.BigInteger;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/organizations")
public interface OrganizationsResource {
  /**
   * <p>
   * Lists all organizations, in the order that they were created on GitHub.
   * </p>
   * <p>
   * <strong>Note:</strong> Pagination is powered exclusively by the
   * <code>since</code> parameter. Use the
   * <a href="https://developer.github.com/v3/#link-header">Link header</a> to get
   * the URL for the next page of organizations.
   * </p>
   *
   */
  @Operation(description = "Lists all organizations, in the order that they were created on GitHub.\n\n**Note:** Pagination is powered exclusively by the `since` parameter. Use the [Link header](https://developer.github.com/v3/#link-header) to get the URL for the next page of organizations.", summary = "List organizations", operationId = "orgs/list")
  @GET
  @Produces("application/json")
  Response orgs_list(@QueryParam("since") String since, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage);
}
