package statement;

import connection.JdbcConnection;

import java.sql.*;

public class DataRetrieve {

    static {
        Connection con = null;
        Statement state = null;
        ResultSet rs=null;
        try {
            con = JdbcConnection.getJdbcConnection();
            state = con.createStatement();

            String sql= "SELECT * FROM STUDENT";
            rs= state.executeQuery(sql);

            while(rs.next())
            {
                System.out.println(rs.getInt("ID")+" "+rs.getString("NAME")+" "+rs.getInt("AGE")+" "+rs.getString("CITY"));
            }
            rs.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                if (rs != null)
                {
                    rs.close();
                }
                if (state != null && con != null)
                {
                    JdbcConnection.closeConnection(con,state);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
