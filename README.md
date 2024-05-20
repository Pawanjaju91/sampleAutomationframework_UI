# TestNG Automation Framework

This repository contains a sample automation framework for UI testing using TestNG and Maven.

## Overview

The purpose of this automation framework is to provide a structure and set of tools for automating UI tests of web applications using Cucumber, TestNG and Maven. It includes basic setup, configuration, and sample test cases to demonstrate its usage.

## Features

- **TestNG Integration:** Utilizes TestNG as the testing framework for executing test cases. TestNG offers features like annotations, assertions, and test parameterization.
- **Maven Support:** The framework is built using Maven, allowing for easy project setup, dependency management, and test execution.
- **TestNG XML Configuration:** TestNG tests are executed using a `testng.xml` configuration file, providing flexibility in defining test suites and test parameters.
- **Cucumber :** To write feature file in Gherkin language and corresponding step definations file in Java.
- **Selenium :** Used for interacting with web elements and perform UI automation. 

## Getting Started

### Prerequisites

Before running the tests, ensure you have the following software installed on your system:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)

### Setup

1. Clone this repository to your local machine:

```bash
git clone <repository-url>

2.Navigate to the project directory:
cd <framework-folder>

**Running Tests**

To execute the sample TestNG tests, run the following Maven command:
mvn test

perform changes in Runnertest.java with the help of tags such as tags = "@scenario1", @scenario2 etc.
 
