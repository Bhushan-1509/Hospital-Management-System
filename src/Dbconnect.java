import java.sql.*;

public class Dbconnect {
    public static Connection dbConnect() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection cn = null;
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false", "root", "");
        return cn;

    }

}
