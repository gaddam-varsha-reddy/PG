package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.UserdetailsManager;
import com.wavemaker.manager.implementation.UserdetailsOperations;
import com.wavemaker.model.Userdetails;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    UserdetailsManager userdetailsManager =new UserdetailsOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Userdetails> userdetailsList = userdetailsManager.displayUsers();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userdetailsList));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Userdetails userdetails = objectMapper.readValue(request.getReader(), Userdetails.class);
        userdetailsManager.addUser(userdetails);
    }
}
