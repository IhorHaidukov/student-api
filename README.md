# Student API

Student API is a backend REST API built with Java 17, Spring Boot, Spring Data JPA and PostgreSQL.

The application supports student CRUD operations, DTO mapping, request validation, exception handling, and database persistence.

## Technologies

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* REST API
* DTO / Mapper
* Exception Handling
* Lombok
* Validation
* Maven
* Git
* GitHub

## Features

* Create student
* Get all students
* Get student by ID
* Update student
* Delete student
* Count students
* DTO mapping between entities and API responses
* Request validation
* Custom exception handling

## API Endpoints

### Get all students

GET /students

### Get student by id

GET /students/{id}

### Create student

POST /students

### Update student

PUT /students/{id}

### Delete student

DELETE /students/{id}

### Count students

GET /students/count

## Project Structure

Controller → Service → Repository → PostgreSQL

## Author

Ihor Haidukov
