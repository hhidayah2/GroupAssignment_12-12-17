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
public class spacemanager {
    private String name;
    private int phonenumber;
    private String email;
    private String username;
    private int staffno;

    public spacemanager() {
    }

    
    
    public spacemanager(String name, int phonenumber, String email, String username, int staffno) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.username = username;
        this.staffno = staffno;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStaffno() {
        return staffno;
    }

    public void setStaffno(int staffno) {
        this.staffno = staffno;
    }
    
    
    
}
