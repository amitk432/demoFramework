# Demo Automation Framework

This is a Selenium TestNG-based automation framework for UI testing. It is designed with modularity and scalability in mind, using the Page Object Model (POM) and standard Java best practices.

## 📁 Project Structure

```
demoFramework-master/
│── src/
│   ├── main/java/utilities/       # Helper classes (WebDriverManager, reporting, etc.)
│   ├── main/java/pages/           # Page Object Model classes
│   ├── main/java/steps/           # Step Definitions for Cucumber
│   ├── main/java/runners/         # Test runners for executing scenarios
│   ├── test/resources/features/   # Cucumber feature files
│── test-output/                   # Test reports and logs
│── pom.xml                         # Maven dependencies and configurations

```

## 🚀 Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6+
- IntelliJ IDEA (recommended)
- Chrome or compatible browser for Selenium tests

### 🔧 Setup

1. Clone this repository or download the ZIP.
2. Navigate into the project directory:
   ```bash
   cd demoFramework-master
   ```
3. Install dependencies:
   ```bash
   mvn clean install
   ```

### 🧪 Running Tests

Run all tests defined in the `testng.xml` suite:

```bash
mvn test
```

You can also run individual test classes by modifying `testng.xml` or using the Maven Surefire plugin.

## 🛠 Technologies Used

- Java
- Maven
- Selenium WebDriver
- TestNG
- Page Object Model (POM) design pattern

## 📄 Notes

- Tests are currently configured to run in parallel by methods via `testng.xml`.
- Modify `Runner.java` under `runners` package to control execution logic.

---

Happy Testing! 🎉
