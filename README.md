## 🚀 CI Status

![CI](https://github.com/YusufAkgun37/selenium-test-automation/actions/workflows/maven-test.yml/badge.svg)

## 📊 Test Reports

Allure HTML reports are generated automatically in CI and stored as workflow artifacts.



# Selenium Test Automation Framework

This project is a UI test automation framework built using Java, Selenium WebDriver, TestNG, and Maven.  
The framework follows the Page Object Model (POM) design pattern to ensure clean, maintainable, and scalable test automation.

---

## 🚀 Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- Git & GitHub

---

## 📁 Project Structure
selenium-test-automation
├── src
│ └── test
│ └── java
│ ├── base
│ │ └── BaseTest.java
│ ├── pages
│ │ └── LoginPage.java
│ └── tests
│ ├── SmokeTest.java
│ └── LoginTest.java
├── testng.xml
├── pom.xml
└── README.md

---

## 🧪 Test Scenarios

### Smoke Tests
- Verify application is accessible

### Regression Tests
- Successful login
- Invalid login with wrong credentials
- Logout functionality

---

## 🧩 Framework Design
- Page Object Model (POM)
- Explicit waits for stable test execution
- TestNG groups (smoke, regression)
- Centralized WebDriver management using BaseTest

---

## ▶️ How to Run Tests

### Run all tests
```bash
mvn test
```

### Run tests using TestNG suite
```bash
mvn test "-DsuiteXmlFile=testng.xml"
```

## 🔄 Continuous Integration (CI)

- Tests run automatically on:
- push to main
- pull request to main
- Implemented using GitHub Actions
- CI pipeline executes Maven tests in a headless Chrome environment

## 📌 Sample Scenarios

- Successful login
- Invalid login attempt
- Logout functionality
- Basic smoke test
