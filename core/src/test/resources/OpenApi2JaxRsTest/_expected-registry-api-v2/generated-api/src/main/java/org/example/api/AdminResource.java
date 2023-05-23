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
import org.example.api.beans.LogConfiguration;
import org.example.api.beans.NamedLogConfiguration;
import org.example.api.beans.Rule;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/v2/admin")
public interface AdminResource {
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
  @Path("/rules")
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
  @Path("/rules")
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
  @Path("/rules")
  @DELETE
  void deleteAllGlobalRules();

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
  @Path("/rules/{rule}")
  @GET
  @Produces("application/json")
  Rule getGlobalRuleConfig(@PathParam("rule") RuleType rule);

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
  @Path("/rules/{rule}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Rule updateGlobalRuleConfig(@PathParam("rule") RuleType rule, @NotNull Rule data);

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
   * <li>Rule cannot be deleted (HTTP error <code>409</code>)</li>
   * <li>A server error occurred (HTTP error <code>500</code>)</li>
   * </ul>
   * 
   */
  @Path("/rules/{rule}")
  @DELETE
  void deleteGlobalRule(@PathParam("rule") RuleType rule);

  /**
   * <p>
   * List all of the configured logging levels. These override the default logging
   * configuration.
   * </p>
   * 
   */
  @Path("/loggers")
  @GET
  @Produces("application/json")
  List<NamedLogConfiguration> listLogConfigurations();

  /**
   * <p>
   * Returns the configured logger configuration for the provided logger name, if
   * no logger configuration is persisted it will return the current default log
   * configuration in the system.
   * </p>
   * 
   */
  @Path("/loggers/{logger}")
  @GET
  @Produces("application/json")
  NamedLogConfiguration getLogConfiguration(@PathParam("logger") String logger);

  /**
   * <p>
   * Configures the logger referenced by the provided logger name with the given
   * configuration.
   * </p>
   * 
   */
  @Path("/loggers/{logger}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  NamedLogConfiguration setLogConfiguration(@PathParam("logger") String logger, @NotNull LogConfiguration data);

  /**
   * <p>
   * Removes the configured logger configuration (if any) for the given logger.
   * </p>
   * 
   */
  @Path("/loggers/{logger}")
  @DELETE
  @Produces("application/json")
  NamedLogConfiguration removeLogConfiguration(@PathParam("logger") String logger);
}
