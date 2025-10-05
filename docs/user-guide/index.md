# User Guide

Welcome to the comprehensive user guide for Apicurio Codegen. This section provides detailed documentation for all features and capabilities.

## Table of Contents

### Basic Usage
- **Installation & Setup** - Different ways to install and configure Apicurio Codegen
- **Maven Plugin** - Detailed Maven plugin configuration and usage
- **CLI Usage** - Command-line interface documentation
- **Configuration Reference** - Complete configuration options

### Code Generation
- **OpenAPI Support** - Supported OpenAPI features and specifications
- **Output Formats** - Different types of code you can generate
- **Customization** - How to customize generated code
- **Templates** - Working with custom templates

### Integration
- **Quarkus Integration** - Deep integration with Quarkus applications
- **Build Integration** - Integrating with various build systems
- **CI/CD Pipelines** - Using Apicurio Codegen in automated workflows

### Advanced Topics
- **Performance Tuning** - Optimizing code generation for large APIs
- **Troubleshooting** - Common issues and solutions
- **Contributing** - How to contribute to the project

---

*This user guide is under active development. More sections will be added as the documentation evolves.*

## Quick Navigation

- [← Back to Getting Started](../getting-started.md)
- [← Back to Home](../index.md)
- [View on GitHub →](https://github.com/apicurio/apicurio-codegen)

## Apicurio Codegen OpenAPI Extensions

Apicurio Codegen uses [OpenAPI specification extensions](https://spec.openapis.org/oas/v3.0.3.html#specification-extensions) to allow customization of the generated source code based on your API contract.

### `x-codegen`

The `x-codegen` extension can be defined at the root level of the OpenAPI document.  

It is applied globally and allows you to customize the generated bean classes by:
- Adding annotations to all generated beans.
- Controlling date/time formatting.
- Configuring the application context root.

### `x-codegen.bean-annotations`

Adding annotations to generated bean classes:

```json
{
  "x-codegen": {
    "bean-annotations": [
      "@lombok.ToString", // (1)
      {
        "annotation": "@lombok.EqualsAndHashCode", // (2)
        "excludeEnums": true
      }
    ]
  }
}
```

1. Adds the `@lombok.ToString` annotation to all generated bean classes.
2. Adds the `@lombok.EqualsAndHashCode` annotation to all generated bean classes, except for Java enums (when excludeEnums is set to `true`).

### `x-codegen.contextRoot`

Additionally, you can configure the application context root using the `x-codegen.contextRoot` property.  

This property defines a base path that will be automatically prefixed to all generated JAX-RS resource classes.

For example, if you set the context root to `/apis/studio/v1`, all generated resource paths will include this prefix.

```json
{
  "x-codegen": {
    "contextRoot": "/apis/studio/v1",
    "bean-annotations": []
  }
}
```

Corresponding JAX-RS code:

```java
@Path("/apis/studio/v1/users")
public class UserResource {}
```

!!! note "Note"

    You can use the `x-codegen-contextRoot` property to apply a context root prefix to a specific JAX-RS resource instead of using the global one.

### `x-codegen.suppress-date-time-formatting`

By default, Apicurio Codegen generates properties of type `string` with the format `date-time` as shown below:

```java
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
@JsonProperty("shipDate")
private Date shipDate;
```

If you want to disable this behavior, you can use the `x-codegen.suppress-date-time-formatting` property to remove the `@JsonFormat` annotation from generated fields.

```json
{
  "x-codegen": {
    "suppress-date-time-formatting": true
  }
}
```
