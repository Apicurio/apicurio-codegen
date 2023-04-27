package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/repos")
public interface ReposResource {
  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Lists the teams who have push access to this branch. The list includes child
   * teams.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/teams")
  @GET
  @Produces("application/json")
  Response repos_get_teams_with_access_to_protected_branch(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Replaces the list of teams that have push access to this branch. This removes
   * all teams that previously had push access and grants push access to the new
   * list of teams. Team restrictions include child teams.
   * </p>
   * <p>
   * | Type | Description | | ------- |
   * ------------------------------------------------------------------------------------------------------------------------------------------
   * | | <code>array</code> | The teams that can have push access. Use the team's
   * <code>slug</code>. <strong>Note</strong>: The list of users, apps, and teams
   * in total is limited to 100 items. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/teams")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_set_team_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Grants the specified teams push access for this branch. You can also give
   * push access to child teams.
   * </p>
   * <p>
   * | Type | Description | | ------- |
   * ------------------------------------------------------------------------------------------------------------------------------------------
   * | | <code>array</code> | The teams that can have push access. Use the team's
   * <code>slug</code>. <strong>Note</strong>: The list of users, apps, and teams
   * in total is limited to 100 items. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/teams")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_add_team_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Removes the ability of a team to push to this branch. You can also remove
   * push access for child teams.
   * </p>
   * <p>
   * | Type | Description | | ------- |
   * ---------------------------------------------------------------------------------------------------------------------------------------------------
   * | | <code>array</code> | Teams that should no longer have push access. Use
   * the team's <code>slug</code>. <strong>Note</strong>: The list of users, apps,
   * and teams in total is limited to 100 items. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/teams")
  @DELETE
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_remove_team_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Returns all branches where the given commit SHA is the HEAD, or latest commit
   * for the branch.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/commits/{commit_sha}/branches-where-head")
  @GET
  @Produces("application/json")
  Response repos_list_branches_for_head_commit(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("commit_sha") String commitSha);

  /**
   * <p>
   * Get the top 10 popular contents over the last 14 days.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/traffic/popular/paths")
  @GET
  @Produces("application/json")
  Response repos_get_top_paths(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * 
   */
  @Path("/{owner}/{repo}/deployments/{deployment_id}")
  @GET
  @Produces("application/json")
  Response repos_get_deployment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("deployment_id") Integer deploymentId);

  /**
   * <p>
   * To ensure there can always be an active deployment, you can only delete an
   * <em>inactive</em> deployment. Anyone with <code>repo</code> or
   * <code>repo_deployment</code> scopes can delete an inactive deployment.
   * </p>
   * <p>
   * To set a deployment as inactive, you must:
   * </p>
   * <ul>
   * <li>Create a new deployment that is active so that the system has a record of
   * the current state, then delete the previously active deployment.</li>
   * <li>Mark the active deployment as inactive by adding any non-successful
   * deployment status.</li>
   * </ul>
   * <p>
   * For more information, see &quot;<a href=
   * "https://developer.github.com/v3/repos/deployments/#create-a-deployment">Create
   * a deployment</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/repos/deployments/#create-a-deployment-status">Create
   * a deployment status</a>.&quot;
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/deployments/{deployment_id}")
  @DELETE
  void repos_delete_deployment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("deployment_id") Integer deploymentId);

  /**
   * <p>
   * To download the asset's binary content, set the <code>Accept</code> header of
   * the request to <a href=
   * "https://developer.github.com/v3/media/#media-types"><code>application/octet-stream</code></a>.
   * The API will either redirect the client to the location, or stream it
   * directly if possible. API clients should handle both a <code>200</code> or
   * <code>302</code> response.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/releases/assets/{asset_id}")
  @GET
  @Produces("application/json")
  Response repos_get_release_asset(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("asset_id") Integer assetId);

  /**
   * 
   */
  @Path("/{owner}/{repo}/releases/assets/{asset_id}")
  @DELETE
  void repos_delete_release_asset(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("asset_id") Integer assetId);

  /**
   * <p>
   * Users with push access to the repository can edit a release asset.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/releases/assets/{asset_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_release_asset(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("asset_id") Integer assetId, @NotNull InputStream data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_status_checks/contexts")
  @GET
  @Produces("application/json")
  List<String> repos_get_all_status_check_contexts(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_status_checks/contexts")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  List<String> repos_set_status_check_contexts(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_status_checks/contexts")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  List<String> repos_add_status_check_contexts(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_status_checks/contexts")
  @DELETE
  @Produces("application/json")
  @Consumes("application/json")
  List<String> repos_remove_status_check_contexts(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Gets the contents of a file or directory in a repository. Specify the file
   * path or directory in <code>:path</code>. If you omit <code>:path</code>, you
   * will receive the contents of all files in the repository.
   * </p>
   * <p>
   * Files and symlinks support <a href=
   * "https://developer.github.com/v3/repos/contents/#custom-media-types">a custom
   * media type</a> for retrieving the raw content or rendered HTML (when
   * supported). All content types support <a href=
   * "https://developer.github.com/v3/repos/contents/#custom-media-types">a custom
   * media type</a> to ensure the content is returned in a consistent object
   * format.
   * </p>
   * <p>
   * <strong>Note</strong>:
   * </p>
   * <ul>
   * <li>To get a repository's contents recursively, you can
   * <a href="https://developer.github.com/v3/git/trees/">recursively get the
   * tree</a>.</li>
   * <li>This API has an upper limit of 1,000 files for a directory. If you need
   * to retrieve more files, use the
   * <a href="https://developer.github.com/v3/git/trees/#get-a-tree">Git Trees
   * API</a>.</li>
   * <li>This API supports files up to 1 megabyte in size.</li>
   * </ul>
   * <h4>If the content is a directory</h4>
   * <p>
   * The response will be an array of objects, one object for each item in the
   * directory. When listing the contents of a directory, submodules have their
   * &quot;type&quot; specified as &quot;file&quot;. Logically, the value
   * <em>should</em> be &quot;submodule&quot;. This behavior exists in API v3
   * <a href="https://git.io/v1YCW">for backwards compatibility purposes</a>. In
   * the next major version of the API, the type will be returned as
   * &quot;submodule&quot;.
   * </p>
   * <h4>If the content is a symlink</h4>
   * <p>
   * If the requested <code>:path</code> points to a symlink, and the symlink's
   * target is a normal file in the repository, then the API responds with the
   * content of the file (in the format shown in the example. Otherwise, the API
   * responds with an object describing the symlink itself.
   * </p>
   * <h4>If the content is a submodule</h4>
   * <p>
   * The <code>submodule_git_url</code> identifies the location of the submodule
   * repository, and the <code>sha</code> identifies a specific commit within the
   * submodule repository. Git uses the given URL when cloning the submodule
   * repository, and checks out the submodule at that specific commit.
   * </p>
   * <p>
   * If the submodule repository is not hosted on github.com, the Git URLs
   * (<code>git_url</code> and <code>_links[&quot;git&quot;]</code>) and the
   * github.com URLs (<code>html_url</code> and
   * <code>_links[&quot;html&quot;]</code>) will have null values.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/contents/{path}")
  @GET
  @Produces({"application/json", "application/vnd.github.v3.object"})
  Response repos_get_content(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("path") String path, @QueryParam("ref") String ref);

  /**
   * <p>
   * Creates a new file or replaces an existing file in a repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/contents/{path}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_or_update_file_contents(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("path") String path, @NotNull InputStream data);

  /**
   * <p>
   * Deletes a file in a repository.
   * </p>
   * <p>
   * You can provide an additional <code>committer</code> parameter, which is an
   * object containing information about the committer. Or, you can provide an
   * <code>author</code> parameter, which is an object containing information
   * about the author.
   * </p>
   * <p>
   * The <code>author</code> section is optional and is filled in with the
   * <code>committer</code> information if omitted. If the <code>committer</code>
   * information is omitted, the authenticated user's information is used.
   * </p>
   * <p>
   * You must provide values for both <code>name</code> and <code>email</code>,
   * whether you choose to use <code>author</code> or <code>committer</code>.
   * Otherwise, you'll receive a <code>422</code> status code.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/contents/{path}")
  @DELETE
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_delete_file(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("path") String path, @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/topics")
  @GET
  @Produces("application/json")
  Response repos_get_all_topics(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * 
   */
  @Path("/{owner}/{repo}/topics")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_replace_all_topics(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * Shows whether dependency alerts are enabled or disabled for a repository. The
   * authenticated user must have admin access to the repository. For more
   * information, see &quot;<a href=
   * "https://help.github.com/en/articles/about-security-alerts-for-vulnerable-dependencies">About
   * security alerts for vulnerable dependencies</a>&quot;.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/vulnerability-alerts")
  @GET
  void repos_check_vulnerability_alerts(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Enables dependency alerts and the dependency graph for a repository. The
   * authenticated user must have admin access to the repository. For more
   * information, see &quot;<a href=
   * "https://help.github.com/en/articles/about-security-alerts-for-vulnerable-dependencies">About
   * security alerts for vulnerable dependencies</a>&quot;.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/vulnerability-alerts")
  @PUT
  void repos_enable_vulnerability_alerts(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Disables dependency alerts and the dependency graph for a repository. The
   * authenticated user must have admin access to the repository. For more
   * information, see &quot;<a href=
   * "https://help.github.com/en/articles/about-security-alerts-for-vulnerable-dependencies">About
   * security alerts for vulnerable dependencies</a>&quot;.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/vulnerability-alerts")
  @DELETE
  void repos_disable_vulnerability_alerts(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Simple filtering of deployments is available via query parameters:
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/deployments")
  @GET
  @Produces("application/json")
  Response repos_list_deployments(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("sha") String sha, @QueryParam("ref") String ref, @QueryParam("task") String task,
      @QueryParam("environment") String environment, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * Deployments offer a few configurable parameters with certain defaults.
   * </p>
   * <p>
   * The <code>ref</code> parameter can be any named branch, tag, or SHA. At
   * GitHub we often deploy branches and verify them before we merge a pull
   * request.
   * </p>
   * <p>
   * The <code>environment</code> parameter allows deployments to be issued to
   * different runtime environments. Teams often have multiple environments for
   * verifying their applications, such as <code>production</code>,
   * <code>staging</code>, and <code>qa</code>. This parameter makes it easier to
   * track which environments have requested deployments. The default environment
   * is <code>production</code>.
   * </p>
   * <p>
   * The <code>auto_merge</code> parameter is used to ensure that the requested
   * ref is not behind the repository's default branch. If the ref <em>is</em>
   * behind the default branch for the repository, we will attempt to merge it for
   * you. If the merge succeeds, the API will return a successful merge commit. If
   * merge conflicts prevent the merge from succeeding, the API will return a
   * failure response.
   * </p>
   * <p>
   * By default, <a href="https://developer.github.com/v3/repos/statuses">commit
   * statuses</a> for every submitted context must be in a <code>success</code>
   * state. The <code>required_contexts</code> parameter allows you to specify a
   * subset of contexts that must be <code>success</code>, or to specify contexts
   * that have not yet been submitted. You are not required to use commit statuses
   * to deploy. If you do not require any contexts or create any commit statuses,
   * the deployment will always succeed.
   * </p>
   * <p>
   * The <code>payload</code> parameter is available for any extra information
   * that a deployment system might need. It is a JSON text field that will be
   * passed on when a deployment event is dispatched.
   * </p>
   * <p>
   * The <code>task</code> parameter is used by the deployment system to allow
   * different execution paths. In the web world this might be
   * <code>deploy:migrations</code> to run schema changes on the system. In the
   * compiled world this could be a flag to compile an application with debugging
   * enabled.
   * </p>
   * <p>
   * Users with <code>repo</code> or <code>repo_deployment</code> scopes can
   * create a deployment for a given ref.
   * </p>
   * <h4>Merged branch response</h4>
   * <p>
   * You will see this response when GitHub automatically merges the base branch
   * into the topic branch instead of creating a deployment. This auto-merge
   * happens when:
   * </p>
   * <ul>
   * <li>Auto-merge option is enabled in the repository</li>
   * <li>Topic branch does not include the latest changes on the base branch,
   * which is <code>master</code> in the response example</li>
   * <li>There are no merge conflicts</li>
   * </ul>
   * <p>
   * If there are no new commits in the base branch, a new request to create a
   * deployment should give a successful response.
   * </p>
   * <h4>Merge conflict response</h4>
   * <p>
   * This error happens when the <code>auto_merge</code> option is enabled and
   * when the default branch (in this case <code>master</code>), can't be merged
   * into the branch that's being deployed (in this case
   * <code>topic-branch</code>), due to merge conflicts.
   * </p>
   * <h4>Failed commit status checks</h4>
   * <p>
   * This error happens when the <code>required_contexts</code> parameter
   * indicates that one or more contexts need to have a <code>success</code>
   * status for the commit to be deployed, but one or more of the required
   * contexts do not have a state of <code>success</code>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/deployments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_deployment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * This endpoint will return all community profile metrics, including an overall
   * health score, repository description, the presence of documentation, detected
   * code of conduct, detected license, and the presence of ISSUE_TEMPLATE,
   * PULL_REQUEST_TEMPLATE, README, and CONTRIBUTING files.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/community/profile")
  @GET
  @Produces("application/json")
  Response repos_get_community_profile_metrics(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pages")
  @GET
  @Produces("application/json")
  Response repos_get_pages(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pages")
  @PUT
  @Consumes("application/json")
  void repos_update_information_about_pages_site(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pages")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_pages_site(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pages")
  @DELETE
  void repos_delete_pages_site(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_pull_request_reviews")
  @GET
  @Produces("application/vnd.github.luke-cage-preview+json")
  Response repos_get_pull_request_review_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_pull_request_reviews")
  @DELETE
  void repos_delete_pull_request_review_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Updating pull request review enforcement requires admin or owner permissions
   * to the repository and branch protection to be enabled.
   * </p>
   * <p>
   * <strong>Note</strong>: Passing new arrays of <code>users</code> and
   * <code>teams</code> replaces their previous values.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_pull_request_reviews")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_pull_request_review_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull InputStream data);

  /**
   * <p>
   * Get the top 10 referrers over the last 14 days.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/traffic/popular/referrers")
  @GET
  @Produces("application/json")
  Response repos_get_top_referrers(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Users with pull access in a repository can view commit statuses for a given
   * ref. The ref can be a SHA, a branch name, or a tag name. Statuses are
   * returned in reverse chronological order. The first status in the list will be
   * the latest one.
   * </p>
   * <p>
   * This resource is also available via a legacy route:
   * <code>GET /repos/:owner/:repo/statuses/:ref</code>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/commits/{ref}/statuses")
  @GET
  @Produces("application/json")
  Response repos_list_commit_statuses_for_ref(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Both <code>:base</code> and <code>:head</code> must be branch names in
   * <code>:repo</code>. To compare branches across other repositories in the same
   * network as <code>:repo</code>, use the format
   * <code>&lt;USERNAME&gt;:branch</code>.
   * </p>
   * <p>
   * The response from the API is equivalent to running the
   * <code>git log base..head</code> command; however, commits are returned in
   * chronological order. Pass the appropriate <a href=
   * "https://developer.github.com/v3/media/#commits-commit-comparison-and-pull-requests">media
   * type</a> to fetch diff and patch formats.
   * </p>
   * <p>
   * The response also includes details on the files that were changed between the
   * two commits. This includes the status of the change (for example, if a file
   * was added, removed, modified, or renamed), and details of the change itself.
   * For example, files with a <code>renamed</code> status have a
   * <code>previous_filename</code> field showing the previous filename of the
   * file, and files with a <code>modified</code> status have a <code>patch</code>
   * field showing the changes made to the file.
   * </p>
   * <p>
   * <strong>Working with large comparisons</strong>
   * </p>
   * <p>
   * The response will include a comparison of up to 250 commits. If you are
   * working with a larger commit range, you can use the
   * <a href="https://developer.github.com/v3/repos/commits/#list-commits">List
   * commits</a> to enumerate all commits in the range.
   * </p>
   * <p>
   * For comparisons with extremely large diffs, you may receive an error response
   * indicating that the diff took too long to generate. You can typically resolve
   * this error by using a smaller commit range.
   * </p>
   * <p>
   * <strong>Signature verification object</strong>
   * </p>
   * <p>
   * The response will include a <code>verification</code> object that describes
   * the result of verifying the commit's signature. The following fields are
   * included in the <code>verification</code> object:
   * </p>
   * <p>
   * These are the possible values for <code>reason</code> in the
   * <code>verification</code> object:
   * </p>
   * <p>
   * | Value | Description | | ------------------------ |
   * ---------------------------------------------------------------------------------------------------------------------------------
   * | | <code>expired_key</code> | The key that made the signature is expired. |
   * | <code>not_signing_key</code> | The &quot;signing&quot; flag is not among
   * the usage flags in the GPG key that made the signature. | |
   * <code>gpgverify_error</code> | There was an error communicating with the
   * signature verification service. | | <code>gpgverify_unavailable</code> | The
   * signature verification service is currently unavailable. | |
   * <code>unsigned</code> | The object does not include a signature. | |
   * <code>unknown_signature_type</code> | A non-PGP signature was found in the
   * commit. | | <code>no_user</code> | No user was associated with the
   * <code>committer</code> email address in the commit. | |
   * <code>unverified_email</code> | The <code>committer</code> email address in
   * the commit was associated with a user, but the email address is not verified
   * on her/his account. | | <code>bad_email</code> | The <code>committer</code>
   * email address in the commit is not included in the identities of the PGP key
   * that made the signature. | | <code>unknown_key</code> | The key that made the
   * signature has not been registered with any user's account. | |
   * <code>malformed_signature</code> | There was an error parsing the signature.
   * | | <code>invalid</code> | The signature could not be cryptographically
   * verified using the key whose key-id was found in the signature. | |
   * <code>valid</code> | None of the above errors applied, so the signature is
   * considered to be verified. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/compare/{base}...{head}")
  @GET
  @Produces("application/json")
  Response repos_compare_commits(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("base") String base, @PathParam("head") String head);

  /**
   * <p>
   * Lists all pull requests containing the provided commit SHA, which can be from
   * any point in the commit history. The results will include open and closed
   * pull requests. Additional preview headers may be required to see certain
   * details for associated pull requests, such as whether a pull request is in a
   * draft state. For more information about previews that might affect this
   * endpoint, see the
   * <a href="https://developer.github.com/v3/pulls/#list-pull-requests">List pull
   * requests</a> endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/commits/{commit_sha}/pulls")
  @GET
  @Produces("application/json")
  Response repos_list_pull_requests_associated_with_commit(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @PathParam("commit_sha") String commitSha,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/enforce_admins")
  @GET
  @Produces("application/json")
  Response repos_get_admin_branch_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Adding admin enforcement requires admin or owner permissions to the
   * repository and branch protection to be enabled.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/enforce_admins")
  @POST
  @Produces("application/json")
  Response repos_set_admin_branch_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Removing admin enforcement requires admin or owner permissions to the
   * repository and branch protection to be enabled.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/enforce_admins")
  @DELETE
  void repos_delete_admin_branch_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Users with pull access can view a deployment status for a deployment:
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/deployments/{deployment_id}/statuses/{status_id}")
  @GET
  @Produces("application/json")
  Response repos_get_deployment_status(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("deployment_id") Integer deploymentId, @PathParam("status_id") Integer statusId);

  /**
   * <p>
   * Enables automated security fixes for a repository. The authenticated user
   * must have admin access to the repository. For more information, see
   * &quot;<a href=
   * "https://help.github.com/en/articles/configuring-automated-security-fixes">Configuring
   * automated security fixes</a>&quot;.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/automated-security-fixes")
  @PUT
  void repos_enable_automated_security_fixes(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Disables automated security fixes for a repository. The authenticated user
   * must have admin access to the repository. For more information, see
   * &quot;<a href=
   * "https://help.github.com/en/articles/configuring-automated-security-fixes">Configuring
   * automated security fixes</a>&quot;.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/automated-security-fixes")
  @DELETE
  void repos_disable_automated_security_fixes(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * When authenticated with admin or owner permissions to the repository, you can
   * use this endpoint to check whether a branch requires signed commits. An
   * enabled status of <code>true</code> indicates you must sign commits on this
   * branch. For more information, see
   * <a href="https://help.github.com/articles/signing-commits-with-gpg">Signing
   * commits with GPG</a> in GitHub Help.
   * </p>
   * <p>
   * <strong>Note</strong>: You must enable branch protection to require signed
   * commits.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_signatures")
  @GET
  @Produces("application/json")
  Response repos_get_commit_signature_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * When authenticated with admin or owner permissions to the repository, you can
   * use this endpoint to require signed commits on a branch. You must enable
   * branch protection to require signed commits.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_signatures")
  @POST
  @Produces("application/json")
  Response repos_create_commit_signature_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * When authenticated with admin or owner permissions to the repository, you can
   * use this endpoint to disable required signed commits on a branch. You must
   * enable branch protection to require signed commits.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_signatures")
  @DELETE
  void repos_delete_commit_signature_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Lists the people who have push access to this branch.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/users")
  @GET
  @Produces("application/json")
  Response repos_get_users_with_access_to_protected_branch(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Replaces the list of people that have push access to this branch. This
   * removes all people that previously had push access and grants push access to
   * the new list of people.
   * </p>
   * <p>
   * | Type | Description | | ------- |
   * -----------------------------------------------------------------------------------------------------------------------------
   * | | <code>array</code> | Usernames for people who can have push access.
   * <strong>Note</strong>: The list of users, apps, and teams in total is limited
   * to 100 items. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/users")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_set_user_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Grants the specified people push access for this branch.
   * </p>
   * <p>
   * | Type | Description | | ------- |
   * -----------------------------------------------------------------------------------------------------------------------------
   * | | <code>array</code> | Usernames for people who can have push access.
   * <strong>Note</strong>: The list of users, apps, and teams in total is limited
   * to 100 items. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/users")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_add_user_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Removes the ability of a user to push to this branch.
   * </p>
   * <p>
   * | Type | Description | | ------- |
   * ---------------------------------------------------------------------------------------------------------------------------------------------
   * | | <code>array</code> | Usernames of the people who should no longer have
   * push access. <strong>Note</strong>: The list of users, apps, and teams in
   * total is limited to 100 items. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/users")
  @DELETE
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_remove_user_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/branches")
  @GET
  @Produces("application/json")
  Response repos_list_branches(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("protected") Boolean _protected, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}")
  @GET
  @Produces("application/json")
  Response repos_get_branch(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * 
   */
  @Path("/{owner}/{repo}/keys")
  @GET
  @Produces("application/json")
  Response repos_list_deploy_keys(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * You can create a read-only deploy key.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/keys")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_deploy_key(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pages/builds/{build_id}")
  @GET
  @Produces("application/json")
  Response repos_get_pages_build(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("build_id") Integer buildId);

  /**
   * <p>
   * Get the total number of clones and breakdown per day or week for the last 14
   * days. Timestamps are aligned to UTC midnight of the beginning of the day or
   * week. Week begins on Monday.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/traffic/clones")
  @GET
  @Produces("application/json")
  Response repos_get_clones(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per") String per);

  /**
   * 
   */
  @Path("/{owner}/{repo}/hooks/{hook_id}")
  @GET
  @Produces("application/json")
  Response repos_get_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("hook_id") Integer hookId);

  /**
   * 
   */
  @Path("/{owner}/{repo}/hooks/{hook_id}")
  @DELETE
  void repos_delete_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("hook_id") Integer hookId);

  /**
   * 
   */
  @Path("/{owner}/{repo}/hooks/{hook_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("hook_id") Integer hookId, @NotNull InputStream data);

  /**
   * <p>
   * This returns a list of releases, which does not include regular Git tags that
   * have not been associated with a release. To get a list of Git tags, use the
   * <a href=
   * "https://developer.github.com/v3/repos/#list-repository-tags">Repository Tags
   * API</a>.
   * </p>
   * <p>
   * Information about published releases are available to everyone. Only users
   * with push access will receive listings for draft releases.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/releases")
  @GET
  @Produces("application/json")
  Response repos_list_releases(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Users with push access to the repository can create a release.
   * </p>
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/releases")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_release(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * Creates a new repository using a repository template. Use the
   * <code>template_owner</code> and <code>template_repo</code> route parameters
   * to specify the repository to use as the template. The authenticated user must
   * own or be a member of an organization that owns the repository. To check if a
   * repository is available to use as a template, get the repository's
   * information using the
   * <a href="https://developer.github.com/v3/repos/#get-a-repository">Get a
   * repository</a> endpoint and check that the <code>is_template</code> key is
   * <code>true</code>.
   * </p>
   * <p>
   * <strong>OAuth scope requirements</strong>
   * </p>
   * <p>
   * When using <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">OAuth</a>,
   * authorizations must include:
   * </p>
   * <ul>
   * <li><code>public_repo</code> scope or <code>repo</code> scope to create a
   * public repository</li>
   * <li><code>repo</code> scope to create a private repository</li>
   * </ul>
   * 
   */
  @Path("/{template_owner}/{template_repo}/generate")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_using_template(@PathParam("template_owner") String templateOwner,
      @PathParam("template_repo") String templateRepo, @NotNull InputStream data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_status_checks")
  @GET
  @Produces("application/json")
  Response repos_get_status_checks_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_status_checks")
  @DELETE
  void repos_remove_status_check_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Updating required status checks requires admin or owner permissions to the
   * repository and branch protection to be enabled.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/required_status_checks")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_status_check_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull InputStream data);

  /**
   * <p>
   * When you pass the <code>scarlet-witch-preview</code> media type, requests to
   * get a repository will also return the repository's code of conduct if it can
   * be detected from the repository's code of conduct file.
   * </p>
   * <p>
   * The <code>parent</code> and <code>source</code> objects are present when the
   * repository is a fork. <code>parent</code> is the repository this repository
   * was forked from, <code>source</code> is the ultimate source for the network.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}")
  @GET
  @Produces("application/json")
  Response repos_get(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Deleting a repository requires admin access. If OAuth is used, the
   * <code>delete_repo</code> scope is required.
   * </p>
   * <p>
   * If an organization owner has configured the organization to prevent members
   * from deleting organization-owned repositories, you will get a
   * <code>403 Forbidden</code> response.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}")
  @DELETE
  void repos_delete(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * <strong>Note</strong>: To edit a repository's topics, use the <a href=
   * "https://developer.github.com/v3/repos/#replace-all-repository-topics">Replace
   * all repository topics</a> endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Lists who has access to this protected branch.
   * </p>
   * <p>
   * <strong>Note</strong>: Users, apps, and teams <code>restrictions</code> are
   * only available for organization-owned repositories.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions")
  @GET
  @Produces("application/json")
  Response repos_get_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Disables the ability to restrict who can push to this branch.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions")
  @DELETE
  void repos_delete_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * 
   */
  @Path("/{owner}/{repo}/keys/{key_id}")
  @GET
  @Produces("application/json")
  Response repos_get_deploy_key(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("key_id") Integer keyId);

  /**
   * <p>
   * Deploy keys are immutable. If you need to update a key, remove the key and
   * create a new one instead.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/keys/{key_id}")
  @DELETE
  void repos_delete_deploy_key(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("key_id") Integer keyId);

  /**
   * <p>
   * <strong>Note:</strong> This returns an <code>upload_url</code> key
   * corresponding to the endpoint for uploading release assets. This key is a
   * <a href="https://developer.github.com/v3/#hypermedia">hypermedia
   * resource</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/releases/{release_id}")
  @GET
  @Produces("application/json")
  Response repos_get_release(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("release_id") Integer releaseId);

  /**
   * <p>
   * Users with push access to the repository can delete a release.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/releases/{release_id}")
  @DELETE
  void repos_delete_release(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("release_id") Integer releaseId);

  /**
   * <p>
   * Users with push access to the repository can edit a release.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/releases/{release_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_release(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("release_id") Integer releaseId, @NotNull InputStream data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection")
  @GET
  @Produces("application/json")
  Response repos_get_branch_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Protecting a branch requires admin or owner permissions to the repository.
   * </p>
   * <p>
   * <strong>Note</strong>: Passing new arrays of <code>users</code> and
   * <code>teams</code> replaces their previous values.
   * </p>
   * <p>
   * <strong>Note</strong>: The list of users, apps, and teams in total is limited
   * to 100 items.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_branch_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull InputStream data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection")
  @DELETE
  void repos_delete_branch_protection(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   * <p>
   * When authenticating as a user with admin rights to a repository, this
   * endpoint will list all currently open repository invitations.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/invitations")
  @GET
  @Produces("application/json")
  Response repos_list_invitations(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * This will trigger a
   * <a href="https://developer.github.com/webhooks/#ping-event">ping event</a> to
   * be sent to the hook.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/hooks/{hook_id}/pings")
  @POST
  void repos_ping_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("hook_id") Integer hookId);

  /**
   * 
   */
  @Path("/{owner}/{repo}/tags")
  @GET
  @Produces("application/json")
  Response repos_list_tags(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{owner}/{repo}/teams")
  @GET
  @Produces("application/json")
  Response repos_list_teams(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Returns the last year of commit activity grouped by week. The
   * <code>days</code> array is a group of commits per day, starting on
   * <code>Sunday</code>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/stats/commit_activity")
  @GET
  @Produces("application/json")
  Response repos_get_commit_activity_stats(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Lists languages for the specified repository. The value shown for each
   * language is the number of bytes of code written in that language.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/languages")
  @GET
  @Produces("application/json")
  Response repos_list_languages(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * You can use this endpoint to trigger a webhook event called
   * <code>repository_dispatch</code> when you want activity that happens outside
   * of GitHub to trigger a GitHub Actions workflow or GitHub App webhook. You
   * must configure your GitHub Actions workflow or GitHub App to run when the
   * <code>repository_dispatch</code> event occurs. For an example
   * <code>repository_dispatch</code> webhook payload, see &quot;<a href=
   * "https://developer.github.com/webhooks/event-payloads/#repository_dispatch">RepositoryDispatchEvent</a>.&quot;
   * </p>
   * <p>
   * The <code>client_payload</code> parameter is available for any extra
   * information that your workflow might need. This parameter is a JSON payload
   * that will be passed on when the webhook event is dispatched. For example, the
   * <code>client_payload</code> can include a message that a user would like to
   * send using a GitHub Actions workflow. Or the <code>client_payload</code> can
   * be used as a test to debug your workflow. For a test example, see the
   * <a href="https://developer.github.com/v3/repos/#example-4">input example</a>.
   * </p>
   * <p>
   * To give you write access to the repository, you must use a personal access
   * token with the <code>repo</code> scope. For more information, see
   * &quot;<a href=
   * "https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line">Creating
   * a personal access token for the command line</a>&quot; in the GitHub Help
   * documentation.
   * </p>
   * <p>
   * This input example shows how you can use the <code>client_payload</code> as a
   * test to debug your workflow.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/dispatches")
  @POST
  @Consumes("application/json")
  void repos_create_dispatch_event(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * Each array contains the day number, hour number, and number of commits:
   * </p>
   * <ul>
   * <li><code>0-6</code>: Sunday - Saturday</li>
   * <li><code>0-23</code>: Hour of day</li>
   * <li>Number of commits</li>
   * </ul>
   * <p>
   * For example, <code>[2, 14, 25]</code> indicates that there were 25 total
   * commits, during the 2:00pm hour on Tuesdays. All times are based on the time
   * zone of individual commits.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/stats/punch_card")
  @GET
  @Produces("application/json")
  List<Integer> repos_get_punch_card_stats(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * A transfer request will need to be accepted by the new owner when
   * transferring a personal repository to another user. The response will contain
   * the original <code>owner</code>, and the transfer will continue
   * asynchronously. For more details on the requirements to transfer personal and
   * organization-owned repositories, see
   * <a href="https://help.github.com/articles/about-repository-transfers/">about
   * repository transfers</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/transfer")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_transfer(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pages/builds")
  @GET
  @Produces("application/json")
  Response repos_list_pages_builds(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * You can request that your site be built from the latest revision on the
   * default branch. This has the same effect as pushing a commit to your default
   * branch, but does not require an additional commit. Manually triggering page
   * builds can be helpful when diagnosing build warnings and failures.
   * </p>
   * <p>
   * Build requests are limited to one concurrent build per repository and one
   * concurrent build per requester. If you request a build while another is still
   * in progress, the second request will be queued until the first completes.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pages/builds")
  @POST
  @Produces("application/json")
  Response repos_request_pages_build(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * For organization-owned repositories, the list of collaborators includes
   * outside collaborators, organization members that are direct collaborators,
   * organization members with access through team memberships, organization
   * members with access through default organization permissions, and
   * organization owners.
   * </p>
   * <p>
   * Team members will include the members of child teams.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/collaborators/{username}")
  @GET
  void repos_check_collaborator(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("username") String username);

  /**
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * <p>
   * For more information the permission levels, see &quot;<a href=
   * "https://help.github.com/en/github/setting-up-and-managing-organizations-and-teams/repository-permission-levels-for-an-organization#permission-levels-for-repositories-owned-by-an-organization">Repository
   * permission levels for an organization</a>&quot;.
   * </p>
   * <p>
   * Note that, if you choose not to pass any parameters, you'll need to set
   * <code>Content-Length</code> to zero when calling out to this endpoint. For
   * more information, see
   * &quot;<a href="https://developer.github.com/v3/#http-verbs">HTTP
   * verbs</a>.&quot;
   * </p>
   * <p>
   * The invitee will receive a notification that they have been invited to the
   * repository, which they must accept or decline. They may do this via the
   * notifications page, the email they receive, or by using the
   * <a href="https://developer.github.com/v3/repos/invitations/">repository
   * invitations API endpoints</a>.
   * </p>
   * <p>
   * <strong>Rate limits</strong>
   * </p>
   * <p>
   * To prevent abuse, you are limited to sending 50 invitations to a repository
   * per 24 hour period. Note there is no limit if you are inviting organization
   * members to an organization repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/collaborators/{username}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_add_collaborator(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("username") String username, @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/collaborators/{username}")
  @DELETE
  void repos_remove_collaborator(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("username") String username);

  /**
   * 
   */
  @Path("/{owner}/{repo}/forks")
  @GET
  @Produces("application/json")
  Response repos_list_forks(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("sort") String sort, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Create a fork for the authenticated user.
   * </p>
   * <p>
   * <strong>Note</strong>: Forking a Repository happens asynchronously. You may
   * have to wait a short period of time before you can access the git objects. If
   * this takes longer than 5 minutes, be sure to contact
   * <a href="https://github.com/contact">GitHub Support</a> or
   * <a href="https://premium.githubsupport.com">GitHub Premium Support</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/forks")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_fork(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * Get the total number of views and breakdown per day or week for the last 14
   * days. Timestamps are aligned to UTC midnight of the beginning of the day or
   * week. Week begins on Monday.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/traffic/views")
  @GET
  @Produces("application/json")
  Response repos_get_views(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per") String per);

  /**
   * 
   */
  @Path("/{owner}/{repo}/releases/{release_id}/assets")
  @GET
  @Produces("application/json")
  Response repos_list_release_assets(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("release_id") Integer releaseId, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * This endpoint makes use of
   * <a href="https://developer.github.com/v3/#hypermedia">a Hypermedia
   * relation</a> to determine which URL to access. The endpoint you call to
   * upload release assets is specific to your release. Use the
   * <code>upload_url</code> returned in the response of the <a href=
   * "https://developer.github.com/v3/repos/releases/#create-a-release">Create a
   * release endpoint</a> to upload a release asset.
   * </p>
   * <p>
   * You need to use an HTTP client which supports
   * <a href="http://en.wikipedia.org/wiki/Server_Name_Indication">SNI</a> to make
   * calls to this endpoint.
   * </p>
   * <p>
   * Most libraries will set the required <code>Content-Length</code> header
   * automatically. Use the required <code>Content-Type</code> header to provide
   * the media type of the asset. For a list of media types, see <a href=
   * "https://www.iana.org/assignments/media-types/media-types.xhtml">Media
   * Types</a>. For example:
   * </p>
   * <p>
   * <code>application/zip</code>
   * </p>
   * <p>
   * GitHub expects the asset data in its raw binary form, rather than JSON. You
   * will send the raw binary content of the asset as the request body. Everything
   * else about the endpoint is the same as the rest of the API. For example,
   * you'll still need to pass your authentication to be able to upload an asset.
   * </p>
   * <p>
   * When an upstream failure occurs, you will receive a
   * <code>502 Bad Gateway</code> status. This may leave an empty asset with a
   * state of <code>starter</code>. It can be safely deleted.
   * </p>
   * <p>
   * <strong>Notes:</strong>
   * </p>
   * <ul>
   * <li>GitHub renames asset filenames that have special characters,
   * non-alphanumeric characters, and leading or trailing periods. The
   * &quot;<a href=
   * "https://developer.github.com/v3/repos/releases/#list-assets-for-a-release">List
   * assets for a release</a>&quot; endpoint lists the renamed filenames. For more
   * information and help, contact <a href="https://github.com/contact">GitHub
   * Support</a>.</li>
   * <li>If you upload an asset with the same filename as another uploaded asset,
   * you'll receive an error and must delete the old file before you can re-upload
   * the new asset.</li>
   * </ul>
   * 
   */
  @Path("/{owner}/{repo}/releases/{release_id}/assets")
  @POST
  @Produces("application/json")
  @Consumes("*/*")
  Response repos_upload_release_asset(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("release_id") Integer releaseId, @QueryParam("name") String name, @QueryParam("label") String label,
      @NotNull String data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/comments/{comment_id}")
  @GET
  @Produces("application/json")
  Response repos_get_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId);

  /**
   * 
   */
  @Path("/{owner}/{repo}/comments/{comment_id}")
  @DELETE
  void repos_delete_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId);

  /**
   * 
   */
  @Path("/{owner}/{repo}/comments/{comment_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId, @NotNull InputStream data);

  /**
   * <p>
   * This will trigger the hook with the latest push to the current repository if
   * the hook is subscribed to <code>push</code> events. If the hook is not
   * subscribed to <code>push</code> events, the server will respond with 204 but
   * no test POST will be generated.
   * </p>
   * <p>
   * <strong>Note</strong>: Previously
   * <code>/repos/:owner/:repo/hooks/:hook_id/test</code>
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/hooks/{hook_id}/tests")
  @POST
  void repos_test_push_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("hook_id") Integer hookId);

  /**
   * 
   */
  @Path("/{owner}/{repo}/hooks")
  @GET
  @Produces("application/json")
  Response repos_list_webhooks(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Repositories can have multiple webhooks installed. Each webhook should have a
   * unique <code>config</code>. Multiple webhooks can share the same
   * <code>config</code> as long as those webhooks do not have any
   * <code>events</code> that overlap.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/hooks")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pages/builds/latest")
  @GET
  @Produces("application/json")
  Response repos_get_latest_pages_build(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Use the <code>:commit_sha</code> to specify the commit that will have its
   * comments listed.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/commits/{commit_sha}/comments")
  @GET
  @Produces("application/json")
  Response repos_list_comments_for_commit(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("commit_sha") String commitSha, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * Create a comment for a commit using its <code>:commit_sha</code>.
   * </p>
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/commits/{commit_sha}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("commit_sha") String commitSha, @NotNull InputStream data);

  /**
   * <p>
   * Returns the total commit counts for the <code>owner</code> and total commit
   * counts in <code>all</code>. <code>all</code> is everyone combined, including
   * the <code>owner</code> in the last 52 weeks. If you'd like to get the commit
   * counts for non-owners, you can subtract <code>owner</code> from
   * <code>all</code>.
   * </p>
   * <p>
   * The array order is oldest week (index 0) to most recent week.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/stats/participation")
  @GET
  @Produces("application/json")
  Response repos_get_participation_stats(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * <strong>Signature verification object</strong>
   * </p>
   * <p>
   * The response will include a <code>verification</code> object that describes
   * the result of verifying the commit's signature. The following fields are
   * included in the <code>verification</code> object:
   * </p>
   * <p>
   * These are the possible values for <code>reason</code> in the
   * <code>verification</code> object:
   * </p>
   * <p>
   * | Value | Description | | ------------------------ |
   * ---------------------------------------------------------------------------------------------------------------------------------
   * | | <code>expired_key</code> | The key that made the signature is expired. |
   * | <code>not_signing_key</code> | The &quot;signing&quot; flag is not among
   * the usage flags in the GPG key that made the signature. | |
   * <code>gpgverify_error</code> | There was an error communicating with the
   * signature verification service. | | <code>gpgverify_unavailable</code> | The
   * signature verification service is currently unavailable. | |
   * <code>unsigned</code> | The object does not include a signature. | |
   * <code>unknown_signature_type</code> | A non-PGP signature was found in the
   * commit. | | <code>no_user</code> | No user was associated with the
   * <code>committer</code> email address in the commit. | |
   * <code>unverified_email</code> | The <code>committer</code> email address in
   * the commit was associated with a user, but the email address is not verified
   * on her/his account. | | <code>bad_email</code> | The <code>committer</code>
   * email address in the commit is not included in the identities of the PGP key
   * that made the signature. | | <code>unknown_key</code> | The key that made the
   * signature has not been registered with any user's account. | |
   * <code>malformed_signature</code> | There was an error parsing the signature.
   * | | <code>invalid</code> | The signature could not be cryptographically
   * verified using the key whose key-id was found in the signature. | |
   * <code>valid</code> | None of the above errors applied, so the signature is
   * considered to be verified. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/commits")
  @GET
  @Produces("application/json")
  Response repos_list_commits(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("sha") String sha, @QueryParam("path") String path, @QueryParam("author") String author,
      @QueryParam("since") String since, @QueryParam("until") String until, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Lists the GitHub Apps that have push access to this branch. Only installed
   * GitHub Apps with <code>write</code> access to the <code>contents</code>
   * permission can be added as authorized actors on a protected branch.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/apps")
  @GET
  @Produces("application/json")
  Response repos_get_apps_with_access_to_protected_branch(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @PathParam("branch") String branch);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Replaces the list of apps that have push access to this branch. This removes
   * all apps that previously had push access and grants push access to the new
   * list of apps. Only installed GitHub Apps with <code>write</code> access to
   * the <code>contents</code> permission can be added as authorized actors on a
   * protected branch.
   * </p>
   * <p>
   * | Type | Description | | ------- |
   * ----------------------------------------------------------------------------------------------------------------------------------------------------------
   * | | <code>array</code> | The GitHub Apps that have push access to this
   * branch. Use the app's <code>slug</code>. <strong>Note</strong>: The list of
   * users, apps, and teams in total is limited to 100 items. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/apps")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_set_app_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Grants the specified apps push access for this branch. Only installed GitHub
   * Apps with <code>write</code> access to the <code>contents</code> permission
   * can be added as authorized actors on a protected branch.
   * </p>
   * <p>
   * | Type | Description | | ------- |
   * ----------------------------------------------------------------------------------------------------------------------------------------------------------
   * | | <code>array</code> | The GitHub Apps that have push access to this
   * branch. Use the app's <code>slug</code>. <strong>Note</strong>: The list of
   * users, apps, and teams in total is limited to 100 items. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/apps")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_add_app_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Protected branches are available in public repositories with GitHub Free and
   * GitHub Free for organizations, and in public and private repositories with
   * GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise
   * Server. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Removes the ability of an app to push to this branch. Only installed GitHub
   * Apps with <code>write</code> access to the <code>contents</code> permission
   * can be added as authorized actors on a protected branch.
   * </p>
   * <p>
   * | Type | Description | | ------- |
   * ----------------------------------------------------------------------------------------------------------------------------------------------------------
   * | | <code>array</code> | The GitHub Apps that have push access to this
   * branch. Use the app's <code>slug</code>. <strong>Note</strong>: The list of
   * users, apps, and teams in total is limited to 100 items. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/apps")
  @DELETE
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_remove_app_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   * <p>
   * Get a published release with the specified tag.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/releases/tags/{tag}")
  @GET
  @Produces("application/json")
  Response repos_get_release_by_tag(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("tag") String tag);

  /**
   * <p>
   * Gets a redirect URL to download a zip archive for a repository. If you omit
   * <code>:ref</code>, the repository’s default branch (usually
   * <code>master</code>) will be used. Please make sure your HTTP framework is
   * configured to follow redirects or you will need to use the
   * <code>Location</code> header to make a second <code>GET</code> request.
   * <strong>Note</strong>: For private repositories, these links are temporary
   * and expire after five minutes.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/zipball/{ref}")
  @GET
  void repos_download_zipball_archive(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref);

  /**
   * 
   */
  @Path("/{owner}/{repo}/invitations/{invitation_id}")
  @DELETE
  void repos_delete_invitation(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("invitation_id") Integer invitationId);

  /**
   * 
   */
  @Path("/{owner}/{repo}/invitations/{invitation_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_invitation(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("invitation_id") Integer invitationId, @NotNull InputStream data);

  /**
   * <p>
   * Users with pull access in a repository can access a combined view of commit
   * statuses for a given ref. The ref can be a SHA, a branch name, or a tag name.
   * </p>
   * <p>
   * The most recent status for each context is returned, up to 100. This field
   * <a href="https://developer.github.com/v3/#pagination">paginates</a> if there
   * are over 100 contexts.
   * </p>
   * <p>
   * Additionally, a combined <code>state</code> is returned. The
   * <code>state</code> is one of:
   * </p>
   * <ul>
   * <li><strong>failure</strong> if any of the contexts report as
   * <code>error</code> or <code>failure</code></li>
   * <li><strong>pending</strong> if there are no statuses or a context is
   * <code>pending</code></li>
   * <li><strong>success</strong> if the latest status for all contexts is
   * <code>success</code></li>
   * </ul>
   * 
   */
  @Path("/{owner}/{repo}/commits/{ref}/status")
  @GET
  @Produces("application/json")
  Response repos_get_combined_status_for_ref(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref);

  /**
   * <p>
   * Users with push access in a repository can create commit statuses for a given
   * SHA.
   * </p>
   * <p>
   * Note: there is a limit of 1000 statuses per <code>sha</code> and
   * <code>context</code> within a repository. Attempts to create more than 1000
   * statuses will result in a validation error.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/statuses/{sha}")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_commit_status(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("sha") String sha, @NotNull InputStream data);

  /**
   * <p>
   * Users with pull access can view deployment statuses for a deployment:
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/deployments/{deployment_id}/statuses")
  @GET
  @Produces("application/json")
  Response repos_list_deployment_statuses(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("deployment_id") Integer deploymentId, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * Users with <code>push</code> access can create deployment statuses for a
   * given deployment.
   * </p>
   * <p>
   * GitHub Apps require <code>read &amp; write</code> access to
   * &quot;Deployments&quot; and <code>read-only</code> access to &quot;Repo
   * contents&quot; (for private repos). OAuth Apps require the
   * <code>repo_deployment</code> scope.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/deployments/{deployment_id}/statuses")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_deployment_status(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("deployment_id") Integer deploymentId, @NotNull InputStream data);

  /**
   * <p>
   * Gets a redirect URL to download a tar archive for a repository. If you omit
   * <code>:ref</code>, the repository’s default branch (usually
   * <code>master</code>) will be used. Please make sure your HTTP framework is
   * configured to follow redirects or you will need to use the
   * <code>Location</code> header to make a second <code>GET</code> request.
   * <strong>Note</strong>: For private repositories, these links are temporary
   * and expire after five minutes.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/tarball/{ref}")
  @GET
  void repos_download_tarball_archive(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref);

  /**
   * <p>
   * Returns the <code>total</code> number of commits authored by the contributor.
   * In addition, the response includes a Weekly Hash (<code>weeks</code> array)
   * with the following information:
   * </p>
   * <ul>
   * <li><code>w</code> - Start of the week, given as a
   * <a href="http://en.wikipedia.org/wiki/Unix_time">Unix timestamp</a>.</li>
   * <li><code>a</code> - Number of additions</li>
   * <li><code>d</code> - Number of deletions</li>
   * <li><code>c</code> - Number of commits</li>
   * </ul>
   * 
   */
  @Path("/{owner}/{repo}/stats/contributors")
  @GET
  @Produces("application/json")
  Response repos_get_contributors_stats(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Gets the preferred README for a repository.
   * </p>
   * <p>
   * READMEs support <a href=
   * "https://developer.github.com/v3/repos/contents/#custom-media-types">custom
   * media types</a> for retrieving the raw content or rendered HTML.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/readme")
  @GET
  @Produces("application/json")
  Response repos_get_readme(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("ref") String ref);

  /**
   * <p>
   * Commit Comments use <a href=
   * "https://developer.github.com/v3/repos/comments/#custom-media-types">these
   * custom media types</a>. You can read more about the use of media types in the
   * API <a href="https://developer.github.com/v3/media/">here</a>.
   * </p>
   * <p>
   * Comments are ordered by ascending ID.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/comments")
  @GET
  @Produces("application/json")
  Response repos_list_commit_comments_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Returns the contents of a single commit reference. You must have
   * <code>read</code> access for the repository to use this endpoint.
   * </p>
   * <p>
   * You can pass the appropriate <a href=
   * "https://developer.github.com/v3/media/#commits-commit-comparison-and-pull-requests">media
   * type</a> to fetch <code>diff</code> and <code>patch</code> formats. Diffs
   * with binary data will have no <code>patch</code> property.
   * </p>
   * <p>
   * To return only the SHA-1 hash of the commit reference, you can provide the
   * <code>sha</code> custom <a href=
   * "https://developer.github.com/v3/media/#commits-commit-comparison-and-pull-requests">media
   * type</a> in the <code>Accept</code> header. You can use this endpoint to
   * check if a remote reference's SHA-1 hash is the same as your local
   * reference's SHA-1 hash by providing the local SHA-1 reference as the ETag.
   * </p>
   * <p>
   * <strong>Signature verification object</strong>
   * </p>
   * <p>
   * The response will include a <code>verification</code> object that describes
   * the result of verifying the commit's signature. The following fields are
   * included in the <code>verification</code> object:
   * </p>
   * <p>
   * These are the possible values for <code>reason</code> in the
   * <code>verification</code> object:
   * </p>
   * <p>
   * | Value | Description | | ------------------------ |
   * ---------------------------------------------------------------------------------------------------------------------------------
   * | | <code>expired_key</code> | The key that made the signature is expired. |
   * | <code>not_signing_key</code> | The &quot;signing&quot; flag is not among
   * the usage flags in the GPG key that made the signature. | |
   * <code>gpgverify_error</code> | There was an error communicating with the
   * signature verification service. | | <code>gpgverify_unavailable</code> | The
   * signature verification service is currently unavailable. | |
   * <code>unsigned</code> | The object does not include a signature. | |
   * <code>unknown_signature_type</code> | A non-PGP signature was found in the
   * commit. | | <code>no_user</code> | No user was associated with the
   * <code>committer</code> email address in the commit. | |
   * <code>unverified_email</code> | The <code>committer</code> email address in
   * the commit was associated with a user, but the email address is not verified
   * on her/his account. | | <code>bad_email</code> | The <code>committer</code>
   * email address in the commit is not included in the identities of the PGP key
   * that made the signature. | | <code>unknown_key</code> | The key that made the
   * signature has not been registered with any user's account. | |
   * <code>malformed_signature</code> | There was an error parsing the signature.
   * | | <code>invalid</code> | The signature could not be cryptographically
   * verified using the key whose key-id was found in the signature. | |
   * <code>valid</code> | None of the above errors applied, so the signature is
   * considered to be verified. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/commits/{ref}")
  @GET
  @Produces("application/json")
  Response repos_get_commit(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref);

  /**
   * <p>
   * View the latest published full release for the repository.
   * </p>
   * <p>
   * The latest release is the most recent non-prerelease, non-draft release,
   * sorted by the <code>created_at</code> attribute. The <code>created_at</code>
   * attribute is the date of the commit used for the release, and not the date
   * when the release was drafted or published.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/releases/latest")
  @GET
  @Produces("application/json")
  Response repos_get_latest_release(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Returns a weekly aggregate of the number of additions and deletions pushed to
   * a repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/stats/code_frequency")
  @GET
  @Produces("application/json")
  List<Integer> repos_get_code_frequency_stats(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Lists contributors to the specified repository and sorts them by the number
   * of commits per contributor in descending order. This endpoint may return
   * information that is a few hours old because the GitHub REST API v3 caches
   * contributor data to improve performance.
   * </p>
   * <p>
   * GitHub identifies contributors by author email address. This endpoint groups
   * contribution counts by GitHub user, which includes all associated email
   * addresses. To improve performance, only the first 500 author email addresses
   * in the repository link to GitHub users. The rest will appear as anonymous
   * contributors without associated GitHub user information.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/contributors")
  @GET
  @Produces("application/json")
  Response repos_list_contributors(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("anon") String anon, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * For organization-owned repositories, the list of collaborators includes
   * outside collaborators, organization members that are direct collaborators,
   * organization members with access through team memberships, organization
   * members with access through default organization permissions, and
   * organization owners.
   * </p>
   * <p>
   * Team members will include the members of child teams.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/collaborators")
  @GET
  @Produces("application/json")
  Response repos_list_collaborators(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("affiliation") String affiliation, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{owner}/{repo}/merges")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_merge(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * <p>
   * Checks the repository permission of a collaborator. The possible repository
   * permissions are <code>admin</code>, <code>write</code>, <code>read</code>,
   * and <code>none</code>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/collaborators/{username}/permission")
  @GET
  @Produces("application/json")
  Response repos_get_collaborator_permission_level(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("username") String username);

  /**
   * <p>
   * List files larger than 100MB found during the import
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/import/large_files")
  @GET
  @Produces("application/json")
  Response migrations_get_large_files(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * View the progress of an import.
   * </p>
   * <p>
   * <strong>Import status</strong>
   * </p>
   * <p>
   * This section includes details about the possible values of the
   * <code>status</code> field of the Import Progress response.
   * </p>
   * <p>
   * An import that does not have errors will progress through these steps:
   * </p>
   * <ul>
   * <li><code>detecting</code> - the &quot;detection&quot; step of the import is
   * in progress because the request did not include a <code>vcs</code> parameter.
   * The import is identifying the type of source control present at the URL.</li>
   * <li><code>importing</code> - the &quot;raw&quot; step of the import is in
   * progress. This is where commit data is fetched from the original repository.
   * The import progress response will include <code>commit_count</code> (the
   * total number of raw commits that will be imported) and <code>percent</code>
   * (0 - 100, the current progress through the import).</li>
   * <li><code>mapping</code> - the &quot;rewrite&quot; step of the import is in
   * progress. This is where SVN branches are converted to Git branches, and where
   * author updates are applied. The import progress response does not include
   * progress information.</li>
   * <li><code>pushing</code> - the &quot;push&quot; step of the import is in
   * progress. This is where the importer updates the repository on GitHub. The
   * import progress response will include <code>push_percent</code>, which is the
   * percent value reported by <code>git push</code> when it is &quot;Writing
   * objects&quot;.</li>
   * <li><code>complete</code> - the import is complete, and the repository is
   * ready on GitHub.</li>
   * </ul>
   * <p>
   * If there are problems, you will see one of these in the <code>status</code>
   * field:
   * </p>
   * <ul>
   * <li><code>auth_failed</code> - the import requires authentication in order to
   * connect to the original repository. To update authentication for the import,
   * please see the <a href=
   * "https://developer.github.com/v3/migrations/source_imports/#update-an-import">Update
   * an import</a> section.</li>
   * <li><code>error</code> - the import encountered an error. The import progress
   * response will include the <code>failed_step</code> and an error message.
   * Contact <a href="https://github.com/contact">GitHub Support</a> or
   * <a href="https://premium.githubsupport.com">GitHub Premium Support</a> for
   * more information.</li>
   * <li><code>detection_needs_auth</code> - the importer requires authentication
   * for the originating repository to continue detection. To update
   * authentication for the import, please see the <a href=
   * "https://developer.github.com/v3/migrations/source_imports/#update-an-import">Update
   * an import</a> section.</li>
   * <li><code>detection_found_nothing</code> - the importer didn't recognize any
   * source control at the URL. To resolve, <a href=
   * "https://developer.github.com/v3/migrations/source_imports/#cancel-an-import">Cancel
   * the import</a> and <a href=
   * "https://developer.github.com/v3/migrations/source_imports/#start-an-import">retry</a>
   * with the correct URL.</li>
   * <li><code>detection_found_multiple</code> - the importer found several
   * projects or repositories at the provided URL. When this is the case, the
   * Import Progress response will also include a <code>project_choices</code>
   * field with the possible project choices as values. To update project choice,
   * please see the <a href=
   * "https://developer.github.com/v3/migrations/source_imports/#update-an-import">Update
   * an import</a> section.</li>
   * </ul>
   * <p>
   * <strong>The project_choices field</strong>
   * </p>
   * <p>
   * When multiple projects are found at the provided URL, the response hash will
   * include a <code>project_choices</code> field, the value of which is an array
   * of hashes each representing a project choice. The exact key/value pairs of
   * the project hashes will differ depending on the version control type.
   * </p>
   * <p>
   * <strong>Git LFS related fields</strong>
   * </p>
   * <p>
   * This section includes details about Git LFS related fields that may be
   * present in the Import Progress response.
   * </p>
   * <ul>
   * <li><code>use_lfs</code> - describes whether the import has been opted in or
   * out of using Git LFS. The value can be <code>opt_in</code>,
   * <code>opt_out</code>, or <code>undecided</code> if no action has been
   * taken.</li>
   * <li><code>has_large_files</code> - the boolean value describing whether files
   * larger than 100MB were found during the <code>importing</code> step.</li>
   * <li><code>large_files_size</code> - the total size in gigabytes of files
   * larger than 100MB found in the originating repository.</li>
   * <li><code>large_files_count</code> - the total number of files larger than
   * 100MB found in the originating repository. To see a list of these files, make
   * a &quot;Get Large Files&quot; request.</li>
   * </ul>
   * 
   */
  @Path("/{owner}/{repo}/import")
  @GET
  @Produces("application/json")
  Response migrations_get_import_status(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Start a source import to a GitHub repository using GitHub Importer.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/import")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response migrations_start_import(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * Stop an import for a repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/import")
  @DELETE
  void migrations_cancel_import(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * An import can be updated with credentials or a project choice by passing in
   * the appropriate parameters in this API request. If no parameters are
   * provided, the import will be restarted.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/import")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response migrations_update_import(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * Update an author's identity for the import. Your application can continue
   * updating authors any time before you push new commits to the repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/import/authors/{author_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response migrations_map_commit_author(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("author_id") Integer authorId, @NotNull InputStream data);

  /**
   * <p>
   * Each type of source control system represents authors in a different way. For
   * example, a Git commit author has a display name and an email address, but a
   * Subversion commit author just has a username. The GitHub Importer will make
   * the author information valid, but the author might not be correct. For
   * example, it will change the bare Subversion username <code>hubot</code> into
   * something like
   * <code>hubot &lt;hubot@12341234-abab-fefe-8787-fedcba987654&gt;</code>.
   * </p>
   * <p>
   * This endpoint and the <a href=
   * "https://developer.github.com/v3/migrations/source_imports/#map-a-commit-author">Map
   * a commit author</a> endpoint allow you to provide correct Git author
   * information.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/import/authors")
  @GET
  @Produces("application/json")
  Response migrations_get_commit_authors(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("since") String since);

  /**
   * <p>
   * You can import repositories from Subversion, Mercurial, and TFS that include
   * files larger than 100MB. This ability is powered by
   * <a href="https://git-lfs.github.com">Git LFS</a>. You can learn more about
   * our LFS feature and working with large files
   * <a href="https://help.github.com/articles/versioning-large-files/">on our
   * help site</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/import/lfs")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response migrations_set_lfs_preference(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * Shows which group of GitHub users can interact with this repository and when
   * the restriction expires. If there are no restrictions, you will see an empty
   * response.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/interaction-limits")
  @GET
  @Produces("application/json")
  Response interactions_get_restrictions_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Temporarily restricts interactions to certain GitHub users within the given
   * repository. You must have owner or admin access to set restrictions.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/interaction-limits")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response interactions_set_restrictions_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * Removes all interaction restrictions from the given repository. You must have
   * owner or admin access to remove restrictions.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/interaction-limits")
  @DELETE
  void interactions_remove_restrictions_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * This method returns the contents of the repository's license file, if one is
   * detected.
   * </p>
   * <p>
   * Similar to <a href=
   * "https://developer.github.com/v3/repos/contents/#get-repository-content">Get
   * repository content</a>, this method also supports <a href=
   * "https://developer.github.com/v3/repos/contents/#custom-media-types">custom
   * media types</a> for retrieving the raw license content or rendered license
   * HTML.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/license")
  @GET
  @Produces("application/json")
  Response licenses_get_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * 
   */
  @Path("/{owner}/{repo}/subscription")
  @GET
  @Produces("application/json")
  Response activity_get_repo_subscription(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * If you would like to watch a repository, set <code>subscribed</code> to
   * <code>true</code>. If you would like to ignore notifications made within a
   * repository, set <code>ignored</code> to <code>true</code>. If you would like
   * to stop watching a repository, <a href=
   * "https://developer.github.com/v3/activity/watching/#delete-a-repository-subscription">delete
   * the repository's subscription</a> completely.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/subscription")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response activity_set_repo_subscription(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * This endpoint should only be used to stop watching a repository. To control
   * whether or not you wish to receive notifications from a repository, <a href=
   * "https://developer.github.com/v3/activity/watching/#set-a-repository-subscription">set
   * the repository's subscription manually</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/subscription")
  @DELETE
  void activity_delete_repo_subscription(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * 
   */
  @Path("/{owner}/{repo}/events")
  @GET
  @Produces("application/json")
  Response activity_list_repo_events(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * List all notifications for the current user.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/notifications")
  @GET
  @Produces("application/json")
  Response activity_list_repo_notifications_for_authenticated_user(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @QueryParam("all") Boolean all,
      @QueryParam("participating") Boolean participating, @QueryParam("since") String since,
      @QueryParam("before") String before, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Marks all notifications in a repository as &quot;read&quot; removes them from
   * the <a href="https://github.com/notifications">default view on GitHub</a>. If
   * the number of notifications is too large to complete in one request, you will
   * receive a <code>202 Accepted</code> status and GitHub will run an
   * asynchronous process to mark notifications as &quot;read.&quot; To check
   * whether any &quot;unread&quot; notifications remain, you can use the <a href=
   * "https://developer.github.com/v3/activity/notifications/#list-repository-notifications-for-the-authenticated-user">List
   * repository notifications for the authenticated user</a> endpoint and pass the
   * query parameter <code>all=false</code>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/notifications")
  @PUT
  @Consumes("application/json")
  void activity_mark_repo_notifications_as_read(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * Lists the people watching the specified repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/subscribers")
  @GET
  @Produces("application/json")
  Response activity_list_watchers_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists the people that have starred the repository.
   * </p>
   * <p>
   * You can also find out <em>when</em> stars were created by passing the
   * following custom <a href="https://developer.github.com/v3/media/">media
   * type</a> via the <code>Accept</code> header:
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/stargazers")
  @GET
  @Produces({"application/json", "application/vnd.github.v3.star+json"})
  Response activity_list_stargazers_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists annotations for a check run using the annotation <code>id</code>.
   * GitHub Apps must have the <code>checks:read</code> permission on a private
   * repository or pull access to a public repository to get annotations for a
   * check run. OAuth Apps and authenticated users must have the <code>repo</code>
   * scope to get annotations for a check run in a private repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/check-runs/{check_run_id}/annotations")
  @GET
  @Produces("application/json")
  Response checks_list_annotations(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_run_id") Integer checkRunId, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * <strong>Note:</strong> The Checks API only looks for pushes in the repository
   * where the check suite or check run were created. Pushes to a branch in a
   * forked repository are not detected and return an empty
   * <code>pull_requests</code> array and a <code>null</code> value for
   * <code>head_branch</code>.
   * </p>
   * <p>
   * Lists check suites for a commit <code>ref</code>. The <code>ref</code> can be
   * a SHA, branch name, or a tag name. GitHub Apps must have the
   * <code>checks:read</code> permission on a private repository or pull access to
   * a public repository to list check suites. OAuth Apps and authenticated users
   * must have the <code>repo</code> scope to get check suites in a private
   * repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/commits/{ref}/check-suites")
  @GET
  @Produces("application/json")
  Response checks_list_suites_for_ref(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref, @QueryParam("app_id") Integer appId, @QueryParam("check_name") String checkName,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * <strong>Note:</strong> The Checks API only looks for pushes in the repository
   * where the check suite or check run were created. Pushes to a branch in a
   * forked repository are not detected and return an empty
   * <code>pull_requests</code> array.
   * </p>
   * <p>
   * Lists check runs for a commit ref. The <code>ref</code> can be a SHA, branch
   * name, or a tag name. GitHub Apps must have the <code>checks:read</code>
   * permission on a private repository or pull access to a public repository to
   * get check runs. OAuth Apps and authenticated users must have the
   * <code>repo</code> scope to get check runs in a private repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/commits/{ref}/check-runs")
  @GET
  @Produces("application/json")
  Response checks_list_for_ref(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref, @QueryParam("check_name") String checkName, @QueryParam("status") String status,
      @QueryParam("filter") String filter, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * <strong>Note:</strong> The Checks API only looks for pushes in the repository
   * where the check suite or check run were created. Pushes to a branch in a
   * forked repository are not detected and return an empty
   * <code>pull_requests</code> array.
   * </p>
   * <p>
   * Lists check runs for a check suite using its <code>id</code>. GitHub Apps
   * must have the <code>checks:read</code> permission on a private repository or
   * pull access to a public repository to get check runs. OAuth Apps and
   * authenticated users must have the <code>repo</code> scope to get check runs
   * in a private repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/check-suites/{check_suite_id}/check-runs")
  @GET
  @Produces("application/json")
  Response checks_list_for_suite(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_suite_id") Integer checkSuiteId, @QueryParam("check_name") String checkName,
      @QueryParam("status") String status, @QueryParam("filter") String filter, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * <strong>Note:</strong> The Checks API only looks for pushes in the repository
   * where the check suite or check run were created. Pushes to a branch in a
   * forked repository are not detected and return an empty
   * <code>pull_requests</code> array.
   * </p>
   * <p>
   * Gets a single check run using its <code>id</code>. GitHub Apps must have the
   * <code>checks:read</code> permission on a private repository or pull access to
   * a public repository to get check runs. OAuth Apps and authenticated users
   * must have the <code>repo</code> scope to get check runs in a private
   * repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/check-runs/{check_run_id}")
  @GET
  @Produces("application/json")
  Response checks_get(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_run_id") Integer checkRunId);

  /**
   * <p>
   * <strong>Note:</strong> The Checks API only looks for pushes in the repository
   * where the check suite or check run were created. Pushes to a branch in a
   * forked repository are not detected and return an empty
   * <code>pull_requests</code> array.
   * </p>
   * <p>
   * Updates a check run for a specific commit in a repository. Your GitHub App
   * must have the <code>checks:write</code> permission to edit check runs.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/check-runs/{check_run_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response checks_update(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_run_id") Integer checkRunId, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Note:</strong> The Checks API only looks for pushes in the repository
   * where the check suite or check run were created. Pushes to a branch in a
   * forked repository are not detected and return an empty
   * <code>pull_requests</code> array and a <code>null</code> value for
   * <code>head_branch</code>.
   * </p>
   * <p>
   * By default, check suites are automatically created when you create a
   * <a href="https://developer.github.com/v3/checks/runs/">check run</a>. You
   * only need to use this endpoint for manually creating check suites when you've
   * disabled automatic creation using &quot;<a href=
   * "https://developer.github.com/v3/checks/suites/#update-repository-preferences-for-check-suites">Update
   * repository preferences for check suites</a>&quot;. Your GitHub App must have
   * the <code>checks:write</code> permission to create check suites.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/check-suites")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response checks_create_suite(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * Triggers GitHub to rerequest an existing check suite, without pushing new
   * code to a repository. This endpoint will trigger the <a href=
   * "https://developer.github.com/webhooks/event-payloads/#check_suite"><code>check_suite</code>
   * webhook</a> event with the action <code>rerequested</code>. When a check
   * suite is <code>rerequested</code>, its <code>status</code> is reset to
   * <code>queued</code> and the <code>conclusion</code> is cleared.
   * </p>
   * <p>
   * To rerequest a check suite, your GitHub App must have the
   * <code>checks:read</code> permission on a private repository or pull access to
   * a public repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/check-suites/{check_suite_id}/rerequest")
  @POST
  void checks_rerequest_suite(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_suite_id") Integer checkSuiteId);

  /**
   * <p>
   * Changes the default automatic flow when creating check suites. By default, a
   * check suite is automatically created each time code is pushed to a
   * repository. When you disable the automatic creation of check suites, you can
   * manually <a href=
   * "https://developer.github.com/v3/checks/suites/#create-a-check-suite">Create
   * a check suite</a>. You must have admin permissions in the repository to set
   * preferences for check suites.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/check-suites/preferences")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response checks_set_suites_preferences(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * <strong>Note:</strong> The Checks API only looks for pushes in the repository
   * where the check suite or check run were created. Pushes to a branch in a
   * forked repository are not detected and return an empty
   * <code>pull_requests</code> array.
   * </p>
   * <p>
   * Creates a new check run for a specific commit in a repository. Your GitHub
   * App must have the <code>checks:write</code> permission to create check runs.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/check-runs")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response checks_create(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Note:</strong> The Checks API only looks for pushes in the repository
   * where the check suite or check run were created. Pushes to a branch in a
   * forked repository are not detected and return an empty
   * <code>pull_requests</code> array and a <code>null</code> value for
   * <code>head_branch</code>.
   * </p>
   * <p>
   * Gets a single check suite using its <code>id</code>. GitHub Apps must have
   * the <code>checks:read</code> permission on a private repository or pull
   * access to a public repository to get check suites. OAuth Apps and
   * authenticated users must have the <code>repo</code> scope to get check suites
   * in a private repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/check-suites/{check_suite_id}")
  @GET
  @Produces("application/json")
  Response checks_get_suite(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_suite_id") Integer checkSuiteId);

  /**
   * <p>
   * Lists the projects in a repository. Returns a <code>404 Not Found</code>
   * status if projects are disabled in the repository. If you do not have
   * sufficient privileges to perform this action, a <code>401 Unauthorized</code>
   * or <code>410 Gone</code> status is returned.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/projects")
  @GET
  @Produces("application/json")
  Response projects_list_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("state") String state, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Creates a repository project board. Returns a <code>404 Not Found</code>
   * status if projects are disabled in the repository. If you do not have
   * sufficient privileges to perform this action, a <code>401 Unauthorized</code>
   * or <code>410 Gone</code> status is returned.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/projects")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response projects_create_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * List the reactions to an
   * <a href="https://developer.github.com/v3/issues/comments/">issue comment</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/comments/{comment_id}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_issue_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId, @QueryParam("content") String content,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Create a reaction to an
   * <a href="https://developer.github.com/v3/issues/comments/">issue comment</a>.
   * A response with a <code>Status: 200 OK</code> means that you already added
   * the reaction type to this issue comment.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/comments/{comment_id}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_issue_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId, @NotNull InputStream data);

  /**
   * <p>
   * List the reactions to an
   * <a href="https://developer.github.com/v3/issues/">issue</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_issue(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @QueryParam("content") String content,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Create a reaction to an
   * <a href="https://developer.github.com/v3/issues/">issue</a>. A response with
   * a <code>Status: 200 OK</code> means that you already added the reaction type
   * to this issue.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_issue(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @NotNull InputStream data);

  /**
   * <p>
   * List the reactions to a
   * <a href="https://developer.github.com/v3/pulls/comments/">pull request review
   * comment</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_pull_request_review_comment(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @PathParam("comment_id") Integer commentId, @QueryParam("content") String content,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Create a reaction to a
   * <a href="https://developer.github.com/v3/pulls/comments/">pull request review
   * comment</a>. A response with a <code>Status: 200 OK</code> means that you
   * already added the reaction type to this pull request review comment.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_pull_request_review_comment(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @PathParam("comment_id") Integer commentId, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Note:</strong> You can also specify a repository by
   * <code>repository_id</code> using the route
   * <code>DELETE /repositories/:repository_id/comments/:comment_id/reactions/:reaction_id</code>.
   * </p>
   * <p>
   * Delete a reaction to a
   * <a href="https://developer.github.com/v3/repos/comments/">commit comment</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/comments/{comment_id}/reactions/{reaction_id}")
  @DELETE
  void reactions_delete_for_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId, @PathParam("reaction_id") Integer reactionId);

  /**
   * <p>
   * <strong>Note:</strong> You can also specify a repository by
   * <code>repository_id</code> using the route
   * <code>DELETE delete /repositories/:repository_id/issues/comments/:comment_id/reactions/:reaction_id</code>.
   * </p>
   * <p>
   * Delete a reaction to an
   * <a href="https://developer.github.com/v3/issues/comments/">issue comment</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/comments/{comment_id}/reactions/{reaction_id}")
  @DELETE
  void reactions_delete_for_issue_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId, @PathParam("reaction_id") Integer reactionId);

  /**
   * <p>
   * <strong>Note:</strong> You can also specify a repository by
   * <code>repository_id</code> using the route
   * <code>DELETE /repositories/:repository_id/issues/:issue_number/reactions/:reaction_id</code>.
   * </p>
   * <p>
   * Delete a reaction to an
   * <a href="https://developer.github.com/v3/issues/">issue</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/reactions/{reaction_id}")
  @DELETE
  void reactions_delete_for_issue(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @PathParam("reaction_id") Integer reactionId);

  /**
   * <p>
   * <strong>Note:</strong> You can also specify a repository by
   * <code>repository_id</code> using the route
   * <code>DELETE /repositories/:repository_id/pulls/comments/:comment_id/reactions/:reaction_id.</code>
   * </p>
   * <p>
   * Delete a reaction to a
   * <a href="https://developer.github.com/v3/pulls/comments/">pull request review
   * comment</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}/reactions/{reaction_id}")
  @DELETE
  void reactions_delete_for_pull_request_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId, @PathParam("reaction_id") Integer reactionId);

  /**
   * <p>
   * List the reactions to a
   * <a href="https://developer.github.com/v3/repos/comments/">commit comment</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/comments/{comment_id}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId, @QueryParam("content") String content,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Create a reaction to a
   * <a href="https://developer.github.com/v3/repos/comments/">commit comment</a>.
   * A response with a <code>Status: 200 OK</code> means that you already added
   * the reaction type to this commit comment.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/comments/{comment_id}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId, @NotNull InputStream data);

  /**
   * <p>
   * This method returns the contents of the repository's code of conduct file, if
   * one is detected.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/community/code_of_conduct")
  @GET
  @Produces("application/json")
  Response codes_of_conduct_get_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Lists the workflows in a repository. Anyone with read access to the
   * repository can use this endpoint. If the repository is private you must use
   * an access token with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:read</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/workflows")
  @GET
  @Produces("application/json")
  Response actions_list_repo_workflows(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * You can use this endpoint to manually trigger a GitHub Actions workflow run.
   * You can also replace <code>{workflow_id}</code> with the workflow file name.
   * For example, you could use <code>main.yml</code>.
   * </p>
   * <p>
   * You must configure your GitHub Actions workflow to run when the <a href=
   * "/developers/webhooks-and-events/webhook-events-and-payloads#workflow_dispatch"><code>workflow_dispatch</code>
   * webhook</a> event occurs. The <code>inputs</code> are configured in the
   * workflow file. For more information about how to configure the
   * <code>workflow_dispatch</code> event in the workflow file, see &quot;<a href=
   * "/actions/reference/events-that-trigger-workflows#workflow_dispatch">Events
   * that trigger workflows</a>.&quot;
   * </p>
   * <p>
   * You must authenticate using an access token with the <code>repo</code> scope
   * to use this endpoint. GitHub Apps must have the <code>actions:write</code>
   * permission to use this endpoint. For more information, see &quot;<a href=
   * "https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line">Creating
   * a personal access token for the command line</a>.&quot;
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/workflows/{workflow_id}/dispatches")
  @POST
  @Consumes("application/json")
  void actions_create_workflow_dispatch(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("workflow_id") Integer workflowId, @NotNull InputStream data);

  /**
   * <p>
   * Lists binaries for the runner application that you can download and run. You
   * must authenticate using an access token with the <code>repo</code> scope to
   * use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runners/downloads")
  @GET
  @Produces("application/json")
  Response actions_list_runner_applications_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Lists all artifacts for a repository. Anyone with read access to the
   * repository can use this endpoint. If the repository is private you must use
   * an access token with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:read</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/artifacts")
  @GET
  @Produces("application/json")
  Response actions_list_artifacts_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists all secrets available in a repository without revealing their encrypted
   * values. You must authenticate using an access token with the
   * <code>repo</code> scope to use this endpoint. GitHub Apps must have the
   * <code>secrets</code> repository permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/secrets")
  @GET
  @Produces("application/json")
  Response actions_list_repo_secrets(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * <strong>Warning:</strong> This GitHub Actions usage endpoint is currently in
   * public beta and subject to change. For more information, see &quot;<a href=
   * "https://developer.github.com/changes/2020-05-15-actions-api-workflow-usage">GitHub
   * Actions API workflow usage</a>.&quot;
   * </p>
   * <p>
   * Gets the number of billable minutes used by a specific workflow during the
   * current billing cycle. Billable minutes only apply to workflows in private
   * repositories that use GitHub-hosted runners. Usage is listed for each
   * GitHub-hosted runner operating system in milliseconds. Any job re-runs are
   * also included in the usage. The usage does not include the multiplier for
   * macOS and Windows runners and is not rounded up to the nearest whole minute.
   * For more information, see &quot;<a href=
   * "https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-actions">Managing
   * billing for GitHub Actions</a>&quot;.
   * </p>
   * <p>
   * You can also replace <code>:workflow_id</code> with
   * <code>:workflow_file_name</code>. For example, you could use
   * <code>main.yml</code>. Anyone with read access to the repository can use this
   * endpoint. If the repository is private you must use an access token with the
   * <code>repo</code> scope. GitHub Apps must have the <code>actions:read</code>
   * permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/workflows/{workflow_id}/timing")
  @GET
  @Produces("application/json")
  Response actions_get_workflow_usage(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("workflow_id") Integer workflowId);

  /**
   * <p>
   * Gets a specific artifact for a workflow run. Anyone with read access to the
   * repository can use this endpoint. If the repository is private you must use
   * an access token with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:read</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/artifacts/{artifact_id}")
  @GET
  @Produces("application/json")
  Response actions_get_artifact(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("artifact_id") Integer artifactId);

  /**
   * <p>
   * Deletes an artifact for a workflow run. You must authenticate using an access
   * token with the <code>repo</code> scope to use this endpoint. GitHub Apps must
   * have the <code>actions:write</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/artifacts/{artifact_id}")
  @DELETE
  void actions_delete_artifact(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("artifact_id") Integer artifactId);

  /**
   * <p>
   * Gets a single repository secret without revealing its encrypted value. You
   * must authenticate using an access token with the <code>repo</code> scope to
   * use this endpoint. GitHub Apps must have the <code>secrets</code> repository
   * permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/secrets/{secret_name}")
  @GET
  @Produces("application/json")
  Response actions_get_repo_secret(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("secret_name") String secretName);

  /**
   * <p>
   * Creates or updates a repository secret with an encrypted value. Encrypt your
   * secret using <a href=
   * "https://libsodium.gitbook.io/doc/bindings_for_other_languages">LibSodium</a>.
   * You must authenticate using an access token with the <code>repo</code> scope
   * to use this endpoint. GitHub Apps must have the <code>secrets</code>
   * repository permission to use this endpoint.
   * </p>
   * <h4>Example encrypting a secret using Node.js</h4>
   * <p>
   * Encrypt your secret using the
   * <a href="https://github.com/github/tweetsodium">tweetsodium</a> library.
   * </p>
   * 
   * <pre>
   * <code>const sodium = require('tweetsodium');
  
  const key = &quot;base64-encoded-public-key&quot;;
  const value = &quot;plain-text-secret&quot;;
  
  // Convert the message and key to Uint8Array's (Buffer implements that interface)
  const messageBytes = Buffer.from(value);
  const keyBytes = Buffer.from(key, 'base64');
  
  // Encrypt using LibSodium.
  const encryptedBytes = sodium.seal(messageBytes, keyBytes);
  
  // Base64 the encrypted secret
  const encrypted = Buffer.from(encryptedBytes).toString('base64');
  
  console.log(encrypted);
  </code>
   * </pre>
   * 
   * <h4>Example encrypting a secret using Python</h4>
   * <p>
   * Encrypt your secret using <a href=
   * "https://pynacl.readthedocs.io/en/stable/public/#nacl-public-sealedbox">pynacl</a>
   * with Python 3.
   * </p>
   * 
   * <pre>
   * <code>from base64 import b64encode
  from nacl import encoding, public
  
  def encrypt(public_key: str, secret_value: str) -&gt; str:
    &quot;&quot;&quot;Encrypt a Unicode string using the public key.&quot;&quot;&quot;
    public_key = public.PublicKey(public_key.encode(&quot;utf-8&quot;), encoding.Base64Encoder())
    sealed_box = public.SealedBox(public_key)
    encrypted = sealed_box.encrypt(secret_value.encode(&quot;utf-8&quot;))
    return b64encode(encrypted).decode(&quot;utf-8&quot;)
  </code>
   * </pre>
   * 
   * <h4>Example encrypting a secret using C#</h4>
   * <p>
   * Encrypt your secret using the
   * <a href="https://www.nuget.org/packages/Sodium.Core/">Sodium.Core</a>
   * package.
   * </p>
   * 
   * <pre>
   * <code>var secretValue = System.Text.Encoding.UTF8.GetBytes(&quot;mySecret&quot;);
  var publicKey = Convert.FromBase64String(&quot;2Sg8iYjAxxmI2LvUXpJjkYrMxURPc8r+dB7TJyvvcCU=&quot;);
  
  var sealedPublicKeyBox = Sodium.SealedPublicKeyBox.Create(secretValue, publicKey);
  
  Console.WriteLine(Convert.ToBase64String(sealedPublicKeyBox));
  </code>
   * </pre>
   * 
   * <h4>Example encrypting a secret using Ruby</h4>
   * <p>
   * Encrypt your secret using the
   * <a href="https://github.com/RubyCrypto/rbnacl">rbnacl</a> gem.
   * </p>
   * 
   * <pre>
   * <code class="language-ruby">require &quot;rbnacl&quot;
  require &quot;base64&quot;
  
  key = Base64.decode64(&quot;+ZYvJDZMHUfBkJdyq5Zm9SKqeuBQ4sj+6sfjlH4CgG0=&quot;)
  public_key = RbNaCl::PublicKey.new(key)
  
  box = RbNaCl::Boxes::Sealed.from_public_key(public_key)
  encrypted_secret = box.encrypt(&quot;my_secret&quot;)
  
  # Print the base64 encoded secret
  puts Base64.strict_encode64(encrypted_secret)
  </code>
   * </pre>
   * 
   */
  @Path("/{owner}/{repo}/actions/secrets/{secret_name}")
  @PUT
  @Consumes("application/json")
  void actions_create_or_update_repo_secret(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("secret_name") String secretName, @NotNull InputStream data);

  /**
   * <p>
   * Deletes a secret in a repository using the secret name. You must authenticate
   * using an access token with the <code>repo</code> scope to use this endpoint.
   * GitHub Apps must have the <code>secrets</code> repository permission to use
   * this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/secrets/{secret_name}")
  @DELETE
  void actions_delete_repo_secret(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("secret_name") String secretName);

  /**
   * <p>
   * Gets a redirect URL to download an archive for a repository. This URL expires
   * after 1 minute. Look for <code>Location:</code> in the response header to
   * find the URL for the download. The <code>:archive_format</code> must be
   * <code>zip</code>. Anyone with read access to the repository can use this
   * endpoint. If the repository is private you must use an access token with the
   * <code>repo</code> scope. GitHub Apps must have the <code>actions:read</code>
   * permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/artifacts/{artifact_id}/{archive_format}")
  @GET
  void actions_download_artifact(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("artifact_id") Integer artifactId, @PathParam("archive_format") String archiveFormat);

  /**
   * <p>
   * Gets a specific self-hosted runner. You must authenticate using an access
   * token with the <code>repo</code> scope to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runners/{runner_id}")
  @GET
  @Produces("application/json")
  Response actions_get_self_hosted_runner_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("runner_id") Integer runnerId);

  /**
   * <p>
   * Forces the removal of a self-hosted runner from a repository. You can use
   * this endpoint to completely remove the runner when the machine you were using
   * no longer exists. You must authenticate using an access token with the
   * <code>repo</code> scope to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runners/{runner_id}")
  @DELETE
  void actions_delete_self_hosted_runner_from_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("runner_id") Integer runnerId);

  /**
   * <p>
   * Gets a redirect URL to download a plain text file of logs for a workflow job.
   * This link expires after 1 minute. Look for <code>Location:</code> in the
   * response header to find the URL for the download. Anyone with read access to
   * the repository can use this endpoint. If the repository is private you must
   * use an access token with the <code>repo</code> scope. GitHub Apps must have
   * the <code>actions:read</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/jobs/{job_id}/logs")
  @GET
  void actions_download_job_logs_for_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("job_id") Integer jobId);

  /**
   * <p>
   * Lists jobs for a workflow run. Anyone with read access to the repository can
   * use this endpoint. If the repository is private you must use an access token
   * with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:read</code> permission to use this endpoint. You can use
   * parameters to narrow the list of results. For more information about using
   * parameters, see
   * <a href="https://developer.github.com/v3/#parameters">Parameters</a>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runs/{run_id}/jobs")
  @GET
  @Produces("application/json")
  Response actions_list_jobs_for_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") Integer runId, @QueryParam("filter") String filter, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists all self-hosted runners for a repository. You must authenticate using
   * an access token with the <code>repo</code> scope to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runners")
  @GET
  @Produces("application/json")
  Response actions_list_self_hosted_runners_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Gets a specific workflow. You can also replace <code>:workflow_id</code> with
   * <code>:workflow_file_name</code>. For example, you could use
   * <code>main.yml</code>. Anyone with read access to the repository can use this
   * endpoint. If the repository is private you must use an access token with the
   * <code>repo</code> scope. GitHub Apps must have the <code>actions:read</code>
   * permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/workflows/{workflow_id}")
  @GET
  @Produces("application/json")
  Response actions_get_workflow(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("workflow_id") Integer workflowId);

  /**
   * <p>
   * Gets a specific job in a workflow run. Anyone with read access to the
   * repository can use this endpoint. If the repository is private you must use
   * an access token with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:read</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/jobs/{job_id}")
  @GET
  @Produces("application/json")
  Response actions_get_job_for_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("job_id") Integer jobId);

  /**
   * <p>
   * Cancels a workflow run using its <code>id</code>. You must authenticate using
   * an access token with the <code>repo</code> scope to use this endpoint. GitHub
   * Apps must have the <code>actions:write</code> permission to use this
   * endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runs/{run_id}/cancel")
  @POST
  void actions_cancel_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") Integer runId);

  /**
   * <p>
   * Gets a redirect URL to download an archive of log files for a workflow run.
   * This link expires after 1 minute. Look for <code>Location:</code> in the
   * response header to find the URL for the download. Anyone with read access to
   * the repository can use this endpoint. If the repository is private you must
   * use an access token with the <code>repo</code> scope. GitHub Apps must have
   * the <code>actions:read</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runs/{run_id}/logs")
  @GET
  void actions_download_workflow_run_logs(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") Integer runId);

  /**
   * <p>
   * Deletes all logs for a workflow run. You must authenticate using an access
   * token with the <code>repo</code> scope to use this endpoint. GitHub Apps must
   * have the <code>actions:write</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runs/{run_id}/logs")
  @DELETE
  void actions_delete_workflow_run_logs(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") Integer runId);

  /**
   * <p>
   * Re-runs your workflow run using its <code>id</code>. You must authenticate
   * using an access token with the <code>repo</code> scope to use this endpoint.
   * GitHub Apps must have the <code>actions:write</code> permission to use this
   * endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runs/{run_id}/rerun")
  @POST
  void actions_re_run_workflow(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") Integer runId);

  /**
   * <p>
   * Gets a specific workflow run. Anyone with read access to the repository can
   * use this endpoint. If the repository is private you must use an access token
   * with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:read</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runs/{run_id}")
  @GET
  @Produces("application/json")
  Response actions_get_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") Integer runId);

  /**
   * <p>
   * Delete a specific workflow run. Anyone with write access to the repository
   * can use this endpoint. If the repository is private you must use an access
   * token with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:write</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runs/{run_id}")
  @DELETE
  void actions_delete_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") Integer runId);

  /**
   * <p>
   * <strong>Warning:</strong> This GitHub Actions usage endpoint is currently in
   * public beta and subject to change. For more information, see &quot;<a href=
   * "https://developer.github.com/changes/2020-05-15-actions-api-workflow-usage">GitHub
   * Actions API workflow usage</a>.&quot;
   * </p>
   * <p>
   * Gets the number of billable minutes and total run time for a specific
   * workflow run. Billable minutes only apply to workflows in private
   * repositories that use GitHub-hosted runners. Usage is listed for each
   * GitHub-hosted runner operating system in milliseconds. Any job re-runs are
   * also included in the usage. The usage does not include the multiplier for
   * macOS and Windows runners and is not rounded up to the nearest whole minute.
   * For more information, see &quot;<a href=
   * "https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-actions">Managing
   * billing for GitHub Actions</a>&quot;.
   * </p>
   * <p>
   * Anyone with read access to the repository can use this endpoint. If the
   * repository is private you must use an access token with the <code>repo</code>
   * scope. GitHub Apps must have the <code>actions:read</code> permission to use
   * this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runs/{run_id}/timing")
  @GET
  @Produces("application/json")
  Response actions_get_workflow_run_usage(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") Integer runId);

  /**
   * <p>
   * Gets your public key, which you need to encrypt secrets. You need to encrypt
   * a secret before you can create or update secrets. Anyone with read access to
   * the repository can use this endpoint. If the repository is private you must
   * use an access token with the <code>repo</code> scope. GitHub Apps must have
   * the <code>secrets</code> repository permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/secrets/public-key")
  @GET
  @Produces("application/json")
  Response actions_get_repo_public_key(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Lists artifacts for a workflow run. Anyone with read access to the repository
   * can use this endpoint. If the repository is private you must use an access
   * token with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:read</code> permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runs/{run_id}/artifacts")
  @GET
  @Produces("application/json")
  Response actions_list_workflow_run_artifacts(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") Integer runId, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Returns a token that you can pass to the <code>config</code> script. The
   * token expires after one hour. You must authenticate using an access token
   * with the <code>repo</code> scope to use this endpoint.
   * </p>
   * <h4>Example using registration token</h4>
   * <p>
   * Configure your self-hosted runner, replacing <code>TOKEN</code> with the
   * registration token provided by this endpoint.
   * </p>
   * 
   * <pre>
   * <code>./config.sh --url https://github.com/octo-org/octo-repo-artifacts --token TOKEN
  </code>
   * </pre>
   * 
   */
  @Path("/{owner}/{repo}/actions/runners/registration-token")
  @POST
  @Produces("application/json")
  Response actions_create_registration_token_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Returns a token that you can pass to remove a self-hosted runner from a
   * repository. The token expires after one hour. You must authenticate using an
   * access token with the <code>repo</code> scope to use this endpoint.
   * </p>
   * <h4>Example using remove token</h4>
   * <p>
   * To remove your self-hosted runner from a repository, replace TOKEN with the
   * remove token provided by this endpoint.
   * </p>
   * 
   * <pre>
   * <code>./config.sh remove --token TOKEN
  </code>
   * </pre>
   * 
   */
  @Path("/{owner}/{repo}/actions/runners/remove-token")
  @POST
  @Produces("application/json")
  Response actions_create_remove_token_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * List all workflow runs for a workflow. You can also replace
   * <code>:workflow_id</code> with <code>:workflow_file_name</code>. For example,
   * you could use <code>main.yml</code>. You can use parameters to narrow the
   * list of results. For more information about using parameters, see
   * <a href="https://developer.github.com/v3/#parameters">Parameters</a>.
   * </p>
   * <p>
   * Anyone with read access to the repository can use this endpoint. If the
   * repository is private you must use an access token with the <code>repo</code>
   * scope.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/workflows/{workflow_id}/runs")
  @GET
  @Produces("application/json")
  Response actions_list_workflow_runs(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("workflow_id") Integer workflowId, @QueryParam("actor") String actor,
      @QueryParam("branch") String branch, @QueryParam("event") String event, @QueryParam("status") String status,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists all workflow runs for a repository. You can use parameters to narrow
   * the list of results. For more information about using parameters, see
   * <a href="https://developer.github.com/v3/#parameters">Parameters</a>.
   * </p>
   * <p>
   * Anyone with read access to the repository can use this endpoint. If the
   * repository is private you must use an access token with the <code>repo</code>
   * scope. GitHub Apps must have the <code>actions:read</code> permission to use
   * this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/actions/runs")
  @GET
  @Produces("application/json")
  Response actions_list_workflow_runs_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("actor") String actor, @QueryParam("branch") String branch, @QueryParam("event") String event,
      @QueryParam("status") String status, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * <strong>Note:</strong> Multi-line comments on pull requests are currently in
   * public beta and subject to change.
   * </p>
   * <p>
   * Provides details for a review comment.
   * </p>
   * <p>
   * <strong>Multi-line comment summary</strong>
   * </p>
   * <p>
   * <strong>Note:</strong> New parameters and response fields are available for
   * developers to preview. During the preview period, these response fields may
   * change without advance notice. Please see the <a href=
   * "https://developer.github.com/changes/2019-10-03-multi-line-comments">blog
   * post</a> for full details.
   * </p>
   * <p>
   * Use the <code>comfort-fade</code> preview header and the <code>line</code>
   * parameter to show multi-line comment-supported fields in the response.
   * </p>
   * <p>
   * If you use the <code>comfort-fade</code> preview header, your response will
   * show:
   * </p>
   * <ul>
   * <li>For multi-line comments, values for <code>start_line</code>,
   * <code>original_start_line</code>, <code>start_side</code>, <code>line</code>,
   * <code>original_line</code>, and <code>side</code>.</li>
   * <li>For single-line comments, values for <code>line</code>,
   * <code>original_line</code>, and <code>side</code> and a <code>null</code>
   * value for <code>start_line</code>, <code>original_start_line</code>, and
   * <code>start_side</code>.</li>
   * </ul>
   * <p>
   * If you don't use the <code>comfort-fade</code> preview header, multi-line and
   * single-line comments will appear the same way in the response with a single
   * <code>position</code> attribute. Your response will show:
   * </p>
   * <ul>
   * <li>For multi-line comments, the last line of the comment range for the
   * <code>position</code> attribute.</li>
   * <li>For single-line comments, the diff-positioned way of referencing comments
   * for the <code>position</code> attribute. For more information, see
   * <code>position</code> in the
   * <a href="https://developer.github.com/v3/pulls/comments/#parameters-2">input
   * parameters</a> table.</li>
   * </ul>
   * <p>
   * The <code>reactions</code> key will have the following payload where
   * <code>url</code> can be used to construct the API location for
   * <a href="https://developer.github.com/v3/reactions">listing and creating</a>
   * reactions.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}")
  @GET
  @Produces("application/json")
  Response pulls_get_review_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId);

  /**
   * <p>
   * Deletes a review comment.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}")
  @DELETE
  void pulls_delete_review_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId);

  /**
   * <p>
   * <strong>Note:</strong> Multi-line comments on pull requests are currently in
   * public beta and subject to change.
   * </p>
   * <p>
   * Enables you to edit a review comment.
   * </p>
   * <p>
   * <strong>Multi-line comment summary</strong>
   * </p>
   * <p>
   * <strong>Note:</strong> New parameters and response fields are available for
   * developers to preview. During the preview period, these response fields may
   * change without advance notice. Please see the <a href=
   * "https://developer.github.com/changes/2019-10-03-multi-line-comments">blog
   * post</a> for full details.
   * </p>
   * <p>
   * Use the <code>comfort-fade</code> preview header and the <code>line</code>
   * parameter to show multi-line comment-supported fields in the response.
   * </p>
   * <p>
   * If you use the <code>comfort-fade</code> preview header, your response will
   * show:
   * </p>
   * <ul>
   * <li>For multi-line comments, values for <code>start_line</code>,
   * <code>original_start_line</code>, <code>start_side</code>, <code>line</code>,
   * <code>original_line</code>, and <code>side</code>.</li>
   * <li>For single-line comments, values for <code>line</code>,
   * <code>original_line</code>, and <code>side</code> and a <code>null</code>
   * value for <code>start_line</code>, <code>original_start_line</code>, and
   * <code>start_side</code>.</li>
   * </ul>
   * <p>
   * If you don't use the <code>comfort-fade</code> preview header, multi-line and
   * single-line comments will appear the same way in the response with a single
   * <code>position</code> attribute. Your response will show:
   * </p>
   * <ul>
   * <li>For multi-line comments, the last line of the comment range for the
   * <code>position</code> attribute.</li>
   * <li>For single-line comments, the diff-positioned way of referencing comments
   * for the <code>position</code> attribute. For more information, see
   * <code>position</code> in the
   * <a href="https://developer.github.com/v3/pulls/comments/#parameters-2">input
   * parameters</a> table.</li>
   * </ul>
   * 
   */
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_update_review_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Note:</strong> Multi-line comments on pull requests are currently in
   * public beta and subject to change.
   * </p>
   * <p>
   * Lists all review comments for a pull request. By default, review comments are
   * in ascending order by ID.
   * </p>
   * <p>
   * <strong>Multi-line comment summary</strong>
   * </p>
   * <p>
   * <strong>Note:</strong> New parameters and response fields are available for
   * developers to preview. During the preview period, these response fields may
   * change without advance notice. Please see the <a href=
   * "https://developer.github.com/changes/2019-10-03-multi-line-comments">blog
   * post</a> for full details.
   * </p>
   * <p>
   * Use the <code>comfort-fade</code> preview header and the <code>line</code>
   * parameter to show multi-line comment-supported fields in the response.
   * </p>
   * <p>
   * If you use the <code>comfort-fade</code> preview header, your response will
   * show:
   * </p>
   * <ul>
   * <li>For multi-line comments, values for <code>start_line</code>,
   * <code>original_start_line</code>, <code>start_side</code>, <code>line</code>,
   * <code>original_line</code>, and <code>side</code>.</li>
   * <li>For single-line comments, values for <code>line</code>,
   * <code>original_line</code>, and <code>side</code> and a <code>null</code>
   * value for <code>start_line</code>, <code>original_start_line</code>, and
   * <code>start_side</code>.</li>
   * </ul>
   * <p>
   * If you don't use the <code>comfort-fade</code> preview header, multi-line and
   * single-line comments will appear the same way in the response with a single
   * <code>position</code> attribute. Your response will show:
   * </p>
   * <ul>
   * <li>For multi-line comments, the last line of the comment range for the
   * <code>position</code> attribute.</li>
   * <li>For single-line comments, the diff-positioned way of referencing comments
   * for the <code>position</code> attribute. For more information, see
   * <code>position</code> in the
   * <a href="https://developer.github.com/v3/pulls/comments/#parameters-2">input
   * parameters</a> table.</li>
   * </ul>
   * <p>
   * The <code>reactions</code> key will have the following payload where
   * <code>url</code> can be used to construct the API location for
   * <a href="https://developer.github.com/v3/reactions">listing and creating</a>
   * reactions.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/comments")
  @GET
  @Produces("application/json")
  Response pulls_list_review_comments(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @QueryParam("sort") String sort,
      @QueryParam("direction") String direction, @QueryParam("since") String since,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * <strong>Note:</strong> Multi-line comments on pull requests are currently in
   * public beta and subject to change.
   * </p>
   * <p>
   * Creates a review comment in the pull request diff. To add a regular comment
   * to a pull request timeline, see &quot;<a href=
   * "https://developer.github.com/v3/issues/comments/#create-an-issue-comment">Create
   * an issue comment</a>.&quot; We recommend creating a review comment using
   * <code>line</code>, <code>side</code>, and optionally <code>start_line</code>
   * and <code>start_side</code> if your comment applies to more than one line in
   * the pull request diff.
   * </p>
   * <p>
   * You can still create a review comment using the <code>position</code>
   * parameter. When you use <code>position</code>, the <code>line</code>,
   * <code>side</code>, <code>start_line</code>, and <code>start_side</code>
   * parameters are not required. For more information, see <a href=
   * "https://developer.github.com/v3/pulls/comments/#multi-line-comment-summary-3">Multi-line
   * comment summary</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> The position value equals the number of lines down
   * from the first &quot;@@&quot; hunk header in the file you want to add a
   * comment. The line just below the &quot;@@&quot; line is position 1, the next
   * line is position 2, and so on. The position in the diff continues to increase
   * through lines of whitespace and additional hunks until the beginning of a new
   * file.
   * </p>
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * <p>
   * <strong>Multi-line comment summary</strong>
   * </p>
   * <p>
   * <strong>Note:</strong> New parameters and response fields are available for
   * developers to preview. During the preview period, these response fields may
   * change without advance notice. Please see the <a href=
   * "https://developer.github.com/changes/2019-10-03-multi-line-comments">blog
   * post</a> for full details.
   * </p>
   * <p>
   * Use the <code>comfort-fade</code> preview header and the <code>line</code>
   * parameter to show multi-line comment-supported fields in the response.
   * </p>
   * <p>
   * If you use the <code>comfort-fade</code> preview header, your response will
   * show:
   * </p>
   * <ul>
   * <li>For multi-line comments, values for <code>start_line</code>,
   * <code>original_start_line</code>, <code>start_side</code>, <code>line</code>,
   * <code>original_line</code>, and <code>side</code>.</li>
   * <li>For single-line comments, values for <code>line</code>,
   * <code>original_line</code>, and <code>side</code> and a <code>null</code>
   * value for <code>start_line</code>, <code>original_start_line</code>, and
   * <code>start_side</code>.</li>
   * </ul>
   * <p>
   * If you don't use the <code>comfort-fade</code> preview header, multi-line and
   * single-line comments will appear the same way in the response with a single
   * <code>position</code> attribute. Your response will show:
   * </p>
   * <ul>
   * <li>For multi-line comments, the last line of the comment range for the
   * <code>position</code> attribute.</li>
   * <li>For single-line comments, the diff-positioned way of referencing comments
   * for the <code>position</code> attribute. For more information, see
   * <code>position</code> in the
   * <a href="https://developer.github.com/v3/pulls/comments/#parameters-2">input
   * parameters</a> table.</li>
   * </ul>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_create_review_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Note:</strong> Multi-line comments on pull requests are currently in
   * public beta and subject to change.
   * </p>
   * <p>
   * Lists review comments for all pull requests in a repository. By default,
   * review comments are in ascending order by ID.
   * </p>
   * <p>
   * <strong>Multi-line comment summary</strong>
   * </p>
   * <p>
   * <strong>Note:</strong> New parameters and response fields are available for
   * developers to preview. During the preview period, these response fields may
   * change without advance notice. Please see the <a href=
   * "https://developer.github.com/changes/2019-10-03-multi-line-comments">blog
   * post</a> for full details.
   * </p>
   * <p>
   * Use the <code>comfort-fade</code> preview header and the <code>line</code>
   * parameter to show multi-line comment-supported fields in the response.
   * </p>
   * <p>
   * If you use the <code>comfort-fade</code> preview header, your response will
   * show:
   * </p>
   * <ul>
   * <li>For multi-line comments, values for <code>start_line</code>,
   * <code>original_start_line</code>, <code>start_side</code>, <code>line</code>,
   * <code>original_line</code>, and <code>side</code>.</li>
   * <li>For single-line comments, values for <code>line</code>,
   * <code>original_line</code>, and <code>side</code> and a <code>null</code>
   * value for <code>start_line</code>, <code>original_start_line</code>, and
   * <code>start_side</code>.</li>
   * </ul>
   * <p>
   * If you don't use the <code>comfort-fade</code> preview header, multi-line and
   * single-line comments will appear the same way in the response with a single
   * <code>position</code> attribute. Your response will show:
   * </p>
   * <ul>
   * <li>For multi-line comments, the last line of the comment range for the
   * <code>position</code> attribute.</li>
   * <li>For single-line comments, the diff-positioned way of referencing comments
   * for the <code>position</code> attribute. For more information, see
   * <code>position</code> in the
   * <a href="https://developer.github.com/v3/pulls/comments/#parameters-2">input
   * parameters</a> table.</li>
   * </ul>
   * <p>
   * The <code>reactions</code> key will have the following payload where
   * <code>url</code> can be used to construct the API location for
   * <a href="https://developer.github.com/v3/reactions">listing and creating</a>
   * reactions.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/comments")
  @GET
  @Produces("application/json")
  Response pulls_list_review_comments_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("sort") String sort, @QueryParam("direction") String direction, @QueryParam("since") String since,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}")
  @GET
  @Produces("application/json")
  Response pulls_get_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @PathParam("review_id") Integer reviewId);

  /**
   * <p>
   * Update the review summary comment with new text.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_update_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @PathParam("review_id") Integer reviewId,
      @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}")
  @DELETE
  @Produces("application/json")
  Response pulls_delete_pending_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @PathParam("review_id") Integer reviewId);

  /**
   * <p>
   * <strong>Note:</strong> To dismiss a pull request review on a
   * <a href="https://developer.github.com/v3/repos/branches/">protected
   * branch</a>, you must be a repository administrator or be included in the list
   * of people or teams who can dismiss pull request reviews.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}/dismissals")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_dismiss_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @PathParam("review_id") Integer reviewId,
      @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/requested_reviewers")
  @GET
  @Produces("application/json")
  Response pulls_list_requested_reviewers(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/requested_reviewers")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_request_reviewers(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/requested_reviewers")
  @DELETE
  @Consumes("application/json")
  void pulls_remove_requested_reviewers(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @NotNull InputStream data);

  /**
   * <p>
   * Draft pull requests are available in public repositories with GitHub Free and
   * GitHub Free for organizations, GitHub Pro, and legacy per-repository billing
   * plans, and in public and private repositories with GitHub Team and GitHub
   * Enterprise Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Lists details of a pull request by providing its number.
   * </p>
   * <p>
   * When you get, <a href=
   * "https://developer.github.com/v3/pulls/#create-a-pull-request">create</a>, or
   * <a href=
   * "https://developer.github.com/v3/pulls/#update-a-pull-request">edit</a> a
   * pull request, GitHub creates a merge commit to test whether the pull request
   * can be automatically merged into the base branch. This test commit is not
   * added to the base branch or the head branch. You can review the status of the
   * test commit using the <code>mergeable</code> key. For more information, see
   * &quot;<a href=
   * "https://developer.github.com/v3/git/#checking-mergeability-of-pull-requests">Checking
   * mergeability of pull requests</a>&quot;.
   * </p>
   * <p>
   * The value of the <code>mergeable</code> attribute can be <code>true</code>,
   * <code>false</code>, or <code>null</code>. If the value is <code>null</code>,
   * then GitHub has started a background job to compute the mergeability. After
   * giving the job time to complete, resubmit the request. When the job finishes,
   * you will see a non-<code>null</code> value for the <code>mergeable</code>
   * attribute in the response. If <code>mergeable</code> is <code>true</code>,
   * then <code>merge_commit_sha</code> will be the SHA of the <em>test</em> merge
   * commit.
   * </p>
   * <p>
   * The value of the <code>merge_commit_sha</code> attribute changes depending on
   * the state of the pull request. Before merging a pull request, the
   * <code>merge_commit_sha</code> attribute holds the SHA of the <em>test</em>
   * merge commit. After merging a pull request, the <code>merge_commit_sha</code>
   * attribute changes depending on how you merged the pull request:
   * </p>
   * <ul>
   * <li>If merged as a <a href=
   * "https://help.github.com/articles/about-merge-methods-on-github/">merge
   * commit</a>, <code>merge_commit_sha</code> represents the SHA of the merge
   * commit.</li>
   * <li>If merged via a <a href=
   * "https://help.github.com/articles/about-merge-methods-on-github/#squashing-your-merge-commits">squash</a>,
   * <code>merge_commit_sha</code> represents the SHA of the squashed commit on
   * the base branch.</li>
   * <li>If <a href=
   * "https://help.github.com/articles/about-merge-methods-on-github/#rebasing-and-merging-your-commits">rebased</a>,
   * <code>merge_commit_sha</code> represents the commit that the base branch was
   * updated to.</li>
   * </ul>
   * <p>
   * Pass the appropriate <a href=
   * "https://developer.github.com/v3/media/#commits-commit-comparison-and-pull-requests">media
   * type</a> to fetch diff and patch formats.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}")
  @GET
  @Produces("application/json")
  Response pulls_get(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber);

  /**
   * <p>
   * Draft pull requests are available in public repositories with GitHub Free and
   * GitHub Free for organizations, GitHub Pro, and legacy per-repository billing
   * plans, and in public and private repositories with GitHub Team and GitHub
   * Enterprise Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * To open or update a pull request in a public repository, you must have write
   * access to the head or the source branch. For organization-owned repositories,
   * you must be a member of the organization that owns the repository to open or
   * update a pull request.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_update(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @NotNull InputStream data);

  /**
   * <p>
   * The list of reviews returns in chronological order.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews")
  @GET
  @Produces("application/json")
  Response pulls_list_reviews(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * <p>
   * Pull request reviews created in the <code>PENDING</code> state do not include
   * the <code>submitted_at</code> property in the response.
   * </p>
   * <p>
   * <strong>Note:</strong> To comment on a specific line in a file, you need to
   * first determine the <em>position</em> of that line in the diff. The GitHub
   * REST API v3 offers the <code>application/vnd.github.v3.diff</code> <a href=
   * "https://developer.github.com/v3/media/#commits-commit-comparison-and-pull-requests">media
   * type</a>. To see a pull request diff, add this media type to the
   * <code>Accept</code> header of a call to the
   * <a href="https://developer.github.com/v3/pulls/#get-a-pull-request">single
   * pull request</a> endpoint.
   * </p>
   * <p>
   * The <code>position</code> value equals the number of lines down from the
   * first &quot;@@&quot; hunk header in the file you want to add a comment. The
   * line just below the &quot;@@&quot; line is position 1, the next line is
   * position 2, and so on. The position in the diff continues to increase through
   * lines of whitespace and additional hunks until the beginning of a new file.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_create_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/merge")
  @GET
  void pulls_check_if_merged(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber);

  /**
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/merge")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_merge(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @NotNull InputStream data);

  /**
   * <p>
   * Updates the pull request branch with the latest upstream changes by merging
   * HEAD from the base branch into the pull request branch.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/update-branch")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_update_branch(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Note:</strong> Responses include a maximum of 3000 files. The
   * paginated response returns 30 files per page by default.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/files")
  @GET
  @Produces("application/json")
  Response pulls_list_files(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * Draft pull requests are available in public repositories with GitHub Free and
   * GitHub Free for organizations, GitHub Pro, and legacy per-repository billing
   * plans, and in public and private repositories with GitHub Team and GitHub
   * Enterprise Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls")
  @GET
  @Produces("application/json")
  Response pulls_list(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("state") String state, @QueryParam("head") String head, @QueryParam("base") String base,
      @QueryParam("sort") String sort, @QueryParam("direction") String direction,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Draft pull requests are available in public repositories with GitHub Free and
   * GitHub Free for organizations, GitHub Pro, and legacy per-repository billing
   * plans, and in public and private repositories with GitHub Team and GitHub
   * Enterprise Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * To open or update a pull request in a public repository, you must have write
   * access to the head or the source branch. For organization-owned repositories,
   * you must be a member of the organization that owns the repository to open or
   * update a pull request.
   * </p>
   * <p>
   * You can create a new pull request.
   * </p>
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_create(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * <p>
   * Creates a reply to a review comment for a pull request. For the
   * <code>comment_id</code>, provide the ID of the review comment you are
   * replying to. This must be the ID of a <em>top-level review comment</em>, not
   * a reply to that comment. Replies to replies are not supported.
   * </p>
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/comments/{comment_id}/replies")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_create_reply_for_review_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @PathParam("comment_id") Integer commentId,
      @NotNull InputStream data);

  /**
   * <p>
   * Lists a maximum of 250 commits for a pull request. To receive a complete
   * commit list for pull requests with more than 250 commits, use the
   * <a href="https://developer.github.com/v3/repos/commits/#list-commits">List
   * commits</a> endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/commits")
  @GET
  @Produces("application/json")
  Response pulls_list_commits(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}/events")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_submit_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @PathParam("review_id") Integer reviewId,
      @NotNull InputStream data);

  /**
   * <p>
   * List comments for a specific pull request review.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}/comments")
  @GET
  @Produces("application/json")
  Response pulls_list_comments_for_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") Integer pullNumber, @PathParam("review_id") Integer reviewId,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists all open code scanning alerts for the default branch (usually
   * <code>master</code>) and protected branches in a repository. You must use an
   * access token with the <code>security_events</code> scope to use this
   * endpoint. GitHub Apps must have the <code>security_events</code> read
   * permission to use this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/code-scanning/alerts")
  @GET
  @Produces("application/json")
  Response code_scanning_list_alerts_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("state") String state, @QueryParam("ref") String ref);

  /**
   * <p>
   * Gets a single code scanning alert. You must use an access token with the
   * <code>security_events</code> scope to use this endpoint. GitHub Apps must
   * have the <code>security_events</code> read permission to use this endpoint.
   * </p>
   * <p>
   * The security <code>alert_id</code> is found at the end of the security
   * alert's URL. For example, the security alert ID for
   * <code>https://github.com/Octo-org/octo-repo/security/code-scanning/88</code>
   * is <code>88</code>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/code-scanning/alerts/{alert_id}")
  @GET
  @Produces("application/json")
  Response code_scanning_get_alert(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("alert_id") Integer alertId);

  /**
   * <p>
   * Users with push access can lock an issue or pull request's conversation.
   * </p>
   * <p>
   * Note that, if you choose not to pass any parameters, you'll need to set
   * <code>Content-Length</code> to zero when calling out to this endpoint. For
   * more information, see
   * &quot;<a href="https://developer.github.com/v3/#http-verbs">HTTP
   * verbs</a>.&quot;
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/lock")
  @PUT
  @Consumes("application/json")
  void issues_lock(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @NotNull InputStream data);

  /**
   * <p>
   * Users with push access can unlock an issue's conversation.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/lock")
  @DELETE
  void issues_unlock(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber);

  /**
   * 
   */
  @Path("/{owner}/{repo}/milestones/{milestone_number}")
  @GET
  @Produces("application/json")
  Response issues_get_milestone(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("milestone_number") Integer milestoneNumber);

  /**
   * 
   */
  @Path("/{owner}/{repo}/milestones/{milestone_number}")
  @DELETE
  void issues_delete_milestone(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("milestone_number") Integer milestoneNumber);

  /**
   * 
   */
  @Path("/{owner}/{repo}/milestones/{milestone_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_update_milestone(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("milestone_number") Integer milestoneNumber, @NotNull InputStream data);

  /**
   * <p>
   * Removes the specified label from the issue, and returns the remaining labels
   * on the issue. This endpoint returns a <code>404 Not Found</code> status if
   * the label does not exist.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/labels/{name}")
  @DELETE
  @Produces("application/json")
  Response issues_remove_label(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @PathParam("name") String name);

  /**
   * 
   */
  @Path("/{owner}/{repo}/milestones")
  @GET
  @Produces("application/json")
  Response issues_list_milestones(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("state") String state, @QueryParam("sort") String sort, @QueryParam("direction") String direction,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{owner}/{repo}/milestones")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_create_milestone(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/issues/comments/{comment_id}")
  @GET
  @Produces("application/json")
  Response issues_get_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId);

  /**
   * 
   */
  @Path("/{owner}/{repo}/issues/comments/{comment_id}")
  @DELETE
  void issues_delete_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId);

  /**
   * 
   */
  @Path("/{owner}/{repo}/issues/comments/{comment_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_update_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") Integer commentId, @NotNull InputStream data);

  /**
   * <p>
   * The API returns a <a href=
   * "https://developer.github.com/v3/#http-redirects"><code>301 Moved Permanently</code>
   * status</a> if the issue was <a href=
   * "https://help.github.com/articles/transferring-an-issue-to-another-repository/">transferred</a>
   * to another repository. If the issue was transferred to or deleted from a
   * repository where the authenticated user lacks read access, the API returns a
   * <code>404 Not Found</code> status. If the issue was deleted from a repository
   * where the authenticated user has read access, the API returns a
   * <code>410 Gone</code> status. To receive webhook events for transferred and
   * deleted issues, subscribe to the <a href=
   * "https://developer.github.com/webhooks/event-payloads/#issues"><code>issues</code></a>
   * webhook.
   * </p>
   * <p>
   * <strong>Note</strong>: GitHub's REST API v3 considers every pull request an
   * issue, but not every issue is a pull request. For this reason,
   * &quot;Issues&quot; endpoints may return both issues and pull requests in the
   * response. You can identify pull requests by the <code>pull_request</code>
   * key. Be aware that the <code>id</code> of a pull request returned from
   * &quot;Issues&quot; endpoints will be an <em>issue id</em>. To find out the
   * pull request id, use the &quot;<a href=
   * "https://developer.github.com/v3/pulls/#list-pull-requests">List pull
   * requests</a>&quot; endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}")
  @GET
  @Produces("application/json")
  Response issues_get(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber);

  /**
   * <p>
   * Issue owners and users with push access can edit an issue.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_update(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/labels/{name}")
  @GET
  @Produces("application/json")
  Response issues_get_label(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("name") String name);

  /**
   * 
   */
  @Path("/{owner}/{repo}/labels/{name}")
  @DELETE
  void issues_delete_label(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("name") String name);

  /**
   * 
   */
  @Path("/{owner}/{repo}/labels/{name}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_update_label(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("name") String name, @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/labels")
  @GET
  @Produces("application/json")
  Response issues_list_labels_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{owner}/{repo}/labels")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_create_label(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/timeline")
  @GET
  @Produces("application/json")
  Response issues_list_events_for_timeline(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists the <a href=
   * "https://help.github.com/articles/assigning-issues-and-pull-requests-to-other-github-users/">available
   * assignees</a> for issues in a repository.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/assignees")
  @GET
  @Produces("application/json")
  Response issues_list_assignees(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/labels")
  @GET
  @Produces("application/json")
  Response issues_list_labels_on_issue(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * Removes any previous labels and sets the new labels for an issue.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/labels")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_set_labels(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/labels")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_add_labels(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/labels")
  @DELETE
  void issues_remove_all_labels(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber);

  /**
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/events")
  @GET
  @Produces("application/json")
  Response issues_list_events(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * List issues in a repository.
   * </p>
   * <p>
   * <strong>Note</strong>: GitHub's REST API v3 considers every pull request an
   * issue, but not every issue is a pull request. For this reason,
   * &quot;Issues&quot; endpoints may return both issues and pull requests in the
   * response. You can identify pull requests by the <code>pull_request</code>
   * key. Be aware that the <code>id</code> of a pull request returned from
   * &quot;Issues&quot; endpoints will be an <em>issue id</em>. To find out the
   * pull request id, use the &quot;<a href=
   * "https://developer.github.com/v3/pulls/#list-pull-requests">List pull
   * requests</a>&quot; endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues")
  @GET
  @Produces("application/json")
  Response issues_list_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("milestone") String milestone, @QueryParam("state") String state,
      @QueryParam("assignee") String assignee, @QueryParam("creator") String creator,
      @QueryParam("mentioned") String mentioned, @QueryParam("labels") String labels, @QueryParam("sort") String sort,
      @QueryParam("direction") String direction, @QueryParam("since") String since,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Any user with pull access to a repository can create an issue. If
   * <a href="https://help.github.com/articles/disabling-issues/">issues are
   * disabled in the repository</a>, the API returns a <code>410 Gone</code>
   * status.
   * </p>
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_create(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * <p>
   * Issue Comments are ordered by ascending ID.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/comments")
  @GET
  @Produces("application/json")
  Response issues_list_comments(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @QueryParam("since") String since,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_create_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @NotNull InputStream data);

  /**
   * <p>
   * Adds up to 10 assignees to an issue. Users already assigned to an issue are
   * not replaced.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/assignees")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_add_assignees(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @NotNull InputStream data);

  /**
   * <p>
   * Removes one or more assignees from an issue.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/{issue_number}/assignees")
  @DELETE
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_remove_assignees(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") Integer issueNumber, @NotNull InputStream data);

  /**
   * 
   */
  @Path("/{owner}/{repo}/issues/events")
  @GET
  @Produces("application/json")
  Response issues_list_events_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Checks if a user has permission to be assigned to an issue in this
   * repository.
   * </p>
   * <p>
   * If the <code>assignee</code> can be assigned to issues in the repository, a
   * <code>204</code> header with no content is returned.
   * </p>
   * <p>
   * Otherwise a <code>404</code> status code is returned.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/assignees/{assignee}")
  @GET
  void issues_check_user_can_be_assigned(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("assignee") String assignee);

  /**
   * 
   */
  @Path("/{owner}/{repo}/milestones/{milestone_number}/labels")
  @GET
  @Produces("application/json")
  Response issues_list_labels_for_milestone(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("milestone_number") Integer milestoneNumber, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{owner}/{repo}/issues/events/{event_id}")
  @GET
  @Produces("application/json")
  Response issues_get_event(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("event_id") Integer eventId);

  /**
   * <p>
   * By default, Issue Comments are ordered by ascending ID.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/issues/comments")
  @GET
  @Produces("application/json")
  Response issues_list_comments_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("sort") String sort, @QueryParam("direction") String direction, @QueryParam("since") String since,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Enables an authenticated GitHub App to find the repository's installation
   * information. The installation's account type will be either an organization
   * or a user account, depending which account the repository belongs to.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/installation")
  @GET
  @Produces("application/json")
  Response apps_get_repo_installation(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Returns a single tree using the SHA1 value for that tree.
   * </p>
   * <p>
   * If <code>truncated</code> is <code>true</code> in the response then the
   * number of items in the <code>tree</code> array exceeded our maximum limit. If
   * you need to fetch more items, use the non-recursive method of fetching trees,
   * and fetch one sub-tree at a time.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/git/trees/{tree_sha}")
  @GET
  @Produces("application/json")
  Response git_get_tree(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("tree_sha") String treeSha, @QueryParam("recursive") String recursive);

  /**
   * <p>
   * Returns an array of references from your Git database that match the supplied
   * name. The <code>:ref</code> in the URL must be formatted as
   * <code>heads/&lt;branch name&gt;</code> for branches and
   * <code>tags/&lt;tag name&gt;</code> for tags. If the <code>:ref</code> doesn't
   * exist in the repository, but existing refs start with <code>:ref</code>, they
   * will be returned as an array.
   * </p>
   * <p>
   * When you use this endpoint without providing a <code>:ref</code>, it will
   * return an array of all the references from your Git database, including notes
   * and stashes if they exist on the server. Anything in the namespace is
   * returned, not just <code>heads</code> and <code>tags</code>.
   * </p>
   * <p>
   * <strong>Note:</strong> You need to explicitly
   * <a href="https://developer.github.com/v3/pulls/#get-a-pull-request">request a
   * pull request</a> to trigger a test merge commit, which checks the
   * mergeability of pull requests. For more information, see &quot;<a href=
   * "https://developer.github.com/v3/git/#checking-mergeability-of-pull-requests">Checking
   * mergeability of pull requests</a>&quot;.
   * </p>
   * <p>
   * If you request matching references for a branch named <code>feature</code>
   * but the branch <code>feature</code> doesn't exist, the response can still
   * include other matching head refs that start with the word
   * <code>feature</code>, such as <code>featureA</code> and
   * <code>featureB</code>.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/git/matching-refs/{ref}")
  @GET
  @Produces("application/json")
  Response git_list_matching_refs(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{owner}/{repo}/git/refs/{ref}")
  @DELETE
  void git_delete_ref(@PathParam("owner") String owner, @PathParam("repo") String repo, @PathParam("ref") String ref);

  /**
   * 
   */
  @Path("/{owner}/{repo}/git/refs/{ref}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response git_update_ref(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref, @NotNull InputStream data);

  /**
   * <p>
   * Creates a new Git <a href=
   * "https://git-scm.com/book/en/v1/Git-Internals-Git-Objects#Commit-Objects">commit
   * object</a>.
   * </p>
   * <p>
   * In this example, the payload of the signature would be:
   * </p>
   * <p>
   * <strong>Signature verification object</strong>
   * </p>
   * <p>
   * The response will include a <code>verification</code> object that describes
   * the result of verifying the commit's signature. The following fields are
   * included in the <code>verification</code> object:
   * </p>
   * <p>
   * These are the possible values for <code>reason</code> in the
   * <code>verification</code> object:
   * </p>
   * <p>
   * | Value | Description | | ------------------------ |
   * ---------------------------------------------------------------------------------------------------------------------------------
   * | | <code>expired_key</code> | The key that made the signature is expired. |
   * | <code>not_signing_key</code> | The &quot;signing&quot; flag is not among
   * the usage flags in the GPG key that made the signature. | |
   * <code>gpgverify_error</code> | There was an error communicating with the
   * signature verification service. | | <code>gpgverify_unavailable</code> | The
   * signature verification service is currently unavailable. | |
   * <code>unsigned</code> | The object does not include a signature. | |
   * <code>unknown_signature_type</code> | A non-PGP signature was found in the
   * commit. | | <code>no_user</code> | No user was associated with the
   * <code>committer</code> email address in the commit. | |
   * <code>unverified_email</code> | The <code>committer</code> email address in
   * the commit was associated with a user, but the email address is not verified
   * on her/his account. | | <code>bad_email</code> | The <code>committer</code>
   * email address in the commit is not included in the identities of the PGP key
   * that made the signature. | | <code>unknown_key</code> | The key that made the
   * signature has not been registered with any user's account. | |
   * <code>malformed_signature</code> | There was an error parsing the signature.
   * | | <code>invalid</code> | The signature could not be cryptographically
   * verified using the key whose key-id was found in the signature. | |
   * <code>valid</code> | None of the above errors applied, so the signature is
   * considered to be verified. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/git/commits")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response git_create_commit(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * <strong>Signature verification object</strong>
   * </p>
   * <p>
   * The response will include a <code>verification</code> object that describes
   * the result of verifying the commit's signature. The following fields are
   * included in the <code>verification</code> object:
   * </p>
   * <p>
   * These are the possible values for <code>reason</code> in the
   * <code>verification</code> object:
   * </p>
   * <p>
   * | Value | Description | | ------------------------ |
   * ---------------------------------------------------------------------------------------------------------------------------------
   * | | <code>expired_key</code> | The key that made the signature is expired. |
   * | <code>not_signing_key</code> | The &quot;signing&quot; flag is not among
   * the usage flags in the GPG key that made the signature. | |
   * <code>gpgverify_error</code> | There was an error communicating with the
   * signature verification service. | | <code>gpgverify_unavailable</code> | The
   * signature verification service is currently unavailable. | |
   * <code>unsigned</code> | The object does not include a signature. | |
   * <code>unknown_signature_type</code> | A non-PGP signature was found in the
   * commit. | | <code>no_user</code> | No user was associated with the
   * <code>committer</code> email address in the commit. | |
   * <code>unverified_email</code> | The <code>committer</code> email address in
   * the commit was associated with a user, but the email address is not verified
   * on her/his account. | | <code>bad_email</code> | The <code>committer</code>
   * email address in the commit is not included in the identities of the PGP key
   * that made the signature. | | <code>unknown_key</code> | The key that made the
   * signature has not been registered with any user's account. | |
   * <code>malformed_signature</code> | There was an error parsing the signature.
   * | | <code>invalid</code> | The signature could not be cryptographically
   * verified using the key whose key-id was found in the signature. | |
   * <code>valid</code> | None of the above errors applied, so the signature is
   * considered to be verified. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/git/tags/{tag_sha}")
  @GET
  @Produces("application/json")
  Response git_get_tag(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("tag_sha") String tagSha);

  /**
   * <p>
   * The tree creation API accepts nested entries. If you specify both a tree and
   * a nested path modifying that tree, this endpoint will overwrite the contents
   * of the tree with the new path contents, and create a new tree structure.
   * </p>
   * <p>
   * If you use this endpoint to add, delete, or modify the file contents in a
   * tree, you will need to commit the tree and then update a branch to point to
   * the commit. For more information see &quot;<a href=
   * "https://developer.github.com/v3/git/commits/#create-a-commit">Create a
   * commit</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/git/refs/#update-a-reference">Update a
   * reference</a>.&quot;
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/git/trees")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response git_create_tree(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * <p>
   * Creates a reference for your repository. You are unable to create new
   * references for empty repositories, even if the commit SHA-1 hash used exists.
   * Empty repositories are repositories without branches.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/git/refs")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response git_create_ref(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * <p>
   * Note that creating a tag object does not create the reference that makes a
   * tag in Git. If you want to create an annotated tag in Git, you have to do
   * this call to create the tag object, and then <a href=
   * "https://developer.github.com/v3/git/refs/#create-a-reference">create</a> the
   * <code>refs/tags/[tag]</code> reference. If you want to create a lightweight
   * tag, you only have to <a href=
   * "https://developer.github.com/v3/git/refs/#create-a-reference">create</a> the
   * tag reference - this call would be unnecessary.
   * </p>
   * <p>
   * <strong>Signature verification object</strong>
   * </p>
   * <p>
   * The response will include a <code>verification</code> object that describes
   * the result of verifying the commit's signature. The following fields are
   * included in the <code>verification</code> object:
   * </p>
   * <p>
   * These are the possible values for <code>reason</code> in the
   * <code>verification</code> object:
   * </p>
   * <p>
   * | Value | Description | | ------------------------ |
   * ---------------------------------------------------------------------------------------------------------------------------------
   * | | <code>expired_key</code> | The key that made the signature is expired. |
   * | <code>not_signing_key</code> | The &quot;signing&quot; flag is not among
   * the usage flags in the GPG key that made the signature. | |
   * <code>gpgverify_error</code> | There was an error communicating with the
   * signature verification service. | | <code>gpgverify_unavailable</code> | The
   * signature verification service is currently unavailable. | |
   * <code>unsigned</code> | The object does not include a signature. | |
   * <code>unknown_signature_type</code> | A non-PGP signature was found in the
   * commit. | | <code>no_user</code> | No user was associated with the
   * <code>committer</code> email address in the commit. | |
   * <code>unverified_email</code> | The <code>committer</code> email address in
   * the commit was associated with a user, but the email address is not verified
   * on her/his account. | | <code>bad_email</code> | The <code>committer</code>
   * email address in the commit is not included in the identities of the PGP key
   * that made the signature. | | <code>unknown_key</code> | The key that made the
   * signature has not been registered with any user's account. | |
   * <code>malformed_signature</code> | There was an error parsing the signature.
   * | | <code>invalid</code> | The signature could not be cryptographically
   * verified using the key whose key-id was found in the signature. | |
   * <code>valid</code> | None of the above errors applied, so the signature is
   * considered to be verified. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/git/tags")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response git_create_tag(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * <p>
   * Returns a single reference from your Git database. The <code>:ref</code> in
   * the URL must be formatted as <code>heads/&lt;branch name&gt;</code> for
   * branches and <code>tags/&lt;tag name&gt;</code> for tags. If the
   * <code>:ref</code> doesn't match an existing ref, a <code>404</code> is
   * returned.
   * </p>
   * <p>
   * <strong>Note:</strong> You need to explicitly
   * <a href="https://developer.github.com/v3/pulls/#get-a-pull-request">request a
   * pull request</a> to trigger a test merge commit, which checks the
   * mergeability of pull requests. For more information, see &quot;<a href=
   * "https://developer.github.com/v3/git/#checking-mergeability-of-pull-requests">Checking
   * mergeability of pull requests</a>&quot;.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/git/ref/{ref}")
  @GET
  @Produces("application/json")
  Response git_get_ref(@PathParam("owner") String owner, @PathParam("repo") String repo, @PathParam("ref") String ref);

  /**
   * 
   */
  @Path("/{owner}/{repo}/git/blobs")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response git_create_blob(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * <p>
   * The <code>content</code> in the response will always be Base64 encoded.
   * </p>
   * <p>
   * <em>Note</em>: This API supports blobs up to 100 megabytes in size.
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/git/blobs/{file_sha}")
  @GET
  @Produces("application/json")
  Response git_get_blob(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("file_sha") String fileSha);

  /**
   * <p>
   * Gets a Git <a href=
   * "https://git-scm.com/book/en/v1/Git-Internals-Git-Objects#Commit-Objects">commit
   * object</a>.
   * </p>
   * <p>
   * <strong>Signature verification object</strong>
   * </p>
   * <p>
   * The response will include a <code>verification</code> object that describes
   * the result of verifying the commit's signature. The following fields are
   * included in the <code>verification</code> object:
   * </p>
   * <p>
   * These are the possible values for <code>reason</code> in the
   * <code>verification</code> object:
   * </p>
   * <p>
   * | Value | Description | | ------------------------ |
   * ---------------------------------------------------------------------------------------------------------------------------------
   * | | <code>expired_key</code> | The key that made the signature is expired. |
   * | <code>not_signing_key</code> | The &quot;signing&quot; flag is not among
   * the usage flags in the GPG key that made the signature. | |
   * <code>gpgverify_error</code> | There was an error communicating with the
   * signature verification service. | | <code>gpgverify_unavailable</code> | The
   * signature verification service is currently unavailable. | |
   * <code>unsigned</code> | The object does not include a signature. | |
   * <code>unknown_signature_type</code> | A non-PGP signature was found in the
   * commit. | | <code>no_user</code> | No user was associated with the
   * <code>committer</code> email address in the commit. | |
   * <code>unverified_email</code> | The <code>committer</code> email address in
   * the commit was associated with a user, but the email address is not verified
   * on her/his account. | | <code>bad_email</code> | The <code>committer</code>
   * email address in the commit is not included in the identities of the PGP key
   * that made the signature. | | <code>unknown_key</code> | The key that made the
   * signature has not been registered with any user's account. | |
   * <code>malformed_signature</code> | There was an error parsing the signature.
   * | | <code>invalid</code> | The signature could not be cryptographically
   * verified using the key whose key-id was found in the signature. | |
   * <code>valid</code> | None of the above errors applied, so the signature is
   * considered to be verified. |
   * </p>
   * 
   */
  @Path("/{owner}/{repo}/git/commits/{commit_sha}")
  @GET
  @Produces("application/json")
  Response git_get_commit(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("commit_sha") String commitSha);
}
