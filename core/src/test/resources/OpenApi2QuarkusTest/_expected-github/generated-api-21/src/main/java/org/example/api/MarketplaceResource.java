package org.example.api;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.math.BigInteger;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/marketplace_listing")
public interface MarketplaceResource {
  /**
   * <p>
   * Returns user and organization accounts associated with the specified plan,
   * including free plans. For per-seat pricing, you see the list of accounts that
   * have purchased the plan, including the number of seats purchased. When
   * someone submits a plan change that won't be processed until the end of their
   * billing cycle, you will also see the upcoming pending change.
   * </p>
   * <p>
   * GitHub Apps must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint. OAuth Apps must use
   * <a href="https://developer.github.com/v3/auth/#basic-authentication">basic
   * authentication</a> with their client ID and client secret to access this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Returns user and organization accounts associated with the specified plan, including free plans. For per-seat pricing, you see the list of accounts that have purchased the plan, including the number of seats purchased. When someone submits a plan change that won't be processed until the end of their billing cycle, you will also see the upcoming pending change.\n\nGitHub Apps must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint. OAuth Apps must use [basic authentication](https://developer.github.com/v3/auth/#basic-authentication) with their client ID and client secret to access this endpoint.", summary = "List accounts for a plan", operationId = "apps/list-accounts-for-plan")
  @Path("/plans/{plan_id}/accounts")
  @GET
  @Produces("application/json")
  Response apps_list_accounts_for_plan(@PathParam("plan_id") BigInteger planId,
      @QueryParam("sort") @DefaultValue("created") String sort, @QueryParam("direction") String direction,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Shows whether the user or organization account actively subscribes to a plan
   * listed by the authenticated GitHub App. When someone submits a plan change
   * that won't be processed until the end of their billing cycle, you will also
   * see the upcoming pending change.
   * </p>
   * <p>
   * GitHub Apps must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint. OAuth Apps must use
   * <a href="https://developer.github.com/v3/auth/#basic-authentication">basic
   * authentication</a> with their client ID and client secret to access this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Shows whether the user or organization account actively subscribes to a plan listed by the authenticated GitHub App. When someone submits a plan change that won't be processed until the end of their billing cycle, you will also see the upcoming pending change.\n\nGitHub Apps must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint. OAuth Apps must use [basic authentication](https://developer.github.com/v3/auth/#basic-authentication) with their client ID and client secret to access this endpoint.", summary = "Get a subscription plan for an account (stubbed)", operationId = "apps/get-subscription-plan-for-account-stubbed")
  @Path("/stubbed/accounts/{account_id}")
  @GET
  @Produces("application/json")
  Response apps_get_subscription_plan_for_account_stubbed(@PathParam("account_id") BigInteger accountId);

  /**
   * <p>
   * Returns repository and organization accounts associated with the specified
   * plan, including free plans. For per-seat pricing, you see the list of
   * accounts that have purchased the plan, including the number of seats
   * purchased. When someone submits a plan change that won't be processed until
   * the end of their billing cycle, you will also see the upcoming pending
   * change.
   * </p>
   * <p>
   * GitHub Apps must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint. OAuth Apps must use
   * <a href="https://developer.github.com/v3/auth/#basic-authentication">basic
   * authentication</a> with their client ID and client secret to access this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Returns repository and organization accounts associated with the specified plan, including free plans. For per-seat pricing, you see the list of accounts that have purchased the plan, including the number of seats purchased. When someone submits a plan change that won't be processed until the end of their billing cycle, you will also see the upcoming pending change.\n\nGitHub Apps must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint. OAuth Apps must use [basic authentication](https://developer.github.com/v3/auth/#basic-authentication) with their client ID and client secret to access this endpoint.", summary = "List accounts for a plan (stubbed)", operationId = "apps/list-accounts-for-plan-stubbed")
  @Path("/stubbed/plans/{plan_id}/accounts")
  @GET
  @Produces("application/json")
  Response apps_list_accounts_for_plan_stubbed(@PathParam("plan_id") BigInteger planId,
      @QueryParam("sort") @DefaultValue("created") String sort, @QueryParam("direction") String direction,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Shows whether the user or organization account actively subscribes to a plan
   * listed by the authenticated GitHub App. When someone submits a plan change
   * that won't be processed until the end of their billing cycle, you will also
   * see the upcoming pending change.
   * </p>
   * <p>
   * GitHub Apps must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint. OAuth Apps must use
   * <a href="https://developer.github.com/v3/auth/#basic-authentication">basic
   * authentication</a> with their client ID and client secret to access this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Shows whether the user or organization account actively subscribes to a plan listed by the authenticated GitHub App. When someone submits a plan change that won't be processed until the end of their billing cycle, you will also see the upcoming pending change.\n\nGitHub Apps must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint. OAuth Apps must use [basic authentication](https://developer.github.com/v3/auth/#basic-authentication) with their client ID and client secret to access this endpoint.", summary = "Get a subscription plan for an account", operationId = "apps/get-subscription-plan-for-account")
  @Path("/accounts/{account_id}")
  @GET
  @Produces("application/json")
  Response apps_get_subscription_plan_for_account(@PathParam("account_id") BigInteger accountId);

  /**
   * <p>
   * Lists all plans that are part of your GitHub Marketplace listing.
   * </p>
   * <p>
   * GitHub Apps must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint. OAuth Apps must use
   * <a href="https://developer.github.com/v3/auth/#basic-authentication">basic
   * authentication</a> with their client ID and client secret to access this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Lists all plans that are part of your GitHub Marketplace listing.\n\nGitHub Apps must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint. OAuth Apps must use [basic authentication](https://developer.github.com/v3/auth/#basic-authentication) with their client ID and client secret to access this endpoint.", summary = "List plans (stubbed)", operationId = "apps/list-plans-stubbed")
  @Path("/stubbed/plans")
  @GET
  @Produces("application/json")
  Response apps_list_plans_stubbed(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists all plans that are part of your GitHub Marketplace listing.
   * </p>
   * <p>
   * GitHub Apps must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint. OAuth Apps must use
   * <a href="https://developer.github.com/v3/auth/#basic-authentication">basic
   * authentication</a> with their client ID and client secret to access this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Lists all plans that are part of your GitHub Marketplace listing.\n\nGitHub Apps must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint. OAuth Apps must use [basic authentication](https://developer.github.com/v3/auth/#basic-authentication) with their client ID and client secret to access this endpoint.", summary = "List plans", operationId = "apps/list-plans")
  @Path("/plans")
  @GET
  @Produces("application/json")
  Response apps_list_plans(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);
}
