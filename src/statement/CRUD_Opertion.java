package statement;

import connection.JdbcConnection;

import java.sql.*;

public class CRUD_Opertion {

    static {
        Connection con = null;
        Statement state = null;

        try {
            con = JdbcConnection.getJdbcConnection();
            state = con.createStatement();

            String sql = "SELECT * FROM STUDENT";
            boolean status = state.execute(sql);

            if (status) {
                ResultSet rs = state.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getInt("ID") + " " + rs.getString("NAME") + " "
                            + rs.getString("AGE") + " " + rs.getString("CITY"));
                }
                rs.close();
            } else {
                int rows = state.getUpdateCount();
                if (rows == 0) {
                    System.out.println("Operation failed");
                } else {
                    System.out.println("Operation successful");
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (state != null && con != null) {
                    JdbcConnection.closeConnection(con, state);
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
