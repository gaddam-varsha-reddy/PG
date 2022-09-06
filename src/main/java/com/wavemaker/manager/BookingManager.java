package com.wavemaker.manager;

import com.wavemaker.model.Bookingdetails;

import java.util.List;

public interface BookingManager {
     void addBooking(int userId,int bedId);
     List<Bookingdetails> displayBooking();
     void updateBookingStatusVaccant(int userid,int bedid);
     int searchBookingId(int userid,int bedid);
     int activeBookingCount();
     int inActiveBookingCount();

}
