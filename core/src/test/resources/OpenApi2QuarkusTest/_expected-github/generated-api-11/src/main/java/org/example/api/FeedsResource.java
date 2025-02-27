package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/feeds")
public interface FeedsResource {
  /**
   * <p>
   * GitHub provides several timeline resources in
   * <a href="http://en.wikipedia.org/wiki/Atom_(standard)">Atom</a> format. The
   * Feeds API lists all the feeds available to the authenticated user:
   * </p>
   * <ul>
   * <li><strong>Timeline</strong>: The GitHub global public timeline</li>
   * <li><strong>User</strong>: The public timeline for any user, using
   * <a href="https://developer.github.com/v3/#hypermedia">URI template</a></li>
   * <li><strong>Current user public</strong>: The public timeline for the
   * authenticated user</li>
   * <li><strong>Current user</strong>: The private timeline for the authenticated
   * user</li>
   * <li><strong>Current user actor</strong>: The private timeline for activity
   * created by the authenticated user</li>
   * <li><strong>Current user organizations</strong>: The private timeline for the
   * organizations the authenticated user is a member of.</li>
   * <li><strong>Security advisories</strong>: A collection of public
   * announcements that provide information about security-related vulnerabilities
   * in software on GitHub.</li>
   * </ul>
   * <p>
   * <strong>Note</strong>: Private feeds are only returned when <a href=
   * "https://developer.github.com/v3/#basic-authentication">authenticating via
   * Basic Auth</a> since current feed URIs use the older, non revocable auth
   * tokens.
   * </p>
   *
   */
  @Operation(description = "GitHub provides several timeline resources in [Atom](http://en.wikipedia.org/wiki/Atom_(standard)) format. The Feeds API lists all the feeds available to the authenticated user:\n\n*   **Timeline**: The GitHub global public timeline\n*   **User**: The public timeline for any user, using [URI template](https://developer.github.com/v3/#hypermedia)\n*   **Current user public**: The public timeline for the authenticated user\n*   **Current user**: The private timeline for the authenticated user\n*   **Current user actor**: The private timeline for activity created by the authenticated user\n*   **Current user organizations**: The private timeline for the organizations the authenticated user is a member of.\n*   **Security advisories**: A collection of public announcements that provide information about security-related vulnerabilities in software on GitHub.\n\n**Note**: Private feeds are only returned when [authenticating via Basic Auth](https://developer.github.com/v3/#basic-authentication) since current feed URIs use the older, non revocable auth tokens.", summary = "Get feeds", operationId = "activity/get-feeds")
  @GET
  @Produces("application/json")
  Response activity_get_feeds();
}
