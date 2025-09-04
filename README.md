Restful Bookstore API  
---------------------
Introduction:
-------------
The Restful Bookstore API is a backend application built using Spring Boot.  
It provides endpoints to manage Books and Authors with full CRUD (Create, Read, Update, Delete) operations.  

This project demonstrates:
--------------------------
- REST API design principles  
- Layered architecture (Controller → Service → Repository → Database)  
- Data transfer using DTOs  
- Integration with an H2 in-memory database  

Objectives
----------
- To design and implement a RESTful API for managing a bookstore.  
- To demonstrate the use of Spring Boot and Spring Data JPA.  
- To provide real-time testing using Postman.  

Technologies Used
-----------------
- Programming Language: Java 17+  
- Framework: Spring Boot
- Database: H2 (in-memory)  
- Tools: Maven, Postman, GitHub. 

Project Structure
-----------------
src/main/java/com/internshipproject/www/

1.controller     - REST API endpoints
2.dto            - Data Transfer Objects
3.entity         - JPA Entities (Book, Author)
4.repository     - Repositories (BookRepository, AuthorRepository)
5.service        - Interfaces for services
6.service/impl   - Service implementations

Features
--------
1.Books Management: Add, update, view, and delete books.  
2.Authors Management: Add, update, view, and delete authors.  
3.One-to-Many Relationship: Each author can have multiple books.  
4.H2 Console: For in-memory database monitoring.  

Setup and Execution
-------------------
1. Clone the Repository
2. git clone https://github.com/anushkabalaga/RestfullBookStoreAPI.git
3. cd RestfullBookStoreAPI

Run the Application
-------------------
mvnw spring-boot:- run

Access the Application
----------------------
Base URL:   http://localhost:2002
H2 Console: http://localhost:2002/h2-console`

API Endpoints
-------------
Books
-----
GET /api/books          - Get all books
POST /api/books         - Add a new book
PUT /api/books/{id}     - Update a book
DELETE /api/books/{id}  - Delete a book

Authors
--------
GET /api/authors          - Get all authors
POST /api/authors         - Add a new authors
PUT /api/authors/{id}     - Update an authors
DELETE /api/authors/{id}  - Delete an authors

Example API Usage
-----------------
Request: Create a Book

POST - /api/books`

json
{
  "title": "Effective Java",
  "isbn": "9780134685991",
  "authorId": 1
}
```

Response
--------
json
{
  "id": 1,
  "title": "Effective Java",
  "isbn": "9780134685991",
  "author": {
    "id": 1,
    "name": "Joshua Bloch"
  }
}


Conclusion
----------
The RESTFUL BOOKSTORE API demonstrates how to build a scalable and structured backend application with SPRING BOOT.
It provides a foundation for building real-world applications with relational data and RESTFUL services.


Author
------
Developed by Anushka Balaga

