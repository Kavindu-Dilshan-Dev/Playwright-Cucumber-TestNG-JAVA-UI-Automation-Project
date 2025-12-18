# Playwright Java Cucumber TestNG\ Project

## Description
A test automation project using Playwright (Java) for browser automation, Cucumber for BDD, and TestNG as the test runner. Reports are generated using `net.masterthought.cucumber`.

## Tech Stack
- Java (JDK 11+)
- Maven
- Playwright for Java
- Cucumber JVM
- TestNG
- `net.masterthought.cucumber` report generator

## Prerequisites
- Java JDK installed (`java -version`)
- Maven installed (`mvn -v`)
- Node.js installed (required by Playwright)
- Browser drivers/install for Playwright: run Playwright install if needed

## Setup
1. Clone the repository:
   - `git clone <repo-url>`
2. Install project dependencies:
   - `mvn clean install`

If Playwright browsers are not installed:
- Run Playwright install according to the Playwright Java docs (or run a script included in the repo).

## Running Tests
- Run all tests:
  - `mvn test`
- To run a specific test or suite use TestNG/Maven flags as configured.

Ensure Cucumber JSON output is produced (example in your Cucumber runner):
- Add or confirm plugin: `plugin = {"json:target/cucumber.json"}`

## Generating HTML Reports
This project uses `net.masterthought.cucumber` and expects:
- JSON input: `target/cucumber.json`
- Output folder: `target/cucumber-reports`

You can generate the report by running the provided Java main class:
- From IDE: run `org.kavindu.reportsGenerator.CucumberReportGenerator`
- Or with Maven exec plugin:
  - `mvn org.codehaus.mojo:exec-maven-plugin:3.1.0:java -Dexec.mainClass="org.kavindu.reportsGenerator.CucumberReportGenerator"`

After success, open the files under:
- `target/cucumber-reports/`

## Project Structure (high level)
- `src/main/java/` \- application/report generator code (`org.kavindu.reportsGenerator`)
- `src/test/java/` \- test code (Cucumber step definitions, runners)
- `pom.xml` \- Maven build and dependencies
- `target/` \- build outputs (including `cucumber.json` and `cucumber-reports/`)

## Common Troubleshooting
- No `cucumber.json` created: ensure Cucumber runner includes `json:target/cucumber.json` plugin.
- Report generator fails: confirm `target/cucumber.json` exists and path matches.
- Playwright browser errors: ensure Node and Playwright dependencies/browsers are installed.

## CI / GitHub Actions (brief)
- Build: `mvn -B -DskipTests=false test`
- Persist `target/cucumber.json` as artifact and run report generator as a step to produce HTML report.

## Contributing
- Create feature branches, add tests, open PRs.
- Follow existing code style and update `README` when adding major features.

## License & Contact
- Add project license (e.g., `LICENSE` file)
- Contact: maintainers or repository owner
