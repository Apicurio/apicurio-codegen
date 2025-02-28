package my.other.pkg;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import my.other.pkg.beans.Limits;
import my.other.pkg.beans.SystemInfo;
import org.eclipse.microprofile.openapi.annotations.Operation;

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
  @Operation(description = "This operation retrieves information about the running registry system, such as the version\nof the software and when it was built.", summary = "Get system information", operationId = "getSystemInfo")
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
  @Operation(description = "This operation retrieves the list of limitations on used resources, that are applied on the current instance of Registry.", summary = "Get resource limits information", operationId = "getResourceLimits")
  @Path("/limits")
  @GET
  @Produces("application/json")
  Limits getResourceLimits();
}
