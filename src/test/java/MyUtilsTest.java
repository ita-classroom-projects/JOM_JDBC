import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class MyUtilsTest {
    public static void main(String[] args) {

        String sb = "===== Checking MyUtils class presence =====\n" +
                "Class found: " + DBTest.isTypePresent("MyUtils") + "\n" +
                "Is it a class: " + DBTest.isTypeClass("MyUtils") + "\n\n" +
                "===== Checking method presence =====\n" +
                checkMethod("createConnection", new Class<?>[]{}, Connection.class) +
                checkMethod("closeConnection", new Class<?>[]{}, void.class) +
                checkMethod("createStatement", new Class<?>[]{}, Statement.class) +
                checkMethod("closeStatement", new Class<?>[]{}, void.class) +
                checkMethod("createSchema", new Class<?>[]{String.class}, void.class) +
                checkMethod("dropSchema", new Class<?>[]{}, void.class) +
                checkMethod("useSchema", new Class<?>[]{}, void.class) +
                checkMethod("createTableRoles", new Class<?>[]{}, void.class) +
                checkMethod("createTableDirections", new Class<?>[]{}, void.class) +
                checkMethod("createTableProjects", new Class<?>[]{}, void.class) +
                checkMethod("createTableEmployees", new Class<?>[]{}, void.class) +
                checkMethod("dropTable", new Class<?>[]{String.class}, void.class) +
                checkMethod("insertTableRoles", new Class<?>[]{String.class}, void.class) +
                checkMethod("insertTableDirections", new Class<?>[]{String.class}, void.class) +
                checkMethod("insertTableProjects", new Class<?>[]{String.class, String.class}, void.class) +
                checkMethod("insertTableEmployees", new Class<?>[]{String.class, String.class, String.class}, void.class) +
                checkMethod("getRoleId", new Class<?>[]{String.class}, int.class) +
                checkMethod("getDirectionId", new Class<?>[]{String.class}, int.class) +
                checkMethod("getProjectId", new Class<?>[]{String.class}, int.class) +
                checkMethod("getEmployeeId", new Class<?>[]{String.class}, int.class) +
                checkMethod("getAllRoles", new Class<?>[]{}, List.class) +
                checkMethod("getAllDirections", new Class<?>[]{}, List.class) +
                checkMethod("getAllProjects", new Class<?>[]{}, List.class) +
                checkMethod("getAllEmployees", new Class<?>[]{}, List.class) +
                checkMethod("getAllDevelopers", new Class<?>[]{}, List.class) +
                checkMethod("getAllJavaProjects", new Class<?>[]{}, List.class) +
                checkMethod("getAllJavaDevelopers", new Class<?>[]{}, List.class) +
                "\n" +
                "===== Checking method execution =====\n" +
                checkExecution("createConnection", DBTest.checkCreateConnection()) +
                checkExecution("closeConnection", DBTest.checkCloseConnection()) +
                checkExecution("createStatement", DBTest.checkCreateStatement()) +
                checkExecution("closeStatement", DBTest.checkCloseStatement()) +
                checkExecution("createSchema", DBTest.checkCreateSchema()) +
                checkExecution("dropSchema", DBTest.checkDropSchema()) +
                checkExecution("useSchema", DBTest.checkUseSchema()) +
                "\n" +
                "===== Checking table creation =====\n" +
                checkExecution("createTableRoles", DBTest.checkCreateTableRoles()) +
                checkExecution("createTableDirections", DBTest.checkCreateTableDirections()) +
                checkExecution("createTableProjects", DBTest.checkCreateTableProjects()) +
                checkExecution("createTableEmployees", DBTest.checkCreateTableEmployees()) +
                "\n" +
                "===== Checking data insertion =====\n" +
                checkExecution("insertTableRoles", DBTest.checkInsertTableRoles()) +
                checkExecution("insertTableDirections", DBTest.checkInsertTableDirections()) +
                checkExecution("insertTableProjects", DBTest.checkInsertTableProjects()) +
                checkExecution("insertTableEmployees", DBTest.checkInsertTableEmployees()) +
                "\n" +
                "===== Checking ID retrieval =====\n" +
                checkExecution("getRoleId", DBTest.checkGetRoleId()) +
                checkExecution("getDirectionId", DBTest.checkGetDirectionId()) +
                checkExecution("getProjectId", DBTest.checkGetProjectId()) +
                checkExecution("getEmployeeId", DBTest.checkGetEmployeeId()) +
                "\n" +
                "===== Checking data retrieval =====\n" +
                checkExecution("getAllRoles", DBTest.checkGetAllRoles()) +
                checkExecution("getAllDirections", DBTest.checkGetAllDirections()) +
                checkExecution("getAllProjects", DBTest.checkGetAllProjects()) +
                checkExecution("getAllEmployees", DBTest.checkGetAllEmployees()) +
                checkExecution("getAllDevelopers", DBTest.checkGetAllDevelopers()) +
                checkExecution("getAllJavaProjects", DBTest.checkGetAllJavaProjects()) +
                checkExecution("getAllJavaDevelopers", DBTest.checkGetAllJavaDevelopers());

        System.out.println(sb);
    }

    /**
     * Helper method to check if a method is present in the class.
     */
    private static String checkMethod(String methodName, Class<?>[] parameters, Class<?> returnType) {
        return String.format("%-30s -> %s%n", methodName,
                DBTest.isMethodPresent("MyUtils", methodName, parameters, returnType) ? "✔ Present" : "✘ Missing");
    }

    /**
     * Helper method to check if a test execution is successful.
     */
    private static String checkExecution(String testName, boolean result) {
        return String.format("%-30s -> %s%n", testName, result ? "✔ Passed" : "✘ Failed");
    }
}
