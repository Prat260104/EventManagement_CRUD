# Event Management System

## 🚀 How to Run the Project
Open your terminal in this folder and run:
```bash
mvn spring-boot:run
```
*(Make sure you have Java and Maven installed)*

---

## Project Structure Explained

```
EventManagement
├── pom.xml                     <-- Maven configuration (Depedencies like Spring Web, H2, JSP)
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.eventmanagement
│   │   │       ├── EventManagementApplication.java  <-- Main entry point (Starts the App)
│   │   │       ├── model
│   │   │       │   └── Event.java                   <-- Database Table Structure (Entity)
│   │   │       ├── repository
│   │   │       │   └── EventRepository.java         <-- Database Tools (Save, Delete, Find)
│   │   │       └── controller
│   │   │           └── EventController.java         <-- Traffic Cop (Handles URL requests)
│   │   ├── resources
│   │   │   └── application.properties               <-- Settings (Port, DB, JSP path)
│   │   └── webapp
│   │       └── WEB-INF
│   │           └── jsp
│   │               ├── events.jsp                   <-- Main Page (HTML + Logic)
│   │               ├── edit_event.jsp               <-- Edit Page
│   │               └── delete_confirm.jsp           <-- Delete Confirmation Page
```

## detailed Explanation

### 1. Backend (Java)
- **`model/Event.java`**: This is your "Data". It tells Spring Boot what an "Event" looks like (ID, Name, Date). It maps directly to a database table.
- **`repository/EventRepository.java`**: This is your "Database Manager". It automatically gives you methods like `.save()`, `.findAll()`, `.deleteById()` without writing SQL.
- **`controller/EventController.java`**: This is the "Brain".
    - When you go to `/events`, it asks the Repository for data and sends it to `events.jsp`.
    - When you submit a form, it receives the data and tells the Repository to save it.

### 2. Frontend (JSP)
- **`webapp/WEB-INF/jsp/`**: This is where your visual pages live.
- **`events.jsp`**: The main dashboard. It uses JSTL tags (like `<c:forEach>`) to loop through the data sent by the Controller.

### 3. Configuration
- **`pom.xml`**: Your project's "Shopping List". It tells Maven to download "Spring Boot", "H2 Database", etc.
- **`application.properties`**: Configuration file. We told it to look for JSPs in `/WEB-INF/jsp/` and use an in-memory H2 database.

## ⚠️ Important Note About Data Storage
Currently, the project uses an **H2 In-Memory Database**.
- **Where is data stored?**: Inside your computer's RAM (Temporary Memory).
- **What happens when I stop the app?**: All data (events) will be **DELETED**.
- **Why?**: This keeps the project simple so you don't have to install MySQL or PostgreSQL to run it.
- **For Teacher**: You can explain that "For simplicity, we are using H2 in-memory DB. In a real app, we would change `application.properties` to connect to MySQL for permanent storage."

