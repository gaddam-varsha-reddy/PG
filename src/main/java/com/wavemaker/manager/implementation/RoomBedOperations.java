package com.wavemaker.manager.implementation;

import com.wavemaker.Connection.MySQLConnectionUtility;
import com.wavemaker.manager.RoomBedManager;
import com.wavemaker.model.RoomBed;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomBedOperations implements RoomBedManager {
    @Override
    public List<RoomBed> displayAllVaccantRooms(){
        List<RoomBed> roomBedList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select  Room.Room_No,Room.Floor_No,Room.Total_Beds,Bed.id, Bed.Bed_No,Bed.isfull,Bed.cost from Room inner join Bed on Room.Id=Bed.Room_Id where isfull=false;");
            while (resultSet.next()) {
                int roomno = resultSet.getInt("Room_No");
                int floorno = resultSet.getInt("Floor_No");
                int totalbeds=resultSet.getInt("Total_Beds");
                int bedId = resultSet.getInt("id");
                int bedno = resultSet.getInt("Bed_No");
                boolean isfull = resultSet.getBoolean("isfull");
                int cost=resultSet.getInt("cost");
                roomBedList.add(new RoomBed(bedId,roomno,floorno,totalbeds, bedno,isfull,cost));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying all rooms");
        }
        return roomBedList;
    }
    @Override
    public List<RoomBed> displayAllRooms(){
        List<RoomBed> roomBedList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select Room.Room_No,Room.Floor_No,Room.Total_Beds,Bed.id , Bed.Bed_No,Bed.isfull,Bed.cost from Room inner join Bed on Room.Id=Bed.Room_Id;");
            while (resultSet.next()) {
                int roomno = resultSet.getInt("Room_No");
                int floorno = resultSet.getInt("Floor_No");
                int totalbeds=resultSet.getInt("Total_Beds");
                int bedId = resultSet.getInt("id");
                int bedno = resultSet.getInt("Bed_No");
                boolean isfull = resultSet.getBoolean("isfull");
                int cost=resultSet.getInt("cost");
                roomBedList.add(new RoomBed(bedId,roomno,floorno,totalbeds,bedno,isfull,cost));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying all rooms");
        }
        return roomBedList;
    }
}
