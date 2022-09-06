package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.RoomBedManager;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.manager.implementation.RoomBedOperations;
import com.wavemaker.manager.implementation.RoomOperations;
import com.wavemaker.model.Room;
import com.wavemaker.model.RoomBed;
import org.w3c.dom.ls.LSOutput;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class RoomServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    RoomManager roomManager=new RoomOperations();
    RoomBedManager roomBedManager=new RoomBedOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<RoomBed> roombed = roomBedManager.displayAllRooms();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(roombed));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(request.getReader().toString());
        Room room = objectMapper.readValue(request.getReader(), Room.class);
      //  System.out.println(room);
        roomManager.addRoom(room);
    }
}
