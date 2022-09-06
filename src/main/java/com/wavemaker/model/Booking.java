package com.wavemaker.model;

import java.util.Objects;

public class Booking {
    int id;
    int userId;
    int bedId;
    boolean isActive;

    public Booking() {
    }

    public Booking(int id, int userId, int bedId, boolean isActive) {
        this.id = id;
        this.userId = userId;
        this.bedId = bedId;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public boolean getisActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && userId == booking.userId && bedId == booking.bedId && isActive == booking.isActive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, bedId, isActive);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", userId=" + userId +
                ", bedId=" + bedId +
                ", isActive=" + isActive +
                '}';
    }
}
