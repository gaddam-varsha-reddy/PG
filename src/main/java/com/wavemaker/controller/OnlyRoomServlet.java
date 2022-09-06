package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.RoomBedManager;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.manager.implementation.RoomBedOperations;
import com.wavemaker.manager.implementation.RoomOperations;
import com.wavemaker.model.Room;
import com.wavemaker.model.RoomBed;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OnlyRoomServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    RoomManager roomManager=new RoomOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Room> room = roomManager.displayOnlyRoom();
        System.out.println(room.toString());
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(room));

    }
}
