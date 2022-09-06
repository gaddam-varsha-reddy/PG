package com.wavemaker.manager;

import com.wavemaker.model.MonthDetails;

import java.util.List;

public interface MonthdetailsManager {
    int searchMonthId(String month,int year);
    void addMonth(String month,int year);
    List<MonthDetails> displayMonthDetails();
}
