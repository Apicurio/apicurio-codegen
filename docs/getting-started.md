# Getting Started

This guide will help you get up and running with Apicurio Codegen in just a few minutes.

## Prerequisites

Before you begin, ensure you have:

- **Java 11 or later** installed
- **Maven 3.6+** for building projects
- **An OpenAPI specification** (we'll provide a simple example)

## Hello World Example

Let's create a simple "Hello World" API and generate code from it.

### Step 1: Create a Simple OpenAPI Specification

Create a file called `hello-api.yaml`:

```yaml
openapi: 3.0.3
info:
  title: Hello World API
  description: A simple Hello World API
  version: 1.0.0
servers:
  - url: http://localhost:8080
    description: Development server
paths:
  /hello:
    get:
      summary: Say hello
      operationId: sayHello
      parameters:
        - name: name
          in: query
          required: false
          schema:
            type: string
            default: "World"
      responses:
        '200':
          description: Successful response
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Greeting'
components:
  schemas:
    Greeting:
      type: object
      properties:
        message:
          type: string
          example: "Hello, World!"
        timestamp:
          type: string
          format: date-time
      required:
        - message
        - timestamp
```

### Step 2: Set Up Maven Project

Create a new Maven project with the following `pom.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                           http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>hello-world-api</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <quarkus.platform.version>3.2.8.Final</quarkus.platform.version>
        <apicurio-codegen.version>1.2.6.Final</apicurio-codegen.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>io.quarkus.platform</groupId>
                <artifactId>quarkus-bom</artifactId>
                <version>${quarkus.platform.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-resteasy-reactive-jackson</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>io.apicurio</groupId>
                <artifactId>apicurio-codegen-maven-plugin</artifactId>
                <version>${apicurio-codegen.version}</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <inputSpec>hello-api.yaml</inputSpec>
                            <output>target/generated-sources/apicurio</output>
                            <projectSettings>
                                <javaPackage>com.example.hello</javaPackage>
                            </projectSettings>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

### Step 3: Generate Code

Run the code generation:

```bash
mvn clean generate-sources
```

This will generate:

- **JAX-RS resource interfaces** in `target/generated-sources/apicurio/`
- **Data model classes** (`Greeting.java`)
- **API interfaces** ready for implementation

### Step 4: Implement the Generated Interface

Create `src/main/java/com/example/hello/HelloResource.java`:

```java
package com.example.hello;

import java.time.OffsetDateTime;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloResource implements HelloApi {

    @Override
    public Greeting sayHello(String name) {
        Greeting greeting = new Greeting();
        greeting.setMessage("Hello, " + (name != null ? name : "World") + "!");
        greeting.setTimestamp(OffsetDateTime.now());
        return greeting;
    }
}
```

### Step 5: Run Your Application

```bash
mvn quarkus:dev
```

Your API is now running at `http://localhost:8080`!

Test it:
```bash
curl "http://localhost:8080/hello?name=Developer"
```

Response:
```json
{
  "message": "Hello, Developer!",
  "timestamp": "2024-01-15T10:30:00Z"
}
```

## What's Next?

Now that you have a working example, explore more advanced features:

- **Configuration Options** - Customize package names, add validation, etc.
- **Multiple Output Formats** - Generate clients, async APIs, and more
- **Integration Patterns** - Learn about different ways to integrate the generator
- **Advanced OpenAPI Features** - Work with complex schemas, security, and more

Check out the [User Guide](user-guide/) for detailed documentation on all features.