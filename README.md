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

### Run tests using TestNG suite
mvn test "-DsuiteXmlFile=testng.xml"

### Notes

Browser closes automatically after each test
Tests are suitable for CI/CD pipelines
