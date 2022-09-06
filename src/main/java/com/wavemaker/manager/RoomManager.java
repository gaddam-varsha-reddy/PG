package com.wavemaker.manager;

import com.wavemaker.model.Room;

import java.util.List;

public interface RoomManager {
    void addRoom(Room room);
    List<Room> displayOnlyRoom();
    int roomCount();
}
