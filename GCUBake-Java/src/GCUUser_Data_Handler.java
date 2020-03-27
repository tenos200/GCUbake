
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * handles the data going through this to find the data between the sql and java for users
 */

/**
 *
 * @author Admin
 */
public class GCUUser_Data_Handler {
    Connection con;
    PreparedStatement pst;
    
    public GCUuser getValidUser(GCUuser pUser){
        //  boolean userExistsInDatabase = false;
        
        DB_Utils.isDatabaseDriversExist(); // check that ucanaccess drivers exist
    
         try 
            {
               
                
                ResultSet rs = pst.executeQuery ("SELECT * FROM user WHERE username='" + pUser.getUsername()+ "' AND " + " passcode =" + pUser.getPassCode());
               
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
    protected void createDatabase(){
        try{
        /*This method is essential for creating the database from the localhost if it does
            not already exists it provides the necessary means the database and tables required to
            be created.
            
            It should be noted that mysql-connector-java file needs to be attached to library
            and mysql needs to be running on machine.
            */
        
        String database = "jdbc:mysql://localhost/";
        String username = "root";
        String password = "Password";
        
        con = DriverManager.getConnection(database, username, password);
        
        String sql = "CREATE DATABASE IF NOT EXISTS GCUBake";
        
        pst = con.prepareStatement(sql);
        pst.execute();
        con.close();
        }
        
        catch(Exception e){
        System.err.println(e.getMessage());
        
        }
    
    
    }
    
    protected void startConnection(){
        
        try{
        /* The details below may need to be adjust in order to connect on the local machine.
            Mysql database in combination with the mysql-connector-java.jar (added to library) file will be required
            in order to provide full functionality to the program and its database.
            */
        String mysqlUrl = "jdbc:mysql://localhost/GCUBake";
        String username = "root";
        String password = "Password";
        con = DriverManager.getConnection(mysqlUrl, username, password);
        }
        catch(Exception e){
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        
        }

        }


        protected void createTables(){
            
            try{
            
            startConnection();
            
            //A backend method which creates the tables on the specified unit if it does not exist
            String createQuery1 = "CREATE TABLE IF NOT EXISTS User("
                 + "userID INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(userID),"
                 + "customerStatus TEXT,"
                 + "title TEXT,"
                 + "firstname TEXT,"
                 + "lastname TEXT,"
                 + "contactNo TEXT,"
                 + "email TEXT,"
                 + "username TEXT,"
                 + "password TEXT);";
            
         pst = con.prepareStatement(createQuery1);
         pst.execute();
         
         
         
         String createQuery2 = "CREATE TABLE IF NOT EXISTS Staff("
                 + "staffID INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(staffID),"
                 + "role TEXT,"
                 + "firstname TEXT,"
                 + "lastname TEXT,"
                 + "contactNo TEXT,"
                 + "email TEXT,"
                 + "username TEXT,"
                 + "password TEXT);";
         
         pst = con.prepareStatement(createQuery2);
         pst.execute();
         
         String createQuery3 = "CREATE TABLE IF NOT EXISTS Login("
                 + "loginID INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(loginID),"
                 + "username TEXT,"
                 + "password TEXT);";
         
         pst = con.prepareStatement(createQuery3);
         pst.execute();
         
         String createQuery4 = "CREATE TABLE IF NOT EXISTS Lessons("
                 + "lessonID INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(lessonID),"
                 + "lessonType TEXT,"
                 + "lessonSatus TEXT)";
 
         pst = con.prepareStatement(createQuery4);
         pst.execute();
         
         con.close();
         
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            
        
    
    }
        

public void DeleteUser()
{
    
    

}


}//end of class
