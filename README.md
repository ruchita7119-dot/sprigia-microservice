# Microservices Project

A Spring Boot microservices application with API Gateway and JWT authentication.

## Services
- **api-gateway** - Spring Cloud Gateway with JWT authentication
- **user-service** - User registration and login
- **product-service** - Product management
- **order-service** - Order processing with Feign client communication

## Tech Stack
Java, Spring Boot, Spring Cloud Gateway, JWT, MySQL, REST APIs, Maven

## Architecture
All requests go through API Gateway → JWT validated → routed to respective service
