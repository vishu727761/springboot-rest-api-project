# Spring Boot REST API Project

A practical Spring Boot project demonstrating REST principles, CRUD operations, Bean Validation,
standardized JSON responses, layered architecture, and CORS.

## Requirements
- JDK 17 or newer
- Maven 3.6+
- IntelliJ IDEA, Eclipse, or VS Code
- Postman (optional, for API testing)

## Run the project
1. Extract the ZIP file.
2. Open the `springboot-rest-api-project` folder in your IDE.
3. Ensure JDK 17+ and Maven are configured.
4. Run `RestApiApplication.java`, or use a terminal:
   ```bash
   mvn spring-boot:run
   ```
5. The API will start at `http://localhost:8080`.

The project uses an in-memory H2 database. Data is reset when the application restarts.

## API endpoints

### Posts
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/posts` | Get all posts |
| GET | `/api/posts/{id}` | Get one post |
| POST | `/api/posts` | Create a post |
| PUT | `/api/posts/{id}` | Update a post |
| DELETE | `/api/posts/{id}` | Delete a post |

POST/PUT JSON body:
```json
{
  "title": "My first post",
  "content": "This is my sample post content."
}
```

### Appointments / Scheduling
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/appointments` | Get all appointments |
| GET | `/api/appointments/{id}` | Get one appointment |
| POST | `/api/appointments` | Create an appointment |
| PUT | `/api/appointments/{id}` | Update an appointment |
| DELETE | `/api/appointments/{id}` | Delete an appointment |

POST/PUT JSON body (use a future date/time):
```json
{
  "customerName": "Aman Kumar",
  "serviceName": "Consultation",
  "scheduledAt": "2027-01-15T10:30:00"
}
```

## Sample response
```json
{
  "success": true,
  "message": "Post created successfully",
  "data": {
    "id": 1,
    "title": "My first post",
    "content": "This is my sample post content."
  }
}
```

Validation errors return HTTP 400 with field-level messages. Missing records return HTTP 404.

## CORS
CORS is enabled for:
- `http://localhost:3000`
- `http://localhost:5173`

Change allowed origins in `CorsConfig.java` to match your frontend.

## H2 database console
Open `http://localhost:8080/h2-console` while the app is running.
- JDBC URL: `jdbc:h2:mem:restapidb`
- User Name: `sa`
- Password: leave blank
