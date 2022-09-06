package com.wavemaker.manager;

public interface BedManager {
    void addBed(int roomId,int totalBeds);
    void updateBedStatusOccupied(int id);
    void updateBedStatusVaccant(int id);
    int searchBedId(int roomNo,int floorNo,int bedNo);
    int bedCount();
}
