package org.example.api;

import io.apicurio.registry.types.RuleType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.List;
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
  @Path("/{rule}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Rule updateGlobalRuleConfig(@PathParam("rule") String rule, Rule data);

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
  @POST
  @Consumes("application/json")
  void createGlobalRule(Rule data);

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
  @DELETE
  void deleteAllGlobalRules();
}
