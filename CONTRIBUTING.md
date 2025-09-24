# Contributing guide

**Want to contribute? Great!**
We try to make it easy, and all contributions, even the smaller ones, are more than welcome.
This includes bug reports, fixes, documentation, examples...
But first, read this page (including the small print at the end).

- [Legal](#legal)
- [Reporting an issue](#reporting-an-issue)
- [Before you contribute](#before-you-contribute)
  - [Code reviews](#code-reviews)
  - [Coding Guidelines](#coding-guidelines)
  - [Continuous Integration](#continuous-integration)
  - [Tests and documentation are not optional](#tests-and-documentation-are-not-optional)
- [Development Setup](#development-setup)
  - [Prerequisites](#prerequisites)
  - [Building the Project](#building-the-project)
  - [Running Tests](#running-tests)
- [Documentation Contributions](#documentation-contributions)
- [The small print](#the-small-print)

## Legal

All original contributions to Apicurio projects are licensed under the
[ASL - Apache License](https://www.apache.org/licenses/LICENSE-2.0),
version 2.0 or later, or, if another license is specified as governing the file or directory being
modified, such other license.

All contributions are subject to the [Developer Certificate of Origin (DCO)](https://developercertificate.org/).
The DCO text is also included verbatim in the [dco.txt](dco.txt) file in the root directory of the repository.

## Reporting an issue

This project uses GitHub issues to manage the issues. Open an issue directly in GitHub.

If you believe you found a bug, and it's likely possible, please indicate a way to reproduce it, what you are seeing and what you would expect to see.
Don't forget to indicate your Apicurio Codegen, Java, and Maven versions.

## Before you contribute

To contribute, use GitHub Pull Requests, from your **own** fork.

Also, make sure you have set up your Git authorship correctly:

```
git config --global user.name "Your Full Name"
git config --global user.email your.email@example.com
```

If you use different computers to contribute, please make sure the name is the same on all your computers.

We may use this information to acknowledge your contributions!

### Code reviews

All submissions, including submissions by project members, require review. We use GitHub pull requests for this purpose.
Consult [GitHub Help](https://help.github.com/articles/about-pull-requests/) for more information on using pull requests.

### Coding Guidelines

* We follow standard Java coding conventions
* Use 4 spaces for indentation (no tabs)
* Maximum line length is 120 characters
* Write meaningful commit messages
* Include tests for new functionality
* Update documentation when appropriate
* Use descriptive variable and method names
* Follow existing code patterns and conventions

### Continuous Integration

Because we are all humans, and to ensure Apicurio Codegen is stable for everyone, all changes must go through Apicurio Codegen continuous integration.
Apicurio Codegen CI is based on GitHub Actions, which means that everyone has the ability to automatically execute CI in their forks as part of the process of making changes.
We ask that all non-trivial changes go through this process, so that the contributor gets immediate feedback, while at the same time keeping our CI fast and healthy for everyone.

The process requires only that you maintain a fork of the Apicurio Codegen repository and sync it occasionally with the upstream repository.

### Tests and documentation are not optional

Don't forget to include tests in your pull requests.
Also don't forget the documentation (reference documentation, javadoc...).

We even accept pull requests that only fix typos in documentation!

## Development Setup

### Prerequisites

- **Java 11 or later** (we test with Java 11, 17, and 21)
- **Maven 3.6+**
- **Git**

### Building the Project

Clone the repository and build:

```bash
git clone https://github.com/apicurio/apicurio-codegen.git
cd apicurio-codegen

# Build all modules
./mvnw clean install

# Build without running tests (faster for development)
./mvnw clean install -DskipTests
```

### Running Tests

```bash
# Run all tests
./mvnw test

# Run a specific test class
./mvnw test -Dtest=OpenApi2QuarkusTest

# Run tests with verbose output
./mvnw test -X
```

## Documentation Contributions

We use MkDocs for our documentation. To contribute to documentation:

1. **Install MkDocs**:
   ```bash
   pip install mkdocs mkdocs-material mkdocstrings
   ```

2. **Preview documentation locally**:
   ```bash
   mkdocs serve
   # Visit http://127.0.0.1:8000
   ```

3. **Build documentation**:
   ```bash
   mkdocs build
   # Output goes to ./target/site/
   ```

4. **Documentation structure**:
   - All docs are in the `docs/` directory
   - Written in Markdown format
   - Use code examples and clear explanations
   - Include working examples when possible

## The small print

This project is an open source project. Please act responsibly, be nice, polite, and enjoy!

We welcome contributions in many forms:

- **Bug reports** - Help us identify and fix issues
- **Feature requests** - Suggest new capabilities
- **Code contributions** - Fix bugs or add new features
- **Documentation** - Improve or add to our docs
- **Examples** - Show how to use Apicurio Codegen
- **Testing** - Help us test on different platforms

Remember that this is a volunteer-driven project. Be patient, be kind, and let's build something great together!

For questions about contributing, feel free to:
- Open a GitHub issue
- Start a discussion in GitHub Discussions
- Reach out to the maintainers

**Thank you for contributing to Apicurio Codegen!**