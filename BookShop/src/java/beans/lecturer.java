/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author user
 */
public class lecturer {
    
    private String name;
    private int StaffNo;

    private String Username;
    private String Icnumber;
    private int PhoneNumber;
    private String email;

    
    public lecturer() {
    }

    public lecturer(String name, int StaffNo, String Username, String Icnumber, int PhoneNumber, String email) {
        this.name = name;
        this.StaffNo = StaffNo;
        this.Username = Username;
        this.Icnumber = Icnumber;
        this.PhoneNumber = PhoneNumber;
        this.email = email;
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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
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


}
