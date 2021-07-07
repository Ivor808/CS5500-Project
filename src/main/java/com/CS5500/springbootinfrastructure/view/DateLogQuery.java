package com.CS5500.springbootinfrastructure.view;

import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.repos.DateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class DateLogQuery {
    @Autowired
    public static DateLogRepository dateLogRepository;

    public static void main(String[] args) {


        ArrayList<DateLog> dates = (ArrayList<DateLog>) dateLogRepository.findAll();
        for (DateLog date : dates) {
            System.out.println(date.getDate());
        }
    }
}
