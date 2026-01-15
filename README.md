# Selenium Test Automation Framework

A robust, scalable, and enterprise-grade **UI Test Automation Framework** built with **Java, Selenium WebDriver, TestNG, Maven**, and **Allure Reports**.
This project demonstrates modern test automation patterns suitable for large-scale applications, including **Dockerized Execution**, **Parallel Testing**, and **CI/CD Integration**.

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange" alt="Java">
  <img src="https://img.shields.io/badge/Selenium-4-green" alt="Selenium">
  <img src="https://img.shields.io/badge/Docker-Enabled-blue" alt="Docker">
  <img src="https://github.com/YusufAkgun37/selenium-test-automation/actions/workflows/maven-test.yml/badge.svg" alt="CI Status">
</p>

---

## � Key Features

*   **Design Pattern:** Page Object Model (POM) for efficient maintenance.
*   **Parallel Execution:** Thread-safe execution using `ThreadLocal<WebDriver>`, allowing multiple tests to run simultaneously.
*   **Docker Support:** Fully containerized environment using `Docker` and `Selenium Grid`.
*   **Cross-Browser Testing:** Configurable support for Chrome, Firefox, and Headless modes via properties.
*   **Reporting:** Integrated **Allure Reports** for detailed visualizations and historical trend analysis.
*   **CI/CD:** Automated pipeline via **GitHub Actions** running on every push/PR.
*   **Configuration Management:** Centralized control via `config.properties`.

---

## 🛠 Technology Stack

*   **Language:** Java 17
*   **Core Library:** Selenium WebDriver 4
*   **Test Runner:** TestNG
*   **Build Tool:** Maven
*   **Containerization:** Docker & Docker Compose
*   **Reporting:** Allure
*   **CI/CD:** GitHub Actions

---

## 📁 Project Structure

```
selenium-test-automation
├── .github/workflows   # CI/CD pipelines
├── src/test/java
│   ├── base            # BaseTest with ThreadLocal Driver
│   ├── pages           # Page Object Classes
│   ├── tests           # Test Classes (Smoke/Regression)
│   └── utils           # Utilities (DriverFactory, ConfigReader)
├── src/test/resources  # Configuration & Test Data
├── docker-compose.yml  # Selenium Grid Setup
├── Dockerfile          # Test Runner Container
└── pom.xml             # Dependencies
```

---

## ⚙️ Configuration

The project is controlled by `src/test/resources/config.properties`. You can easily switch environments or browsers without touching code.

```properties
browser=chrome
headless=false
url=https://the-internet.herokuapp.com/login
# Grid Configuration
executor=local       # 'local' or 'grid'
grid_url=http://localhost:4444
```

---

## ▶️ How to Run Tests

### 1. Local Execution
Run tests on your local machine using Maven:
```bash
mvn clean test
```
*Note: This will use the browser installed on your machine.*

### 2. Parallel Execution
Tests are configured to run in parallel (method level) by default in `testng.xml`.
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### 3. Docker (Selenium Grid) Execution 🐳
Run the entire suite in isolated Docker containers:

1.  Start the Grid and Test Runner:
    ```bash
    docker-compose up --build
    ```
2.  Watch the execution on the **Selenium Grid Dashboard**: `http://localhost:4444`
3.  Once finished, stop the containers:
    ```bash
    docker-compose down
    ```

### 4. Generate Report
View the Allure report locally after execution:
```bash
mvn allure:serve
```

---

## � CI/CD Pipeline

Every commit to `main` triggers a GitHub Actions workflow that:
1.  Sets up a Linux environment.
2.  Installs dependencies.
3.  Runs the full regression suite in Headless Chrome.
4.  Generates and uploads the Allure Report artifact.

---

## 👤 Author

**Yusuf Akgün**
*   🔗 [GitHub Profile](https://github.com/YusufAkgun37)
*   💼 [LinkedIn](https://www.linkedin.com/in/yusuf-akgun-37)

---
*This project is part of my portfolio demonstrating advanced test automation capabilities.*
