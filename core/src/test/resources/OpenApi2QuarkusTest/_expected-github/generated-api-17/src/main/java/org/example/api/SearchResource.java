package org.example.api;

import jakarta.validation.constraints.NotNull;
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
@Path("/search")
public interface SearchResource {
  /**
   * <p>
   * Searches for query terms inside of a file. This method returns up to 100
   * results <a href="https://developer.github.com/v3/#pagination">per page</a>.
   * </p>
   * <p>
   * When searching for code, you can get text match metadata for the file
   * <strong>content</strong> and file <strong>path</strong> fields when you pass
   * the <code>text-match</code> media type. For more details about how to receive
   * highlighted search results, see
   * <a href="https://developer.github.com/v3/search/#text-match-metadata">Text
   * match metadata</a>.
   * </p>
   * <p>
   * For example, if you want to find the definition of the <code>addClass</code>
   * function inside <a href="https://github.com/jquery/jquery">jQuery</a>
   * repository, your query would look something like this:
   * </p>
   * <p>
   * <code>q=addClass+in:file+language:js+repo:jquery/jquery</code>
   * </p>
   * <p>
   * This query searches for the keyword <code>addClass</code> within a file's
   * contents. The query limits the search to files where the language is
   * JavaScript in the <code>jquery/jquery</code> repository.
   * </p>
   * <h4>Considerations for code search</h4>
   * <p>
   * Due to the complexity of searching code, there are a few restrictions on how
   * searches are performed:
   * </p>
   * <ul>
   * <li>Only the <em>default branch</em> is considered. In most cases, this will
   * be the <code>master</code> branch.</li>
   * <li>Only files smaller than 384 KB are searchable.</li>
   * <li>You must always include at least one search term when searching source
   * code. For example, searching for <a href=
   * "https://github.com/search?utf8=%E2%9C%93&amp;q=language%3Ago&amp;type=Code"><code>language:go</code></a>
   * is not valid, while <a href=
   * "https://github.com/search?utf8=%E2%9C%93&amp;q=amazing+language%3Ago&amp;type=Code"><code>amazing language:go</code></a>
   * is.</li>
   * </ul>
   *
   */
  @Operation(description = "Searches for query terms inside of a file. This method returns up to 100 results [per page](https://developer.github.com/v3/#pagination).\n\nWhen searching for code, you can get text match metadata for the file **content** and file **path** fields when you pass the `text-match` media type. For more details about how to receive highlighted search results, see [Text match metadata](https://developer.github.com/v3/search/#text-match-metadata).\n\nFor example, if you want to find the definition of the `addClass` function inside [jQuery](https://github.com/jquery/jquery) repository, your query would look something like this:\n\n`q=addClass+in:file+language:js+repo:jquery/jquery`\n\nThis query searches for the keyword `addClass` within a file's contents. The query limits the search to files where the language is JavaScript in the `jquery/jquery` repository.\n\n#### Considerations for code search\n\nDue to the complexity of searching code, there are a few restrictions on how searches are performed:\n\n*   Only the _default branch_ is considered. In most cases, this will be the `master` branch.\n*   Only files smaller than 384 KB are searchable.\n*   You must always include at least one search term when searching source code. For example, searching for [`language:go`](https://github.com/search?utf8=%E2%9C%93&q=language%3Ago&type=Code) is not valid, while [`amazing\nlanguage:go`](https://github.com/search?utf8=%E2%9C%93&q=amazing+language%3Ago&type=Code) is.", summary = "Search code", operationId = "search/code")
  @Path("/code")
  @GET
  @Produces("application/json")
  Response search_code(@QueryParam("q") @NotNull String q, @QueryParam("sort") String sort,
      @QueryParam("order") @DefaultValue("desc") String order,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Find labels in a repository with names or descriptions that match search
   * keywords. Returns up to 100 results
   * <a href="https://developer.github.com/v3/#pagination">per page</a>.
   * </p>
   * <p>
   * When searching for labels, you can get text match metadata for the label
   * <strong>name</strong> and <strong>description</strong> fields when you pass
   * the <code>text-match</code> media type. For more details about how to receive
   * highlighted search results, see
   * <a href="https://developer.github.com/v3/search/#text-match-metadata">Text
   * match metadata</a>.
   * </p>
   * <p>
   * For example, if you want to find labels in the <code>linguist</code>
   * repository that match <code>bug</code>, <code>defect</code>, or
   * <code>enhancement</code>. Your query might look like this:
   * </p>
   * <p>
   * <code>q=bug+defect+enhancement&amp;repository_id=64778136</code>
   * </p>
   * <p>
   * The labels that best match the query appear first in the search results.
   * </p>
   *
   */
  @Operation(description = "Find labels in a repository with names or descriptions that match search keywords. Returns up to 100 results [per page](https://developer.github.com/v3/#pagination).\n\nWhen searching for labels, you can get text match metadata for the label **name** and **description** fields when you pass the `text-match` media type. For more details about how to receive highlighted search results, see [Text match metadata](https://developer.github.com/v3/search/#text-match-metadata).\n\nFor example, if you want to find labels in the `linguist` repository that match `bug`, `defect`, or `enhancement`. Your query might look like this:\n\n`q=bug+defect+enhancement&repository_id=64778136`\n\nThe labels that best match the query appear first in the search results.", summary = "Search labels", operationId = "search/labels")
  @Path("/labels")
  @GET
  @Produces("application/json")
  Response search_labels(@QueryParam("repository_id") @NotNull BigInteger repositoryId,
      @QueryParam("q") @NotNull String q, @QueryParam("sort") String sort,
      @QueryParam("order") @DefaultValue("desc") String order);

  /**
   * <p>
   * Find users via various criteria. This method returns up to 100 results
   * <a href="https://developer.github.com/v3/#pagination">per page</a>.
   * </p>
   * <p>
   * When searching for users, you can get text match metadata for the issue
   * <strong>login</strong>, <strong>email</strong>, and <strong>name</strong>
   * fields when you pass the <code>text-match</code> media type. For more details
   * about highlighting search results, see
   * <a href="https://developer.github.com/v3/search/#text-match-metadata">Text
   * match metadata</a>. For more details about how to receive highlighted search
   * results, see
   * <a href="https://developer.github.com/v3/search/#text-match-metadata">Text
   * match metadata</a>.
   * </p>
   * <p>
   * For example, if you're looking for a list of popular users, you might try
   * this query:
   * </p>
   * <p>
   * <code>q=tom+repos:%3E42+followers:%3E1000</code>
   * </p>
   * <p>
   * This query searches for users with the name <code>tom</code>. The results are
   * restricted to users with more than 42 repositories and over 1,000 followers.
   * </p>
   *
   */
  @Operation(description = "Find users via various criteria. This method returns up to 100 results [per page](https://developer.github.com/v3/#pagination).\n\nWhen searching for users, you can get text match metadata for the issue **login**, **email**, and **name** fields when you pass the `text-match` media type. For more details about highlighting search results, see [Text match metadata](https://developer.github.com/v3/search/#text-match-metadata). For more details about how to receive highlighted search results, see [Text match metadata](https://developer.github.com/v3/search/#text-match-metadata).\n\nFor example, if you're looking for a list of popular users, you might try this query:\n\n`q=tom+repos:%3E42+followers:%3E1000`\n\nThis query searches for users with the name `tom`. The results are restricted to users with more than 42 repositories and over 1,000 followers.", summary = "Search users", operationId = "search/users")
  @Path("/users")
  @GET
  @Produces("application/json")
  Response search_users(@QueryParam("q") @NotNull String q, @QueryParam("sort") String sort,
      @QueryParam("order") @DefaultValue("desc") String order,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Find commits via various criteria on the default branch (usually
   * <code>master</code>). This method returns up to 100 results
   * <a href="https://developer.github.com/v3/#pagination">per page</a>.
   * </p>
   * <p>
   * When searching for commits, you can get text match metadata for the
   * <strong>message</strong> field when you provide the <code>text-match</code>
   * media type. For more details about how to receive highlighted search results,
   * see
   * <a href="https://developer.github.com/v3/search/#text-match-metadata">Text
   * match metadata</a>.
   * </p>
   * <p>
   * For example, if you want to find commits related to CSS in the
   * <a href="https://github.com/octocat/Spoon-Knife">octocat/Spoon-Knife</a>
   * repository. Your query would look something like this:
   * </p>
   * <p>
   * <code>q=repo:octocat/Spoon-Knife+css</code>
   * </p>
   *
   */
  @Operation(description = "Find commits via various criteria on the default branch (usually `master`). This method returns up to 100 results [per page](https://developer.github.com/v3/#pagination).\n\nWhen searching for commits, you can get text match metadata for the **message** field when you provide the `text-match` media type. For more details about how to receive highlighted search results, see [Text match\nmetadata](https://developer.github.com/v3/search/#text-match-metadata).\n\nFor example, if you want to find commits related to CSS in the [octocat/Spoon-Knife](https://github.com/octocat/Spoon-Knife) repository. Your query would look something like this:\n\n`q=repo:octocat/Spoon-Knife+css`", summary = "Search commits", operationId = "search/commits")
  @Path("/commits")
  @GET
  @Produces("application/json")
  Response search_commits(@QueryParam("q") @NotNull String q, @QueryParam("sort") String sort,
      @QueryParam("order") @DefaultValue("desc") String order,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Find issues by state and keyword. This method returns up to 100 results
   * <a href="https://developer.github.com/v3/#pagination">per page</a>.
   * </p>
   * <p>
   * When searching for issues, you can get text match metadata for the issue
   * <strong>title</strong>, issue <strong>body</strong>, and issue
   * <strong>comment body</strong> fields when you pass the
   * <code>text-match</code> media type. For more details about how to receive
   * highlighted search results, see
   * <a href="https://developer.github.com/v3/search/#text-match-metadata">Text
   * match metadata</a>.
   * </p>
   * <p>
   * For example, if you want to find the oldest unresolved Python bugs on
   * Windows. Your query might look something like this.
   * </p>
   * <p>
   * <code>q=windows+label:bug+language:python+state:open&amp;sort=created&amp;order=asc</code>
   * </p>
   * <p>
   * This query searches for the keyword <code>windows</code>, within any open
   * issue that is labeled as <code>bug</code>. The search runs across
   * repositories whose primary language is Python. The results are sorted by
   * creation date in ascending order, whick means the oldest issues appear first
   * in the search results.
   * </p>
   *
   */
  @Operation(description = "Find issues by state and keyword. This method returns up to 100 results [per page](https://developer.github.com/v3/#pagination).\n\nWhen searching for issues, you can get text match metadata for the issue **title**, issue **body**, and issue **comment body** fields when you pass the `text-match` media type. For more details about how to receive highlighted\nsearch results, see [Text match metadata](https://developer.github.com/v3/search/#text-match-metadata).\n\nFor example, if you want to find the oldest unresolved Python bugs on Windows. Your query might look something like this.\n\n`q=windows+label:bug+language:python+state:open&sort=created&order=asc`\n\nThis query searches for the keyword `windows`, within any open issue that is labeled as `bug`. The search runs across repositories whose primary language is Python. The results are sorted by creation date in ascending order, whick means the oldest issues appear first in the search results.", summary = "Search issues and pull requests", operationId = "search/issues-and-pull-requests")
  @Path("/issues")
  @GET
  @Produces("application/json")
  Response search_issues_and_pull_requests(@QueryParam("q") @NotNull String q, @QueryParam("sort") String sort,
      @QueryParam("order") @DefaultValue("desc") String order,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Find repositories via various criteria. This method returns up to 100 results
   * <a href="https://developer.github.com/v3/#pagination">per page</a>.
   * </p>
   * <p>
   * When searching for repositories, you can get text match metadata for the
   * <strong>name</strong> and <strong>description</strong> fields when you pass
   * the <code>text-match</code> media type. For more details about how to receive
   * highlighted search results, see
   * <a href="https://developer.github.com/v3/search/#text-match-metadata">Text
   * match metadata</a>.
   * </p>
   * <p>
   * For example, if you want to search for popular Tetris repositories written in
   * assembly code, your query might look like this:
   * </p>
   * <p>
   * <code>q=tetris+language:assembly&amp;sort=stars&amp;order=desc</code>
   * </p>
   * <p>
   * This query searches for repositories with the word <code>tetris</code> in the
   * name, the description, or the README. The results are limited to repositories
   * where the primary language is assembly. The results are sorted by stars in
   * descending order, so that the most popular repositories appear first in the
   * search results.
   * </p>
   * <p>
   * When you include the <code>mercy</code> preview header, you can also search
   * for multiple topics by adding more <code>topic:</code> instances. For
   * example, your query might look like this:
   * </p>
   * <p>
   * <code>q=topic:ruby+topic:rails</code>
   * </p>
   *
   */
  @Operation(description = "Find repositories via various criteria. This method returns up to 100 results [per page](https://developer.github.com/v3/#pagination).\n\nWhen searching for repositories, you can get text match metadata for the **name** and **description** fields when you pass the `text-match` media type. For more details about how to receive highlighted search results, see [Text match metadata](https://developer.github.com/v3/search/#text-match-metadata).\n\nFor example, if you want to search for popular Tetris repositories written in assembly code, your query might look like this:\n\n`q=tetris+language:assembly&sort=stars&order=desc`\n\nThis query searches for repositories with the word `tetris` in the name, the description, or the README. The results are limited to repositories where the primary language is assembly. The results are sorted by stars in descending order, so that the most popular repositories appear first in the search results.\n\nWhen you include the `mercy` preview header, you can also search for multiple topics by adding more `topic:` instances. For example, your query might look like this:\n\n`q=topic:ruby+topic:rails`", summary = "Search repositories", operationId = "search/repos")
  @Path("/repositories")
  @GET
  @Produces("application/json")
  Response search_repos(@QueryParam("q") @NotNull String q, @QueryParam("sort") String sort,
      @QueryParam("order") @DefaultValue("desc") String order,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Find topics via various criteria. Results are sorted by best match. This
   * method returns up to 100 results
   * <a href="https://developer.github.com/v3/#pagination">per page</a>. See
   * &quot;<a href="https://help.github.com/articles/searching-topics/">Searching
   * topics</a>&quot; for a detailed list of qualifiers.
   * </p>
   * <p>
   * When searching for topics, you can get text match metadata for the topic's
   * <strong>short_description</strong>, <strong>description</strong>,
   * <strong>name</strong>, or <strong>display_name</strong> field when you pass
   * the <code>text-match</code> media type. For more details about how to receive
   * highlighted search results, see
   * <a href="https://developer.github.com/v3/search/#text-match-metadata">Text
   * match metadata</a>.
   * </p>
   * <p>
   * For example, if you want to search for topics related to Ruby that are
   * featured on https://github.com/topics. Your query might look like this:
   * </p>
   * <p>
   * <code>q=ruby+is:featured</code>
   * </p>
   * <p>
   * This query searches for topics with the keyword <code>ruby</code> and limits
   * the results to find only topics that are featured. The topics that are the
   * best match for the query appear first in the search results.
   * </p>
   *
   */
  @Operation(description = "Find topics via various criteria. Results are sorted by best match. This method returns up to 100 results [per page](https://developer.github.com/v3/#pagination). See \"[Searching topics](https://help.github.com/articles/searching-topics/)\" for a detailed list of qualifiers.\n\nWhen searching for topics, you can get text match metadata for the topic's **short\\_description**, **description**, **name**, or **display\\_name** field when you pass the `text-match` media type. For more details about how to receive highlighted search results, see [Text match metadata](https://developer.github.com/v3/search/#text-match-metadata).\n\nFor example, if you want to search for topics related to Ruby that are featured on https://github.com/topics. Your query might look like this:\n\n`q=ruby+is:featured`\n\nThis query searches for topics with the keyword `ruby` and limits the results to find only topics that are featured. The topics that are the best match for the query appear first in the search results.", summary = "Search topics", operationId = "search/topics")
  @Path("/topics")
  @GET
  @Produces("application/json")
  Response search_topics(@QueryParam("q") @NotNull String q);
}
