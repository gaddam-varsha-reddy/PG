package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.manager.implementation.RoomOperations;
import com.wavemaker.manager.implementation.paymentOperations;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaymentCountServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    com.wavemaker.manager.paymentManager paymentManager=new paymentOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int count = paymentManager.paymentCount();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(count));
    }
}
