# Hands-on 1: Spring Web Project using Maven

## Project Overview

This is a Spring Boot Web Application created using Spring Initializr and Maven.

**Project Details:**
- **Group ID:** com.cognizant
- **Artifact ID:** spring-learn
- **Version:** 0.0.1-SNAPSHOT
- **Spring Boot Version:** 3.2.3
- **Java Version:** 17

---

## Project Structure

```
spring-learn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cognizant/
│   │   │       └── SpringLearnApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── date-format.xml
│   └── test/
│       └── java/
│           └── com/cognizant/
│               └── SpringLearnApplicationTests.java
├── target/                          (Generated after build)
├── pom.xml
├── mvnw                            (Maven Wrapper for Unix/Linux)
├── mvnw.cmd                        (Maven Wrapper for Windows)
├── .gitignore
└── README.md
```

---

## Folder Descriptions

### **src/main/java**
- **Purpose:** Contains all application source code
- **Package Structure:** `com.cognizant` (based on Group ID)
- **Contents:** Java classes for business logic, controllers, services, etc.

**Example:**
```java
src/main/java/com/cognizant/SpringLearnApplication.java
```

---

### **src/main/resources**
- **Purpose:** Contains application configuration files and static resources
- **Contents:**
  - `application.properties` - Application configuration
  - `date-format.xml` - Spring XML Configuration
  - `static/` folder - Static files (HTML, CSS, JavaScript, images)
  - `templates/` folder - Thymeleaf templates (for web pages)

**Key Configuration in application.properties:**
```properties
server.port=8080
spring.application.name=spring-learn
logging.level.root=INFO
```

---

### **src/test/java**
- **Purpose:** Contains all test code (Unit tests, Integration tests)
- **Package Structure:** Mirrors the main package structure
- **Testing Frameworks:** JUnit 5, Spring Boot Test, Mockito (when needed)

**Example:**
```java
src/test/java/com/cognizant/SpringLearnApplicationTests.java
```

---

## Understanding SpringLearnApplication.java

### **Main Class Breakdown:**

```java
package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
        System.out.println("========== Spring Learn Application Starting ==========");
        System.out.println("[INFO] Initializing Spring Boot Application Context...");
        System.out.println("[INFO] Loading Configuration from application.properties...");
        
        SpringApplication.run(SpringLearnApplication.class, args);
        
        System.out.println("========== Spring Learn Application Started Successfully ==========");
        System.out.println("[INFO] Application is ready to serve requests on port 8080");
        System.out.println("[INFO] Access the application at: http://localhost:8080");
    }
}
```

### **Key Components:**

#### **1. Package Declaration**
```java
package com.cognizant;
```
- Declares the package name based on the Group ID
- Follows Java naming conventions

#### **2. Imports**
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
```
- `SpringApplication` - Handles Spring Boot application startup
- `@SpringBootApplication` - Meta-annotation for application setup

#### **3. @SpringBootApplication Annotation**
```java
@SpringBootApplication
public class SpringLearnApplication {
```

**What it does:**
- Combines three annotations into one:
  - `@Configuration` - Marks class as a configuration source
  - `@EnableAutoConfiguration` - Auto-configures Spring based on classpath
  - `@ComponentScan` - Scans for Spring components (@Component, @Service, @Controller, @Repository)

**Benefits:**
- Reduces boilerplate code
- Enables Spring Boot auto-configuration
- Automatically detects and registers beans
- Configures embedded Tomcat server

#### **4. Main Method**
```java
public static void main(String[] args) {
    System.out.println("========== Spring Learn Application Starting ==========");
    System.out.println("[INFO] Initializing Spring Boot Application Context...");
    System.out.println("[INFO] Loading Configuration from application.properties...");
    
    SpringApplication.run(SpringLearnApplication.class, args);
    
    System.out.println("========== Spring Learn Application Started Successfully ==========");
    System.out.println("[INFO] Application is ready to serve requests on port 8080");
    System.out.println("[INFO] Access the application at: http://localhost:8080");
}
```

**Execution Flow:**
1. **Print startup message** - Logs that application is starting
2. **System.out.println() calls** - Display informational messages
3. **SpringApplication.run()** - Bootstraps the Spring application:
   - Creates ApplicationContext
   - Scans for components
   - Loads configuration
   - Starts embedded Tomcat server
4. **Print success message** - Indicates application started successfully

---

## Understanding pom.xml

### **What is pom.xml?**
- **POM = Project Object Model**
- **Purpose:** Maven configuration file for:
  - Project metadata
  - Dependency management
  - Build configuration
  - Plugin management
- **Format:** XML

### **Key Sections:**

#### **1. Parent POM**
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.3</version>
</parent>
```
- Inherits configurations from Spring Boot parent POM
- Provides default dependency versions
- Configures Maven plugins

#### **2. Project Metadata**
```xml
<groupId>com.cognizant</groupId>
<artifactId>spring-learn</artifactId>
<version>0.0.1-SNAPSHOT</version>
```

#### **3. Dependencies**
- Spring Boot Web Starter
- Spring Boot DevTools
- Spring Boot Test Starter

#### **4. Build Plugins**
- Spring Boot Maven Plugin

---

## Running the Application

### **Method 1: Eclipse**
1. Right-click on `SpringLearnApplication.java`
2. Select: **Run As** → **Java Application**
3. Application starts and logs appear in console

### **Method 2: Maven**
```bash
mvn spring-boot:run
```

### **Method 3: JAR File**
```bash
java -jar target/spring-learn-0.0.1-SNAPSHOT.jar
```

---

## Key Takeaways

✅ **Spring Boot simplifies Spring application setup**
✅ **@SpringBootApplication enables auto-configuration**
✅ **pom.xml manages dependencies and build configuration**
✅ **Maven handles compilation, testing, and packaging**
✅ **Embedded Tomcat requires no separate server installation**
✅ **Spring Boot DevTools enables hot reload for fast development**

---

## Next Steps

1. ✅ Understand project structure
2. ✅ Learn about Spring Boot application class
3. ✅ Review pom.xml configuration
4. ✅ Run the application successfully
5. ⏭️ Learn Spring XML Configuration (Hands-on 2)
6. ⏭️ Create REST Controllers
7. ⏭️ Work with databases and JPA

---

**Congratulations! You've successfully set up your first Spring Boot Web Project!** 🎉
