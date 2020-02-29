

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
                Connection con=DB_Utils.getConnection();
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
    
    
    
//    private void Register()
//{
//	  /*Integrate this part with buttons from GUI so values are recieved I used the values from the overload constructor as inputs into the register database.
//			*/
//
//        try{
//
//            //create my mysql database connection
//
//            String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/GCUbake";
//            String username = "root";
//            String password = "";
//            // get a connection(Step 1)
//            Connection myConnection = DriverManager.getConnection(mysqlUrl,username,password);
//            //Create a statement(Step 2)
//            Statement myStatement = myConnection.createStatement();
//
//            //execute query(step 3)
//            String query = "insert into Customer (title, firstname, lastname, contactNo, username, passcode, gcuRole)" + "values (?, ?, ?, ?, ?, ?, ?)";
//
//            PreparedStatement preparedStmt = myConnection.prepareStatement(query);
//            preparedStmt.setString(1,pTitle);
//            preparedStmt.setString(2,pFirstName);
//            preparedStmt.setString(3,pLastName);
//            preparedStmt.setInt(4,pContactNo);
//            preparedStmt.setInt(5,pUsername);
//            preparedStmt.setInt(6,pPassCode);
//            preparedStmt.setInt(7,pGcuRole);
//            preparedStmt.execute();
//
//            myConnection.close();
//
//        }
//        catch (Exception e){
//
//            System.err.println("Got an exception");
//            System.err.println(e.getMessage());
//
//
//        }
//}


public void DeleteUser()
{

}


}//end of class
