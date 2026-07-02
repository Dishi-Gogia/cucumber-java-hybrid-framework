# Enterprise Selenium Cucumber Hybrid Automation Framework

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen)
![JUnit](https://img.shields.io/badge/JUnit-5-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Log4j2](https://img.shields.io/badge/Log4j2-Logging-yellowgreen)
![Extent Reports](https://img.shields.io/badge/Extent-Reports-purple)
![License](https://img.shields.io/badge/License-MIT-blue)

---

## Overview

This project is an **Enterprise Selenium Cucumber Hybrid Automation Framework** developed using **Java, Selenium WebDriver, Cucumber, JUnit, Maven, and the Page Object Model (POM)**.

The framework is designed to be **scalable, reusable and maintainable**, following industry best practices for UI test automation.

The application under test is **Automation Exercise**.

---

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Selenium WebDriver | Web UI Automation |
| Cucumber | Behaviour Driven Development (BDD) |
| JUnit | Test Execution |
| Maven | Build & Dependency Management |
| Log4j2 | Logging |
| Extent Reports | HTML Reporting |
| Git & GitHub | Version Control |

---

# Framework Architecture

```
                 Feature Files
                       │
                       ▼
               Step Definitions
                       │
                       ▼
                    Hooks
                       │
                       ▼
                 Page Objects
                       │
                       ▼
                  WebActions
                       │
                       ▼
              Selenium WebDriver
                       │
                       ▼
              Automation Exercise
```

---

## Project Structure

```
src
└── test
    ├── java
    │   ├── base
    │   ├── hooks
    │   ├── pages
    │   ├── reports
    │   ├── runner
    │   ├── stepdefinitions
    │   └── utilities
    │
    └── resources
        ├── features
        ├── config.properties
        └── log4j2.xml
```

---

## Framework Design

The framework follows a layered architecture to promote maintainability and code reuse.

### Base Layer

- BaseTest
- BasePage

### Page Layer

- HomePage
- LoginPage
- SignupPage
- ProductsPage
- CartPage

### Utilities

- EnvironemntUtils
- WaitUtils
- TestDataReader
- ScreenshotUtils
- LoggerUtils
- ConfigReader

### Reports

- Extent Reports
- Cucumber Reports

---

## Design Patterns Used

- Page Object Model (POM)
- Base Page Design
- Singleton Pattern (Extent Reports)
- Utility Class Pattern
- ThreadLocal (Extent Report Management)

---

# Features Implemented

## Authentication

- User Registration
- User Login
- Logout
- Delete Account

## Products

- Search Product
- View Product Details
- Add Product to Cart

## Cart

- View Cart
- Remove Product
- Verify Empty Cart

---

# Framework Features

- Behaviour Driven Development (BDD)
- Page Object Model (POM)
- Reusable WebActions Utility
- Centralized Configuration Management
- Explicit Wait Utilities
- Log4j2 Logging
- Extent Reports
- Cucumber HTML Reports
- JSON Reports
- XML Reports
- Automatic Screenshot Capture on Failure
- Reusable Hooks for Test Setup & Cleanup
- Maven Build Support
- Modular Framework Design

---

# Reporting

The framework generates the following reports:

- Extent HTML Report
- Cucumber HTML Report
- Cucumber JSON Report
- Cucumber XML Report

Screenshots are automatically captured and attached whenever a scenario fails.

---

# Logging

Log4j2 is integrated throughout the framework.

Logs are generated for:

- Framework Initialization
- Browser Launch
- Application Navigation
- Page Actions
- Test Data Reading
- Assertions
- Screenshot Capture
- Test Completion

---

# How to Execute

## Clone Repository

```bash
git clone https://github.com/Dishi-Gogia/cucumber-java-hybrid-framework.git
```

## Navigate to Project

```bash
cd cucumber-java-hybrid-framework
```

## Install Dependencies

```bash
mvn clean install
```

## Execute Tests

```bash
mvn clean test
```

or execute:

```
src/test/java/runner/TestRunner.java
```

directly from your IDE.

---

# Reports Generated

```
target
│
├── cucumber-reports
│      ├── CucumberReport.html
│      ├── CucumberReport.json
│      └── CucumberReport.xml
│
├── extent-reports
│      └── ExtentReport.html
│
└── screenshots
```

---

# Future Enhancements

- Parallel Execution
- Cross Browser Execution
- Selenium Grid Integration
- Docker Integration
- GitHub Actions CI/CD
- Jenkins Pipeline
- BrowserStack Integration
- Allure Reports
- REST Assured API Framework Integration

---

# Author

**Dishi Gogia**

Senior QA Automation Engineer

**GitHub**

https://github.com/Dishi-Gogia

**LinkedIn**

 https://www.linkedin.com/in/dishi-gogia

---

## If you found this project useful, consider giving it a ⭐ on GitHub.
