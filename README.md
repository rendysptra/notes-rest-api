# Notes API

Simple REST API for creating and reading notes. This project is built with
Spring Boot and uses Spring Data JPA to store `Note` data.

## Feature Status

- `POST /v1/notes` to create a note
- `GET /v1/notes` to retrieve all notes
- Title validation is required and limited to 255 characters
- Note IDs are generated as UUIDs
- Notes are sorted by creation time in ascending order

Update, delete, search, and bookmark operations are not available yet.

## Technology

- Java 26
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- H2 Database and H2 Console
- Spring Validation
- Maven Wrapper

## Prerequisites

- Java Development Kit (JDK) 26
- Maven does not need to be installed globally because the project provides a Maven Wrapper

Check the installed Java version:

```bash
java --version
```

## Running the Application

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
./mvnw.cmd spring-boot:run
```

The application runs at `http://localhost:8080`.

## API

### Create a Note

`POST /v1/notes`

Request body:

```json
{
	"title": "Learning Spring Boot",
	"content": "Learning about REST APIs and JPA",
	"url": "https://spring.io"
}
```

Example using `curl`:

```bash
curl -X POST http://localhost:8080/v1/notes \
	-H "Content-Type: application/json" \
	-d '{"title":"Learning Spring Boot","content":"Learning about REST APIs and JPA","url":"https://spring.io"}'
```

Successful responses use the `201 Created` status and include `id`, `title`,
`content`, `url`, `created`, and `updated`.

`title` must be a non-blank string between 1 and 255 characters. `content` and
`url` are optional.

### Retrieve All Notes

`GET /v1/notes`

```bash
curl http://localhost:8080/v1/notes
```

Successful responses use the `200 OK` status and return an array of notes
sorted by creation time in ascending order.

## Running Tests

Linux/macOS:

```bash
./mvnw test
```

Windows:

```powershell
./mvnw.cmd test
```

The project currently includes a smoke test to verify that the application
context can be loaded.

## Building the JAR File

```bash
./mvnw clean package
java -jar target/notes-0.0.1-SNAPSHOT.jar
```

## Project Structure

```text
src/
├── main/
│   ├── java/com/rendysaptra/notes/
│   │   ├── controller/       # REST endpoints
│   │   ├── domain/           # Requests, DTOs, and Note entity
│   │   ├── mapper/           # Domain object and DTO mapping
│   │   ├── repository/       # Spring Data JPA data access
│   │   ├── service/          # Application logic
│   │   └── NotesApplication.java
│   └── resources/
│       ├── application.properties
│       ├── static/
│       └── templates/
└── test/
    └── java/com/rendysaptra/notes/
        └── NotesApplicationTests.java
```

## Planned Improvements

- Add update and delete operations.
- Add note filtering or search.
- Add controller, service, and request validation tests.
- Add explicit database configuration for production environments.