package my.other.pkg;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import my.other.pkg.beans.Limits;
import my.other.pkg.beans.SystemInfo;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/apis/registry/v2/system")
public interface SystemResource {
  /**
   * <p>
   * This operation retrieves information about the running registry system, such
   * as the version of the software and when it was built.
   * </p>
   * 
   */
  @Path("/info")
  @GET
  @Produces("application/json")
  SystemInfo getSystemInfo();

  /**
   * <p>
   * This operation retrieves the list of limitations on used resources, that are
   * applied on the current instance of Registry.
   * </p>
   * 
   */
  @Path("/limits")
  @GET
  @Produces("application/json")
  Limits getResourceLimits();
}
