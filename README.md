# MoneyFlowControl

A Spring Boot application for financial management using MariaDB and Flyway for database migrations, fully containerized with Docker.

---

## Technologies

- Java 24
- Spring Boot 3.5.4
- MariaDB 11
- Flyway
- Docker / Docker Compose
- Maven

---

## Prerequisites

- [Java 24](https://www.oracle.com/java/technologies/javase/jdk24-archive-downloads.html) or higher
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

---

## Project Setup

1. **Clone the repository**

```bash
git clone https://github.com/LuizDaSilvaF/Money-Flow-Control.git
```
```bash
cd moneyflowcontrol
```
2. **Create .env file**

Create a .env file in the project root with the following variables:

```bash
# Database
MYSQL_ROOT_PASSWORD=your_root_password
MYSQL_DATABASE=moneyflow
MYSQL_USER=user
MYSQL_PASSWORD=your_password

# Spring Datasource
SPRING_DATASOURCE_URL=jdbc:mariadb://db:3306/moneyflow
SPRING_DATASOURCE_USERNAME=user
SPRING_DATASOURCE_PASSWORD=your_password

# Hibernate
SPRING_JPA_HIBERNATE_DDL_AUTO=none

# Flyway
SPRING_FLYWAY_ENABLED=true
```

---

## Build and Run
1. **Run with Docker Compose**

```bash
docker-compose up --build
```
This will:

* Build the Spring Boot application image
* Start the MariaDB container
* Start the application container on port 8082
---
Testing the Application
* Access: http://localhost:8082
