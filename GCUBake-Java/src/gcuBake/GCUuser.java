
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
    
    
    //Not need this only for run class
//    public static void main(String[]args){
//        
//
//
//
//}
    
    
//Default Contructor
    GCUuser()
    {
        
        }
    
//overloaded Contructor
    
    public GCUuser(String pTitle, String pFirstName, String pLastName, int pContactNo, String pUsername, int pPassCode, String pGcuRole) {
        this.title = pTitle;
        this.firstName = pFirstName;
        this.lastName = pLastName;
        this.contactNo = pContactNo;
        this.username = pUsername;
        this.passCode = pPassCode;
        this.gcuRole = pGcuRole;
    }
    

public GCUuser(){

    
//Methods
public void logIn()
{
        
        }

public void Register()

{
    //add database connection here

    /*String
        
        }


}

private void register(){



}

private gcuRole(){



	return role;
}
=======
public void DeleteUser()
{

}


private void setFirstname(){


}

private void setLastname(){





}
  
private void setContactno(){


}
    



private void setTitle(){


}


private void setUsername(){


}
private void loginUser(){



}

}//end of class



}


