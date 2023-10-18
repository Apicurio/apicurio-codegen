package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/gitignore")
public interface GitignoreResource {
  /**
   * <p>
   * The API also allows fetching the source of a single template. Use the raw
   * <a href="https://developer.github.com/v3/media/">media type</a> to get the
   * raw contents.
   * </p>
   * 
   */
  @Path("/templates/{name}")
  @GET
  @Produces("application/json")
  Response gitignore_get_template(@PathParam("name") String name);

  /**
   * <p>
   * List all templates available to pass as an option when <a href=
   * "https://developer.github.com/v3/repos/#create-a-repository-for-the-authenticated-user">creating
   * a repository</a>.
   * </p>
   * 
   */
  @Path("/templates")
  @GET
  @Produces("application/json")
  List<String> gitignore_get_all_templates();
}
