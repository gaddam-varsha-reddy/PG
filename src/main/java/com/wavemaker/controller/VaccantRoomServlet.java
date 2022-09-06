package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.RoomBedManager;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.manager.implementation.RoomBedOperations;
import com.wavemaker.manager.implementation.RoomOperations;
import com.wavemaker.model.RoomBed;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class VaccantRoomServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    RoomBedManager roomBedManager=new RoomBedOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<RoomBed> roombed = roomBedManager.displayAllVaccantRooms();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(roombed));
    }

}
