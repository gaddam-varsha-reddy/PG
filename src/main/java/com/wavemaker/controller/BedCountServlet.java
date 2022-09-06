package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.BedManager;
import com.wavemaker.manager.UserdetailsManager;
import com.wavemaker.manager.implementation.BedOperations;
import com.wavemaker.manager.implementation.UserdetailsOperations;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BedCountServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    BedManager bedManager= new BedOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int count = bedManager.bedCount();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(count));
    }
}
