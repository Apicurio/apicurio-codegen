package org.example.api;

import io.apicurio.registry.types.RuleType;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.Rule;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/rules")
public interface RulesResource {
  /**
   * <p>
   * Returns information about the named globally configured rule.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>Invalid rule name/type (HTTP error <code>400</code>)</li>
   * <li>No rule with name/type <code>rule</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Returns information about the named globally configured rule.\n\nThis operation can fail for the following reasons:\n\n* Invalid rule name/type (HTTP error `400`)\n* No rule with name/type `rule` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Get Global Rule Config", operationId = "getGlobalRuleConfig")
  @Path("/{rule}")
  @GET
  @Produces("application/json")
  Rule getGlobalRuleConfig(@PathParam("rule") String rule);

  /**
   * <p>
   * Updates the configuration for a globally configured rule.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>Invalid rule name/type (HTTP error <code>400</code>)</li>
   * <li>No rule with name/type <code>rule</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Updates the configuration for a globally configured rule.\n\nThis operation can fail for the following reasons:\n\n* Invalid rule name/type (HTTP error `400`)\n* No rule with name/type `rule` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Update Global Rule Config", operationId = "updateGlobalRuleConfig")
  @Path("/{rule}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Rule updateGlobalRuleConfig(@PathParam("rule") String rule, @NotNull Rule data);

  /**
   * <p>
   * Deletes a single global rule. If this is the only rule configured, this is
   * the same as deleting <strong>all</strong> rules.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>Invalid rule name/type (HTTP error <code>400</code>)</li>
   * <li>No rule with name/type <code>rule</code> exists (HTTP error
   * <code>404</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes a single global rule.  If this is the only rule configured, this is the same\nas deleting **all** rules.\n\nThis operation can fail for the following reasons:\n\n* Invalid rule name/type (HTTP error `400`)\n* No rule with name/type `rule` exists (HTTP error `404`)\n* A server error occurred (HTTP error `500`)\n", summary = "Delete Global Rule", operationId = "deleteGlobalRule")
  @Path("/{rule}")
  @DELETE
  void deleteGlobalRule(@PathParam("rule") String rule);

  /**
   * <p>
   * Gets a list of all the currently configured global rules (if any).
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Gets a list of all the currently configured global rules (if any).\n\nThis operation can fail for the following reasons:\n\n* A server error occurred (HTTP error `500`)\n", summary = "List Global Rules", operationId = "listGlobalRules")
  @GET
  @Produces("application/json")
  List<RuleType> listGlobalRules();

  /**
   * <p>
   * Adds a rule to the list of globally configured rules.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>The rule type is unknown (HTTP error <code>400</code>)</li>
   * <li>The rule already exists (HTTP error <code>409</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Adds a rule to the list of globally configured rules.\n\nThis operation can fail for the following reasons:\n\n* The rule type is unknown (HTTP error `400`)\n* The rule already exists (HTTP error `409`)\n* A server error occurred (HTTP error `500`)\n", summary = "Create Global Rule", operationId = "createGlobalRule")
  @POST
  @Consumes("application/json")
  void createGlobalRule(@NotNull Rule data);

  /**
   * <p>
   * Deletes all globally configured rules.
   * </p>
   * <p>
   * This operation can fail for the following reasons:
   * </p>
   * <ul>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   *
   */
  @Operation(description = "Deletes all globally configured rules.\n\nThis operation can fail for the following reasons:\n\n* A server error occurred (HTTP error `500`)\n", summary = "Delete All Global Rules", operationId = "deleteAllGlobalRules")
  @DELETE
  void deleteAllGlobalRules();
}
