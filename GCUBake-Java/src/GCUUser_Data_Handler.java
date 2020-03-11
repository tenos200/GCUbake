
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
    
    
    //Other methods
    
public void Register(GCUuser test)
{
	  /*Integrate this part with buttons from GUI so values are recieved I used the values from the overload constructor as inputs into the register database.
			*/

        try{
            //create my mysql database connection
            
            /*
            create my mysql database connection
						use this code for conneciton
            String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/GCUbake"; modify required database url for your machine
            String username = "root";
            String password = "";
            
            // get a connection(Step 1)
            con = DriverManager.getConnection(mysqlUrl,username,password);
            */
            
            Connection con = DB_Utils.getConnection();
            Statement stmt = con.createStatement();
            // get a connection(Step 1)
            
            //Create a statement(Step 2)
            
            String customerDefault = "defautl Customer";

            //execute query(step 3)
            String query = "INSERT INTO user (Title, firstname, lastname, username, passcode, role)" + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,test.getTitle());
            preparedStmt.setString(2,test.getFirstName());
            preparedStmt.setString(3,test.getLastName());
            preparedStmt.setInt(4,test.getContactNo());
            preparedStmt.setString(5,test.getUsername());
            preparedStmt.setInt(6,test.getPassCode());
            preparedStmt.setString(6,customerDefault);
            preparedStmt.execute();
            con.close();
            
            /*
            try{

            //create my mysql database connection

            String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/GCUbake";
            String username = "root";
            String password = "abc123";
            // get a connection(Step 1)
            con = DriverManager.getConnection(mysqlUrl,username,password);
            //Create a statement(Step 2)
            String query = "insert into Customer (title, firstname, lastname, contactNo, email, username, password)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            pst = con.prepareStatement(query);
            //execute query(step 3)

            pst.setString(1,cmdGender.getSelectedItem().toString());
            pst.setString(2,txtFirstname.getText());
            pst.setString(3,txtLastname.getText());
            pst.setString(4,txtPhone.getText());
            pst.setString(5,txtEmail.getText());
            pst.setString(6,txtUsername.getText());
            pst.setString(7,txtPassword.getText());

            pst.execute();

            con.close();

        }
        catch (Exception e){

            System.err.println("Got an exception");
            System.err.println(e.getMessage());

        }
        
            
            */


        }
        catch (Exception e){

            System.err.println("Got an exception");
          System.err.println(e.getMessage());


        }

}

public void DeleteUser()
{
    
    

}


}//end of class
