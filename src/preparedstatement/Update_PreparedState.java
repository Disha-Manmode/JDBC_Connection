package preparedstatement;

import connection.JdbcConnection;

import java.sql.*;
import java.util.Scanner;

public class Update_PreparedState {

    static{

        Connection con=null;
        PreparedStatement pstate=null;

        try{
            con= JdbcConnection.getJdbcConnection();
            String query="UPDATE STUDENT SET AGE=? WHERE ID=?";
            pstate =con.prepareStatement(query);

            System.out.println("Enter Id for updation");
            Scanner sc= new Scanner(System.in);
            int id=sc.nextInt();

            System.out.println("Enter Age");
            int age= sc.nextInt();

            pstate.setInt(2,id);
            pstate.setInt(1,age);

            int rows=pstate.executeUpdate();
            if(rows>0){
                System.out.println("Successfully updated data");
            }
            else{
                System.out.println("Failed to update data");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                JdbcConnection.closeConnection(con,pstate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
