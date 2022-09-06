package com.wavemaker.manager;

import com.wavemaker.model.Userdetails;

import java.util.List;

public interface UserdetailsManager {
    List<Userdetails> displayUsers();
    void addUser(Userdetails userdetails);
    void updateUserStatusVaccant(int id);
    int searchUserId(String email);
    int activeUserCount();
    int inActiveUserCount();
}
