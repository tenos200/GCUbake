 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


/*
 * This class will handle the users and who has permission for certain functuon 
 */

/**
 *
 * @author timenos , aadamrazak
 */
public class GCUuser{
    
    //Variables
    private String title;
    private String firstName;
    private String lastName;
    private int contactNo;
    
    private String ID; 
    private String username;
    private int passCode;
    private String gcuRole;

    
    GCUuser test = new GCUuser("Mr", "Aadam", "Razak", "testtest", 123, "CUSOMTER");
    public GCUuser(String title, String firstName, String lastName, String userName, int passCode,String gcuRole){
    
    }
    
    
    //Getters
    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        
        return lastName;
    }

    public int getContactNo() {
        
        return contactNo;
    }

    public String getID() {
        return ID;
    }


    public String getUsername() {
        return username;
    }

    public int getPassCode() {
        return passCode;
    }

    public String getGcuRole() {
        return gcuRole;
    }
//Setters**Check if you need all of them or some of them
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassCode(int passCode) {
        this.passCode = passCode;
    }

    public void setGcuRole(String gcuRole) {
        this.gcuRole = gcuRole;
    }
    
     
    
//Default Contructor
    GCUuser()
    {}
    
//overloaded Contructor
    
    public GCUuser(String pTitle, String pFirstName, String pLastName, int pContactNo, String pUsername, int pPassCode, String pGcuRole, String pID) 
{
        this.title = pTitle;
        this.firstName = pFirstName;
        this.lastName = pLastName;
        this.contactNo = pContactNo;
        this.ID=pID;
        this.username = pUsername;
        this.passCode = pPassCode;
        this.gcuRole = pGcuRole;
}
 
}//end of class






