# 🚖 Ride-Sharing Service – Dual Database Spring Boot App

This project is an **Spring Boot application** that demonstrates how to integrate and manage data across **two databases**:  

- **PostgreSQL** → for relational entities  
- **MongoDB** → for document-based storage  

---

## 📌 Overview
The application models a simplified **ride-sharing service**, handling different aspects of the system across both databases.  

- **Relational Entities (PostgreSQL):**  
  - **Captain**  
  - **Customer**  
  - **Trip**  
  - **Payment**  

- **Document Entity (MongoDB):**  
  - **Rating**  

---

## 🛠 Features
- Full **CRUD operations** for all entities  
- **Custom query methods** for advanced data retrieval  
- Well-structured **RESTful API endpoints**  
- Organized into layers:
  - **Model** (entities & documents)  
  - **Repository** (JPA & MongoDB repositories)  
  - **Service** (business logic)  
  - **Controller** (REST endpoints)
 
  ---

## 💻 Tech Stack
- **Java** with **Spring Boot**  
- **PostgreSQL** (relational database)  
- **MongoDB** (NoSQL database)  
- **Docker & Docker Compose**
- **Maven** (build tool)  
  
