import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "yourUsername";
        String password = "yourPassword";
        String selectedDB = request.getParameter("selectedDB");

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://10.12.1.34/" + selectedDB;
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

    private void doUnitWork() {
        // Your logic here
        System.out.println("Doing unit work...");
    }
}
