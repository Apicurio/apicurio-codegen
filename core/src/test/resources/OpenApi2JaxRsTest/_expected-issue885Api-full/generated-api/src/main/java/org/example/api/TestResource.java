package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

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
  @Path("/chinese/character")
  @GET
  void generatedMethod1();
}
