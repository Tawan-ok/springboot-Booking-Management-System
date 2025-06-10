# Booking Management System

This project is a Spring Boot application that demonstrates a simple booking management backend.

## Prerequisites

- **Java 21**
- **Gradle** (the project includes the Gradle wrapper)
- **Docker** and **docker-compose** for running PostgreSQL

## Getting Started

1. **Start PostgreSQL using `docker-compose`**

   ```bash
   docker-compose up -d
   ```

   This starts a PostgreSQL instance configured with database `booking_db`,
   user `booking_user` and password `booking_pass`.

2. **Build the project**

   ```bash
   ./gradlew build
   ```

3. **Run the tests**

   ```bash
   ./gradlew test
   ```

4. **Run the application**

   ```bash
   ./gradlew bootRun
   ```

The service will start on `http://localhost:8080`.

## API Endpoints

- `POST /api/auth/register` – Register a new user
- `POST /api/auth/login` – Authenticate and obtain a JWT
- `GET /api/users/getAll` – Retrieve all users (requires authentication)

The application uses JWT-based authentication and secures all endpoints except those under `/api/auth/*`.
