package com.wavemaker.model;

import java.util.Objects;

public class Userdetails {
    int id;
    String firstName;
    String lastName;
    String mobileNo;
    String email;
    String dob;
    boolean isActive;

    public Userdetails() {
    }

    public Userdetails(int id, String firstName, String lastName, String mobileNo, String email, String dob, boolean isActive){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.mobileNo=mobileNo;
        this.email=email;
        this.dob=dob;
        this.isActive=isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean getisActive() {
        return isActive;
    }

    public void setisActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Userdetails that = (Userdetails) o;
        return id == that.id && isActive == that.isActive && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(mobileNo, that.mobileNo) && Objects.equals(email, that.email) && Objects.equals(dob, that.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, mobileNo, email, dob, isActive);
    }

    @Override
    public String toString() {
        return "Userdetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
