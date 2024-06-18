# Health Service API

This project is a Health Service API built with Spring Boot. It allows managing doctors and patients, and provides an endpoint to suggest doctors based on a patient's symptoms and location.

## Table of Contents

- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Setup and Running](#setup-and-running)
- [API Endpoints](#api-endpoints)
- [Swagger Documentation](#swagger-documentation)

## Project Structure

The project is organized into the following packages:

- `com.assignment.Lattice.Controller`: Contains the REST controllers for handling API requests.
- `com.assignment.Lattice.Model`: Contains the entity classes for Doctor and Patient.
- `com.assignment.Lattice.Repository`: Contains the JPA repository interfaces for Doctor and Patient.
- `com.assignment.Lattice.Service`: Contains the service interfaces and their implementations.
- `com.assignment.Lattice.config`: Contains the Swagger configuration class.

## Technologies Used

- Java 11
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (for testing purposes)
- Springdoc OpenAPI (for Swagger documentation)

## Setup and Running

1. **Clone the repository**:
   ```sh
   git clone <repository-url>
   cd health-service-api
### 2. Setup MySQL Database
Start your MySQL server.
Create a database named demo

```bash
CREATE DATABASE demo;
```
## 3. Update MySQL Credentials
Update the MySQL credentials in the src/main/resources/application.properties file.
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/demo
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```
Replace yourpassword with your MySQL root password.

## 4. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

The application will start running at http://localhost:8080.<br>
Swagger UI: http://localhost:8080/swagger-ui.html or http://localhost:8080/swagger-ui/
