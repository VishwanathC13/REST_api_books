# 📚 Spring Boot REST API - Book Management

A comprehensive **REST API** built with **Spring Boot** to manage books using ISBN, title, and author name. This project demonstrates **CRUD operations**, **RESTful principles**, and **Postman testing**.

---

## 🚀 Features

✅ Add new books 📖  
✅ Retrieve book details by ISBN 🔍  
✅ Retrieve all books 📚  
✅ Update book information ✏️  
✅ Delete books 🗑  
✅ In-memory database for quick testing ⚡  
✅ Exception handling for invalid requests ❌  
✅ RESTful API design 🌍  

---

## 🛠 Tech Stack

- **Spring Boot** – For backend development  
- **Spring Data JPA** – For database interactions  
- **H2 Database** – Lightweight, in-memory database  
- **Lombok** – Reduces boilerplate code  
- **Postman** – API testing tool  

---

## 🏗 Project Setup

### 1️⃣ Prerequisites
Ensure you have the following installed:
- **Java 17+**
- **Maven**
- **Postman** (for API testing)

### 2️⃣ Clone the Repository
```sh
git clone https://github.com/VishwanathC13/REST_api_books.git
cd REST_api_books
```

### 3️⃣ Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

### 4️⃣ Verify the API is Running
Open a browser and navigate to:
```
http://localhost:8080/books
```

---

## 🔥 API Endpoints

### 📝 Book Management Endpoints
| Method | Endpoint           | Description               | Request Body |
|--------|-------------------|---------------------------|--------------|
| GET    | `/books`      | Get all books            | ❌ |
| GET    | `/books/{isbn}` | Get book by ISBN        | ❌ |
| POST   | `/books`      | Add a new book           | ✅ |
| PUT    | `/books/{isbn}` | Update book information | ✅ |
| DELETE | `/books/{isbn}` | Delete a book           | ❌ |

### 📌 Request & Response Examples

#### 1️⃣ Add a New Book (POST `/books`)
**Request Body:**
```json
{
  "isbn": "123456789",
  "title": "Spring Boot in Action",
  "author": "Craig Walls"
}
```
**Response:**
```json
{
  "isbn": "123456789",
  "title": "Spring Boot in Action",
  "author": "Craig Walls"
}
```

#### 2️⃣ Get Book by ISBN (GET `/books/{isbn}`)
**Response:**
```json
{
  "isbn": "123456789",
  "title": "Spring Boot in Action",
  "author": "Craig Walls"
}
```

#### 3️⃣ Update Book Details (PUT `/books/{isbn}`)
**Request Body:**
```json
{
  "title": "Updated Title",
  "author": "Updated Author"
}
```

#### 4️⃣ Delete a Book (DELETE `/books/{isbn}`)
**Response:**
```
Book deleted successfully.
```

---

## 🧪 Testing with Postman
1. Open **Postman**.
2. Use the above endpoints to test API functionality.
3. Send requests with JSON data where required.

---

## 📌 Future Enhancements
- 🔑 Implement **JWT authentication** for secure access  
- 📄 Add **pagination & filtering** for books  
- 📡 Deploy on **AWS / Heroku**  
- 🎨 Integrate with a **React frontend**  

---

## 🎯 Contributing
Feel free to fork this repository, create a new branch, and submit a **Pull Request**! 🚀

---

## 📜 License
This project is licensed under the **MIT License**.

---

### 📩 Connect with Me
🔗 LinkedIn: [https://linkedin.com/in/your-profile](https://www.linkedin.com/in/vishwanath-c-154568208/)
