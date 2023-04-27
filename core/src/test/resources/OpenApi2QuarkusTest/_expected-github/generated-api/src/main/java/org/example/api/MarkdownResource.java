package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.io.InputStream;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/markdown")
public interface MarkdownResource {
  /**
   * 
   */
  @POST
  @Consumes("application/json")
  void markdown_render(@NotNull InputStream data);

  /**
   * <p>
   * You must send Markdown as plain text (using a <code>Content-Type</code>
   * header of <code>text/plain</code> or <code>text/x-markdown</code>) to this
   * endpoint, rather than using JSON format. In raw mode,
   * <a href="https://github.github.com/gfm/">GitHub Flavored Markdown</a> is not
   * supported and Markdown will be rendered in plain format like a README.md
   * file. Markdown content must be 400 KB or less.
   * </p>
   * 
   */
  @Path("/raw")
  @POST
  @Produces("text/html")
  @Consumes({"text/x-markdown", "text/plain"})
  String markdown_render_raw(@NotNull String data);
}
