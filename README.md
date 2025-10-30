# 🏦 Bank Management System (Java + JDBC + MySQL)

## 📖 Overview
This **Bank Management System** is a Java-based application designed to manage essential banking operations such as **account creation, deposits, withdrawals, and balance inquiries**.  
The system now uses **JDBC (Java Database Connectivity)** with a **MySQL database** to store and manage account information persistently.

This project demonstrates **Object-Oriented Programming (OOP)** principles in Java along with **database connectivity**, making it an excellent example for students and beginners learning enterprise-level Java development.

---

## 🚀 Features
✅ Create new bank accounts with user details  
✅ Deposit money into an account  
✅ Withdraw money from an account  
✅ Check account balance  
✅ View transaction history  
✅ Login / Logout (Admin and User)  
✅ JDBC integration for persistent storage  
✅ MySQL database connectivity  
✅ Proper exception handling and input validation  
✅ Modular structure for maintainability and scalability  

---

## 🛠️ Technologies Used
| Category | Technology |
|-----------|-------------|
| Programming Language | Java (JDK 8 or higher) |
| Database | MySQL |
| Database Connectivity | JDBC |
| IDE | Eclipse / IntelliJ IDEA / NetBeans |
| Build Tool | Gradle / Manual Compilation |
| Web Server (if applicable) | Apache Tomcat |
| UI Layer (optional) | HTML, CSS (for servlet/web version) |

---

## 🗂️ Project Structure
| File/Folder | Description |
|--------------|-------------|
| `src/com/bank/dao/` | Data Access Layer for all database operations |
| `src/com/bank/model/` | Contains Java classes like `Account`, `User`, etc. |
| `src/com/bank/service/` | Contains business logic classes |
| `src/com/bank/utils/DBConnection.java` | JDBC connection setup |
| `webapp/` | Contains HTML, CSS files for frontend (if servlet-based) |
| `web.xml` | Servlet configuration file |
| `Bank.sql` | MySQL database schema file |
| `README.md` | Project documentation |

---

## 🧩 Database Configuration

### 🗄️ MySQL Setup
1. Open MySQL Workbench or CLI and create a database:
   ```sql
   CREATE DATABASE bank_management;
   USE bank_management;
CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20) UNIQUE,
    account_holder_name VARCHAR(100),
    account_type VARCHAR(20),
    phone_number VARCHAR(15),
    aadhaar_number VARCHAR(20) UNIQUE,
    balance DOUBLE DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20),
    transaction_type VARCHAR(20),
    amount DOUBLE,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



Update your JDBC connection details in DBConnection.java:

private static final String URL = "jdbc:mysql://localhost:3306/bank_management";
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";



How to Run the Project
🧩 Option 1: Run in Console

Clone the repository:

git clone https://github.com/BALAMADHU1/Bank_Management_System.git


Open the project folder in your IDE.

Configure your MySQL credentials in DBConnection.java.

Compile and run:

javac -d bin src/com/bank/**/*.java
java -cp bin com.bank.Main

🌐 Option 2: Run as Web Application (Servlet Version)

Import the project as a Dynamic Web Project in Eclipse.

Configure Tomcat Server.

Deploy the application and start the server.

Access in browser:

http://localhost:8080/Bank_Management_System/

💡 OOP Concepts Implemented

Encapsulation: Data hiding through private fields and public getters/setters.

Inheritance: Common base class Account for SavingsAccount and CurrentAccount.

Abstraction: Abstract methods defining common account operations.

Polymorphism: Overriding methods for different account types.

🔐 Admin Credentials (Example)
Username	Password
admin	admin

(You can modify these in the database for security.)

🧱 Future Enhancements

Add OTP-based authentication for login.

Generate PDF statements of transactions.

Integrate GUI using JavaFX or Spring Boot + Thymeleaf.

Add email/SMS notifications for transactions.

Role-based access (Admin / Customer).

🤝 Contribution

Fork this repository

Create your feature branch: git checkout -b feature/new-feature

Commit your changes: git commit -m 'Add new feature'

Push to the branch: git push origin feature/new-feature

Open a Pull Request

📜 License

This project is open-source under the MIT License — you’re free to use and modify it with attribution.

❤️ Acknowledgements

Thanks to all Java and MySQL developers who inspired this project!
Created with passion by Balamadhu Gujjala.


✨ Example Output (Console Version)
Welcome to Bank Management System
---------------------------------
1. Create Account
2. Deposit
3. Withdraw
4. Check Balance
5. Show Transactions
6. Exit
Enter your choice:

📧 Contact

For queries or collaboration, reach out at:
📩 balamadhug02@gmail.com

