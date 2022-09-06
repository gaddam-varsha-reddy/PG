package com.wavemaker.manager.implementation;

import com.wavemaker.Connection.MySQLConnectionUtility;
import com.wavemaker.manager.UserdetailsManager;
import com.wavemaker.model.Userdetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserdetailsOperations implements UserdetailsManager {
    @Override
    public List<Userdetails> displayUsers(){
        List<Userdetails> userdetailsList = new ArrayList<>();
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()) {
                int Id = resultSet.getInt("ID");
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String mobileNo = resultSet.getString("Mobile_No");
                String email= resultSet.getString("Email");
                String dob = resultSet.getString("dob");
                Boolean isactive=resultSet.getBoolean("is_active");
                userdetailsList.add(new Userdetails(Id,firstName,lastName,mobileNo,email,dob,isactive));
            }
        } catch (SQLException e) {
            System.out.println("Exception found in displaying user");
        }
        return userdetailsList;
    }
    @Override
    public void addUser(Userdetails userdetails){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "insert into User(First_Name,Last_Name,Mobile_No,Email,dob,is_active) values(?,?,?,?,?,1)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userdetails.getFirstName());
            ps.setString(2, userdetails.getLastName());
            ps.setString(3, userdetails.getMobileNo());
            ps.setString(4, userdetails.getEmail());
            ps.setString(5, userdetails.getDob());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in adding userdetails");
        }
    }
    @Override
    public void updateUserStatusVaccant(int id){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "update User set is_active=0 where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Exception found in updating status of user");
        }
    }
    @Override
    public int searchUserId(String email){
        Connection connection = MySQLConnectionUtility.getConnection();
        String sql = "SELECT Id FROM User where email=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
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
    public int activeUserCount(){
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from User where is_active=true;");
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
    public int inActiveUserCount(){
        Connection connection = MySQLConnectionUtility.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(*) from User where is_active=false;");
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
