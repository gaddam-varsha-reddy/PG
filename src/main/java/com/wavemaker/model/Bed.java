package com.wavemaker.model;

import java.util.Objects;

public class Bed {
    int id;
    int roomId;
    int bedNo;
    boolean isFull;
    int cost;

    public Bed() {
    }

    public Bed(int id, int roomId, int bedNo, boolean isFull, int cost){
        this.id=id;
        this.roomId=roomId;
        this.bedNo=bedNo;
        this.isFull=isFull;
        this.cost=cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
        Bed bed = (Bed) o;
        return id == bed.id && roomId == bed.roomId && bedNo == bed.bedNo && isFull == bed.isFull && cost == bed.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomId, bedNo, isFull, cost);
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", bedNo=" + bedNo +
                ", isFull=" + isFull +
                ", cost=" + cost +
                '}';
    }
}
