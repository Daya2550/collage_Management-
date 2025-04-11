
# 📘 College Management System (Java - JFrame)

## 📌 Overview

The **College Management System** is a desktop-based Java application designed using `JFrame` for GUI. It helps colleges automate and simplify processes like **student attendance tracking**, **exam result generation**, and **notice board management**. It supports different user roles (Admin, Teacher, Student) and provides each role with tailored functionality and access.

---

## 🧑‍💻 Technologies Used

| Technology      | Description                      |
|-----------------|----------------------------------|
| Java (JDK)      | Core Programming Language        |
| Swing/JFrame    | GUI Framework for Desktop App    |
| MySQL           | Relational Database Management   |
| JDBC            | Java Database Connectivity       |
| iText Library   | For generating PDF reports       |

---

## 👥 User Roles & Functionalities

### 🔐 1. Login System
- Secure login with username and password.
- Role-based access: `Admin`, `Teacher`, `Student`.

---

### 👨‍💼 2. Admin Dashboard
- Full access to manage entire system.
- Add/Remove **students and teachers**.
- Assign students to **batches and classes**.
- Monitor **attendance and exam data**.
- Upload **global notices**.
- View all **attendance and result reports**.
- Control access to specific features.

---

### 👩‍🏫 3. Teacher Panel
- View assigned **classes and batches**.
- Add daily **attendance** for each student.
- Add and update **exam marks**.
- View and generate **exam result sheets**.
- Export **daily attendance reports** as PDFs.

---

### 👨‍🎓 4. Student Panel
- View **subject-wise** and **overall attendance**.
- Check **exam results** with **total percentage**.
- View **notice board** with updates from Admin/Teachers.

---

## 📂 Module Breakdown

### 📝 Attendance Management
- Teachers can mark attendance daily.
- Attendance data is saved with subject, date, and batch/class.
- Students can view attendance per subject and total percentage.
- Admin can view and manage all attendance data.

### 📊 Exam Result Management
- Teachers can enter exam marks for each student.
- The system calculates total marks and percentage.
- Exam results can be generated class-wise or student-wise.
- Students can access their results via their panel.

### 📢 Global Notice Board
- Admin and teachers can post notices.
- Students and teachers can view all relevant notices.
- Supports formatting and date-wise filtering.

### 📄 PDF Reporting
- Teachers/Admin can generate:
  - Daily attendance reports
  - Class-wise attendance summaries
  - Exam result sheets
- PDF generated using `iText` Java library.

---

## 🧱 Database Structure

### 📌 Tables

#### `users`
| Field        | Type    | Description             |
|--------------|---------|-------------------------|
| id           | INT     | Primary Key             |
| username     | VARCHAR | Unique user name        |
| password     | VARCHAR | Login password          |
| role         | ENUM    | 'Admin', 'Teacher', 'Student' |

#### `students`
| Field       | Type    | Description             |
|-------------|---------|-------------------------|
| student_id  | INT     | Primary Key             |
| name        | VARCHAR | Full name               |
| batch       | VARCHAR | Batch/year group        |
| class       | VARCHAR | Class assigned          |

#### `teachers`
| Field       | Type    | Description             |
|-------------|---------|-------------------------|
| teacher_id  | INT     | Primary Key             |
| name        | VARCHAR | Teacher name            |
| subject     | VARCHAR | Teaches subject         |
| assigned_class | VARCHAR | Class assigned      |

#### `attendance`
| Field       | Type    | Description              |
|-------------|---------|--------------------------|
| id          | INT     | Primary Key              |
| date        | DATE    | Date of attendance       |
| student_id  | INT     | FK to `students`         |
| subject     | VARCHAR | Subject name             |
| status      | VARCHAR | 'Present' / 'Absent'     |

#### `exam_results`
| Field        | Type    | Description              |
|--------------|---------|--------------------------|
| result_id    | INT     | Primary Key              |
| student_id   | INT     | FK to `students`         |
| subject      | VARCHAR | Subject name             |
| marks        | INT     | Marks scored             |
| total_marks  | INT     | Maximum marks            |

#### `notices`
| Field        | Type    | Description              |
|--------------|---------|--------------------------|
| notice_id    | INT     | Primary Key              |
| title        | VARCHAR | Notice title             |
| content      | TEXT    | Full content             |
| date_posted  | DATE    | Posting date             |
| posted_by    | VARCHAR | Admin/Teacher Name       |

---

## 🔄 Project Flow

1. **Login** → Identify user role.
2. **Role Redirect**:
   - Admin → Admin Dashboard
   - Teacher → Teacher Dashboard
   - Student → Student Panel
3. **Dashboard Usage**:
   - Add/view attendance
   - Add/view exam results
   - Access notices
   - Generate reports

---

## 🛠️ How to Run the Project

1. **Clone or download** this repository.
2. Import the project in your preferred **Java IDE** (e.g., NetBeans, IntelliJ, Eclipse).
3. Install and set up **MySQL database**.
4. Import the provided `college_management.sql` file.
5. Update your JDBC credentials in Java source files (e.g., `DBConnection.java`).
6. Compile and run `Main.java`.

---
