package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.TestObject;
import org.example.api.beans.UploadResponse;
import org.jboss.resteasy.annotations.providers.multipart.RestForm;
import org.jboss.resteasy.plugins.providers.multipart.FileUpload;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/upload")
public interface UploadResource {
  @Operation(summary = "Upload with comprehensive field types")
  @Path("/comprehensive")
  @POST
  @Produces("application/json")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  UploadResponse uploadWithComprehensiveFieldTypes(@RestForm("requiredFile") @NotNull FileUpload requiredFile,
      @RestForm("requiredText") @NotNull String requiredText,
      @RestForm("requiredNumber") @NotNull Integer requiredNumber, @RestForm("optionalFile") FileUpload optionalFile,
      @RestForm("optionalText") String optionalText, @RestForm("longNumber") Integer longNumber,
      @RestForm("floatNumber") Float floatNumber, @RestForm("doubleNumber") Double doubleNumber,
      @RestForm("bigDecimalNumber") BigDecimal bigDecimalNumber, @RestForm("booleanFlag") Boolean booleanFlag,
      @RestForm("dateField") LocalDate dateField, @RestForm("dateTimeField") LocalDateTime dateTimeField,
      @RestForm("stringArray") List<String> stringArray, @RestForm("integerArray") List<Integer> integerArray,
      @RestForm("objectReference") TestObject objectReference,
      @RestForm("objectArrayReference") List<TestObject> objectArrayReference,
      @RestForm("genericObject") Map<String, Object> genericObject);

  @Operation(summary = "Edge cases for multipart processing")
  @Path("/edge-cases")
  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  void edgeCasesForMultipartProcessing(@RestForm("unknownType") String unknownType,
      @RestForm("noTypeField") Map<String, Object> noTypeField,
      @RestForm("emptyArrayItems") List<String> emptyArrayItems);
}
