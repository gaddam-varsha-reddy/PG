package com.wavemaker.manager.implementation;

import com.wavemaker.Connection.MySQLConnectionUtility;
import com.wavemaker.manager.paymentManager;
import com.wavemaker.model.Paymentdetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class paymentOperations implements paymentManager {
    @Override
    public void addPayment(int bedId,int monthId){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into Payment(bed_Id,month_Id) values(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, bedId);
            ps.setInt(2, monthId);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in adding payment");
        }
    }
    @Override
    public List<Paymentdetails> displayPaymentDetails(){
        List<Paymentdetails> paymentList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT R.ROOM_NO,R.FLOOR_NO,B.BED_NO,M.MONTH,M.YEAR FROM ROOM R JOIN BED B ON R.ID = B.Room_ID JOIN PAYMENT P ON B.ID = P.Bed_ID JOIN MONTHDETAILS M ON P.Month_ID = M.ID;");
            while (resultSet.next()) {
                int roomNo = resultSet.getInt("room_no");
                int floorNo = resultSet.getInt("floor_no");
                int bedNo = resultSet.getInt("bed_no");
                String month = resultSet.getString("Month");
                int year= resultSet.getInt("year");
                paymentList.add(new Paymentdetails(roomNo,floorNo,bedNo,month,year));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying user");
        }
        return paymentList;
    }
    @Override
    public int paymentCount(){
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from Payment;");
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
