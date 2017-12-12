/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author hayatihidayah
 */
public class technician {
    private int techid;
    private String name;
    private int techno;

    public technician() {
    }

    public technician(int techid, String name, int techno) {
        this.techid = techid;
        this.name = name;
        this.techno = techno;
    }

    public int getTechid() {
        return techid;
    }

    public void setTechid(int techid) {
        this.techid = techid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTechno() {
        return techno;
    }

    public void setTechno(int techno) {
        this.techno = techno;
    }
    
}
