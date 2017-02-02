
package married;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
    
    connection()
    {
         try {
                String driver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost/married";
                Class.forName(driver);
                Connection conn = DriverManager.getConnection(myUrl, "root", "");
                System.out.println("Connected\n");       
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
    }
    
}
