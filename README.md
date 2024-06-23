## 教学项目管理系统 - 后端

### 简介

此项目为教学项目管理系统的后端部分，主要功能包括：
- 教师管理：教师可以创建、更新、删除项目，并查看项目详细信息。
- 学生管理：学生可以查看项目、参与项目或退出项目。
- 参与管理：管理学生参与项目的情况，包括角色分配。
- 数据展示：通过 API 接口展示教师、学生、项目和参与信息。
- [前端项目地址](https://github.com/gujiu21L/Teaching-Project-Management-Frontend)
  
### 项目结构

- `src/main/java`：Java 源代码目录。
- `src/main/resources`：资源文件目录，包括配置文件。
- `src/test/java`：单元测试代码目录。

### 环境要求

- JDK 8 及以上
- MySQL 5.7 及以上

### 数据库配置

1. **配置数据库连接**

   在项目根目录下创建 `jdbc.properties` 文件，并根据实际情况填写数据库连接信息。可以参考 `jdbc.properties.template` 模板文件：

   ```properties
   jdbc.url=jdbc:mysql://localhost:3306/yourdatabase
   jdbc.username=yourusername
   jdbc.password=yourpassword
   ```

2. **创建数据库和表**

   使用项目提供的 `schema.sql` 脚本来创建数据库和表：

   ```sql
   CREATE DATABASE teaching_project_management;
   USE teaching_project_management;

   CREATE TABLE Teacher (
       TeacherID INT AUTO_INCREMENT PRIMARY KEY,
       Name VARCHAR(255),
       Email VARCHAR(255),
       Department VARCHAR(255)
   );

   CREATE TABLE Student (
       StudentID INT AUTO_INCREMENT PRIMARY KEY,
       Name VARCHAR(255),
       Email VARCHAR(255),
       Major VARCHAR(255)
   );

   CREATE TABLE Project (
       ProjectID INT AUTO_INCREMENT PRIMARY KEY,
       ProjectName VARCHAR(255),
       StartDate DATE,
       EndDate DATE,
       TeacherID INT,
       FOREIGN KEY (TeacherID) REFERENCES Teacher(TeacherID)
   );

   CREATE TABLE ProjectParticipation (
       ParticipationID INT AUTO_INCREMENT PRIMARY KEY,
       ProjectID INT,
       StudentID INT,
       Role VARCHAR(255),
       FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID),
       FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
   );
   ```

### 运行项目

1. **克隆仓库**

   ```sh
   git clone https://github.com/gujiu21L/Teaching-Project-Management-Backend.git
   cd Teaching-Project-Management-Backend
   ```

4. **访问 API 接口**

   项目启动后，可以通过以下路径访问 API 接口：

   - 获取所有教师信息：`GET /teacher/getAllTeachers`
   - 获取教师详情：`GET /teacher/getTeacherById?teacherId={teacherId}`
   - 新增教师：`POST /teacher/addTeacher`
   - 更新教师信息：`POST /teacher/updateTeacher`
   - 删除教师：`POST /teacher/deleteTeacher?teacherId={teacherId}`

   - 获取所有学生信息：`GET /student/getAllStudents`
   - 获取学生详情：`GET /student/getStudentById?studentId={studentId}`
   - 新增学生：`POST /student/addStudent`
   - 更新学生信息：`POST /student/updateStudent`
   - 删除学生：`POST /student/deleteStudent?studentId={studentId}`

   - 获取所有项目信息：`GET /project/getAllProjects`
   - 获取项目详情：`GET /project/getProjectById?projectId={projectId}`
   - 新增项目：`POST /project/addProject`
   - 更新项目信息：`POST /project/updateProject`
   - 删除项目：`POST /project/deleteProject?projectId={projectId}`

   - 获取所有项目参与信息：`GET /participation/getAllParticipations`
   - 获取项目参与详情：`GET /participation/getParticipationById?participationId={participationId}`
   - 新增项目参与信息：`POST /participation/addParticipation`
   - 更新项目参与信息：`POST /participation/updateParticipation`
   - 删除项目参与信息：`POST /participation/deleteParticipation?participationId={participationId}`

### 项目部署

打成war包放到服务器里就行

### 贡献

欢迎提交 issue 和 pull request 来改进本项目。
