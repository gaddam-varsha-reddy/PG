package com.wavemaker.manager.implementation;

import com.wavemaker.Connection.MySQLConnectionUtility;
import com.wavemaker.manager.BookingManager;
import com.wavemaker.model.Bookingdetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingOperations implements BookingManager {
    @Override
    public void addBooking(int userId,int bedId){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into Booking(User_Id,Bed_Id,is_active) values(?,?,1)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, bedId);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in adding booking");
        }
    }
    @Override
    public List<Bookingdetails> displayBooking(){
        List<Bookingdetails> bookingList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT U.EMAIL,R.ROOM_NO,R.FLOOR_NO,B1.BED_NO ,B1.COST,B.IS_ACTIVE FROM USER U JOIN BOOkING B ON U.ID = B.User_Id JOIN BED B1 ON B.Bed_ID = B1.ID JOIN ROOM R ON B1.Room_ID = R.ID;");
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                boolean isactive = resultSet.getBoolean("is_active");
                int roomNo = resultSet.getInt("room_no");
                int floorNo = resultSet.getInt("floor_no");
                int bedNo = resultSet.getInt("bed_no");
                int cost = resultSet.getInt("cost");
                bookingList.add(new Bookingdetails(email,isactive,roomNo,floorNo,bedNo,cost));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying bookings");
        }
        return bookingList;
    }
    @Override
    public void updateBookingStatusVaccant(int userid,int bedid){
        Connection connection = MySQLConnectionUtility.getConnection();
       String sql = "update Booking set is_active=false where user_id=? and Bed_Id=? and is_active=true";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setInt(2,bedid);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in updating status");
        }
    }
    @Override
    public int searchBookingId(int userid,int bedid){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "SELECT Id FROM Booking where user_id=? and Bed_Id=? and is_active=true";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setInt(2,bedid);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                return id;
            }
        }
        catch (Exception e) {
            System.out.println("Exception found in searching user id");
        }
        return -1;
    }
    @Override
    public int activeBookingCount(){
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from booking where is_active=true;");
            while (resultSet.next()) {
                int Id = resultSet.getInt("count(*)");
                return Id;
            }
        }
        catch(Exception e){
            System.out.println("Exception");
        }
        return -1;
    }
    @Override
    public int inActiveBookingCount(){
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from booking where is_active=false;");
            while (resultSet.next()) {
                int Id = resultSet.getInt("count(*)");
                return Id;
            }
        }
        catch(Exception e){
            System.out.println("Exception");
        }
        return -1;
    }
}
