package auth;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        System.err.println("App started");

        // Database credentials
        String url = "jdbc:mysql://localhost:3306/users"; // Ensure this database exists
        String username = "root";  // Change to your MySQL username
        String password = "root";  // Change to your MySQL password

        // Initialize connection object
        Connection connection = null;

        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // load the driver

            // Create a connection to the database
            connection = DriverManager.getConnection(url, username, password); // driver manager is a class to manage the connection
            Statement statement = connection.createStatement();
            System.out.println("Connection to the database successful!");
            String inserQuery = "INSERT INTO user (useName, firstName) VALUES ('john_doe', 'John')";
            statement.executeUpdate(inserQuery);
            // Test query: Fetch current date from the database
            String query="Select * from user";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {  // Iterate through each row
                System.out.println("ID: " + resultSet.getInt(1));  // Use getInt() for integer columns
                System.out.println("Username: " + resultSet.getString(2));
                System.out.println("First Name: " + resultSet.getString(3));
                System.out.println("----------------------");  // Separator for readability
            }
           
            

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } finally {
            // Close the connection when done
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.err.println("Error while closing connection: " + e.getMessage());
            }
        }
    }
}

/**
  instructions how to set up the project
  1.download the eclipse
  2.download the sql connecter jar file.
  3.create the simple java project 
  4.configure the jar into our project-> right click on project select  the properties click on the library-> click on the classpath->on right side option click on add external jar file add the file.
 */




