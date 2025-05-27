# Project Structure in IntelliJ IDEA

When the project is opened in IntelliJ IDEA, you'll notice the following structure:

## `src/main/java`
This folder contains the main Java code for your application.  
- The main application class (e.g., `ExampleApplication.java`) is found here. It contains the `main` method, which is the entry point of your Spring Boot application.

## `src/main/resources`
This directory holds the configuration files and other resources, including:  
- **`application.properties`**: Used for application configuration.  
- **`static/` and `templates/`**: Directories for static web resources (like CSS or JavaScript files) and server-side template files (like Thymeleaf or Mustache), respectively.

## `src/test/java`
Contains the test classes for your application.

## `pom.xml`
The Maven build file where all project dependencies are listed. You can add more dependencies here if needed.