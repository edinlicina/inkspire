# Inkspire

Inkspire is a small **Java / Spring Boot backend** I built as the foundation for a manga / manhwa / manhua reader.  
It exposes a REST API to manage **novels** and their **chapters**, backed by a PostgreSQL database and documented via Swagger / OpenAPI.

---

## ✨ Features

- 📖 Manage **novels**
  - Create, list, update, delete novels
  - Store title and description
- 📑 Manage **chapters**
  - Create chapters for a novel
  - Store chapter title, chapter number and content (e.g. text or serialized data for images)
- 🗄️ **PostgreSQL** persistence (via Spring Data JPA)
- 🐳 **Docker** setup for the database
- 📚 **Swagger** API documentation
- 🧱 Clean separation into controllers, services, repositories, entities, and DTOs

---

## 🛠 Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot 3
- **Build Tool:** Gradle
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA (Hibernate)
- **Docs:** Swagger / OpenAPI (springdoc + springfox)
- **Others:** Lombok, JUnit
