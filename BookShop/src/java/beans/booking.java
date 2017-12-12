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
public class booking {

    public booking() {
    }
    private int booking_id;
    private String StartDate;
    private String EndDate;
    private String Status;
    private String book;
    private String purpose;
    private int StaffNo;
    private String starttime;
    private String endtime;

    public booking(int booking_id, String StartDate, String EndDate, String Status, String book, String purpose, int StaffNo, String starttime, String endtime) {
        this.booking_id = booking_id;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Status = Status;
        this.book = book;
        this.purpose = purpose;
        this.StaffNo = StaffNo;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

 

    public int getStaffNo() {
        return StaffNo;
    }

    public void setStaffNo(int StaffNo) {
        this.StaffNo = StaffNo;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    
    
}