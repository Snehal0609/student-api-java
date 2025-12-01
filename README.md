This project is a complete Student CRUD Application built using Spring Boot.
It includes both:

1️⃣ REST API (Backend) — Create, Read, Update, Delete Students
2️⃣ Java Console Client — A menu-driven program that calls the API using HttpClient

This project demonstrates full-stack backend skills including API development, JPA, H2 database usage, clean folder structure, and integration with a Java-based client.

🚀 Features
✅ Backend REST API (Spring Boot)

POST → Create student

GET → Get student by ID

GET → Get all students

PUT → Update student

DELETE → Delete student

✅ Java Console Menu Client

Choose options (1 to 6)

Calls backend API

Display JSON responses

Handles wrong inputs safely

🛠 Technologies Used

Java 17

Spring Boot

Spring Data JPA

H2 In-Memory Database

Maven

Java HttpClient (for console client)

📁 Project Structure
src/
 └── main/java/com/example/demo
      ├── client
      │     └── StudentApiMenu.java
      ├── controller
      │     └── StudentController.java
      ├── model
      │     └── Student.java
      ├── repository
      │     └── StudentRepository.java
      └── DemoApplication.java
 └── main/resources
      └── application.properties

pom.xml
mvnw / mvnw.cmd
.gitignore


This is a correct, production-style Spring Boot project layout.

▶ How to Run the Backend API

In your project directory:

Start Spring Boot server
./mvnw spring-boot:run


The server will run at:

http://localhost:9191

▶ How to Run the Console Client
1 .Compile the project
./mvnw compile

2 Run the menu client
java -cp target/classes com.example.demo.client.StudentApiMenu


You will see:

===== STUDENT API MENU =====
1. Create Student
2. Get Student by ID
3. Get All Students
4. Update Student
5. Delete Student
6. Exit

API Endpoints (For Testing With Postman or curl)
Create Student
POST /students
Body:
{
  "name": "Snehal",
  "age": 25,
  "city": "Pune"
}

Get All Students
GET /students

Get By ID
GET /students/{id}

Update Student
PUT /students/{id}

Delete Student
DELETE /students/{id}

---Database

Uses H2 in-memory database

Auto-creates table based on the Student entity

No installation required

---Requirements

Java 17

Maven (or Maven Wrapper which is included)