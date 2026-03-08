# Job Portal (Java + MySQL)

## Project Description

This project is a simple **Job Portal Management System** built using **Java and MySQL**.
It allows users to perform basic database operations such as inserting, viewing, updating, and deleting job records from a MySQL database.

The program uses **JDBC (Java Database Connectivity)** to connect Java with MySQL and perform CRUD operations.

---

# Features

The application provides the following functionalities:

1. **Insert Job**

   * Add a new job record with:

     * Job Title
     * Company Name
     * Salary

2. **View Jobs**

   * Display all jobs stored in the database.

3. **Update Job Salary**

   * Update the salary of a specific job using the Job ID.

4. **Delete Job**

   * Remove a job from the database using the Job ID.

5. **Exit**

   * Close the application.

---

# Technologies Used

* **Java**
* **JDBC**
* **MySQL**
* **MySQL Workbench**
* **PreparedStatement**
* **SQL (CRUD operations)**

---

# Database Setup

Create a database and table in MySQL before running the program.

```sql
CREATE DATABASE job_portal;

USE job_portal;

CREATE TABLE jobs (
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    company VARCHAR(100),
    salary INT
);
```

---

# MySQL Connection Configuration

Update the database credentials in the `connect()` method if needed:

```java
con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/job_portal",
    "root",
    "your_password"
);
```

---

# How to Run the Program

1. Install **MySQL Server** and **MySQL Workbench**.
2. Create the database and table using the SQL script above.
3. Add the **MySQL JDBC Driver** to your Java project.
4. Compile the program:

```
javac Jobportal.java
```

5. Run the program:

```
java jobportal.Jobportal
```

---

# Program Menu

When the program runs, the following menu appears:

```
1. Insert Job
2. View Jobs
3. Update Salary
4. Delete Job
5. Exit
```

Users can select an option to perform the required operation.

---

# Example Output

```
1. Insert Job
2. View Jobs
3. Update Salary
4. Delete Job
5. Exit

Choice: 1

Job Title:
Software Developer
Company:
Google
Salary:
120000
Inserted → Check MySQL Workbench
```

---

# Project Structure

```
jobportal
 └── Jobportal.java
```

---

# Author

**Srikesav M**

---

# Future Improvements

Possible improvements for this project:

* Add **search job functionality**
* Add **job location field**
* Create a **GUI using Java Swing or JavaFX**
* Add **user authentication (admin login)**
* Implement **job application system**

---
