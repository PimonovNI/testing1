# Contributing to Testing1

Thank you for considering contributing to this project!  
Please follow the guidelines below to ensure a smooth collaboration.

## Reporting Issues

1. **Check existing issues** – search the [issue tracker](https://github.com/PimonovNI/testing1/issues) to avoid duplicates.
2. **Use the provided templates** – we have issue templates for bug reports and feature requests.
3. **Provide clear details**:
    - Steps to reproduce the bug
    - Expected vs actual behavior
    - Environment (OS, JDK version, etc.)
    - Screenshots or logs if applicable

## Submitting Pull Requests

1. **Fork the repository** and create your branch from `main`.
2. **Keep changes focused** – one feature/fix per PR.
3. **Follow the code style** – use Kotlin idioms and keep formatting consistent.
4. **Add/update tests** if your change affects functionality.
5. **Run the build** locally:
   ```bash
   ./gradlew clean build
   ```
Ensure all tests pass and there are no lint errors.
6. **Write a clear commit message** and PR description.
7. **Link any related issues** in the PR description.

## Development Setup

1. Clone the repository.
2. Open it in **IntelliJ IDEA** (recommended) or any Kotlin-compatible IDE.
3. Use the Gradle wrapper for building and running.

### Useful Gradle tasks

| Task | Description |
|------|-------------|
| `./gradlew build` | Compiles and tests the project |
| `./gradlew run`   | Executes the main class (if defined) |
| `./gradlew clean` | Cleans build artifacts |

## Code of Conduct

We strive to maintain a respectful and inclusive environment. Please adhere to common courtesy when interacting with contributors.

## Questions

If you have any questions, feel free to open a discussion or reach out to the repository owner.

Thank you for your contribution!
