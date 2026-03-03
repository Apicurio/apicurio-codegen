package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.JsonPayload;
import org.jboss.resteasy.annotations.providers.multipart.RestForm;
import org.jboss.resteasy.plugins.providers.multipart.FileUpload;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/edge")
public interface EdgeResource {
  @Operation(summary = "Multipart with top-level string schema (not object) - should generate no params", operationId = "invalidStringSchema")
  @Path("/invalid-string-schema")
  @POST
  void invalidStringSchema();

  @Operation(summary = "Multipart with top-level array schema (not object) - should generate no params", operationId = "invalidArraySchema")
  @Path("/invalid-array-schema")
  @POST
  void invalidArraySchema();

  @Operation(summary = "Multipart with a property having an empty schema {} - maps to Map<String, Object>", operationId = "nullFieldSchemas")
  @Path("/null-field-schemas")
  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  void nullFieldSchemas(@RestForm("emptySchema") Map<String, Object> emptySchema,
      @RestForm("normalField") String normalField);

  @Operation(summary = "Multipart with required list containing a ghost field not in properties", operationId = "requiredFields")
  @Path("/required-fields")
  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  void requiredFields(@RestForm("existingRequired") @NotNull String existingRequired,
      @RestForm("optionalField") Integer optionalField);

  @Operation(summary = "Non-multipart JSON content - should generate a normal body param", operationId = "jsonOnly")
  @Path("/json-only")
  @POST
  @Consumes("application/json")
  void jsonOnly(@NotNull JsonPayload data);

  @Operation(summary = "Mixed content types - multipart takes priority, JSON body is skipped", operationId = "mixedMultipartJson")
  @Path("/mixed-multipart-json")
  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  void mixedMultipartJson(@RestForm("file") FileUpload file, @RestForm("description") String description);
}
