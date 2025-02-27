package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/enterprises")
public interface EnterprisesResource {
  /**
   * <p>
   * <strong>Warning:</strong> The Billing API is currently in public beta and
   * subject to change.
   * </p>
   * <p>
   * Gets the summary of the free and paid GitHub Actions minutes used.
   * </p>
   * <p>
   * Paid minutes only apply to workflows in private repositories that use
   * GitHub-hosted runners. Minutes used is listed for each GitHub-hosted runner
   * operating system. Any job re-runs are also included in the usage. The usage
   * does not include the multiplier for macOS and Windows runners and is not
   * rounded up to the nearest whole minute. For more information, see
   * &quot;<a href=
   * "https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-actions">Managing
   * billing for GitHub Actions</a>&quot;.
   * </p>
   * <p>
   * The authenticated user must be an enterprise admin.
   * </p>
   * 
   */
  @Path("/{enterprise_id}/settings/billing/actions")
  @GET
  @Produces("application/json")
  Response billing_get_github_actions_billing_ghe(@PathParam("enterprise_id") String enterpriseId);

  /**
   * <p>
   * <strong>Warning:</strong> The Billing API is currently in public beta and
   * subject to change.
   * </p>
   * <p>
   * Gets the estimated paid and estimated total storage used for GitHub Actions
   * and Github Packages.
   * </p>
   * <p>
   * Paid minutes only apply to packages stored for private repositories. For more
   * information, see &quot;<a href=
   * "https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-packages">Managing
   * billing for GitHub Packages</a>.&quot;
   * </p>
   * <p>
   * The authenticated user must be an enterprise admin.
   * </p>
   * 
   */
  @Path("/{enterprise_id}/settings/billing/shared-storage")
  @GET
  @Produces("application/json")
  Response billing_get_shared_storage_billing_ghe(@PathParam("enterprise_id") String enterpriseId);

  /**
   * <p>
   * <strong>Warning:</strong> The Billing API is currently in public beta and
   * subject to change.
   * </p>
   * <p>
   * Gets the free and paid storage used for GitHub Packages in gigabytes.
   * </p>
   * <p>
   * Paid minutes only apply to packages stored for private repositories. For more
   * information, see &quot;<a href=
   * "https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-packages">Managing
   * billing for GitHub Packages</a>.&quot;
   * </p>
   * <p>
   * The authenticated user must be an enterprise admin.
   * </p>
   * 
   */
  @Path("/{enterprise_id}/settings/billing/packages")
  @GET
  @Produces("application/json")
  Response billing_get_github_packages_billing_ghe(@PathParam("enterprise_id") String enterpriseId);
}
