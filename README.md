# FastKart Backend & Frontend

This repository contains a Spring Boot backend and a Next.js admin frontend.

## MySQL Configuration

The backend expects a running MySQL instance with the following settings (see
[`backend/src/main/resources/application.yml`](backend/src/main/resources/application.yml)):

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC
    username: root
    password: 1234
    driver-class-name: com.mysql.cj.jdbc.Driver
```

Ensure the `test` database exists or adjust the values to match your local
MySQL setup.

## Starting the Spring Boot Backend

```bash
cd backend
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

Ensure the `API_PROD_URL` environment variable points to the backend API
(`http://localhost:8080/api/`) when running the frontend.

## Running the Next.js Frontend

Before starting the frontend, set the `API_PROD_URL` environment variable to the
base URL of the backend. Then start the development server:

```bash
cd nextjs-fastkart-admin
export API_PROD_URL=http://localhost:8080/api/
npm install
npm run dev
```

On Windows use `set` instead of `export`:

```cmd
set API_PROD_URL=http://localhost:8080/api/
npm install
npm run dev
```

The Next.js application will be available at `http://localhost:3000`.
