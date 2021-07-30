package com.CS5500.springbootinfrastructure.controller;

import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.dao.Type;
import com.CS5500.springbootinfrastructure.repos.DateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class WebpageController {

    @Autowired
    private DateLogRepository dateRepo;

    @GetMapping(path="/records")
    public String fetchHomePage(Model model) {
        List<DateLog> logs = dateRepo.getJSONDates();
        model.addAttribute("allDates", logs);
        return "homepage";
    }

    @GetMapping(path = "/records/types")
    public String fetchTypes(Model model) {
        List<Type> types = dateRepo.getJSONTypes();
        model.addAttribute("allTypes", types);
        return "types";
    }

    @GetMapping(path = "/records/{date}/types")
    public String fetchTypeById(@PathVariable("date") Date date, Model model) {
        Optional optionalDL = dateRepo.findById(date);
        if (optionalDL.isPresent()) {
            DateLog dateLog = (DateLog) optionalDL.get();
            List<Type> types = dateLog.getTypes();
            model.addAttribute("typesForDate", types);

            return "typesid";
        }

        return "typeserror";
    }
}
