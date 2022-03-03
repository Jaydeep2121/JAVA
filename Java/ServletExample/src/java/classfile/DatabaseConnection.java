package classfile;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    static String dbdriver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/mca5";
    public static Connection initializeDatabase() throws ClassNotFoundException, SQLException{
        Class.forName(dbdriver);
        Connection con=DriverManager.getConnection(url,"root","");
        return con;
    }
    public void closeConnection() throws ClassNotFoundException, SQLException{
        Class.forName(dbdriver);
        Connection con=DriverManager.getConnection(url,"root","");
        con.close();
    }
}
