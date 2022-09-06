package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.BookingManager;
import com.wavemaker.manager.implementation.BookingOperations;
import com.wavemaker.model.Bookingdetails;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookingServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    BookingManager bookingManager=new BookingOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Bookingdetails> bookingList = bookingManager.displayBooking();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingList));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        bookingManager.addBooking(Integer.parseInt(request.getParameter("userId")),Integer.parseInt(request.getParameter("bedId")));
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId=Integer.parseInt(request.getParameter("userId"));
        int bedId=Integer.parseInt(request.getParameter("bedId"));
        bookingManager.updateBookingStatusVaccant(userId,bedId);
    }
}
