/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author user
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


 
import beans.Product;
import beans.UserAccount;
import beans.lecturer;
import beans.booking;
import beans.room;
import beans.spacemanager;
import beans.admin;
import beans.technician;
 
public class DBUtils {
 
    public static UserAccount findUser(Connection conn, //
            String userName, String password) throws SQLException {
 
        String sql = "Select a.username, a.password, a.position from user a " //
                + " where a.username = ? and a.password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        int adminId;
        String email;
        String name;
        int staffno;
        String icnumber;
        int phonenumber;

        if (rs.next()) {
            String position = rs.getString("position");
                if(position.equals("admin"))  //insert info for admin
                {
                    String sql1 = "Select * from admin a " //
                    + " where a.user_name = ? ";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, userName);
                    ResultSet rs1 = pstm1.executeQuery();
                    while(rs1.next())
                    {
                        adminId=rs1.getInt("admin_id");
                        name=rs1.getString("name");
                        UserAccount user = new UserAccount();
                    user.setUserName(userName);
                    user.setPassword(password);
                    user.setPosition(position);
                    user.setName(name);
                    return user;
                    }  //end while
                } // end if(for admin)
                if(position.equals("spacemanager"))  //insert info for spacemanager
                {
                    String sql1 = "Select * from spacemanager a " //
                    + " where a.username = ? ";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, userName);
                    ResultSet rs1 = pstm1.executeQuery();
                    while(rs1.next())
                    {
                      
                        name=rs1.getString("name");
                        phonenumber=rs1.getInt("phonenumber");
                        email=rs1.getString("email");
                     staffno=rs1.getInt("staffno");
                        UserAccount user = new UserAccount();
                    user.setUserName(userName);
                    user.setPassword(password);
                    user.setPosition(position);
                    user.setName(name);
                    user.setEmail(email);
                    user.setStaffNo(staffno);
                    user.setPhoneNumber(phonenumber);
                    return user;
                    }  //end while
                } // end if(for spacemanager)
                if(position.equals("lecturer"))  //insert info for lect
                {
               
                    String sql1 = "Select * from lecturer a " //
                            + " where a.username = ? ";
                    PreparedStatement pstm1 = conn.prepareStatement(sql1);
                    pstm1.setString(1, userName);
                    ResultSet rs1 = pstm1.executeQuery();
                    while(rs1.next())
                    {
                      
                        name=rs1.getString("name");
                        staffno=rs1.getInt("staffNo");
                        icnumber=rs1.getString("IcNumber");
                        UserAccount user = new UserAccount();
                        user.setUserName(userName);
                        user.setPassword(password);
                        user.setPosition(position);
                        user.setName(name);
                        user.setStaffNo(staffno);
                        user.setPhoneNumber(rs1.getInt("phonenumber"));
                        user.setEmail(rs1.getString("email"));
                        user.setIcnumber(rs1.getString("IcNumber"));
                        return user;
                    }  //end while
            } // end if(for lect)
          
           
        }
        return null;
    }
 
    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select a.username, a.password, a.position from user a "//
                + " where a.username = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("password");
            String position = rs.getString("position");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setPosition(position);
            return user;
        }
        return null;
    }
 
    public static List<lecturer> queryProduct(Connection conn) throws SQLException {
        String sql = "Select  staffNo,name,phonenumber, email, username,IcNumber from lecturer";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<lecturer> list = new ArrayList<lecturer>();
        while (rs.next()) {
         
            String name = rs.getString("name");
            String email=rs.getString("email");
        
            lecturer product = new lecturer();
            product.setStaffNo(rs.getInt("staffNo"));
            product.setName(rs.getString("name"));
            product.setEmail(rs.getString("email"));
            product.setUsername(rs.getString("username"));
            product.setIcnumber(rs.getString("IcNumber"));
            product.setPhoneNumber(rs.getInt("phonenumber"));
           
            list.add(product);
        }
        return list;
    }
    
    //query all spacemanger
    public static List<spacemanager> querySpacemanager(Connection conn) throws SQLException {
        String sql = "Select  name,phonenumber,email, username,staffno from spacemanager";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<spacemanager> list = new ArrayList<spacemanager>();
        while (rs.next()) {
            spacemanager product = new spacemanager();
            product.setName(rs.getString("name"));
            product.setPhonenumber(rs.getInt("phonenumber"));
            product.setEmail(rs.getString("email"));
            product.setUsername(rs.getString("username"));
            product.setStaffno(rs.getInt("staffno"));
            list.add(product);
        }
        return list;
    }
    
     //query all admin
    public static List<admin> queryadmin(Connection conn) throws SQLException {
        String sql = "Select  admin_id,name,user_name from admin";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<admin> list = new ArrayList<admin>();
        while (rs.next()) {
            admin product = new admin();
            product.setName(rs.getString("name"));
            product.setUsername(rs.getString("user_name"));
            product.setAdminId(rs.getInt("admin_id"));
            list.add(product);
        }
        return list;
    }
    
     public static List<booking> queryBooking(Connection conn, String room, String date) throws SQLException {
        
         String sql = "Select a.booking_id, a.StartDate, a.EndDate, a.Status, a.book, a.purpose, a.staffno, a.starttime, a.endtime from booking a where book = ? and StartDate = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, room);
        pstm.setString(2,date);
        ResultSet rs = pstm.executeQuery();
        List<booking> list = new ArrayList<booking>();
        while (rs.next()) {
            booking product = new booking();
           product.setBook(rs.getString("book"));
           product.setBooking_id(rs.getInt("booking_id"));
           product.setEndDate(rs.getString("EndDate"));
           product.setPurpose(rs.getString("purpose"));
           product.setStaffNo(rs.getInt("staffno"));
           product.setStartDate(rs.getString("StartDate"));
           product.setStatus(rs.getString("Status"));
           product.setEndtime(rs.getString("endtime"));
           product.setStarttime(rs.getString("starttime"));
           
            list.add(product);
        }
        return list;
    }
     
     //search booking
     public static List<booking> searchbooking(Connection conn,String room,String sd,String st) throws SQLException {
        
         String sql = "Select a.booking_id, a.StartDate, a.EndDate, a.Status, a.book, a.purpose, a.staffno, a.starttime, a.endtime from booking a where book = ? and StartDate = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, room);
        pstm.setString(2,sd);
        ResultSet rs = pstm.executeQuery();
        List<booking> list = new ArrayList<booking>();
        while (rs.next()) {
            booking product = new booking();
           product.setBook(rs.getString("book"));
           product.setBooking_id(rs.getInt("booking_id"));
           product.setEndDate(rs.getString("EndDate"));
           product.setPurpose(rs.getString("purpose"));
           product.setStaffNo(rs.getInt("staffno"));
           product.setStartDate(rs.getString("StartDate"));
           product.setStatus(rs.getString("Status"));
           product.setEndtime(rs.getString("endtime"));
           product.setStarttime(rs.getString("starttime"));
           
            list.add(product);
        }
        return list;
    }
     
          public static List<booking> queryBooking(Connection conn,int staffno) throws SQLException {
        
         String sql = "Select booking_id, StartDate,EndDate,Status, book, purpose, staffno, starttime, endtime from booking where staffno=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,staffno);
        ResultSet rs = pstm.executeQuery();
        List<booking> list = new ArrayList<booking>();
        while (rs.next()) {
            booking product = new booking();
           product.setBook(rs.getString("book"));
           product.setBooking_id(rs.getInt("booking_id"));
           product.setEndDate(rs.getString("EndDate"));
           product.setPurpose(rs.getString("purpose"));
           product.setStaffNo(rs.getInt("staffno"));
           product.setStartDate(rs.getString("StartDate"));
           product.setStatus(rs.getString("Status"));
           product.setEndtime(rs.getString("endtime"));
           product.setStarttime(rs.getString("starttime"));
           
            list.add(product);
        }
        return list;
    }
    
          //query all aprroved 
      public static List<booking> queryBooking(Connection conn,int staffno,String terima) throws SQLException {
        
         String sql = "Select booking_id, StartDate,EndDate, book, purpose, staffno, starttime, endtime from booking where staffno=? and Status=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,staffno);
        pstm.setString(2,terima);
        ResultSet rs = pstm.executeQuery();
        List<booking> list = new ArrayList<booking>();
        while (rs.next()) {
            booking product = new booking();
           product.setBook(rs.getString("book"));
           product.setBooking_id(rs.getInt("booking_id"));
           product.setEndDate(rs.getString("EndDate"));
           product.setPurpose(rs.getString("purpose"));
           product.setStaffNo(rs.getInt("staffno"));
           product.setStartDate(rs.getString("StartDate"));
           product.setEndtime(rs.getString("endtime"));
           product.setStarttime(rs.getString("starttime"));
           
            list.add(product);
        }
        return list;
    }    
      
      //count how much approved
      public static int queryBooking(Connection conn,int staffno,int total) throws SQLException {
        
         String sql = "Select count(booking_id) from booking where staffno=? and Status= ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,staffno);
        pstm.setString(2,"approved");
        ResultSet rs = pstm.executeQuery();
    
        while (rs.next()) {
        
        total= rs.getInt("count(booking_id)");
        }
 
        return total;
    }    
      
          //query all booking
           public static List<booking> queryBooking(Connection conn) throws SQLException {
        
         String sql = "Select booking_id, StartDate,EndDate,Status, book, purpose, staffno, starttime, endtime from booking where status=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,"pending");
        ResultSet rs = pstm.executeQuery();
        List<booking> list = new ArrayList<booking>();
        while (rs.next()) {
            booking product = new booking();
           product.setBook(rs.getString("book"));
           product.setBooking_id(rs.getInt("booking_id"));
           product.setEndDate(rs.getString("EndDate"));
           product.setPurpose(rs.getString("purpose"));
           product.setStaffNo(rs.getInt("staffno"));
           product.setStartDate(rs.getString("StartDate"));
           product.setStatus(rs.getString("Status"));
           product.setEndtime(rs.getString("endtime"));
           product.setStarttime(rs.getString("starttime"));
           
            list.add(product);
        }
        return list;
    }
          
           //query all booking for admin
             public static List<booking> queryallbooking(Connection conn) throws SQLException {
        
         String sql = "Select booking_id, StartDate,EndDate,Status, book, purpose, staffno, starttime, endtime from booking";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<booking> list = new ArrayList<booking>();
        while (rs.next()) {
            booking product = new booking();
           product.setBook(rs.getString("book"));
           product.setBooking_id(rs.getInt("booking_id"));
           product.setEndDate(rs.getString("EndDate"));
           product.setPurpose(rs.getString("purpose"));
           product.setStaffNo(rs.getInt("staffno"));
           product.setStartDate(rs.getString("StartDate"));
           product.setStatus(rs.getString("Status"));
           product.setEndtime(rs.getString("endtime"));
           product.setStarttime(rs.getString("starttime"));
           
            list.add(product);
        }
        return list;
    }
           
           //query all resources
           public static List<room> queryResources(Connection conn) throws SQLException {
        
         String sql = "Select room_id, room_type,room_name,capacity,facilities,pic from room";
        PreparedStatement pstm = conn.prepareStatement(sql);
       
        ResultSet rs = pstm.executeQuery();
        List<room> list = new ArrayList<room>();
        while (rs.next()) {
      
             int room_id=Integer.parseInt(rs.getString("room_id"));
             String room_type = rs.getString("room_type");
             String room_name=rs.getString("room_name");
             String capacity=rs.getString("capacity");
             String facilities=rs.getString("facilities");
             String pic=rs.getString("pic");
             
             room R= new room();
             R.setRoomId(room_id);
             R.setRoomType(room_type);
             R.setRoomName(room_name);
             R.setCapacity(capacity);
             R.setFacility(facilities);
             R.setPic(pic);
             list.add(R);            
        }
        return list;
    }
                //query all technician
           public static List<technician> queryTechnician(Connection conn) throws SQLException {
        
         String sql = "Select tech_id,tech_name,tech_no from technician";
        PreparedStatement pstm = conn.prepareStatement(sql);
       
        ResultSet rs = pstm.executeQuery();
        List<technician> list_tech = new ArrayList<technician>();
        while (rs.next()) {
      
             int tech_id=Integer.parseInt(rs.getString("tech_id"));
            
             String tech_name=rs.getString("tech_name");
             int tech_no=Integer.parseInt(rs.getString("tech_no"));
             technician T= new technician();
             T.setTechid(tech_id);
             T.setName(tech_name);
             T.setTechno(tech_no);
   
             list_tech.add(T);            
        }
        return list_tech;
    }
              //query all 1 booking
           public static List<booking> queryBookingall(Connection conn) throws SQLException {
        
         String sql = "Select booking_id, StartDate,EndDate,Status, book, purpose, staffno, starttime, endtime from booking where status=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,"pending");
        ResultSet rs = pstm.executeQuery();
        List<booking> list = new ArrayList<booking>();
        while (rs.next()) {
            booking product = new booking();
           product.setBook(rs.getString("book"));
           product.setBooking_id(rs.getInt("booking_id"));
           product.setEndDate(rs.getString("EndDate"));
           product.setPurpose(rs.getString("purpose"));
           product.setStaffNo(rs.getInt("staffno"));
           product.setStartDate(rs.getString("StartDate"));
           product.setStatus(rs.getString("Status"));
           product.setEndtime(rs.getString("endtime"));
           product.setStarttime(rs.getString("starttime"));
           
            list.add(product);
        }
        return list;
    }
           
    //dummy
    public static List<lecturer> queryuser(Connection conn) throws SQLException {
         String sql = "Select staffNo,name,phonenumber,email,username,IcNumber from lecturer";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<lecturer> list = new ArrayList<lecturer>();
        while (rs.next()) {
            int staffno = rs.getInt("staffNo");
            String name = rs.getString("name");
            int phonenumber=rs.getInt("phonenumber");
            String email=rs.getString("email");
            String username=rs.getString("username");
            String ic=rs.getString("IcNumber");
            lecturer product = new lecturer();
            product.setEmail(email);
            product.setName(name);
            product.setIcnumber(ic);
            product.setPhoneNumber(phonenumber);
            product.setUsername(username);
           
            list.add(product);
        }
        return list;
    }
 
    public static Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String name = rs.getString("Name");
            float price = rs.getFloat("Price");
            Product product = new Product(code, name, price);
            return product;
        }
        return null;
    }
    
      public static room findRoom(Connection conn, int roomId) throws SQLException {
        String sql = "Select room_id, room_type, room_name, capacity, facilities, piv from room a where room_id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, roomId);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            
            String type = rs.getString("room_type");
            String name = rs.getString("room_name");
            String capacity = rs.getString("capacity");
            String facility = rs.getString("facilities");
            String pic = rs.getString("pic");
            room room1 = new room(roomId, type, name, capacity, facility, pic);
            return room1;
        }
        return null;
    }
    //findBooking
     public static booking findBooking(Connection conn, int code) throws SQLException {
        String sql = "Select StartDate,EndDate,Status, book, purpose, staffno, starttime, endtime from booking where booking_id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, code);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
           String book=rs.getString("book");
           int id=code;
          String ed= rs.getString("EndDate");
          String p=rs.getString("purpose");
          int sn= rs.getInt("staffno");
           String sd=rs.getString("StartDate");
           String s=rs.getString("Status");
           String et=rs.getString("endtime");
         String st= rs.getString("starttime");
         booking product = new booking (id, sd, ed,  s,  book,  p,  sn, st,et);
            return product;
        }
        return null;
    }
 
    public static void updateProduct(Connection conn, Product product) throws SQLException {
        String sql = "Update Product set Name =?, Price=? where Code=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setString(3, product.getCode());
        pstm.executeUpdate();
    }
    
    //update lect profile
        public static void updateLect(Connection conn,int staffno,String nama,String phonenumber,String username,String email,String position,String icnumber,String password) throws SQLException {
        String sql = "Update lecturer set phonenumber=?,email=?,username=? where staffNo=? ";
        int pnumber=Integer.parseInt(phonenumber);
        PreparedStatement pstm = conn.prepareStatement(sql);
      
        pstm.setInt(1, pnumber);
        pstm.setString(2,email);
        pstm.setString(3,username);
       
        pstm.setInt(4,staffno);
        
        pstm.executeUpdate();
    }
    
            
    //update sm profile
        public static void updateSM(Connection conn,int staffno,String nama,String phonenumber,String username,String email,String position,String icnumber,String password) throws SQLException {
        String sql = "Update spacemanager set phonenumber=?,email=?,username=? where staffno=? ";
        int pnumber=Integer.parseInt(phonenumber);
        PreparedStatement pstm = conn.prepareStatement(sql);
      
        pstm.setInt(1, pnumber);
        pstm.setString(2,email);
        pstm.setString(3,username);
       
        pstm.setInt(4,staffno);
        
        pstm.executeUpdate();
    }
    //update for booking
     public static void updateBooking(Connection conn, booking product) throws SQLException {
        String sql = "Update booking set StartDate=?,EndDate=?, book=?, purpose=?, staffno=?, starttime=?, endtime=? where booking_id=?";
     
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        
        pstm.setString(1, product.getStartDate());
        pstm.setString(2, product.getEndDate());
        pstm.setString(3, product.getBook());
        pstm.setString(4, product.getPurpose());
         pstm.setInt(5,product.getStaffNo());
          pstm.setString(6, product.getStarttime());
          pstm.setString(7, product.getEndtime());
            pstm.setInt(8, product.getBooking_id());

        pstm.executeUpdate();
    }
     
         //update approve booking
     public static void updatebooking(Connection conn, String id) throws SQLException {
        String sql = "Update booking set Status=? where booking_id=?";
            int bookId=Integer.parseInt(id);
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        
        pstm.setString(1,"approved");
        pstm.setInt(2,bookId);


        pstm.executeUpdate();
    }
     
          //update reject booking
     public static void updatebookingReject(Connection conn, String id) throws SQLException {
        String sql = "Update booking set Status=? where booking_id=?";
            int bookId=Integer.parseInt(id);
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        
        pstm.setString(1,"reject");
        pstm.setInt(2,bookId);


        pstm.executeUpdate();
    }
     
     public static void updateRoom(Connection conn, String id) throws SQLException {
        String sql = "Update room where room_id=?";
            int roomId=Integer.parseInt(id);
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, roomId);
        pstm.executeUpdate();
    }
    public static void insertProduct(Connection conn, Product product) throws SQLException {
        String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getCode());
        pstm.setString(2, product.getName());
        pstm.setFloat(3, product.getPrice());
 
        pstm.executeUpdate();
    }
    
        public static void insertBooking(Connection conn, booking product) throws SQLException {
        String sql = "Insert into booking(StartDate,EndDate,Status,book,purpose,staffno,starttime,endtime) values (?,?,?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getStartDate());
        pstm.setString(2, product.getEndDate());
        pstm.setString(3, product.getStatus());
        pstm.setString(4, product.getBook());
        pstm.setString(5, product.getPurpose());
        pstm.setInt(6, product.getStaffNo());
        pstm.setString(7, product.getStarttime());
        pstm.setString(8, product.getEndtime());
        
        
 
        pstm.executeUpdate();
    }
        
        //insert new room
        
         public static void insertnewresources(Connection conn, room rm) throws SQLException {
        String sql = "Insert into room( room_id, room_type,room_name,capacity,facilities,pic )values(?,?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,rm.getRoomId());
        pstm.setString(2,rm.getRoomType());
        pstm.setString(3,rm.getRoomName());
        pstm.setString(4,rm.getCapacity());
        pstm.setString(5,rm.getFacility());
        pstm.setString(6,rm.getPic());
 
        pstm.executeUpdate();
    }
         
            public static void insertnewtechnician(Connection conn, technician tch) throws SQLException {
        String sql = "Insert into technician( tech_id,tech_name,tech_no)values(?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,tch.getTechid());
        pstm.setString(2,tch.getName());
        pstm.setInt(3,tch.getTechno());
        pstm.executeUpdate();
    }
        
     public static void insertnewuser(Connection conn, UserAccount usr) throws SQLException {
        String sql = "insert into user(position,username,password) values (?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, usr.getPosition());
        pstm.setString(2,usr.getUserName());
        pstm.setString(3, usr.getPassword());
        pstm.executeUpdate();
        if(usr.getPosition().equals("lecturer"))
        {
        String sql1 = "insert into lecturer(staffNo,name,phonenumber,email,username,IcNumber) values (?,?,?,?,?,?)";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setInt(1,usr.getStaffNo());
        pstm1.setString(2, usr.getName());
        pstm1.setInt(3,usr.getPhoneNumber());
        pstm1.setString(4, usr.getEmail());
        pstm1.setString(5, usr.getUserName());
        pstm1.setString(6, usr.getIcnumber());
        pstm1.executeUpdate();
        }
        else
        {
            String sql1 = "insert into spacemanager(name,phonenumber,email,username) values (?,?,?,?)";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, usr.getName());
        pstm1.setInt(2,usr.getPhoneNumber());
        pstm1.setString(3, usr.getEmail());
        pstm1.setString(4, usr.getUserName());
        pstm1.executeUpdate();
        }
    }
 
    public static void deleteProduct(Connection conn, String code) throws SQLException {
        String sql = "Delete From Product where Code= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        pstm.executeUpdate();
    }
    
    public static void deleteRoom(Connection conn, String room_id) throws SQLException {
        String sql = "Delete From Room where rom_id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, room_id);
 
        pstm.executeUpdate();
    }
    
      public static void deleteBooking(Connection conn, String id) throws SQLException {
        String sql = "Delete From booking where booking_id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, id);
 
        pstm.executeUpdate();
    }
 
}
