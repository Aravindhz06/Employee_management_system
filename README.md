📋 Employee Management System

A desktop-based Employee Management System built using Java Swing, Core Java, JDBC, and MySQL. The application allows users to add, update, view, and remove employee details with a clean and interactive user interface.

🚀 Features

➕ Add New Employee

📝 Update Existing Employee

👀 View Employee Details

❌ Delete Employee

🔍 Search Employees

🆔 Auto-generated Employee ID

💾 Persistent storage using MySQL database

🖥️ Fully interactive GUI using Java Swing

🛠️ Tech Stack

Java (Core Java + OOPs)

Java Swing — GUI

JDBC — Database connectivity

MySQL — Backend database

IntelliJ IDEA / Eclipse

📂 Project Structure
Employee_Management_System/
├── src/
│   ├── Main.java
│   ├── AddEmployee.java
│   ├── ViewEmployee.java
│   ├── UpdateEmployee.java
│   ├── RemoveEmployee.java
│   ├── Conn.java        # JDBC connection file
│   └── ... other GUI files
├── images/
│   └── icons used in GUI
└── README.md

🗄️ Database Setup (MySQL)

Create a database and table:

CREATE DATABASE employee_management;

USE employee_management;

CREATE TABLE employee (
    name VARCHAR(50),
    fname VARCHAR(50),
    dob VARCHAR(20),
    salary VARCHAR(20),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(50),
    education VARCHAR(50),
    aadhar VARCHAR(20),
    empId VARCHAR(20) PRIMARY KEY
);


Update your MySQL username and password inside Conn.java.

▶️ How to Run

Install Java and MySQL

Import project into IntelliJ IDEA or Eclipse

Configure your database in Conn.java

Run:

Main.java


The Employee Management dashboard will open.

📸 Screenshots

(Add your GUI screenshots here)

!<img width="1229" height="610" alt="login" src="https://github.com/user-attachments/assets/ac9ff07d-5f97-4bd4-a7f8-a7895ef1a012" />
(images/dashboard.png)
!<img width="1098" height="736" alt="add" src="https://github.com/user-attachments/assets/d6898d8e-46a7-42e3-831a-054db04cb3cc" />
(images/add_employee.png)

📌 Future Improvements

Add validation for input fields

Add login authentication

Add export to PDF/Excel

Add employee attendance module

📧 Contact

If you have suggestions or want to connect:

GitHub: https://github.com/Aravindhz06

LinkedIn: https://www.linkedin.com/in/aravindh6104/
