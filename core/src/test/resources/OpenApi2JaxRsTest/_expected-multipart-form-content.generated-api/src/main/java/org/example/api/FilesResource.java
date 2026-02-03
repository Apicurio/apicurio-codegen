package org.example.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.api.beans.FileUploadProcessResponse;
import org.jboss.resteasy.annotations.providers.multipart.RestForm;
import org.jboss.resteasy.plugins.providers.multipart.FileUpload;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/files")
public interface FilesResource {
  @Path("/postFile")
  @POST
  @Produces("application/json")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  FileUploadProcessResponse postFile(@RestForm("file") FileUpload file);
}