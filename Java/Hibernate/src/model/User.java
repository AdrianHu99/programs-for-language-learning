package model;

import java.util.*;

public class User {
	
	//basic information of the database
	private int userid;
    private String firstName;
    private String lastName;
    private Date time;
    private String emailaddress;
    
    //userid operations
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
  //firstname operations
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
  //lastname operations
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
  //time operations
    public Date gettime() {
        return time;
    }
    public void settime(Date time) {
        this.time = time;
    }
    
  //email operations
    public String getEmail() {
        return emailaddress;
    }
    public void setEmail(String email) {
        this.emailaddress = email;
    }
    
    
    @Override
    public String toString() {
        return "This user's userid is " + userid + ", firstName is " + firstName
                + ", lastName is " + lastName + ", time is " + time + ", email is "
                + emailaddress + ".";
    }
}
