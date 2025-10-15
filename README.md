# TMDB API Test Project

## Overview
This repository contains automated API tests for [The Movie Database (TMDB)](https://www.themoviedb.org/) service. The tests are written in Java using Spring Boot to bootstrap the testing context, Rest Assured for HTTP interactions, and TestNG as the test runner. Assertions rely on AssertJ and domain-specific helpers, while reporting is powered by Allure.

The root project currently consists of a single Gradle module:

- **`api-tests`** – houses the TestNG suites, HTTP controllers/facades for exercising TMDB endpoints, request/response models, data builders, and Allure configuration.

## Prerequisites
- **Java 17 or later** – Spring Boot 3.4.x requires at least Java 17.
- **Gradle Wrapper** – included; no standalone Gradle installation is necessary.
- **TMDB API credentials** – an API Read Access Token (v4) and the numeric account ID tied to the token.

You will need network access to TMDB's public API when executing the suites.

## Configuring Secrets
Tests read credentials from the following environment variables:

- `API_TOKEN` – TMDB API Read Access Token (v3).
- `API_ACCOUNT_ID` – TMDB account ID associated with the token.

You can provide these values in one of two ways:

1. **Environment variables** (useful in CI):
   ```bash
   export API_TOKEN="<your_token>"
   export API_ACCOUNT_ID="<your_account_id>"
   ```
2. **Local secrets file** (convenient for local runs). Create a file named `local.secrets.properties` in the project root with the following content:
   ```properties
   API_TOKEN=<your_token>
   API_ACCOUNT_ID=<your_account_id>
   ```
   The Gradle build automatically loads this file and forwards the values to the TestNG execution environment.

## Running the Test Suites
Execute all tests with the Gradle wrapper:

```bash
./gradlew clean test
```

By default the suite definition at `api-tests/src/test/resources/testng.xml` is used. To run a different TestNG suite file, pass the `suite` system property:

```bash
./gradlew test -Dsuite=src/test/resources/another-suite.xml
```

### Allure Reporting
Allure results are produced in `api-tests/build/allure-results` after a test run. To generate and open the HTML report:

```bash
./gradlew allureReport
./gradlew allureServe
```

`allureServe` launches a local server hosting the report; stop it with <kbd>Ctrl</kbd>+<kbd>C</kbd> when finished.

## Static Analysis
PMD is enabled for all modules with rules defined in `config/pmd/pmd-ruleset.xml`. To execute PMD analysis explicitly run:

```bash
./gradlew pmdMain pmdTest
```

## Project Structure Highlights
```
api-tests/
├── src/main/java/org/themoviedb/       # Controllers, facades, DTOs, mappers, and configuration
├── src/test/java/org/themoviedb/       # TestNG-based API test classes
└── src/test/resources/testng.xml       # Default TestNG suite definition
```

Domain-specific helpers under `facades`, `controllers`, and `steps` encapsulate API calls, while the `assertions` package contains reusable verifications for TMDB responses.

## Troubleshooting
- When running in CI, confirm that `API_TOKEN` and `API_ACCOUNT_ID` are injected as environment variables for the `test` task.

## Useful Gradle Commands
- `./gradlew test` – run TestNG suites.
- `./gradlew allureReport` – build an Allure HTML report.
- `./gradlew pmdTest` – execute PMD rules against test sources.

For additional TMDB API documentation visit the [TMDB developer portal](https://developer.themoviedb.org/reference/intro/getting-started).