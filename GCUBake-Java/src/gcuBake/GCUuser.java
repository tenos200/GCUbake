
/*
 * This class will handle the users and who has permission for certain functuon 
 */

/**
 *
 * @author timenos , aadamrazak
 */
public class GCUuser{
    
    //Variables
    private String John;
    private String title;
    private String firstName;
    private String lastName;
    private int contactNo;
    
    
    private String username;
    private int passCode;
    private String gcuRole;

    
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
    
    public GCUuser(String pTitle, String pFirstName, String pLastName, int pContactNo, String pUsername, int pPassCode, String pGcuRole) 
{
        this.title = pTitle;
        this.firstName = pFirstName;
        this.lastName = pLastName;
        this.contactNo = pContactNo;
        this.username = pUsername;
        this.passCode = pPassCode;
        this.gcuRole = pGcuRole;
}
 
    
//Methods
public void logInUser()
{}

private void Register()
{
	  /*Integrate this part with buttons from GUI so values are recieved I used the values from the overload constructor as inputs into the register database.
			

        try{
            //create my mysql database connection

            String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/GCUbake";
            String username = "root";
            String password = "";
            // get a connection(Step 1)
            Connection myConnection = DriverManager.getConnection(mysqlUrl,username,password);
            //Create a statement(Step 2)
            Statement myStatement = myConnection.createStatement();

            //execute query(step 3)
            String query = "insert into Customer (title, firstname, lastname, contactNo, username, passcode, gcuRole)" + "values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = myConnection.prepareStatement(query);
            preparedStmt.setString(1,pTitle);
            preparedStmt.setString(2,pFirstName);
            preparedStmt.setString(3,pLastName);
            preparedStmt.setInt(4,pContactNo);
            preparedStmt.setInt(5,pUsername);
            preparedStmt.setInt(6,pPassCode);
            preparedStmt.setInt(7,pGcuRole);
            preparedStmt.execute();

            myConnection.close();


        }
        catch (Exception e){

            System.err.println("Got an exception");
            System.err.println(e.getMessage());


        }*/










}


public void DeleteUser()
{

}



}//end of class






