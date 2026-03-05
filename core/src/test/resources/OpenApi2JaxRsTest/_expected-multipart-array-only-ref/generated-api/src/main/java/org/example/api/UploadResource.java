package org.example.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.TestObject;
import org.jboss.resteasy.annotations.providers.multipart.RestForm;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/upload")
public interface UploadResource {
  @Operation(summary = "Upload with array-only ref field")
  @Path("/items")
  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  void uploadWithArrayonlyRefField(@RestForm("items") List<TestObject> items,
      @RestForm("amounts") List<BigDecimal> amounts);
}
