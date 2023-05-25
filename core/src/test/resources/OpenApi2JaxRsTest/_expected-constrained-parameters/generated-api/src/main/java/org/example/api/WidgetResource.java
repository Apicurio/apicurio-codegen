package org.example.api;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.util.List;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/widget-names")
public interface WidgetResource {
  @GET
  @Produces("application/json")
  List<String> getWidgetNames(
      @QueryParam("ownerId") @DecimalMax(value = "1000000000", inclusive = false) @DecimalMin(value = "1", inclusive = true) @DefaultValue("100") Integer ownerId,
      @QueryParam("userId") @DecimalMax(value = "999999999", inclusive = true) @DecimalMin(value = "0", inclusive = false) Integer userId,
      @QueryParam("nameFilter") @Size(max = 10) @Size(min = 1) List<String> nameFilter,
      @CookieParam("sessionToken") @Size(max = 20) @Size(min = 1) @Pattern(regexp = "\\S") String sessionToken,
      @CookieParam("sessionInfo") Object sessionInfo);
}
