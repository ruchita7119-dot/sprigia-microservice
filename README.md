# Microservices Backend System

A production-ready microservices application built with **Java 17** and **Spring Boot 3.4**, featuring centralized API Gateway, JWT authentication, and Feign client based inter-service communication.

## Architecture

```
Client Request
      ↓
API Gateway (Port 8080)
  → JWT Validation
  → Route to Service
      ↓
┌─────────────────┬─────────────────┬─────────────────┐
│  User Service   │ Product Service │  Order Service  │
│  (Port 8081)    │  (Port 8082)    │  (Port 8083)    │
└─────────────────┴─────────────────┴─────────────────┘
      ↓
   MySQL Database
```

## Services

| Service | Port | Responsibility |
|---------|------|----------------|
| api-gateway | 8080 | Centralized routing, JWT validation, request filtering |
| user-service | 8081 | User registration, login, JWT token generation |
| product-service | 8082 | Product CRUD operations |
| order-service | 8083 | Order placement, fetches user & product data via Feign |

## Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot 3.4, Spring Cloud Gateway 2024.0.0
- **Security:** JWT, Spring Security, OAuth2 Resource Server
- **Communication:** Feign Client (inter-service REST calls)
- **Database:** MySQL, Hibernate/JPA
- **Build Tool:** Maven
- **Testing:** JUnit, Mockito

## Key Features

- **Centralized Auth** — All requests pass through API Gateway. No internal service is reachable without a valid JWT token
- **Role-Based Access Control** — Endpoints protected based on user roles
- **Inter-Service Communication** — Order service fetches real-time product and user data using Feign clients without exposing internal APIs
- **Global Exception Handling** — Consistent error responses across all services
- **Input Validation & Logging** — Applied across all services for reliability

## How to Run

### Prerequisites
- Java 17+
- MySQL
- Maven

### Steps

1. Clone the repository
```
git clone https://github.com/ruchita7119-dot/sprigia-microservice.git
```
2. Create a MySQL database for each service
3. Update `application.properties` in each service with your DB credentials
4. Run services in this order
```
cd user-service && mvn spring-boot:run
cd product-service && mvn spring-boot:run
cd order-service && mvn spring-boot:run
cd api-gateway && mvn spring-boot:run
```

## API Flow Example

```
1. Register  →  POST  http://localhost:8080/auth/register
2. Login     →  POST  http://localhost:8080/auth/login       → returns JWT token
3. Products  →  GET   http://localhost:8080/products         → requires JWT header
4. Order     →  POST  http://localhost:8080/orders           → requires JWT header
```


## Author

**Ruchita Jerripotula**
[GitHub](https://github.com/ruchita7119-dot) | [LinkedIn](https://www.linkedin.com/in/ruchita-jerripotula-964a84211)
