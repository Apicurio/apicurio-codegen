package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/test")
public interface TestResource {
  /**
   * <p>
   * 测试中文字符
   * </p>
   *
   */
  @Operation(description = "\u6D4B\u8BD5\u4E2D\u6587\u5B57\u7B26", summary = "\u6D4B\u8BD5\u4E2D\u6587\u5B57\u7B26")
  @Path("/chinese/character")
  @GET
  void character();
}
