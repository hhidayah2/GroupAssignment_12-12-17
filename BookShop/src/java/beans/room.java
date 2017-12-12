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
public class room {
    private int roomId;
    private String roomType;
    private String roomName;
    private String capacity;
    private String facility;
    private String pic;

    public room() {
    }

    
    public room(int roomId, String roomType, String roomName, String capacity, String facility, String pic) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomName = roomName;
        this.capacity = capacity;
        this.facility = facility;
        this.pic = pic;
    }

    
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

  

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }
    
}
