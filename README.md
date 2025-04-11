# Demo Automation Framework

This is a Selenium TestNG-based automation framework for UI testing. It is designed with modularity and scalability in mind, using the Page Object Model (POM) and standard Java best practices.

## 📁 Project Structure

```
demoFramework-master/
│
├── pom.xml                     # Maven project file with dependencies
├── testng.xml                  # TestNG suite configuration
├── src/
│   ├── main/java/
│   │   ├── pages/              # Page Object classes
│   │   ├── runners/            # Test runner classes
│   │   ├── steps/              # Step definitions for actions
│   │   └── utilities/          # Utility/helper classes
└── .idea/                      # IntelliJ project settings
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
