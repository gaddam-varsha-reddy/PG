package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.UserdetailsManager;
import com.wavemaker.manager.implementation.UserdetailsOperations;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InActiveUserCountServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    UserdetailsManager userdetailsManager=new UserdetailsOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int count = userdetailsManager.inActiveUserCount();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(count));
    }
}
