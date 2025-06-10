# Booking Management System

This project is a Spring Boot application that demonstrates a simple booking management backend.

## Prerequisites

- **Java 21**
- **Gradle** (the project includes the Gradle wrapper)
- **Docker** and **docker-compose** for running PostgreSQL and Memcached

## Getting Started

1. **Start PostgreSQL and Memcached using `docker-compose`**

   ```bash
   docker-compose up -d
   ```

   This starts both PostgreSQL and a Memcached instance configured with
   database `booking_db`, user `booking_user` and password `booking_pass`.

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

### Caching with Memcached

The application checks Memcached before querying the database for user lists.
The default configuration expects a Memcached server running on `localhost:11211`
(automatically started via `docker-compose`).

## API Endpoints

- `POST /api/auth/register` – Register a new user
- `POST /api/auth/login` – Authenticate and obtain a JWT
- `GET /api/users/getAll` – Retrieve all users (requires authentication)

The application uses JWT-based authentication and secures all endpoints except those under `/api/auth/*`.
