# JAVA_Course_And_Project_by_CodingWallah   
## Java course by Shivam Sir [coding wallah utb channel and own site]  

**********************************************************************************************************************************
**********************************************************************************************************************************


# 📚 Simple Book Management System – Version 1

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen)
![Java](https://img.shields.io/badge/Java-17-blue)
![Status](https://img.shields.io/badge/Status-Active-success)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Build](https://img.shields.io/badge/Build-Maven-orange)

## A clean and beginner-friendly **Spring Boot REST API** for managing books.  

📝 Version Info

Version 1: Basic CRUD, in-memory repository (HashMap)

Version 2 (coming soon):
Uses Repository interface, Dependency Injection, IoC, loose coupling.

Version 3 (future):
Database integration + JPA + MySQL + DTOs + validations.


This **v1** uses an **in-memory HashMap** instead of a database — perfect for learning backend fundamentals.

Built while learning Spring Boot and REST API fundamentals.

---

**********************************************************************************************************************************

## 🚀 Features

- Add a new book  
- Fetch all books  
- Update book  
- Delete book  
- Simple & clear 3-layer design (Controller → Service → Repository → Model)  
- No database required  

---

**********************************************************************************************************************************

## 🧱 Project Structure

✅ ALL DEFAULT FOLDERS OF A SPRING BOOT + MAVEN PROJECT (SQL Format)
```
project-root/
│
├── src/
│   ├── main/
│   │   ├── java/                -- main source code
│   │   ├── resources/           -- configs & static files
│   │   │   ├── application.properties
│   │   │   ├── application.yml
│   │   │   └── static/          -- CSS, JS, images
│   │   │
│   │   └── webapp/ (optional)   -- JSP or templates
│   │
│   └── test/
│       └── java/                -- unit tests
│
├── target/                      -- generated output (ignored in git)
│
├── pom.xml                      -- Maven build file
│
└── README.md
```

#### SRC FOLDER : 
src/main/java/com/alpha1zln/simpleBookMgmt/  
```
src/
└── main/
    └── java/
        └── com/
            └── alpha1zln/
                └── simpleBookMgmt/
                    ├── SimpleBookMgmtApplication.java
                    │
                    ├── model/
                    │   └── Book.java
                    │
                    ├── repository/
                    │   └── BookRepository.java
                    │
                    ├── service/
                    │   └── BookService.java
                    │
                    └── controller/
                        └── BookController.java

```

**********************************************************************************************************************************


---

## 📌 Endpoints (REST API)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/books` | Get all books |
| GET | `/books/{id}` | Get book by ID |
| POST | `/books` | Add a book |
| PUT | `/books/{id}` | Update book |
| DELETE | `/books/{id}` | Delete book |

---

## 📦 JSON Example (Add Book)

```json
{
  "id": 101,
  "title": "The Alchemist",
  "author": "Paulo Coelho"
}
```

**********************************************************************************************************************************
🧩 UML Diagrams

1️⃣ Class Diagram (Simple)
```
+------------------+
|      Book        |
+------------------+
| - id: int        |
| - title: String  |
| - author: String |
+------------------+

+------------------------+       +---------------------------+
|     BookController     |       |       BookService        |
+------------------------+       +---------------------------+
| + getAllBooks()        | <---> | + getAllBooks()          |
| + getBookById(id)      |       | + getBookById(id)        |
| + addBook(book)        |       | + addBook(book)          |
| + updateBook(id,book)  |       | + updateBook(id,book)    |
| + deleteBook(id)       |       | + deleteBook(id)         |
+------------------------+       +---------------------------+
                                        |
                                        v
                              +--------------------------+
                              |     BookRepository      |
                              +--------------------------+
                              | + save(book)            |
                              | + findAll()             |
                              | + findById(id)          |
                              | + deleteById(id)        |
                              +--------------------------+

```
**********************************************************************************************************************************

🧩 Clear Sequence Diagram (Step-by-Step Flow)

Below is a crystal clear ASCII sequence diagram showing how each layer talks:
```
User (Postman)
      |
      | 1. Sends HTTP Request (GET/POST/PUT/DELETE)
      v
+----------------------+
|   BookController     |
+----------------------+
      |
      | 2. Calls Service Method
      v
+----------------------+
|     BookService      |
+----------------------+
      |
      | 3. Talks to Repository
      v
+----------------------------+
|      BookRepository        |
+----------------------------+
      |
      | 4. Returns Data (Book / List / Boolean)
      ^
      |
+----------------------+
|     BookService      |
+----------------------+
      ^
      | 5. Sends processed data
      |
+----------------------+
|   BookController     |
+----------------------+
      ^
      | 6. Sends HTTP Response (JSON)
      |
User (Postman)
```

Simple explanation:
User → Controller → Service → Repository → Service → Controller → User.

**********************************************************************************************************************************
🧩 How to Use POSTMAN in VS Code (Step-by-Step)

📌 Step 1 — Install "Postman" Extension

In VS Code:

Go to Extensions

Search → "Postman"

Install the official extension

📌 Step 2 — Open Postman Sidebar

Left side → Look for Postman icon → Click it.

📌 Step 3 — Create a New Request

Click:

New → HTTP Request


It opens a new tab like:

GET http://localhost:8080

📌 Step 4 — Select HTTP Method

At top left:

GET | POST | PUT | DELETE


Choose the method as per API.

📌 Step 5 — Enter URL

Example:

http://localhost:8080/books

📌 Step 6 — For POST/PUT → Add Body

Click:

Body → Raw → JSON


Then paste JSON.

📌 Step 7 — Hit SEND

You will see the API output at bottom.

🚀 Now Examples for All CRUD Operations

We will use these random sample books:

id	title	author
101	Rich Dad Poor Dad	Robert Kiyosaki
102	Atomic Habits	James Clear
✅ A) GET ALL BOOKS
Request
GET http://localhost:8080/books

Response
[
  {
    "id": 101,
    "title": "Rich Dad Poor Dad",
    "author": "Robert Kiyosaki"
  },
  {
    "id": 102,
    "title": "Atomic Habits",
    "author": "James Clear"
  }
]

✅ B) GET BOOK BY ID
Request
GET http://localhost:8080/books/101

Response
{
  "id": 101,
  "title": "Rich Dad Poor Dad",
  "author": "Robert Kiyosaki"
}

✅ C) ADD BOOK (POST)
Request
POST http://localhost:8080/books

Body (JSON)
{
  "id": 103,
  "title": "The Alchemist",
  "author": "Paulo Coelho"
}

Response
{
  "id": 103,
  "title": "The Alchemist",
  "author": "Paulo Coelho"
}

✅ D) UPDATE BOOK (PUT)
Request
PUT http://localhost:8080/books/102

Body (JSON)
{
  "title": "Atomic Habits (Updated)",
  "author": "James Clear"
}

Response
{
  "id": 102,
  "title": "Atomic Habits (Updated)",
  "author": "James Clear"
}

✅ E) DELETE BOOK
Request
DELETE http://localhost:8080/books/101

Response
"Deleted"


If ID not found → "Not Found"

*******
# 🧪 Postman Summary for Book Management System (Version 1)

## How to Use Postman in VS Code
1. Install the "Postman" extension in VS Code.
2. Open the Postman sidebar (left panel).
3. Click: New → HTTP Request.
4. Select HTTP Method (GET, POST, PUT, DELETE).
5. Enter the API URL (example: http://localhost:8080/books).
6. For POST/PUT:
   - Open Body tab
   - Select Raw → JSON
   - Enter JSON data
7. Click SEND to execute the request.

---

### CRUD API Examples

#### 1️⃣ GET -– GET / Fetch All Books
- Method: GET  
- URL: `http://localhost:8080/books`
- Purpose: Returns list of all books.

Response Example:
[
  {
    "id": 101,
    "title": "Rich Dad Poor Dad",
    "author": "Robert Kiyosaki"
  },
  {
    "id": 102,
    "title": "Atomic Habits",
    "author": "James Clear"
  }
]

---

#### 2️⃣ GET - GET BOOK BY ID / Fetch Single Book
- Method: GET
- URL: `http://localhost:8080/books/101`
- Purpose: Returns details of book with ID = 1.


Response:
{
  "id": 101,
  "title": "Rich Dad Poor Dad",
  "author": "Robert Kiyosaki"
}

---

#### 3️⃣ POST - ADD BOOK (POST) / Add New Book

- Method: POST
- URL: `http://localhost:8080/books`
- Purpose: Adds a new book to the system.

Body (JSON):
{
  "id": 103,
  "title": "The Alchemist",
  "author": "Paulo Coelho"
}

---

#### 4️⃣ PUT – Update Existing Book / UPDATE BOOK (PUT)
- Method: PUT
- URL: `http://localhost:8080/books/102`
- Purpose: Updates book details with ID = 1.

Body:
{
  "title": "Atomic Habits (Updated)",
  "author": "James Clear"
}

---

#### 5️⃣ DELETE – Remove Book / DELETE BOOK
- Method: DELETE
- URL: http://localhost:8080/books/1
- Purpose: Deletes book with ID = 1.

Response Examples:
"Deleted"
or
"Not Found"

---

### 🧱 Summary Table

| Operation     | Method | URL                  | Body |
|--------------|--------|----------------------|------|
| Get all      | GET    | /books               | ❌   |
| Get by ID    | GET    | /books/{id}          | ❌   |
| Add book     | POST   | /books               | ✔️   |
| Update book  | PUT    | /books/{id}          | ✔️   |
| Delete book  | DELETE | /books/{id}          | ❌   |



**********************************************************************************************************************************

🌟 GitHub Commands - Steps to create repo on github and push code from pc to github site ::

### 🧱 A. CREATE REPOSITORY ON GITHUB SITE :

- First create a repository on github site.

- Create a dir - with project name and mention ver_no. in it [if multiple ver will be there in future].

- Add readme.md and mention some proj. details.

****

### 🧱 B. You already created a GitHub repo → now follow these steps:

📌 Step 1: Clone your repository to PC

Open terminal in the folder where you want the project:

git clone https://github.com/your-username/your-repo-name.git

📌 Step 2: Copy your project files into the cloned folder

Open the cloned repo folder on your PC

Paste your Spring Boot project inside it

Make sure the folder now contains src/, pom.xml, README.md


****
### 🧱 B-i <in detail>. PUSH CODE FROM PC TO GITHUB SITE

Here are the correct steps when you have already cloned the repository from GitHub.

📌 IMPORTANT:
If you cloned a repo → DO NOT run git init (because .git already exists).

🚀 Correct Steps to Push Local Spring Boot Project to GitHub (When Repo is Cloned)
```
✅ 1. Go to your project folder
cd your-project-folder-name

❌ (Skip this — do NOT run)
git init     ← NOT NEEDED because repo was cloned

✅ 2. Check Git status
``` git status ```

This confirms:
repo exists
remote is linked
branch name (main)


✅ 3. Create and switch to new branch (projver1)
git checkout -b projver1

✅ 4. Add all new files
git add .

✅ 5. Commit your changes
git commit -m "Initial commit for version 1"

✅ 6. Push new branch to GitHub
git push -u origin projver1
```

🎉 That’s it!

Your project is now pushed to branch: projver1, and from GitHub UI you can Create Pull Request → Merge to main.

🚀 Full Corrected Command Set (Copy-Paste Block)
```
cd your-project-folder-name
git status
git checkout -b projver1
git add .
git commit -m "Initial commit for version 1"
git push -u origin projver1
```

******

### 🧱 B-ii <in detail>. If PUSH from pc to github is done using branch.

Then go to GitHub site → Open Pull Request → Merge to main branch.

**********************************************************************************************************************************

**********************************************************************************************************************************

🌟🌟 ## THEORY 🌟🌟 *******

***********************

## 🌟 3-Layer Architecture (Simple Explanation)

### 1️⃣ Controller Layer (Presentation Layer)
- Handles incoming API requests (GET/POST/PUT/DELETE).
- Talks to service layer for business logic.
- Sends back responses to the user.
- Converts JSON → Java & Java → JSON.
- Validates input before passing ahead.
- Main job: Communicate between user and service.

### 2️⃣ Service Layer (Business Layer)
- Contains all the business rules and logic.
- Decides how data should be processed.
- Talks to the repository for data access.
- Ensures validation & rules before saving/updating.
- Acts as a middle layer between controller & repo.
- Main job: “Brain” of the application.

### 3️⃣ Repository Layer (Data Access Layer)
- Handles data storage (DB, files, maps, etc.).
- In our case, uses HashMap as in-memory database.
- Provides CRUD functions like save, find, delete.
- No business logic here → only data access.
- Used by service layer when data is needed.
- Main job: Store and retrieve data.


***************
## 🌟 4-Layer Architecture (Simple Explanation)

### 1️⃣ Controller Layer
- Receives API requests.
- Calls service layer.
- Sends JSON results back.
- No business logic.
- Only input/output handling.
- Like a receptionist.

### 2️⃣ Service Layer
- Contains business rules.
- Processes data before saving.
- Calls repository layer.
- Ensures workflow correctness.
- No database code.
- Like a manager.

### 3️⃣ Repository Layer
- Handles CRUD operations.
- Talks to the database.
- No business logic.
- Pure storage code only.
- Used by service layer.
- Like a librarian storing books.

### 4️⃣ Model/Entity Layer
- Contains Java classes (Book, Student, etc.).
- Represents table/data structure.
- Used by all layers.
- Only fields + getters/setters.
- No logic inside.
- Like a blueprint of objects.

*******

## 📝 Architecture Summary Table

| Layer Name     | Purpose (Simple Words)                  | Contains What?                      |
|----------------|-----------------------------------------|-------------------------------------|
| Controller     | Handles API calls & responses           | REST APIs, request handling         |
| Service        | Holds business logic                    | Logic, processing, validations      |
| Repository     | Manages data storage                    | CRUD operations, database access    |
| Model/Entity   | Represents data structure               | Fields, getters/setters (POJOs)     |



****************

## 🌟 LAYMAN LANG ... Layman Analogy   

🚀 3-Layer Architecture (Explained in Simple Language)

1. Model Layer (WHAT data looks like)
This is your data blueprint.
Example → Book has id, title, author.

2. Service Layer (BUSINESS LOGIC)
This is your brain of the app.

It decides:
how to add books
how to update
how to delete
where to store data (here → list in memory)

3. Controller Layer (ENTRY GATE)
This is the communication layer.
It takes requests from browser / Postman and calls the service.

4. Repository Layer (STORAGE ROOM)
This is the place where all data is kept safely.
Like a storage room where you put books in and take books out.
It only knows how to store and fetch things, nothing else.
Service layer comes here whenever it needs data.

*****

🎯 Simple Explanation of Layers (Updated)  


|Layer	         |      Meaning	                            |                    What It Does  |
|----------------|-----------------------------------------|-------------------------------------|
|Model	          |  Data structure / Shape of object	         |      Book(id, title, author) - Book POJO  |
|Repository	      | Fake DB	[In-memory storage using HashMap]    |      Stores books inside HashMap  |
|Service	      |    Logic	/ processing                     |      Checks, updates, delete rules - add, update, delete  |
|Controller	      |API	Handles / API entry-point                |      URL endpoints, Ex - GET /books  |


*******
 
### 🌟 UML = Unified Modeling Language
```
What they are:
Simple diagrams that show how your application works.

Common ones:
Class Diagram → Shows your classes (Book, Service, Repository)

Sequence Diagram → Shows how requests flow (Controller → Service → Repository)

Why useful:
Helps understand project structure
Good for documentation
College submissions / viva questions
```

**************
crtr - alpha1zln - cgo
**************

### 🌟 POSTMAN

• Postman is a tool used to test REST APIs easily.  
• It allows us to send GET, POST, PUT, DELETE requests to our backend.  
• We can check responses instantly without building a full UI.  
• It helps debug errors by showing status codes and response bodies.  
• Developers use it to verify every API endpoint works correctly.  
• It is very important for backend projects because it speeds up testing and development.  


**********************************************************************************************************************************
DONE 
**********************************************************************************************************************************
