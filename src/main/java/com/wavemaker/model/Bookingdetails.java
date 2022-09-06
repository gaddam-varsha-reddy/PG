package com.wavemaker.model;

import java.util.Objects;

public class Bookingdetails {
    String email;
    boolean isActive;
    int roomNo;
    int floorNo;
    int bedNo;
    int cost;

    public Bookingdetails() {
    }

    public Bookingdetails(String email, boolean isActive, int roomNo, int floorNo, int bedNo, int cost){
        this.email=email;
        this.isActive=isActive;
        this.roomNo=roomNo;
        this.floorNo=floorNo;
        this.bedNo=bedNo;
        this.cost=cost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getisActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public int getBedNo() {
        return bedNo;
    }

    public void setBedNo(int bedNo) {
        this.bedNo = bedNo;
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
        Bookingdetails that = (Bookingdetails) o;
        return isActive == that.isActive && roomNo == that.roomNo && floorNo == that.floorNo && bedNo == that.bedNo && cost == that.cost && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, isActive, roomNo, floorNo, bedNo, cost);
    }

    @Override
    public String toString() {
        return "Bookingdetails{" +
                "email='" + email + '\'' +
                ", isActive=" + isActive +
                ", roomNo=" + roomNo +
                ", floorNo=" + floorNo +
                ", bedNo=" + bedNo +
                ", cost=" + cost +
                '}';
    }
}
