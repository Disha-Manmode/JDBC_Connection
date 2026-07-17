package preparedstatement;

import connection.JdbcConnection;

import java.sql.*;
import java.util.Scanner;

public class Insertion_PreparedState {

    static {

        Connection con = null;
        PreparedStatement pstate = null;

        try {
            con = JdbcConnection.getJdbcConnection();
            String query="INSERT INTO STUDENT(ID,NAME,AGE,CITY) VALUES(?,?,?,?)";
            pstate =con.prepareStatement(query);

            System.out.println("Enter following data to store into Database");
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter ID");
            int id=sc.nextInt();

            System.out.println("Enter Name");
            String name=sc.next();

            System.out.println("Enter Age");
            int age=sc.nextInt();

            System.out.println("Enter City");
            String city=sc.next();

            pstate.setInt(1,id);
            pstate.setString(2,name);
            pstate.setInt(3,age);
            pstate.setString(4,city);

            int rows=pstate.executeUpdate();

            if(rows ==0){
                System.out.println("Failed to insert");
            }
            else{
                System.out.println("Successfully Entered Data");
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
