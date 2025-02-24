import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class DBTest {
    public DBTest() {
    }

    public static boolean checkStub() {
        return true;
    }

    public static boolean isTypePresent(String typeName) {
        try {
            Class<?> clazz = Class.forName(typeName);
            return clazz.getName().equals(typeName);
        } catch (ClassNotFoundException var2) {
            return false;
        }
    }

    public static boolean isTypeClass(String typeName) {
        try {
            Class<?> clazz = Class.forName(typeName);
            return !Modifier.isAbstract(clazz.getModifiers()) && !Modifier.isInterface(clazz.getModifiers());
        } catch (ClassNotFoundException var2) {
            return false;
        }
    }

    public static boolean isMethodPresent(String typeName, String methodName, Class<?>[] parameterTypes, Class<?> parameterReturn) {
        try {
            Class<?> clazz = Class.forName(typeName);
            Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
            return Modifier.isPublic(method.getModifiers()) && parameterReturn.getName().equals(method.getReturnType().getName());
        } catch (NoSuchMethodException | ClassNotFoundException var6) {
            ReflectiveOperationException e = var6;
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static String getTemporaryDBName() {
        String timeTemplate = "ddHHmmss";
        String currentTime = (new SimpleDateFormat(timeTemplate)).format(new Date());
        return "MyDB" + currentTime;
    }

    public static boolean checkCreateConnection() {
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            Connection actual = myUtils.createConnection();
            result = actual != null;
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkCloseConnection() {
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            Connection actual = myUtils.createConnection();
            result = actual != null;
            myUtils.closeConnection();
            result = result && actual.isClosed();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkCreateStatement() {
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            Statement actual = myUtils.createStatement();
            result = actual != null;
            myUtils.closeStatement();
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkCloseStatement() {
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            Statement actual = myUtils.createStatement();
            result = actual != null;
            myUtils.closeStatement();
            actual.close();
            result = result && actual.isClosed();
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkCreateSchema() {
        String schemaName = getTemporaryDBName();

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean checkDropSchema() {
        String schemaName = getTemporaryDBName();

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.dropSchema();
            myUtils.createSchema(schemaName);
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean checkUseSchema() {
        String schemaName = getTemporaryDBName();

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return true;
        } catch (Exception var2) {
            return false;
        }
    }


    public static boolean checkCreateTableRoles() {
        String schemaName = getTemporaryDBName();
        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean checkCreateTableDirections() {
        String schemaName = getTemporaryDBName();

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableDirections();
            myUtils.dropTable("Directions");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean checkCreateTableProjects() {
        String schemaName = getTemporaryDBName();

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean checkCreateTableEmployees() {
        String schemaName = getTemporaryDBName();

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.createTableEmployees();
            myUtils.dropTable("Employees");
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean checkDropTable() {
        String schemaName = getTemporaryDBName();

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.dropTable("Roles");
            myUtils.createTableRoles();
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return true;
        } catch (Exception var2) {
            return false;
        }
    }

    public static boolean checkInsertTableRoles() {
        String schemaName = getTemporaryDBName();
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.insertTableRoles("Developer");
            result = myUtils.getRoleId("Developer") == 1;
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkInsertTableDirections() {
        String schemaName = getTemporaryDBName();
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableDirections();
            myUtils.insertTableDirections("Java");
            result = myUtils.getDirectionId("Java") == 1;
            myUtils.dropTable("Directions");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkInsertTableProjects() {
        String schemaName = getTemporaryDBName();
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.insertTableDirections("Java");
            myUtils.insertTableProjects("MoonLight", "Java");
            result = myUtils.getProjectId("MoonLight") == 1;
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkInsertTableEmployees() {
        String schemaName = getTemporaryDBName();
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.createTableEmployees();
            myUtils.insertTableRoles("Developer");
            myUtils.insertTableDirections("Java");
            myUtils.insertTableProjects("MoonLight", "Java");
            myUtils.insertTableEmployees("Alex", "Developer", "MoonLight");
            result = myUtils.getEmployeeId("Alex") == 1;
            myUtils.dropTable("Employees");
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkGetRoleId() {
        String schemaName = getTemporaryDBName();
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.insertTableRoles("Developer");
            myUtils.insertTableRoles("DevOps");
            result = myUtils.getRoleId("DevOps") == 2;
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkGetDirectionId() {
        String schemaName = getTemporaryDBName();
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableDirections();
            myUtils.insertTableDirections("Java");
            myUtils.insertTableDirections(".Net");
            result = myUtils.getDirectionId(".Net") == 2;
            myUtils.dropTable("Directions");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkGetProjectId() {
        String schemaName = getTemporaryDBName();
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.insertTableDirections("Java");
            myUtils.insertTableProjects("MoonLight", "Java");
            myUtils.insertTableProjects("Sun", "Java");
            result = myUtils.getProjectId("Sun") == 2;
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkGetEmployeeId() {
        String schemaName = getTemporaryDBName();
        boolean result = false;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.createTableEmployees();
            myUtils.insertTableRoles("Developer");
            myUtils.insertTableDirections("Java");
            myUtils.insertTableProjects("MoonLight", "Java");
            myUtils.insertTableEmployees("Alex", "Developer", "MoonLight");
            myUtils.insertTableEmployees("Charlie", "Developer", "MoonLight");
            result = myUtils.getEmployeeId("Charlie") == 2;
            myUtils.dropTable("Employees");
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
            return result;
        } catch (Exception var3) {
            return false;
        }
    }

    public static boolean checkGetAllRoles() {
        String schemaName = getTemporaryDBName();
        List<String> expected = Arrays.asList("DB", "DevOps", "Developer", "QC");
        List<String> actual = null;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.insertTableRoles("Developer");
            myUtils.insertTableRoles("DevOps");
            myUtils.insertTableRoles("QC");
            myUtils.insertTableRoles("DB");
            actual = myUtils.getAllRoles();
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
        } catch (Exception var4) {
            return false;
        }

        Collections.sort(actual);
        return actual != null && expected.equals(actual);
    }

    public static boolean checkGetAllDirections() {
        String schemaName = getTemporaryDBName();
        List<String> expected = Arrays.asList(".Net", "Java", "Python", "Ruby", "WebUI");
        List<String> actual = null;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableDirections();
            myUtils.insertTableDirections("Java");
            myUtils.insertTableDirections(".Net");
            myUtils.insertTableDirections("Python");
            myUtils.insertTableDirections("Ruby");
            myUtils.insertTableDirections("WebUI");
            actual = myUtils.getAllDirections();
            myUtils.dropTable("Directions");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
        } catch (Exception var4) {
            return false;
        }

        Collections.sort(actual);
        return actual != null && expected.equals(actual);
    }

    public static boolean checkGetAllProjects() {
        String schemaName = getTemporaryDBName();
        List<String> expected = Arrays.asList("Mars", "MoonLight", "Saturn", "Sun", "Venus");
        List<String> actual = null;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.insertTableDirections("Java");
            myUtils.insertTableProjects("MoonLight", "Java");
            myUtils.insertTableProjects("Sun", "Java");
            myUtils.insertTableProjects("Venus", "Java");
            myUtils.insertTableProjects("Mars", "Java");
            myUtils.insertTableProjects("Saturn", "Java");
            actual = myUtils.getAllProjects();
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
        } catch (Exception var4) {
            return false;
        }

        Collections.sort(actual);
        return actual != null && expected.equals(actual);
    }

    public static boolean checkGetAllEmployees() {
        String schemaName = getTemporaryDBName();
        List<String> expected = Arrays.asList("Alex", "Charlie", "Jordan", "Taylor");
        List<String> actual = null;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.createTableEmployees();
            myUtils.insertTableRoles("Developer");
            myUtils.insertTableDirections("Java");
            myUtils.insertTableProjects("MoonLight", "Java");
            myUtils.insertTableEmployees("Alex", "Developer", "MoonLight");
            myUtils.insertTableEmployees("Charlie", "Developer", "MoonLight");
            myUtils.insertTableEmployees("Jordan", "Developer", "MoonLight");
            myUtils.insertTableEmployees("Taylor", "Developer", "MoonLight");
            actual = myUtils.getAllEmployees();
            myUtils.dropTable("Employees");
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
        } catch (Exception var4) {
            return false;
        }

        Collections.sort(actual);
        return actual != null && expected.equals(actual);
    }

    public static boolean checkGetAllDevelopers() {
        String schemaName = getTemporaryDBName();
        List<String> expected = Arrays.asList("Alex", "Charlie", "Jordan", "Sam");
        List<String> actual = null;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.createTableEmployees();
            myUtils.insertTableRoles("Developer");
            myUtils.insertTableRoles("DevOps");
            myUtils.insertTableRoles("QC");
            myUtils.insertTableDirections("Java");
            myUtils.insertTableDirections("Python");
            myUtils.insertTableProjects("MoonLight", "Java");
            myUtils.insertTableProjects("Sun", "Java");
            myUtils.insertTableProjects("Mars", "Python");
            myUtils.insertTableEmployees("Alex", "Developer", "MoonLight");
            myUtils.insertTableEmployees("Charlie", "Developer", "Sun");
            myUtils.insertTableEmployees("Jordan", "Developer", "Mars");
            myUtils.insertTableEmployees("Taylor", "DevOps", "MoonLight");
            myUtils.insertTableEmployees("Morgan", "DevOps", "Mars");
            myUtils.insertTableEmployees("Sam", "Developer", "MoonLight");
            myUtils.insertTableEmployees("Anna", "QC", "MoonLight");
            myUtils.insertTableEmployees("Casey", "QC", "Sun");
            myUtils.insertTableEmployees("Jamie", "QC", "Mars");
            actual = myUtils.getAllDevelopers();
            myUtils.dropTable("Employees");
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
        } catch (Exception var4) {
            return false;
        }

        Collections.sort(actual);
        return actual != null && expected.equals(actual);
    }

    public static boolean checkGetAllJavaProjects() {
        String schemaName = getTemporaryDBName();
        List<String> expected = Arrays.asList("MoonLight", "Sun");
        List<String> actual = null;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.createTableEmployees();
            myUtils.insertTableRoles("Developer");
            myUtils.insertTableRoles("DevOps");
            myUtils.insertTableRoles("QC");
            myUtils.insertTableDirections("Java");
            myUtils.insertTableDirections("Python");
            myUtils.insertTableProjects("MoonLight", "Java");
            myUtils.insertTableProjects("Sun", "Java");
            myUtils.insertTableProjects("Mars", "Python");
            myUtils.insertTableEmployees("Alex", "Developer", "MoonLight");
            myUtils.insertTableEmployees("Charlie", "Developer", "Sun");
            myUtils.insertTableEmployees("Jordan", "Developer", "Mars");
            myUtils.insertTableEmployees("Taylor", "DevOps", "MoonLight");
            myUtils.insertTableEmployees("Morgan", "DevOps", "Mars");
            myUtils.insertTableEmployees("Sam", "Developer", "MoonLight");
            myUtils.insertTableEmployees("Anna", "QC", "MoonLight");
            myUtils.insertTableEmployees("Casey", "QC", "Sun");
            myUtils.insertTableEmployees("Jamie", "QC", "Mars");
            actual = myUtils.getAllJavaProjects();
            myUtils.dropTable("Employees");
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
        } catch (Exception var4) {
            return false;
        }

        Collections.sort(actual);
        return actual != null && expected.equals(actual);
    }

    public static boolean checkGetAllJavaDevelopers() {
        String schemaName = getTemporaryDBName();
        List<String> expected = Arrays.asList("Alex", "Charlie", "Sam");
        List<String> actual = null;

        try {
            MyUtils myUtils = new MyUtils();
            myUtils.createConnection();
            myUtils.createStatement();
            myUtils.createSchema(schemaName);
            myUtils.useSchema();
            myUtils.createTableRoles();
            myUtils.createTableDirections();
            myUtils.createTableProjects();
            myUtils.createTableEmployees();
            myUtils.insertTableRoles("Developer");
            myUtils.insertTableRoles("DevOps");
            myUtils.insertTableRoles("QC");
            myUtils.insertTableDirections("Java");
            myUtils.insertTableDirections("Python");
            myUtils.insertTableProjects("MoonLight", "Java");
            myUtils.insertTableProjects("Sun", "Java");
            myUtils.insertTableProjects("Mars", "Python");
            myUtils.insertTableEmployees("Alex", "Developer", "MoonLight");
            myUtils.insertTableEmployees("Charlie", "Developer", "Sun");
            myUtils.insertTableEmployees("Jordan", "Developer", "Mars");
            myUtils.insertTableEmployees("Taylor", "DevOps", "MoonLight");
            myUtils.insertTableEmployees("Morgan", "DevOps", "Mars");
            myUtils.insertTableEmployees("Sam", "Developer", "MoonLight");
            myUtils.insertTableEmployees("Anna", "QC", "MoonLight");
            myUtils.insertTableEmployees("Casey", "QC", "Sun");
            myUtils.insertTableEmployees("Jamie", "QC", "Mars");
            actual = myUtils.getAllJavaDevelopers();
            myUtils.dropTable("Employees");
            myUtils.dropTable("Projects");
            myUtils.dropTable("Directions");
            myUtils.dropTable("Roles");
            myUtils.dropSchema();
            myUtils.closeStatement();
            myUtils.closeConnection();
        } catch (Exception var4) {
            return false;
        }

        Collections.sort(actual);
        return actual != null && expected.equals(actual);
    }
}
