# Hands-on 2: Spring Core – Load SimpleDateFormat from Spring Configuration XML

## Overview

This hands-on exercise demonstrates **Spring XML Configuration** and how to use it to create and manage beans. Specifically, we'll load a `SimpleDateFormat` bean from an XML configuration file instead of creating it in multiple places in the application.

## Problem Statement

**Issue:** SimpleDateFormat with the pattern 'dd/MM/yyyy' is created in multiple places of an application.

**Solution:** Define a bean in Spring XML Configuration file and retrieve the date format from Spring's ApplicationContext.

---

## Learning Objectives

✅ Understand Spring XML Configuration
✅ Learn about Bean definition and instantiation
✅ Understand Constructor Injection in Spring
✅ Learn how to create ApplicationContext from XML
✅ Learn how to retrieve beans using getBean()
✅ Avoid code duplication by centralizing configuration

---

## Project Structure

```
Week-3/
├── HANDS-ON-1/
│   ├── src/main/java/com/cognizant/SpringLearnApplication.java
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   └── date-format.xml
│   ├── src/test/java/com/cognizant/SpringLearnApplicationTests.java
│   ├── pom.xml
│   ├── README.md
│   └── .gitignore
└── HANDS-ON-2/
    ├── src/main/java/com/cognizant/SpringLearnApplication.java      (Updated with displayDate() method)
    ├── src/main/resources/
    │   └── date-format.xml                                         (Spring XML Configuration)
    └── HANDS-ON-2-DOCUMENTATION.md
```

---

## Files Created/Modified

### **1. date-format.xml** (NEW)

Location: `src/main/resources/date-format.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- SimpleDateFormat Bean Configuration -->
    <bean id="dateFormat" class="java.text.SimpleDateFormat">
        <constructor-arg value="dd/MM/yyyy" />
    </bean>

</beans>
```

#### **XML Structure Breakdown:**

```xml
<?xml version="1.0" encoding="UTF-8"?>
```
- XML declaration specifying version and character encoding

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
```
- Root element: `<beans>` - Container for all bean definitions
- `xmlns` - XML namespace for Spring beans
- `xsi:schemaLocation` - Points to the Spring beans schema definition

```xml
<bean id="dateFormat" class="java.text.SimpleDateFormat">
    <constructor-arg value="dd/MM/yyyy" />
</bean>
```
- **`<bean>`** - Defines a single bean instance
  - `id="dateFormat"` - Unique identifier for the bean
  - `class="java.text.SimpleDateFormat"` - Fully qualified class name
- **`<constructor-arg>`** - Constructor parameter injection
  - `value="dd/MM/yyyy"` - Value passed to SimpleDateFormat constructor

---

### **2. SpringLearnApplication.java** (MODIFIED)

Location: `src/main/java/com/cognizant/SpringLearnApplication.java`

#### **Key Changes:**

1. **Added imports for Spring XML Configuration:**
   ```java
   import org.springframework.context.ApplicationContext;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   ```

2. **Added displayDate() method:**
   ```java
   public static void displayDate() {
       // Spring XML Configuration implementation
   }
   ```

3. **Called displayDate() in main():**
   ```java
   displayDate();
   ```

#### **displayDate() Method - Implementation Details**

**Step 1: Load XML Configuration**
```java
ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
```
- Creates ApplicationContext from XML file
- Loads all beans defined in the XML

**Step 2: Retrieve Bean**
```java
SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
```
- Gets bean by ID "dateFormat"
- Returns SimpleDateFormat instance

**Step 3: Parse Date String**
```java
Date parsedDate = format.parse("31/12/2018");
```
- Uses the Spring bean to parse date
- Pattern: dd/MM/yyyy

**Step 4: Display Result**
```java
System.out.println(format.format(parsedDate));
```
- Outputs: 31/12/2018

---

## Expected Console Output

```
========== Spring Learn Application Starting ==========
[INFO] Initializing Spring Boot Application Context...
[INFO] Loading Configuration from application.properties...

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.3)

[INFO] Application is ready to serve requests on port 8080
[INFO] Access the application at: http://localhost:8080

========== Hands-on 2: Spring Core - XML Configuration ==========

[STEP 1] Creating ApplicationContext from 'date-format.xml'...
[SUCCESS] ApplicationContext created successfully!

[STEP 2] Retrieving 'dateFormat' bean from ApplicationContext...
[SUCCESS] Bean retrieved successfully!
[INFO] Bean class: java.text.SimpleDateFormat
[INFO] Date format pattern: dd/MM/yyyy

[STEP 3] Parsing date string '31/12/2018' using the format...
[SUCCESS] Date parsed successfully!
[INPUT] Date string: 31/12/2018
[OUTPUT] Parsed Date object: Mon Dec 31 00:00:00 IST 2018
[OUTPUT] Formatted output: 31/12/2018

[STEP 4] Additional Date Operations...
[INFO] Current date formatted: 08/07/2024

[STEP 5] Closing ApplicationContext...
[SUCCESS] ApplicationContext closed successfully!

========== Hands-on 2 Completed ==========
```

---

## Key Concepts

### **1. Spring XML Configuration**
- Centralized bean definitions in XML
- Alternative to programmatic configuration
- Declarative approach to bean creation

### **2. Bean Definition**
- Bean ID: Unique identifier for retrieving the bean
- Bean Class: Fully qualified class name
- Constructor Arguments: Dependencies passed via constructor

### **3. Constructor Injection**
- Values injected through constructor parameters
- `<constructor-arg>` element
- Type-safe and explicit dependency declaration

### **4. ApplicationContext**
- Spring's central interface for bean management
- Holds all configured beans
- Responsible for bean lifecycle

### **5. getBean() Method**
- Retrieves beans from ApplicationContext by ID
- Supports type-safe retrieval with class parameter
- Throws exception if bean not found

---

## Benefits of Spring XML Configuration

| Benefit | Description |
|---------|-------------|
| **Centralized Configuration** | All bean definitions in one place |
| **DRY Principle** | Don't Repeat Yourself - define once, use everywhere |
| **Easy Maintenance** | Change configuration without modifying code |
| **Loose Coupling** | Components depend on abstractions, not concrete implementations |
| **Reusability** | Same bean used in multiple places |
| **Testability** | Easy to mock and test with Spring beans |
| **Configuration Management** | Separate configuration from business logic |

---

## Troubleshooting

### **Issue: Port 8080 already in use**
**Solution:** Change port in `application.properties`
```properties
server.port=8081
```

### **Issue: ClassPathXmlApplicationContext throws FileNotFoundException**
**Solution:** Ensure `date-format.xml` is in `src/main/resources` folder

### **Issue: Bean not found exception**
**Solution:** Verify bean ID in XML matches the ID in getBean() call

### **Issue: ParseException when parsing date**
**Solution:** Ensure date string format matches the pattern in XML (dd/MM/yyyy)

---

## Running the Application

### **Method 1: Eclipse**
1. Right-click on `SpringLearnApplication.java`
2. Select: **Run As** → **Java Application**
3. Observe console output

### **Method 2: Maven**
```bash
cd Week-3/HANDS-ON-2
mvn spring-boot:run
```

### **Method 3: Terminal**
```bash
mvn clean package
java -jar target/spring-learn-0.0.1-SNAPSHOT.jar
```

---

## Comparison: Without Spring vs With Spring

### **Without Spring (Traditional Approach)**
```java
// Creating SimpleDateFormat in multiple places
SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat format3 = new SimpleDateFormat("dd/MM/yyyy");
```

**Problems:**
- Code duplication
- Inconsistent format changes
- Hard to maintain
- Tight coupling

### **With Spring (Spring XML Configuration)**
```xml
<bean id="dateFormat" class="java.text.SimpleDateFormat">
    <constructor-arg value="dd/MM/yyyy" />
</bean>
```

**Benefits:**
- Single definition
- Easy to change format
- Loose coupling
- DRY principle
- Centralized configuration

---

## Next Steps

1. ✅ Understand Spring XML Configuration
2. ✅ Learn Bean Creation with Constructor Injection
3. ✅ Learn ApplicationContext and getBean()
4. ⏭️ Explore Setter Injection
5. ⏭️ Learn Annotation-based Configuration
6. ⏭️ Explore Java-based Configuration
7. ⏭️ Learn about Bean Lifecycle and Scopes

---

## Key Takeaways

✅ **Spring centralizes configuration** - Avoid code duplication
✅ **XML Configuration is declarative** - Easy to understand
✅ **Constructor Injection** - Explicit dependency declaration
✅ **ApplicationContext manages beans** - Central bean repository
✅ **DRY Principle** - Define once, reuse everywhere
✅ **Loose Coupling** - Components are independent
✅ **Easy Maintenance** - Change configuration without code changes

---

**Congratulations! You've successfully learned Spring XML Configuration and Dependency Injection!** 🎉
