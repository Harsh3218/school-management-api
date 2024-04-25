# 🏫 School Management System

The **School Management System** is a Java Spring Boot application designed to manage student, parent, and teacher information within a school environment. This system provides RESTful API endpoints for CRUD operations on student data, including the ability to associate students with parents and teachers.

### 🧱 Technology Stack

- **Java**: Core programming language
- **Spring Boot**: Framework for building RESTful APIs
- **Spring Data JPA**: Persistence layer for interacting with databases
- **H2 Database**: In-memory database for development
- **PostgreSQL**: Production database (can be configured for other databases)
- **Maven**: Dependency management
- **Postman**: API testing tool
- **Lombok**: Library for reducing boilerplate code
- **JUnit**: Testing framework
  
#### 🚀 Getting Started

To run the School Management System application locally, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/school-management-system.git
   ```

2. **Configure Database Properties:**

   Open the `application.properties` file located in `src/main/resources` and update the database URL, username, and password according to your local environment:
   ```properties
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.url=jdbc:mysql://your-database-host/your-database-name
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.datasource.driver-class-name =com.mysql.cj.jdbc.Driver
   spring.jpa.show-sql: true
   ```

   Replace `your-database-host`, `your-database-name`, `your-username`, and `your-password` with your specific database details.

3. **Run the Application:**

   Navigate to the project directory and execute the following Maven command to start the application:
   ```bash
   mvn spring-boot:run
   ```

4. **Verify Application Startup:**

   Check the console logs for any startup messages or errors. Once the application has started successfully, you can proceed to interact with the API endpoints.

#### 🌐 API Endpoints

The School Management System exposes the following RESTful API endpoints:

- **Students:**
  - `POST /api/students/add`: Add a new student
  - `GET /api/students/{id}`: Retrieve student by ID
  - `GET /api/students/all`: Retrieve all students
  - `PUT /api/students/{id}`: Update student by ID
  - `DELETE /api/students/{id}`: Delete student by ID

- **Parents:**
  - `POST /api/parents/add`: Add a new parent
  - `GET /api/parents/{id}`: Retrieve parent by ID
  - `GET /api/parents/all`: Retrieve all parents
  - `PUT /api/parents/{id}`: Update parent by ID
  - `DELETE /api/parents/{id}`: Delete parent by ID

- **Teachers:**
  - `POST /api/teachers/add`: Add a new teacher
  - `GET /api/teachers/{id}`: Retrieve teacher by ID
  - `GET /api/teachers/all`: Retrieve all teachers
  - `PUT /api/teachers/{id}`: Update teacher by ID
  - `DELETE /api/teachers/{id}`: Delete teacher by ID


