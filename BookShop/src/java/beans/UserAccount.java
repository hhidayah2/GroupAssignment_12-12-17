/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author hisham
 */
public class UserAccount {
 
   public static final String GENDER_MALE ="M";
   public static final String GENDER_FEMALE = "F";
    
   private String userName;
   private String position;
   private String password;
   private int adminId;
   private String name;
   private int StaffNo;
   private String Icnumber;
   private int PhoneNumber;
   private String email;
 
 
    
 
   public UserAccount() {
        
   }
    
   public String getUserName() {
       return userName;
   }
 
   public void setUserName(String userName) {
       this.userName = userName;
   }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
 
  
 
   public String getPassword() {
       return password;
   }
 
   public void setPassword(String password) {
       this.password = password;
   }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStaffNo() {
        return StaffNo;
    }

    public void setStaffNo(int StaffNo) {
        this.StaffNo = StaffNo;
    }

   
    public String getIcnumber() {
        return Icnumber;
    }

    public void setIcnumber(String Icnumber) {
        this.Icnumber = Icnumber;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   


 
}