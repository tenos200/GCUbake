/*
 * This is class that will have the functions of the lessons
This class will link to others to gather data between each other
 */

/**
 *
 * @author timenos, aadamrazak
 */
public class GCULessons {
    
    private String type;
    private String lessonID;
    private String name;
    private String status;

    
    //Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLessonID() {
        return lessonID;
    }

    public void setLessonID(String lessonID) {
        this.lessonID = lessonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    //contructor 

     GCULessons() 
     {}

    public GCULessons(String type, String lessonID, String name, String status) {
        this.type = type;
        this.lessonID = lessonID;
        this.name = name;
        this.status = status;
    }
    
     
    
    
}
