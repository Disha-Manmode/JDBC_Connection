package preparedstatement;

import connection.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Deletion_PreparedState {

    static {
        Connection con = null;
        PreparedStatement pstate = null;

        try {
           con = JdbcConnection.getJdbcConnection();
           String query="DELETE FROM STUDENT WHERE ID=?";
           pstate =con.prepareStatement(query);

            System.out.println("Enter id to delete data");
            Scanner sc=new Scanner(System.in);
            int id=sc.nextInt();

            pstate.setInt(1,id);

            int rows=pstate.executeUpdate();

            if(rows > 0){
                System.out.println("Successfully Deleted Data");
            }
            else{
                System.out.println("Failed to delete");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                JdbcConnection.closeConnection(con,pstate);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
