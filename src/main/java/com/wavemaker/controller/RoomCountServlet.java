package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.BedManager;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.manager.implementation.BedOperations;
import com.wavemaker.manager.implementation.RoomOperations;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoomCountServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    RoomManager roomManager= new RoomOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int count = roomManager.roomCount();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(count));
    }
}
