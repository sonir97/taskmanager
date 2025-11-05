💼 Project: Task Manager REST API

Tech Stack: Java, Spring Boot, JPA/Hibernate, H2/PostgreSQL, RESTful APIs, Maven

Description:
A REST API for managing user tasks — where each user can create, update, delete, and list their own tasks. Implemented clean architecture using layered design (Controller, Service, Repository) and leveraged Spring Boot annotations for dependency injection and data persistence.

Key Highlights:

Designed REST endpoints for managing task lifecycle (GET, POST, PUT, DELETE).

Used Spring Data JPA for ORM with entity relationships and UUID-based primary keys.

Implemented global exception handling and proper HTTP status responses using ResponseEntity.

Configured H2 in-memory database for development and easy testing.

(In progress) Adding authentication and user-specific task ownership with Spring Security & JWT.

Documented APIs with Swagger/OpenAPI for testing and integration.
