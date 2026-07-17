import java.sql.*;
import static java.lang.Class.forName;

public class Main {
    public static void main(String[] args) {
        Connection connection =null;
        Statement statement= null;

        try {
            connection = JdbcConnection.getJdbcConnection();
            statement = connection.createStatement();

            String sql = "INSERT INTO STUDENT(ID,NAME,AGE,CITY) VALUES(1,'Disha',17,'Nagpur')";
            int rows = statement.executeUpdate(sql);

            if (rows == 0) {
                System.out.println("Failed to enter Data");
            } else {
                System.out.println("Successfully Entered Data");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally
        {
            try {
                JdbcConnection.closeConnection(connection,statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}