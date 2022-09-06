package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.MonthdetailsManager;
import com.wavemaker.manager.implementation.MonthdetailsImplementation;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MonthServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    MonthdetailsManager monthDetailsManager=new MonthdetailsImplementation();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String month=request.getParameter("month");
        int year=Integer.parseInt(request.getParameter("year"));
        int id=monthDetailsManager.searchMonthId(month,year);
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(id));
    }
}
