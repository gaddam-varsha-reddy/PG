package com.wavemaker.model;

import java.util.Objects;

public class RoomBed {
    int bedId;
    int roomNo;
    int floorNo;
    int totalBeds;
    int bedNo;
    boolean isFull;
    int cost;

    public RoomBed(int bedId, int roomNo, int floorNo, int totalBeds, int bedNo, boolean isFull, int cost) {
        this.bedId = bedId;
        this.roomNo = roomNo;
        this.floorNo = floorNo;
        this.totalBeds = totalBeds;
        this.bedNo = bedNo;
        this.isFull = isFull;
        this.cost = cost;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(int totalBeds) {
        this.totalBeds = totalBeds;
    }

    public int getBedNo() {
        return bedNo;
    }

    public void setBedNo(int bedNo) {
        this.bedNo = bedNo;
    }

    public boolean getisFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomBed roomBed = (RoomBed) o;
        return bedId == roomBed.bedId && roomNo == roomBed.roomNo && floorNo == roomBed.floorNo && totalBeds == roomBed.totalBeds && bedNo == roomBed.bedNo && isFull == roomBed.isFull && cost == roomBed.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bedId, roomNo, floorNo, totalBeds, bedNo, isFull, cost);
    }

    @Override
    public String toString() {
        return "RoomBed{" +
                "bedId=" + bedId +
                ", roomNo=" + roomNo +
                ", floorNo=" + floorNo +
                ", totalBeds=" + totalBeds +
                ", bedNo=" + bedNo +
                ", isFull=" + isFull +
                ", cost=" + cost +
                '}';
    }
}
