package com.CS5500.springbootinfrastructure.view;

import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.formatter.DataFormatterImpl;
import com.CS5500.springbootinfrastructure.repos.DateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DateLogQuery {

    public static void main(String[] args) {


        Timestamp t = new DataFormatterImpl().convertTimestamp("20130209T185023-0800");
        System.out.println(t.toString());
    }
}
