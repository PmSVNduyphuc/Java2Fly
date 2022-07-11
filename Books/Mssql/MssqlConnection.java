package Books.Mssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MssqlConnection {
    public static Connection getMssqlConnection() throws SQLException{
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=JAVA2";
        String UserName ="sa";
        String PassWord = "sa";
        Connection connection = DriverManager.getConnection(dbURL,UserName,PassWord);
        return connection;
    }
}