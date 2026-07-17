# JDBC Connectivity

A console-based Java application that demonstrates database connectivity using **JDBC** and **MySQL**. This project implements CRUD (Create, Read, Update, Delete) operations using both `Statement` and `PreparedStatement`, following a clean package structure.

---

## Features

- Insert records using `Statement`
- Retrieve records from MySQL
- Update existing records
- Delete records
- Perform CRUD operations using `PreparedStatement`
- Batch update support
- Centralized JDBC connection utility

---

## Technologies Used

| Technology | Version |
|------------|---------|
| Java | JDK 23 |
| JDBC | MySQL JDBC Driver |
| MySQL | 8.x |
| IDE | IntelliJ IDEA |
| Git | Version Control |

---

## Project Structure

```text
DatabaseConnectivity/
│
├── Database/
│   └── STUDENT.sql
│
├── src/
│   ├── connection/
│   │   └── JdbcConnection.java
│   │
│   ├── statement/
│   │   ├── DataInsertion.java
│   │   ├── DataRetrieve.java
│   │   ├── DataDeletion.java
│   │   └── CRUD_Operation.java
│   │
│   ├── preparedstatement/
│   │   ├── BatchUpdate.java
│   │   ├── Insertion_PreparedState.java
│   │   ├── Retrieve_PreparedState.java
│   │   ├── Update_PreparedState.java
│   │   └── Deletion_PreparedState.java
│   │
│   └── Main.java
│
├── .gitignore
└── README.md
```

---

## Database Schema

```sql
STUDENT(
    ID INT PRIMARY KEY,
    NAME VARCHAR(50),
    AGE INT,
    CITY VARCHAR(50)
)
```

---

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/your-username/DatabaseConnectivity.git
```

### 2. Open the project

Import the project into **IntelliJ IDEA**.

### 3. Configure MySQL

Create a database and import the SQL file located in the `Database` folder.

### 4. Update database credentials

Modify the values in `JdbcConnection.java`:

```java
String url = "jdbc:mysql://localhost:3306/STUDENT";
String username = "root";
String password = "your_password";
```

### 5. Run

Remove Comments to Execute 
Execute `Main.java`.

---

## Learning Outcomes

- JDBC architecture
- Database connectivity
- Statement vs PreparedStatement
- CRUD operations
- Exception handling
- Batch processing
- Java package organization

---

## Future Improvements

- Maven project structure
- Logging (Log4j/SLF4J)
- Connection Pooling
- DAO Design Pattern
- Menu-driven console application
- Transaction Management

---

## Author

**Disha Manmode**

Electronics Engineering Student | Java Developer | Learning JDBC, Spring Boot, and Full Stack Java Development


## License

Self Employed
