# Digital Nurture 5.0 - Deep Skilling (Java FSE React)

Welcome to my repository for the **Cognizant Digital Nurture 5.0 Deep Skilling** program. This repository contains all the hands-on exercises, microservices projects, and front-end applications developed during the 7-week learning journey focused on Java Full Stack Engineering (FSE) with React.

## Program Highlights
The Deep Skilling learning program covers four major engineering constructs:
1. **Engineering Concepts**: Design Patterns, Data Structures & Algorithms.
2. **Programming Languages**: Java, PL/SQL, TDD (JUnit5, Mockito), SLF4J.
3. **Products and Frameworks**: Spring Core, Spring Data JPA, Hibernate, Spring REST, Microservices (Spring Boot 3, Spring Cloud), React.
4. **Platforms & GenAI**: GIT, CI/CD, Docker, Cloud Fundamentals, GenAI (GitHub Copilot).

---

## Repository Structure

The repository is organized week-wise to map the learning modules and hands-on exercises:

### 📁 Week-1: Core Engineering Concepts & Programming
*Contains Exercises 01 to 12*
- **Design Patterns and Principles**: SOLID principles, Creational, Structural, and Behavioral patterns.
- **Data Structures & Algorithms**: Searching, sorting, arrays, and linked lists.
- **PL/SQL Programming**: Database application development using PL/SQL constructs.
- **TDD & Logging**: Test-Driven Development with JUnit5 & Mockito, SLF4J logging framework integration.

### 📁 Week-2: Spring Core, Maven & Spring Data JPA
*Contains Exercises 13 to 17*
- **Spring Core & Maven**: Dependency Injection, IoC Container, Bean Configuration, and Maven build tool.
- **Spring Data JPA & Hibernate**: Entity mapping, repositories, CRUD operations, query methods, pagination, and sorting.

### 📁 Week-3: Spring REST & Code Quality
- **Spring REST with Spring Boot 3**: Building RESTful APIs, handling HTTP methods, DTOs, content negotiation, Exception handling, and Spring Security.
- **Code Quality**: SonarQube integration, static code analysis, and interpreting quality gates.

### 📁 Week-4: Microservices
- **Account & Loan Microservices**: Implementation of independent, loosely coupled Spring Boot RESTful web services. 
- Explored running multiple services concurrently on different embedded server ports (e.g., 8080 and 8081).
- Concepts covered: Service Discovery (Eureka), API Gateway, Fault Tolerance, and Spring Cloud Config.

### 📁 Week-5: React SPA & Debugging
- **ReactJS**: Built various Single Page Applications (SPAs).
- Explored React components (functional & class), state, props, hooks, event handling, routing, and interacting with APIs (Fetch/Axios).
- **Application Debugging**: Debugging frontend applications using Chrome DevTools.

---

## Getting Started

### Prerequisites
- **Java Development Kit (JDK) 17+**
- **Maven** for building backend projects
- **Node.js and npm** for running React applications
- **MySQL / PostgreSQL** (as configured in application.properties)
- An IDE such as **IntelliJ IDEA**, **Eclipse**, or **VS Code**

### Running the Backend Services
1. Navigate to the specific week and project folder (e.g., `cd Week-4/account`).
2. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

### Running the Frontend Applications
1. Navigate to the React project folder (e.g., `cd Week-5/myfirstreact`).
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the application:
   ```bash
   npm start
   ```

---

## Certification & Assessment
The completion of these exercises is part of the preparation for the **Final Knowledge-Based Assessment (KBA)** in the Digital Nurture 5.0 program, validating a comprehensive understanding of Java Full Stack development.
