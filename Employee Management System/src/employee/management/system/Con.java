package employee.management.system;
import java.sql.*;

public class Con {
    Connection c;
    Statement s;

    public Con(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Update connection URL with the correct port number and database name
            c = DriverManager.getConnection("jdbc:mysql://localhost:148/employeemanagementsystem", "root", "148Vaishali@");

            s = c.createStatement();
        } catch (Exception e) {
            // Print a more descriptive error message
            System.err.println("Error connecting to the database:");
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        // Instantiate the Con class to establish the connection
        Con con = new Con();
    }
}
