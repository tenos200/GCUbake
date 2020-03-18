
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * handles the data going through this to find the data between the sql and java
 */

/**
 *
 * @author Admin
 */
public class GCUUser_Data_Handler {
    Connection con = null;
    
    public GCUuser getValidUser(GCUuser pUser){
        //  boolean userExistsInDatabase = false;
        
        DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
    
         try 
            {
                Connection con=DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM user WHERE username='" + pUser.getUsername()+ "' AND " + " passcode =" + pUser.getPassCode());
               
                rs.next();//move to first record
                
                pUser.setID(rs.getString("ID"));
                pUser.setFirstName(rs.getString("firstname"));
                pUser.setLastName(rs.getString("lastname"));
                pUser.setPassCode(Integer.parseInt(rs.getString("passcode")));
                pUser.setGcuRole(rs.getString("role"));

            }
         catch(SQLException e)
            {
                System.out.println("getValidUser : Error");
                System.out.println("SQL exception occured" + e);
            }
     
    //==========================================================='  
        return pUser;
    }
    public boolean checkUserIsValid(GCUuser pUser){
        boolean userExistsInDatabase = false;
      
         try 
            {
                Connection con = DB_Utils.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery ("SELECT * FROM user WHERE username='" + pUser.getUsername()+ "' AND " + " passcode=" + pUser.getPassCode());
                while (rs.next()) 
                {        
                  userExistsInDatabase=true; // set if at least one record is found
                }
                
            }
         catch(SQLException ex)
            {
                System.out.println("checkUserIsValid : Error");
                System.out.println("SQL exception occured\n" + ex);
            }

    //==========================================================='  
    return (userExistsInDatabase);
    }
    
    public void connection(){
        
        try{
        String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/GCUbake";
        String username = "root";
        String password = "Password";
        con = DriverManager.getConnection(mysqlUrl ,username,password);
        }
        catch(Exception e){
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        
        
        }
        
        
    
    
    
    
    }

public void DeleteUser()
{
    
    

}


}//end of class
