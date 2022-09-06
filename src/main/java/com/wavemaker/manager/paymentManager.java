package com.wavemaker.manager;

import com.wavemaker.model.Paymentdetails;

import java.util.List;

public interface paymentManager {
    void addPayment(int bedId,int monthId);
    List<Paymentdetails> displayPaymentDetails();
    int paymentCount();
}
