package statement;

import connection.JdbcConnection;

import java.sql.*;
import static java.lang.Class.forName;

public class DataDeletion{

    static {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = JdbcConnection.getJdbcConnection();
            statement = connection.createStatement();
            String sql = "DELETE FROM STUDENT WHERE ID = 1";
            int rows = statement.executeUpdate(sql);

            if (rows > 0) {
                System.out.println("Successfully deleted data");
            } else {
                System.out.println("Failed to delete");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcConnection.closeConnection(connection, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
