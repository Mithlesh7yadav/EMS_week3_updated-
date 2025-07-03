# EMS_week3_updated
# 🧑‍💼 Employee Management System (Spring Boot + PostgreSQL)

This is a simple Spring Boot application demonstrating:

- Employee and Department entity mapping
- Self-referencing manager relationship (an Employee can manage other Employees)
- RESTful APIs for CRUD operations
- Proper exception handling with `@ControllerAdvice`
- Input validation and clean structure

---

## 🏗️ Technologies Used

- Java8
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Postman (for testing)
- Maven

---

## 📦 Project Structure


com.EMS (spring boot + postgres)
├── controller
│ ├── EmployeeController.java
│ └── DepartmentController.java
├── entity
│ ├── Employee.java
│ └── Department.java
├── repository
│ ├── EmployeeRepository.java
│ └── DepartmentRepository.java
├── service
│ ├── EmployeeService.java
│ └── DepartmentService.java
├── exception
│ ├── GlobalExceptionHandler.java
│ └── ResourceNotFoundException.java
└── DemoApplication.java


---

## 🧩 Database Design

### `Employee` Table

| Field       | Type    | Description                                      |
|-------------|---------|--------------------------------------------------|
| id          | Long    | Primary key                                      |
| name        | String  | Employee name                                    |
| project     | String  | Project name                                     |
| age         | int     | Employee age                                     |
| salary      | double  | Employee salary                                  |
| manager_id  | Long    | FK to another employee (`self-referencing`)      |
| department_id | Long  | FK to `Department` table                         |

### `Department` Table

| Field       | Type    | Description           |
|-------------|---------|-----------------------|
| id          | Long    | Primary key           |
| name        | String  | Department name       |

---

## ⚙️ Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-username/employee-department-app.git
cd employee-department-app

spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

------------------------------------------------------------

🧪 API Testing (with Postman)
1. Create Department
POST /departments

json
Copy
Edit
{
  "name": "Engineering"
}

------------------------------------------
2. Create Employee
POST /employees

json
Copy
Edit
{
  "name": "Mithlesh",
  "project": "EMS System",
  "age": 28,
  "salary": 75000,
  "manager": {
    "id": 1
  },
  "department": {
    "id": 2
  }
}

-------------------------------------------


💡 Features
Full REST API for Employee & Department

Clean layered architecture (Controller → Service → Repository)

Exception handling with custom messages

Self-join example (Employee referencing a manager)


------------------------------------------





❗ Error Handling
Handled via GlobalExceptionHandler.java:

404: Resource Not Found

500: Internal Server Error

Custom error messages for clarity


