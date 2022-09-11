package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.BookingManager;
import com.wavemaker.manager.UserdetailsManager;
import com.wavemaker.manager.implementation.BookingOperations;
import com.wavemaker.manager.implementation.UserdetailsOperations;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class searchBookingServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    BookingManager bookingManager=new BookingOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userid=Integer.parseInt(request.getParameter("userId"));
        int bedid=Integer.parseInt(request.getParameter("bedId"));
        int id=bookingManager.searchBookingId(userid,bedid);
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(id));
    }
}
