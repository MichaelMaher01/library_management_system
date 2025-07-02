
# 📚 Library Management System

A modern, secure **Library Management System** built with **Java**, **Spring Boot**, and **PostgreSQL**.  
Provides a robust **JWT-based REST API** for managing books, authors, users, and borrowing operations with **role-based access control**.

---

## ⚙️ Configuration

Edit `application.yml` to connect to your local PostgreSQL instance:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/
    username:
    password:
```

> ⚠️ Replace `url`, `username`, and `password` with your actual DB credentials.  
> 🧪 On startup, the app will auto-run `data.sql` to insert sample records.

---

## 🗂️ Project Structure

- `postman/` – Postman collection to test API endpoints  
- `edr/` – Entity-Relationship Diagram image of the database schema  

---

## 🔐 Authentication & Authorization

- Register a user via `POST /api/auth/register`
- Login using `POST /api/auth/login` to receive a JWT token
- Use this token with all secured routes:
  ```
  Authorization: Bearer <your_token>
  ```

---

## ✅ Key Features

- 🔐 **JWT Authentication**  
- 👥 **Role-Based Access** (`ADMIN`, `LIBRARIAN`, `STAFF`)  
- 📚 Book & Category Management  
- 👤 Member Management  
- 🔁 Borrow & Return Book Transactions  
- 📖 Borrowing History Tracking  
- 🛠 PostgreSQL Integration with initial `data.sql`  
- 📄 Well-structured and modular API design

---

## 🧾 Entity Overview

- **Books**: title, summary, language, ISBN, etc.  
- **Authors** & **Publishers**  
- **Categories**: hierarchical support  
- **Members**: library borrowers  
- **Users**: system accounts with roles  
- **BorrowingTransactions**: borrow/return log

🖼 View full diagram in `edr/` folder.

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- PostgreSQL

### 🧰 Setup Instructions

1. Create a PostgreSQL database and user
2. Configure `application.yml` as shown:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/library_db
    username: library_user
    password: library_pass
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
```

3. Build and run the project:

```bash
mvn clean install
java -jar target/library-management-system.jar
```

---

## 🧪 API Testing with Postman

1. Open Postman
2. Import the collection from `postman/`
3. Register a user → Login → Copy JWT token
4. Set Authorization header:
   ```
   Bearer <your_token>
   ```
5. Test all available endpoints based on your user role

---

## 🗺 ERD (Database Diagram)

Find the full database structure in `edr/` folder.  
It includes all entities and their relationships visually.

---
