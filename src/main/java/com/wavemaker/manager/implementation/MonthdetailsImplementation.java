package com.wavemaker.manager.implementation;

import com.wavemaker.Connection.MySQLConnectionUtility;
import com.wavemaker.manager.MonthdetailsManager;
import com.wavemaker.model.MonthDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonthdetailsImplementation implements MonthdetailsManager {
    @Override
    public int searchMonthId(String month,int year){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "SELECT Id FROM MonthDetails where month=? and year=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, month);
            ps.setInt(2,year);
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
    public void addMonth(String month,int year){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into MonthDetails(month,year) values(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, month);
            ps.setInt(2, year);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in adding booking");
        }
    }
    @Override
    public List<MonthDetails> displayMonthDetails(){
        List<MonthDetails> monthList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MonthDetails");
            while (resultSet.next()) {
                int id=resultSet.getInt("Id");
                String month = resultSet.getString("month");
                int year = resultSet.getInt("year");
                monthList.add(new MonthDetails(id,month,year));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying user");
        }
        return monthList;
    }
}
