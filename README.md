🏡 Neighborhood Community Management System
A simple Java console/web-based application built using Core Java, JDBC, and Oracle Database to manage neighborhood gardens, plot allocations, and community tasks.
This project follows the MVC (Model–View–Controller) layered architecture and demonstrates database interaction using JDBC with proper validation and exception handling.

🚀 Features
🌿 Garden Management
Add new garden details
View garden information
Store garden records in the database

🌱 Plot Allocation
Allocate plots to community members
Prevent duplicate or conflicting allocations
View plot allocation details

📋 Task Management
Assign tasks to garden plots
Track pending tasks
Handle allocation conflicts

✅ Validation & Exception Handling
Prevent empty or invalid inputs
Custom exceptions for:
Plot allocation conflicts
Validation errors
Active allocations or pending tasks
Proper error messages for failed operations

🛠 Technologies Used
Java (Core Java)
JDBC
Oracle Database (XE)
Apache Tomcat (if web-based) / Console (if standalone)
Eclipse / IntelliJ IDEA

📂 Project Structure
Bean Layer – Garden and PlotTask models
DAO Layer – Database operations
Service Layer – Business logic & validation
Util Layer – Database connection & custom exceptions
Main Class – Application entry point

🗄 Database Setup
Create required tables such as:
GARDEN
PLOT
PLOT_ALLOCATION
TASK


⚙️ Configuration
Update database connection details inside DBUtil.java:
Database URL
Username
Password
Add the Oracle JDBC Driver (ojdbc.jar) to your project libraries.

▶️ How to Run
Import the project into Eclipse or IntelliJ
Configure Oracle Database
Ensure JDBC driver is added
Run GardenMain.java
Use console options/menu to manage gardens, plots, and tasks

🧩 Application Flow
User Input → Main Controller → Service Layer → DAO Layer → Database → Result Displayed

🎯 Learning Objectives
This project helps understand:
JDBC connectivity with Oracle
Layered architecture (MVC style)
Exception handling using custom exceptions
Business logic validation
Database constraints and relationships
Clean code structure in Java

🔮 Future Enhancements
Add update and delete functionality
Build a web interface using Servlets/JSP
Implement connection pooling
Add authentication system for community members
Convert the project into Spring Boot application
Improve UI using HTML/CSS

👨‍💻 Author

Developed as a learning project for practicing JDBC, layered architecture, and exception handling in Java.

📜 License

This project is free to use for educational purposes.

Output:


<img width="495" height="179" alt="Screenshot 2026-02-12 093244" src="https://github.com/user-attachments/assets/96a9b9cf-3827-4914-8a55-4c8298097733" />


<img width="1528" height="847" alt="Screenshot 2026-02-12 093307" src="https://github.com/user-attachments/assets/a10e8afc-f43c-483d-a14b-e0c67aceade0" />


<img width="1552" height="899" alt="Screenshot 2026-02-12 093335" src="https://github.com/user-attachments/assets/d5793167-0c1b-43a2-a20d-da8e80d314cd" />


