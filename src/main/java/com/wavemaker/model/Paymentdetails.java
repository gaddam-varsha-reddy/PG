package com.wavemaker.model;

import java.util.Objects;

public class Paymentdetails {
    int roomNo;
    int floorNo;
    int bedNo;
    String month;
    int year;

    public Paymentdetails() {
    }

    public Paymentdetails(int roomNo, int floorNo, int bedNo, String month, int year){
        this.roomNo=roomNo;
        this.floorNo=floorNo;
        this.bedNo=bedNo;
        this.month=month;
        this.year=year;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paymentdetails that = (Paymentdetails) o;
        return roomNo == that.roomNo && floorNo == that.floorNo && bedNo == that.bedNo && year == that.year && Objects.equals(month, that.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNo, floorNo, bedNo, month, year);
    }

    @Override
    public String toString() {
        return "Paymentdetails{" +
                "roomNo=" + roomNo +
                ", floorNo=" + floorNo +
                ", bedNo=" + bedNo +
                ", month='" + month + '\'' +
                ", year=" + year +
                '}';
    }
}
