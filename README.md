# Selenium Test Automation Framework

A modern **UI Test Automation Framework** built with **Java, Selenium WebDriver, TestNG, Maven**, and **Allure Reports**.  
The project is designed with **Page Object Model (POM)** principles and fully integrated with **GitHub Actions CI**.

---

## 🚀 CI Status

![CI](https://github.com/YusufAkgun37/selenium-test-automation/actions/workflows/maven-test.yml/badge.svg)

---

## 📊 Test Reports (Allure)

![Allure](https://img.shields.io/badge/Allure-Report-orange)
- Allure **HTML reports** are generated automatically in CI
- Reports are uploaded as **GitHub Actions artifacts**
- Failed tests include **automatic screenshot attachments** 📸

**How to view report:**
1. Open **GitHub → Actions**
2. Select a workflow run
3. Download **allure-report** artifact
4. Open `index.html`

---

## 🧠 Key Features

- ✅ Selenium WebDriver (Headless Chrome)
- ✅ TestNG test management
- ✅ Page Object Model (POM)
- ✅ Allure HTML Reporting
- ✅ Screenshot on test failure (Allure attachment)
- ✅ GitHub Actions CI integration
- ✅ Clean & scalable project structure

---

## 🛠 Technologies Used

- Java 17
- Selenium WebDriver 4
- TestNG
- Maven
- Allure TestNG
- GitHub Actions

---

## 📁 Project Structure

```
selenium-test-automation
├── .github/workflows
│ └── maven-test.yml
├── src
│ └── test
│ ├── java
│ │ ├── base
│ │ │ └── BaseTest.java
│ │ ├── listeners
│ │ │ └── TestListener.java
│ │ ├── pages
│ │ │ ├── LoginPage.java
│ │ │ └── GooglePage.java
│ │ ├── tests
│ │ │ ├── smoke
│ │ │ │ └── SmokeTest.java
│ │ │ └── regression
│ │ │ └── LoginTest.java
│ │ └── utils
│ │ ├── JsonDataReader.java
│ │ └── TestDataProvider.java
│ └── resources
│ └── testdata
│ └── loginData.json
├── testng.xml
├── pom.xml
└── README.md
```

---

## 🧪 Test Suites

### 🔥 Smoke Tests
- Application availability check

### 🔁 Regression Tests
- Successful login
- Invalid login
- Logout functionality

---

## 🧩 Framework Design

- Page Object Model (POM)
- Centralized WebDriver lifecycle (BaseTest)
- Listener-based failure handling
- Screenshot capture on test failure
- CI-friendly headless execution

---

## ▶️ How to Run Tests Locally

### Run all tests
```bash
mvn clean test
```

### Run using TestNG suite
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Generate Allure report locally
```bash
mvn allure:report
mvn allure:serve
```

---

## 🔄 Continuous Integration (CI)

- Triggered on:
  - Push to `main`
  - Pull Request to `main`
- Runs tests in **Ubuntu + Headless Chrome**
- Generates Allure report
- Uploads report as workflow artifact

---

## 📸 Allure Screenshot Example

- Screenshots are automatically attached for **failed tests**
- Visible under **Attachments → Screenshot Failure** in Allure

---

## 🎯 Why This Project?

This project demonstrates:
- Real-world Selenium framework design
- CI/CD automation knowledge
- Reporting & debugging best practices
- Recruiter-friendly, production-style setup

Perfect for **QA Automation / SDET portfolios** 💼

---

## 👤 Author

**Yusuf Akgün**  
🔗 GitHub: https://github.com/YusufAkgun37
