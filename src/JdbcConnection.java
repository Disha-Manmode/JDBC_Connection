import java.sql.*;

public class JdbcConnection {

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getJdbcConnection() throws SQLException {
        Connection con=null;
        Statement state=null;

        String url="jdbc:mysql://localhost:3306/DATA_STUDENT";
        String user="root";
        String password="MySql@20122004";

        con=DriverManager.getConnection(url,user,password);
        return con;
    }

    public static void closeConnection(Connection con, Statement state) throws SQLException {

        state.close();
        con.close();
    }
}
