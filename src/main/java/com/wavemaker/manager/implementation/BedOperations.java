package com.wavemaker.manager.implementation;

import com.wavemaker.Connection.MySQLConnectionUtility;
import com.wavemaker.manager.BedManager;

import java.sql.*;

public class BedOperations implements BedManager {
    @Override
    public void addBed(int roomId,int totalBeds){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into Bed(Bed_No,Room_Id,isfull,cost) values(?,?,false,?)";
        try {
            int cost=10000;
            if(totalBeds==2){
                cost=9000;
            }
            else if(totalBeds==3){
                cost=8000;
            }
            for(int i=1;i<=totalBeds;i++) {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, i);
                ps.setInt(2, roomId);
                ps.setInt(3,cost);
                ps.execute();
            }

        }
        catch (SQLException e) {
            System.out.println("Exception found in adding bed");
        }
    }
    @Override
    public void updateBedStatusOccupied(int id){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "update Bed set isfull=true where Id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in updating status");
        }
    }
    @Override
    public void updateBedStatusVaccant(int id){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "update Bed set isfull=false where Id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in updating status");
        }
    }
    @Override
    public int searchBedId(int roomNo,int floorNo,int bedNo){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "select Id from Room where Room_No=? and Floor_No=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, roomNo);
            statement.setInt(2, floorNo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                sql = "SELECT Id FROM Bed where Room_Id=? and Bed_No=?";
                try {
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.setInt(2, bedNo);
                    resultSet = ps.executeQuery();
                    while (resultSet.next()) {
                        id = resultSet.getInt("ID");
                        return id;
                    }
                }
                catch (Exception e) {
                    System.out.println("Exception found in searching bed id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception found in searching room id");
        }
        return -1;
    }
    @Override
    public int bedCount(){
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from Bed;");
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
