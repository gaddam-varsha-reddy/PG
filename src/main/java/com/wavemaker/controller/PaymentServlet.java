package com.wavemaker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavemaker.manager.implementation.paymentOperations;
import com.wavemaker.model.Paymentdetails;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PaymentServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    com.wavemaker.manager.paymentManager paymentManager=new paymentOperations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Paymentdetails> paymentlist = paymentManager.displayPaymentDetails();
        response.getWriter().write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(paymentlist));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        paymentManager.addPayment(Integer.parseInt(request.getParameter("bedId")),Integer.parseInt(request.getParameter("monthId")));
    }
}
