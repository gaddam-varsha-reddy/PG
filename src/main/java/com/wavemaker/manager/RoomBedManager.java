package com.wavemaker.manager;

import com.wavemaker.model.RoomBed;

import java.util.List;

public interface RoomBedManager {
    List<RoomBed> displayAllVaccantRooms();
    List<RoomBed> displayAllRooms();
}
