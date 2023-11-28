package my.other.pkg;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import my.other.pkg.beans.UserInfo;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/apis/registry/v2/users")
public interface UsersResource {
  /**
   * <p>
   * Returns information about the currently authenticated user.
   * </p>
   * 
   */
  @Path("/me")
  @GET
  @Produces("application/json")
  UserInfo getCurrentUserInfo();
}
