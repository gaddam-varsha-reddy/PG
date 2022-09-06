package com.wavemaker.model;

import java.util.Objects;

public class MonthDetails {
    int id;
    String month;
    int year;

    public MonthDetails() {
    }

    public MonthDetails(int id, String month, int year){
        this.id=id;
        this.month=month;
        this.year=year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        MonthDetails that = (MonthDetails) o;
        return id == that.id && year == that.year && Objects.equals(month, that.month);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, month, year);
    }

    @Override
    public String toString() {
        return "MonthDetails{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", year=" + year +
                '}';
    }
}
