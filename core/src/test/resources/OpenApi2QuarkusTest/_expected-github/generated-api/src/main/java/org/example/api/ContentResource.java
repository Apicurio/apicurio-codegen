package org.example.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.io.InputStream;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/content_references")
public interface ContentResource {
  /**
   * <p>
   * Creates an attachment under a content reference URL in the body or comment of
   * an issue or pull request. Use the <code>id</code> of the content reference
   * from the <a href=
   * "https://developer.github.com/webhooks/event-payloads/#content_reference"><code>content_reference</code>
   * event</a> to create an attachment.
   * </p>
   * <p>
   * The app must create a content attachment within six hours of the content
   * reference URL being posted. See &quot;<a href=
   * "https://developer.github.com/apps/using-content-attachments/">Using content
   * attachments</a>&quot; for details about content attachments.
   * </p>
   * <p>
   * You must use an <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-an-installation">installation
   * access token</a> to access this endpoint.
   * </p>
   * 
   */
  @Path("/{content_reference_id}/attachments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response apps_create_content_attachment(@PathParam("content_reference_id") Integer contentReferenceId,
      InputStream data);
}
