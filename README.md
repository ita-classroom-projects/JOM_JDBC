## Develop a Database for Managing Employees, Roles, Directions, and Projects 
You need to design a database for a company that works on various projects, each belonging to a specific direction. Each employee has a specific role and is assigned to a particular project.

### Database Structure Requirements
**1. Roles Table (Job Roles)**
- **id (PK**) – unique identifier for the role.
- **roleName (VARCHAR, unique)** – the name of the role (e.g., "Developer", "DevOps", "QC").

**2. Directions Table (Business Directions)**

- **id (PK)** – unique identifier for the direction.
- **directionName (VARCHAR, unique)** – the name of the direction (e.g., "Java", "Python", ".Net").

**3. Projects Table (Company Projects)**

- **id (PK)** – unique identifier for the project.
- **projectName (VARCHAR, unique)** – the name of the project.
- **directionId (FK → Directions.id)** – the direction to which the project belongs.

**4. Employee Table (Company Employees)**

- **id (PK)** – unique identifier for the employee.
- **firstName (VARCHAR)** – employee's first name.
- **roleId (FK → Roles.id)** – employee's role in the company.
- **projectId (FK → Projects.id)** – the project the employee is assigned to.
  
![image](https://github.com/user-attachments/assets/d856c0f0-eb4d-4af9-8150-7421d4ff02c5)

**Create next methods of the MyUtils class:**

- public Connection createConnection() throws SQLException
- public void closeConnection() throws SQLException
- public Statement createStatement() throws SQLException
- public void closeStatement() throws SQLException
- public void createSchema(String schemaName) throws SQLException
- public void dropSchema() throws SQLException
- public void useSchema() throws SQLException

**Methods for creating tables:**

- public void createTableRoles() throws SQLException
- public void createTableDirections() throws SQLException
- public void createTableProjects() throws SQLException
- public void createTableEmployees() throws SQLException
- public void dropTable(String tableName) throws SQLException

**Methods for insert data to tables:**

- public void insertTableRoles(String roleName) throws SQLException
- public void insertTableDirections(String directionName) throws SQLException
- public void insertTableProjects(String projectName, String directionName) throws SQLException
- public void insertTableEmployees(String firstName, String roleName, String projectName) throws SQLException

**Methods to obtaining data from tables:**

- public int getRoleId(String roleName) throws SQLException
- public int getDirectionId(String directionName) throws SQLException
- public int getProjectId(String projectName) throws SQLException
- public int getEmployeeId(String firstName) throws SQLException
- public List<String> getAllRoles() throws SQLException
- public List<String> getAllDirestions() throws SQLException
- public List<String> getAllProjects() throws SQLException
- public List<String> getAllEmployees() throws SQLException
- public List<String> getAllDevelopers() throws SQLException
- public List<String> getAllJavaProjects() throws SQLException
- public List<String> getAllJavaDevelopers() throws SQLException

For example, for a given data:

![image](https://github.com/user-attachments/assets/4ca4f295-d55e-46dc-baa9-c3b1375ba577)

![image](https://github.com/user-attachments/assets/1e126f15-6511-4525-bbc5-d424bba304f8)

![image](https://github.com/user-attachments/assets/d8def5ee-f503-4404-b004-a64a39f9c98a)

![image](https://github.com/user-attachments/assets/213a1bad-3d63-43ca-ba9a-ca65c048a1e4)


you should get by method getAllJavaDevelopers() => [Alex, Sam, Charlie] .
