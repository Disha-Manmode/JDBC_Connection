package preparedstatement;

import connection.JdbcConnection;

import java.sql.*;
public class Retrieve_PreparedState {
        static {
            Connection con = null;
            PreparedStatement pstate = null;
            ResultSet rs=null;
            try {
                con = JdbcConnection.getJdbcConnection();
                String query= "SELECT * FROM STUDENT";
                pstate = con.prepareStatement(query);

                rs= pstate.executeQuery();

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
                    if (pstate != null && con != null)
                    {
                        JdbcConnection.closeConnection(con,pstate);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }


