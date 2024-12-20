/*
 * This class provides a database connection using the Singleton pattern.
 * It ensures that only one connection instance is created and reused.
 */

package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    // Static variable to hold the single instance of the Connection
    private static Connection con = null;

    // Private constructor to prevent instantiation from outside the class
    private ConnectionProvider() {}

    // Public method to provide access to the single Connection instance
    public static Connection getCon() {
        try {
            // Check if the connection is null (i.e., not yet created)
            if (con == null) {
                // Load the SQL Server JDBC driver
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                // Establish the connection to the database
                con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=InventoryDB", 
                    "sa", 
                    "123456789"
                );
            }
            // Return the single instance of the connection
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            // Handle any exceptions that occur during connection creation
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
