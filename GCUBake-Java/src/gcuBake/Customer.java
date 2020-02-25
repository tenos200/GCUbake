/*
 * This class will handle customers request 
* such as booking and canceling lessons
 */

/**
 *
 * @author timenos , aadamrazak
 */
public class Customer {
    
    //variables
    private String userProgress;
    private int custID;

    Customer(){}
    
    public Customer(String pUserProgress, int pCustID) {
        this.userProgress = pUserProgress;
        this.custID = pCustID;
    }
    
    public String getUserProgress() {
        return userProgress;
    }

    public void setUserProgress(String userProgress) {
        this.userProgress = userProgress;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    
    //Methods
    public void bookLesson()
    {}
    
    public void cancelLesson()
    {}
    
    
    
    
    
}//End of class
