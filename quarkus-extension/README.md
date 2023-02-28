# Apicurio Codegen Quarkus Extension

A Quarkus extension that can be used to generate JAX-RS interfaces and Java beans.

## Configuration

First, add the following dependency to your application in order to have the code generation capabilities available.

```xml
<dependency>
    <groupId>io.apicurio</groupId>
    <artifactId>apicurio-codegen-quarkus-extension</artifactId>
</dependency>
```

Once the extension has been added to your application, you must configure it as follows:

```
# Codegen properties
apicurio.codegen.openapi.spec=petstore-openapi.json
apicurio.codegen.openapi.base-package=io.petstore
```

With that configuration being the first property the name of the OpenAPI spec, located in your resources folder, and the second
configuration property being the base package used by the generator to create the Java file, the extension will generate the 
JAX-RS interfaces and the Java beans for you. 


