package preparedstatement;

import connection.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchUpdate {
    static{
        Connection con=null;
        PreparedStatement pstate=null;
        ResultSet rs=null;

        try{
            con= JdbcConnection.getJdbcConnection();
            String query="INSERT INTO STUDENT(ID,NAME,AGE,CITY) VALUES(?,?,?,?)";
            pstate =con.prepareStatement(query);

            System.out.println("Enter following data to store into Database");
            Scanner sc = new Scanner(System.in);

            for(int i=1;i<=2;i++)
            {
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

                pstate.addBatch();
            }

            int[] rows=pstate.executeBatch();

            String select = "SELECT * FROM STUDENT";

            PreparedStatement ps = con.prepareStatement(select);

            rs = ps.executeQuery();
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("ID") + " " +
                                rs.getString("NAME") + " " +
                                rs.getInt("AGE") + " " +
                                rs.getString("CITY")
                );
            }

            rs.close();
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
