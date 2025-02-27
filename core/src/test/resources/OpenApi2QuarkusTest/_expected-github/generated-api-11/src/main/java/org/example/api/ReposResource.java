package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
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
import java.math.BigInteger;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.Operation;

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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nLists the teams who have push access to this branch. The list includes child teams.", summary = "Get teams with access to the protected branch", operationId = "repos/get-teams-with-access-to-protected-branch")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nReplaces the list of teams that have push access to this branch. This removes all teams that previously had push access and grants push access to the new list of teams. Team restrictions include child teams.\n\n| Type    | Description                                                                                                                                |\n| ------- | ------------------------------------------------------------------------------------------------------------------------------------------ |\n| `array` | The teams that can have push access. Use the team's `slug`. **Note**: The list of users, apps, and teams in total is limited to 100 items. |", summary = "Set team access restrictions", operationId = "repos/set-team-access-restrictions")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nGrants the specified teams push access for this branch. You can also give push access to child teams.\n\n| Type    | Description                                                                                                                                |\n| ------- | ------------------------------------------------------------------------------------------------------------------------------------------ |\n| `array` | The teams that can have push access. Use the team's `slug`. **Note**: The list of users, apps, and teams in total is limited to 100 items. |", summary = "Add team access restrictions", operationId = "repos/add-team-access-restrictions")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nRemoves the ability of a team to push to this branch. You can also remove push access for child teams.\n\n| Type    | Description                                                                                                                                         |\n| ------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |\n| `array` | Teams that should no longer have push access. Use the team's `slug`. **Note**: The list of users, apps, and teams in total is limited to 100 items. |", summary = "Remove team access restrictions", operationId = "repos/remove-team-access-restrictions")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nReturns all branches where the given commit SHA is the HEAD, or latest commit for the branch.", summary = "List branches for HEAD commit", operationId = "repos/list-branches-for-head-commit")
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
  @Operation(description = "Get the top 10 popular contents over the last 14 days.", summary = "Get top referral paths", operationId = "repos/get-top-paths")
  @Path("/{owner}/{repo}/traffic/popular/paths")
  @GET
  @Produces("application/json")
  Response repos_get_top_paths(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   *
   */
  @Operation(description = "", summary = "Get a deployment", operationId = "repos/get-deployment")
  @Path("/{owner}/{repo}/deployments/{deployment_id}")
  @GET
  @Produces("application/json")
  Response repos_get_deployment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("deployment_id") BigInteger deploymentId);

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
  @Operation(description = "To ensure there can always be an active deployment, you can only delete an _inactive_ deployment. Anyone with `repo` or `repo_deployment` scopes can delete an inactive deployment.\n\nTo set a deployment as inactive, you must:\n\n*   Create a new deployment that is active so that the system has a record of the current state, then delete the previously active deployment.\n*   Mark the active deployment as inactive by adding any non-successful deployment status.\n\nFor more information, see \"[Create a deployment](https://developer.github.com/v3/repos/deployments/#create-a-deployment)\" and \"[Create a deployment status](https://developer.github.com/v3/repos/deployments/#create-a-deployment-status).\"", summary = "Delete a deployment", operationId = "repos/delete-deployment")
  @Path("/{owner}/{repo}/deployments/{deployment_id}")
  @DELETE
  void repos_delete_deployment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("deployment_id") BigInteger deploymentId);

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
  @Operation(description = "To download the asset's binary content, set the `Accept` header of the request to [`application/octet-stream`](https://developer.github.com/v3/media/#media-types). The API will either redirect the client to the location, or stream it directly if possible. API clients should handle both a `200` or `302` response.", summary = "Get a release asset", operationId = "repos/get-release-asset")
  @Path("/{owner}/{repo}/releases/assets/{asset_id}")
  @GET
  @Produces("application/json")
  Response repos_get_release_asset(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("asset_id") BigInteger assetId);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a release asset", operationId = "repos/delete-release-asset")
  @Path("/{owner}/{repo}/releases/assets/{asset_id}")
  @DELETE
  void repos_delete_release_asset(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("asset_id") BigInteger assetId);

  /**
   * <p>
   * Users with push access to the repository can edit a release asset.
   * </p>
   *
   */
  @Operation(description = "Users with push access to the repository can edit a release asset.", summary = "Update a release asset", operationId = "repos/update-release-asset")
  @Path("/{owner}/{repo}/releases/assets/{asset_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_release_asset(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("asset_id") BigInteger assetId, @NotNull InputStream data);

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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Get all status check contexts", operationId = "repos/get-all-status-check-contexts")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Set status check contexts", operationId = "repos/set-status-check-contexts")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Add status check contexts", operationId = "repos/add-status-check-contexts")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Remove status check contexts", operationId = "repos/remove-status-check-contexts")
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
  @Operation(description = "Gets the contents of a file or directory in a repository. Specify the file path or directory in `:path`. If you omit\n`:path`, you will receive the contents of all files in the repository.\n\nFiles and symlinks support [a custom media type](https://developer.github.com/v3/repos/contents/#custom-media-types) for\nretrieving the raw content or rendered HTML (when supported). All content types support [a custom media\ntype](https://developer.github.com/v3/repos/contents/#custom-media-types) to ensure the content is returned in a consistent\nobject format.\n\n**Note**:\n*   To get a repository's contents recursively, you can [recursively get the tree](https://developer.github.com/v3/git/trees/).\n*   This API has an upper limit of 1,000 files for a directory. If you need to retrieve more files, use the [Git Trees\nAPI](https://developer.github.com/v3/git/trees/#get-a-tree).\n*   This API supports files up to 1 megabyte in size.\n\n#### If the content is a directory\nThe response will be an array of objects, one object for each item in the directory.\nWhen listing the contents of a directory, submodules have their \"type\" specified as \"file\". Logically, the value\n_should_ be \"submodule\". This behavior exists in API v3 [for backwards compatibility purposes](https://git.io/v1YCW).\nIn the next major version of the API, the type will be returned as \"submodule\".\n\n#### If the content is a symlink \nIf the requested `:path` points to a symlink, and the symlink's target is a normal file in the repository, then the\nAPI responds with the content of the file (in the format shown in the example. Otherwise, the API responds with an object \ndescribing the symlink itself.\n\n#### If the content is a submodule\nThe `submodule_git_url` identifies the location of the submodule repository, and the `sha` identifies a specific\ncommit within the submodule repository. Git uses the given URL when cloning the submodule repository, and checks out\nthe submodule at that specific commit.\n\nIf the submodule repository is not hosted on github.com, the Git URLs (`git_url` and `_links[\"git\"]`) and the\ngithub.com URLs (`html_url` and `_links[\"html\"]`) will have null values.", summary = "Get repository content", operationId = "repos/get-content")
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
  @Operation(description = "Creates a new file or replaces an existing file in a repository.", summary = "Create or update file contents", operationId = "repos/create-or-update-file-contents")
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
  @Operation(description = "Deletes a file in a repository.\n\nYou can provide an additional `committer` parameter, which is an object containing information about the committer. Or, you can provide an `author` parameter, which is an object containing information about the author.\n\nThe `author` section is optional and is filled in with the `committer` information if omitted. If the `committer` information is omitted, the authenticated user's information is used.\n\nYou must provide values for both `name` and `email`, whether you choose to use `author` or `committer`. Otherwise, you'll receive a `422` status code.", summary = "Delete a file", operationId = "repos/delete-file")
  @Path("/{owner}/{repo}/contents/{path}")
  @DELETE
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_delete_file(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("path") String path, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Get all repository topics", operationId = "repos/get-all-topics")
  @Path("/{owner}/{repo}/topics")
  @GET
  @Produces("application/json")
  Response repos_get_all_topics(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   *
   */
  @Operation(description = "", summary = "Replace all repository topics", operationId = "repos/replace-all-topics")
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
  @Operation(description = "Shows whether dependency alerts are enabled or disabled for a repository. The authenticated user must have admin access to the repository. For more information, see \"[About security alerts for vulnerable dependencies](https://help.github.com/en/articles/about-security-alerts-for-vulnerable-dependencies)\".", summary = "Check if vulnerability alerts are enabled for a repository", operationId = "repos/check-vulnerability-alerts")
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
  @Operation(description = "Enables dependency alerts and the dependency graph for a repository. The authenticated user must have admin access to the repository. For more information, see \"[About security alerts for vulnerable dependencies](https://help.github.com/en/articles/about-security-alerts-for-vulnerable-dependencies)\".", summary = "Enable vulnerability alerts", operationId = "repos/enable-vulnerability-alerts")
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
  @Operation(description = "Disables dependency alerts and the dependency graph for a repository. The authenticated user must have admin access to the repository. For more information, see \"[About security alerts for vulnerable dependencies](https://help.github.com/en/articles/about-security-alerts-for-vulnerable-dependencies)\".", summary = "Disable vulnerability alerts", operationId = "repos/disable-vulnerability-alerts")
  @Path("/{owner}/{repo}/vulnerability-alerts")
  @DELETE
  void repos_disable_vulnerability_alerts(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Simple filtering of deployments is available via query parameters:
   * </p>
   *
   */
  @Operation(description = "Simple filtering of deployments is available via query parameters:", summary = "List deployments", operationId = "repos/list-deployments")
  @Path("/{owner}/{repo}/deployments")
  @GET
  @Produces("application/json")
  Response repos_list_deployments(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("sha") @DefaultValue("none") String sha, @QueryParam("ref") @DefaultValue("none") String ref,
      @QueryParam("task") @DefaultValue("none") String task,
      @QueryParam("environment") @DefaultValue("none") String environment,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Deployments offer a few configurable parameters with certain defaults.\n\nThe `ref` parameter can be any named branch, tag, or SHA. At GitHub we often deploy branches and verify them\nbefore we merge a pull request.\n\nThe `environment` parameter allows deployments to be issued to different runtime environments. Teams often have\nmultiple environments for verifying their applications, such as `production`, `staging`, and `qa`. This parameter\nmakes it easier to track which environments have requested deployments. The default environment is `production`.\n\nThe `auto_merge` parameter is used to ensure that the requested ref is not behind the repository's default branch. If\nthe ref _is_ behind the default branch for the repository, we will attempt to merge it for you. If the merge succeeds,\nthe API will return a successful merge commit. If merge conflicts prevent the merge from succeeding, the API will\nreturn a failure response.\n\nBy default, [commit statuses](https://developer.github.com/v3/repos/statuses) for every submitted context must be in a `success`\nstate. The `required_contexts` parameter allows you to specify a subset of contexts that must be `success`, or to\nspecify contexts that have not yet been submitted. You are not required to use commit statuses to deploy. If you do\nnot require any contexts or create any commit statuses, the deployment will always succeed.\n\nThe `payload` parameter is available for any extra information that a deployment system might need. It is a JSON text\nfield that will be passed on when a deployment event is dispatched.\n\nThe `task` parameter is used by the deployment system to allow different execution paths. In the web world this might\nbe `deploy:migrations` to run schema changes on the system. In the compiled world this could be a flag to compile an\napplication with debugging enabled.\n\nUsers with `repo` or `repo_deployment` scopes can create a deployment for a given ref.\n\n#### Merged branch response\nYou will see this response when GitHub automatically merges the base branch into the topic branch instead of creating\na deployment. This auto-merge happens when:\n*   Auto-merge option is enabled in the repository\n*   Topic branch does not include the latest changes on the base branch, which is `master` in the response example\n*   There are no merge conflicts\n\nIf there are no new commits in the base branch, a new request to create a deployment should give a successful\nresponse.\n\n#### Merge conflict response\nThis error happens when the `auto_merge` option is enabled and when the default branch (in this case `master`), can't\nbe merged into the branch that's being deployed (in this case `topic-branch`), due to merge conflicts.\n\n#### Failed commit status checks\nThis error happens when the `required_contexts` parameter indicates that one or more contexts need to have a `success`\nstatus for the commit to be deployed, but one or more of the required contexts do not have a state of `success`.", summary = "Create a deployment", operationId = "repos/create-deployment")
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
  @Operation(description = "This endpoint will return all community profile metrics, including an overall health score, repository description, the presence of documentation, detected code of conduct, detected license, and the presence of ISSUE\\_TEMPLATE, PULL\\_REQUEST\\_TEMPLATE, README, and CONTRIBUTING files.", summary = "Get community profile metrics", operationId = "repos/get-community-profile-metrics")
  @Path("/{owner}/{repo}/community/profile")
  @GET
  @Produces("application/json")
  Response repos_get_community_profile_metrics(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   *
   */
  @Operation(description = "", summary = "Get a GitHub Pages site", operationId = "repos/get-pages")
  @Path("/{owner}/{repo}/pages")
  @GET
  @Produces("application/json")
  Response repos_get_pages(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   *
   */
  @Operation(description = "", summary = "Update information about a GitHub Pages site", operationId = "repos/update-information-about-pages-site")
  @Path("/{owner}/{repo}/pages")
  @PUT
  @Consumes("application/json")
  void repos_update_information_about_pages_site(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Create a GitHub Pages site", operationId = "repos/create-pages-site")
  @Path("/{owner}/{repo}/pages")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_pages_site(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a GitHub Pages site", operationId = "repos/delete-pages-site")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Get pull request review protection", operationId = "repos/get-pull-request-review-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Delete pull request review protection", operationId = "repos/delete-pull-request-review-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nUpdating pull request review enforcement requires admin or owner permissions to the repository and branch protection to be enabled.\n\n**Note**: Passing new arrays of `users` and `teams` replaces their previous values.", summary = "Update pull request review protection", operationId = "repos/update-pull-request-review-protection")
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
  @Operation(description = "Get the top 10 referrers over the last 14 days.", summary = "Get top referral sources", operationId = "repos/get-top-referrers")
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
  @Operation(description = "Users with pull access in a repository can view commit statuses for a given ref. The ref can be a SHA, a branch name, or a tag name. Statuses are returned in reverse chronological order. The first status in the list will be the latest one.\n\nThis resource is also available via a legacy route: `GET /repos/:owner/:repo/statuses/:ref`.", summary = "List commit statuses for a reference", operationId = "repos/list-commit-statuses-for-ref")
  @Path("/{owner}/{repo}/commits/{ref}/statuses")
  @GET
  @Produces("application/json")
  Response repos_list_commit_statuses_for_ref(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Both `:base` and `:head` must be branch names in `:repo`. To compare branches across other repositories in the same network as `:repo`, use the format `<USERNAME>:branch`.\n\nThe response from the API is equivalent to running the `git log base..head` command; however, commits are returned in chronological order. Pass the appropriate [media type](https://developer.github.com/v3/media/#commits-commit-comparison-and-pull-requests) to fetch diff and patch formats.\n\nThe response also includes details on the files that were changed between the two commits. This includes the status of the change (for example, if a file was added, removed, modified, or renamed), and details of the change itself. For example, files with a `renamed` status have a `previous_filename` field showing the previous filename of the file, and files with a `modified` status have a `patch` field showing the changes made to the file.\n\n**Working with large comparisons**\n\nThe response will include a comparison of up to 250 commits. If you are working with a larger commit range, you can use the [List commits](https://developer.github.com/v3/repos/commits/#list-commits) to enumerate all commits in the range.\n\nFor comparisons with extremely large diffs, you may receive an error response indicating that the diff took too long to generate. You can typically resolve this error by using a smaller commit range.\n\n**Signature verification object**\n\nThe response will include a `verification` object that describes the result of verifying the commit's signature. The following fields are included in the `verification` object:\n\nThese are the possible values for `reason` in the `verification` object:\n\n| Value                    | Description                                                                                                                       |\n| ------------------------ | --------------------------------------------------------------------------------------------------------------------------------- |\n| `expired_key`            | The key that made the signature is expired.                                                                                       |\n| `not_signing_key`        | The \"signing\" flag is not among the usage flags in the GPG key that made the signature.                                           |\n| `gpgverify_error`        | There was an error communicating with the signature verification service.                                                         |\n| `gpgverify_unavailable`  | The signature verification service is currently unavailable.                                                                      |\n| `unsigned`               | The object does not include a signature.                                                                                          |\n| `unknown_signature_type` | A non-PGP signature was found in the commit.                                                                                      |\n| `no_user`                | No user was associated with the `committer` email address in the commit.                                                          |\n| `unverified_email`       | The `committer` email address in the commit was associated with a user, but the email address is not verified on her/his account. |\n| `bad_email`              | The `committer` email address in the commit is not included in the identities of the PGP key that made the signature.             |\n| `unknown_key`            | The key that made the signature has not been registered with any user's account.                                                  |\n| `malformed_signature`    | There was an error parsing the signature.                                                                                         |\n| `invalid`                | The signature could not be cryptographically verified using the key whose key-id was found in the signature.                      |\n| `valid`                  | None of the above errors applied, so the signature is considered to be verified.                                                  |", summary = "Compare two commits", operationId = "repos/compare-commits")
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
  @Operation(description = "Lists all pull requests containing the provided commit SHA, which can be from any point in the commit history. The results will include open and closed pull requests. Additional preview headers may be required to see certain details for associated pull requests, such as whether a pull request is in a draft state. For more information about previews that might affect this endpoint, see the [List pull requests](https://developer.github.com/v3/pulls/#list-pull-requests) endpoint.", summary = "List pull requests associated with a commit", operationId = "repos/list-pull-requests-associated-with-commit")
  @Path("/{owner}/{repo}/commits/{commit_sha}/pulls")
  @GET
  @Produces("application/json")
  Response repos_list_pull_requests_associated_with_commit(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @PathParam("commit_sha") String commitSha,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Get admin branch protection", operationId = "repos/get-admin-branch-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nAdding admin enforcement requires admin or owner permissions to the repository and branch protection to be enabled.", summary = "Set admin branch protection", operationId = "repos/set-admin-branch-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nRemoving admin enforcement requires admin or owner permissions to the repository and branch protection to be enabled.", summary = "Delete admin branch protection", operationId = "repos/delete-admin-branch-protection")
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
  @Operation(description = "Users with pull access can view a deployment status for a deployment:", summary = "Get a deployment status", operationId = "repos/get-deployment-status")
  @Path("/{owner}/{repo}/deployments/{deployment_id}/statuses/{status_id}")
  @GET
  @Produces("application/json")
  Response repos_get_deployment_status(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("deployment_id") BigInteger deploymentId, @PathParam("status_id") BigInteger statusId);

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
  @Operation(description = "Enables automated security fixes for a repository. The authenticated user must have admin access to the repository. For more information, see \"[Configuring automated security fixes](https://help.github.com/en/articles/configuring-automated-security-fixes)\".", summary = "Enable automated security fixes", operationId = "repos/enable-automated-security-fixes")
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
  @Operation(description = "Disables automated security fixes for a repository. The authenticated user must have admin access to the repository. For more information, see \"[Configuring automated security fixes](https://help.github.com/en/articles/configuring-automated-security-fixes)\".", summary = "Disable automated security fixes", operationId = "repos/disable-automated-security-fixes")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nWhen authenticated with admin or owner permissions to the repository, you can use this endpoint to check whether a branch requires signed commits. An enabled status of `true` indicates you must sign commits on this branch. For more information, see [Signing commits with GPG](https://help.github.com/articles/signing-commits-with-gpg) in GitHub Help.\n\n**Note**: You must enable branch protection to require signed commits.", summary = "Get commit signature protection", operationId = "repos/get-commit-signature-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nWhen authenticated with admin or owner permissions to the repository, you can use this endpoint to require signed commits on a branch. You must enable branch protection to require signed commits.", summary = "Create commit signature protection", operationId = "repos/create-commit-signature-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nWhen authenticated with admin or owner permissions to the repository, you can use this endpoint to disable required signed commits on a branch. You must enable branch protection to require signed commits.", summary = "Delete commit signature protection", operationId = "repos/delete-commit-signature-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nLists the people who have push access to this branch.", summary = "Get users with access to the protected branch", operationId = "repos/get-users-with-access-to-protected-branch")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nReplaces the list of people that have push access to this branch. This removes all people that previously had push access and grants push access to the new list of people.\n\n| Type    | Description                                                                                                                   |\n| ------- | ----------------------------------------------------------------------------------------------------------------------------- |\n| `array` | Usernames for people who can have push access. **Note**: The list of users, apps, and teams in total is limited to 100 items. |", summary = "Set user access restrictions", operationId = "repos/set-user-access-restrictions")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nGrants the specified people push access for this branch.\n\n| Type    | Description                                                                                                                   |\n| ------- | ----------------------------------------------------------------------------------------------------------------------------- |\n| `array` | Usernames for people who can have push access. **Note**: The list of users, apps, and teams in total is limited to 100 items. |", summary = "Add user access restrictions", operationId = "repos/add-user-access-restrictions")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nRemoves the ability of a user to push to this branch.\n\n| Type    | Description                                                                                                                                   |\n| ------- | --------------------------------------------------------------------------------------------------------------------------------------------- |\n| `array` | Usernames of the people who should no longer have push access. **Note**: The list of users, apps, and teams in total is limited to 100 items. |", summary = "Remove user access restrictions", operationId = "repos/remove-user-access-restrictions")
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions/users")
  @DELETE
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_remove_user_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch, @NotNull List<String> data);

  /**
   *
   */
  @Operation(description = "", summary = "List branches", operationId = "repos/list-branches")
  @Path("/{owner}/{repo}/branches")
  @GET
  @Produces("application/json")
  Response repos_list_branches(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("protected") Boolean _protected, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Get a branch", operationId = "repos/get-branch")
  @Path("/{owner}/{repo}/branches/{branch}")
  @GET
  @Produces("application/json")
  Response repos_get_branch(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   *
   */
  @Operation(description = "", summary = "List deploy keys", operationId = "repos/list-deploy-keys")
  @Path("/{owner}/{repo}/keys")
  @GET
  @Produces("application/json")
  Response repos_list_deploy_keys(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * You can create a read-only deploy key.
   * </p>
   *
   */
  @Operation(description = "You can create a read-only deploy key.", summary = "Create a deploy key", operationId = "repos/create-deploy-key")
  @Path("/{owner}/{repo}/keys")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_deploy_key(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Get GitHub Pages build", operationId = "repos/get-pages-build")
  @Path("/{owner}/{repo}/pages/builds/{build_id}")
  @GET
  @Produces("application/json")
  Response repos_get_pages_build(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("build_id") BigInteger buildId);

  /**
   * <p>
   * Get the total number of clones and breakdown per day or week for the last 14
   * days. Timestamps are aligned to UTC midnight of the beginning of the day or
   * week. Week begins on Monday.
   * </p>
   *
   */
  @Operation(description = "Get the total number of clones and breakdown per day or week for the last 14 days. Timestamps are aligned to UTC midnight of the beginning of the day or week. Week begins on Monday.", summary = "Get repository clones", operationId = "repos/get-clones")
  @Path("/{owner}/{repo}/traffic/clones")
  @GET
  @Produces("application/json")
  Response repos_get_clones(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per") @DefaultValue("day") String per);

  /**
   *
   */
  @Operation(description = "", summary = "Get a repository webhook", operationId = "repos/get-webhook")
  @Path("/{owner}/{repo}/hooks/{hook_id}")
  @GET
  @Produces("application/json")
  Response repos_get_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("hook_id") BigInteger hookId);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a repository webhook", operationId = "repos/delete-webhook")
  @Path("/{owner}/{repo}/hooks/{hook_id}")
  @DELETE
  void repos_delete_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("hook_id") BigInteger hookId);

  /**
   *
   */
  @Operation(description = "", summary = "Update a repository webhook", operationId = "repos/update-webhook")
  @Path("/{owner}/{repo}/hooks/{hook_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("hook_id") BigInteger hookId, @NotNull InputStream data);

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
  @Operation(description = "This returns a list of releases, which does not include regular Git tags that have not been associated with a release. To get a list of Git tags, use the [Repository Tags API](https://developer.github.com/v3/repos/#list-repository-tags).\n\nInformation about published releases are available to everyone. Only users with push access will receive listings for draft releases.", summary = "List releases", operationId = "repos/list-releases")
  @Path("/{owner}/{repo}/releases")
  @GET
  @Produces("application/json")
  Response repos_list_releases(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Users with push access to the repository can create a release.\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Create a release", operationId = "repos/create-release")
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
  @Operation(description = "Creates a new repository using a repository template. Use the `template_owner` and `template_repo` route parameters to specify the repository to use as the template. The authenticated user must own or be a member of an organization that owns the repository. To check if a repository is available to use as a template, get the repository's information using the [Get a repository](https://developer.github.com/v3/repos/#get-a-repository) endpoint and check that the `is_template` key is `true`.\n\n**OAuth scope requirements**\n\nWhen using [OAuth](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/), authorizations must include:\n\n*   `public_repo` scope or `repo` scope to create a public repository\n*   `repo` scope to create a private repository", summary = "Create a repository using a template", operationId = "repos/create-using-template")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Get status checks protection", operationId = "repos/get-status-checks-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Remove status check protection", operationId = "repos/remove-status-check-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nUpdating required status checks requires admin or owner permissions to the repository and branch protection to be enabled.", summary = "Update status check protection", operationId = "repos/update-status-check-protection")
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
  @Operation(description = "When you pass the `scarlet-witch-preview` media type, requests to get a repository will also return the repository's code of conduct if it can be detected from the repository's code of conduct file.\n\nThe `parent` and `source` objects are present when the repository is a fork. `parent` is the repository this repository was forked from, `source` is the ultimate source for the network.", summary = "Get a repository", operationId = "repos/get")
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
  @Operation(description = "Deleting a repository requires admin access. If OAuth is used, the `delete_repo` scope is required.\n\nIf an organization owner has configured the organization to prevent members from deleting organization-owned\nrepositories, you will get a `403 Forbidden` response.", summary = "Delete a repository", operationId = "repos/delete")
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
  @Operation(description = "**Note**: To edit a repository's topics, use the [Replace all repository topics](https://developer.github.com/v3/repos/#replace-all-repository-topics) endpoint.", summary = "Update a repository", operationId = "repos/update")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nLists who has access to this protected branch.\n\n**Note**: Users, apps, and teams `restrictions` are only available for organization-owned repositories.", summary = "Get access restrictions", operationId = "repos/get-access-restrictions")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nDisables the ability to restrict who can push to this branch.", summary = "Delete access restrictions", operationId = "repos/delete-access-restrictions")
  @Path("/{owner}/{repo}/branches/{branch}/protection/restrictions")
  @DELETE
  void repos_delete_access_restrictions(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("branch") String branch);

  /**
   *
   */
  @Operation(description = "", summary = "Get a deploy key", operationId = "repos/get-deploy-key")
  @Path("/{owner}/{repo}/keys/{key_id}")
  @GET
  @Produces("application/json")
  Response repos_get_deploy_key(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("key_id") BigInteger keyId);

  /**
   * <p>
   * Deploy keys are immutable. If you need to update a key, remove the key and
   * create a new one instead.
   * </p>
   *
   */
  @Operation(description = "Deploy keys are immutable. If you need to update a key, remove the key and create a new one instead.", summary = "Delete a deploy key", operationId = "repos/delete-deploy-key")
  @Path("/{owner}/{repo}/keys/{key_id}")
  @DELETE
  void repos_delete_deploy_key(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("key_id") BigInteger keyId);

  /**
   * <p>
   * <strong>Note:</strong> This returns an <code>upload_url</code> key
   * corresponding to the endpoint for uploading release assets. This key is a
   * <a href="https://developer.github.com/v3/#hypermedia">hypermedia
   * resource</a>.
   * </p>
   *
   */
  @Operation(description = "**Note:** This returns an `upload_url` key corresponding to the endpoint for uploading release assets. This key is a [hypermedia resource](https://developer.github.com/v3/#hypermedia).", summary = "Get a release", operationId = "repos/get-release")
  @Path("/{owner}/{repo}/releases/{release_id}")
  @GET
  @Produces("application/json")
  Response repos_get_release(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("release_id") BigInteger releaseId);

  /**
   * <p>
   * Users with push access to the repository can delete a release.
   * </p>
   *
   */
  @Operation(description = "Users with push access to the repository can delete a release.", summary = "Delete a release", operationId = "repos/delete-release")
  @Path("/{owner}/{repo}/releases/{release_id}")
  @DELETE
  void repos_delete_release(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("release_id") BigInteger releaseId);

  /**
   * <p>
   * Users with push access to the repository can edit a release.
   * </p>
   *
   */
  @Operation(description = "Users with push access to the repository can edit a release.", summary = "Update a release", operationId = "repos/update-release")
  @Path("/{owner}/{repo}/releases/{release_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_release(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("release_id") BigInteger releaseId, @NotNull InputStream data);

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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Get branch protection", operationId = "repos/get-branch-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nProtecting a branch requires admin or owner permissions to the repository.\n\n**Note**: Passing new arrays of `users` and `teams` replaces their previous values.\n\n**Note**: The list of users, apps, and teams in total is limited to 100 items.", summary = "Update branch protection", operationId = "repos/update-branch-protection")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "Delete branch protection", operationId = "repos/delete-branch-protection")
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
  @Operation(description = "When authenticating as a user with admin rights to a repository, this endpoint will list all currently open repository invitations.", summary = "List repository invitations", operationId = "repos/list-invitations")
  @Path("/{owner}/{repo}/invitations")
  @GET
  @Produces("application/json")
  Response repos_list_invitations(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * This will trigger a
   * <a href="https://developer.github.com/webhooks/#ping-event">ping event</a> to
   * be sent to the hook.
   * </p>
   *
   */
  @Operation(description = "This will trigger a [ping event](https://developer.github.com/webhooks/#ping-event) to be sent to the hook.", summary = "Ping a repository webhook", operationId = "repos/ping-webhook")
  @Path("/{owner}/{repo}/hooks/{hook_id}/pings")
  @POST
  void repos_ping_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("hook_id") BigInteger hookId);

  /**
   *
   */
  @Operation(description = "", summary = "List repository tags", operationId = "repos/list-tags")
  @Path("/{owner}/{repo}/tags")
  @GET
  @Produces("application/json")
  Response repos_list_tags(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "List repository teams", operationId = "repos/list-teams")
  @Path("/{owner}/{repo}/teams")
  @GET
  @Produces("application/json")
  Response repos_list_teams(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Returns the last year of commit activity grouped by week. The
   * <code>days</code> array is a group of commits per day, starting on
   * <code>Sunday</code>.
   * </p>
   *
   */
  @Operation(description = "Returns the last year of commit activity grouped by week. The `days` array is a group of commits per day, starting on `Sunday`.", summary = "Get the last year of commit activity", operationId = "repos/get-commit-activity-stats")
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
  @Operation(description = "Lists languages for the specified repository. The value shown for each language is the number of bytes of code written in that language.", summary = "List repository languages", operationId = "repos/list-languages")
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
  @Operation(description = "You can use this endpoint to trigger a webhook event called `repository_dispatch` when you want activity that happens outside of GitHub to trigger a GitHub Actions workflow or GitHub App webhook. You must configure your GitHub Actions workflow or GitHub App to run when the `repository_dispatch` event occurs. For an example `repository_dispatch` webhook payload, see \"[RepositoryDispatchEvent](https://developer.github.com/webhooks/event-payloads/#repository_dispatch).\"\n\nThe `client_payload` parameter is available for any extra information that your workflow might need. This parameter is a JSON payload that will be passed on when the webhook event is dispatched. For example, the `client_payload` can include a message that a user would like to send using a GitHub Actions workflow. Or the `client_payload` can be used as a test to debug your workflow. For a test example, see the [input example](https://developer.github.com/v3/repos/#example-4).\n\nTo give you write access to the repository, you must use a personal access token with the `repo` scope. For more information, see \"[Creating a personal access token for the command line](https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line)\" in the GitHub Help documentation.\n\nThis input example shows how you can use the `client_payload` as a test to debug your workflow.", summary = "Create a repository dispatch event", operationId = "repos/create-dispatch-event")
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
  @Operation(description = "Each array contains the day number, hour number, and number of commits:\n\n*   `0-6`: Sunday - Saturday\n*   `0-23`: Hour of day\n*   Number of commits\n\nFor example, `[2, 14, 25]` indicates that there were 25 total commits, during the 2:00pm hour on Tuesdays. All times are based on the time zone of individual commits.", summary = "Get the hourly commit count for each day", operationId = "repos/get-punch-card-stats")
  @Path("/{owner}/{repo}/stats/punch_card")
  @GET
  @Produces("application/json")
  List<BigInteger> repos_get_punch_card_stats(@PathParam("owner") String owner, @PathParam("repo") String repo);

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
  @Operation(description = "A transfer request will need to be accepted by the new owner when transferring a personal repository to another user. The response will contain the original `owner`, and the transfer will continue asynchronously. For more details on the requirements to transfer personal and organization-owned repositories, see [about repository transfers](https://help.github.com/articles/about-repository-transfers/).", summary = "Transfer a repository", operationId = "repos/transfer")
  @Path("/{owner}/{repo}/transfer")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_transfer(@PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List GitHub Pages builds", operationId = "repos/list-pages-builds")
  @Path("/{owner}/{repo}/pages/builds")
  @GET
  @Produces("application/json")
  Response repos_list_pages_builds(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "You can request that your site be built from the latest revision on the default branch. This has the same effect as pushing a commit to your default branch, but does not require an additional commit. Manually triggering page builds can be helpful when diagnosing build warnings and failures.\n\nBuild requests are limited to one concurrent build per repository and one concurrent build per requester. If you request a build while another is still in progress, the second request will be queued until the first completes.", summary = "Request a GitHub Pages build", operationId = "repos/request-pages-build")
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
  @Operation(description = "For organization-owned repositories, the list of collaborators includes outside collaborators, organization members that are direct collaborators, organization members with access through team memberships, organization members with access through default organization permissions, and organization owners.\n\nTeam members will include the members of child teams.", summary = "Check if a user is a repository collaborator", operationId = "repos/check-collaborator")
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
  @Operation(description = "This endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.\n\nFor more information the permission levels, see \"[Repository permission levels for an organization](https://help.github.com/en/github/setting-up-and-managing-organizations-and-teams/repository-permission-levels-for-an-organization#permission-levels-for-repositories-owned-by-an-organization)\".\n\nNote that, if you choose not to pass any parameters, you'll need to set `Content-Length` to zero when calling out to this endpoint. For more information, see \"[HTTP verbs](https://developer.github.com/v3/#http-verbs).\"\n\nThe invitee will receive a notification that they have been invited to the repository, which they must accept or decline. They may do this via the notifications page, the email they receive, or by using the [repository invitations API endpoints](https://developer.github.com/v3/repos/invitations/).\n\n**Rate limits**\n\nTo prevent abuse, you are limited to sending 50 invitations to a repository per 24 hour period. Note there is no limit if you are inviting organization members to an organization repository.", summary = "Add a repository collaborator", operationId = "repos/add-collaborator")
  @Path("/{owner}/{repo}/collaborators/{username}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_add_collaborator(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("username") String username, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Remove a repository collaborator", operationId = "repos/remove-collaborator")
  @Path("/{owner}/{repo}/collaborators/{username}")
  @DELETE
  void repos_remove_collaborator(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("username") String username);

  /**
   *
   */
  @Operation(description = "", summary = "List forks", operationId = "repos/list-forks")
  @Path("/{owner}/{repo}/forks")
  @GET
  @Produces("application/json")
  Response repos_list_forks(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("sort") @DefaultValue("newest") String sort,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Create a fork for the authenticated user.\n\n**Note**: Forking a Repository happens asynchronously. You may have to wait a short period of time before you can access the git objects. If this takes longer than 5 minutes, be sure to contact [GitHub Support](https://github.com/contact) or [GitHub Premium Support](https://premium.githubsupport.com).", summary = "Create a fork", operationId = "repos/create-fork")
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
  @Operation(description = "Get the total number of views and breakdown per day or week for the last 14 days. Timestamps are aligned to UTC midnight of the beginning of the day or week. Week begins on Monday.", summary = "Get page views", operationId = "repos/get-views")
  @Path("/{owner}/{repo}/traffic/views")
  @GET
  @Produces("application/json")
  Response repos_get_views(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per") @DefaultValue("day") String per);

  /**
   *
   */
  @Operation(description = "", summary = "List release assets", operationId = "repos/list-release-assets")
  @Path("/{owner}/{repo}/releases/{release_id}/assets")
  @GET
  @Produces("application/json")
  Response repos_list_release_assets(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("release_id") BigInteger releaseId, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "This endpoint makes use of [a Hypermedia relation](https://developer.github.com/v3/#hypermedia) to determine which URL to access. The endpoint you call to upload release assets is specific to your release. Use the `upload_url` returned in\nthe response of the [Create a release endpoint](https://developer.github.com/v3/repos/releases/#create-a-release) to upload a release asset.\n\nYou need to use an HTTP client which supports [SNI](http://en.wikipedia.org/wiki/Server_Name_Indication) to make calls to this endpoint.\n\nMost libraries will set the required `Content-Length` header automatically. Use the required `Content-Type` header to provide the media type of the asset. For a list of media types, see [Media Types](https://www.iana.org/assignments/media-types/media-types.xhtml). For example: \n\n`application/zip`\n\nGitHub expects the asset data in its raw binary form, rather than JSON. You will send the raw binary content of the asset as the request body. Everything else about the endpoint is the same as the rest of the API. For example,\nyou'll still need to pass your authentication to be able to upload an asset.\n\nWhen an upstream failure occurs, you will receive a `502 Bad Gateway` status. This may leave an empty asset with a state of `starter`. It can be safely deleted.\n\n**Notes:**\n*   GitHub renames asset filenames that have special characters, non-alphanumeric characters, and leading or trailing periods. The \"[List assets for a release](https://developer.github.com/v3/repos/releases/#list-assets-for-a-release)\"\nendpoint lists the renamed filenames. For more information and help, contact [GitHub Support](https://github.com/contact).\n*   If you upload an asset with the same filename as another uploaded asset, you'll receive an error and must delete the old file before you can re-upload the new asset.", summary = "Upload a release asset", operationId = "repos/upload-release-asset")
  @Path("/{owner}/{repo}/releases/{release_id}/assets")
  @POST
  @Produces("application/json")
  @Consumes("*/*")
  Response repos_upload_release_asset(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("release_id") BigInteger releaseId, @QueryParam("name") String name, @QueryParam("label") String label,
      @NotNull String data);

  /**
   *
   */
  @Operation(description = "", summary = "Get a commit comment", operationId = "repos/get-commit-comment")
  @Path("/{owner}/{repo}/comments/{comment_id}")
  @GET
  @Produces("application/json")
  Response repos_get_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a commit comment", operationId = "repos/delete-commit-comment")
  @Path("/{owner}/{repo}/comments/{comment_id}")
  @DELETE
  void repos_delete_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId);

  /**
   *
   */
  @Operation(description = "", summary = "Update a commit comment", operationId = "repos/update-commit-comment")
  @Path("/{owner}/{repo}/comments/{comment_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId, @NotNull InputStream data);

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
  @Operation(description = "This will trigger the hook with the latest push to the current repository if the hook is subscribed to `push` events. If the hook is not subscribed to `push` events, the server will respond with 204 but no test POST will be generated.\n\n**Note**: Previously `/repos/:owner/:repo/hooks/:hook_id/test`", summary = "Test the push repository webhook", operationId = "repos/test-push-webhook")
  @Path("/{owner}/{repo}/hooks/{hook_id}/tests")
  @POST
  void repos_test_push_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("hook_id") BigInteger hookId);

  /**
   *
   */
  @Operation(description = "", summary = "List repository webhooks", operationId = "repos/list-webhooks")
  @Path("/{owner}/{repo}/hooks")
  @GET
  @Produces("application/json")
  Response repos_list_webhooks(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Repositories can have multiple webhooks installed. Each webhook should have a
   * unique <code>config</code>. Multiple webhooks can share the same
   * <code>config</code> as long as those webhooks do not have any
   * <code>events</code> that overlap.
   * </p>
   *
   */
  @Operation(description = "Repositories can have multiple webhooks installed. Each webhook should have a unique `config`. Multiple webhooks can\nshare the same `config` as long as those webhooks do not have any `events` that overlap.", summary = "Create a repository webhook", operationId = "repos/create-webhook")
  @Path("/{owner}/{repo}/hooks")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_webhook(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Get latest Pages build", operationId = "repos/get-latest-pages-build")
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
  @Operation(description = "Use the `:commit_sha` to specify the commit that will have its comments listed.", summary = "List commit comments", operationId = "repos/list-comments-for-commit")
  @Path("/{owner}/{repo}/commits/{commit_sha}/comments")
  @GET
  @Produces("application/json")
  Response repos_list_comments_for_commit(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("commit_sha") String commitSha, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Create a comment for a commit using its `:commit_sha`.\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Create a commit comment", operationId = "repos/create-commit-comment")
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
  @Operation(description = "Returns the total commit counts for the `owner` and total commit counts in `all`. `all` is everyone combined, including the `owner` in the last 52 weeks. If you'd like to get the commit counts for non-owners, you can subtract `owner` from `all`.\n\nThe array order is oldest week (index 0) to most recent week.", summary = "Get the weekly commit count", operationId = "repos/get-participation-stats")
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
  @Operation(description = "**Signature verification object**\n\nThe response will include a `verification` object that describes the result of verifying the commit's signature. The following fields are included in the `verification` object:\n\nThese are the possible values for `reason` in the `verification` object:\n\n| Value                    | Description                                                                                                                       |\n| ------------------------ | --------------------------------------------------------------------------------------------------------------------------------- |\n| `expired_key`            | The key that made the signature is expired.                                                                                       |\n| `not_signing_key`        | The \"signing\" flag is not among the usage flags in the GPG key that made the signature.                                           |\n| `gpgverify_error`        | There was an error communicating with the signature verification service.                                                         |\n| `gpgverify_unavailable`  | The signature verification service is currently unavailable.                                                                      |\n| `unsigned`               | The object does not include a signature.                                                                                          |\n| `unknown_signature_type` | A non-PGP signature was found in the commit.                                                                                      |\n| `no_user`                | No user was associated with the `committer` email address in the commit.                                                          |\n| `unverified_email`       | The `committer` email address in the commit was associated with a user, but the email address is not verified on her/his account. |\n| `bad_email`              | The `committer` email address in the commit is not included in the identities of the PGP key that made the signature.             |\n| `unknown_key`            | The key that made the signature has not been registered with any user's account.                                                  |\n| `malformed_signature`    | There was an error parsing the signature.                                                                                         |\n| `invalid`                | The signature could not be cryptographically verified using the key whose key-id was found in the signature.                      |\n| `valid`                  | None of the above errors applied, so the signature is considered to be verified.                                                  |", summary = "List commits", operationId = "repos/list-commits")
  @Path("/{owner}/{repo}/commits")
  @GET
  @Produces("application/json")
  Response repos_list_commits(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("sha") String sha, @QueryParam("path") String path, @QueryParam("author") String author,
      @QueryParam("since") String since, @QueryParam("until") String until,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nLists the GitHub Apps that have push access to this branch. Only installed GitHub Apps with `write` access to the `contents` permission can be added as authorized actors on a protected branch.", summary = "Get apps with access to the protected branch", operationId = "repos/get-apps-with-access-to-protected-branch")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nReplaces the list of apps that have push access to this branch. This removes all apps that previously had push access and grants push access to the new list of apps. Only installed GitHub Apps with `write` access to the `contents` permission can be added as authorized actors on a protected branch.\n\n| Type    | Description                                                                                                                                                |\n| ------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |\n| `array` | The GitHub Apps that have push access to this branch. Use the app's `slug`. **Note**: The list of users, apps, and teams in total is limited to 100 items. |", summary = "Set app access restrictions", operationId = "repos/set-app-access-restrictions")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nGrants the specified apps push access for this branch. Only installed GitHub Apps with `write` access to the `contents` permission can be added as authorized actors on a protected branch.\n\n| Type    | Description                                                                                                                                                |\n| ------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |\n| `array` | The GitHub Apps that have push access to this branch. Use the app's `slug`. **Note**: The list of users, apps, and teams in total is limited to 100 items. |", summary = "Add app access restrictions", operationId = "repos/add-app-access-restrictions")
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
  @Operation(description = "Protected branches are available in public repositories with GitHub Free and GitHub Free for organizations, and in public and private repositories with GitHub Pro, GitHub Team, GitHub Enterprise Cloud, and GitHub Enterprise Server. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nRemoves the ability of an app to push to this branch. Only installed GitHub Apps with `write` access to the `contents` permission can be added as authorized actors on a protected branch.\n\n| Type    | Description                                                                                                                                                |\n| ------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |\n| `array` | The GitHub Apps that have push access to this branch. Use the app's `slug`. **Note**: The list of users, apps, and teams in total is limited to 100 items. |", summary = "Remove app access restrictions", operationId = "repos/remove-app-access-restrictions")
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
  @Operation(description = "Get a published release with the specified tag.", summary = "Get a release by tag name", operationId = "repos/get-release-by-tag")
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
  @Operation(description = "Gets a redirect URL to download a zip archive for a repository. If you omit `:ref`, the repository\u2019s default branch (usually\n`master`) will be used. Please make sure your HTTP framework is configured to follow redirects or you will need to use\nthe `Location` header to make a second `GET` request.\n**Note**: For private repositories, these links are temporary and expire after five minutes.", summary = "Download a repository archive (zip)", operationId = "repos/download-zipball-archive")
  @Path("/{owner}/{repo}/zipball/{ref}")
  @GET
  void repos_download_zipball_archive(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a repository invitation", operationId = "repos/delete-invitation")
  @Path("/{owner}/{repo}/invitations/{invitation_id}")
  @DELETE
  void repos_delete_invitation(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("invitation_id") BigInteger invitationId);

  /**
   *
   */
  @Operation(description = "", summary = "Update a repository invitation", operationId = "repos/update-invitation")
  @Path("/{owner}/{repo}/invitations/{invitation_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_update_invitation(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("invitation_id") BigInteger invitationId, @NotNull InputStream data);

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
  @Operation(description = "Users with pull access in a repository can access a combined view of commit statuses for a given ref. The ref can be a SHA, a branch name, or a tag name.\n\nThe most recent status for each context is returned, up to 100. This field [paginates](https://developer.github.com/v3/#pagination) if there are over 100 contexts.\n\nAdditionally, a combined `state` is returned. The `state` is one of:\n\n*   **failure** if any of the contexts report as `error` or `failure`\n*   **pending** if there are no statuses or a context is `pending`\n*   **success** if the latest status for all contexts is `success`", summary = "Get the combined status for a specific reference", operationId = "repos/get-combined-status-for-ref")
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
  @Operation(description = "Users with push access in a repository can create commit statuses for a given SHA.\n\nNote: there is a limit of 1000 statuses per `sha` and `context` within a repository. Attempts to create more than 1000 statuses will result in a validation error.", summary = "Create a commit status", operationId = "repos/create-commit-status")
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
  @Operation(description = "Users with pull access can view deployment statuses for a deployment:", summary = "List deployment statuses", operationId = "repos/list-deployment-statuses")
  @Path("/{owner}/{repo}/deployments/{deployment_id}/statuses")
  @GET
  @Produces("application/json")
  Response repos_list_deployment_statuses(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("deployment_id") BigInteger deploymentId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Users with `push` access can create deployment statuses for a given deployment.\n\nGitHub Apps require `read & write` access to \"Deployments\" and `read-only` access to \"Repo contents\" (for private repos). OAuth Apps require the `repo_deployment` scope.", summary = "Create a deployment status", operationId = "repos/create-deployment-status")
  @Path("/{owner}/{repo}/deployments/{deployment_id}/statuses")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_deployment_status(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("deployment_id") BigInteger deploymentId, @NotNull InputStream data);

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
  @Operation(description = "Gets a redirect URL to download a tar archive for a repository. If you omit `:ref`, the repository\u2019s default branch (usually\n`master`) will be used. Please make sure your HTTP framework is configured to follow redirects or you will need to use\nthe `Location` header to make a second `GET` request.\n**Note**: For private repositories, these links are temporary and expire after five minutes.", summary = "Download a repository archive (tar)", operationId = "repos/download-tarball-archive")
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
  @Operation(description = "\nReturns the `total` number of commits authored by the contributor. In addition, the response includes a Weekly Hash (`weeks` array) with the following information:\n\n*   `w` - Start of the week, given as a [Unix timestamp](http://en.wikipedia.org/wiki/Unix_time).\n*   `a` - Number of additions\n*   `d` - Number of deletions\n*   `c` - Number of commits", summary = "Get all contributor commit activity", operationId = "repos/get-contributors-stats")
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
  @Operation(description = "Gets the preferred README for a repository.\n\nREADMEs support [custom media types](https://developer.github.com/v3/repos/contents/#custom-media-types) for retrieving the raw content or rendered HTML.", summary = "Get a repository README", operationId = "repos/get-readme")
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
  @Operation(description = "Commit Comments use [these custom media types](https://developer.github.com/v3/repos/comments/#custom-media-types). You can read more about the use of media types in the API [here](https://developer.github.com/v3/media/).\n\nComments are ordered by ascending ID.", summary = "List commit comments for a repository", operationId = "repos/list-commit-comments-for-repo")
  @Path("/{owner}/{repo}/comments")
  @GET
  @Produces("application/json")
  Response repos_list_commit_comments_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Returns the contents of a single commit reference. You must have `read` access for the repository to use this endpoint.\n\nYou can pass the appropriate [media type](https://developer.github.com/v3/media/#commits-commit-comparison-and-pull-requests) to fetch `diff` and `patch` formats. Diffs with binary data will have no `patch` property.\n\nTo return only the SHA-1 hash of the commit reference, you can provide the `sha` custom [media type](https://developer.github.com/v3/media/#commits-commit-comparison-and-pull-requests) in the `Accept` header. You can use this endpoint to check if a remote reference's SHA-1 hash is the same as your local reference's SHA-1 hash by providing the local SHA-1 reference as the ETag.\n\n**Signature verification object**\n\nThe response will include a `verification` object that describes the result of verifying the commit's signature. The following fields are included in the `verification` object:\n\nThese are the possible values for `reason` in the `verification` object:\n\n| Value                    | Description                                                                                                                       |\n| ------------------------ | --------------------------------------------------------------------------------------------------------------------------------- |\n| `expired_key`            | The key that made the signature is expired.                                                                                       |\n| `not_signing_key`        | The \"signing\" flag is not among the usage flags in the GPG key that made the signature.                                           |\n| `gpgverify_error`        | There was an error communicating with the signature verification service.                                                         |\n| `gpgverify_unavailable`  | The signature verification service is currently unavailable.                                                                      |\n| `unsigned`               | The object does not include a signature.                                                                                          |\n| `unknown_signature_type` | A non-PGP signature was found in the commit.                                                                                      |\n| `no_user`                | No user was associated with the `committer` email address in the commit.                                                          |\n| `unverified_email`       | The `committer` email address in the commit was associated with a user, but the email address is not verified on her/his account. |\n| `bad_email`              | The `committer` email address in the commit is not included in the identities of the PGP key that made the signature.             |\n| `unknown_key`            | The key that made the signature has not been registered with any user's account.                                                  |\n| `malformed_signature`    | There was an error parsing the signature.                                                                                         |\n| `invalid`                | The signature could not be cryptographically verified using the key whose key-id was found in the signature.                      |\n| `valid`                  | None of the above errors applied, so the signature is considered to be verified.                                                  |", summary = "Get a commit", operationId = "repos/get-commit")
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
  @Operation(description = "View the latest published full release for the repository.\n\nThe latest release is the most recent non-prerelease, non-draft release, sorted by the `created_at` attribute. The `created_at` attribute is the date of the commit used for the release, and not the date when the release was drafted or published.", summary = "Get the latest release", operationId = "repos/get-latest-release")
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
  @Operation(description = "Returns a weekly aggregate of the number of additions and deletions pushed to a repository.", summary = "Get the weekly commit activity", operationId = "repos/get-code-frequency-stats")
  @Path("/{owner}/{repo}/stats/code_frequency")
  @GET
  @Produces("application/json")
  List<BigInteger> repos_get_code_frequency_stats(@PathParam("owner") String owner, @PathParam("repo") String repo);

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
  @Operation(description = "Lists contributors to the specified repository and sorts them by the number of commits per contributor in descending order. This endpoint may return information that is a few hours old because the GitHub REST API v3 caches contributor data to improve performance.\n\nGitHub identifies contributors by author email address. This endpoint groups contribution counts by GitHub user, which includes all associated email addresses. To improve performance, only the first 500 author email addresses in the repository link to GitHub users. The rest will appear as anonymous contributors without associated GitHub user information.", summary = "List repository contributors", operationId = "repos/list-contributors")
  @Path("/{owner}/{repo}/contributors")
  @GET
  @Produces("application/json")
  Response repos_list_contributors(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("anon") String anon, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "For organization-owned repositories, the list of collaborators includes outside collaborators, organization members that are direct collaborators, organization members with access through team memberships, organization members with access through default organization permissions, and organization owners.\n\nTeam members will include the members of child teams.", summary = "List repository collaborators", operationId = "repos/list-collaborators")
  @Path("/{owner}/{repo}/collaborators")
  @GET
  @Produces("application/json")
  Response repos_list_collaborators(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("affiliation") @DefaultValue("all") String affiliation,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Merge a branch", operationId = "repos/merge")
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
  @Operation(description = "Checks the repository permission of a collaborator. The possible repository permissions are `admin`, `write`, `read`, and `none`.", summary = "Get repository permissions for a user", operationId = "repos/get-collaborator-permission-level")
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
  @Operation(description = "List files larger than 100MB found during the import", summary = "Get large files", operationId = "migrations/get-large-files")
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
  @Operation(description = "View the progress of an import.\n\n**Import status**\n\nThis section includes details about the possible values of the `status` field of the Import Progress response.\n\nAn import that does not have errors will progress through these steps:\n\n*   `detecting` - the \"detection\" step of the import is in progress because the request did not include a `vcs` parameter. The import is identifying the type of source control present at the URL.\n*   `importing` - the \"raw\" step of the import is in progress. This is where commit data is fetched from the original repository. The import progress response will include `commit_count` (the total number of raw commits that will be imported) and `percent` (0 - 100, the current progress through the import).\n*   `mapping` - the \"rewrite\" step of the import is in progress. This is where SVN branches are converted to Git branches, and where author updates are applied. The import progress response does not include progress information.\n*   `pushing` - the \"push\" step of the import is in progress. This is where the importer updates the repository on GitHub. The import progress response will include `push_percent`, which is the percent value reported by `git push` when it is \"Writing objects\".\n*   `complete` - the import is complete, and the repository is ready on GitHub.\n\nIf there are problems, you will see one of these in the `status` field:\n\n*   `auth_failed` - the import requires authentication in order to connect to the original repository. To update authentication for the import, please see the [Update an import](https://developer.github.com/v3/migrations/source_imports/#update-an-import) section.\n*   `error` - the import encountered an error. The import progress response will include the `failed_step` and an error message. Contact [GitHub Support](https://github.com/contact) or [GitHub Premium Support](https://premium.githubsupport.com) for more information.\n*   `detection_needs_auth` - the importer requires authentication for the originating repository to continue detection. To update authentication for the import, please see the [Update an import](https://developer.github.com/v3/migrations/source_imports/#update-an-import) section.\n*   `detection_found_nothing` - the importer didn't recognize any source control at the URL. To resolve, [Cancel the import](https://developer.github.com/v3/migrations/source_imports/#cancel-an-import) and [retry](https://developer.github.com/v3/migrations/source_imports/#start-an-import) with the correct URL.\n*   `detection_found_multiple` - the importer found several projects or repositories at the provided URL. When this is the case, the Import Progress response will also include a `project_choices` field with the possible project choices as values. To update project choice, please see the [Update an import](https://developer.github.com/v3/migrations/source_imports/#update-an-import) section.\n\n**The project_choices field**\n\nWhen multiple projects are found at the provided URL, the response hash will include a `project_choices` field, the value of which is an array of hashes each representing a project choice. The exact key/value pairs of the project hashes will differ depending on the version control type.\n\n**Git LFS related fields**\n\nThis section includes details about Git LFS related fields that may be present in the Import Progress response.\n\n*   `use_lfs` - describes whether the import has been opted in or out of using Git LFS. The value can be `opt_in`, `opt_out`, or `undecided` if no action has been taken.\n*   `has_large_files` - the boolean value describing whether files larger than 100MB were found during the `importing` step.\n*   `large_files_size` - the total size in gigabytes of files larger than 100MB found in the originating repository.\n*   `large_files_count` - the total number of files larger than 100MB found in the originating repository. To see a list of these files, make a \"Get Large Files\" request.", summary = "Get an import status", operationId = "migrations/get-import-status")
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
  @Operation(description = "Start a source import to a GitHub repository using GitHub Importer.", summary = "Start an import", operationId = "migrations/start-import")
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
  @Operation(description = "Stop an import for a repository.", summary = "Cancel an import", operationId = "migrations/cancel-import")
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
  @Operation(description = "An import can be updated with credentials or a project choice by passing in the appropriate parameters in this API\nrequest. If no parameters are provided, the import will be restarted.", summary = "Update an import", operationId = "migrations/update-import")
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
  @Operation(description = "Update an author's identity for the import. Your application can continue updating authors any time before you push new commits to the repository.", summary = "Map a commit author", operationId = "migrations/map-commit-author")
  @Path("/{owner}/{repo}/import/authors/{author_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response migrations_map_commit_author(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("author_id") BigInteger authorId, @NotNull InputStream data);

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
  @Operation(description = "Each type of source control system represents authors in a different way. For example, a Git commit author has a display name and an email address, but a Subversion commit author just has a username. The GitHub Importer will make the author information valid, but the author might not be correct. For example, it will change the bare Subversion username `hubot` into something like `hubot <hubot@12341234-abab-fefe-8787-fedcba987654>`.\n\nThis endpoint and the [Map a commit author](https://developer.github.com/v3/migrations/source_imports/#map-a-commit-author) endpoint allow you to provide correct Git author information.", summary = "Get commit authors", operationId = "migrations/get-commit-authors")
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
  @Operation(description = "You can import repositories from Subversion, Mercurial, and TFS that include files larger than 100MB. This ability is powered by [Git LFS](https://git-lfs.github.com). You can learn more about our LFS feature and working with large files [on our help site](https://help.github.com/articles/versioning-large-files/).", summary = "Update Git LFS preference", operationId = "migrations/set-lfs-preference")
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
  @Operation(description = "Shows which group of GitHub users can interact with this repository and when the restriction expires. If there are no restrictions, you will see an empty response.", summary = "Get interaction restrictions for a repository", operationId = "interactions/get-restrictions-for-repo")
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
  @Operation(description = "Temporarily restricts interactions to certain GitHub users within the given repository. You must have owner or admin access to set restrictions.", summary = "Set interaction restrictions for a repository", operationId = "interactions/set-restrictions-for-repo")
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
  @Operation(description = "Removes all interaction restrictions from the given repository. You must have owner or admin access to remove restrictions.", summary = "Remove interaction restrictions for a repository", operationId = "interactions/remove-restrictions-for-repo")
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
  @Operation(description = "This method returns the contents of the repository's license file, if one is detected.\n\nSimilar to [Get repository content](https://developer.github.com/v3/repos/contents/#get-repository-content), this method also supports [custom media types](https://developer.github.com/v3/repos/contents/#custom-media-types) for retrieving the raw license content or rendered license HTML.", summary = "Get the license for a repository", operationId = "licenses/get-for-repo")
  @Path("/{owner}/{repo}/license")
  @GET
  @Produces("application/json")
  Response licenses_get_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   *
   */
  @Operation(description = "", summary = "Get a repository subscription", operationId = "activity/get-repo-subscription")
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
  @Operation(description = "If you would like to watch a repository, set `subscribed` to `true`. If you would like to ignore notifications made within a repository, set `ignored` to `true`. If you would like to stop watching a repository, [delete the repository's subscription](https://developer.github.com/v3/activity/watching/#delete-a-repository-subscription) completely.", summary = "Set a repository subscription", operationId = "activity/set-repo-subscription")
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
  @Operation(description = "This endpoint should only be used to stop watching a repository. To control whether or not you wish to receive notifications from a repository, [set the repository's subscription manually](https://developer.github.com/v3/activity/watching/#set-a-repository-subscription).", summary = "Delete a repository subscription", operationId = "activity/delete-repo-subscription")
  @Path("/{owner}/{repo}/subscription")
  @DELETE
  void activity_delete_repo_subscription(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   *
   */
  @Operation(description = "", summary = "List repository events", operationId = "activity/list-repo-events")
  @Path("/{owner}/{repo}/events")
  @GET
  @Produces("application/json")
  Response activity_list_repo_events(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * List all notifications for the current user.
   * </p>
   *
   */
  @Operation(description = "List all notifications for the current user.", summary = "List repository notifications for the authenticated user", operationId = "activity/list-repo-notifications-for-authenticated-user")
  @Path("/{owner}/{repo}/notifications")
  @GET
  @Produces("application/json")
  Response activity_list_repo_notifications_for_authenticated_user(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @QueryParam("all") @DefaultValue("false") Boolean all,
      @QueryParam("participating") @DefaultValue("false") Boolean participating, @QueryParam("since") String since,
      @QueryParam("before") String before, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Marks all notifications in a repository as \"read\" removes them from the [default view on GitHub](https://github.com/notifications). If the number of notifications is too large to complete in one request, you will receive a `202 Accepted` status and GitHub will run an asynchronous process to mark notifications as \"read.\" To check whether any \"unread\" notifications remain, you can use the [List repository notifications for the authenticated user](https://developer.github.com/v3/activity/notifications/#list-repository-notifications-for-the-authenticated-user) endpoint and pass the query parameter `all=false`.", summary = "Mark repository notifications as read", operationId = "activity/mark-repo-notifications-as-read")
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
  @Operation(description = "Lists the people watching the specified repository.", summary = "List watchers", operationId = "activity/list-watchers-for-repo")
  @Path("/{owner}/{repo}/subscribers")
  @GET
  @Produces("application/json")
  Response activity_list_watchers_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Lists the people that have starred the repository.\n\nYou can also find out _when_ stars were created by passing the following custom [media type](https://developer.github.com/v3/media/) via the `Accept` header:", summary = "List stargazers", operationId = "activity/list-stargazers-for-repo")
  @Path("/{owner}/{repo}/stargazers")
  @GET
  @Produces({"application/json", "application/vnd.github.v3.star+json"})
  Response activity_list_stargazers_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Lists annotations for a check run using the annotation `id`. GitHub Apps must have the `checks:read` permission on a private repository or pull access to a public repository to get annotations for a check run. OAuth Apps and authenticated users must have the `repo` scope to get annotations for a check run in a private repository.", summary = "List check run annotations", operationId = "checks/list-annotations")
  @Path("/{owner}/{repo}/check-runs/{check_run_id}/annotations")
  @GET
  @Produces("application/json")
  Response checks_list_annotations(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_run_id") BigInteger checkRunId, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "**Note:** The Checks API only looks for pushes in the repository where the check suite or check run were created. Pushes to a branch in a forked repository are not detected and return an empty `pull_requests` array and a `null` value for `head_branch`.\n\nLists check suites for a commit `ref`. The `ref` can be a SHA, branch name, or a tag name. GitHub Apps must have the `checks:read` permission on a private repository or pull access to a public repository to list check suites. OAuth Apps and authenticated users must have the `repo` scope to get check suites in a private repository.", summary = "List check suites for a Git reference", operationId = "checks/list-suites-for-ref")
  @Path("/{owner}/{repo}/commits/{ref}/check-suites")
  @GET
  @Produces("application/json")
  Response checks_list_suites_for_ref(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref, @QueryParam("app_id") BigInteger appId, @QueryParam("check_name") String checkName,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "**Note:** The Checks API only looks for pushes in the repository where the check suite or check run were created. Pushes to a branch in a forked repository are not detected and return an empty `pull_requests` array.\n\nLists check runs for a commit ref. The `ref` can be a SHA, branch name, or a tag name. GitHub Apps must have the `checks:read` permission on a private repository or pull access to a public repository to get check runs. OAuth Apps and authenticated users must have the `repo` scope to get check runs in a private repository.", summary = "List check runs for a Git reference", operationId = "checks/list-for-ref")
  @Path("/{owner}/{repo}/commits/{ref}/check-runs")
  @GET
  @Produces("application/json")
  Response checks_list_for_ref(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref, @QueryParam("check_name") String checkName, @QueryParam("status") String status,
      @QueryParam("filter") @DefaultValue("latest") String filter,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "**Note:** The Checks API only looks for pushes in the repository where the check suite or check run were created. Pushes to a branch in a forked repository are not detected and return an empty `pull_requests` array.\n\nLists check runs for a check suite using its `id`. GitHub Apps must have the `checks:read` permission on a private repository or pull access to a public repository to get check runs. OAuth Apps and authenticated users must have the `repo` scope to get check runs in a private repository.", summary = "List check runs in a check suite", operationId = "checks/list-for-suite")
  @Path("/{owner}/{repo}/check-suites/{check_suite_id}/check-runs")
  @GET
  @Produces("application/json")
  Response checks_list_for_suite(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_suite_id") BigInteger checkSuiteId, @QueryParam("check_name") String checkName,
      @QueryParam("status") String status, @QueryParam("filter") @DefaultValue("latest") String filter,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "**Note:** The Checks API only looks for pushes in the repository where the check suite or check run were created. Pushes to a branch in a forked repository are not detected and return an empty `pull_requests` array.\n\nGets a single check run using its `id`. GitHub Apps must have the `checks:read` permission on a private repository or pull access to a public repository to get check runs. OAuth Apps and authenticated users must have the `repo` scope to get check runs in a private repository.", summary = "Get a check run", operationId = "checks/get")
  @Path("/{owner}/{repo}/check-runs/{check_run_id}")
  @GET
  @Produces("application/json")
  Response checks_get(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_run_id") BigInteger checkRunId);

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
  @Operation(description = "**Note:** The Checks API only looks for pushes in the repository where the check suite or check run were created. Pushes to a branch in a forked repository are not detected and return an empty `pull_requests` array.\n\nUpdates a check run for a specific commit in a repository. Your GitHub App must have the `checks:write` permission to edit check runs.", summary = "Update a check run", operationId = "checks/update")
  @Path("/{owner}/{repo}/check-runs/{check_run_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response checks_update(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_run_id") BigInteger checkRunId, @NotNull InputStream data);

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
  @Operation(description = "**Note:** The Checks API only looks for pushes in the repository where the check suite or check run were created. Pushes to a branch in a forked repository are not detected and return an empty `pull_requests` array and a `null` value for `head_branch`.\n\nBy default, check suites are automatically created when you create a [check run](https://developer.github.com/v3/checks/runs/). You only need to use this endpoint for manually creating check suites when you've disabled automatic creation using \"[Update repository preferences for check suites](https://developer.github.com/v3/checks/suites/#update-repository-preferences-for-check-suites)\". Your GitHub App must have the `checks:write` permission to create check suites.", summary = "Create a check suite", operationId = "checks/create-suite")
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
  @Operation(description = "Triggers GitHub to rerequest an existing check suite, without pushing new code to a repository. This endpoint will trigger the [`check_suite` webhook](https://developer.github.com/webhooks/event-payloads/#check_suite) event with the action `rerequested`. When a check suite is `rerequested`, its `status` is reset to `queued` and the `conclusion` is cleared.\n\nTo rerequest a check suite, your GitHub App must have the `checks:read` permission on a private repository or pull access to a public repository.", summary = "Rerequest a check suite", operationId = "checks/rerequest-suite")
  @Path("/{owner}/{repo}/check-suites/{check_suite_id}/rerequest")
  @POST
  void checks_rerequest_suite(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_suite_id") BigInteger checkSuiteId);

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
  @Operation(description = "Changes the default automatic flow when creating check suites. By default, a check suite is automatically created each time code is pushed to a repository. When you disable the automatic creation of check suites, you can manually [Create a check suite](https://developer.github.com/v3/checks/suites/#create-a-check-suite). You must have admin permissions in the repository to set preferences for check suites.", summary = "Update repository preferences for check suites", operationId = "checks/set-suites-preferences")
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
  @Operation(description = "**Note:** The Checks API only looks for pushes in the repository where the check suite or check run were created. Pushes to a branch in a forked repository are not detected and return an empty `pull_requests` array.\n\nCreates a new check run for a specific commit in a repository. Your GitHub App must have the `checks:write` permission to create check runs.", summary = "Create a check run", operationId = "checks/create")
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
  @Operation(description = "**Note:** The Checks API only looks for pushes in the repository where the check suite or check run were created. Pushes to a branch in a forked repository are not detected and return an empty `pull_requests` array and a `null` value for `head_branch`.\n\nGets a single check suite using its `id`. GitHub Apps must have the `checks:read` permission on a private repository or pull access to a public repository to get check suites. OAuth Apps and authenticated users must have the `repo` scope to get check suites in a private repository.", summary = "Get a check suite", operationId = "checks/get-suite")
  @Path("/{owner}/{repo}/check-suites/{check_suite_id}")
  @GET
  @Produces("application/json")
  Response checks_get_suite(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("check_suite_id") BigInteger checkSuiteId);

  /**
   * <p>
   * Lists the projects in a repository. Returns a <code>404 Not Found</code>
   * status if projects are disabled in the repository. If you do not have
   * sufficient privileges to perform this action, a <code>401 Unauthorized</code>
   * or <code>410 Gone</code> status is returned.
   * </p>
   *
   */
  @Operation(description = "Lists the projects in a repository. Returns a `404 Not Found` status if projects are disabled in the repository. If you do not have sufficient privileges to perform this action, a `401 Unauthorized` or `410 Gone` status is returned.", summary = "List repository projects", operationId = "projects/list-for-repo")
  @Path("/{owner}/{repo}/projects")
  @GET
  @Produces("application/json")
  Response projects_list_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("state") @DefaultValue("open") String state,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Creates a repository project board. Returns a <code>404 Not Found</code>
   * status if projects are disabled in the repository. If you do not have
   * sufficient privileges to perform this action, a <code>401 Unauthorized</code>
   * or <code>410 Gone</code> status is returned.
   * </p>
   *
   */
  @Operation(description = "Creates a repository project board. Returns a `404 Not Found` status if projects are disabled in the repository. If you do not have sufficient privileges to perform this action, a `401 Unauthorized` or `410 Gone` status is returned.", summary = "Create a repository project", operationId = "projects/create-for-repo")
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
  @Operation(description = "List the reactions to an [issue comment](https://developer.github.com/v3/issues/comments/).", summary = "List reactions for an issue comment", operationId = "reactions/list-for-issue-comment")
  @Path("/{owner}/{repo}/issues/comments/{comment_id}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_issue_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId, @QueryParam("content") String content,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Create a reaction to an
   * <a href="https://developer.github.com/v3/issues/comments/">issue comment</a>.
   * A response with a <code>Status: 200 OK</code> means that you already added
   * the reaction type to this issue comment.
   * </p>
   *
   */
  @Operation(description = "Create a reaction to an [issue comment](https://developer.github.com/v3/issues/comments/). A response with a `Status: 200 OK` means that you already added the reaction type to this issue comment.", summary = "Create reaction for an issue comment", operationId = "reactions/create-for-issue-comment")
  @Path("/{owner}/{repo}/issues/comments/{comment_id}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_issue_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId, @NotNull InputStream data);

  /**
   * <p>
   * List the reactions to an
   * <a href="https://developer.github.com/v3/issues/">issue</a>.
   * </p>
   *
   */
  @Operation(description = "List the reactions to an [issue](https://developer.github.com/v3/issues/).", summary = "List reactions for an issue", operationId = "reactions/list-for-issue")
  @Path("/{owner}/{repo}/issues/{issue_number}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_issue(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @QueryParam("content") String content,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Create a reaction to an
   * <a href="https://developer.github.com/v3/issues/">issue</a>. A response with
   * a <code>Status: 200 OK</code> means that you already added the reaction type
   * to this issue.
   * </p>
   *
   */
  @Operation(description = "Create a reaction to an [issue](https://developer.github.com/v3/issues/). A response with a `Status: 200 OK` means that you already added the reaction type to this issue.", summary = "Create reaction for an issue", operationId = "reactions/create-for-issue")
  @Path("/{owner}/{repo}/issues/{issue_number}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_issue(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @NotNull InputStream data);

  /**
   * <p>
   * List the reactions to a
   * <a href="https://developer.github.com/v3/pulls/comments/">pull request review
   * comment</a>.
   * </p>
   *
   */
  @Operation(description = "List the reactions to a [pull request review comment](https://developer.github.com/v3/pulls/comments/).", summary = "List reactions for a pull request review comment", operationId = "reactions/list-for-pull-request-review-comment")
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_pull_request_review_comment(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @PathParam("comment_id") BigInteger commentId,
      @QueryParam("content") String content, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Create a reaction to a
   * <a href="https://developer.github.com/v3/pulls/comments/">pull request review
   * comment</a>. A response with a <code>Status: 200 OK</code> means that you
   * already added the reaction type to this pull request review comment.
   * </p>
   *
   */
  @Operation(description = "Create a reaction to a [pull request review comment](https://developer.github.com/v3/pulls/comments/). A response with a `Status: 200 OK` means that you already added the reaction type to this pull request review comment.", summary = "Create reaction for a pull request review comment", operationId = "reactions/create-for-pull-request-review-comment")
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_pull_request_review_comment(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @PathParam("comment_id") BigInteger commentId, @NotNull InputStream data);

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
  @Operation(description = "**Note:** You can also specify a repository by `repository_id` using the route `DELETE /repositories/:repository_id/comments/:comment_id/reactions/:reaction_id`.\n\nDelete a reaction to a [commit comment](https://developer.github.com/v3/repos/comments/).", summary = "Delete a commit comment reaction", operationId = "reactions/delete-for-commit-comment")
  @Path("/{owner}/{repo}/comments/{comment_id}/reactions/{reaction_id}")
  @DELETE
  void reactions_delete_for_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId, @PathParam("reaction_id") BigInteger reactionId);

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
  @Operation(description = "**Note:** You can also specify a repository by `repository_id` using the route `DELETE delete /repositories/:repository_id/issues/comments/:comment_id/reactions/:reaction_id`.\n\nDelete a reaction to an [issue comment](https://developer.github.com/v3/issues/comments/).", summary = "Delete an issue comment reaction", operationId = "reactions/delete-for-issue-comment")
  @Path("/{owner}/{repo}/issues/comments/{comment_id}/reactions/{reaction_id}")
  @DELETE
  void reactions_delete_for_issue_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId, @PathParam("reaction_id") BigInteger reactionId);

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
  @Operation(description = "**Note:** You can also specify a repository by `repository_id` using the route `DELETE /repositories/:repository_id/issues/:issue_number/reactions/:reaction_id`.\n\nDelete a reaction to an [issue](https://developer.github.com/v3/issues/).", summary = "Delete an issue reaction", operationId = "reactions/delete-for-issue")
  @Path("/{owner}/{repo}/issues/{issue_number}/reactions/{reaction_id}")
  @DELETE
  void reactions_delete_for_issue(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @PathParam("reaction_id") BigInteger reactionId);

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
  @Operation(description = "**Note:** You can also specify a repository by `repository_id` using the route `DELETE /repositories/:repository_id/pulls/comments/:comment_id/reactions/:reaction_id.`\n\nDelete a reaction to a [pull request review comment](https://developer.github.com/v3/pulls/comments/).", summary = "Delete a pull request comment reaction", operationId = "reactions/delete-for-pull-request-comment")
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}/reactions/{reaction_id}")
  @DELETE
  void reactions_delete_for_pull_request_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId, @PathParam("reaction_id") BigInteger reactionId);

  /**
   * <p>
   * List the reactions to a
   * <a href="https://developer.github.com/v3/repos/comments/">commit comment</a>.
   * </p>
   *
   */
  @Operation(description = "List the reactions to a [commit comment](https://developer.github.com/v3/repos/comments/).", summary = "List reactions for a commit comment", operationId = "reactions/list-for-commit-comment")
  @Path("/{owner}/{repo}/comments/{comment_id}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId, @QueryParam("content") String content,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Create a reaction to a
   * <a href="https://developer.github.com/v3/repos/comments/">commit comment</a>.
   * A response with a <code>Status: 200 OK</code> means that you already added
   * the reaction type to this commit comment.
   * </p>
   *
   */
  @Operation(description = "Create a reaction to a [commit comment](https://developer.github.com/v3/repos/comments/). A response with a `Status: 200 OK` means that you already added the reaction type to this commit comment.", summary = "Create reaction for a commit comment", operationId = "reactions/create-for-commit-comment")
  @Path("/{owner}/{repo}/comments/{comment_id}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_commit_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId, @NotNull InputStream data);

  /**
   * <p>
   * This method returns the contents of the repository's code of conduct file, if
   * one is detected.
   * </p>
   *
   */
  @Operation(description = "This method returns the contents of the repository's code of conduct file, if one is detected.", summary = "Get the code of conduct for a repository", operationId = "codes-of-conduct/get-for-repo")
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
  @Operation(description = "Lists the workflows in a repository. Anyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "List repository workflows", operationId = "actions/list-repo-workflows")
  @Path("/{owner}/{repo}/actions/workflows")
  @GET
  @Produces("application/json")
  Response actions_list_repo_workflows(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "You can use this endpoint to manually trigger a GitHub Actions workflow run. You can also replace `{workflow_id}` with the workflow file name. For example, you could use `main.yml`.\n\nYou must configure your GitHub Actions workflow to run when the [`workflow_dispatch` webhook](/developers/webhooks-and-events/webhook-events-and-payloads#workflow_dispatch) event occurs. The `inputs` are configured in the workflow file. For more information about how to configure the `workflow_dispatch` event in the workflow file, see \"[Events that trigger workflows](/actions/reference/events-that-trigger-workflows#workflow_dispatch).\"\n\nYou must authenticate using an access token with the `repo` scope to use this endpoint. GitHub Apps must have the `actions:write` permission to use this endpoint. For more information, see \"[Creating a personal access token for the command line](https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line).\"", summary = "Create a workflow dispatch event", operationId = "actions/create-workflow-dispatch")
  @Path("/{owner}/{repo}/actions/workflows/{workflow_id}/dispatches")
  @POST
  @Consumes("application/json")
  void actions_create_workflow_dispatch(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("workflow_id") BigInteger workflowId, @NotNull InputStream data);

  /**
   * <p>
   * Lists binaries for the runner application that you can download and run. You
   * must authenticate using an access token with the <code>repo</code> scope to
   * use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Lists binaries for the runner application that you can download and run. You must authenticate using an access token with the `repo` scope to use this endpoint.", summary = "List runner applications for a repository", operationId = "actions/list-runner-applications-for-repo")
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
  @Operation(description = "Lists all artifacts for a repository. Anyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "List artifacts for a repository", operationId = "actions/list-artifacts-for-repo")
  @Path("/{owner}/{repo}/actions/artifacts")
  @GET
  @Produces("application/json")
  Response actions_list_artifacts_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists all secrets available in a repository without revealing their encrypted
   * values. You must authenticate using an access token with the
   * <code>repo</code> scope to use this endpoint. GitHub Apps must have the
   * <code>secrets</code> repository permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Lists all secrets available in a repository without revealing their encrypted values. You must authenticate using an access token with the `repo` scope to use this endpoint. GitHub Apps must have the `secrets` repository permission to use this endpoint.", summary = "List repository secrets", operationId = "actions/list-repo-secrets")
  @Path("/{owner}/{repo}/actions/secrets")
  @GET
  @Produces("application/json")
  Response actions_list_repo_secrets(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "**Warning:** This GitHub Actions usage endpoint is currently in public beta and subject to change. For more information, see \"[GitHub Actions API workflow usage](https://developer.github.com/changes/2020-05-15-actions-api-workflow-usage).\"\n\nGets the number of billable minutes used by a specific workflow during the current billing cycle. Billable minutes only apply to workflows in private repositories that use GitHub-hosted runners. Usage is listed for each GitHub-hosted runner operating system in milliseconds. Any job re-runs are also included in the usage. The usage does not include the multiplier for macOS and Windows runners and is not rounded up to the nearest whole minute. For more information, see \"[Managing billing for GitHub Actions](https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-actions)\".\n\nYou can also replace `:workflow_id` with `:workflow_file_name`. For example, you could use `main.yml`. Anyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "Get workflow usage", operationId = "actions/get-workflow-usage")
  @Path("/{owner}/{repo}/actions/workflows/{workflow_id}/timing")
  @GET
  @Produces("application/json")
  Response actions_get_workflow_usage(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("workflow_id") BigInteger workflowId);

  /**
   * <p>
   * Gets a specific artifact for a workflow run. Anyone with read access to the
   * repository can use this endpoint. If the repository is private you must use
   * an access token with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:read</code> permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Gets a specific artifact for a workflow run. Anyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "Get an artifact", operationId = "actions/get-artifact")
  @Path("/{owner}/{repo}/actions/artifacts/{artifact_id}")
  @GET
  @Produces("application/json")
  Response actions_get_artifact(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("artifact_id") BigInteger artifactId);

  /**
   * <p>
   * Deletes an artifact for a workflow run. You must authenticate using an access
   * token with the <code>repo</code> scope to use this endpoint. GitHub Apps must
   * have the <code>actions:write</code> permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Deletes an artifact for a workflow run. You must authenticate using an access token with the `repo` scope to use this endpoint. GitHub Apps must have the `actions:write` permission to use this endpoint.", summary = "Delete an artifact", operationId = "actions/delete-artifact")
  @Path("/{owner}/{repo}/actions/artifacts/{artifact_id}")
  @DELETE
  void actions_delete_artifact(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("artifact_id") BigInteger artifactId);

  /**
   * <p>
   * Gets a single repository secret without revealing its encrypted value. You
   * must authenticate using an access token with the <code>repo</code> scope to
   * use this endpoint. GitHub Apps must have the <code>secrets</code> repository
   * permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Gets a single repository secret without revealing its encrypted value. You must authenticate using an access token with the `repo` scope to use this endpoint. GitHub Apps must have the `secrets` repository permission to use this endpoint.", summary = "Get a repository secret", operationId = "actions/get-repo-secret")
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
  @Operation(description = "Creates or updates a repository secret with an encrypted value. Encrypt your secret using\n[LibSodium](https://libsodium.gitbook.io/doc/bindings_for_other_languages). You must authenticate using an access\ntoken with the `repo` scope to use this endpoint. GitHub Apps must have the `secrets` repository permission to use\nthis endpoint.\n\n#### Example encrypting a secret using Node.js\n\nEncrypt your secret using the [tweetsodium](https://github.com/github/tweetsodium) library.\n\n```\nconst sodium = require('tweetsodium');\n\nconst key = \"base64-encoded-public-key\";\nconst value = \"plain-text-secret\";\n\n// Convert the message and key to Uint8Array's (Buffer implements that interface)\nconst messageBytes = Buffer.from(value);\nconst keyBytes = Buffer.from(key, 'base64');\n\n// Encrypt using LibSodium.\nconst encryptedBytes = sodium.seal(messageBytes, keyBytes);\n\n// Base64 the encrypted secret\nconst encrypted = Buffer.from(encryptedBytes).toString('base64');\n\nconsole.log(encrypted);\n```\n\n\n#### Example encrypting a secret using Python\n\nEncrypt your secret using [pynacl](https://pynacl.readthedocs.io/en/stable/public/#nacl-public-sealedbox) with Python 3.\n\n```\nfrom base64 import b64encode\nfrom nacl import encoding, public\n\ndef encrypt(public_key: str, secret_value: str) -> str:\n  \"\"\"Encrypt a Unicode string using the public key.\"\"\"\n  public_key = public.PublicKey(public_key.encode(\"utf-8\"), encoding.Base64Encoder())\n  sealed_box = public.SealedBox(public_key)\n  encrypted = sealed_box.encrypt(secret_value.encode(\"utf-8\"))\n  return b64encode(encrypted).decode(\"utf-8\")\n```\n\n#### Example encrypting a secret using C#\n\nEncrypt your secret using the [Sodium.Core](https://www.nuget.org/packages/Sodium.Core/) package.\n\n```\nvar secretValue = System.Text.Encoding.UTF8.GetBytes(\"mySecret\");\nvar publicKey = Convert.FromBase64String(\"2Sg8iYjAxxmI2LvUXpJjkYrMxURPc8r+dB7TJyvvcCU=\");\n\nvar sealedPublicKeyBox = Sodium.SealedPublicKeyBox.Create(secretValue, publicKey);\n\nConsole.WriteLine(Convert.ToBase64String(sealedPublicKeyBox));\n```\n\n#### Example encrypting a secret using Ruby\n\nEncrypt your secret using the [rbnacl](https://github.com/RubyCrypto/rbnacl) gem.\n\n```ruby\nrequire \"rbnacl\"\nrequire \"base64\"\n\nkey = Base64.decode64(\"+ZYvJDZMHUfBkJdyq5Zm9SKqeuBQ4sj+6sfjlH4CgG0=\")\npublic_key = RbNaCl::PublicKey.new(key)\n\nbox = RbNaCl::Boxes::Sealed.from_public_key(public_key)\nencrypted_secret = box.encrypt(\"my_secret\")\n\n# Print the base64 encoded secret\nputs Base64.strict_encode64(encrypted_secret)\n```", summary = "Create or update a repository secret", operationId = "actions/create-or-update-repo-secret")
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
  @Operation(description = "Deletes a secret in a repository using the secret name. You must authenticate using an access token with the `repo` scope to use this endpoint. GitHub Apps must have the `secrets` repository permission to use this endpoint.", summary = "Delete a repository secret", operationId = "actions/delete-repo-secret")
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
  @Operation(description = "Gets a redirect URL to download an archive for a repository. This URL expires after 1 minute. Look for `Location:` in\nthe response header to find the URL for the download. The `:archive_format` must be `zip`. Anyone with read access to\nthe repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope.\nGitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "Download an artifact", operationId = "actions/download-artifact")
  @Path("/{owner}/{repo}/actions/artifacts/{artifact_id}/{archive_format}")
  @GET
  void actions_download_artifact(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("artifact_id") BigInteger artifactId, @PathParam("archive_format") String archiveFormat);

  /**
   * <p>
   * Gets a specific self-hosted runner. You must authenticate using an access
   * token with the <code>repo</code> scope to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Gets a specific self-hosted runner. You must authenticate using an access token with the `repo` scope to use this endpoint.", summary = "Get a self-hosted runner for a repository", operationId = "actions/get-self-hosted-runner-for-repo")
  @Path("/{owner}/{repo}/actions/runners/{runner_id}")
  @GET
  @Produces("application/json")
  Response actions_get_self_hosted_runner_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("runner_id") BigInteger runnerId);

  /**
   * <p>
   * Forces the removal of a self-hosted runner from a repository. You can use
   * this endpoint to completely remove the runner when the machine you were using
   * no longer exists. You must authenticate using an access token with the
   * <code>repo</code> scope to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Forces the removal of a self-hosted runner from a repository. You can use this endpoint to completely remove the runner when the machine you were using no longer exists. You must authenticate using an access token with the `repo` scope to use this endpoint.", summary = "Delete a self-hosted runner from a repository", operationId = "actions/delete-self-hosted-runner-from-repo")
  @Path("/{owner}/{repo}/actions/runners/{runner_id}")
  @DELETE
  void actions_delete_self_hosted_runner_from_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("runner_id") BigInteger runnerId);

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
  @Operation(description = "Gets a redirect URL to download a plain text file of logs for a workflow job. This link expires after 1 minute. Look\nfor `Location:` in the response header to find the URL for the download. Anyone with read access to the repository can\nuse this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must\nhave the `actions:read` permission to use this endpoint.", summary = "Download job logs for a workflow run", operationId = "actions/download-job-logs-for-workflow-run")
  @Path("/{owner}/{repo}/actions/jobs/{job_id}/logs")
  @GET
  void actions_download_job_logs_for_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("job_id") BigInteger jobId);

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
  @Operation(description = "Lists jobs for a workflow run. Anyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint. You can use parameters to narrow the list of results. For more information about using parameters, see [Parameters](https://developer.github.com/v3/#parameters).", summary = "List jobs for a workflow run", operationId = "actions/list-jobs-for-workflow-run")
  @Path("/{owner}/{repo}/actions/runs/{run_id}/jobs")
  @GET
  @Produces("application/json")
  Response actions_list_jobs_for_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") BigInteger runId, @QueryParam("filter") @DefaultValue("latest") String filter,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists all self-hosted runners for a repository. You must authenticate using
   * an access token with the <code>repo</code> scope to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Lists all self-hosted runners for a repository. You must authenticate using an access token with the `repo` scope to use this endpoint.", summary = "List self-hosted runners for a repository", operationId = "actions/list-self-hosted-runners-for-repo")
  @Path("/{owner}/{repo}/actions/runners")
  @GET
  @Produces("application/json")
  Response actions_list_self_hosted_runners_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Gets a specific workflow. You can also replace `:workflow_id` with `:workflow_file_name`. For example, you could use `main.yml`. Anyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "Get a workflow", operationId = "actions/get-workflow")
  @Path("/{owner}/{repo}/actions/workflows/{workflow_id}")
  @GET
  @Produces("application/json")
  Response actions_get_workflow(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("workflow_id") BigInteger workflowId);

  /**
   * <p>
   * Gets a specific job in a workflow run. Anyone with read access to the
   * repository can use this endpoint. If the repository is private you must use
   * an access token with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:read</code> permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Gets a specific job in a workflow run. Anyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "Get a job for a workflow run", operationId = "actions/get-job-for-workflow-run")
  @Path("/{owner}/{repo}/actions/jobs/{job_id}")
  @GET
  @Produces("application/json")
  Response actions_get_job_for_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("job_id") BigInteger jobId);

  /**
   * <p>
   * Cancels a workflow run using its <code>id</code>. You must authenticate using
   * an access token with the <code>repo</code> scope to use this endpoint. GitHub
   * Apps must have the <code>actions:write</code> permission to use this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Cancels a workflow run using its `id`. You must authenticate using an access token with the `repo` scope to use this endpoint. GitHub Apps must have the `actions:write` permission to use this endpoint.", summary = "Cancel a workflow run", operationId = "actions/cancel-workflow-run")
  @Path("/{owner}/{repo}/actions/runs/{run_id}/cancel")
  @POST
  void actions_cancel_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") BigInteger runId);

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
  @Operation(description = "Gets a redirect URL to download an archive of log files for a workflow run. This link expires after 1 minute. Look for\n`Location:` in the response header to find the URL for the download. Anyone with read access to the repository can use\nthis endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have\nthe `actions:read` permission to use this endpoint.", summary = "Download workflow run logs", operationId = "actions/download-workflow-run-logs")
  @Path("/{owner}/{repo}/actions/runs/{run_id}/logs")
  @GET
  void actions_download_workflow_run_logs(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") BigInteger runId);

  /**
   * <p>
   * Deletes all logs for a workflow run. You must authenticate using an access
   * token with the <code>repo</code> scope to use this endpoint. GitHub Apps must
   * have the <code>actions:write</code> permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Deletes all logs for a workflow run. You must authenticate using an access token with the `repo` scope to use this endpoint. GitHub Apps must have the `actions:write` permission to use this endpoint.", summary = "Delete workflow run logs", operationId = "actions/delete-workflow-run-logs")
  @Path("/{owner}/{repo}/actions/runs/{run_id}/logs")
  @DELETE
  void actions_delete_workflow_run_logs(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") BigInteger runId);

  /**
   * <p>
   * Re-runs your workflow run using its <code>id</code>. You must authenticate
   * using an access token with the <code>repo</code> scope to use this endpoint.
   * GitHub Apps must have the <code>actions:write</code> permission to use this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Re-runs your workflow run using its `id`. You must authenticate using an access token with the `repo` scope to use this endpoint. GitHub Apps must have the `actions:write` permission to use this endpoint.", summary = "Re-run a workflow", operationId = "actions/re-run-workflow")
  @Path("/{owner}/{repo}/actions/runs/{run_id}/rerun")
  @POST
  void actions_re_run_workflow(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") BigInteger runId);

  /**
   * <p>
   * Gets a specific workflow run. Anyone with read access to the repository can
   * use this endpoint. If the repository is private you must use an access token
   * with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:read</code> permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Gets a specific workflow run. Anyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "Get a workflow run", operationId = "actions/get-workflow-run")
  @Path("/{owner}/{repo}/actions/runs/{run_id}")
  @GET
  @Produces("application/json")
  Response actions_get_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") BigInteger runId);

  /**
   * <p>
   * Delete a specific workflow run. Anyone with write access to the repository
   * can use this endpoint. If the repository is private you must use an access
   * token with the <code>repo</code> scope. GitHub Apps must have the
   * <code>actions:write</code> permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Delete a specific workflow run. Anyone with write access to the repository can use this endpoint. If the repository is\nprivate you must use an access token with the `repo` scope. GitHub Apps must have the `actions:write` permission to use\nthis endpoint.", summary = "Delete a workflow run", operationId = "actions/delete-workflow-run")
  @Path("/{owner}/{repo}/actions/runs/{run_id}")
  @DELETE
  void actions_delete_workflow_run(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") BigInteger runId);

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
  @Operation(description = "**Warning:** This GitHub Actions usage endpoint is currently in public beta and subject to change. For more information, see \"[GitHub Actions API workflow usage](https://developer.github.com/changes/2020-05-15-actions-api-workflow-usage).\"\n\nGets the number of billable minutes and total run time for a specific workflow run. Billable minutes only apply to workflows in private repositories that use GitHub-hosted runners. Usage is listed for each GitHub-hosted runner operating system in milliseconds. Any job re-runs are also included in the usage. The usage does not include the multiplier for macOS and Windows runners and is not rounded up to the nearest whole minute. For more information, see \"[Managing billing for GitHub Actions](https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-actions)\".\n\nAnyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "Get workflow run usage", operationId = "actions/get-workflow-run-usage")
  @Path("/{owner}/{repo}/actions/runs/{run_id}/timing")
  @GET
  @Produces("application/json")
  Response actions_get_workflow_run_usage(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") BigInteger runId);

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
  @Operation(description = "Gets your public key, which you need to encrypt secrets. You need to encrypt a secret before you can create or update secrets. Anyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `secrets` repository permission to use this endpoint.", summary = "Get a repository public key", operationId = "actions/get-repo-public-key")
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
  @Operation(description = "Lists artifacts for a workflow run. Anyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "List workflow run artifacts", operationId = "actions/list-workflow-run-artifacts")
  @Path("/{owner}/{repo}/actions/runs/{run_id}/artifacts")
  @GET
  @Produces("application/json")
  Response actions_list_workflow_run_artifacts(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("run_id") BigInteger runId, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Returns a token that you can pass to the `config` script. The token expires after one hour. You must authenticate\nusing an access token with the `repo` scope to use this endpoint.\n\n#### Example using registration token\n \nConfigure your self-hosted runner, replacing `TOKEN` with the registration token provided by this endpoint.\n\n```\n./config.sh --url https://github.com/octo-org/octo-repo-artifacts --token TOKEN\n```", summary = "Create a registration token for a repository", operationId = "actions/create-registration-token-for-repo")
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
  @Operation(description = "Returns a token that you can pass to remove a self-hosted runner from a repository. The token expires after one hour.\nYou must authenticate using an access token with the `repo` scope to use this endpoint.\n\n#### Example using remove token\n \nTo remove your self-hosted runner from a repository, replace TOKEN with the remove token provided by this endpoint.\n\n```\n./config.sh remove --token TOKEN\n```", summary = "Create a remove token for a repository", operationId = "actions/create-remove-token-for-repo")
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
  @Operation(description = "List all workflow runs for a workflow. You can also replace `:workflow_id` with `:workflow_file_name`. For example, you could use `main.yml`. You can use parameters to narrow the list of results. For more information about using parameters, see [Parameters](https://developer.github.com/v3/#parameters).\n\nAnyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope.", summary = "List workflow runs", operationId = "actions/list-workflow-runs")
  @Path("/{owner}/{repo}/actions/workflows/{workflow_id}/runs")
  @GET
  @Produces("application/json")
  Response actions_list_workflow_runs(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("workflow_id") BigInteger workflowId, @QueryParam("actor") String actor,
      @QueryParam("branch") String branch, @QueryParam("event") String event, @QueryParam("status") String status,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Lists all workflow runs for a repository. You can use parameters to narrow the list of results. For more information about using parameters, see [Parameters](https://developer.github.com/v3/#parameters).\n\nAnyone with read access to the repository can use this endpoint. If the repository is private you must use an access token with the `repo` scope. GitHub Apps must have the `actions:read` permission to use this endpoint.", summary = "List workflow runs for a repository", operationId = "actions/list-workflow-runs-for-repo")
  @Path("/{owner}/{repo}/actions/runs")
  @GET
  @Produces("application/json")
  Response actions_list_workflow_runs_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("actor") String actor, @QueryParam("branch") String branch, @QueryParam("event") String event,
      @QueryParam("status") String status, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "**Note:** Multi-line comments on pull requests are currently in public beta and subject to change.\n\nProvides details for a review comment.\n\n**Multi-line comment summary**\n\n**Note:** New parameters and response fields are available for developers to preview. During the preview period, these response fields may change without advance notice. Please see the [blog post](https://developer.github.com/changes/2019-10-03-multi-line-comments) for full details.\n\nUse the `comfort-fade` preview header and the `line` parameter to show multi-line comment-supported fields in the response.\n\nIf you use the `comfort-fade` preview header, your response will show:\n\n*   For multi-line comments, values for `start_line`, `original_start_line`, `start_side`, `line`, `original_line`, and `side`.\n*   For single-line comments, values for `line`, `original_line`, and `side` and a `null` value for `start_line`, `original_start_line`, and `start_side`.\n\nIf you don't use the `comfort-fade` preview header, multi-line and single-line comments will appear the same way in the response with a single `position` attribute. Your response will show:\n\n*   For multi-line comments, the last line of the comment range for the `position` attribute.\n*   For single-line comments, the diff-positioned way of referencing comments for the `position` attribute. For more information, see `position` in the [input parameters](https://developer.github.com/v3/pulls/comments/#parameters-2) table.\n\nThe `reactions` key will have the following payload where `url` can be used to construct the API location for [listing and creating](https://developer.github.com/v3/reactions) reactions.", summary = "Get a review comment for a pull request", operationId = "pulls/get-review-comment")
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}")
  @GET
  @Produces("application/json")
  Response pulls_get_review_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId);

  /**
   * <p>
   * Deletes a review comment.
   * </p>
   *
   */
  @Operation(description = "Deletes a review comment.", summary = "Delete a review comment for a pull request", operationId = "pulls/delete-review-comment")
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}")
  @DELETE
  void pulls_delete_review_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId);

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
  @Operation(description = "**Note:** Multi-line comments on pull requests are currently in public beta and subject to change.\n\nEnables you to edit a review comment.\n\n**Multi-line comment summary**\n\n**Note:** New parameters and response fields are available for developers to preview. During the preview period, these response fields may change without advance notice. Please see the [blog post](https://developer.github.com/changes/2019-10-03-multi-line-comments) for full details.\n\nUse the `comfort-fade` preview header and the `line` parameter to show multi-line comment-supported fields in the response.\n\nIf you use the `comfort-fade` preview header, your response will show:\n\n*   For multi-line comments, values for `start_line`, `original_start_line`, `start_side`, `line`, `original_line`, and `side`.\n*   For single-line comments, values for `line`, `original_line`, and `side` and a `null` value for `start_line`, `original_start_line`, and `start_side`.\n\nIf you don't use the `comfort-fade` preview header, multi-line and single-line comments will appear the same way in the response with a single `position` attribute. Your response will show:\n\n*   For multi-line comments, the last line of the comment range for the `position` attribute.\n*   For single-line comments, the diff-positioned way of referencing comments for the `position` attribute. For more information, see `position` in the [input parameters](https://developer.github.com/v3/pulls/comments/#parameters-2) table.", summary = "Update a review comment for a pull request", operationId = "pulls/update-review-comment")
  @Path("/{owner}/{repo}/pulls/comments/{comment_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_update_review_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId, @NotNull InputStream data);

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
  @Operation(description = "**Note:** Multi-line comments on pull requests are currently in public beta and subject to change.\n\nLists all review comments for a pull request. By default, review comments are in ascending order by ID.\n\n**Multi-line comment summary**\n\n**Note:** New parameters and response fields are available for developers to preview. During the preview period, these response fields may change without advance notice. Please see the [blog post](https://developer.github.com/changes/2019-10-03-multi-line-comments) for full details.\n\nUse the `comfort-fade` preview header and the `line` parameter to show multi-line comment-supported fields in the response.\n\nIf you use the `comfort-fade` preview header, your response will show:\n\n*   For multi-line comments, values for `start_line`, `original_start_line`, `start_side`, `line`, `original_line`, and `side`.\n*   For single-line comments, values for `line`, `original_line`, and `side` and a `null` value for `start_line`, `original_start_line`, and `start_side`.\n\nIf you don't use the `comfort-fade` preview header, multi-line and single-line comments will appear the same way in the response with a single `position` attribute. Your response will show:\n\n*   For multi-line comments, the last line of the comment range for the `position` attribute.\n*   For single-line comments, the diff-positioned way of referencing comments for the `position` attribute. For more information, see `position` in the [input parameters](https://developer.github.com/v3/pulls/comments/#parameters-2) table.\n\nThe `reactions` key will have the following payload where `url` can be used to construct the API location for [listing and creating](https://developer.github.com/v3/reactions) reactions.", summary = "List review comments on a pull request", operationId = "pulls/list-review-comments")
  @Path("/{owner}/{repo}/pulls/{pull_number}/comments")
  @GET
  @Produces("application/json")
  Response pulls_list_review_comments(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @QueryParam("sort") @DefaultValue("created") String sort,
      @QueryParam("direction") String direction, @QueryParam("since") String since,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "**Note:** Multi-line comments on pull requests are currently in public beta and subject to change.\n\nCreates a review comment in the pull request diff. To add a regular comment to a pull request timeline, see \"[Create an issue comment](https://developer.github.com/v3/issues/comments/#create-an-issue-comment).\" We recommend creating a review comment using `line`, `side`, and optionally `start_line` and `start_side` if your comment applies to more than one line in the pull request diff.\n\nYou can still create a review comment using the `position` parameter. When you use `position`, the `line`, `side`, `start_line`, and `start_side` parameters are not required. For more information, see [Multi-line comment summary](https://developer.github.com/v3/pulls/comments/#multi-line-comment-summary-3).\n\n**Note:** The position value equals the number of lines down from the first \"@@\" hunk header in the file you want to add a comment. The line just below the \"@@\" line is position 1, the next line is position 2, and so on. The position in the diff continues to increase through lines of whitespace and additional hunks until the beginning of a new file.\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.\n\n**Multi-line comment summary**\n\n**Note:** New parameters and response fields are available for developers to preview. During the preview period, these response fields may change without advance notice. Please see the [blog post](https://developer.github.com/changes/2019-10-03-multi-line-comments) for full details.\n\nUse the `comfort-fade` preview header and the `line` parameter to show multi-line comment-supported fields in the response.\n\nIf you use the `comfort-fade` preview header, your response will show:\n\n*   For multi-line comments, values for `start_line`, `original_start_line`, `start_side`, `line`, `original_line`, and `side`.\n*   For single-line comments, values for `line`, `original_line`, and `side` and a `null` value for `start_line`, `original_start_line`, and `start_side`.\n\nIf you don't use the `comfort-fade` preview header, multi-line and single-line comments will appear the same way in the response with a single `position` attribute. Your response will show:\n\n*   For multi-line comments, the last line of the comment range for the `position` attribute.\n*   For single-line comments, the diff-positioned way of referencing comments for the `position` attribute. For more information, see `position` in the [input parameters](https://developer.github.com/v3/pulls/comments/#parameters-2) table.", summary = "Create a review comment for a pull request", operationId = "pulls/create-review-comment")
  @Path("/{owner}/{repo}/pulls/{pull_number}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_create_review_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @NotNull InputStream data);

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
  @Operation(description = "**Note:** Multi-line comments on pull requests are currently in public beta and subject to change.\n\nLists review comments for all pull requests in a repository. By default, review comments are in ascending order by ID.\n\n**Multi-line comment summary**\n\n**Note:** New parameters and response fields are available for developers to preview. During the preview period, these response fields may change without advance notice. Please see the [blog post](https://developer.github.com/changes/2019-10-03-multi-line-comments) for full details.\n\nUse the `comfort-fade` preview header and the `line` parameter to show multi-line comment-supported fields in the response.\n\nIf you use the `comfort-fade` preview header, your response will show:\n\n*   For multi-line comments, values for `start_line`, `original_start_line`, `start_side`, `line`, `original_line`, and `side`.\n*   For single-line comments, values for `line`, `original_line`, and `side` and a `null` value for `start_line`, `original_start_line`, and `start_side`.\n\nIf you don't use the `comfort-fade` preview header, multi-line and single-line comments will appear the same way in the response with a single `position` attribute. Your response will show:\n\n*   For multi-line comments, the last line of the comment range for the `position` attribute.\n*   For single-line comments, the diff-positioned way of referencing comments for the `position` attribute. For more information, see `position` in the [input parameters](https://developer.github.com/v3/pulls/comments/#parameters-2) table.\n\nThe `reactions` key will have the following payload where `url` can be used to construct the API location for [listing and creating](https://developer.github.com/v3/reactions) reactions.", summary = "List review comments in a repository", operationId = "pulls/list-review-comments-for-repo")
  @Path("/{owner}/{repo}/pulls/comments")
  @GET
  @Produces("application/json")
  Response pulls_list_review_comments_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("sort") @DefaultValue("created") String sort, @QueryParam("direction") String direction,
      @QueryParam("since") String since, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Get a review for a pull request", operationId = "pulls/get-review")
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}")
  @GET
  @Produces("application/json")
  Response pulls_get_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @PathParam("review_id") BigInteger reviewId);

  /**
   * <p>
   * Update the review summary comment with new text.
   * </p>
   *
   */
  @Operation(description = "Update the review summary comment with new text.", summary = "Update a review for a pull request", operationId = "pulls/update-review")
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_update_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @PathParam("review_id") BigInteger reviewId,
      @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a pending review for a pull request", operationId = "pulls/delete-pending-review")
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}")
  @DELETE
  @Produces("application/json")
  Response pulls_delete_pending_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @PathParam("review_id") BigInteger reviewId);

  /**
   * <p>
   * <strong>Note:</strong> To dismiss a pull request review on a
   * <a href="https://developer.github.com/v3/repos/branches/">protected
   * branch</a>, you must be a repository administrator or be included in the list
   * of people or teams who can dismiss pull request reviews.
   * </p>
   *
   */
  @Operation(description = "**Note:** To dismiss a pull request review on a [protected branch](https://developer.github.com/v3/repos/branches/), you must be a repository administrator or be included in the list of people or teams who can dismiss pull request reviews.", summary = "Dismiss a review for a pull request", operationId = "pulls/dismiss-review")
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}/dismissals")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_dismiss_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @PathParam("review_id") BigInteger reviewId,
      @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List requested reviewers for a pull request", operationId = "pulls/list-requested-reviewers")
  @Path("/{owner}/{repo}/pulls/{pull_number}/requested_reviewers")
  @GET
  @Produces("application/json")
  Response pulls_list_requested_reviewers(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "This endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Request reviewers for a pull request", operationId = "pulls/request-reviewers")
  @Path("/{owner}/{repo}/pulls/{pull_number}/requested_reviewers")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_request_reviewers(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Remove requested reviewers from a pull request", operationId = "pulls/remove-requested-reviewers")
  @Path("/{owner}/{repo}/pulls/{pull_number}/requested_reviewers")
  @DELETE
  @Consumes("application/json")
  void pulls_remove_requested_reviewers(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @NotNull InputStream data);

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
  @Operation(description = "Draft pull requests are available in public repositories with GitHub Free and GitHub Free for organizations, GitHub Pro, and legacy per-repository billing plans, and in public and private repositories with GitHub Team and GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nLists details of a pull request by providing its number.\n\nWhen you get, [create](https://developer.github.com/v3/pulls/#create-a-pull-request), or [edit](https://developer.github.com/v3/pulls/#update-a-pull-request) a pull request, GitHub creates a merge commit to test whether the pull request can be automatically merged into the base branch. This test commit is not added to the base branch or the head branch. You can review the status of the test commit using the `mergeable` key. For more information, see \"[Checking mergeability of pull requests](https://developer.github.com/v3/git/#checking-mergeability-of-pull-requests)\".\n\nThe value of the `mergeable` attribute can be `true`, `false`, or `null`. If the value is `null`, then GitHub has started a background job to compute the mergeability. After giving the job time to complete, resubmit the request. When the job finishes, you will see a non-`null` value for the `mergeable` attribute in the response. If `mergeable` is `true`, then `merge_commit_sha` will be the SHA of the _test_ merge commit.\n\nThe value of the `merge_commit_sha` attribute changes depending on the state of the pull request. Before merging a pull request, the `merge_commit_sha` attribute holds the SHA of the _test_ merge commit. After merging a pull request, the `merge_commit_sha` attribute changes depending on how you merged the pull request:\n\n*   If merged as a [merge commit](https://help.github.com/articles/about-merge-methods-on-github/), `merge_commit_sha` represents the SHA of the merge commit.\n*   If merged via a [squash](https://help.github.com/articles/about-merge-methods-on-github/#squashing-your-merge-commits), `merge_commit_sha` represents the SHA of the squashed commit on the base branch.\n*   If [rebased](https://help.github.com/articles/about-merge-methods-on-github/#rebasing-and-merging-your-commits), `merge_commit_sha` represents the commit that the base branch was updated to.\n\nPass the appropriate [media type](https://developer.github.com/v3/media/#commits-commit-comparison-and-pull-requests) to fetch diff and patch formats.", summary = "Get a pull request", operationId = "pulls/get")
  @Path("/{owner}/{repo}/pulls/{pull_number}")
  @GET
  @Produces("application/json")
  Response pulls_get(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber);

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
  @Operation(description = "Draft pull requests are available in public repositories with GitHub Free and GitHub Free for organizations, GitHub Pro, and legacy per-repository billing plans, and in public and private repositories with GitHub Team and GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nTo open or update a pull request in a public repository, you must have write access to the head or the source branch. For organization-owned repositories, you must be a member of the organization that owns the repository to open or update a pull request.", summary = "Update a pull request", operationId = "pulls/update")
  @Path("/{owner}/{repo}/pulls/{pull_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_update(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @NotNull InputStream data);

  /**
   * <p>
   * The list of reviews returns in chronological order.
   * </p>
   *
   */
  @Operation(description = "The list of reviews returns in chronological order.", summary = "List reviews for a pull request", operationId = "pulls/list-reviews")
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews")
  @GET
  @Produces("application/json")
  Response pulls_list_reviews(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "This endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.\n\nPull request reviews created in the `PENDING` state do not include the `submitted_at` property in the response.\n\n**Note:** To comment on a specific line in a file, you need to first determine the _position_ of that line in the diff. The GitHub REST API v3 offers the `application/vnd.github.v3.diff` [media type](https://developer.github.com/v3/media/#commits-commit-comparison-and-pull-requests). To see a pull request diff, add this media type to the `Accept` header of a call to the [single pull request](https://developer.github.com/v3/pulls/#get-a-pull-request) endpoint.\n\nThe `position` value equals the number of lines down from the first \"@@\" hunk header in the file you want to add a comment. The line just below the \"@@\" line is position 1, the next line is position 2, and so on. The position in the diff continues to increase through lines of whitespace and additional hunks until the beginning of a new file.", summary = "Create a review for a pull request", operationId = "pulls/create-review")
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_create_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Check if a pull request has been merged", operationId = "pulls/check-if-merged")
  @Path("/{owner}/{repo}/pulls/{pull_number}/merge")
  @GET
  void pulls_check_if_merged(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber);

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
  @Operation(description = "This endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Merge a pull request", operationId = "pulls/merge")
  @Path("/{owner}/{repo}/pulls/{pull_number}/merge")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_merge(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @NotNull InputStream data);

  /**
   * <p>
   * Updates the pull request branch with the latest upstream changes by merging
   * HEAD from the base branch into the pull request branch.
   * </p>
   *
   */
  @Operation(description = "Updates the pull request branch with the latest upstream changes by merging HEAD from the base branch into the pull request branch.", summary = "Update a pull request branch", operationId = "pulls/update-branch")
  @Path("/{owner}/{repo}/pulls/{pull_number}/update-branch")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_update_branch(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Note:</strong> Responses include a maximum of 3000 files. The
   * paginated response returns 30 files per page by default.
   * </p>
   *
   */
  @Operation(description = "**Note:** Responses include a maximum of 3000 files. The paginated response returns 30 files per page by default.", summary = "List pull requests files", operationId = "pulls/list-files")
  @Path("/{owner}/{repo}/pulls/{pull_number}/files")
  @GET
  @Produces("application/json")
  Response pulls_list_files(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Draft pull requests are available in public repositories with GitHub Free and GitHub Free for organizations, GitHub Pro, and legacy per-repository billing plans, and in public and private repositories with GitHub Team and GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.", summary = "List pull requests", operationId = "pulls/list")
  @Path("/{owner}/{repo}/pulls")
  @GET
  @Produces("application/json")
  Response pulls_list(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("state") @DefaultValue("open") String state, @QueryParam("head") String head,
      @QueryParam("base") String base, @QueryParam("sort") @DefaultValue("created") String sort,
      @QueryParam("direction") String direction, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Draft pull requests are available in public repositories with GitHub Free and GitHub Free for organizations, GitHub Pro, and legacy per-repository billing plans, and in public and private repositories with GitHub Team and GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nTo open or update a pull request in a public repository, you must have write access to the head or the source branch. For organization-owned repositories, you must be a member of the organization that owns the repository to open or update a pull request.\n\nYou can create a new pull request.\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Create a pull request", operationId = "pulls/create")
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
  @Operation(description = "Creates a reply to a review comment for a pull request. For the `comment_id`, provide the ID of the review comment you are replying to. This must be the ID of a _top-level review comment_, not a reply to that comment. Replies to replies are not supported.\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Create a reply for a review comment", operationId = "pulls/create-reply-for-review-comment")
  @Path("/{owner}/{repo}/pulls/{pull_number}/comments/{comment_id}/replies")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_create_reply_for_review_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @PathParam("comment_id") BigInteger commentId,
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
  @Operation(description = "Lists a maximum of 250 commits for a pull request. To receive a complete commit list for pull requests with more than 250 commits, use the [List commits](https://developer.github.com/v3/repos/commits/#list-commits) endpoint.", summary = "List commits on a pull request", operationId = "pulls/list-commits")
  @Path("/{owner}/{repo}/pulls/{pull_number}/commits")
  @GET
  @Produces("application/json")
  Response pulls_list_commits(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Submit a review for a pull request", operationId = "pulls/submit-review")
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}/events")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response pulls_submit_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @PathParam("review_id") BigInteger reviewId,
      @NotNull InputStream data);

  /**
   * <p>
   * List comments for a specific pull request review.
   * </p>
   *
   */
  @Operation(description = "List comments for a specific pull request review.", summary = "List comments for a pull request review", operationId = "pulls/list-comments-for-review")
  @Path("/{owner}/{repo}/pulls/{pull_number}/reviews/{review_id}/comments")
  @GET
  @Produces("application/json")
  Response pulls_list_comments_for_review(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("pull_number") BigInteger pullNumber, @PathParam("review_id") BigInteger reviewId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Lists all open code scanning alerts for the default branch (usually `master`) and protected branches in a repository. You must use an access token with the `security_events` scope to use this endpoint. GitHub Apps must have the `security_events` read permission to use this endpoint.", summary = "List code scanning alerts for a repository", operationId = "code-scanning/list-alerts-for-repo")
  @Path("/{owner}/{repo}/code-scanning/alerts")
  @GET
  @Produces("application/json")
  Response code_scanning_list_alerts_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("state") @DefaultValue("open") String state, @QueryParam("ref") String ref);

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
  @Operation(description = "Gets a single code scanning alert. You must use an access token with the `security_events` scope to use this endpoint. GitHub Apps must have the `security_events` read permission to use this endpoint.\n\nThe security `alert_id` is found at the end of the security alert's URL. For example, the security alert ID for `https://github.com/Octo-org/octo-repo/security/code-scanning/88` is `88`.", summary = "Get a code scanning alert", operationId = "code-scanning/get-alert")
  @Path("/{owner}/{repo}/code-scanning/alerts/{alert_id}")
  @GET
  @Produces("application/json")
  Response code_scanning_get_alert(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("alert_id") BigInteger alertId);

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
  @Operation(description = "Users with push access can lock an issue or pull request's conversation.\n\nNote that, if you choose not to pass any parameters, you'll need to set `Content-Length` to zero when calling out to this endpoint. For more information, see \"[HTTP verbs](https://developer.github.com/v3/#http-verbs).\"", summary = "Lock an issue", operationId = "issues/lock")
  @Path("/{owner}/{repo}/issues/{issue_number}/lock")
  @PUT
  @Consumes("application/json")
  void issues_lock(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @NotNull InputStream data);

  /**
   * <p>
   * Users with push access can unlock an issue's conversation.
   * </p>
   *
   */
  @Operation(description = "Users with push access can unlock an issue's conversation.", summary = "Unlock an issue", operationId = "issues/unlock")
  @Path("/{owner}/{repo}/issues/{issue_number}/lock")
  @DELETE
  void issues_unlock(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber);

  /**
   *
   */
  @Operation(description = "", summary = "Get a milestone", operationId = "issues/get-milestone")
  @Path("/{owner}/{repo}/milestones/{milestone_number}")
  @GET
  @Produces("application/json")
  Response issues_get_milestone(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("milestone_number") BigInteger milestoneNumber);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a milestone", operationId = "issues/delete-milestone")
  @Path("/{owner}/{repo}/milestones/{milestone_number}")
  @DELETE
  void issues_delete_milestone(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("milestone_number") BigInteger milestoneNumber);

  /**
   *
   */
  @Operation(description = "", summary = "Update a milestone", operationId = "issues/update-milestone")
  @Path("/{owner}/{repo}/milestones/{milestone_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_update_milestone(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("milestone_number") BigInteger milestoneNumber, @NotNull InputStream data);

  /**
   * <p>
   * Removes the specified label from the issue, and returns the remaining labels
   * on the issue. This endpoint returns a <code>404 Not Found</code> status if
   * the label does not exist.
   * </p>
   *
   */
  @Operation(description = "Removes the specified label from the issue, and returns the remaining labels on the issue. This endpoint returns a `404 Not Found` status if the label does not exist.", summary = "Remove a label from an issue", operationId = "issues/remove-label")
  @Path("/{owner}/{repo}/issues/{issue_number}/labels/{name}")
  @DELETE
  @Produces("application/json")
  Response issues_remove_label(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @PathParam("name") String name);

  /**
   *
   */
  @Operation(description = "", summary = "List milestones", operationId = "issues/list-milestones")
  @Path("/{owner}/{repo}/milestones")
  @GET
  @Produces("application/json")
  Response issues_list_milestones(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("state") @DefaultValue("open") String state, @QueryParam("sort") @DefaultValue("due_on") String sort,
      @QueryParam("direction") @DefaultValue("asc") String direction,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Create a milestone", operationId = "issues/create-milestone")
  @Path("/{owner}/{repo}/milestones")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_create_milestone(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Get an issue comment", operationId = "issues/get-comment")
  @Path("/{owner}/{repo}/issues/comments/{comment_id}")
  @GET
  @Produces("application/json")
  Response issues_get_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId);

  /**
   *
   */
  @Operation(description = "", summary = "Delete an issue comment", operationId = "issues/delete-comment")
  @Path("/{owner}/{repo}/issues/comments/{comment_id}")
  @DELETE
  void issues_delete_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId);

  /**
   *
   */
  @Operation(description = "", summary = "Update an issue comment", operationId = "issues/update-comment")
  @Path("/{owner}/{repo}/issues/comments/{comment_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_update_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("comment_id") BigInteger commentId, @NotNull InputStream data);

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
  @Operation(description = "The API returns a [`301 Moved Permanently` status](https://developer.github.com/v3/#http-redirects) if the issue was\n[transferred](https://help.github.com/articles/transferring-an-issue-to-another-repository/) to another repository. If\nthe issue was transferred to or deleted from a repository where the authenticated user lacks read access, the API\nreturns a `404 Not Found` status. If the issue was deleted from a repository where the authenticated user has read\naccess, the API returns a `410 Gone` status. To receive webhook events for transferred and deleted issues, subscribe\nto the [`issues`](https://developer.github.com/webhooks/event-payloads/#issues) webhook.\n\n**Note**: GitHub's REST API v3 considers every pull request an issue, but not every issue is a pull request. For this\nreason, \"Issues\" endpoints may return both issues and pull requests in the response. You can identify pull requests by\nthe `pull_request` key. Be aware that the `id` of a pull request returned from \"Issues\" endpoints will be an _issue id_. To find out the pull\nrequest id, use the \"[List pull requests](https://developer.github.com/v3/pulls/#list-pull-requests)\" endpoint.", summary = "Get an issue", operationId = "issues/get")
  @Path("/{owner}/{repo}/issues/{issue_number}")
  @GET
  @Produces("application/json")
  Response issues_get(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber);

  /**
   * <p>
   * Issue owners and users with push access can edit an issue.
   * </p>
   *
   */
  @Operation(description = "Issue owners and users with push access can edit an issue.", summary = "Update an issue", operationId = "issues/update")
  @Path("/{owner}/{repo}/issues/{issue_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_update(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Get a label", operationId = "issues/get-label")
  @Path("/{owner}/{repo}/labels/{name}")
  @GET
  @Produces("application/json")
  Response issues_get_label(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("name") String name);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a label", operationId = "issues/delete-label")
  @Path("/{owner}/{repo}/labels/{name}")
  @DELETE
  void issues_delete_label(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("name") String name);

  /**
   *
   */
  @Operation(description = "", summary = "Update a label", operationId = "issues/update-label")
  @Path("/{owner}/{repo}/labels/{name}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_update_label(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("name") String name, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List labels for a repository", operationId = "issues/list-labels-for-repo")
  @Path("/{owner}/{repo}/labels")
  @GET
  @Produces("application/json")
  Response issues_list_labels_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Create a label", operationId = "issues/create-label")
  @Path("/{owner}/{repo}/labels")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_create_label(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List timeline events for an issue", operationId = "issues/list-events-for-timeline")
  @Path("/{owner}/{repo}/issues/{issue_number}/timeline")
  @GET
  @Produces("application/json")
  Response issues_list_events_for_timeline(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists the <a href=
   * "https://help.github.com/articles/assigning-issues-and-pull-requests-to-other-github-users/">available
   * assignees</a> for issues in a repository.
   * </p>
   *
   */
  @Operation(description = "Lists the [available assignees](https://help.github.com/articles/assigning-issues-and-pull-requests-to-other-github-users/) for issues in a repository.", summary = "List assignees", operationId = "issues/list-assignees")
  @Path("/{owner}/{repo}/assignees")
  @GET
  @Produces("application/json")
  Response issues_list_assignees(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "List labels for an issue", operationId = "issues/list-labels-on-issue")
  @Path("/{owner}/{repo}/issues/{issue_number}/labels")
  @GET
  @Produces("application/json")
  Response issues_list_labels_on_issue(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Removes any previous labels and sets the new labels for an issue.
   * </p>
   *
   */
  @Operation(description = "Removes any previous labels and sets the new labels for an issue.", summary = "Set labels for an issue", operationId = "issues/set-labels")
  @Path("/{owner}/{repo}/issues/{issue_number}/labels")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_set_labels(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Add labels to an issue", operationId = "issues/add-labels")
  @Path("/{owner}/{repo}/issues/{issue_number}/labels")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_add_labels(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Remove all labels from an issue", operationId = "issues/remove-all-labels")
  @Path("/{owner}/{repo}/issues/{issue_number}/labels")
  @DELETE
  void issues_remove_all_labels(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber);

  /**
   *
   */
  @Operation(description = "", summary = "List issue events", operationId = "issues/list-events")
  @Path("/{owner}/{repo}/issues/{issue_number}/events")
  @GET
  @Produces("application/json")
  Response issues_list_events(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "List issues in a repository.\n\n**Note**: GitHub's REST API v3 considers every pull request an issue, but not every issue is a pull request. For this\nreason, \"Issues\" endpoints may return both issues and pull requests in the response. You can identify pull requests by\nthe `pull_request` key. Be aware that the `id` of a pull request returned from \"Issues\" endpoints will be an _issue id_. To find out the pull\nrequest id, use the \"[List pull requests](https://developer.github.com/v3/pulls/#list-pull-requests)\" endpoint.", summary = "List repository issues", operationId = "issues/list-for-repo")
  @Path("/{owner}/{repo}/issues")
  @GET
  @Produces("application/json")
  Response issues_list_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("milestone") String milestone, @QueryParam("state") @DefaultValue("open") String state,
      @QueryParam("assignee") String assignee, @QueryParam("creator") String creator,
      @QueryParam("mentioned") String mentioned, @QueryParam("labels") String labels,
      @QueryParam("sort") @DefaultValue("created") String sort,
      @QueryParam("direction") @DefaultValue("desc") String direction, @QueryParam("since") String since,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Any user with pull access to a repository can create an issue. If [issues are disabled in the repository](https://help.github.com/articles/disabling-issues/), the API returns a `410 Gone` status.\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Create an issue", operationId = "issues/create")
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
  @Operation(description = "Issue Comments are ordered by ascending ID.", summary = "List issue comments", operationId = "issues/list-comments")
  @Path("/{owner}/{repo}/issues/{issue_number}/comments")
  @GET
  @Produces("application/json")
  Response issues_list_comments(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @QueryParam("since") String since,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "This endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Create an issue comment", operationId = "issues/create-comment")
  @Path("/{owner}/{repo}/issues/{issue_number}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_create_comment(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @NotNull InputStream data);

  /**
   * <p>
   * Adds up to 10 assignees to an issue. Users already assigned to an issue are
   * not replaced.
   * </p>
   *
   */
  @Operation(description = "Adds up to 10 assignees to an issue. Users already assigned to an issue are not replaced.", summary = "Add assignees to an issue", operationId = "issues/add-assignees")
  @Path("/{owner}/{repo}/issues/{issue_number}/assignees")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_add_assignees(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @NotNull InputStream data);

  /**
   * <p>
   * Removes one or more assignees from an issue.
   * </p>
   *
   */
  @Operation(description = "Removes one or more assignees from an issue.", summary = "Remove assignees from an issue", operationId = "issues/remove-assignees")
  @Path("/{owner}/{repo}/issues/{issue_number}/assignees")
  @DELETE
  @Produces("application/json")
  @Consumes("application/json")
  Response issues_remove_assignees(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("issue_number") BigInteger issueNumber, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List issue events for a repository", operationId = "issues/list-events-for-repo")
  @Path("/{owner}/{repo}/issues/events")
  @GET
  @Produces("application/json")
  Response issues_list_events_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Checks if a user has permission to be assigned to an issue in this repository.\n\nIf the `assignee` can be assigned to issues in the repository, a `204` header with no content is returned.\n\nOtherwise a `404` status code is returned.", summary = "Check if a user can be assigned", operationId = "issues/check-user-can-be-assigned")
  @Path("/{owner}/{repo}/assignees/{assignee}")
  @GET
  void issues_check_user_can_be_assigned(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("assignee") String assignee);

  /**
   *
   */
  @Operation(description = "", summary = "List labels for issues in a milestone", operationId = "issues/list-labels-for-milestone")
  @Path("/{owner}/{repo}/milestones/{milestone_number}/labels")
  @GET
  @Produces("application/json")
  Response issues_list_labels_for_milestone(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("milestone_number") BigInteger milestoneNumber,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Get an issue event", operationId = "issues/get-event")
  @Path("/{owner}/{repo}/issues/events/{event_id}")
  @GET
  @Produces("application/json")
  Response issues_get_event(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("event_id") BigInteger eventId);

  /**
   * <p>
   * By default, Issue Comments are ordered by ascending ID.
   * </p>
   *
   */
  @Operation(description = "By default, Issue Comments are ordered by ascending ID.", summary = "List issue comments for a repository", operationId = "issues/list-comments-for-repo")
  @Path("/{owner}/{repo}/issues/comments")
  @GET
  @Produces("application/json")
  Response issues_list_comments_for_repo(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @QueryParam("sort") @DefaultValue("created") String sort, @QueryParam("direction") String direction,
      @QueryParam("since") String since, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Enables an authenticated GitHub App to find the repository's installation information. The installation's account type will be either an organization or a user account, depending which account the repository belongs to.\n\nYou must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint.", summary = "Get a repository installation for the authenticated app", operationId = "apps/get-repo-installation")
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
  @Operation(description = "Returns a single tree using the SHA1 value for that tree.\n\nIf `truncated` is `true` in the response then the number of items in the `tree` array exceeded our maximum limit. If you need to fetch more items, use the non-recursive method of fetching trees, and fetch one sub-tree at a time.", summary = "Get a tree", operationId = "git/get-tree")
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
  @Operation(description = "Returns an array of references from your Git database that match the supplied name. The `:ref` in the URL must be formatted as `heads/<branch name>` for branches and `tags/<tag name>` for tags. If the `:ref` doesn't exist in the repository, but existing refs start with `:ref`, they will be returned as an array.\n\nWhen you use this endpoint without providing a `:ref`, it will return an array of all the references from your Git database, including notes and stashes if they exist on the server. Anything in the namespace is returned, not just `heads` and `tags`.\n\n**Note:** You need to explicitly [request a pull request](https://developer.github.com/v3/pulls/#get-a-pull-request) to trigger a test merge commit, which checks the mergeability of pull requests. For more information, see \"[Checking mergeability of pull requests](https://developer.github.com/v3/git/#checking-mergeability-of-pull-requests)\".\n\nIf you request matching references for a branch named `feature` but the branch `feature` doesn't exist, the response can still include other matching head refs that start with the word `feature`, such as `featureA` and `featureB`.", summary = "List matching references", operationId = "git/list-matching-refs")
  @Path("/{owner}/{repo}/git/matching-refs/{ref}")
  @GET
  @Produces("application/json")
  Response git_list_matching_refs(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("ref") String ref, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a reference", operationId = "git/delete-ref")
  @Path("/{owner}/{repo}/git/refs/{ref}")
  @DELETE
  void git_delete_ref(@PathParam("owner") String owner, @PathParam("repo") String repo, @PathParam("ref") String ref);

  /**
   *
   */
  @Operation(description = "", summary = "Update a reference", operationId = "git/update-ref")
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
  @Operation(description = "Creates a new Git [commit object](https://git-scm.com/book/en/v1/Git-Internals-Git-Objects#Commit-Objects).\n\nIn this example, the payload of the signature would be:\n\n\n\n**Signature verification object**\n\nThe response will include a `verification` object that describes the result of verifying the commit's signature. The following fields are included in the `verification` object:\n\nThese are the possible values for `reason` in the `verification` object:\n\n| Value                    | Description                                                                                                                       |\n| ------------------------ | --------------------------------------------------------------------------------------------------------------------------------- |\n| `expired_key`            | The key that made the signature is expired.                                                                                       |\n| `not_signing_key`        | The \"signing\" flag is not among the usage flags in the GPG key that made the signature.                                           |\n| `gpgverify_error`        | There was an error communicating with the signature verification service.                                                         |\n| `gpgverify_unavailable`  | The signature verification service is currently unavailable.                                                                      |\n| `unsigned`               | The object does not include a signature.                                                                                          |\n| `unknown_signature_type` | A non-PGP signature was found in the commit.                                                                                      |\n| `no_user`                | No user was associated with the `committer` email address in the commit.                                                          |\n| `unverified_email`       | The `committer` email address in the commit was associated with a user, but the email address is not verified on her/his account. |\n| `bad_email`              | The `committer` email address in the commit is not included in the identities of the PGP key that made the signature.             |\n| `unknown_key`            | The key that made the signature has not been registered with any user's account.                                                  |\n| `malformed_signature`    | There was an error parsing the signature.                                                                                         |\n| `invalid`                | The signature could not be cryptographically verified using the key whose key-id was found in the signature.                      |\n| `valid`                  | None of the above errors applied, so the signature is considered to be verified.                                                  |", summary = "Create a commit", operationId = "git/create-commit")
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
  @Operation(description = "**Signature verification object**\n\nThe response will include a `verification` object that describes the result of verifying the commit's signature. The following fields are included in the `verification` object:\n\nThese are the possible values for `reason` in the `verification` object:\n\n| Value                    | Description                                                                                                                       |\n| ------------------------ | --------------------------------------------------------------------------------------------------------------------------------- |\n| `expired_key`            | The key that made the signature is expired.                                                                                       |\n| `not_signing_key`        | The \"signing\" flag is not among the usage flags in the GPG key that made the signature.                                           |\n| `gpgverify_error`        | There was an error communicating with the signature verification service.                                                         |\n| `gpgverify_unavailable`  | The signature verification service is currently unavailable.                                                                      |\n| `unsigned`               | The object does not include a signature.                                                                                          |\n| `unknown_signature_type` | A non-PGP signature was found in the commit.                                                                                      |\n| `no_user`                | No user was associated with the `committer` email address in the commit.                                                          |\n| `unverified_email`       | The `committer` email address in the commit was associated with a user, but the email address is not verified on her/his account. |\n| `bad_email`              | The `committer` email address in the commit is not included in the identities of the PGP key that made the signature.             |\n| `unknown_key`            | The key that made the signature has not been registered with any user's account.                                                  |\n| `malformed_signature`    | There was an error parsing the signature.                                                                                         |\n| `invalid`                | The signature could not be cryptographically verified using the key whose key-id was found in the signature.                      |\n| `valid`                  | None of the above errors applied, so the signature is considered to be verified.                                                  |", summary = "Get a tag", operationId = "git/get-tag")
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
  @Operation(description = "The tree creation API accepts nested entries. If you specify both a tree and a nested path modifying that tree, this endpoint will overwrite the contents of the tree with the new path contents, and create a new tree structure.\n\nIf you use this endpoint to add, delete, or modify the file contents in a tree, you will need to commit the tree and then update a branch to point to the commit. For more information see \"[Create a commit](https://developer.github.com/v3/git/commits/#create-a-commit)\" and \"[Update a reference](https://developer.github.com/v3/git/refs/#update-a-reference).\"", summary = "Create a tree", operationId = "git/create-tree")
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
  @Operation(description = "Creates a reference for your repository. You are unable to create new references for empty repositories, even if the commit SHA-1 hash used exists. Empty repositories are repositories without branches.", summary = "Create a reference", operationId = "git/create-ref")
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
  @Operation(description = "Note that creating a tag object does not create the reference that makes a tag in Git. If you want to create an annotated tag in Git, you have to do this call to create the tag object, and then [create](https://developer.github.com/v3/git/refs/#create-a-reference) the `refs/tags/[tag]` reference. If you want to create a lightweight tag, you only have to [create](https://developer.github.com/v3/git/refs/#create-a-reference) the tag reference - this call would be unnecessary.\n\n**Signature verification object**\n\nThe response will include a `verification` object that describes the result of verifying the commit's signature. The following fields are included in the `verification` object:\n\nThese are the possible values for `reason` in the `verification` object:\n\n| Value                    | Description                                                                                                                       |\n| ------------------------ | --------------------------------------------------------------------------------------------------------------------------------- |\n| `expired_key`            | The key that made the signature is expired.                                                                                       |\n| `not_signing_key`        | The \"signing\" flag is not among the usage flags in the GPG key that made the signature.                                           |\n| `gpgverify_error`        | There was an error communicating with the signature verification service.                                                         |\n| `gpgverify_unavailable`  | The signature verification service is currently unavailable.                                                                      |\n| `unsigned`               | The object does not include a signature.                                                                                          |\n| `unknown_signature_type` | A non-PGP signature was found in the commit.                                                                                      |\n| `no_user`                | No user was associated with the `committer` email address in the commit.                                                          |\n| `unverified_email`       | The `committer` email address in the commit was associated with a user, but the email address is not verified on her/his account. |\n| `bad_email`              | The `committer` email address in the commit is not included in the identities of the PGP key that made the signature.             |\n| `unknown_key`            | The key that made the signature has not been registered with any user's account.                                                  |\n| `malformed_signature`    | There was an error parsing the signature.                                                                                         |\n| `invalid`                | The signature could not be cryptographically verified using the key whose key-id was found in the signature.                      |\n| `valid`                  | None of the above errors applied, so the signature is considered to be verified.                                                  |", summary = "Create a tag object", operationId = "git/create-tag")
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
  @Operation(description = "Returns a single reference from your Git database. The `:ref` in the URL must be formatted as `heads/<branch name>` for branches and `tags/<tag name>` for tags. If the `:ref` doesn't match an existing ref, a `404` is returned.\n\n**Note:** You need to explicitly [request a pull request](https://developer.github.com/v3/pulls/#get-a-pull-request) to trigger a test merge commit, which checks the mergeability of pull requests. For more information, see \"[Checking mergeability of pull requests](https://developer.github.com/v3/git/#checking-mergeability-of-pull-requests)\".", summary = "Get a reference", operationId = "git/get-ref")
  @Path("/{owner}/{repo}/git/ref/{ref}")
  @GET
  @Produces("application/json")
  Response git_get_ref(@PathParam("owner") String owner, @PathParam("repo") String repo, @PathParam("ref") String ref);

  /**
   *
   */
  @Operation(description = "", summary = "Create a blob", operationId = "git/create-blob")
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
  @Operation(description = "The `content` in the response will always be Base64 encoded.\n\n_Note_: This API supports blobs up to 100 megabytes in size.", summary = "Get a blob", operationId = "git/get-blob")
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
  @Operation(description = "Gets a Git [commit object](https://git-scm.com/book/en/v1/Git-Internals-Git-Objects#Commit-Objects).\n\n**Signature verification object**\n\nThe response will include a `verification` object that describes the result of verifying the commit's signature. The following fields are included in the `verification` object:\n\nThese are the possible values for `reason` in the `verification` object:\n\n| Value                    | Description                                                                                                                       |\n| ------------------------ | --------------------------------------------------------------------------------------------------------------------------------- |\n| `expired_key`            | The key that made the signature is expired.                                                                                       |\n| `not_signing_key`        | The \"signing\" flag is not among the usage flags in the GPG key that made the signature.                                           |\n| `gpgverify_error`        | There was an error communicating with the signature verification service.                                                         |\n| `gpgverify_unavailable`  | The signature verification service is currently unavailable.                                                                      |\n| `unsigned`               | The object does not include a signature.                                                                                          |\n| `unknown_signature_type` | A non-PGP signature was found in the commit.                                                                                      |\n| `no_user`                | No user was associated with the `committer` email address in the commit.                                                          |\n| `unverified_email`       | The `committer` email address in the commit was associated with a user, but the email address is not verified on her/his account. |\n| `bad_email`              | The `committer` email address in the commit is not included in the identities of the PGP key that made the signature.             |\n| `unknown_key`            | The key that made the signature has not been registered with any user's account.                                                  |\n| `malformed_signature`    | There was an error parsing the signature.                                                                                         |\n| `invalid`                | The signature could not be cryptographically verified using the key whose key-id was found in the signature.                      |\n| `valid`                  | None of the above errors applied, so the signature is considered to be verified.                                                  |", summary = "Get a commit", operationId = "git/get-commit")
  @Path("/{owner}/{repo}/git/commits/{commit_sha}")
  @GET
  @Produces("application/json")
  Response git_get_commit(@PathParam("owner") String owner, @PathParam("repo") String repo,
      @PathParam("commit_sha") String commitSha);
}
