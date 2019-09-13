
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mitrajit
 */
public class DatabaseConnection {
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver",DB_URL = "jdbc:mysql://localhost:3306/Attendance";
    public static Connection Connect(String USER,String PASS)
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            Connection con=DriverManager.getConnection(DB_URL, USER, PASS);
            return con;
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
                 
    }
    
}
