import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static void main(String[] args) {
        // Dummy values for demonstration purposes
        String username = "yourUsername";
        String password = "yourPassword";
        // Assuming you have a method to get the "selectedDB" parameter
        String selectedDB = getSelectedDB();

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://10.12.1.34/" + selectedDB; //XXX
            conn = DriverManager.getConnection(url, username, password);
            doUnitWork();
        } catch (ClassNotFoundException cnfe) {
            // Handle ClassNotFoundException
            cnfe.printStackTrace();
        } catch (SQLException se) {
            // Handle SQLException
            se.printStackTrace();
        } catch (InstantiationException ie) {
            // Handle InstantiationException
            ie.printStackTrace();
        } catch (IllegalAccessException iae) {
            // Handle IllegalAccessException
            iae.printStackTrace();
        } finally {
            // Manage connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    // Dummy method for demonstration purposes
    private static String getSelectedDB() {
        return "sampleDB";
    }

    // Dummy method for demonstration purposes
    private static void doUnitWork() {
        // Your logic here
        System.out.println("Doing unit work...");
    }
}
