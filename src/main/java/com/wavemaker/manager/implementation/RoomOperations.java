package com.wavemaker.manager.implementation;

import com.wavemaker.Connection.MySQLConnectionUtility;
import com.wavemaker.manager.BedManager;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.model.Room;
import com.wavemaker.model.Userdetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomOperations implements RoomManager {
    @Override
    public void addRoom(Room room) {
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into Room(Room_No,Floor_No,Total_Beds) values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, room.getRoomNo());
            ps.setInt(2, room.getFloorNo());
            ps.setInt(3, room.getTotalBeds());
            ps.execute();
            sql = "SELECT Id,Total_Beds FROM Room where Room_No=? and Floor_No=?";
            try {
                ps = connection.prepareStatement(sql);
                ps.setInt(1, room.getRoomNo());
                ps.setInt(2, room.getFloorNo());
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    int totalBeds = resultSet.getInt("Total_Beds");
                    BedManager bedManager = new BedOperations();
                    bedManager.addBed(id, totalBeds);
                }
            }
            catch (Exception e) {
                System.out.println("Exception found in adding bed in room");
            }

        }catch (SQLException e) {
            System.out.println("Exception found in adding room");
        }
    }
    @Override
    public List<Room> displayOnlyRoom(){
        List<Room> roomList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Room");
            while (resultSet.next()) {
                int Id = resultSet.getInt("ID");
                int roomno = resultSet.getInt("Room_No");
                int floorno = resultSet.getInt("Floor_No");
                int totalbeds= resultSet.getInt("Total_Beds");
                roomList.add(new Room(Id,roomno,floorno,totalbeds));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying user");
        }
        return roomList;
    }
    @Override
    public int roomCount(){
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from Room;");
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
