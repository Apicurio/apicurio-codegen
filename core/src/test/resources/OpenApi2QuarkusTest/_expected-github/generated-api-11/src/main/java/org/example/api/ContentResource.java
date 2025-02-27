package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.io.InputStream;
import java.math.BigInteger;
import org.eclipse.microprofile.openapi.annotations.Operation;

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
  @Operation(description = "Creates an attachment under a content reference URL in the body or comment of an issue or pull request. Use the `id` of the content reference from the [`content_reference` event](https://developer.github.com/webhooks/event-payloads/#content_reference) to create an attachment.\n\nThe app must create a content attachment within six hours of the content reference URL being posted. See \"[Using content attachments](https://developer.github.com/apps/using-content-attachments/)\" for details about content attachments.\n\nYou must use an [installation access token](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-an-installation) to access this endpoint.", summary = "Create a content attachment", operationId = "apps/create-content-attachment")
  @Path("/{content_reference_id}/attachments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response apps_create_content_attachment(@PathParam("content_reference_id") BigInteger contentReferenceId,
      @NotNull InputStream data);
}
