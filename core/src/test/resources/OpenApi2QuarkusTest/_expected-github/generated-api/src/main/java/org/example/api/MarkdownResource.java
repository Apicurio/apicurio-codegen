package org.example.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.io.InputStream;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/markdown")
public interface MarkdownResource {
  /**
   *
   */
  @POST
  @Consumes("application/json")
  void markdown_render(InputStream data);

  /**
   * You must send Markdown as plain text (using a `Content-Type` header of `text/plain` or `text/x-markdown`) to this endpoint, rather than using JSON format. In raw mode, [GitHub Flavored Markdown](https://github.github.com/gfm/) is not supported and Markdown will be rendered in plain format like a README.md file. Markdown content must be 400 KB or less.
   */
  @Path("/raw")
  @POST
  @Produces("text/html")
  @Consumes({"text/x-markdown", "text/plain"})
  String markdown_render_raw(String data);
}
